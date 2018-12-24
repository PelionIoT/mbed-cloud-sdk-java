package com.arm.mbed.cloud.sdk.common;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.arm.mbed.cloud.sdk.annotations.Internal;
import com.arm.mbed.cloud.sdk.annotations.Preamble;

@Preamble(description = "Logger wrapper for Java SDK")
@Internal
public class SdkLogger {

    private static final Logger LOGGER = LoggerFactory.getLogger("Arm Pelion Cloud SDK");

    public static SdkLogger getLogger() {
        return SdkLoggerHolder.INSTANCE;
    }

    public SdkLogger() {
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

    /**
     * Logs an error.
     *
     * @param message
     *            error message.
     * @param exception
     *            exception causing the error.
     */
    public void logError(String message, Throwable exception) {
        final String exceptionString = exception == null ? "Unknown Reason"
                                                         : exception.getMessage() == null ? "An exception ["
                                                                                            + exception.toString()
                                                                                            + "] was raised"
                                                                                          : exception.getMessage()
                                                                                            + (exception.getCause() == null ? ""
                                                                                                                            : ". Cause: "
                                                                                                                              + exception.getCause());
        LOGGER.error(message + ". Reason: " + exceptionString);
    }

    public void logWarn(String message) {
        LOGGER.warn(message);
    }

    /**
     * Logs a warning.
     *
     * @param message
     *            warning message.
     * @param exception
     *            exception causing the warning.
     */
    public void logWarn(String message, Throwable exception) {
        final String exceptionString = exception == null ? "Unknown Reason"
                                                         : exception.getMessage() == null ? "An exception ["
                                                                                            + exception.toString()
                                                                                            + "] was raised"
                                                                                          : exception.getMessage()
                                                                                            + (exception.getCause() == null ? ""
                                                                                                                            : ". Cause: "
                                                                                                                              + exception.getCause());
        LOGGER.warn(message + ". Reason: " + exceptionString);
    }

    public void throwSdkException(Exception exception) throws MbedCloudException {
        throwCloudException(exception instanceof MbedCloudException ? (MbedCloudException) exception
                                                                    : new MbedCloudException(exception));
    }

    public void throwSdkException(String message, Exception cause) throws MbedCloudException {
        throwCloudException(new MbedCloudException(message, cause));
    }

    public void throwSdkException(String message) throws MbedCloudException {
        throwCloudException(new MbedCloudException(message));
    }

    private void throwCloudException(MbedCloudException exception) throws MbedCloudException {
        logError(exception.getMessage(), exception.getCause());
        throw exception;
    }

    private static class SdkLoggerHolder {
        public static final SdkLogger INSTANCE = new SdkLogger();
    }
}
