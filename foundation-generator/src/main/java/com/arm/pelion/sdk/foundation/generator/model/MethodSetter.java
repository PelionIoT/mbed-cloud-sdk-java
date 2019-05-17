package com.arm.pelion.sdk.foundation.generator.model;

import com.arm.mbed.cloud.sdk.common.SdkEnum;
import com.arm.mbed.cloud.sdk.common.TranslationUtils;
import com.arm.pelion.sdk.foundation.generator.util.TranslationException;
import com.arm.pelion.sdk.foundation.generator.util.Utils;

public class MethodSetter extends MethodOverloaded {

    public MethodSetter(Field field, String longDescription, boolean isInternal, boolean shouldAcceptString) {
        super(false, generateSetterName(field), generateSetterDescription(field),
              generateSetterLongDescription(longDescription, field), false, true, false, field.containsCustomCode(),
              field.needsCustomCode(), isInternal, field.isRequired(), false, null);
        if (shouldAcceptString) {
            Field clone = field.clone();
            clone.setType(TypeFactory.stringType());
            addParameter(clone.toParameter());
            initialiseCodeBuilder();
            generateComplexStatement(field);
        } else {
            addParameter(field.toParameter());
            setStatement(generateStatement(field));
        }
    }

    public MethodSetter(Field field) {
        this(field, null, false, false);
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

    private void generateComplexStatement(Field field) {
        boolean isEnum = field.getType().isEnum();
        String methodName = null;
        if (isEnum) {
            methodName = SdkEnum.METHOD_GET_VALUE_FROM_STRING;
        } else {
            try {
                methodName = MethodMapper.getTranslationMethod(field.getType(), TypeFactory.stringType());
            } catch (TranslationException exception) {
                exception.printStackTrace();
            }
        }

        getCode().addStatement("this.$L = $T.$L($L)", field.getName(),
                               isEnum ? field.getType().hasClass() ? field.getType().getClazz()
                                                                   : field.getType().getTypeName()
                                      : TranslationUtils.class,
                               methodName, field.getName());

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
