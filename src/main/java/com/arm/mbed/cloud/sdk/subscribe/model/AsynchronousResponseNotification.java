package com.arm.mbed.cloud.sdk.subscribe.model;

import com.arm.mbed.cloud.sdk.annotations.Nullable;
import com.arm.mbed.cloud.sdk.annotations.Preamble;
import com.arm.mbed.cloud.sdk.common.Error;
import com.arm.mbed.cloud.sdk.common.MbedCloudException;

@Preamble(description = "Java bean describing an asynchronous response notification")
public class AsynchronousResponseNotification extends NotificationWithPayload {

    /**
     * Serialisation Id.
     */
    private static final long serialVersionUID = 8973539556556008066L;
    private final String id;
    private final int statusCode;
    private String errorMessage;

    public AsynchronousResponseNotification(String id, int statusCode) {
        super();
        this.id = id;
        this.statusCode = statusCode;
    }

    /**
     * Gets the asynchronous response Id.
     *
     * @return the id
     */
    public String getId() {
        return id;
    }

    /**
     * Gets the response status code.
     *
     * @return the statusCode
     */
    public int getStatusCode() {
        return statusCode;
    }

    /**
     * Specifies whether the notification reports a failure.
     *
     * @return true if an error is reported. False otherwise.
     */
    public boolean reportsFailure() {
        return statusCode >= 300;
    }

    /**
     * Sets the error message.
     *
     * @param message
     *            error message
     */
    public void setErrorMessage(String message) {
        if (message != null) {
            setThrowable(new MbedCloudException(message));
        }
        this.errorMessage = message;
    }

    /**
     * Gets the error message.
     * 
     * @return the errorMessage
     */
    public String getErrorMessage() {
        return errorMessage;
    }

    /**
     * Converts to a generic error.
     * 
     * @return equivalent error if request failed; Null otherwise.
     */
    public @Nullable com.arm.mbed.cloud.sdk.common.Error toError() {
        return reportsFailure() ? new Error(getStatusCode(), "Async error", getErrorMessage(), getId()) : null;

    }

    /*
     * (non-Javadoc)
     *
     * @see
     * com.arm.mbed.cloud.sdk.subscribe.model.NotificationWithPayload#setObject(com.arm.mbed.cloud.sdk.subscribe.model.
     * NotificationWithPayload)
     */
    @Override
    public <T extends NotificationWithPayload> void setObject(T other) {
        super.setObject(other);
        setErrorMessage(null);
        if (other != null && other instanceof AsynchronousResponseNotification) {
            setErrorMessage(((AsynchronousResponseNotification) other).getErrorMessage());
        }
    }

    @Override
    public AsynchronousResponseNotification clone() {
        final AsynchronousResponseNotification clone = new AsynchronousResponseNotification(id, statusCode);
        clone.setObject(this);
        return clone;
    }

    /*
     * (non-Javadoc)
     *
     * @see java.lang.Object#hashCode()
     */
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = super.hashCode();
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        result = prime * result + statusCode;
        return result;
    }

    /*
     * (non-Javadoc)
     *
     * @see java.lang.Object#equals(java.lang.Object)
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!super.equals(obj)) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final AsynchronousResponseNotification other = (AsynchronousResponseNotification) obj;
        if (id == null) {
            if (other.id != null) {
                return false;
            }
        } else if (!id.equals(other.id)) {
            return false;
        }
        if (statusCode != other.statusCode) {
            return false;
        }
        return true;
    }

    /*
     * (non-Javadoc)
     *
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        return "AsynchronousResponseNotification [id=" + id + ", statusCode=" + statusCode + ", payload="
               + super.toString() + "]";
    }

}
