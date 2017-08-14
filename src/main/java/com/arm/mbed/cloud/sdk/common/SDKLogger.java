package com.arm.mbed.cloud.sdk.common;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.arm.mbed.cloud.sdk.annotations.Internal;
import com.arm.mbed.cloud.sdk.annotations.Preamble;

@Preamble(description = "Logger wrapper for Java SDK")
@Internal
public class SDKLogger {

    private final Logger logger = LoggerFactory.getLogger("mbed Cloud SDK");

    public SDKLogger() {
        super();
    }

    public void logInfo(String message) {
        logger.info(message);
    }

    public void logDebug(String message) {
        logger.debug(message);
    }

    public void logError(String message) {
        logger.error(message);
    }

    public void logError(String message, Exception e) {
        String exceptionString = (e == null) ? "Unknown Reason"
                : (e.getMessage() == null) ? "An exception [" + e.toString() + "] was raised" : e.getMessage();
        logger.error(message + ". Reason: " + exceptionString);
    }

    public void logWarn(String message) {
        logger.warn(message);
    }

    public void throwSDKException(Exception e) throws MbedCloudException {
        throwCloudException((e instanceof MbedCloudException) ? (MbedCloudException) e : new MbedCloudException(e));
    }

    public void throwSDKException(String message, Exception cause) throws MbedCloudException {
        throwCloudException(new MbedCloudException(message, cause));
    }

    public void throwSDKException(String message) throws MbedCloudException {
        throwCloudException(new MbedCloudException(message));
    }

    private void throwCloudException(MbedCloudException ex) throws MbedCloudException {
        logError(ex.getMessage());
        throw ex;
    }
}
