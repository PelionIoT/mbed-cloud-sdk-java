package com.arm.mbed.cloud.sdk.subscribe;

import java.io.Serializable;

import com.arm.mbed.cloud.sdk.annotations.Nullable;
import com.arm.mbed.cloud.sdk.annotations.Preamble;

@Preamble(description = "A notification message")
public class NotificationMessage<T extends NotificationMessageValue> implements Cloneable, Serializable {
    /**
     * Serialisation Id.
     */
    private static final long serialVersionUID = -5281052003758591311L;
    private final T value;
    private final Throwable exception;

    /**
     * Constructor.
     *
     * @param value
     *            payload of the message.
     * @param ec
     *            exception if any.
     */
    public NotificationMessage(@Nullable T value, @Nullable Throwable ec) {
        super();
        this.value = value;
        this.exception = ec;
    }

    /**
     * Gets message payload value.
     *
     * @return the value
     */
    public T getValue() {
        return value;
    }

    /**
     * Gets exceptions if the notification reports an exception rather than a value.
     *
     * @return the exception
     */
    public Throwable getException() {
        return exception;
    }

    /*
     * (non-Javadoc)
     *
     * @see java.lang.Object#clone()
     */
    @SuppressWarnings({ "rawtypes", "unchecked" })
    @Override
    public NotificationMessage<T> clone() {
        return new NotificationMessage((value == null) ? null : value.clone(), exception);
    }

    /*
     * (non-Javadoc)
     *
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        return "NotificationMessage [value=" + value + ", exception=" + exception + "]";
    }
}
