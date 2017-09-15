package com.arm.mbed.cloud.sdk.common;

import com.arm.mbed.cloud.sdk.annotations.API;
import com.arm.mbed.cloud.sdk.annotations.Internal;
import com.arm.mbed.cloud.sdk.annotations.Preamble;

@Preamble(description = "Generic SDK module definition")
@Internal
public abstract class AbstractApi {

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
        super();
        this.client = new ApiClientWrapper(options);
        logger = new SdkLogger();
        metadataCache = new ApiMetadataCache();
    }

    protected void checkNotNull(Object arg, String argName) throws MbedCloudException {
        ApiUtils.checkNotNull(logger, arg, argName);
    }

    /**
     * Gets SDK logger.
     * 
     * @see SdkLogger
     * @return the logger.
     */
    public SdkLogger getLogger() {
        return logger;
    }

    /**
     * Gets meta data for the last Arm Mbed Cloud API call.
     * 
     * @see ApiMetadata
     * @return metadata
     */
    @API
    public ApiMetadata getLastApiMetadata() {
        return metadataCache.getLastApiMetadata();
    }

    /**
     * Gets the SDK module name.
     * 
     * @return module name.
     */
    public abstract String getModuleName();

}
