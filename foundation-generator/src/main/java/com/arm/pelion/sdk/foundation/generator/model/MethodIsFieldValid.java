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
                              + fetchRegex(field) + "\"))");
            } else {
                checkList.add("(" + field.getName() + " == null || String.valueOf(" + field.getName() + ").matches(\""
                              + fetchRegex(field) + "\"))");
            }
        }
        if (field.hasMinimum()) {
            if (field.getType().isString()) {
                checkList.add("(" + field.getName() + " != null && " + field.getName() + ".length() >= "
                              + field.getMinimum() + ")");
            } else if (field.getType().isList() || field.getType().isHashtable()) {
                checkList.add("(" + field.getName() + " != null && " + field.getName() + ".size() >= "
                              + field.getMinimum() + ")");
            } else if (field.getType().isNumber()) {
                checkList.add("(" + field.getName() + " >= " + field.getMinimum() + ")");
            }
        }
        if (field.hasMaximum()) {
            if (field.getType().isString()) {
                checkList.add("(" + field.getName() + " == null || " + field.getName() + ".length() <= "
                              + field.getMaximum() + ")");
            } else if (field.getType().isList() || field.getType().isHashtable()) {
                checkList.add("(" + field.getName() + " == null || " + field.getName() + ".size() <= "
                              + field.getMaximum() + ")");
            } else if (field.getType().isNumber()) {
                checkList.add("(" + field.getName() + " <= " + field.getMaximum() + ")");
            }
        }
        // TODO add more checks
        return "return " + String.join(System.lineSeparator() + "&& ", checkList);
    }

    @Override
    protected void addAnnotations() {
        super.addAnnotations();
        specificationBuilder.addAnnotation(StaticAnalysisUtils.ignoreUselessParentheses());
    }

    private String fetchRegex(Field field) {
        return field.getPattern();
    }

    private static String generateMethodDescription(Field field) {
        return "Checks whether " + field.getName() + " value is valid";
    }

    private static String generateMethodName(Field field) {
        return Utils.combineNames(false, "is", field.getName(), "valid");
    }

}
