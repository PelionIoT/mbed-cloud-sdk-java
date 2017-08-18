package com.arm.mbed.cloud.sdk.accountmanagement.model;

import com.arm.mbed.cloud.sdk.annotations.Preamble;
import com.arm.mbed.cloud.sdk.common.SDKEnum;

@Preamble(description = "The status of the API key")
public enum ApiKeyStatus implements SDKEnum {
    ACTIVE, INACTIVE;

    @Override
    public boolean isDefault() {
        return this == getDefault();
    }

    public static ApiKeyStatus getDefault() {
        return INACTIVE;
    }

    @Override
    public String getString() {
        return toString();
    }
}
