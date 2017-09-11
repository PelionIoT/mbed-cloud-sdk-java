package com.arm.mbed.cloud.sdk.common;

import com.arm.mbed.cloud.sdk.annotations.API;
import com.arm.mbed.cloud.sdk.annotations.Preamble;

@Preamble(description = "Generic SDK module definition")
public abstract class AbstractAPI {

    protected final ApiClientWrapper client;

    protected final SDKLogger logger;
    protected final ApiMetadataCache metadataCache;

    public AbstractAPI(ConnectionOptions options) {
        super();
        this.client = new ApiClientWrapper(options);
        logger = new SDKLogger();
        metadataCache = new ApiMetadataCache();
    }

    protected void checkNotNull(Object arg, String argName) throws MbedCloudException {
        ApiUtils.checkNotNull(logger, arg, argName);
    }

    /**
     * @return the logger
     */
    public SDKLogger getLogger() {
        return logger;
    }

    /**
     * Get meta data for the last Arm Mbed Cloud API call
     * 
     * @return metadata
     */
    @API
    public ApiMetadata getLastApiMetadata() {
        return metadataCache.getLastApiMetadata();
    }

    public abstract String getModuleName();

}
