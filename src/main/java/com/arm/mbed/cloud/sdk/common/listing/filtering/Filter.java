package com.arm.mbed.cloud.sdk.common.listing.filtering;

import com.arm.mbed.cloud.sdk.annotations.Preamble;

@Preamble(description = "Filter for listing requests")
public class Filter implements Cloneable {

    protected final String fieldName;
    protected final Object value;
    protected final FilterOperator operator;

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

    public String getPrefix() {
        return null;
    }

    public boolean hasPrefix() {
        return false;
    }

    @Override
    public Filter clone() {
        return new Filter(fieldName, operator, value);
    }

}
