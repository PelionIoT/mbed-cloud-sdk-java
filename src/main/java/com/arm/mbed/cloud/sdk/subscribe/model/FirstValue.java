package com.arm.mbed.cloud.sdk.subscribe.model;

import com.arm.mbed.cloud.sdk.annotations.Preamble;

@Preamble(description = "Enumerator describing when the first value received should be triggered on")
/**
 * 'First value' refers to how soon after requesting a subscription the first resource value is fetched.
 * <p>
 * There is a tradeoff in terms of performance/api calls/device power usage.
 *
 */
public enum FirstValue {
    /**
     * Listens to value changes happening after the device registered or re-registed. Therefore, it waits for a device
     * to send re-register message. one api call.
     * <p>
     * LONG wait.
     */
    ON_REGISTRATION,
    /**
     * Listens to value changes happening as soon as changes happen. Therefore, it sets up subscriptions on existing
     * live resources. many api calls.
     * <p>
     * MEDIUM wait.
     */
    ON_VALUE_UPDATE,

    IMMEDIATELY;
    // TODO Add LAST_KNOWN, IMMEDIATELY
    // explicitly requests value update from each matching resource. many api calls. immediate.

    public static FirstValue getDefault() {
        return FirstValue.ON_VALUE_UPDATE;
    }
}
