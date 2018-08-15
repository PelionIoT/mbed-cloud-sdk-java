package com.arm.mbed.cloud.sdk.common;

import java.util.Map;

import com.arm.mbed.cloud.sdk.annotations.API;
import com.arm.mbed.cloud.sdk.annotations.Internal;
import com.arm.mbed.cloud.sdk.annotations.Preamble;

@Preamble(description = "Generic SDK module definition")
@Internal
public abstract class AbstractApi implements ApiModule {

    protected final ApiClientWrapper client;

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

    /**
     * Constructor.
     *
     * @param options
     *            connection options @see {@link ConnectionOptions}
     * @param userAgentExtension
     *            extension list for the user agent: module name - module version
     */
    public AbstractApi(ConnectionOptions options, Map<String, String> userAgentExtension) {
        super();
        this.client = new ApiClientWrapper(options, userAgentExtension);
        logger = new SdkLogger();
        metadataCache = new ApiMetadataCache();
    }

    protected void checkNotNull(Object arg, String argName) throws MbedCloudException {
        clearApiMetadata();
        ApiUtils.checkNotNull(logger, arg, argName);
    }

    protected void checkModelValidity(SdkModel model, String argName) throws MbedCloudException {
        clearApiMetadata();
        ApiUtils.checkModelValidity(logger, model, argName);
    }

    /* (non-Javadoc)
     * @see com.arm.mbed.cloud.sdk.common.ApiModule#getLogger()
     */
    @Override
    public SdkLogger getLogger() {
        return logger;
    }

    /* (non-Javadoc)
     * @see com.arm.mbed.cloud.sdk.common.ApiModule#getClient()
     */
    @Override
    public ApiClientWrapper getClient() {
        return client;
    }

    /* (non-Javadoc)
     * @see com.arm.mbed.cloud.sdk.common.ApiModule#getLastApiMetadata()
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

    /* (non-Javadoc)
     * @see com.arm.mbed.cloud.sdk.common.ApiModule#getModuleName()
     */
    @Override
    public abstract String getModuleName();

}
