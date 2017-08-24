package com.arm.mbed.cloud.sdk.common.listing.filtering;

import com.arm.mbed.cloud.sdk.common.SDKEnum;

public enum FilterOperator implements SDKEnum {
    NOT_EQUAL("not equal to", "_neq"), EQUAL("equal to", null), GREATER_THAN("greater than",
            "_gte"), LESS_THAN("less than", "_lte");
    private final String suffix;
    private final String string;

    private FilterOperator(String string, String suffix) {
        this.suffix = suffix;
        this.string = string;
    }

    /**
     * @return the suffix
     */
    public String getSuffix() {
        return suffix;
    }

    @Override
    public boolean isDefault() {
        return this == getDefault();
    }

    public static FilterOperator getDefault() {
        return EQUAL;
    }

    @Override
    public String getString() {
        return string;
    }

    /*
     * (non-Javadoc)
     * 
     * @see java.lang.Enum#toString()
     */
    @Override
    public String toString() {
        return getString();
    }

}
