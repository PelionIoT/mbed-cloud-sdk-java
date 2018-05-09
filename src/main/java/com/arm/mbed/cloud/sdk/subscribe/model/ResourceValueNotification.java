package com.arm.mbed.cloud.sdk.subscribe.model;

import java.nio.ByteBuffer;
import java.nio.charset.StandardCharsets;

import com.arm.mbed.cloud.sdk.annotations.Preamble;
import com.arm.mbed.cloud.sdk.connect.model.Resource;
import com.arm.mbed.cloud.sdk.subscribe.NotificationMessageValue;
import com.mbed.lwm2m.DecodingException;
import com.mbed.lwm2m.EncodingType;
import com.mbed.lwm2m.base64.Base64Decoder;

@Preamble(description = "Java bean describing a resource value notification")
public class ResourceValueNotification implements NotificationMessageValue {
    /**
     * Serialisation Id.
     */
    private static final long serialVersionUID = 5943106211908183446L;

    private final Resource resource;
    private String contentType;
    private Object payload;
    private String maxAge;
    private Throwable throwable;

    private String deviceType;// TODO

    /**
     * Constructor.
     *
     * @param deviceId
     *            device id.
     * @param resourcePath
     *            resource path
     */
    public ResourceValueNotification(String deviceId, String resourcePath) {
        this(new Resource(deviceId, resourcePath));
    }

    /**
     * Constructor.
     *
     * @param resource.
     */
    public ResourceValueNotification(Resource resource) {
        super();
        this.resource = resource;
    }

    /**
     * Gets the resource.
     *
     * @return the resource
     */
    public Resource getResource() {
        return resource;
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
     * @param aPayload
     *            the payload to set
     * @return this
     */
    public ResourceValueNotification payload(Object aPayload) {
        setPayload(aPayload);
        return this;
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
     * @return the maxAge
     */
    public String getMaxAge() {
        return maxAge;
    }

    /**
     * @param maxAge
     *            the maxAge to set
     */
    public void setMaxAge(String maxAge) {
        this.maxAge = maxAge;
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
        if (encodingType == EncodingType.UNKNOWN) {
            return Base64Decoder.decodeToUtf8(payload);
        }
        final byte[] bytes = payload.getBytes(StandardCharsets.UTF_8);
        final ByteBuffer buffer = ByteBuffer.wrap(bytes);
        return Base64Decoder.decodeBase64(buffer, encodingType);
    }

    /*
     * (non-Javadoc)
     *
     * @see java.lang.Object#clone()
     */
    @Override
    public ResourceValueNotification clone() {
        final ResourceValueNotification clone = new ResourceValueNotification(resource);
        clone.setContentType(contentType);
        clone.setPayload(payload);
        clone.setThrowable(throwable);
        clone.setMaxAge(maxAge);
        return clone;
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
        result = prime * result + ((deviceType == null) ? 0 : deviceType.hashCode());
        result = prime * result + ((maxAge == null) ? 0 : maxAge.hashCode());
        result = prime * result + ((payload == null) ? 0 : payload.hashCode());
        result = prime * result + ((resource == null) ? 0 : resource.hashCode());
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
        ResourceValueNotification other = (ResourceValueNotification) obj;
        if (contentType == null) {
            if (other.contentType != null) {
                return false;
            }
        } else if (!contentType.equals(other.contentType)) {
            return false;
        }
        if (deviceType == null) {
            if (other.deviceType != null) {
                return false;
            }
        } else if (!deviceType.equals(other.deviceType)) {
            return false;
        }
        if (maxAge == null) {
            if (other.maxAge != null) {
                return false;
            }
        } else if (!maxAge.equals(other.maxAge)) {
            return false;
        }
        if (payload == null) {
            if (other.payload != null) {
                return false;
            }
        } else if (!payload.equals(other.payload)) {
            return false;
        }
        if (resource == null) {
            if (other.resource != null) {
                return false;
            }
        } else if (!resource.equals(other.resource)) {
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
        return "ResourceValueNotification [resource=" + resource + ", contentType=" + contentType + ", payload="
                + payload + ", maxAge=" + maxAge + ", throwable=" + throwable + ", deviceType=" + deviceType + "]";
    }

}
