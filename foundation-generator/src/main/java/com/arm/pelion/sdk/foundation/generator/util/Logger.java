package com.arm.pelion.sdk.foundation.generator.util;

import org.slf4j.LoggerFactory;

public class Logger {
    private static final org.slf4j.Logger LOGGER = LoggerFactory.getLogger("Foundation Generator");

    public static Logger getLogger() {
        return LoggerHolder.INSTANCE;
    }

    public Logger() {
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

    public void throwGeneratorException(Exception exception) throws FoundationGeneratorException {
        throwException(exception instanceof FoundationGeneratorException ? (FoundationGeneratorException) exception
                                                                         : new FoundationGeneratorException(exception));
    }

    public void throwGeneratorException(String message, Exception cause) throws FoundationGeneratorException {
        throwException(new FoundationGeneratorException(message, cause));
    }

    public void throwGeneratorException(String message) throws FoundationGeneratorException {
        throwException(new FoundationGeneratorException(message));
    }

    private void throwException(FoundationGeneratorException exception) throws FoundationGeneratorException {
        logError(exception.getMessage(), exception.getCause());
        throw exception;
    }

    private static class LoggerHolder {
        public static final Logger INSTANCE = new Logger();
    }
}
