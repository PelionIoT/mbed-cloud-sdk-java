package com.arm.mbed.cloud.sdk.common;

import java.lang.reflect.ParameterizedType;

import org.jetbrains.annotations.NotNull;

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
    private final AbstractApi module;

    /**
     * Constructor.
     *
     * @param options
     *            connection options.
     */
    public GenericClient(@NotNull ConnectionOptions options) {
        this(new DefaultModule(options));
    }

    /**
     * Constructor.
     *
     * @param module
     *            Pelion module.
     */
    public GenericClient(@NotNull AbstractApi module) {
        this.module = module;
    }

    /**
     * Gets a new generic client instance.
     *
     * @param options
     *            connection options
     * @return a generic client instance.
     */
    public static GenericClient newClient(@NotNull ConnectionOptions options) {
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
     * @return paginator returned by Pelion.
     * @throws MbedCloudException
     *             if an error occurred during the call.
     */
    public @NonNull <T extends SdkModel, S, O extends ListOptions> Paginator<T>
           callPaginatedApi(@NotNull CloudListRequest<T, S, O> request, O options,
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
     * @return paginator returned by Pelion.
     * @throws MbedCloudException
     *             if an error occurred during the call.
     */
    public @NonNull <T extends SdkModel, S, O extends ListOptions> Paginator<T>
           callPaginatedApi(@Nullable String operationId, @NotNull CloudListRequest<T, S, O> request, O options,
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
     * @return page returned by Pelion.
     * @throws MbedCloudException
     *             if an error occurred during the call.
     */
    public @Nullable <T extends SdkModel, S, O extends ListOptions> ListResponse<T>
           callListApi(@NotNull CloudListRequest<T, S, O> request, O options,
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
     * @return page returned by Pelion.
     * @throws MbedCloudException
     *             if an error occurred during the call.
     */
    public @Nullable <T extends SdkModel, S, O extends ListOptions> ListResponse<T>
           callListApi(@Nullable String operationId, @NotNull CloudListRequest<T, S, O> request, O options,
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
     * @return response returned by Pelion.
     * @throws MbedCloudException
     *             if an error occurred during the call.
     */
    public @Nullable <T, S> T callApi(@NotNull CloudRequest<T, S> request,
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
     * @return response returned by Pelion.
     * @throws MbedCloudException
     *             if an error occurred during the call.
     *
     */
    public @Nullable <T, S> T callApi(@Nullable String operationId, @NotNull CloudRequest<T, S> request,
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
     * @return response returned by Pelion.
     * @throws MbedCloudException
     *             if an error occurred during the call.
     */
    public @Nullable <T, U, S> T callApi(@Nullable String operationId, @NonNull Mapper<U, T> mapper,
                                         @NotNull CloudRequest<U, S> request,
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
    private static class DefaultModule extends AbstractApi {

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

        @Override
        public String getModuleName() {
            return NAME;
        }

    }
}
