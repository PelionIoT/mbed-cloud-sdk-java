package com.arm.pelion.sdk.foundation.generator.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import com.arm.mbed.cloud.sdk.common.UuidGenerator;
import com.arm.pelion.sdk.foundation.generator.util.Utils;
import com.mifmif.common.regex.Generex;

public class ValueGenerator {
    public static final String DEFAULT_VALUE = String.valueOf((String) null);

    private ValueGenerator() {

    }

    public static String generateFieldValue(Field field) {
        if (field == null) {
            return DEFAULT_VALUE;
        }
        if (field.getType().isEnum()) {
            return (field.getType().hasClass() ? field.getType().getClazz().getName()
                                               : field.getType().getImportPath().getFullyQualifiedName())
                   + ".getDefault()";

        }
        if (!field.getType().hasClass()) {
            return DEFAULT_VALUE;
        }
        if (field.getType().isString()) {
            if (field.hasPattern()) {
                return "\"" + generateStringBasedOnRegex(field.getPattern()) + "\"";
            }
            return "\"" + generateRandomString() + "\"";
        }
        if (field.getType().isBoolean()) {
            return String.valueOf(Math.random() > 0.5);
        }
        if (field.getType().isDate()) {
            return String.valueOf("new java.util.Date("
                                  + String.valueOf(new Date().getTime() + (long) (Math.random() * 10000)) + "L)");
        }
        if (field.getType().isNumber()) {
            if (field.getType().isDecimal()) {
                final double value = Math.random() * 100000.0;
                return field.getType().isPrimitive() ? String.valueOf(value)
                                                     : "Double.valueOf(" + String.valueOf(value) + ")";
            }
            final int value = (int) (Math.random() * 255) - 128;// A random number which can be a byte, int, or a
            // long;
            if (field.getType().isPrimitive()) {
                return String.valueOf(value);
            } else {
                return (field.getType().isInteger() ? "Integer" : "Long") + ".valueOf(" + String.valueOf(value) + ")";
            }
        }
        return DEFAULT_VALUE;
    }

    public static String generateRandomString() {
        return UuidGenerator.generate();
    }

    private static String generateStringBasedOnRegex(String pattern) {
        String patternToConsider = Utils.applyPatternReverseHack(pattern.trim());
        if (patternToConsider.startsWith("^")) {
            patternToConsider = patternToConsider.substring(1);
        }
        if (patternToConsider.endsWith("$")) {
            patternToConsider = patternToConsider.substring(0, patternToConsider.length() - 1);
        }
        final Generex generex = new Generex(patternToConsider);
        return Utils.applyPatternHack(generex.random()).replace("\"", "").replace("\n", "").replace("\r", "")
                    .replace("\\", "\\\\");
    }

    public static String generateFieldWithInvalidValue(Field field) {
        if (field == null) {
            return null;
        }
        if (field.getType().isString() && field.isRequired()) {
            return null;
        }
        if (field.getType().isString() && field.hasPattern()) {
            final String potentialInvalidRegex = "[^"
                                                 + generateStringBasedOnRegex(field.getPattern()).replaceAll("[\\[\\]\\-\\\"]",
                                                                                                             "")
                                                 + "]{64}";
            String potentialInvalidString = "";
            int trial = 10;
            while (trial > 0) {
                potentialInvalidString += generateStringBasedOnRegex(potentialInvalidRegex);
                if (!potentialInvalidString.matches(field.getPattern())) {
                    return "\"" + potentialInvalidString + "\"";
                }
                trial--;
            }
            return null;
        }
        return generateFieldValue(field);
    }

    public static List<String> generateModelFieldWithInvalidValues(Model model) {
        if (model == null) {
            return null;
        }
        final List<Field> fields = ((AbstractMethodConstructor) model.fetchMethod(fetchConstructor(model))).getAllFields();
        if (fields.stream().filter(f -> f.needsValidation()).count() == 0) {
            return null;
        }

        return fields.stream().map(f -> String.valueOf(generateFieldWithInvalidValue(f))).collect(Collectors.toList());
    }

    public static List<String> generateModelFieldValues(Model model) {
        if (model == null) {
            return new ArrayList<>();
        }
        final List<Field> fields = ((AbstractMethodConstructor) model.fetchMethod(fetchConstructor(model))).getAllFields();
        return fields.stream().map(f -> String.valueOf(generateFieldValue(f))).collect(Collectors.toList());
    }

    private static String fetchConstructor(Model model) {
        return model.getContructorIdentifiers().isEmpty() ? null : model.getContructorIdentifiers().iterator().next();
    }

}
