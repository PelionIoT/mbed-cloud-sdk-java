package com.arm.mbed.cloud.sdk.common;

import com.arm.mbed.cloud.sdk.annotations.Preamble;

@Preamble(description = "Log level of the http communications between client and Arm Mbed Cloud")
public enum CallLogLevel {
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
