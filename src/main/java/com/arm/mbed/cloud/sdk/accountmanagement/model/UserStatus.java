package com.arm.mbed.cloud.sdk.accountmanagement.model;

import com.arm.mbed.cloud.sdk.annotations.Preamble;
import com.arm.mbed.cloud.sdk.common.SDKEnum;

@Preamble(description = "The status of the user")
public enum UserStatus implements SDKEnum {
    ENROLLING, INVITED, ACTIVE, RESET, INACTIVE;

    @Override
    public boolean isDefault() {
        return this == getDefault();
    }

    public static final UserStatus getDefault() {
        return UserStatus.INACTIVE;
    }

    @Override
    public String getString() {
        return toString();
    }
}
