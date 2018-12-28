package com.arm.mbed.cloud.sdk.update.model;

import com.arm.mbed.cloud.sdk.annotations.Preamble;
import com.arm.mbed.cloud.sdk.common.SdkEnum;

@Preamble(description = "Device state")
public enum DeviceState implements SdkEnum {

    PENDING("pending"),
    UPDATED_CONNECTOR_CHANNEL("updated_connector_channel"),
    FAILED_CONNECTOR_CHANNEL_UPDATE("failed_connector_channel_update"),
    DEPLOYED("deployed"),
    MANIFEST_REMOVED("manifestremoved"),
    DEREGISTERED("deregistered"),
    UNKNOWN_ENUM(SDK_UNKNOWN_ENUM_VALUE);

    private final String value;

    /**
     * Constructor.
     * 
     * @param value
     *            string representation.
     */
    private DeviceState(String value) {
        this.value = value;
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
     * Gets string representation.
     * 
     * @see SdkEnum#getString()
     */
    @Override
    public String getString() {
        return value;
    }

    /**
     * toString
     * 
     * @see java.lang.Enum#toString()
     */
    @Override
    public String toString() {
        return getString();
    }

    /**
     * Gets default state.
     * 
     * @return default state.
     */
    public static DeviceState getDefault() {
        return PENDING;
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
     * Gets state from its string representation.
     * 
     * @param value
     *            string
     * @return corresponding state or default state if not recognised.
     */
    public static DeviceState getState(String value) {
        if (value == null) {
            return getDefault();
        }
        final String trimmedValue = value.trim();
        for (final DeviceState state : values()) {
            if (state.getString().equalsIgnoreCase(trimmedValue)) {
                return state;
            }
        }
        return getDefault();
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
