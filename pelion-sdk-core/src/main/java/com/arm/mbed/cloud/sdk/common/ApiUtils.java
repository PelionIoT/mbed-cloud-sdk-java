package com.arm.mbed.cloud.sdk.common;

import java.io.IOException;
import java.net.URL;
import java.net.URLConnection;
import java.util.Date;

import com.arm.mbed.cloud.sdk.annotations.Internal;
import com.arm.mbed.cloud.sdk.annotations.NonNull;
import com.arm.mbed.cloud.sdk.annotations.Nullable;
import com.arm.mbed.cloud.sdk.annotations.Preamble;

@Preamble(description = "Utilities for APIs")
@Internal
public final class ApiUtils {

    private ApiUtils() {
        super();
    }

    /**
     * Ensures that a field is not null.
     *
     * @param logger
     *            logger to report an error if any
     * @param arg
     *            value of the argument
     * @param argName
     *            name of the argument
     * @throws MbedCloudException
     *             if the field is null
     */
    public static void checkNotNull(SdkLogger logger, Object arg, String argName) throws MbedCloudException {
        if (arg == null && logger != null) {
            logger.throwSdkException(new IllegalArgumentException("Argument [" + argName + "] cannot be Null"));
        }
    }

    /**
     * Determines whether all required fields have been set and therefore if the model instance is valid.
     *
     * @param logger
     *            logger to report an error if any
     * @param model
     *            model instance
     * @param argName
     *            name of the argument
     * @throws MbedCloudException
     *             if the model instance is invalid.
     */
    public static void checkModelValidity(SdkLogger logger, SdkModel model, String argName) throws MbedCloudException {
        final String errorMessage = SdkUtils.checkModelValidity(model, argName);
        if (errorMessage == null) {
            return;
        }
        logger.throwSdkException(new IllegalArgumentException(errorMessage));
    }

    /**
     * Checks whether an exception is due to a Cloud exception.
     * 
     * @param exception
     *            exception to check.
     * @return True if the exception is due to a Cloud exception. False otherwise.
     */
    public static boolean isCloudException(Exception exception) {
        return exception == null ? false : exception instanceof MbedCloudException
                                           || exception.getCause() instanceof MbedCloudException;
    }

    /**
     * Checks whether an exception is due to a not implemented functionality.
     * 
     * @param exception
     *            exception to check.
     * @return True if the exception is due to a not implemented functionality. False otherwise.
     */
    public static boolean isNotImplementedException(Exception exception) {
        return exception == null ? false : exception instanceof NotImplementedException
                                           || exception.getCause() instanceof NotImplementedException;
    }

    /**
     * Checks whether an exception is due to a parameter error.
     * 
     * @param exception
     *            exception to check.
     * @return True if the exception is due to a parameter error. False otherwise.
     */
    public static boolean isParameterErrorException(Exception exception) {
        return exception == null ? false : exception instanceof IllegalArgumentException
                                           || exception.getCause() instanceof IllegalArgumentException;
    }

    /**
     * Normalises URL path.
     *
     * @param path
     *            path string
     * @return normalised path
     */
    public static String normalisePath(String path) {
        if (path != null && !path.isEmpty() && path.charAt(0) == '/') {
            return path.substring(1);
        }
        return path;
    }

    /**
     * Normalises resource path.
     * <p>
     * Ensures it starts with a forward slash
     *
     * @param resourcePath
     *            resource path string
     * @return normalised resource path
     */
    public static String normaliseResourcePath(String resourcePath) {
        if (resourcePath != null && (resourcePath.isEmpty() || resourcePath.charAt(0) != '/')) {
            return "/" + resourcePath;
        }
        return resourcePath;
    }

    /**
     * Compares two URL paths.
     *
     * @param path1
     *            path string
     * @param path2
     *            path string
     * @return true if the two paths are equal. False otherwise.
     */
    public static boolean comparePaths(String path1, String path2) {
        final String normalisedPath1 = normalisePath(path1);
        final String normalisedPath2 = normalisePath(path2);
        if (normalisedPath1 == null) {
            return normalisedPath2 == null;
        }
        return normalisedPath1.equals(normalisedPath2);
    }

    /**
     * Converts date into a UTC timestamp string.
     *
     * @param date
     *            date/time
     * @return timestamp in UTC (RFC3339)
     */
    public static String toUtcTimestamp(Date date) {
        return TranslationUtils.toUtcTimestamp(date);
    }

    /**
     *
     * Converts string following RFC3339 into dates.
     *
     * @param valueStr
     *            string representing a date and following RFC3339
     * @return corresponding date
     * @throws MbedCloudException
     *             if string does not follow RFC3339
     */
    public static Date convertStringToDate(String valueStr) throws MbedCloudException {
        return TranslationUtils.convertStringToDate(valueStr);
    }

    /**
     * Converts strings from camel to snake case.
     *
     * @param stringToConvert
     *            string to convert
     * @return snake case string.
     */
    public static String convertCamelToSnake(String stringToConvert) {
        return SdkUtils.convertCamelToSnake(stringToConvert);
    }

    /**
     * Converts strings from snake to camel case.
     *
     * @param stringToConvert
     *            string to convert
     * @param capitalAtStart
     *            should the first letter be a uppercase or not.
     * @return camel case string.
     */
    public static String convertSnakeToCamel(String stringToConvert, boolean capitalAtStart) {
        return SdkUtils.convertSnakeToCamel(stringToConvert, capitalAtStart);
    }

    /**
     * Opens a URL connection using client properties.
     * 
     * @param url
     *            url to connect to.
     * @param client
     *            client to get the properties from.
     * @param logger
     *            logger.
     * @return the opened connection.
     * @throws MbedCloudException
     *             if an exception is raised in the process.
     */
    public static URLConnection openConnection(@NonNull URL url, @Nullable ApiClientWrapper client,
                                               @NonNull SdkLogger logger) throws MbedCloudException {
        checkNotNull(logger, url, "url");
        try {
            final URLConnection connection = url.openConnection();
            if (client != null) {
                connection.setRequestProperty(ApiClientWrapper.USER_AGENT_HEADER,
                                              client.getUserAgent().getUserAgentString());
                connection.setRequestProperty(ApiClientWrapper.AUTHORISATION_HEADER, client.getAuthorisationToken());
            }
            return connection;
        } catch (IOException exception) {
            throw new MbedCloudException(exception);
        }

    }
}
