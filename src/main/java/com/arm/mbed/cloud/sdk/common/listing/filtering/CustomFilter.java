package com.arm.mbed.cloud.sdk.common.listing.filtering;

public class CustomFilter extends Filter {

    public static final String CUSTOM_ATTRIBUTES_PREFIX = "custom_attributes__";

    public CustomFilter(String fieldName, FilterOperator operator, Object value) {
        super(fieldName, operator, value);
    }

    /*
     * (non-Javadoc)
     * 
     * @see com.arm.mbed.cloud.sdk.common.listing.filtering.Filter#getPrefix()
     */
    @Override
    public String getPrefix() {
        return CUSTOM_ATTRIBUTES_PREFIX;
    }

    /*
     * (non-Javadoc)
     * 
     * @see com.arm.mbed.cloud.sdk.common.listing.filtering.Filter#hasPrefix()
     */
    @Override
    public boolean hasPrefix() {
        return true;
    }

    /*
     * (non-Javadoc)
     * 
     * @see com.arm.mbed.cloud.sdk.common.listing.filtering.Filter#clone()
     */
    @Override
    public CustomFilter clone() {
        return new CustomFilter(fieldName, operator, value);
    }

    public Filter getRawFilter() {
        return super.clone();
    }
}
