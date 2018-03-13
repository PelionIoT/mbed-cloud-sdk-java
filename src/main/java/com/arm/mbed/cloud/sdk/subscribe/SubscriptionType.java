package com.arm.mbed.cloud.sdk.subscribe;

import com.arm.mbed.cloud.sdk.annotations.Preamble;

@Preamble(description = "Type of subscription")
public enum SubscriptionType {
    DEVICE_STATE_CHANGE, NOTIFICATION, ASYNCHRONOUS_RESPONSE

}
