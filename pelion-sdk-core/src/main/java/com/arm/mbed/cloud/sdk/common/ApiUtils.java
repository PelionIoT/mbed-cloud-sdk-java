package com.arm.mbed.cloud.sdk.common;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;

import com.arm.mbed.cloud.sdk.annotations.Internal;
import com.arm.mbed.cloud.sdk.annotations.Preamble;
import com.arm.mbed.cloud.sdk.annotations.Required;

@Preamble(description = "Utilities for APIs")
@Internal
public class ApiUtils {

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
        if (arg == null) {
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
        if (model == null) {
            return;
        }
        if (model.isValid()) {
            return;
        }

        final Field[] modelFields = model.getClass().getDeclaredFields();

        final List<String> missingFields = new LinkedList<>();

        for (final Field modelField : modelFields) {
            if (modelField.isAnnotationPresent(Required.class)) {
                Object value = null;
                try {
                    modelField.setAccessible(true);
                    value = modelField.get(model);
                } catch (IllegalArgumentException | IllegalAccessException exception) {
                    // Nothing to do
                }
                if (value == null) {
                    missingFields.add(modelField.getName());
                }
            }

        }
        final StringBuilder errorBuilder = missingFields.isEmpty()
                ? generateInvalidModelInstanceErrorMessage(model, argName)
                : generateModelInstanceWithMissingFieldsErrorMessage(model, missingFields, argName);
        logger.throwSdkException(new IllegalArgumentException(errorBuilder.toString()));

    }

    private static StringBuilder generateInvalidModelInstanceErrorMessage(SdkModel model, String argName) {
        final StringBuilder errorBuilder = new StringBuilder(200);
        errorBuilder.append("Parameter [");
        errorBuilder.append(argName);
        errorBuilder.append("] is an invalid instance of ").append(model.getClass().getSimpleName())
                .append(" model. Please ensure all its fields are valid.");
        return errorBuilder;
    }

    private static StringBuilder generateModelInstanceWithMissingFieldsErrorMessage(SdkModel model,
            List<String> missingFields, String argName) {
        final List<String> setters = new LinkedList<>();
        final Method[] modelMethods = model.getClass().getDeclaredMethods();
        for (final Method modelMethod : modelMethods) {
            if (modelMethod.isAnnotationPresent(Required.class)) {
                for (final String missingField : missingFields) {
                    if (modelMethod.getName().toLowerCase(Locale.UK).contains(missingField.toLowerCase(Locale.UK))) {
                        setters.add(modelMethod.getName());
                        break;
                    }
                }
            }
            if (setters.size() == missingFields.size()) {
                break;
            }
        }
        final StringBuilder errorBuilder = new StringBuilder(200);
        boolean start = true;
        errorBuilder.append("Fields [");
        for (final String missingField : missingFields) {
            if (!start) {
                errorBuilder.append(", ");
            }
            errorBuilder.append(missingField);
            start = false;
        }
        errorBuilder.append("] of parameter [");
        errorBuilder.append(argName);
        errorBuilder.append("] are required. Please ensure they get set using the following setters: ");
        start = true;
        for (final String setter : setters) {
            if (!start) {
                errorBuilder.append(", ");
            }
            errorBuilder.append(setter);
            start = false;
        }
        errorBuilder.append('.');
        return errorBuilder;
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
        if (stringToConvert == null || stringToConvert.isEmpty()) {
            return stringToConvert;
        }
        final StringBuffer sb = new StringBuffer();
        boolean start = true;
        final String[] stringElements = stringToConvert.split("_");
        final int numberOfElements = stringElements.length;
        for (final String s : stringElements) {
            if (start) {
                sb.append(capitalAtStart ? Character.toUpperCase(s.charAt(0)) : Character.toLowerCase(s.charAt(0)));
                start = false;
            } else {
                sb.append(Character.toUpperCase(s.charAt(0)));
            }
            if (s.length() > 1) {
                String subString = s.substring(1, s.length());
                if (numberOfElements > 1) {
                    subString = subString.toLowerCase(Locale.getDefault());
                }
                sb.append(subString);
            }
        }
        return sb.toString();
    }

    /**
     * Converts strings from camel to snake case.
     *
     * @param stringToConvert
     *            string to convert
     * @return snake case string.
     */
    public static String convertCamelToSnake(String stringToConvert) {
        if (stringToConvert == null || stringToConvert.isEmpty()) {
            return stringToConvert;
        }
        return stringToConvert.replaceAll("(.)(\\p{Upper})", "$1_$2").replaceAll("(\\p{Upper})(\\p{Upper})", "$1_$2")
                .toLowerCase();
    }

    public interface CaseConverter {
        String convert(String strToConvert, boolean capitalAtStart);
    }

    /**
     * Case conversion types.
     *
     */
    public enum CaseConversion {
        SNAKE_TO_CAMEL, CAMEL_TO_SNAKE
    }

    /**
     * Case converter factory.
     * <p>
     * Gets a case converter from a type.
     *
     * @param conversion
     *            conversion type
     * @return case converter
     */
    public static CaseConverter getCaseConverter(CaseConversion conversion) {
        CaseConverter converter = null;
        switch (conversion) {
            case CAMEL_TO_SNAKE:
                converter = new CaseConverter() {

                    @Override
                    public String convert(String strToConvert, boolean capitalAtStart) {
                        return convertCamelToSnake(strToConvert);
                    }
                };
                break;
            case SNAKE_TO_CAMEL:
                converter = new CaseConverter() {

                    @Override
                    public String convert(String strToConvert, boolean capitalAtStart) {
                        return convertSnakeToCamel(strToConvert, capitalAtStart);
                    }
                };
                break;
            default:
                break;

        }
        return converter;
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
}
