package com.arm.mbed.cloud.sdk.common.listing;

import com.arm.mbed.cloud.sdk.annotations.Preamble;
import com.arm.mbed.cloud.sdk.common.ApiUtils;

@Preamble(description = "Possible optional fields to request when listing")
public class IncludeField {

    private final String str;

    IncludeField(String str) {
        this.str = str;
    }

    @Override
    public String toString() {
        return str;
    }

    public String encode() {
        return ApiUtils.convertCamelToSnake(toString());
    }

}
