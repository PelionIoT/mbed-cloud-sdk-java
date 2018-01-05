package com.arm.mbed.cloud.sdk.common;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Date;

import com.arm.mbed.cloud.sdk.annotations.Internal;
import com.arm.mbed.cloud.sdk.annotations.Preamble;
import com.arm.mbed.cloud.sdk.common.GenericAdapter.Mapper;

import okhttp3.Headers;
import okhttp3.Request;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Response;

@Preamble(description = "Utility in charge of calling Arm Mbed Cloud APIs")
@Internal
public class CloudCaller<T, U> {

    private final CloudCall<T> caller;
    private final Mapper<T, U> mapper;
    private final SdkLogger logger;
    private final String apiName;
    private final boolean storeMetadata;
    private final AbstractApi module;

    /**
     * Defines a request to Arm Mbed Cloud.
     *
     * @param <T>
     *            type of response object.
     */
    public interface CloudCall<T> {
        Call<T> call();
    }

    private CloudCaller(String apiName, CloudCall<T> caller, Mapper<T, U> mapper, AbstractApi module,
            boolean storeMetada) {
        super();
        this.caller = caller;
        this.mapper = mapper;
        this.logger = module.logger;
        this.apiName = apiName;
        this.module = module;
        this.storeMetadata = storeMetada;
    }

    /**
     * Executes a call to Arm Mbed Cloud.
     * <p>
     * Note: call metadata are recorded
     * 
     * @param module
     *            API module
     * @param functionName
     *            API function name.
     * @param mapper
     *            object mapper
     * @param caller
     *            request
     * 
     * @param <T>
     *            type of HTTP response object.
     * @param <U>
     *            type of API response object.
     * @return request result
     * @throws MbedCloudException
     *             if an error occurred during the call
     */
    public static <T, U> U call(AbstractApi module, String functionName, Mapper<T, U> mapper, CloudCall<T> caller)
            throws MbedCloudException {
        return call(module, functionName, mapper, caller, true);
    }

    /**
     * Executes a call to Arm Mbed Cloud.
     * 
     * @param module
     *            API module
     * @param functionName
     *            API function name.
     * @param mapper
     *            object mapper
     * @param caller
     *            request
     * @param storeMetadata
     *            states whether metadata should be recorded
     * 
     * @param <T>
     *            type of HTTP response object.
     * @param <U>
     *            type of API response object.
     * @return request result
     * @throws MbedCloudException
     *             if an error occurred during the call
     */
    public static <T, U> U call(AbstractApi module, String functionName, Mapper<T, U> mapper, CloudCall<T> caller,
            boolean storeMetadata) throws MbedCloudException {
        return callWithFeedback(module, functionName, mapper, caller, storeMetadata).getResult();
    }

    /**
     * Executes a call to Arm Mbed Cloud.
     * 
     * @param module
     *            API module
     * @param functionName
     *            API function name.
     * @param mapper
     *            object mapper
     * @param <T>
     *            type of HTTP response object.
     * @param <U>
     *            type of API response object.
     * @param caller
     *            request
     * @param storeMetadata
     *            states whether metadata should be recorded
     * @return CallFeedback @see {@link CallFeedback}
     * @throws MbedCloudException
     *             if an error occurred during the call
     */
    public static <T, U> CallFeedback<U> callWithFeedback(AbstractApi module, String functionName, Mapper<T, U> mapper,
            CloudCall<T> caller, boolean storeMetadata) throws MbedCloudException {
        return new CloudCaller<>(functionName, caller, mapper, module, storeMetadata).execute();
    }

    /**
     * Stores API Metadata to the module.
     * 
     * @param module
     *            module.
     * @param metadata
     *            api metadata
     */
    public static void storeApiMetadata(AbstractApi module, ApiMetadata metadata) {
        new CloudCaller<>(null, null, null, module, true).storeApiMetadataInTheCache(metadata);
    }

    /**
     * Executes a call to Arm Mbed Cloud.
     * 
     * @return result objects of type U
     * @throws MbedCloudException
     *             if an error occurred during the call
     */
    public CallFeedback<U> execute() throws MbedCloudException {
        try {
            logger.logInfo("Calling Arm Mbed Cloud API: " + apiName);
            clearPreviousApiMetadata();
            final Response<T> response = caller.call().execute();
            final CallFeedback<U> comms = new CallFeedback<>(logger);
            comms.setMetadataFromResponse(response);
            if (storeMetadata) {
                storeApiMetadataInTheCache(comms.getMetadata());
            }
            checkResponse(response, comms);
            comms.setResultFromResponse(mapper, response);
            return comms;
        } catch (Exception exception) {
            logger.throwSdkException("An error occurred when calling SDK function [" + apiName + "]", exception);
        }
        return null;
    }

    /**
     * Stores API metadata.
     * 
     * @param metadata
     *            API metadata
     */
    public void storeApiMetadataInTheCache(ApiMetadata metadata) {
        module.metadataCache.storeMetadata(metadata);
    }

    private void clearPreviousApiMetadata() {
        module.metadataCache.clearMetadata();
    }

    private void checkResponse(Response<T> response, CallFeedback<U> comms) throws MbedCloudException {
        if (response == null) {
            logger.throwSdkException("An error occurred when calling Arm Mbed Cloud: no response was received");
        }
        if (response != null && !response.isSuccessful()) {
            Error error = retrieveErrorDetails(response);
            if (comms != null) {
                comms.setErrorMessage(error);
            }
            String errorMessage = retrieveErrorMessage(response);
            logger.throwSdkException(
                    "An error occurred when calling Arm Mbed Cloud: [" + response.code() + "] " + response.message(),
                    error == null ? errorMessage == null ? null : new MbedCloudException(errorMessage)
                            : new MbedCloudException(error.toPrettyString()));
        }
    }

    private String retrieveErrorMessage(Response<T> response) {
        String errorMessage = null;
        try {
            errorMessage = response.errorBody().string();
        } catch (IOException exception) {
            // Nothing to do
        }
        return errorMessage;
    }

    private Error retrieveErrorDetails(Response<T> response) {
        Error error = null;
        try {
            error = ErrorJsonConverter.INSTANCE.convert(response.errorBody());
        } catch (Exception exception) {
            // Nothing to do
        }
        if (error == null) {
            try {
                error = new Error(response.code(), "Mbed Cloud call", response.message(),
                        response.raw().request().url().toString());
            } catch (Exception exception) {
                // Nothing to do
            }
        }
        return error;
    }

    private static class ErrorJsonConverter {
        private final JsonSerialiser jsonSerialiser = new JsonSerialiser();
        public static final ErrorJsonConverter INSTANCE = new ErrorJsonConverter();

        private Error convert(ResponseBody value) {
            if (value == null) {
                return null;
            }
            return jsonSerialiser.fromJson(value.charStream(), Error.class);

        }
    }

    /**
     * 
     * Defines a call (Metadata + response) of a call to Arm Mbed Cloud.
     * 
     * @param <U>
     *            type of the result object
     */
    public static class CallFeedback<U> {
        private final SdkLogger logger;
        ApiMetadata metadata;
        U result;

        /**
         * Constructor.
         * 
         * @param logger
         *            logger
         */
        public CallFeedback(SdkLogger logger) {
            super();
            this.logger = logger;
        }

        /**
         * Gets call metadata.
         * 
         * @see ApiMetadata
         * @return the metadata
         */
        public ApiMetadata getMetadata() {
            return metadata;
        }

        /**
         * Gets call result.
         * 
         * @return the result
         */
        public U getResult() {
            return result;
        }

        /**
         * Sets call metadata.
         * 
         * @see ApiMetadata
         * @param metadata
         *            the metadata to set
         */
        public void setMetadata(ApiMetadata metadata) {
            this.metadata = metadata;
        }

        /**
         * Sets call result.
         * 
         * @param result
         *            the result to set
         */
        public void setResult(U result) {
            this.result = result;
        }

        /**
         * Sets result from an HTTP response.
         * 
         * @param mapper
         *            object mapper
         * @param <T>
         *            type of the result
         * @param response
         *            HTTP response
         */
        public <T> void setResultFromResponse(Mapper<T, U> mapper, Response<T> response) {
            setResult((mapper == null) ? null : mapper.map(response.body()));
        }

        /**
         * Sets metadata from an HTTP response.
         * 
         * @param <T>
         *            type of the result
         * @param response
         *            HTTP response
         */
        public <T> void setMetadataFromResponse(Response<T> response) {
            setMetadata(retrieveMetadata(response));
        }

        /**
         * Sets error message.
         * 
         * @param error
         *            error message @see Error
         */
        public void setErrorMessage(Error error) {
            if (metadata != null) {
                metadata.setErrorMessage(error);
            }
        }

        private <T> ApiMetadata retrieveMetadata(Response<T> response) {
            if (response == null) {
                return null;
            }
            final ApiMetadata callMetadata = new ApiMetadata();

            final Request request = response.raw().request();
            if (request != null) {
                callMetadata.setMethod(request.method());
                callMetadata.setUrl(request.url().url());
            }

            callMetadata.setStatusCode(response.code());
            final Headers headers = response.headers();
            if (headers != null) {
                callMetadata.setHeaders(headers.toMultimap());
                callMetadata.setRequestId(headers.get("x-request-id"));
                try {
                    callMetadata.setDateFromString(headers.get("date"));
                } catch (Exception exception) {
                    logger.logError("Error occurred when trying to fetch server date from API metadata", exception);
                    callMetadata.setDate(new Date());
                }
            }
            final T body = response.body();
            if (body != null) {
                callMetadata.setObject(body.getClass());
                callMetadata.setEtag(fetchEtagField(body));
            }
            return callMetadata;
        }

        private <T> String fetchEtagField(T body) {
            try {
                final Method getEtagMethod = body.getClass().getMethod("getEtag");
                if (getEtagMethod != null) {
                    final Object etag = getEtagMethod.invoke(body);
                    return (etag == null) ? null : (etag instanceof String) ? (String) etag : etag.toString();
                }
            } catch (SecurityException | IllegalAccessException | IllegalArgumentException
                    | InvocationTargetException exception) {
                logger.logError("Error occurred when trying to fetch etag from API metadata", exception);
            } catch (NoSuchMethodException exception) {
                return null;
            }
            return null;
        }
    }

}
