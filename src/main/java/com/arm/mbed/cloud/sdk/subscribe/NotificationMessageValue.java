package com.arm.mbed.cloud.sdk.subscribe;

import java.io.Serializable;

public interface NotificationMessageValue extends Cloneable, Serializable {
    NotificationMessageValue clone();
}
