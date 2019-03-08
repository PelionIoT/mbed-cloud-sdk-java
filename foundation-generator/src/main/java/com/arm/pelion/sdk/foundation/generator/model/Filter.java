package com.arm.pelion.sdk.foundation.generator.model;

import com.arm.mbed.cloud.sdk.common.listing.FilterOptions;
import com.arm.mbed.cloud.sdk.common.listing.ListOptions;
import com.arm.mbed.cloud.sdk.common.listing.filtering.FilterOperator;
import com.arm.pelion.sdk.foundation.generator.util.Utils;

public class Filter {

    private String fieldName;
    private TypeParameter fieldType;
    private FilterOperator operator;

    public String getFieldName() {
        return fieldName;
    }

    public void setFieldName(String fieldName) {
        this.fieldName = fieldName;
    }

    public TypeParameter getFieldType() {
        return fieldType;
    }

    public void setFieldType(TypeParameter fieldType) {
        this.fieldType = fieldType;
    }

    public FilterOperator getOperator() {
        return operator;
    }

    public void setOperator(FilterOperator operator) {
        this.operator = operator;
    }

    public boolean correspondsToParameter(Parameter parameter) {
        if (parameter == null) {
            return false;
        }
        return Utils.isSameParameter(parameter.getName(), Utils.combineNames(false, fieldName, operator.getSuffix()));
    }

    public Field getTag() {
        return new Field(true, TypeFactory.getCorrespondingType(String.class),
                         Utils.generateConstantName("tagFilterBy", fieldName), "Tag for filter by " + fieldName, null,
                         null, true, false, true, false, null, false).initialiser("\"" + fieldName + "\"");
    }

    public String getEncodingMethodName() {
        switch (operator) {
            case EQUAL:
                return ListOptions.METHOD_FILTER_ENCODE_EQUAL;
            case GREATER_THAN:
                return ListOptions.METHOD_FILTER_ENCODE_GREATER_THAN;
            case IN:
                return ListOptions.METHOD_FILTER_ENCODE_IN;
            case LESS_THAN:
                return ListOptions.METHOD_FILTER_ENCODE_LESS_THAN;
            case LIKE:
                return ListOptions.METHOD_FILTER_ENCODE_LIKE;
            case NOT_EQUAL:
                return ListOptions.METHOD_FILTER_ENCODE_NOT_EQUAL;
            case NOT_IN:
                return ListOptions.METHOD_FILTER_ENCODE_NOT_IN;
            case UNKNOWN_ENUM:
            default:
                return null;
        }
    }

    public String getAddFilterMethodName() {
        switch (operator) {
            case EQUAL:
                return FilterOptions.METHOD_FILTER_ADD_EQUAL;
            case GREATER_THAN:
                return FilterOptions.METHOD_FILTER_ADD_GREATER_THAN;
            case IN:
                return FilterOptions.METHOD_FILTER_ADD_IN;
            case LESS_THAN:
                return FilterOptions.METHOD_FILTER_ADD_LESS_THAN;
            case LIKE:
                return FilterOptions.METHOD_FILTER_ADD_LIKE;
            case NOT_EQUAL:
                return FilterOptions.METHOD_FILTER_ADD_NOT_EQUAL;
            case NOT_IN:
                return FilterOptions.METHOD_FILTER_ADD_NOT_IN;
            case UNKNOWN_ENUM:
            default:
                return null;
        }
    }

}
