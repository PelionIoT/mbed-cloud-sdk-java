package com.arm.mbed.cloud.sdk.update.model;

import com.arm.mbed.cloud.sdk.annotations.Preamble;
import com.arm.mbed.cloud.sdk.common.SDKEnum;

@Preamble(description = "campaign state")
public enum CampaignState implements SDKEnum {

    DRAFT("draft"), SCHEDULED("scheduled"), DEVICE_FETCH("devicefetch"), DEVICE_COPY("devicecopy"), PUBLISHING(
            "publishing"), DEPLOYING(
                    "deploying"), DEPLOYED("deployed"), MANIFEST_REMOVED("manifestremoved"), EXPIRED("expired");
    private final String value;

    private CampaignState(String value) {
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

    public static CampaignState getDefault() {
        return DRAFT;
    }

    public static CampaignState getState(String value) {
        if (value == null) {
            return getDefault();
        }
        final String trimmedValue = value.trim();
        for (final CampaignState state : values()) {
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
