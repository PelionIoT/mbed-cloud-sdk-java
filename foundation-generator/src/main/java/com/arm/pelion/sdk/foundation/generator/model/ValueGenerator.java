package com.arm.pelion.sdk.foundation.generator.model;

import java.util.Date;
import java.util.List;

import com.arm.mbed.cloud.sdk.common.SdkEnum;
import com.arm.mbed.cloud.sdk.common.UuidGenerator;
import com.arm.pelion.sdk.foundation.generator.util.Utils;
import com.mifmif.common.regex.Generex;

public class ValueGenerator {
    public static final String DEFAULT_VALUE = String.valueOf((String) null);

    private ValueGenerator() {

    }

    // public static String generateFieldValue(Field field) {
    // if (field == null) {
    // return DEFAULT_VALUE;
    // }
    // if (field.getType().isEnum()) {
    // return (field.getType().hasClass() ? field.getType().getClazz().getName()
    // : field.getType().getImportPath().getFullyQualifiedName())
    // + ".getDefault()";
    //
    // }
    // if (!field.getType().hasClass()) {
    // return DEFAULT_VALUE;
    // }
    // if (field.getType().isString()) {
    // if (field.hasPattern()) {
    // return "\"" + generateStringBasedOnRegex(field.getPattern()) + "\"";
    // }
    // return "\"" + generateRandomString() + "\"";
    // }
    // if (field.getType().isBoolean()) {
    // return String.valueOf(Math.random() > 0.5);
    // }
    // if (field.getType().isDate()) {
    // return String.valueOf("new java.util.Date("
    // + String.valueOf(new Date().getTime() + (long) (Math.random() * 10000)) + "L)");
    // }
    // if (field.getType().isNumber()) {
    // if (field.getType().isDecimal()) {
    // final double value = Math.random() * 100000.0;
    // return field.getType().isPrimitive() ? String.valueOf(value)
    // : "Double.valueOf(" + String.valueOf(value) + ")";
    // }
    // final int value = (int) (Math.random() * 255) - 128;// A random number which can be a byte, int, or a
    // // long;
    // if (field.getType().isPrimitive()) {
    // return String.valueOf(value);
    // } else {
    // return (field.getType().isInteger() ? "Integer" : "Long") + ".valueOf(" + String.valueOf(value) + ")";
    // }
    // }
    // return DEFAULT_VALUE;
    // }

    public static void addGenerateFieldValue(Field field, List<String> formats, List<Object> values) {
        if (formats == null || values == null || field == null) {
            return;
        }
        if (field.getType().isEnum()) {
            formats.add("$T.$L()");
            values.add(field.getType().hasClass() ? field.getType().getClazz() : field.getType().getTypeName());
            values.add(SdkEnum.METHOD_GET_DEFAULT);
            return;

        }
        if (!field.getType().hasClass()) {
            if (field.getType().isModel()) {
                formats.add("new $T()");
                values.add(field.getType().hasClass() ? field.getType().getClazz() : field.getType().getTypeName());
                return;
            }
            formats.add(DEFAULT_VALUE);
            return;
        }
        if (field.getType().isString()) {
            formats.add("$S");
            if (field.hasPattern()) {
                values.add(generateStringBasedOnRegex(field.getPattern()));
                return;
            }
            values.add(generateRandomString());
            return;
        }
        if (field.getType().isBoolean()) {
            formats.add(String.valueOf(Math.random() > 0.5));
            return;
        }
        if (field.getType().isDate()) {
            formats.add("new $T($LL)");
            values.add(Date.class);
            values.add(Long.valueOf(new Date().getTime() + (long) (Math.random() * 10000)));
            return;
        }
        if (field.getType().isNumber()) {
            if (field.getType().isDecimal()) {
                final double value = Math.random() * 100000.0;
                if (field.getType().isPrimitive()) {
                    formats.add("$L");
                } else {
                    formats.add("$T.valueOf($L)");
                    values.add(Double.class);
                }
                values.add(Double.valueOf(value));
                return;
            }
            final int value = (int) (Math.random() * 255) - 128;// A random number which can be a byte, int, or a
            // long;
            if (field.getType().isPrimitive()) {
                formats.add("$L");
            } else {
                formats.add("$T.valueOf($L)");
                values.add(field.getType().isInteger() ? Integer.class : Long.class);
            }
            values.add(Integer.valueOf(value));
            return;
        }
        formats.add(DEFAULT_VALUE);
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

    // public static String generateFieldWithInvalidValue(Field field) {
    // if (field == null) {
    // return null;
    // }
    // if (field.getType().isString() && field.isRequired()) {
    // return null;
    // }
    // if (field.getType().isString() && field.hasPattern()) {
    // final String potentialInvalidRegex = "[^"
    // + generateStringBasedOnRegex(field.getPattern()).replaceAll("[\\[\\]\\-\\\"]",
    // "")
    // + "]{64}";
    // String potentialInvalidString = "";
    // int trial = 10;
    // while (trial > 0) {
    // potentialInvalidString += generateStringBasedOnRegex(potentialInvalidRegex);
    // if (!potentialInvalidString.matches(field.getPattern())) {
    // return "\"" + potentialInvalidString + "\"";
    // }
    // trial--;
    // }
    // return null;
    // }
    // return generateFieldValue(field);
    // }

    public static void addGenerateFieldInvalidValue(Field field, List<String> formats, List<Object> values) {
        if (formats == null || values == null || field == null) {
            return;
        }

        if (field.getType().isString() && field.isRequired()) {
            formats.add(DEFAULT_VALUE);
            return;
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
                    formats.add("$S");
                    values.add(potentialInvalidString);
                    return;
                }
                trial--;
            }
            formats.add(DEFAULT_VALUE);
            return;
        }
        addGenerateFieldValue(field, formats, values);
    }

    // public static List<String> generateModelFieldWithInvalidValues(Model model) {
    // if (model == null) {
    // return null;
    // }
    // final List<Field> fields = ((AbstractMethodConstructor)
    // model.fetchMethod(fetchConstructor(model))).getAllFields();
    // if (fields.stream().filter(f -> f.needsValidation()).count() == 0) {
    // return null;
    // }
    //
    // return fields.stream().map(f -> String.valueOf(generateFieldWithInvalidValue(f))).collect(Collectors.toList());
    // }

    // public static List<String> generateModelFieldValues(Model model) {
    // if (model == null) {
    // return new ArrayList<>();
    // }
    // final List<Field> fields = ((AbstractMethodConstructor)
    // model.fetchMethod(fetchConstructor(model))).getAllFields();
    // return fields.stream().map(f -> String.valueOf(generateFieldValue(f))).collect(Collectors.toList());
    // }
    public static void generateModelFieldWithInvalidValues(Model model, List<String> formats, List<Object> values) {
        if (formats == null || values == null) {
            return;
        }
        final List<Field> fields = ((AbstractMethodConstructor) model.fetchMethod(fetchConstructor(model))).getAllFields();
        if (fields.stream().filter(f -> f.needsValidation()).count() == 0) {
            return;
        }
        fields.forEach(f -> addGenerateFieldInvalidValue(f, formats, values));
    }

    public static void generateModelFieldValues(Model model, List<String> formats, List<Object> values) {
        if (formats == null || values == null) {
            return;
        }
        final List<Field> fields = ((AbstractMethodConstructor) model.fetchMethod(fetchConstructor(model))).getAllFields();
        fields.forEach(f -> addGenerateFieldValue(f, formats, values));
    }

    private static String fetchConstructor(Model model) {
        return model.getContructorIdentifiers().isEmpty() ? null : model.getContructorIdentifiers().stream().findFirst()
                                                                        .orElse(null);
    }

    public static String getJavaDefaultValue(TypeParameter type, String defaultValue) {
        final boolean hasDefaultValue = defaultValue != null && !defaultValue.isEmpty();
        if (type.isBoolean()) {
            final StringBuilder builder = new StringBuilder();
            if (!type.isPrimitive()) {
                builder.append("Boolean.valueOf(");
            }
            builder.append(hasDefaultValue ? defaultValue : "false");
            if (!type.isPrimitive()) {
                builder.append(")");
            }
            return builder.toString();
        }
        if (type.isEnum()) {// TODO ensure the method for getting default type is always valid
            return hasDefaultValue ? type.getShortName() + "." + SdkEnum.METHOD_GET_VALUE_FROM_STRING + "(\""
                                     + defaultValue + "\")"
                                   : type.getShortName() + "." + SdkEnum.METHOD_GET_DEFAULT + "()";
        }
        if (type.isNumber()) {

            final boolean isPrimitive = type.isPrimitive();
            if ("null".equals(defaultValue)) {
                return isPrimitive ? type.isInteger() ? "0" : type.isDecimal() ? "0.0" : "0L" : defaultValue;
            }
            final StringBuilder builder = new StringBuilder();
            if (!isPrimitive) {
                if (type.isInteger()) {
                    builder.append("Integer.valueOf(");
                } else if (type.isDecimal()) {
                    builder.append("Double.valueOf(");
                } else {
                    builder.append("Long.valueOf(");
                }
            }

            builder.append(hasDefaultValue ? defaultValue : type.isInteger() ? "0" : type.isDecimal() ? "0.0" : "0L");
            if (!isPrimitive) {
                builder.append(")");
            }
            return builder.toString();
        }
        if (type.isDate()) {// TODO ensure the default date value is called now
            return hasDefaultValue ? defaultValue.contains("now") ? "new java.util.Date()" : defaultValue
                                   : "new java.util.Date()";
        }
        if (type.isString()) {
            return hasDefaultValue ? "\"" + defaultValue + "\"" : "(String) null";
        }
        if (type.isHashtable() || type.isList()) {
            return hasDefaultValue ? defaultValue : "(" + type.getFullyQualifiedName() + ") null";
        }

        return hasDefaultValue ? defaultValue : "(" + type.getShortName() + ") null";
    }

}
