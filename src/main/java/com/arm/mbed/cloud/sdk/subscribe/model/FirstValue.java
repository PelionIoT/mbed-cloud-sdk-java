package com.arm.mbed.cloud.sdk.subscribe.model;

import com.arm.mbed.cloud.sdk.annotations.Preamble;

@Preamble(description = "Enumerator describing when the first value received should be triggered on")
public enum FirstValue {
    ON_REGISTRATION, ON_VALUE_UPDATE;
    // TODO Add LAST_KNOWN, IMMEDIATELY

    public static FirstValue getDefault() {
        return FirstValue.ON_REGISTRATION;
    }
}
