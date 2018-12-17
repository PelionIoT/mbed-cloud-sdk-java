package com.arm.mbed.cloud.sdk.common;

import java.util.Map;

import com.arm.mbed.cloud.sdk.annotations.API;
import com.arm.mbed.cloud.sdk.annotations.Internal;
import com.arm.mbed.cloud.sdk.annotations.Preamble;

@Preamble(description = "Generic SDK module definition")
@Internal
public abstract class AbstractModule implements SdkContext {

    public static final String FIELD_NAME_SERVICE_REGISTRY = "serviceRegistry";
    public static final String METHOD_CHECK_NOT_NULL = "checkNotNull";
    public static final String METHOD_CHECK_MODEL_VALIDITY = "checkModelValidity";
    protected final ApiClientWrapper client;
    protected final ServiceRegistry serviceRegistry;

    protected final SdkLogger logger;
    protected final ApiMetadataCache metadataCache;

    /**
     * Constructor.
     *
     * @param options
     *            connection options @see {@link ConnectionOptions}
     */
    public AbstractModule(ConnectionOptions options) {
        this(options, null);
    }

    protected AbstractModule(ApiClientWrapper client) {
        super();
        this.client = client;
        serviceRegistry = new ServiceRegistry(client);
        logger = new SdkLogger();
        metadataCache = new ApiMetadataCache();
    }

    /**
     * Constructor.
     * 
     * @param context
     */
    public AbstractModule(SdkContext context) {
        super();
        this.client = context.getClient();
        this.serviceRegistry = context.getServiceRegistry();
        this.logger = context.getLogger();
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
    public AbstractModule(ConnectionOptions options, Map<String, String> userAgentExtension) {
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

    @Override
    public ServiceRegistry getServiceRegistry() {
        return serviceRegistry;
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
        return serviceRegistry.getService(serviceClass);
    }

    /**
     * Gets the SDK module name.
     *
     * @return module name.
     */
    @Override
    public abstract String getModuleName();

}
