package com.arm.mbed.cloud.sdk.subscribe.model;

import java.nio.ByteBuffer;
import java.nio.charset.StandardCharsets;

import com.arm.mbed.cloud.sdk.annotations.Preamble;
import com.arm.mbed.cloud.sdk.connect.model.Resource;
import com.arm.mbed.cloud.sdk.subscribe.NotificationMessageValue;
import com.mbed.lwm2m.DecodingException;
import com.mbed.lwm2m.EncodingType;
import com.mbed.lwm2m.base64.Base64Decoder;

@Preamble(description = "Java bean describing a resource value change")
public class ResourceValueChangeNotification implements NotificationMessageValue {
    /**
     * Serialisation Id.
     */
    private static final long serialVersionUID = 5943106211908183446L;

    private final Resource resource;
    private String contentType;
    private Object payload;
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
    public ResourceValueChangeNotification(String deviceId, String resourcePath) {
        this(new Resource(deviceId, resourcePath));
    }

    /**
     * Constructor.
     *
     * @param resource.
     */
    public ResourceValueChangeNotification(Resource resource) {
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
     * @param payloadContentType1
     *            content type of the payload.
     */
    public void decodePayload(String encodedPayload, String payloadContentType1) {
        setContentType(payloadContentType1);
        try {
            setPayload(decodeBase64EncodedPayload(encodedPayload, payloadContentType1));
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
    public ResourceValueChangeNotification clone() {
        final ResourceValueChangeNotification clone = new ResourceValueChangeNotification(resource);
        clone.setContentType(contentType);
        clone.setPayload(payload);
        clone.setThrowable(throwable);
        return clone;
    }

    @Override
    public Object getRawValue() {
        return this;
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
        ResourceValueChangeNotification other = (ResourceValueChangeNotification) obj;
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
        return "ResourceValueChangeNotification [resource=" + resource + ", contentType=" + contentType + ", payload="
                + payload + ", throwable=" + throwable + "]";
    }

}
