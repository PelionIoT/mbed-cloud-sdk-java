package com.arm.mbed.cloud.sdk.common;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.URL;
import java.util.Date;

import com.arm.mbed.cloud.sdk.annotations.Internal;
import com.arm.mbed.cloud.sdk.annotations.Preamble;
import com.arm.mbed.cloud.sdk.common.GenericAdapter.Mapper;

import okhttp3.Headers;
import okhttp3.Request;
import retrofit2.Call;
import retrofit2.Response;

@Preamble(description = "Utility in charge of calling Arm Mbed Cloud APIs")
@Internal
public class CloudCaller<T, U> {
    protected static final String DATE_HEADER = "Date";
    protected static final String DATE_HEADER_LOWERCASE = "date";
    protected static final String REQUEST_ID_HEADER = "X-Request-ID";
    protected static final String REQUEST_ID_HEADER_LOWERCASE = "x-request-id";
    private final CloudCall<T> caller;
    private final Mapper<T, U> mapper;
    private final SdkLogger logger;
    private final String apiName;
    private final boolean storeMetadata;
    private final boolean throwExceptionOnNotFound;
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
            boolean storeMetada, boolean throwExceptionOnNotFound) {
        super();
        this.caller = caller;
        this.mapper = mapper;
        this.logger = module.logger;
        this.apiName = apiName;
        this.module = module;
        this.storeMetadata = storeMetada;
        this.throwExceptionOnNotFound = throwExceptionOnNotFound;
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
        return call(module, functionName, mapper, caller, false);
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
     * @param throwExceptionOnNotFound
     *            states whether to throw an exception when 404 Not found is received from the server
     * @param <T>
     *            type of HTTP response object.
     * @param <U>
     *            type of API response object.
     * @return request result
     * @throws MbedCloudException
     *             if an error occurred during the call
     */
    public static <T, U> U call(AbstractApi module, String functionName, Mapper<T, U> mapper, CloudCall<T> caller,
            boolean throwExceptionOnNotFound) throws MbedCloudException {
        return call(module, functionName, mapper, caller, true, throwExceptionOnNotFound);
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
     * @param throwExceptionOnNotFound
     *            states whether to throw an exception when 404 Not found is received from the server
     * @param <T>
     *            type of HTTP response object.
     * @param <U>
     *            type of API response object.
     * @return request result
     * @throws MbedCloudException
     *             if an error occurred during the call
     */
    public static <T, U> U call(AbstractApi module, String functionName, Mapper<T, U> mapper, CloudCall<T> caller,
            boolean storeMetadata, boolean throwExceptionOnNotFound) throws MbedCloudException {
        return callWithFeedback(module, functionName, mapper, caller, storeMetadata, throwExceptionOnNotFound)
                .getResult();
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
     * @param throwExceptionOnNotFound
     *            states whether to throw an exception when 404 Not found is received from the server
     * @return CallFeedback @see {@link CallFeedback}
     * @throws MbedCloudException
     *             if an error occurred during the call
     */
    public static <T, U> CallFeedback<U> callWithFeedback(AbstractApi module, String functionName, Mapper<T, U> mapper,
            CloudCall<T> caller, boolean storeMetadata, boolean throwExceptionOnNotFound) throws MbedCloudException {
        return new CloudCaller<>(functionName, caller, mapper, module, storeMetadata, throwExceptionOnNotFound)
                .execute();
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
        new CloudCaller<>(null, null, null, module, true, false).storeApiMetadataInTheCache(metadata);
    }

    /**
     * Executes a call to Arm Mbed Cloud.
     *
     * @return result objects of type U
     * @throws MbedCloudException
     *             if an error occurred during the call
     */
    public CallFeedback<U> execute() throws MbedCloudException {
        Call<T> call = null;
        try {
            logger.logInfo("Calling Arm Mbed Cloud API: " + apiName);
            clearPreviousApiMetadata();
            call = caller.call();
            final Response<T> response = call.execute();
            final CallFeedback<U> comms = new CallFeedback<>(logger);
            comms.setMetadataFromResponse(response);
            if (storeMetadata) {
                storeApiMetadataInTheCache(comms.getMetadata());
            }
            checkResponse(response, comms);
            comms.setResultFromResponse(mapper, response);
            return comms;
        } catch (Exception exception) {
            Exception detailedException = exception;
            if (call != null) {
                if (call.isCanceled()) {
                    detailedException = new Exception("the call to Mbed Cloud has been cancelled.", exception);
                }
                call.cancel();
            }
            logger.throwSdkException("An error occurred when calling SDK function [" + apiName + "]",
                    detailedException);
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

            final String errorMessage = retrieveErrorMessageFromBody(response);
            final Error error = retrieveErrorDetails(errorMessage, response);
            if (comms != null) {
                comms.setErrorMessage(error);
            }
            // In the case of a 404 Not found error, consider that the request result is actually NULL and not
            // erroneous.
            if (response.code() == 404 && !throwExceptionOnNotFound) {
                return;
            }

            logger.throwSdkException(
                    "An error occurred when calling Arm Mbed Cloud: [" + response.code() + "] " + response.message(),
                    error == null ? errorMessage == null ? null : new MbedCloudException(errorMessage)
                            : new MbedCloudException(error.toPrettyString()));
        }
    }

    protected static <T> String retrieveErrorMessageFromBody(Response<T> response) {
        String errorMessage = null;
        try {
            errorMessage = response.errorBody().string();
        } catch (IOException exception) {
            // Nothing to do
        }
        return errorMessage;
    }

    protected static <T> Error retrieveErrorDetails(String errorMessageFromBody, Response<T> response) {
        Error error = null;
        try {
            error = ErrorJsonConverter.INSTANCE.convert(errorMessageFromBody);
        } catch (Exception exception) {
            // Nothing to do
        }
        if (error == null) {
            error = generateErrorFromResponse(errorMessageFromBody, response);
        }
        return error;
    }

    private static <T> Error generateErrorFromResponse(String errorMessageFromBody, Response<T> response) {
        final StringBuilder errorMessageBuilder = new StringBuilder();
        errorMessageBuilder.append(response.message());
        if (errorMessageFromBody != null && !errorMessageFromBody.isEmpty()) {
            errorMessageBuilder.append(": ").append(errorMessageFromBody);
        }
        return new Error(response.code(), "Mbed Cloud call", errorMessageBuilder.toString(),
                retrieveRequestId(response));
    }

    public static <T> String retrieveRequestId(Response<T> response) {
        final String requestId = response.headers().get(REQUEST_ID_HEADER);
        return requestId == null || requestId.isEmpty() ? fetchRequestUrlString(response) : requestId;
    }

    private static <T> String fetchRequestUrlString(Response<T> response) {
        final URL url = fetchRequestUrl(fetchRequest(response));
        return (url == null) ? null : url.toString();
    }

    private static URL fetchRequestUrl(Request request) {
        if (request == null) {
            return null;
        }
        return request.url().url();
    }

    private static <T> Request fetchRequest(Response<T> response) {
        return response.raw().request();
    }

    protected static class ErrorJsonConverter {
        private final JsonSerialiser jsonSerialiser = new JsonSerialiser();
        public static final ErrorJsonConverter INSTANCE = new ErrorJsonConverter();

        public Error convert(String body) {
            if (body == null) {
                return null;
            }
            return jsonSerialiser.fromJson(body, ErrorHack.class).getError();

        }
    }

    /**
     * Workaroud to handle the fact that request id is snake case.
     */
    @SuppressWarnings("PMD.DoNotExtendJavaLangError")
    private static class ErrorHack extends Error {
        /**
         * Serialisation Id.
         */
        private static final long serialVersionUID = 4818490051889482443L;
        @SuppressWarnings({ "checkstyle:membername", "PMD.VariableNamingConventions" })
        private String request_id;

        /**
         * Gets the underlying error.
         *
         * @return the underlying error.
         */
        public Error getError() {
            final Error error = clone();
            error.setRequestId(request_id);
            return error;
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
                metadata.setError(error);
            }
        }

        private <T> ApiMetadata retrieveMetadata(Response<T> response) {
            if (response == null) {
                return null;
            }
            final ApiMetadata callMetadata = new ApiMetadata();

            final Request request = fetchRequest(response);
            if (request != null) {
                callMetadata.setMethod(request.method());
                callMetadata.setUrl(fetchRequestUrl(request));
            }

            callMetadata.setStatusCode(response.code());
            final Headers headers = response.headers();
            if (headers != null) {
                callMetadata.setHeaders(headers.toMultimap());

                callMetadata.setRequestId(headers.get(REQUEST_ID_HEADER_LOWERCASE));
                if (!callMetadata.hasRequestId()) {
                    callMetadata.setRequestId(headers.get(REQUEST_ID_HEADER));
                }
                try {
                    String dateHeader = headers.get(DATE_HEADER);
                    if (dateHeader == null) {
                        dateHeader = headers.get(DATE_HEADER_LOWERCASE);
                    }
                    callMetadata.setDateFromString(dateHeader);
                } catch (Exception exception) {
                    logger.logWarn("An error occurred when trying to fetch server date from API metadata", exception);
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
