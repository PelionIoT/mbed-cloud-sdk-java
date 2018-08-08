package com.arm.pelion.sdk.foundation.generator.model;

import com.arm.mbed.cloud.sdk.common.ApiUtils;

public class MethodSetter extends Method {

    public MethodSetter(Field field, String longDescription, boolean isInternal) {
        super(false, generateSetterName(field), generateSetterDescription(field),
              generateSetterLongDescription(longDescription, field), false, true, false, field.containsCustomCode(),
              field.needsCustomCode(), isInternal, field.isRequired(), false);
        addParameter(field.toParameter());
        setStatement(generateStatement(field));
    }

    protected String getCallStatement(Parameter setter) {
        return getName() + "(" + String.valueOf(setter == null ? null : setter.getName()) + ");";
    }

    private static String generateSetterLongDescription(String longDescription, Field field) {
        String description = has(longDescription) ? longDescription : field.getLongDescription();
        if (field.hasPattern()) {
            description = description + System.lineSeparator() + "<p>" + System.lineSeparator()
                          + "Note: the value has to match [" + field.getPattern() + "] to be valid";
        }
        return description;
    }

    public String generateStatement(Field field) {
        return "this." + field.getName() + " = " + field.getName() + ";" + System.lineSeparator();
    }

    private static String generateSetterDescription(Field field) {
        return "Sets " + field.getDescription().toLowerCase().trim();
    }

    private static String generateSetterName(Field field) {
        return ApiUtils.convertSnakeToCamel("Set_" + ApiUtils.convertCamelToSnake(field.getName()), false);
    }

}
