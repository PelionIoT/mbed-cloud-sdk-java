package utils;

import org.slf4j.LoggerFactory;

public class ExampleLogger {
    private static final org.slf4j.Logger logger = LoggerFactory.getLogger("SDK examples");

    // TODO use a proper logger instead

    public static void logExample(String exampleName, String details) {
        StringBuilder builder = new StringBuilder();
        builder.append("[EXAMPLE]: ");
        builder.append(exampleName).append(" (").append(details).append(")");
        log(builder.toString());
    }

    public static void log(Object obj) {
        log(String.valueOf(obj));
    }

    public static void log(String message) {
        logger.info(message);
    }

    public static void logError(String message) {
        logger.error(message);
    }

}
