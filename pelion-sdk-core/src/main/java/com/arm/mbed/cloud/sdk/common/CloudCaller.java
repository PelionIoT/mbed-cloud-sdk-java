package com.arm.mbed.cloud.sdk.common;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.URL;
import java.util.Date;

import com.arm.mbed.cloud.sdk.annotations.Internal;
import com.arm.mbed.cloud.sdk.annotations.Preamble;
import com.arm.mbed.cloud.sdk.common.CloudRequest.CloudCall;
import com.arm.mbed.cloud.sdk.common.GenericAdapter.Mapper;

import okhttp3.Headers;
import okhttp3.Request;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Response;

@Preamble(description = "Utility in charge of calling Pelion Cloud APIs")
@Internal
public class CloudCaller<T, U> {
    public static final String METHOD_CALL_CLOUD_API = "call";
    private static final String UNCHECKED = "unchecked";
    protected static final String DATE_HEADER = "Date";
    protected static final String DATE_HEADER_LOWERCASE = "date";
    protected static final String REQUEST_ID_HEADER = "X-Request-ID";
    protected static final String REQUEST_ID_HEADER_LOWERCASE = "x-request-id";
    protected static final String ETAG_HEADER = "ETag";
    protected static final String ETAG_HEADER_LOWERCASE = "etag";
    private final CloudCall<T> caller;
    private final Mapper<T, U> mapper;
    private final SdkLogger logger;
    private final String apiName;
    private final boolean storeMetadata;
    private final boolean throwExceptionOnNotFound;
    private final AbstractModule module;

    private CloudCaller(String apiName, CloudCall<T> caller, Mapper<T, U> mapper, AbstractModule module,
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
    public static <T, U> U call(AbstractModule module, String functionName, Mapper<T, U> mapper,
                                CloudCall<T> caller) throws MbedCloudException {
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
    public static <T, U> U call(AbstractModule module, String functionName, Mapper<T, U> mapper, CloudCall<T> caller,
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
    public static <T, U> U call(AbstractModule module, String functionName, Mapper<T, U> mapper, CloudCall<T> caller,
                                boolean storeMetadata, boolean throwExceptionOnNotFound) throws MbedCloudException {
        return callWithFeedback(module, functionName, mapper, caller, storeMetadata,
                                throwExceptionOnNotFound).getResult();
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
     * @param caller
     *            request
     * @param throwExceptionOnNotFound
     *            states whether to throw an exception when 404 Not found is received from the server
     * @param <T>
     *            type of HTTP response object.
     * @return raw result
     * @throws MbedCloudException
     *             if an error occurred during the call
     */
    public static <T> String callRaw(AbstractModule module, String functionName, CloudCall<T> caller,
                                     boolean throwExceptionOnNotFound) throws MbedCloudException {
        return callWithRawFeedback(module, functionName, caller, true, throwExceptionOnNotFound).getResult();
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
    public static <T, U> CallFeedback<T, U>
           callWithFeedback(AbstractModule module, String functionName, Mapper<T, U> mapper, CloudCall<T> caller,
                            boolean storeMetadata, boolean throwExceptionOnNotFound) throws MbedCloudException {
        return new CloudCaller<>(functionName, caller, mapper, module, storeMetadata,
                                 throwExceptionOnNotFound).execute();
    }

    /**
     * Executes a raw call to Arm Mbed Cloud.
     *
     * @param module
     *            API module
     * @param functionName
     *            API function name.
     * @param <T>
     *            type of HTTP response object.
     * @param caller
     *            request
     * @param storeMetadata
     *            states whether metadata should be recorded
     * @param throwExceptionOnNotFound
     *            states whether to throw an exception when 404 Not found is received from the server
     * @return a raw call feedback @see {@link RawCallFeedback}
     * @throws MbedCloudException
     *             if an error occurred during the call
     */
    public static <T> RawCallFeedback<T>
           callWithRawFeedback(AbstractModule module, String functionName, CloudCall<T> caller, boolean storeMetadata,
                               boolean throwExceptionOnNotFound) throws MbedCloudException {
        return new CloudCaller<>(functionName, caller, null, module, storeMetadata,
                                 throwExceptionOnNotFound).executeRaw();
    }

    /**
     * Stores API Metadata to the module.
     *
     * @param module
     *            module.
     * @param metadata
     *            api metadata
     */
    public static void storeApiMetadata(AbstractModule module, ApiMetadata metadata) {
        new CloudCaller<>(null, null, null, module, true, false).storeApiMetadataInTheCache(metadata);
    }

    /**
     * Executes a call to Arm Mbed Cloud.
     *
     * @return raw result objects
     * @throws MbedCloudException
     *             if an error occurred during the call
     */
    @SuppressWarnings({ UNCHECKED })
    private RawCallFeedback<T> executeRaw() throws MbedCloudException {
        return execute(RawCallFeedback.class);
    }

    /**
     * Executes a call to Arm Mbed Cloud.
     *
     * @return result objects of type U
     * @throws MbedCloudException
     *             if an error occurred during the call
     */
    @SuppressWarnings(UNCHECKED)
    private CallFeedback<T, U> execute() throws MbedCloudException {
        return execute(CallFeedback.class);
    }

    /**
     * Executes a call to Arm Mbed Cloud.
     *
     * @return result objects
     * @throws MbedCloudException
     *             if an error occurred during the call
     */
    private <C extends AbstractCallFeedBack<T>> C execute(Class<C> callFeedback) throws MbedCloudException {
        Call<T> call = null;
        try {
            final boolean isRawCall = callFeedback != null && callFeedback.isAssignableFrom(RawCallFeedback.class);
            logger.logInfo("Calling Arm Mbed Cloud API: " + apiName);
            clearPreviousApiMetadata();
            call = caller.call();
            final CloudResponse<T> response = executeRequest(call, isRawCall);
            @SuppressWarnings(UNCHECKED)
            final C comms = (C) (isRawCall ? new RawCallFeedback<T>(logger) : new CallFeedback<>(logger, mapper));
            comms.setMetadataFromResponse(response.getResponse());
            if (storeMetadata) {
                storeApiMetadataInTheCache(comms.getMetadata());
            }
            checkResponse(response, comms);
            comms.setResultFromResponse(response);
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

    private CloudResponse<T> executeRequest(Call<T> call, final boolean isRawCall) throws IOException {
        return isRawCall ? rawExecute(call) : new CloudResponse<>(call.execute(), null);
    }

    @SuppressWarnings(UNCHECKED)
    private CloudResponse<T> rawExecute(Call<T> call) throws IOException {
        try {
            final Method method = call.getClass().getDeclaredMethod("createRawCall");
            method.setAccessible(true);
            final okhttp3.Call rawCall = (okhttp3.Call) method.invoke(call);
            CloudResponse<T> response = null;
            try (okhttp3.Response rawResponse = rawCall.execute()) {
                final int code = rawResponse.code();
                try (ResponseBody rawBody = rawResponse.body()) {
                    if (code < 200 || code >= 300) {
                        response = new CloudResponse<>((Response<T>) Response.error(rawBody, rawResponse),
                                                       rawBody.string());
                    } else if (code == 204 || code == 205) {
                        response = new CloudResponse<>((Response<T>) Response.success(null, rawResponse), null);
                    } else {
                        response = new CloudResponse<>((Response<T>) Response.success(null, rawResponse),
                                                       rawBody.string());
                    }
                }
            }

            return response;
        } catch (Exception exception) {
            logger.logError("An error occurred when trying to fetch the raw HTTP response: " + exception.getMessage());
            return new CloudResponse<>(call.execute(), null);
        }
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

    private <C extends AbstractCallFeedBack<T>> void checkResponse(CloudResponse<T> response,
                                                                   C comms) throws MbedCloudException {
        if (response == null) {
            logger.throwSdkException("An error occurred when calling Arm Mbed Cloud: no response was received");
        }
        if (response != null && !response.isSuccessful()) {

            final String errorMessage = retrieveErrorMessageFromBody(response);
            final Error error = retrieveErrorDetails(errorMessage, response.getResponse());
            if (comms != null) {
                comms.setErrorMessage(error);
            }
            // In the case of a 404 Not found error, consider that the request result is actually NULL and not
            // erroneous.
            if (response.isNotFound() && !throwExceptionOnNotFound) {
                return;
            }

            logger.throwSdkException("An error occurred when calling Arm Mbed Cloud: [" + response.code() + "] "
                                     + response.message(), new MbedCloudException(error.toPrettyString()));
        }
    }

    protected static <T> String retrieveErrorMessageFromBody(CloudResponse<T> response) {
        String errorMessage = null;
        try {
            errorMessage = response.getRawBody() == null ? response.getResponse().errorBody().string()
                                                         : response.getRawBody();
        } catch (Exception exception) {
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

    static URL fetchRequestUrl(Request request) {
        if (request == null) {
            return null;
        }
        return request.url().url();
    }

    static <T> Request fetchRequest(Response<T> response) {
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

    public static class CloudResponse<T> {
        private final Response<T> response;
        private final String rawBody;

        /**
         * Constructor.
         *
         * @param response
         *            response
         * @param rawBody
         *            raw body
         */
        public CloudResponse(Response<T> response, String rawBody) {
            super();
            this.response = response;
            this.rawBody = rawBody;
        }

        public String message() {
            return response == null ? null : response.message();
        }

        public int code() {
            return response == null ? 0 : response.code();
        }

        public boolean isNotFound() {
            return code() == 404;
        }

        public boolean isSuccessful() {
            return response == null ? false : response.isSuccessful();
        }

        /**
         * Gets the response.
         *
         * @return the response
         */
        public Response<T> getResponse() {
            return response;
        }

        /**
         * Gets the raw body.
         *
         * @return the rawBody
         */
        public String getRawBody() {
            return rawBody;
        }

    }

    private abstract static class AbstractCallFeedBack<T> {

        protected final SdkLogger logger;
        ApiMetadata metadata;

        public AbstractCallFeedBack(SdkLogger logger) {
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
         * Sets metadata from an HTTP response.
         *
         * @param <T>
         *            type of the result
         * @param response
         *            HTTP response
         */
        public void setMetadataFromResponse(Response<T> response) {
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

        private ApiMetadata retrieveMetadata(Response<T> response) {
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
                callMetadata.setEtag(headers.get(ETAG_HEADER_LOWERCASE));
                if (!callMetadata.hasEtag()) {
                    callMetadata.setEtag(headers.get(ETAG_HEADER));
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
                final String etag = fetchEtagField(body);
                if (etag != null) {
                    callMetadata.setEtag(etag);
                }
            }
            return callMetadata;
        }

        private String fetchEtagField(T body) {
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

        /**
         * Sets result from an HTTP response.
         *
         * @param response
         *            HTTP response
         */
        public abstract void setResultFromResponse(CloudResponse<T> response);

    }

    /**
     *
     * Defines a call (Metadata + raw response) of a call to Arm Mbed Cloud.
     *
     * @param <T>
     *            type of the response object
     */
    public static class RawCallFeedback<T> extends AbstractCallFeedBack<T> {
        String result;

        /**
         * Constructor.
         *
         * @param logger
         *            logger
         */
        public RawCallFeedback(SdkLogger logger) {
            super(logger);
        }

        /**
         * Gets call result.
         *
         * @return the result
         */
        public String getResult() {
            return result;
        }

        /**
         * Sets call result.
         *
         * @param result
         *            the result to set
         */
        public void setResult(String result) {
            this.result = result;
        }

        /**
         * Sets result from an HTTP response.
         *
         * @param response
         *            HTTP response
         */
        @Override
        public void setResultFromResponse(CloudResponse<T> response) {
            if (!response.isNotFound()) {
                setResult(response.getRawBody());
            }
        }
    }

    /**
     *
     * Defines a call (Metadata + response) of a call to Arm Mbed Cloud.
     *
     * @param <U>
     *            type of the result object
     * @param <T>
     *            type of the response object
     */
    public static class CallFeedback<T, U> extends AbstractCallFeedBack<T> {
        private U result;
        private final Mapper<T, U> mapper;

        /**
         * Constructor.
         *
         * @param logger
         *            logger
         * @param mapper
         *            mapper
         */
        public CallFeedback(SdkLogger logger, Mapper<T, U> mapper) {
            super(logger);
            this.mapper = mapper;
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
         * @param response
         *            HTTP response
         */
        @Override
        public void setResultFromResponse(CloudResponse<T> response) {
            if (!response.isNotFound()) {
                setResult((mapper == null) ? null : mapper.map(response.getResponse().body()));
            }
        }
    }
}
