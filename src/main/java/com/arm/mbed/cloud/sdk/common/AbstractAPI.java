package com.arm.mbed.cloud.sdk.common;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public abstract class AbstractAPI {

    protected final ApiClientWrapper client;

    protected final Logger logger = LoggerFactory.getLogger("mbed Cloud SDK");

    public AbstractAPI(ConnectionOptions options) {
        super();
        this.client = new ApiClientWrapper(options);
    }

    protected void logInfo(String message) {
        logger.info(message);
    }

    protected void logDebug(String message) {
        logger.debug(message);
    }

    protected void logError(String message) {
        logger.error(message);
    }

    protected void logWarn(String message) {
        logger.warn(message);
    }

    protected void throwSDKException(Exception e) throws MbedCloudException {
        MbedCloudException ex = new MbedCloudException(e);
        logError(ex.getMessage());
        throw ex;
    }

}
