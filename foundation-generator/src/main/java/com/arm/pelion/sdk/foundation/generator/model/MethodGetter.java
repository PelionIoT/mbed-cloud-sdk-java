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

    private static String generateGetterLongDescription(String longDescription, Field field) {
        return has(longDescription) ? longDescription : field.getLongDescription();
    }

    public String generateStatement(Field field) {
        return "return " + field.getName();
    }

    private static String generateGetterDescription(Field field) {
        return "Gets " + field.getDescription().toLowerCase().trim();
    }

    private static String generateGetterName(Field field) {
        return ApiUtils.convertSnakeToCamel("get_" + ApiUtils.convertCamelToSnake(field.getName()), false);
    }

}
