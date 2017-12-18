package com.arm.mbed.cloud.sdk.common.listing.filtering;

import com.arm.mbed.cloud.sdk.annotations.Internal;
import com.arm.mbed.cloud.sdk.annotations.Preamble;

@Preamble(description = "Filter for listing requests")
public class Filter implements Cloneable {

    protected final String fieldName;
    protected final Object value;
    protected final FilterOperator operator;

    /**
     * Constructor.
     * 
     * @param fieldName
     *            field on which the filter applies
     * @param operator
     *            filter operator {@link FilterOperator}
     * @param value
     *            filter value to apply
     */
    public Filter(String fieldName, FilterOperator operator, Object value) {
        super();
        this.fieldName = fieldName;
        this.value = value;
        this.operator = (operator == null) ? FilterOperator.getDefault() : operator;
    }

    /**
     * Gets the name of the field the filter applies to.
     * 
     * @return the field name
     */
    public String getFieldName() {
        return fieldName;
    }

    /**
     * Gets the value of the filter.
     * 
     * @return the value
     */
    public Object getValue() {
        return value;
    }

    /**
     * Gets the filter operator.
     * 
     * @see FilterOperator for more information about operators.
     * @return the operator
     */
    public FilterOperator getOperator() {
        return operator;
    }

    /**
     * States whether the definition of the filter is correct.
     * 
     * @return true if the filter is valid
     */
    public boolean isValid() {
        return fieldName != null && value != null;
    }

    /**
     * Gets filter prefix.
     * 
     * @return filter prefix
     */
    @Internal
    public String getPrefix() {
        return null;
    }

    /**
     * States whether the filter has a prefix.
     * 
     * @return true if it has.
     */
    @Internal
    public boolean hasPrefix() {
        return false;
    }

    /**
     * Gets a clone of the filter.
     * 
     * @return a clone.
     * @see Cloneable
     */
    @Override
    public Filter clone() {
        return new Filter(fieldName, operator, value);
    }

}
