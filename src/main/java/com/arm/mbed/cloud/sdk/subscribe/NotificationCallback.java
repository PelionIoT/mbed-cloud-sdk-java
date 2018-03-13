package com.arm.mbed.cloud.sdk.subscribe;

import com.arm.mbed.cloud.sdk.common.Callback;

public class NotificationCallback<T extends NotificationMessageValue> {
    private final Callback<T> onSuccess;
    private final Callback<Throwable> onFailure;

    public NotificationCallback(Callback<T> onSuccess, Callback<Throwable> onFailure) {
        super();
        this.onSuccess = onSuccess;
        this.onFailure = onFailure;
    }

    public void callBack(NotificationMessage<T> message) {
        if (message == null) {
            return;
        }
        callBack(message.getValue(), message.getException());
    }

    public void callBack(T value, Throwable throwable) {
        if (throwable == null) {
            if (onSuccess != null) {
                onSuccess.execute(value);
            }
        } else {
            if (onFailure != null) {
                onFailure.execute(throwable);
            }
        }
    }

    public void callBack(T value) {
        callBack(value, null);
    }

    public void callBack(Throwable throwable) {
        callBack(null, throwable);
    }

}
