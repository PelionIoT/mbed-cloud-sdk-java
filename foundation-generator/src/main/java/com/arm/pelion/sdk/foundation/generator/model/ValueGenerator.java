package com.arm.pelion.sdk.foundation.generator.model;

import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;

import com.arm.mbed.cloud.sdk.common.SdkEnum;
import com.arm.mbed.cloud.sdk.common.UuidGenerator;
import com.arm.pelion.sdk.foundation.generator.util.TranslationException;
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
        addGenerateFieldValue(field.getType(), field.getValidation(), values);
    }

    public static void addGenerateFieldValue(TypeParameter fieldType, Validation validation, Values values) {

        if (fieldType == null || values == null) {
            return;
        }
        boolean hasValidation = validation != null;
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
            if (hasValidation) {
                String value = validation.hasPattern() ? generateStringBasedOnRegex(validation.getPattern())
                                                       : generateRandomString();
                if (validation.hasMinimum()) {
                    final int min = Integer.parseInt(validation.getMinimum());
                    while (value.length() < min) {
                        value += validation.hasPattern() ? generateStringBasedOnRegex(validation.getPattern())
                                                         : generateRandomString();
                    }
                }
                if (validation.hasMaximum()) {
                    final int max = Integer.parseInt(validation.getMaximum());
                    if (value.length() > max) {
                        value = value.substring(0, max - 1);
                    }
                }
                values.addValue(value);
                return;

            }
            values.addValue(generateRandomString());
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
                double value = Math.random()
                               * (hasValidation && validation.hasMaximum() ? Double.parseDouble(validation.getMaximum())
                                                                           : 100000.0);
                if (hasValidation && validation.hasMinimum()) {
                    value = Math.max(Double.parseDouble(validation.getMinimum()), value);
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
            if (hasValidation) {
                if (validation.hasMinimum()) {
                    value = (int) Math.max(Long.parseLong(validation.getMinimum()), value);
                }
                if (validation.hasMaximum()) {
                    value = (int) Math.min(Long.parseLong(validation.getMaximum()), value);
                }
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
        if (field.getType().isString() && field.hasValidation() && field.getValidation().hasPattern()) {
            final String potentialInvalidRegex = "[^"
                                                 + generateStringBasedOnRegex(field.getValidation()
                                                                                   .getPattern()).replaceAll("[\\[\\]\\-\\\"]",
                                                                                                             "")
                                                 + "]{64}";
            String potentialInvalidString = "";
            int trial = 10;
            while (trial > 0) {
                potentialInvalidString += generateStringBasedOnRegex(potentialInvalidRegex);
                if (!potentialInvalidString.matches(field.getValidation().getPattern())) {
                    values.addToFormat("$S");
                    values.addValue(potentialInvalidString);
                    return;
                }
                trial--;
            }
            values.addToFormat(DEFAULT_VALUE);
            return;
        }
        if (field.hasValidation() && field.getValidation().hasMaximum()) {
            if (field.getType().isNumber()) {
                values.addToFormat(field.getValidation().getMaximum() + "+ 1");
                return;
            }
            if (field.getType().isString()) {
                long max = Long.parseLong(field.getValidation().getMaximum());
                String someRandomString = generateRandomString();
                while (someRandomString.length() < max) {
                    someRandomString += generateRandomString();
                }
                values.addToFormat("$S");
                values.addValue(someRandomString);
                return;
            }
            // TODO find a way to do hashtables and lists
        }
        if (field.hasValidation() && field.getValidation().hasMinimum()) {
            if (field.getType().isNumber()) {
                values.addToFormat(field.getValidation().getMinimum() + "- 1");
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
        if (fields.stream().filter(f -> f.needsValidation() && !f.isReadOnly()).count() == 0) {
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

    @SuppressWarnings("boxing")
    public static void getJavaDefaultValue(TypeParameter type, String defaultValue, Values values) {
        if (values == null) {
            return;
        }
        final boolean hasDefaultValue = defaultValue != null && !defaultValue.isEmpty();
        try {
            type.translate();
        } catch (TranslationException exception) {
            // Nothing to do
        }
        if (type.isBoolean()) {
            if (type.isPrimitive()) {
                values.addToFormat("$L");
                values.addValue(hasDefaultValue ? defaultValue : false);
                return;
            }
            values.addValue(Boolean.class);
            if (!hasDefaultValue) {
                values.addToFormat("$T.$L");
                values.addValue("FALSE");
                return;
            }
            if (Boolean.parseBoolean(defaultValue)) {
                values.addToFormat("$T.$L");
                values.addValue("TRUE");
                return;
            }
            if ("null".equals(defaultValue.trim().toLowerCase(Locale.UK))) {
                values.addToFormat("($T) $L");
                values.addValue(DEFAULT_VALUE);
                return;
            }
            values.addToFormat("$T.$L");
            values.addValue("FALSE");
            return;
        }
        if (type.isEnum()) {// TODO ensure the method for getting default type is always valid
            values.addValue(type.hasClass() ? type.getClazz() : type.getTypeName());
            if (hasDefaultValue) {
                values.addToFormat("$T.$L($S)");
                values.addValue(SdkEnum.METHOD_GET_VALUE_FROM_STRING);
                values.addValue(defaultValue);
                return;
            }
            values.addToFormat("$T.$L()");
            values.addValue(SdkEnum.METHOD_GET_DEFAULT);
            return;
        }
        if (type.isNumber()) {
            final boolean isPrimitive = type.isPrimitive();
            if (!hasDefaultValue || "null".equals(defaultValue.trim().toLowerCase(Locale.UK))) {
                values.addToFormat(isPrimitive ? "$L" : "($T) $L");
                if (type.isInteger()) {
                    if (isPrimitive) {
                        values.addValue(0);
                        return;
                    }
                    values.addValue(Integer.class);
                    values.addValue(DEFAULT_VALUE);
                    return;
                } else if (type.isDecimal()) {
                    if (isPrimitive) {
                        values.addValue(0.0);
                        return;
                    }
                    values.addValue(Double.class);
                    values.addValue(DEFAULT_VALUE);
                    return;
                } else {
                    if (isPrimitive) {
                        values.addValue(0L);
                        return;
                    }
                    values.addValue(Long.class);
                    values.addValue(DEFAULT_VALUE);
                    return;
                }
            }
            values.addToFormat(isPrimitive ? "$L" : "$T.valueOf($L)");
            if (type.isInteger()) {
                if (isPrimitive) {
                    values.addValue(defaultValue);
                    return;
                }
                values.addValue(Integer.class);
                values.addValue(defaultValue);
                return;
            } else if (type.isDecimal()) {
                if (isPrimitive) {
                    values.addValue(defaultValue.contains(".") ? defaultValue : defaultValue.trim() + ".0");
                    return;
                }
                values.addValue(Double.class);
                values.addValue(defaultValue);
                return;
            }
            if (isPrimitive) {
                values.addValue(defaultValue.contains("L") ? defaultValue : defaultValue.trim() + "L");
                return;
            }
            values.addValue(Long.class);
            values.addValue(defaultValue);
            return;
        }
        if (type.isDate()) {
            // TODO ensure the default date value is called now

            if (!hasDefaultValue || defaultValue.toLowerCase(Locale.UK).contains("now")) {
                values.addToFormat("new $T()");
                values.addValue(Date.class);
                return;
            }
            values.addToFormat("$L");
            values.addValue(defaultValue);
            return;
        }
        if (type.isString()) {
            if (hasDefaultValue) {
                values.addToFormat("$S");
                values.addValue(defaultValue);
                return;
            }

            values.addToFormat("($T) $L");
            values.addValue(String.class);
            values.addValue(DEFAULT_VALUE);
            return;
        }
        if (hasDefaultValue) {
            values.addToFormat("$L");
            values.addValue(defaultValue);
            return;
        }
        values.addToFormat("($T) $L");
        values.addValue(type.hasClass() ? type.getClazz() : type.getTypeName());
        values.addValue(DEFAULT_VALUE);
        return;
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

        public Object[] getValuesArray() {
            return getValues().toArray();
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
