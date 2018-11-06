package com.arm.pelion.sdk.foundation.generator.model;

import java.util.List;
import java.util.stream.Collectors;

public class MethodListOptionsToString extends MethodToString {

    private static final String INCLUDE_FIELD_NAME = "include";
    private static final String FILTER_FIELD_NAME = "filter";

    public MethodListOptionsToString(Model currentModel, Model parentModel) {
        super(currentModel, parentModel);
    }

    @Override
    protected List<Field> extraFields() {
        // TODO Auto-generated method stub
        return super.extraFields();
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
