package com.arm.pelion.sdk.foundation.generator.model;

import com.arm.mbed.cloud.sdk.common.ApiUtils;

public class MethodGetter extends Method {

    public MethodGetter(Field field, String longDescription, boolean isInternal) {
        super(false, generateGetterName(field), generateGetterDescription(field),
              generateGetterLongDescription(longDescription, field), false, true, false, field.containsCustomCode(),
              field.needsCustomCode(), isInternal, false, false);
        setReturnType(field.getType());
        setReturnDescription(field.getName());
        setStatement(generateStatement(field));
    }

    public MethodGetter(Field field) {
        this(field, null, false);
    }

    private static String generateGetterLongDescription(String longDescription, Field field) {
        return has(longDescription) ? longDescription : field.getLongDescription();
    }

    public String generateStatement(Field field) {
        return "return " + field.getName();
    }

    private static String generateGetterDescription(Field field) {
        return "Gets " + getFieldDescription(field).toLowerCase().trim();
    }

    private static String getFieldDescription(Field field) {
        return field.hasDescription() ? field.getDescription() : field.getName();
    }

    public static String generateGetterName(Field field) {
        return getCorrespondingGetterMethodName(field.getName(), field.getType().isBoolean(), false);
    }

    public static String getCorrespondingGetterMethodName(String fieldName, boolean isBoolean, boolean isFromLowLevel) {
        if (fieldName == null) {
            return null;
        }
        final String snakeCase = ApiUtils.convertCamelToSnake(fieldName);
        String snakeName = "get_" + snakeCase;
        if (isBoolean) {
            snakeName = (!isFromLowLevel && snakeCase.startsWith("is") ? "" : "is_") + snakeCase;
        }
        return ApiUtils.convertSnakeToCamel(snakeName, false);
    }

    protected String getCallStatement() {
        return getName() + "();";
    }

    public static String getCorrespondingFieldName(java.lang.reflect.Method methodOfInterest) {
        if (methodOfInterest == null) {
            return null;
        }
        final String snakeCase = ApiUtils.convertCamelToSnake(methodOfInterest.getName()).replace("get_", "")
                                         .replace("is_", "");
        return ApiUtils.convertSnakeToCamel(snakeCase, false);
    }

}
