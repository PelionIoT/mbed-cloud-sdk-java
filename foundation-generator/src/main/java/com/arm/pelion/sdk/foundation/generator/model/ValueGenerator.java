package com.arm.pelion.sdk.foundation.generator.model;

import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;

import com.arm.mbed.cloud.sdk.common.SdkEnum;
import com.arm.mbed.cloud.sdk.common.UuidGenerator;
import com.arm.pelion.sdk.foundation.generator.util.Utils;
import com.mifmif.common.regex.Generex;

public class ValueGenerator {
    public static final String DEFAULT_VALUE = String.valueOf((String) null);

    private ValueGenerator() {

    }

    public static void addGenerateFieldValue(Field field, Values values) {
        if (field == null) {
            return;
        }
        addGenerateFieldValue(field.getType(), field.hasPattern(), field.getPattern(), field.hasMinimum(),
                              field.getMinimum(), field.hasMaximum(), field.getMaximum(), values);
    }

    public static void addGenerateFieldValue(TypeParameter fieldType, boolean hasPattern, String fieldPattern,
                                             boolean hasMinimum, String fieldMinimum, boolean hasMaximum,
                                             String fieldMaximum, Values values) {

        if (fieldType == null || values == null) {
            return;
        }
        if (fieldType.isEnum()) {
            values.addToFormat("$T.$L()");
            values.addValue(fieldType.hasClass() ? fieldType.getClazz() : fieldType.getTypeName());
            values.addValue(SdkEnum.METHOD_GET_DEFAULT);
            return;

        }
        if (!fieldType.hasClass()) {
            if (fieldType.isModel()) {
                values.addToFormat("new $T()");
                values.addValue(fieldType.hasClass() ? fieldType.getClazz() : fieldType.getTypeName());
                return;
            }
            values.addToFormat(DEFAULT_VALUE);
            return;
        }
        if (fieldType.isString()) {
            values.addToFormat("$S");
            String value = hasPattern ? generateStringBasedOnRegex(fieldPattern) : generateRandomString();
            if (hasMinimum) {
                final int min = Integer.parseInt(fieldMinimum);
                while (value.length() < min) {
                    value += hasPattern ? generateStringBasedOnRegex(fieldPattern) : generateRandomString();
                }
            }
            if (hasMaximum) {
                final int max = Integer.parseInt(fieldMaximum);
                if (value.length() > max) {
                    value = value.substring(0, max - 1);
                }
            }
            values.addValue(value);
            return;
        }
        if (fieldType.isBoolean()) {
            if (fieldType.isPrimitive()) {
                values.addToFormat(String.valueOf(Math.random() > 0.5));
            } else {
                values.addToFormat(Math.random() > 0.5 ? "Boolean.TRUE" : "Boolean.FALSE");
            }
            return;
        }
        if (fieldType.isDate()) {
            values.addToFormat("new $T($LL)");
            values.addValue(Date.class);
            values.addValue(Long.valueOf(new Date().getTime() + (long) (Math.random() * 10000)));
            return;
        }
        if (fieldType.isNumber()) {
            if (fieldType.isDecimal()) {
                double value = Math.random() * (hasMaximum ? Double.parseDouble(fieldMaximum) : 100000.0);
                if (hasMinimum) {
                    value = Math.max(Double.parseDouble(fieldMinimum), value);
                }
                if (fieldType.isPrimitive()) {
                    values.addToFormat("$L");
                } else {
                    values.addToFormat("$T.valueOf($L)");
                    values.addValue(Double.class);
                }
                values.addValue(Double.valueOf(value));
                return;
            }
            int value = (int) (Math.random() * 255) - 128;// A random number which can be a byte, int, or a
            // long;
            if (hasMinimum) {
                value = (int) Math.max(Long.parseLong(fieldMinimum), value);
            }
            if (hasMaximum) {
                value = (int) Math.min(Long.parseLong(fieldMaximum), value);
            }
            if (fieldType.isPrimitive()) {
                values.addToFormat("$L");
            } else {
                values.addToFormat("$T.valueOf($L)");
                values.addValue(fieldType.isInteger() ? Integer.class : Long.class);
            }
            values.addValue(Integer.valueOf(value));
            return;
        }
        values.addToFormat(DEFAULT_VALUE);
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

    public static void addGenerateFieldInvalidValue(Field field, Values values) {
        if (values == null || field == null) {
            return;
        }

        if (field.getType().isString() && field.isRequired()) {
            values.addToFormat(DEFAULT_VALUE);
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
                    values.addToFormat("$S");
                    values.addValue(potentialInvalidString);
                    return;
                }
                trial--;
            }
            values.addToFormat(DEFAULT_VALUE);
            return;
        }
        if (field.hasMaximum()) {
            if (field.getType().isNumber()) {
                values.addToFormat(field.getMaximum() + "+ 1");
                return;
            }
            if (field.getType().isString()) {
                long max = Long.parseLong(field.getMaximum());
                String someRandomString = generateRandomString();
                while (someRandomString.length() < max) {
                    someRandomString += generateRandomString();
                }
                values.addToFormat(someRandomString);
                return;
            }
            // TODO find a way to do hashtables and lists
        }
        if (field.hasMinimum()) {
            if (field.getType().isNumber()) {
                values.addToFormat(field.getMaximum() + "- 1");
                return;
            }
            if (field.getType().isList() || field.getType().isHashtable() || field.getType().isString()) {
                values.addToFormat(DEFAULT_VALUE);
                return;
            }
        }
        addGenerateFieldValue(field, values);
    }

    public static void generateModelFieldWithInvalidValues(Model model, Values values) {
        if (values == null) {
            return;
        }
        final List<Field> fields = ((AbstractMethodConstructor) model.fetchMethod(fetchConstructor(model))).getAllFields();
        if (fields.stream().filter(f -> f.needsValidation()).count() == 0) {
            return;
        }
        fields.forEach(f -> addGenerateFieldInvalidValue(f, values));
    }

    public static void generateModelFieldValues(Model model, Values values) {
        if (values == null) {
            return;
        }
        final List<Field> fields = ((AbstractMethodConstructor) model.fetchMethod(fetchConstructor(model))).getAllFields();
        fields.forEach(f -> addGenerateFieldValue(f, values));
    }

    private static String fetchConstructor(Model model) {
        return model.getContructorIdentifiers().isEmpty() ? null : model.getContructorIdentifiers().stream().findFirst()
                                                                        .orElse(null);
    }

    public static String getJavaDefaultValue(TypeParameter type, String defaultValue) {
        final boolean hasDefaultValue = defaultValue != null && !defaultValue.isEmpty();
        if (type.isBoolean()) {
            if (type.isPrimitive()) {
                return hasDefaultValue ? defaultValue : "false";
            }
            if (!hasDefaultValue) {
                return "Boolean.FALSE";
            }
            if (Boolean.parseBoolean(defaultValue)) {
                return "Boolean.TRUE";
            }
            if ("null".equals(defaultValue.trim().toLowerCase(Locale.UK))) {
                return "null";
            }
            return "Boolean.FALSE";
        }
        if (type.isEnum()) {// TODO ensure the method for getting default type is always valid
            return hasDefaultValue ? type.getShortName() + "." + SdkEnum.METHOD_GET_VALUE_FROM_STRING + "(\""
                                     + defaultValue + "\")"
                                   : type.getShortName() + "." + SdkEnum.METHOD_GET_DEFAULT + "()";
        }
        if (type.isNumber()) {

            final boolean isPrimitive = type.isPrimitive();
            if (!hasDefaultValue || "null".equals(defaultValue.trim().toLowerCase(Locale.UK))) {
                if (type.isInteger()) {
                    return isPrimitive ? "0" : "(Integer) null";
                } else if (type.isDecimal()) {
                    return isPrimitive ? "0.0" : "(Double) null";
                } else {
                    return isPrimitive ? "0L" : "(Long) null";
                }
            }
            if (type.isInteger()) {
                return isPrimitive ? defaultValue : "Integer.valueOf(" + defaultValue + ")";
            } else if (type.isDecimal()) {
                return isPrimitive ? defaultValue.contains(".") ? defaultValue : defaultValue.trim() + ".0"
                                   : "Double.valueOf(" + defaultValue + ")";
            } else {
                return isPrimitive ? defaultValue.contains("L") ? defaultValue : defaultValue.trim() + "L"
                                   : "Long.valueOf(" + defaultValue + ")";
            }

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

    public static class Values {
        final List<String> formats = new LinkedList<>();
        final List<Object> values = new LinkedList<>();

        public List<String> getFormats() {
            return formats;
        }

        public List<Object> getValues() {
            return values;
        }

        public void clear() {
            formats.clear();
            values.clear();
        }

        public boolean hasFormat() {
            return !formats.isEmpty();
        }

        public void setFormat(String format) {
            formats.clear();
            addToFormat(format);
        }

        public void setFormat(List<String> formats) {
            formats.clear();
            addToFormat(formats);
        }

        public void addToFormat(String format) {
            if (format == null) {
                return;
            }
            formats.add(format);
        }

        public void addToFormat(List<String> formats) {
            if (formats == null) {
                return;
            }
            this.formats.addAll(formats);
        }

        public void addValue(Object value) {
            if (value == null) {
                return;
            }
            values.add(value);
        }

        public void addValue(List<Object> values) {
            if (values == null) {
                return;
            }
            this.values.addAll(values);
        }

        public void setValues(Object value) {
            values.clear();
            addValue(value);
        }

        public void setValues(List<Object> values) {
            this.values.clear();
            addValue(values);
        }

        public void add(Values value) {
            if (value == null) {
                return;
            }
            addValue(value.getValues());
            addToFormat(value.getFormats());
        }

        @Override
        public String toString() {
            return "Values [formats=" + formats + ", values=" + values + "]";
        }

    }

}
