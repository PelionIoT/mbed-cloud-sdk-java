package com.arm.mbed.cloud.sdk.subscribe.model;

import com.arm.mbed.cloud.sdk.annotations.Nullable;
import com.arm.mbed.cloud.sdk.annotations.Preamble;
import com.arm.mbed.cloud.sdk.common.SdkEnum;

@Preamble(description = "Device States")
public enum DeviceState implements SdkEnum {
    REGISTRATION("Registrations"),
    REGISTRATION_UPDATE("RegistrationUpdates"),
    DEREGISTRATION("DeRegistrations"),
    EXPIRED_REGISTRATION("ExpiredRegistrations"),
    UNKNOWN_ENUM(SDK_UNKNOWN_ENUM_VALUE);
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
     * States whether it is the default value.
     * 
     * @see SdkEnum#isDefault()
     */
    @Override
    public boolean isDefault() {
        return this == getDefault();
    }

    /**
     * States whether the value is unknown and an error happened during parsing.
     * 
     * @see SdkEnum#isUnknownValue()
     */
    @Override
    public boolean isUnknownValue() {
        return this == getUnknownEnum();
    }

    /**
     * Gets default device state.
     * 
     * @return default state.
     */
    public static DeviceState getDefault() {
        return REGISTRATION;
    }

    /**
     * Gets Unknown state value.
     * 
     * @return unknown state.
     */
    public static DeviceState getUnknownEnum() {
        return UNKNOWN_ENUM;
    }

    /**
     * Gets the device state from its string representation.
     * 
     * @param string
     *            string describing the device state.
     * @return corresponding device state. If not found, default state is returned.
     */
    public static DeviceState getState(@Nullable String string) {
        if (string == null) {
            return getDefault();
        }
        final String trimmedString = string.trim();
        for (final DeviceState state : values()) {
            if (state.toString().equalsIgnoreCase(trimmedString)) {
                return state;
            }
        }
        return getDefault();
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
     * Gets string representation.
     * 
     * @see Object#toString()
     */
    @Override
    public String toString() {
        return getString();
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
