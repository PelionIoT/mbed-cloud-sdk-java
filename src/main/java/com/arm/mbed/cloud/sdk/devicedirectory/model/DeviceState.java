package com.arm.mbed.cloud.sdk.devicedirectory.model;

import com.arm.mbed.cloud.sdk.annotations.Preamble;
import com.arm.mbed.cloud.sdk.common.SDKEnum;

@Preamble(description = "The state of the device")
public enum DeviceState implements SDKEnum {
    UNENROLLED("unenrolled"), CLOUD_ENROLLING("cloud_enrolling"), BOOTSTRAPPED("bootstrapped"), REGISTERED(
            "registered"), DEREGISTERED("deregistered");

    private final String value;

    private DeviceState(String string) {
        this.value = string;
    }

    /**
     * @return the string
     */
    @Override
    public String toString() {
        return getString();
    }

    /**
     * @return the string
     */
    @Override
    public String getString() {
        return value;
    }

    @Override
    public boolean isDefault() {
        return this == getDefault();
    }

    public static DeviceState getDefault() {
        return DeviceState.DEREGISTERED;
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
