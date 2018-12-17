package com.arm.mbed.cloud.sdk.common;

import java.util.Map;

import com.arm.mbed.cloud.sdk.annotations.API;
import com.arm.mbed.cloud.sdk.annotations.Internal;
import com.arm.mbed.cloud.sdk.annotations.Preamble;

@Preamble(description = "Generic SDK module definition")
@Internal
public abstract class AbstractApi implements ApiModule {

    public static final String SERVICE_STORE_FIELD_NAME = "serviceStore";
    public static final String METHOD_CHECK_NOT_NULL = "checkNotNull";
    public static final String METHOD_CHECK_MODEL_VALIDITY = "checkModelValidity";
    protected final ApiClientWrapper client;
    protected final ServiceStore serviceStore;

    protected final SdkLogger logger;
    protected final ApiMetadataCache metadataCache;

    /**
     * Constructor.
     *
     * @param options
     *            connection options @see {@link ConnectionOptions}
     */
    public AbstractApi(ConnectionOptions options) {
        this(options, null);
    }

    protected AbstractApi(ApiClientWrapper client) {
        super();
        this.client = client;
        serviceStore = new ServiceStore(client);
        logger = new SdkLogger();
        metadataCache = new ApiMetadataCache();
    }

    /**
     * Constructor.
     *
     * @param options
     *            connection options @see {@link ConnectionOptions}
     * @param userAgentExtension
     *            extension list for the user agent: module name - module version
     */
    public AbstractApi(ConnectionOptions options, Map<String, String> userAgentExtension) {
        this(new ApiClientWrapper(options, userAgentExtension));
    }

    public void checkNotNull(Object arg, String argName) throws MbedCloudException {
        clearApiMetadata();
        ApiUtils.checkNotNull(logger, arg, argName);
    }

    public void checkModelValidity(SdkModel model, String argName) throws MbedCloudException {
        clearApiMetadata();
        ApiUtils.checkModelValidity(logger, model, argName);
    }

    /*
     * (non-Javadoc)
     *
     * @see com.arm.mbed.cloud.sdk.common.ApiModule#getLogger()
     */
    @Override
    public SdkLogger getLogger() {
        return logger;
    }

    /*
     * (non-Javadoc)
     *
     * @see com.arm.mbed.cloud.sdk.common.ApiModule#getClient()
     */
    @Override
    public ApiClientWrapper getClient() {
        return client;
    }

    /**
     * Gets meta data for the last Arm Mbed Cloud API call.
     *
     * @see ApiMetadata
     * @return metadata
     */
    @Override
    @API
    public ApiMetadata getLastApiMetadata() {
        return metadataCache.getLastApiMetadata();
    }

    /**
     * Clears API metadata cache.
     * <p>
     * This is for internal purposes only.
     */
    @Internal
    public void clearApiMetadata() {
        metadataCache.clearMetadata();
    }

    /**
     *
     * Gets a service.
     *
     * @param serviceClass
     *            class of the service.
     * @param <S>
     *            service type
     * @return corresponding service.
     * @throws MbedCloudException
     *             if a problem occurred during the process.
     */
    public <S> S getService(Class<S> serviceClass) throws MbedCloudException {
        return serviceStore.getService(serviceClass);
    }

    /**
     * Gets the SDK module name.
     *
     * @return module name.
     */
    @Override
    public abstract String getModuleName();

}
