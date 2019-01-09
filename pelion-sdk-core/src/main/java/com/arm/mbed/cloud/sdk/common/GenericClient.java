package com.arm.mbed.cloud.sdk.common;

import java.lang.reflect.ParameterizedType;

import com.arm.mbed.cloud.sdk.annotations.API;
import com.arm.mbed.cloud.sdk.annotations.Internal;
import com.arm.mbed.cloud.sdk.annotations.NonNull;
import com.arm.mbed.cloud.sdk.annotations.Nullable;
import com.arm.mbed.cloud.sdk.annotations.Preamble;
import com.arm.mbed.cloud.sdk.common.CloudRequest.CloudCall;
import com.arm.mbed.cloud.sdk.common.CloudRequest.CloudListRequest;
import com.arm.mbed.cloud.sdk.common.GenericAdapter.Mapper;
import com.arm.mbed.cloud.sdk.common.listing.ListOptions;
import com.arm.mbed.cloud.sdk.common.listing.ListResponse;
import com.arm.mbed.cloud.sdk.common.listing.PageRequester;
import com.arm.mbed.cloud.sdk.common.listing.Paginator;

@Preamble(description = "Generic client to call Pelion APIs")
/**
 *
 * Utility enabling calls to Pelion Cloud APIs which are not yet supported by the SDK.
 * <p>
 * Note: Please avoid using this client directly if the Cloud API is supported by the SDK.
 *
 */
public class GenericClient {

    private static final String UNCHECKED = "unchecked";
    private static final String REQUEST_PARAMETER_TAG = "request";
    private static final String DEFAULT_OPERATION_ID = "customCall()";
    private final AbstractModule module;

    /**
     * Constructor.
     *
     * @param options
     *            connection options.
     */
    public GenericClient(@NonNull ConnectionOptions options) {
        this(new DefaultModule(options));
    }

    /**
     * Constructor.
     *
     * @param module
     *            Pelion module.
     */
    public GenericClient(@NonNull AbstractModule module) {
        this.module = module;
    }

    /**
     * Gets a new generic client instance.
     *
     * @param options
     *            connection options
     * @return a generic client instance.
     */
    public static GenericClient newClient(@NonNull ConnectionOptions options) {
        return new GenericClient(options);
    }

    /**
     * Calls a Pelion Cloud Paginated API.
     *
     * @param request
     *            request definition.
     * @param options
     *            list options
     * @param extraRequestParameters
     *            extra request parameters.
     * @param <T>
     *            type of the model returned in the list
     * @param <S>
     *            service to call
     * @param <O>
     *            type of list options
     * @return paginator returned by Pelion.
     * @throws MbedCloudException
     *             if an error occurred during the call.
     */
    public @NonNull <T extends SdkModel, S, O extends ListOptions> Paginator<T>
           callPaginatedApi(@NonNull CloudListRequest<T, S, O> request, O options,
                            Object... extraRequestParameters) throws MbedCloudException {
        return callPaginatedApi(null, request, options, extraRequestParameters);
    }

    /**
     * Calls a Pelion Cloud Paginated API.
     *
     * @param operationId
     *            name of the API called.
     * @param request
     *            request definition.
     * @param options
     *            list options
     * @param extraRequestParameters
     *            extra request parameters.
     * @param <T>
     *            type of the model returned in the list
     * @param <S>
     *            service to call
     * @param <O>
     *            type of list options
     * @return paginator returned by Pelion.
     * @throws MbedCloudException
     *             if an error occurred during the call.
     */
    public @NonNull <T extends SdkModel, S, O extends ListOptions> Paginator<T>
           callPaginatedApi(@Nullable String operationId, @NonNull CloudListRequest<T, S, O> request, O options,
                            Object... extraRequestParameters) throws MbedCloudException {
        module.checkNotNull(request, REQUEST_PARAMETER_TAG);
        final String finalOperationId = operationId;
        final CloudListRequest<T, S, O> finalRequest = request;
        final Object[] finalExtraParameters = extraRequestParameters;
        return new Paginator<>(options, new PageRequester<T>() {

            @SuppressWarnings(UNCHECKED)
            @Override
            public ListResponse<T> requestNewPage(ListOptions listOptions) throws MbedCloudException {
                return callListApi(finalOperationId, finalRequest, (O) listOptions, finalExtraParameters);
            }
        });
    }

    /**
     * Calls a Pelion Cloud list API.
     *
     *
     * @param request
     *            request definition.
     * @param options
     *            list options
     * @param extraRequestParameters
     *            extra request parameters.
     * @param <T>
     *            type of the model returned in the list
     * @param <S>
     *            service to call
     * @param <O>
     *            type of list options
     * @return page returned by Pelion.
     * @throws MbedCloudException
     *             if an error occurred during the call.
     */
    public @Nullable <T extends SdkModel, S, O extends ListOptions> ListResponse<T>
           callListApi(@NonNull CloudListRequest<T, S, O> request, O options,
                       Object... extraRequestParameters) throws MbedCloudException {
        return callListApi(null, request, options, extraRequestParameters);
    }

    /**
     * Calls a Pelion Cloud list API.
     *
     * @param operationId
     *            name of the API called.
     * @param request
     *            request definition.
     * @param options
     *            list options
     * @param extraRequestParameters
     *            extra request parameters.
     * @param <T>
     *            type of the model returned in the list
     * @param <S>
     *            service to call
     * @param <O>
     *            type of list options
     * @return page returned by Pelion.
     * @throws MbedCloudException
     *             if an error occurred during the call.
     */
    public @Nullable <T extends SdkModel, S, O extends ListOptions> ListResponse<T>
           callListApi(@Nullable String operationId, @NonNull CloudListRequest<T, S, O> request, O options,
                       Object... extraRequestParameters) throws MbedCloudException {
        module.checkNotNull(request, REQUEST_PARAMETER_TAG);
        @SuppressWarnings(UNCHECKED)
        final Class<T> modelClass = (Class<T>) (((ParameterizedType) request.getClass()
                                                                            .getGenericInterfaces()[0]).getActualTypeArguments()[0]);
        @SuppressWarnings(UNCHECKED)
        final Class<S> serviceClass = (Class<S>) (((ParameterizedType) request.getClass()
                                                                              .getGenericInterfaces()[0]).getActualTypeArguments()[1]);
        return callApi(operationId, GenericAdapter.identityListMapper(modelClass),
                       request.defineCall(module.getService(serviceClass), options, extraRequestParameters));
    }

    /**
     * Calls a Pelion Cloud API.
     *
     * @param request
     *            request definition.
     * @param requestParameters
     *            parameters.
     * @param <T>
     *            type of the model returned in the list
     * @param <S>
     *            service to call
     * 
     * @return response returned by Pelion.
     * @throws MbedCloudException
     *             if an error occurred during the call.
     */
    public @Nullable <T, S> T callApi(@NonNull CloudRequest<T, S> request,
                                      Object... requestParameters) throws MbedCloudException {
        return callApi(null, request, requestParameters);
    }

    /**
     * Calls a Pelion Cloud API.
     *
     * @param operationId
     *            name of the API called.
     * @param request
     *            request definition.
     * @param requestParameters
     *            parameters.
     * @param <T>
     *            type of the model returned in the list
     * @param <S>
     *            service to call
     * @return response returned by Pelion.
     * @throws MbedCloudException
     *             if an error occurred during the call.
     *
     */
    public @Nullable <T, S> T callApi(@Nullable String operationId, @NonNull CloudRequest<T, S> request,
                                      @Nullable Object... requestParameters) throws MbedCloudException {
        module.checkNotNull(request, REQUEST_PARAMETER_TAG);
        @SuppressWarnings(UNCHECKED)
        final Class<T> modelClass = (Class<T>) (((ParameterizedType) request.getClass()
                                                                            .getGenericInterfaces()[0]).getActualTypeArguments()[0]);
        return callApi(operationId, GenericAdapter.identityMapper(modelClass), request, requestParameters);
    }

    /**
     *
     * Calls a Pelion Cloud API.
     *
     * @param operationId
     *            name of the API called.
     * @param mapper
     *            mapper between the response from Pelion Cloud and the expected model/entity.
     * @param request
     *            request definition.
     * @param requestParameters
     *            parameters.
     * @param <T>
     *            type of the model returned in the list
     * @param <S>
     *            service to call
     * @param <U>
     *            type of objects returned by the API
     * @return response returned by Pelion.
     * @throws MbedCloudException
     *             if an error occurred during the call.
     */
    public @Nullable <T, U, S> T callApi(@Nullable String operationId, @NonNull Mapper<U, T> mapper,
                                         @NonNull CloudRequest<U, S> request,
                                         @Nullable Object... requestParameters) throws MbedCloudException {
        module.checkNotNull(request, REQUEST_PARAMETER_TAG);
        @SuppressWarnings(UNCHECKED)
        final Class<S> serviceClass = (Class<S>) (((ParameterizedType) request.getClass()
                                                                              .getGenericInterfaces()[0]).getActualTypeArguments()[1]);
        return callApi(operationId, mapper, request.defineCall(module.getService(serviceClass), requestParameters));
    }

    /**
     *
     * Calls a Pelion Cloud API.
     *
     * @param operationId
     *            name of the API called.
     * @param mapper
     *            mapper between the response from Pelion Cloud and the expected model/entity.
     * @param call
     *            low level call definition.
     * @param <T>
     *            type of the model returned in the list
     * @param <U>
     *            type of objects returned by the API
     * @return response returned by Pelion.
     * @throws MbedCloudException
     *             if an error occurred during the call.
     */
    public @Nullable <T, U> T callApi(@Nullable String operationId, @NonNull Mapper<U, T> mapper,
                                      @NonNull CloudCall<U> call) throws MbedCloudException {
        module.checkNotNull(mapper, "mapper");
        module.checkNotNull(mapper, "call");
        final String method = operationId == null ? DEFAULT_OPERATION_ID : operationId;
        return CloudCaller.call(module, method, mapper, call);
    }

    /**
     * Gets meta data for the last call to the cloud.
     *
     * @see ApiMetadata
     * @return metadata
     */
    @API
    public ApiMetadata getLastApiMetadata() {
        return module.getLastApiMetadata();
    }

    @Preamble(description = "Default Pelion Cloud module")
    @Internal
    private static class DefaultModule extends AbstractModule {

        private static final String NAME = "Default module";

        /**
         * Constructor.
         *
         * @param options
         *            connection options.
         */
        public DefaultModule(@NonNull ConnectionOptions options) {
            super(options);
        }

        public DefaultModule(SdkContext context) {
            super(context);
        }

        @Override
        public String getModuleName() {
            return NAME;
        }

        @Override
        public DefaultModule clone() {
            return new DefaultModule(this);
        }

    }
}
