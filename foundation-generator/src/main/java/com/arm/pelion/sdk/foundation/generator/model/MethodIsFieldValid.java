package com.arm.pelion.sdk.foundation.generator.model;

import java.util.LinkedList;
import java.util.List;

import com.arm.pelion.sdk.foundation.generator.util.Utils;

public class MethodIsFieldValid extends Method {

    public MethodIsFieldValid(Field field, boolean isInternal) {
        super(false, generateMethodName(field), generateMethodDescription(field), null, false, true, false,
              field.containsCustomCode(), field.needsCustomCode(), isInternal, false, false);
        setReturnType(TypeFactory.getCorrespondingType(boolean.class));
        setReturnDescription("true if the value is valid; false otherwise.");
        setStatement(generateStatement(field));
    }

    public String generateStatement(Field field) {
        List<String> checkList = new LinkedList<>();
        final Validation validation = field.getValidation();
        if (!validation.isNullable()) {
            checkList.add(field.getName() + " != null");
        }
        final String checkNullOr = validation.isNullable() ? field.getName() + " == null || " : "";
        final String checkNotNullAnd = validation.isNullable() ? field.getName() + " != null && " : "";
        if (validation.hasPattern()) {
            if (field.getType().isString()) {
                checkList.add("(" + checkNullOr + field.getName() + ".matches(\"" + validation.getPattern() + "\"))");
            } else {
                checkList.add("(" + checkNullOr + " String.valueOf(" + field.getName() + ").matches(\""
                              + validation.getPattern() + "\"))");
            }
        }
        if (validation.hasMinimum()) {

            if (field.getType().isString()) {
                checkList.add("(" + checkNotNullAnd + field.getName() + ".length() >= " + validation.getMinimum()
                              + ")");
            } else if (field.getType().isList() || field.getType().isHashtable()) {
                checkList.add("(" + checkNotNullAnd + field.getName() + ".size() >= " + validation.getMinimum() + ")");
            } else if (field.getType().isNumber()) {
                checkList.add("(" + field.getName() + " >= " + validation.getMinimum() + ")");
            }
        }
        if (validation.hasMaximum()) {
            if (field.getType().isString()) {
                checkList.add("(" + checkNullOr + field.getName() + ".length() <= " + validation.getMaximum() + ")");
            } else if (field.getType().isList() || field.getType().isHashtable()) {
                checkList.add("(" + checkNullOr + field.getName() + ".size() <= " + validation.getMaximum() + ")");
            } else if (field.getType().isNumber()) {
                checkList.add("(" + field.getName() + " <= " + validation.getMaximum() + ")");
            }
        }
        // TODO add more checks
        return "return " + String.join(System.lineSeparator() + "&& ", checkList);
    }

    @Override
    protected void addStaticAnalysisAnnotations() {
        annotationRegistry.ignoreUselessParentheses();
        super.addStaticAnalysisAnnotations();
    }

    private static String generateMethodDescription(Field field) {
        return "Checks whether " + field.getName() + " value is valid";
    }

    private static String generateMethodName(Field field) {
        return Utils.combineNames(false, "is", field.getName(), "valid");
    }

}
