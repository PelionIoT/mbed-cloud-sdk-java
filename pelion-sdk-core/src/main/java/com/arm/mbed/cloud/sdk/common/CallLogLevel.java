package com.arm.mbed.cloud.sdk.common;

import com.arm.mbed.cloud.sdk.annotations.Preamble;

@Preamble(description = "Log level of the http communications between client and Arm Pelion Cloud")
public enum CallLogLevel {
    /**
     * No HTTP logs are logged.
     */
    NONE,
    /**
     * Logs request and response lines.
     * <p>
     * See HttpLoggingInterceptor (https://github.com/square/okhttp/tree/master/okhttp-logging-interceptor) for more
     * information
     */
    BASIC,
    /**
     * Logs request and response lines and their respective headers.
     * <p>
     * See HttpLoggingInterceptor (https://github.com/square/okhttp/tree/master/okhttp-logging-interceptor) for more
     * information
     */
    HEADERS,
    /**
     * Logs request and response lines and their respective headers and bodies (if present).
     * <p>
     * See HttpLoggingInterceptor (https://github.com/square/okhttp/tree/master/okhttp-logging-interceptor) for more
     * information
     */
    BODY;
    /**
     * Gets the log level from a string.
     * 
     * @param level
     *            string
     * @return corresponding log level. If not found, no logging will be performed.
     */
    public static CallLogLevel getLevel(String level) {
        if (level == null || level.isEmpty()) {
            return NONE;
        }
        final String trimmedLevel = level.trim();
        for (final CallLogLevel logLevel : values()) {
            if (logLevel.toString().equalsIgnoreCase(trimmedLevel)) {
                return logLevel;
            }
        }
        return NONE;
    }
}
