package com.arm.mbed.cloud.sdk.update.model;

import com.arm.mbed.cloud.sdk.annotations.Preamble;
import com.arm.mbed.cloud.sdk.common.SdkEnum;

@Preamble(description = "campaign state")
public enum CampaignState implements SdkEnum {

    DRAFT("draft"), SCHEDULED("scheduled"), DEVICE_FETCH("devicefetch"), DEVICE_COPY("devicecopy"), PUBLISHING(
            "publishing"), DEPLOYING(
                    "deploying"), DEPLOYED("deployed"), MANIFEST_REMOVED("manifestremoved"), EXPIRED("expired");
    private final String value;

    /**
     * Constructor.
     * 
     * @param value
     *            string representation.
     */
    private CampaignState(String value) {
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
     * Gets string representation.
     * 
     * @see SdkEnum#getString()
     */
    @Override
    public String getString() {
        return value;
    }

    /**
     * ToString.
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
    public static CampaignState getDefault() {
        return DRAFT;
    }

    /**
     * Gets state from its string representation.
     * 
     * @param value
     *            string
     * @return corresponding state or default state if not recognised.
     */
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
