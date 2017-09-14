package com.arm.mbed.cloud.sdk.accountmanagement.model;

import com.arm.mbed.cloud.sdk.annotations.Preamble;
import com.arm.mbed.cloud.sdk.common.SDKEnum;

@Preamble(description = "The status of the API key")
public enum ApiKeyStatus implements SDKEnum {
    ACTIVE, INACTIVE;
    /**
     * States whether it is the default value.
     * 
     * @see SDKEnum#isDefault()
     */
    @Override
    public boolean isDefault() {
        return this == getDefault();
    }

    /**
     * Gets default status.
     * 
     * @return default status.
     */
    public static ApiKeyStatus getDefault() {
        return INACTIVE;
    }

    /**
     * Gets string representation.
     * 
     * @see SDKEnum#getString()
     */
    @Override
    public String getString() {
        return toString();
    }

    /**
     * Merges two statuses.
     * 
     * @see SDKEnum#merge(SDKEnum, SDKEnum)
     */
    @Override
    public <T extends SDKEnum> T merge(T obj1, T obj2) {
        if (obj1 == null) {
            return obj2;
        }
        if (obj2 == null) {
            return obj1;
        }
        if (obj1.isDefault()) {
            return obj2;
        }
        if (obj2.isDefault()) {
            return obj1;
        }
        return obj2;
    }
}
