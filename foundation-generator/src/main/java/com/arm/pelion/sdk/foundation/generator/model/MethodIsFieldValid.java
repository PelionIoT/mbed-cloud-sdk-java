package com.arm.pelion.sdk.foundation.generator.model;

import java.util.LinkedList;
import java.util.List;

import com.arm.mbed.cloud.sdk.common.ApiUtils;

public class MethodIsFieldValid extends Method {

    public MethodIsFieldValid(Field field, boolean isInternal) {
        super(false, generateMethodName(field), generateMethodDescription(field), null, false, true, false,
              field.containsCustomCode(), field.needsCustomCode(), isInternal, false, false);
        setReturnType(new ParameterType(boolean.class));
        setReturnDescription("true if the value is valid; false otherwise.");
        setStatement(generateStatement(field));
    }

    private static String generateGetterLongDescription(String longDescription, Field field) {
        return has(longDescription) ? longDescription : field.getLongDescription();
    }

    public String generateStatement(Field field) {
        List<String> checkList = new LinkedList<>();
        if (field.isRequired()) {
            checkList.add(field.getName() + " != null");
        }
        if (field.hasPattern()) {
            if (field.getType().isString()) {
                checkList.add("(" + field.getName() + " == null || " + field.getName() + ".matches(\""
                              + field.getPattern() + "\"))");
            } else {
                checkList.add("(" + field.getName() + " == null || String.valueOf(" + field.getName() + ").matches(\""
                              + field.getPattern() + "\"))");
            }
        }
        // TODO add more checks
        return "return " + String.join(System.lineSeparator() + "&& ", checkList);
    }

    private static String generateMethodDescription(Field field) {
        return "Checks whether " + field.getName() + " value is valid";
    }

    private static String generateMethodName(Field field) {
        return ApiUtils.convertSnakeToCamel("is_" + ApiUtils.convertCamelToSnake(field.getName()) + "_valid", false);
    }

}
