package com.arm.pelion.sdk.foundation.generator.model;

import java.util.List;
import java.util.stream.Collectors;

import com.arm.mbed.cloud.sdk.common.listing.ListOptions;
import com.arm.mbed.cloud.sdk.common.listing.ListOptionsEncoder;

public class MethodListOptionsToString extends MethodToString {

    public MethodListOptionsToString(Model currentModel, Model parentModel) {
        super(currentModel, parentModel);
    }

    @Override
    protected String generateFlattenedListOfElements(List<Field> fields) {
        return fields == null ? "" : String.join(System.lineSeparator() + "+ \", ", fields.stream().map(f -> {
            final String fieldName = f.getName();
            switch (fieldName) {
                case ListOptions.FIELD_NAME_INCLUDE:
                    return fieldName + "=\" + " + ListOptionsEncoder.METHOD_INCLUDE_TO_STRING + "() ";
                case ListOptions.FIELD_NAME_FILTER:
                    return fieldName + "=\" + " + ListOptions.METHOD_FILTER_TO_STRING + "() ";
                default:
                    return fieldName + "=\" + " + fieldName;
            }

        }).collect(Collectors.toList()));
    }
}
