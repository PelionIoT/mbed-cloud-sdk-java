package com.arm.mbed.cloud.sdk.common;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.arm.mbed.cloud.sdk.annotations.Internal;
import com.arm.mbed.cloud.sdk.annotations.Preamble;

@Preamble(description = "Logger wrapper for Java SDK")
@Internal
public class SDKLogger {

    private static final Logger LOGGER = LoggerFactory.getLogger("Arm Mbed Cloud SDK");

    public static SDKLogger getLogger() {
        return SDKLoggerHolder.INSTANCE;
    }

    public SDKLogger() {
        super();
    }

    public void logInfo(String message) {
        LOGGER.info(message);
    }

    public void logDebug(String message) {
        LOGGER.debug(message);
    }

    public void logError(String message) {
        LOGGER.error(message);
    }

    public void logError(String message, Throwable e) {
        final String exceptionString = e == null ? "Unknown Reason"
                : e.getMessage() == null ? "An exception [" + e.toString() + "] was raised"
                        : e.getMessage() + (e.getCause() == null ? "" : ". Cause: " + e.getCause());
        LOGGER.error(message + ". Reason: " + exceptionString);
    }

    public void logWarn(String message) {
        LOGGER.warn(message);
    }

    public void throwSDKException(Exception exception) throws MbedCloudException {
        throwCloudException(exception instanceof MbedCloudException ? (MbedCloudException) exception
                : new MbedCloudException(exception));
    }

    public void throwSDKException(String message, Exception cause) throws MbedCloudException {
        throwCloudException(new MbedCloudException(message, cause));
    }

    public void throwSDKException(String message) throws MbedCloudException {
        throwCloudException(new MbedCloudException(message));
    }

    private void throwCloudException(MbedCloudException exception) throws MbedCloudException {
        logError(exception.getMessage(), exception.getCause());
        throw exception;
    }

    private static class SDKLoggerHolder {
        public final static SDKLogger INSTANCE = new SDKLogger();
    }
}
