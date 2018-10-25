package com.arm.mbed.cloud.sdk.common;

import java.lang.reflect.ParameterizedType;

import org.jetbrains.annotations.NotNull;

import com.arm.mbed.cloud.sdk.annotations.API;
import com.arm.mbed.cloud.sdk.annotations.Internal;
import com.arm.mbed.cloud.sdk.annotations.NonNull;
import com.arm.mbed.cloud.sdk.annotations.Nullable;
import com.arm.mbed.cloud.sdk.annotations.Preamble;
import com.arm.mbed.cloud.sdk.common.CloudRequest.CloudCall;
import com.arm.mbed.cloud.sdk.common.GenericAdapter.Mapper;

@Preamble(description = "Generic client to call Pelion APIs")
/**
 *
 * Utility enabling calls to Pelion Cloud APIs which are not yet supported by the SDK.
 * <p>
 * Note: Please avoid using this client directly if the Cloud API is supported by the SDK.
 *
 */
public class GenericClient {

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
     * Calls a Pelion Cloud API.
     *
     * @param request
     *            request definition.
     * @param requestParameters
     *            parameters.
     * @return model returned by Pelion.
     * @throws MbedCloudException
     *             if an error occurred during the call.
     */
    public @Nullable <T extends SdkModel, S> T callApi(@NotNull CloudRequest<T, S> request,
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
     * @return model returned by Pelion.
     * @throws MbedCloudException
     *             if an error occurred during the call.
     *
     */
    public @Nullable <T extends SdkModel, S> T
           callApi(@Nullable String operationId, @NotNull CloudRequest<T, S> request,
                   @Nullable Object... requestParameters) throws MbedCloudException {
        module.checkNotNull(request, "request");
        @SuppressWarnings("unchecked")
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
     * @return model returned by Pelion.
     * @throws MbedCloudException
     *             if an error occurred during the call.
     */
    public @Nullable <T extends SdkModel, U, S> T
           callApi(@Nullable String operationId, @NonNull Mapper<U, T> mapper, @NotNull CloudRequest<U, S> request,
                   @Nullable Object... requestParameters) throws MbedCloudException {
        module.checkNotNull(request, "request");
        @SuppressWarnings("unchecked")
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
     * @return model returned by Pelion.
     * @throws MbedCloudException
     *             if an error occurred during the call.
     */
    public @Nullable <T extends SdkModel, U> T callApi(@Nullable String operationId, @NonNull Mapper<U, T> mapper,
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
