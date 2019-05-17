package com.arm.mbed.cloud.sdk.common;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.codec.binary.Hex;

import com.arm.mbed.cloud.sdk.annotations.NonNull;
import com.arm.mbed.cloud.sdk.annotations.Nullable;
import com.arm.mbed.cloud.sdk.annotations.Preamble;
import com.arm.mbed.cloud.sdk.annotations.Required;

@Preamble(description = "SDK Utilities")
public final class SdkUtils {
    private static final String DOUBLE_UNDERSCORE = "__";
    private static final String WHITE_SPACE = " ";
    private static final String UNDERSCORE = "_";
    private static final Pattern JSON_ARRAY_PATTERN = Pattern.compile("\\[([\'\"][\\w-\\s\\S]*[\'\"],?)*\\]");
    private static final String EMPTY_STRING = "";
    public static final String EXTENSION_SEPARATOR = ".";

    private SdkUtils() {
        super();
    }

    /**
     * Parses a string containing a list of elements and returning corresponding Java List.
     *
     * @param listString
     *            String containing a list on elements, either a JSON array or a CSV String.
     * @return list of elements
     */
    public static List<String> parseListString(String listString) {
        if (listString == null) {
            return null;
        }
        if (listString.isEmpty()) {
            return new ArrayList<>();
        }
        final Matcher matcher = JSON_ARRAY_PATTERN.matcher(listString);
        String[] array = null;
        if (matcher.matches()) { // it is a JSON array
            final String aliasArray = matcher.group(1);
            array = aliasArray.replaceAll("[\'\"]", "").split(",");
        } else { // it must be a CSV string
            array = listString.split(",");
        }
        return Arrays.asList(array);
    }

    /**
     * Generates a new String composed of copies of the list elements joined together with a copy of the separator.
     *
     * @param list
     *            list of elements to join
     * @param separator
     *            separator between elements
     * @return corresponding string of joined elements separated by the separator.
     */
    public static String joinList(List<?> list, String separator) {
        if (list == null || list.isEmpty()) {
            return null;
        }
        final StringBuilder buffer = new StringBuilder();
        boolean start = true;
        for (final Object element : list) {
            if (!start) {
                buffer.append(separator);
            }
            buffer.append(toSting(element));
            start = false;
        }
        return buffer.toString();
    }

    private static String toSting(final Object element) {
        if (element == null) {
            return null;
        }
        if (element instanceof SdkEnum) {
            return ((SdkEnum) element).getString();
        }
        if (element instanceof SdkModel) {
            return ((SdkModel) element).getId();
        }
        return element.toString().trim();
    }

    /**
     * Checks whether two URLs are equal.
     *
     * @param url1
     *            one URL
     * @param url2
     *            another URL
     * @return true if the URLs are equal; false otherwise
     */
    public static boolean urlEquals(URL url1, URL url2) {
        if (url1 == null && url2 == null) {
            return true;
        }
        if (url1 == null || url2 == null) {
            return false;
        }
        if (url1.toString() == null) {
            return url2.toString() == null;
        }
        return url1.toString().equals(url2.toString());
    }

    /**
     * Calculates the hashcode of a URL.
     *
     * @param url
     *            a url.
     * @return corresponding hashcode
     */
    public static int urlHashcode(URL url) {
        if (url == null || url.toString() == null) {
            return 0;
        }
        return url.toString().hashCode();
    }

    /**
     * Converts byte array to String.
     * 
     * @param value
     *            byte array
     * @return corresponding hexadecimal string
     */
    public static String toHex(byte[] value) {
        if (value == null) {
            return null;
        }
        return Hex.encodeHexString(value);
    }

    /**
     * Checks model validity
     * 
     * @param model
     *            corresponding model
     * @param argName
     *            model instance name.
     * @return null if model is valid, the error message otherwise.
     */
    public static String checkModelValidity(SdkModel model, String argName) {
        if (model == null) {
            return null;
        }
        if (model.isValid()) {
            return null;
        }

        final List<Field> missingFields = determineMissingFields(model);
        final StringBuilder errorBuilder = missingFields.isEmpty() ? SdkUtils.generateInvalidModelInstanceErrorMessage(model,
                                                                                                                       argName)
                                                                   : SdkUtils.generateModelInstanceRequiredFieldsMessage(model,
                                                                                                                         missingFields,
                                                                                                                         argName);
        return errorBuilder.toString();
    }

    /**
     * Generates a message describing all model required fields.
     * 
     * @param model
     *            model of interest
     * @return corresponding message
     */
    public static String describeRequiredFields(SdkModel model) {
        return generateModelInstanceRequiredFieldsMessage(model, listRequiredFields(model), "model",
                                                          model == null ? SdkModel.class.getSimpleName()
                                                                        : model.getClass().getSimpleName()).toString();
    }

    /**
     * Lists all model required fields.
     * 
     * @param model
     *            corresponding model.
     * @return list of required fields.
     * 
     */
    public static @NonNull List<Field> listRequiredFields(@Nullable SdkModel model) {
        final List<Field> requiredFields = new LinkedList<>();
        if (model == null) {
            return requiredFields;
        }
        for (Class<?> clazz = model.getClass(); clazz != Object.class; clazz = clazz.getSuperclass()) {
            final Field[] fields = clazz.getDeclaredFields();
            for (final Field field : fields) {
                if (field.isAnnotationPresent(Required.class)) {
                    requiredFields.add(field);
                }
            }
        }
        return requiredFields;
    }

    /**
     * Determines a list of unset required fields.
     * 
     * @param model
     *            corresponding model
     * @return list of unset fields
     */
    public static @NonNull List<Field> determineMissingFields(@Nullable SdkModel model) {
        final List<Field> missingFields = new LinkedList<>();
        final List<Field> modelFields = listRequiredFields(model);
        for (final Field modelField : modelFields) {
            Object value = null;
            try {
                modelField.setAccessible(true);
                value = modelField.get(model);
            } catch (@SuppressWarnings("unused") IllegalArgumentException | IllegalAccessException exception) {
                // Nothing to do
            }
            if (value == null) {
                missingFields.add(modelField);
            }
        }
        return missingFields;
    }

    /**
     * Generates an error message for invalid models.
     * 
     * @param model
     *            corresponding model
     * @param argName
     *            model instance name.
     * @return error message
     */
    public static StringBuilder generateInvalidModelInstanceErrorMessage(SdkModel model, String argName) {
        final StringBuilder errorBuilder = new StringBuilder(200);
        errorBuilder.append("Parameter [");
        errorBuilder.append(argName);
        errorBuilder.append("] is an invalid instance of ").append(model.getClass().getSimpleName())
                    .append(" model. Please ensure all its fields are valid. Instance: ").append(model);
        return errorBuilder;
    }

    /**
     * Generates a message for listing model required fields.
     * <p>
     * Determines which fields are required and describes how to set them.
     * 
     * @param model
     *            corresponding model.
     * @param requiredFields
     *            model required fields
     * @param argType
     *            type of the parameter e.g. model, parameter, etc.
     * @param argName
     *            model instance name
     * @return message regarding required fields.
     */
    @SuppressWarnings("PMD.NPathComplexity")
    public static StringBuilder generateModelInstanceRequiredFieldsMessage(SdkModel model, List<Field> requiredFields,
                                                                           String argType, String argName) {
        if (requiredFields == null || requiredFields.isEmpty()) {
            final StringBuilder errorBuilder = new StringBuilder(30);
            errorBuilder.append(argType).append(" [");
            errorBuilder.append(argName);
            errorBuilder.append("] has no required fields.");
            return errorBuilder;
        }
        final List<String> setters = new LinkedList<>();
        final Method[] modelMethods = model.getClass().getMethods();
        for (final Method modelMethod : modelMethods) {
            if (modelMethod.isAnnotationPresent(Required.class)) {
                for (final Field missingField : requiredFields) {
                    if (modelMethod.getName().toLowerCase(Locale.UK)
                                   .contains(missingField.getName().toLowerCase(Locale.UK))) {
                        setters.add(modelMethod.getName());
                        break;
                    }
                }
            }
            if (setters.size() == requiredFields.size()) {
                break;
            }
        }
        final StringBuilder errorBuilder = new StringBuilder(200);
        final boolean plural = requiredFields.size() > 1;
        boolean start = true;
        errorBuilder.append("Field").append(plural ? "s" : "").append(" [");
        for (final Field field : requiredFields) {
            if (!start) {
                errorBuilder.append(", ");
            }
            errorBuilder.append(field.getName());
            start = false;
        }
        errorBuilder.append("] of ").append(argType).append(" [");
        errorBuilder.append(argName);
        errorBuilder.append("] ").append(plural ? "are" : "is").append(" required. Please ensure ")
                    .append(plural ? "they" : "it").append(" get").append(plural ? "" : "s")
                    .append(" set using the following setter").append(plural ? "s" : "").append(": ");
        start = true;
        for (final String setter : setters) {
            if (!start) {
                errorBuilder.append(", ");
            }
            errorBuilder.append(setter);
            start = false;
        }
        errorBuilder.append(". Instance: ");
        errorBuilder.append(model);
        return errorBuilder;
    }

    /**
     * Generates a message for listing model required fields.
     * <p>
     * Determines which fields are required and describes how to set them.
     * 
     * @param model
     *            corresponding model.
     * @param requiredFields
     *            model required fields
     * @param argName
     *            model instance name
     * @return error message
     */
    public static StringBuilder generateModelInstanceRequiredFieldsMessage(SdkModel model, List<Field> requiredFields,
                                                                           String argName) {
        return generateModelInstanceRequiredFieldsMessage(model, requiredFields, "parameter", argName);
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
        final String[] stringElements = stringToConvert.replace(DOUBLE_UNDERSCORE, UNDERSCORE).split(UNDERSCORE);
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
        return stringToConvert.trim().replaceAll("(.)(\\p{Upper})", "$1_$2")
                              .replaceAll("(\\p{Upper})(\\p{Upper})", "$1_$2").replace(WHITE_SPACE, UNDERSCORE)
                              .replace(DOUBLE_UNDERSCORE, UNDERSCORE).toLowerCase(Locale.UK).trim();
    }

    public interface CaseConverter {
        String convert(String strToConvert, boolean capitalAtStart);
    }

    /**
     * Case conversion types.
     *
     */
    public enum CaseConversion {
        SNAKE_TO_CAMEL,
        CAMEL_TO_SNAKE
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
     * Checks whether a file name contains an extension.
     * 
     * @param fileName
     *            file name of interest
     * @return true if there is an extension. false otherwise.
     */
    public static boolean hasExtension(String fileName) {
        return !getFileExtension(fileName).isEmpty();
    }

    /**
     * Retrieves the extension part of a file name.
     * 
     * @param fileName
     *            file name of interest
     * @return the extension part or an empty string if no extension was found
     */
    public static String getFileExtension(String fileName) {
        if (fileName == null || fileName.trim().endsWith(EXTENSION_SEPARATOR)) {
            return EMPTY_STRING;
        }
        final int i = fileName.lastIndexOf('.');
        if (i < 0) {
            return EMPTY_STRING;
        }
        final StringBuilder builder = new StringBuilder();
        final String shorterFilename = fileName.substring(0, i);
        final int j = shorterFilename.lastIndexOf('.');
        // This is an arbitrary constraint on the length of the extension.
        if (j > 0 && shorterFilename.length() - j < 5) {
            builder.append(shorterFilename.substring(j + 1)).append('.');
        }
        builder.append(fileName.substring(i + 1));
        return builder.toString().trim();
    }

    /**
     * Retrieves the file name without the extension part.
     * 
     * @param fileName
     *            file name of interest
     * @return the file name without the extension part.
     */
    public static String getFileNameWithoutExtension(String fileName) {
        if (fileName == null) {
            return EMPTY_STRING;
        }
        return fileName.trim().replace(EXTENSION_SEPARATOR + getFileExtension(fileName), EMPTY_STRING);
    }

}
