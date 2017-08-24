package com.arm.mbed.cloud.sdk.common;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Date;

import com.arm.mbed.cloud.sdk.annotations.Internal;
import com.arm.mbed.cloud.sdk.annotations.Preamble;
import com.arm.mbed.cloud.sdk.common.GenericAdapter.Mapper;
import com.google.gson.Gson;

import okhttp3.Headers;
import okhttp3.Request;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Response;

@Preamble(description = "Utility in charge of calling arm Mbed Cloud APIs")
@Internal
public class CloudCaller<T, U> {

    public static interface CloudCall<T> {
        Call<T> call();
    }

    private final CloudCall<T> caller;
    private final Mapper<T, U> mapper;
    private final SDKLogger logger;
    private final String apiName;
    private final boolean storeMetadata;
    private final AbstractAPI module;

    private CloudCaller(String apiName, CloudCall<T> caller, Mapper<T, U> mapper, AbstractAPI module,
            boolean storeMetada) {
        super();
        this.caller = caller;
        this.mapper = mapper;
        this.logger = module.logger;
        this.apiName = apiName;
        this.module = module;
        this.storeMetadata = storeMetada;
    }

    public static <T, U> U call(AbstractAPI module, String functionName, Mapper<T, U> mapper, CloudCall<T> caller)
            throws MbedCloudException {
        return call(module, functionName, mapper, caller, true);
    }

    public static <T, U> U call(AbstractAPI module, String functionName, Mapper<T, U> mapper, CloudCall<T> caller,
            boolean storeMetadata) throws MbedCloudException {
        return callWithFeedback(module, functionName, mapper, caller, storeMetadata).getResult();
    }

    public static <T, U> CallFeedback<U> callWithFeedback(AbstractAPI module, String functionName, Mapper<T, U> mapper,
            CloudCall<T> caller, boolean storeMetadata) throws MbedCloudException {
        return new CloudCaller<>(functionName, caller, mapper, module, storeMetadata).execute();
    }

    public CallFeedback<U> execute() throws MbedCloudException {
        try {
            logger.logInfo("Calling arm Mbed Cloud API: " + apiName);
            Response<T> response = caller.call().execute();
            CallFeedback<U> comms = new CallFeedback<>(logger);
            comms.setMetadataFromResponse(response);
            if (storeMetadata) {
                storeApiMetadata(comms.getMetadata());
            }
            checkResponse(response);
            comms.setResultFromResponse(mapper, response);
            return comms;
        } catch (Exception e) {
            logger.throwSDKException("An error occurred when calling SDK function [" + apiName + "]", e);
        }
        return null;
    }

    private void storeApiMetadata(ApiMetadata metadata) {
        module.metadataCache.storeMetadata(metadata);
    }

    private void checkResponse(Response<T> response) throws MbedCloudException {
        if (response == null) {
            logger.throwSDKException("An error occurred when calling Mbed Cloud: no response was received");
        }
        if (response != null && !response.isSuccessful()) {
            String errorMessage = null;
            Error error = null;
            try {
                error = ErrorJsonConverter.INSTANCE.convert(response.errorBody());
            } catch (Exception e) {
                try {
                    errorMessage = response.errorBody().string();
                } catch (IOException e1) {
                    // Nothing to do
                }
                // Nothing to do
            }
            logger.throwSDKException(
                    "An error occurred when calling Mbed Cloud: [" + response.code() + "] " + response.message(),
                    (error != null) ? new MbedCloudException(error.toString())
                            : (errorMessage == null) ? null : new MbedCloudException(errorMessage));
        }
    }

    private static class ErrorJsonConverter {
        private final Gson gson = new Gson();
        public static final ErrorJsonConverter INSTANCE = new ErrorJsonConverter();

        private Error convert(ResponseBody value) {
            if (value == null) {
                return null;
            }
            return gson.fromJson(value.charStream(), Error.class);

        }
    }

    public static class CallFeedback<U> {
        private final SDKLogger logger;
        ApiMetadata metadata;
        U result;

        public CallFeedback(SDKLogger logger) {
            super();
            this.logger = logger;
        }

        /**
         * @return the metadata
         */
        public ApiMetadata getMetadata() {
            return metadata;
        }

        /**
         * @return the result
         */
        public U getResult() {
            return result;
        }

        /**
         * @param metadata
         *            the metadata to set
         */
        public void setMetadata(ApiMetadata metadata) {
            this.metadata = metadata;
        }

        /**
         * @param result
         *            the result to set
         */
        public void setResult(U result) {
            this.result = result;
        }

        public <T> void setResultFromResponse(Mapper<T, U> mapper, Response<T> response) {
            setResult((mapper == null) ? null : mapper.map(response.body()));
        }

        public <T> void setMetadataFromResponse(Response<T> response) {
            setMetadata(retrieveMetadata(response));
        }

        private <T> ApiMetadata retrieveMetadata(Response<T> response) {
            if (response == null) {
                return null;
            }
            ApiMetadata callMetadata = new ApiMetadata();

            Request request = response.raw().request();
            if (request != null) {
                callMetadata.setMethod(request.method());
                callMetadata.setUrl(request.url().url());
            }

            callMetadata.setStatusCode(response.code());
            Headers headers = response.headers();
            if (headers != null) {
                callMetadata.setHeaders(headers.toMultimap());
                callMetadata.setRequestId(headers.get("x-request-id"));
                try {
                    callMetadata.setDateFromString(headers.get("date"));
                } catch (Exception e) {
                    logger.logError("Error occurred when trying to fetch server date from API metadata", e);
                    callMetadata.setDate(new Date());
                }
            }
            T body = response.body();
            if (body != null) {
                callMetadata.setObject(body.getClass());
                callMetadata.setEtag(fetchEtagField(body));
            }
            return callMetadata;
        }

        private <T> String fetchEtagField(T body) {
            try {
                Method getEtagMethod = body.getClass().getMethod("getEtag");
                if (getEtagMethod != null) {
                    Object etag = getEtagMethod.invoke(body);
                    return (etag == null) ? null : (etag instanceof String) ? (String) etag : etag.toString();
                }
            } catch (SecurityException | IllegalAccessException | IllegalArgumentException
                    | InvocationTargetException e) {
                logger.logError("Error occurred when trying to fetch etag from API metadata", e);
            } catch (NoSuchMethodException e) {
                return null;
            }
            return null;
        }
    }

}
