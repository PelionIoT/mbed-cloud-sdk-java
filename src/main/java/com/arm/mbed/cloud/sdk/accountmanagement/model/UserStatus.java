package com.arm.mbed.cloud.sdk.accountmanagement.model;

import com.arm.mbed.cloud.sdk.annotations.Preamble;
import com.arm.mbed.cloud.sdk.common.SDKEnum;

@Preamble(description = "The status of the user")
public enum UserStatus implements SDKEnum {
    ENROLLING, INVITED, ACTIVE, RESET, INACTIVE;
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
     * Gets default user status.
     * 
     * @return default status.
     */
    public static final UserStatus getDefault() {
        return UserStatus.INACTIVE;
    }

    /**
     * Gets the string representation of the user status.
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
