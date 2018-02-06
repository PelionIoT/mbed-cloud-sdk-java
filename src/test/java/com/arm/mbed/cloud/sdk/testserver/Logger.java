package com.arm.mbed.cloud.sdk.testserver;

import io.vertx.core.logging.LoggerFactory;

public class Logger {
    private static final boolean CONSOLE_COLOURING = (System.getenv("CONSOLE_COLOURING") == null) ? false : true;
    private static final String LOGGER_DELEGATE_FACTORY_CLASS_NAME_PROPERTY = "vertx.logger-delegate-factory-class-name";
    private static final String LOGGER_DELEGATE_FACTORY_CLASS_NAME = "io.vertx.core.logging.SLF4JLogDelegateFactory";
    static {
        System.setProperty(LOGGER_DELEGATE_FACTORY_CLASS_NAME_PROPERTY, LOGGER_DELEGATE_FACTORY_CLASS_NAME);
    }
    private final io.vertx.core.logging.Logger testLogger;
    private static final String TEST_SERVER_LOG_PREFIX = "  testserver ";
    private static final String INFO_LOG_PREFIX = "\u001B[34m" + TEST_SERVER_LOG_PREFIX + "\u001B[0m";
    private static final String WARNING_LOG_PREFIX = "\u001B[33m" + TEST_SERVER_LOG_PREFIX + "\u001B[0m";
    private static final String ERROR_LOG_PREFIX = "\u001B[31m" + TEST_SERVER_LOG_PREFIX + "\u001B[0m";

    public Logger() {
        testLogger = LoggerFactory.getLogger("Java SDK Test server");
    }

    public void logInfo(String message) {
        testLogger.info((CONSOLE_COLOURING) ? INFO_LOG_PREFIX + message : message);
    }

    public void logError(String message) {
        testLogger.info((CONSOLE_COLOURING) ? ERROR_LOG_PREFIX + message : message);
    }

    public void logDebug(String message) {
        testLogger.debug((CONSOLE_COLOURING) ? INFO_LOG_PREFIX + message : message);
    }

    public void logWarn(String message) {
        testLogger.warn((CONSOLE_COLOURING) ? WARNING_LOG_PREFIX + message : message);
    }
}
