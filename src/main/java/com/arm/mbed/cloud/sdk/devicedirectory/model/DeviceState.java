package com.arm.mbed.cloud.sdk.devicedirectory.model;

import com.arm.mbed.cloud.sdk.annotations.Preamble;
import com.arm.mbed.cloud.sdk.common.SdkEnum;

@Preamble(description = "The state of the device")
public enum DeviceState implements SdkEnum {
    UNENROLLED("unenrolled"), CLOUD_ENROLLING("cloud_enrolling"), BOOTSTRAPPED("bootstrapped"), REGISTERED(
            "registered"), DEREGISTERED("deregistered");

    private final String value;

    /**
     * Constructor.
     * 
     * @param value
     *            string representation.
     */
    private DeviceState(String string) {
        this.value = string;
    }

    /**
     * Gets string representation.
     * 
     * @see Object#toString()
     */
    @Override
    public String toString() {
        return getString();
    }

    /**
     * Gets string representation.
     * 
     * @see SdkEnum#getString()
     */
    @Override
    public String getString() {
        return value;
    }

    /**
     * States whether it is the default value.
     * 
     * @see SdkEnum#isDefault()
     */
    @Override
    public boolean isDefault() {
        return this == getDefault();
    }

    /**
     * Gets default state.
     * 
     * @return default state.
     */
    public static DeviceState getDefault() {
        return DeviceState.DEREGISTERED;
    }

    /**
     * States whether a device in this state is connected.
     * 
     * @return True if this state is equivalent to a connected device. False otherwise.
     */
    public boolean isConnected() {
        return this == getIsConnectedState();
    }

    /**
     * Gets which state corresponds to a connected device.
     * 
     * @return corresponding state.
     */
    public static DeviceState getIsConnectedState() {
        return DeviceState.REGISTERED;
    }

    /**
     * Merges two states.
     * 
     * @see SdkEnum#merge(SdkEnum, SdkEnum)
     */
    @Override
    public <T extends SdkEnum> T merge(T obj1, T obj2) {
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
