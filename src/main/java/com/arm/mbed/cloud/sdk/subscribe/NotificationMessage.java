package com.arm.mbed.cloud.sdk.subscribe;

import java.io.Serializable;

public class NotificationMessage<T extends NotificationMessageValue> implements Cloneable, Serializable {
    /**
     * 
     */
    private static final long serialVersionUID = -5281052003758591311L;
    private final T value;
    private final Throwable exception;

    public NotificationMessage(T value, Throwable ec) {
        super();
        this.value = value;
        this.exception = ec;
    }

    /**
     * @return the value
     */
    public T getValue() {
        return value;
    }

    /**
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
    };

}
