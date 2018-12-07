package com.arm.pelion.sdk.foundation.generator.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import com.arm.mbed.cloud.sdk.common.UuidGenerator;
import com.mifmif.common.regex.Generex;

public class ValueGenerator {

    private ValueGenerator() {

    }

    public static String generateFieldValue(Field field) {
        if (field == null) {
            return null;
        }
        if (field.getType().isEnum()) {
            return (field.getType().hasClass() ? field.getType().getClazz().getName()
                                               : field.getType().getImportPath().getFullyQualifiedName())
                   + ".getDefault()";

        }
        if (!field.getType().hasClass()) {
            return null;
        }
        if (field.getType().isString()) {
            if (field.hasPattern()) {
                return "\"" + generateStringBasedOnRegex(field.getPattern()) + "\"";
            }
            return "\"" + UuidGenerator.generate() + "\"";
        }
        if (field.getType().isBoolean()) {
            return String.valueOf(Math.random() > 0.5);
        }
        if (field.getType().isDate()) {
            return String.valueOf("new java.util.Date("
                                  + String.valueOf(new Date().getTime() + (long) (Math.random() * 10000)) + "l)");
        }
        if (field.getType().isNumber()) {
            if (field.getType().isDecimal()) {
                return String.valueOf(Math.random() * 100000.0);
            }
            return String.valueOf((int) (Math.random() * 255) - 128);// A random number wich can be a byte, int, or a
                                                                     // long
        }
        return null;
    }

    private static String generateStringBasedOnRegex(String pattern) {
        final Generex generex = new Generex(pattern);
        return generex.random().replace("$", "$$").replace("\"", "").replace("\n", "").replace("\r", "");
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
