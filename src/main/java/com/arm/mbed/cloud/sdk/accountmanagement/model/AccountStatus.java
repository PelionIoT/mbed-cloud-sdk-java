/**
 * 
 */
package com.arm.mbed.cloud.sdk.accountmanagement.model;

import com.arm.mbed.cloud.sdk.annotations.Preamble;
import com.arm.mbed.cloud.sdk.common.SDKEnum;

@Preamble(description = "The status of the account")
public enum AccountStatus implements SDKEnum {

    ENROLLING, ACTIVE, SUSPENDED, RESTRICTED;

    @Override
    public boolean isDefault() {
        return this == getDefault();
    }

    public static AccountStatus getDefault() {
        return AccountStatus.SUSPENDED;
    }

    @Override
    public String getString() {
        return toString();
    }

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
