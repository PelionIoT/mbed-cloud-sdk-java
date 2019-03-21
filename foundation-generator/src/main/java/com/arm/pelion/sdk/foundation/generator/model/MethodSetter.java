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
        if (!field.hasValidation()) {
            return description;
        }
        final Validation validation = field.getValidation();
        final String limitDescription = field.getType().isNumber() ? "value"
                                                                   : field.getType().isString() ? "length of the string"
                                                                                                : "number of elements";
        if (validation.hasPattern()) {
            description = (has(description) ? description + Utils.generateNewDocumentationLine() : "") + "Note: the "
                          + limitDescription + " has to match {@code /" + validation.getPattern() + "/} to be valid";
        }

        if (validation.hasMinimum()) {
            description = (has(description) ? description + Utils.generateNewDocumentationLine() : "") + "Note: the "
                          + limitDescription + " has to be greater than or equal to {@code " + validation.getMinimum()
                          + "} to be valid";
        }
        if (validation.hasMaximum()) {
            description = (has(description) ? description + Utils.generateNewDocumentationLine() : "") + "Note: the "
                          + limitDescription + " has to be less than or equal to {@code " + validation.getMaximum()
                          + "} to be valid";
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
