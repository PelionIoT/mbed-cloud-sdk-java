package com.arm.pelion.sdk.foundation.generator.model;

import java.lang.reflect.Modifier;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

import com.arm.mbed.cloud.sdk.common.listing.ListOptions;

public class MethodListOptionsToString extends MethodToString {

    private static final String INCLUDE_FIELD_NAME = "include";
    private static final String FILTER_FIELD_NAME = "filter";

    public MethodListOptionsToString(Model currentModel, Model parentModel) {
        super(currentModel, parentModel);
    }

    // Getting all accessible ListOptions fields
    @Override
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

    @Override
    protected String generateFlattenedListOfElements(List<Field> fields) {
        return fields == null ? "" : String.join(System.lineSeparator() + "+ \", ", fields.stream().map(f -> {
            final String fieldName = f.getName();
            switch (fieldName) {
                case INCLUDE_FIELD_NAME:
                    return fieldName + "=\" + encodeInclude() ";
                case FILTER_FIELD_NAME:
                    return fieldName + "=\" + retrieveFilterAsJson ";
                default:
                    return fieldName + "=\" + " + fieldName;
            }

        }).collect(Collectors.toList()));
    }
}
