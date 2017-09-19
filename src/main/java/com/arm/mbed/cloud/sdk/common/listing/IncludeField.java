package com.arm.mbed.cloud.sdk.common.listing;

import com.arm.mbed.cloud.sdk.annotations.Preamble;
import com.arm.mbed.cloud.sdk.common.ApiUtils;

@Preamble(description = "Possible optional fields to request when listing")
public class IncludeField {

    private final String str;

    /**
     * Constructor.
     * 
     * @param str
     *            field string
     */
    public IncludeField(String str) {
        this.str = str;
    }

    /**
     * Gets field string.
     * 
     * @return string representation.
     */
    @Override
    public String toString() {
        return str;
    }

    /**
     * Encodes include field to snake case.
     * 
     * @return processed string.
     */
    public String encode() {
        return ApiUtils.convertCamelToSnake(toString());
    }

}
