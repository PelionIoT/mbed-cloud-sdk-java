package com.arm.mbed.cloud.sdk.subscribe;

import com.arm.mbed.cloud.sdk.annotations.Preamble;

@Preamble(description = "Type of subscription")
public enum SubscriptionType {
    /**
     * Subscription to notifications related to device state changes.
     */
    DEVICE_STATE_CHANGE,
    /**
     * Subscription to notifications related to sensor value changes.
     */
    NOTIFICATION,
    /**
     * Subscription to Cloud asynchronous responses such as sensor current value.
     */
    ASYNCHRONOUS_RESPONSE

}
