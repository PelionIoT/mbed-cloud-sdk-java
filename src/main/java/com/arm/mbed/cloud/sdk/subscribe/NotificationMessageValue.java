package com.arm.mbed.cloud.sdk.subscribe;

import java.io.Serializable;

import com.arm.mbed.cloud.sdk.annotations.Preamble;

@Preamble(description = "Payload of a notification message")
public interface NotificationMessageValue extends Cloneable, Serializable {
    /**
     * Clones the notification message payload.
     *
     * @return a clone.
     */
    NotificationMessageValue clone();

    /**
     * Gets payload raw value.
     *
     * @return raw value.
     */
    Object getRawValue();
}
