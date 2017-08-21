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

}
