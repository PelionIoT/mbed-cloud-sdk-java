package com.arm.mbed.cloud.sdk.common.listing.filtering;

import com.arm.mbed.cloud.sdk.annotations.Preamble;

@Preamble(description = "Filter for listing requests")
public class Filter {

    private final String fieldName;
    private final Object value;
    private final FilterOperator operator;

    public Filter(String fieldName, FilterOperator operator, Object value) {
        super();
        this.fieldName = fieldName;
        this.value = value;
        this.operator = (operator == null) ? FilterOperator.getDefault() : operator;
    }

    /**
     * @return the field name
     */
    public String getFieldName() {
        return fieldName;
    }

    /**
     * @return the value
     */
    public Object getValue() {
        return value;
    }

    /**
     * @return the operator
     */
    public FilterOperator getOperator() {
        return operator;
    }

    public boolean isValid() {
        return (fieldName != null && value != null);
    }

    public String encodeFilter(String field) {
        if (!isValid()) {
            return null;
        }

        StringBuilder builder = new StringBuilder();
        builder.append(field);
        String suffix = operator.getSuffix();
        if (suffix != null) {
            builder.append(suffix);
        }
        builder.append("=");
        builder.append(String.valueOf(value));
        return builder.toString();
    }

    public String encodeFilter() {
        return encodeFilter(fieldName);
    }

}
