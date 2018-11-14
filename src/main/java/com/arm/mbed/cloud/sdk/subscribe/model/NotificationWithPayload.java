package com.arm.mbed.cloud.sdk.subscribe.model;

import java.nio.ByteBuffer;
import java.nio.charset.StandardCharsets;

import com.arm.mbed.cloud.sdk.annotations.Preamble;
import com.arm.mbed.cloud.sdk.subscribe.NotificationMessageValue;
import com.mbed.lwm2m.DecodingException;
import com.mbed.lwm2m.EncodingType;
import com.mbed.lwm2m.base64.Base64Decoder;

@Preamble(description = "Object describing a notification containing some payload")
public class NotificationWithPayload implements NotificationMessageValue {

    /**
     * Serialisation Id.
     */
    private static final long serialVersionUID = 1650120441987311373L;
    private String contentType;
    private Object payload;
    private Throwable throwable;

    public NotificationWithPayload() {
        super();
        setObject(null);
    }

    /**
     * Gets the content type.
     *
     * @return the contentType
     */
    public String getContentType() {
        return contentType;
    }

    /**
     * Gets the payload.
     *
     * @return the payload
     */
    public Object getPayload() {
        return payload;
    }

    /**
     * Gets the exception which may have happened.
     *
     * @return the throwable
     */
    public Throwable getThrowable() {
        return throwable;
    }

    /**
     * Sets the content type.
     *
     * @param contentType
     *            the contentType to set
     */
    public void setContentType(String contentType) {
        this.contentType = contentType;
    }

    /**
     * Sets the payload.
     *
     * @param payload
     *            the payload to set
     */
    public void setPayload(Object payload) {
        this.payload = payload;
    }

    /**
     *
     * Sets the payload.
     *
     * @param somePayload
     *            the payload to set
     * @param <T>
     *            type of payload
     * @return this
     */
    @SuppressWarnings("unchecked")
    public <T extends NotificationWithPayload> T payload(Object somePayload) {
        setPayload(somePayload);
        return (T) this;
    }

    /**
     * Sets exception which may have happened.
     *
     * @param throwable
     *            the throwable to set
     */
    public void setThrowable(Throwable throwable) {
        this.throwable = throwable;
    }

    /**
     * States whether an exception was thrown during the process.
     *
     * @return True if an error occurred. False otherwise.
     */
    public boolean hasErrorOccurred() {
        return throwable != null;
    }

    /**
     * Decodes the payload.
     *
     * @param encodedPayload
     *            encoded payload
     * @param payloadContentType
     *            content type of the payload.
     */
    public void decodePayload(String encodedPayload, String payloadContentType) {
        setContentType(payloadContentType);
        try {
            setPayload(decodeBase64EncodedPayload(encodedPayload, payloadContentType));
        } catch (DecodingException exception) {
            setThrowable(exception);
        }
    }

    private static Object decodeBase64EncodedPayload(String payload, String ct) throws DecodingException {
        final EncodingType encodingType = EncodingType.getType(ct);
        switch (encodingType) {
            case LWM2M_CORE_LINK_PARAM:
            case LWM2M_JSON:
            case LWM2M_OPAQUE:
            case LWM2M_TLV:
                final byte[] bytes = payload.getBytes(StandardCharsets.UTF_8);
                final ByteBuffer buffer = ByteBuffer.wrap(bytes);
                return Base64Decoder.decodeBase64Lwm2m(buffer, encodingType);
            case JSON:
                // TODO
            case PLAIN_TEXT:
            case UNKNOWN:
            default:
                return Base64Decoder.decodeToUtf8(payload);
        }
    }

    @Override
    public Object getRawValue() {
        return getPayload();
    }

    /*
     * (non-Javadoc)
     *
     * @see java.lang.Object#hashCode()
     */
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((contentType == null) ? 0 : contentType.hashCode());
        result = prime * result + ((payload == null) ? 0 : payload.hashCode());
        result = prime * result + ((throwable == null) ? 0 : throwable.hashCode());
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
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final NotificationWithPayload other = (NotificationWithPayload) obj;
        if (contentType == null) {
            if (other.contentType != null) {
                return false;
            }
        } else if (!contentType.equals(other.contentType)) {
            return false;
        }
        if (payload == null) {
            if (other.payload != null) {
                return false;
            }
        } else if (!payload.equals(other.payload)) {
            return false;
        }
        if (throwable == null) {
            if (other.throwable != null) {
                return false;
            }
        } else if (!throwable.equals(other.throwable)) {
            return false;
        }
        return true;
    }

    /**
     * Sets this object's fields with other's field values
     *
     * @param other
     *            an other object
     * @param <T>
     *            type of the other object.
     */
    public <T extends NotificationWithPayload> void setObject(T other) {
        if (other == null) {
            setContentType(null);
            setPayload(null);
            setThrowable(null);
        } else {
            setContentType(other.getContentType());
            setPayload(other.getPayload());
            setThrowable(other.getThrowable());
        }
    }

    /*
     * (non-Javadoc)
     *
     * @see java.lang.Object#clone()
     */
    @Override
    public NotificationWithPayload clone() {
        final NotificationWithPayload clone = new NotificationWithPayload();
        clone.setObject(this);
        return clone;
    }

    /*
     * (non-Javadoc)
     *
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        return "NotificationWithPayload [contentType=" + contentType + ", payload=" + payload + ", throwable="
               + throwable + "]";
    }

}
