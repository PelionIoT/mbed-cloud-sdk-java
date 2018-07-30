package com.arm.mbed.cloud.sdk.common.listing.filtering;

import com.arm.mbed.cloud.sdk.annotations.Internal;
import com.arm.mbed.cloud.sdk.annotations.Preamble;

@Preamble(description = "Custom filter for listing requests")
public class CustomFilter extends Filter {

    public static final String CUSTOM_ATTRIBUTES_PREFIX = "custom_attributes__";
    public static final String INCORRECT_BUT_ACCEPTED_CUSTOM_ATTRIBUTES_PREFIX = "custom_attribute__";

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
    public CustomFilter(String fieldName, FilterOperator operator, Object value) {
        super(fieldName, operator, value);
    }

    /**
     * Gets filter prefix.
     *
     * @return filter prefix
     * @see Filter#getPrefix()
     */
    @Internal
    @Override
    public String getPrefix() {
        return CUSTOM_ATTRIBUTES_PREFIX;
    }

    /**
     * States whether the filter has a prefix.
     *
     * @return true if it has.
     * @see Filter#hasPrefix()
     */
    @Internal
    @Override
    public boolean hasPrefix() {
        return true;
    }

    /**
     * Gets a clone of the filter.
     *
     * @return a clone.
     * @see Cloneable
     */
    @Override
    public CustomFilter clone() {
        return new CustomFilter(fieldName, operator, value);
    }

    /**
     * Gets parent filter.
     *
     * @return filter
     */
    public Filter getRawFilter() {
        return super.clone();
    }
}
