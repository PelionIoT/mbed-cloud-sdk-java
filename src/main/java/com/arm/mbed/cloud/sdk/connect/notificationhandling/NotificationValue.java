package com.arm.mbed.cloud.sdk.connect.notificationhandling;

import com.arm.mbed.cloud.sdk.subscribe.NotificationMessageValue;

public class NotificationValue implements NotificationMessageValue {

    /**
     * 
     */
    private static final long serialVersionUID = 7698726162618796273L;
    private final Object value;

    public NotificationValue(Object value) {
        super();
        this.value = value;
    }

    /**
     * Gets raw value
     * 
     * @return the value
     */
    public Object getRawValue() {
        return value;
    }

    @Override
    public NotificationMessageValue clone() {
        return new NotificationValue(value);
    }

}
