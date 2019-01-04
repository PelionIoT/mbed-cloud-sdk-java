package com.arm.pelion.sdk.foundation.generator.model;

import com.arm.pelion.sdk.foundation.generator.util.Utils;

public class MethodSetter extends Method {

    public MethodSetter(Field field, String longDescription, boolean isInternal) {
        super(false, generateSetterName(field), generateSetterDescription(field),
              generateSetterLongDescription(longDescription, field), false, true, false, field.containsCustomCode(),
              field.needsCustomCode(), isInternal, field.isRequired(), false);
        addParameter(field.toParameter());
        setStatement(generateStatement(field));
    }

    public MethodSetter(Field field) {
        this(field, null, false);
    }

    protected String getCallStatement(Parameter setter) {
        return getName() + "(" + String.valueOf(setter == null ? null : setter.getName()) + ");";
    }

    private static String generateSetterLongDescription(String longDescription, Field field) {
        String description = has(longDescription) ? longDescription : field.getLongDescription();
        if (field.hasPattern()) {
            description = description + System.lineSeparator() + "<p>" + System.lineSeparator()
                          + "Note: the value has to match {@code /" + field.getPattern() + "/} to be valid";
        }
        return description;
    }

    public String generateStatement(Field field) {
        return "this." + field.getName() + " = " + field.getName() + ";" + System.lineSeparator();
    }

    private static String generateSetterDescription(Field field) {
        return "Sets " + getSetterDecription(field).toLowerCase().trim();
    }

    private static String getSetterDecription(Field field) {
        return field.hasDescription() ? field.getDescription() : field.getName();
    }

    public static String generateSetterName(Field field) {
        return getCorrespondingSetterMethodName(field.getName());
    }

    public static String generateSetterName(Field field, boolean fluent) {
        return getCorrespondingSetterMethodName(field.getName(), fluent);
    }

    public static String getCorrespondingSetterMethodName(String fieldName) {
        return getCorrespondingSetterMethodName(fieldName, false);
    }

    public static String getCorrespondingSetterMethodName(String fieldName, boolean fluent) {
        if (fieldName == null) {
            return null;
        }
        return Utils.combineNames(false, fluent ? "" : "set", fieldName);
    }

}
