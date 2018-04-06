package com.arm.mbed.cloud.sdk.subscribe;

import com.arm.mbed.cloud.sdk.annotations.Preamble;
import com.arm.mbed.cloud.sdk.common.Callback;

@Preamble(description = "Notification callback")
public class NotificationCallback<T extends NotificationMessageValue> {
    private final Callback<T> onSuccess;
    private final Callback<Throwable> onFailure;

    /**
     * Constructor.
     *
     * @param onSuccess
     *            callback when success.
     * @param onFailure
     *            callback when failure.
     */
    public NotificationCallback(Callback<T> onSuccess, Callback<Throwable> onFailure) {
        super();
        this.onSuccess = onSuccess;
        this.onFailure = onFailure;
    }

    /**
     * Calls back when a notification message is received.
     *
     * @param message
     *            message triggering the callback.
     */
    public void callBack(NotificationMessage<T> message) {
        if (message == null) {
            return;
        }
        callBack(message.getValue(), message.getException());
    }

    /**
     * Calls back when a notification message is received.
     *
     * @param value
     *            message payload.
     * @param throwable
     *            exception.
     */
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

    /**
     * Calls back when a notification message is received.
     *
     * @param value
     *            message payload.
     */
    public void callBack(T value) {
        callBack(value, null);
    }

    /**
     * Calls back when an exception is received.
     *
     * @param throwable
     *            exception received.
     */
    public void callBack(Throwable throwable) {
        callBack(null, throwable);
    }

}
