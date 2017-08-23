package com.arm.mbed.cloud.sdk.update.model;

import com.arm.mbed.cloud.sdk.annotations.Preamble;
import com.arm.mbed.cloud.sdk.common.SDKEnum;

@Preamble(description = "Device state")
public enum DeviceStatus implements SDKEnum {

    PENDING("pending"), UPDATED_CONNECTOR_CHANNEL("updated_connector_channel"), FAILED_CONNECTOR_CHANNEL_UPDATE(
            "failed_connector_channel_update"), DEPLOYED("deployed"), MANIFEST_REMOVED("manifestremoved");

    private final String value;

    private DeviceStatus(String value) {
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

    public static DeviceStatus getDefault() {
        return PENDING;
    }

    public static DeviceStatus getState(String value) {
        if (value == null) {
            return getDefault();
        }
        value = value.trim();
        for (DeviceStatus state : values()) {
            if (state.getString().equalsIgnoreCase(value)) {
                return state;
            }
        }
        return getDefault();
    }

}
