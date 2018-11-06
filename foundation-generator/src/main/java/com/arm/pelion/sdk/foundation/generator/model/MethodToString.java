package com.arm.pelion.sdk.foundation.generator.model;

import java.lang.reflect.Modifier;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

import com.arm.mbed.cloud.sdk.common.listing.ListOptions;
import com.squareup.javapoet.CodeBlock;

public class MethodToString extends AbstractMethodBasedOnModel {

    public MethodToString(Model currentModel, Model parentModel) {
        super(currentModel, parentModel, false, "toString", "Returns a string representation of the object.",
              "@see java.lang.Object#toString()", false, true, false, false,
              currentModel == null ? false : currentModel.needsFieldCustomisation(), false, false, true);
        setReturnType(new ParameterType(String.class));
        setReturnDescription("the string representation");
        setCode(CodeBlock.builder());
    }

    /*
     * (non-Javadoc)
     *
     * @see com.arm.pelion.sdk.foundation.generator.model.Method#translateCode()
     */
    @Override
    protected void translateCode() {
        super.translateCode();
        code.addStatement("return " + generateFullString(currentModel, parentModel, extraFields()));
    }

    // Getting all accessible ListOptions fields
    protected List<Field> extraFields() {
        final List<Field> list = new LinkedList<>();
        Class<?> clazz = ListOptions.class;
        while (clazz != null) {
            final java.lang.reflect.Field[] fields = clazz.getDeclaredFields();
            if (fields != null) {
                Arrays.asList(fields).stream()
                      .filter(f -> Modifier.isPublic(f.getModifiers()) || Modifier.isProtected(f.getModifiers()))
                      .forEach(f -> list.add(new Field(f, true, true, null)));
            }
            clazz = clazz.getSuperclass();
        }
        return list.isEmpty() ? null : list;
    }

    private String generateFullString(Model currentModel, Model parentModel, List<Field> extraFields) {
        if (currentModel == null) {
            return "";
        }
        StringBuilder builder = new StringBuilder();
        builder.append("\"").append(currentModel.getName()).append(" [");
        if (currentModel.hasFields()) {
            builder.append(generateFlattenedListOfElements(currentModel.getFieldList()));
        }
        if (parentModel != null && parentModel.hasFields()) {
            if (currentModel.hasFields()) {
                builder.append(" + \", ");
            }
            builder.append(generateFlattenedListOfElements(parentModel.getFieldList()));
            if (extraFields != null) {
                builder.append(" + \", ");
                builder.append(generateFlattenedListOfElements(extraFields));
            }
        } else {
            if (extraFields != null) {
                if (currentModel.hasFields()) {
                    builder.append(" + \", ");
                }
                builder.append(generateFlattenedListOfElements(extraFields));
            } else {
                if (currentModel.hasFields()) {
                    builder.append(" + \"]\"");
                } else {
                    builder.append("]\"");
                }
            }
        }
        return builder.toString();

    }

    protected String generateFlattenedListOfElements(List<Field> fields) {
        return fields == null ? "" : String.join(System.lineSeparator() + "+ \", ", fields.stream().map(f -> {
            return f.getName() + "=\" + " + f.getName();
        }).collect(Collectors.toList()));
    }
}
