package com.arm.mbed.cloud.sdk.update.model;

import com.arm.mbed.cloud.sdk.annotations.Preamble;
import com.arm.mbed.cloud.sdk.common.SDKEnum;

@Preamble(description = "Device state")
public enum DeviceState implements SDKEnum {

    PENDING("pending"), UPDATED_CONNECTOR_CHANNEL("updated_connector_channel"), FAILED_CONNECTOR_CHANNEL_UPDATE(
            "failed_connector_channel_update"), DEPLOYED("deployed"), MANIFEST_REMOVED("manifestremoved");

    private final String value;

    private DeviceState(String value) {
        this.value = value;
    }

    @Override
    public boolean isDefault() {
        return this == getDefault();
    }

    @Override
    public String getString() {
        return value;
    }

    /*
     * (non-Javadoc)
     * 
     * @see java.lang.Enum#toString()
     */
    @Override
    public String toString() {
        return getString();
    }

    public static DeviceState getDefault() {
        return PENDING;
    }

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
