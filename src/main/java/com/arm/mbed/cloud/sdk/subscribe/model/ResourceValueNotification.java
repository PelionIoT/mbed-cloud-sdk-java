package com.arm.mbed.cloud.sdk.subscribe.model;

import com.arm.mbed.cloud.sdk.annotations.Preamble;
import com.arm.mbed.cloud.sdk.connect.model.Resource;

@Preamble(description = "Java bean describing a resource value notification")
public class ResourceValueNotification extends NotificationWithPayload {
    /**
     * Serialisation Id.
     */
    private static final long serialVersionUID = 5943106211908183446L;

    private final Resource resource;
    private String maxAge;
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
        this(Resource.newObservableResource(deviceId, resourcePath));
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
     * Gets the max age.
     * <p>
     * Note: maximum cache time of the value in seconds.
     *
     * @return the maxAge
     */
    public String getMaxAge() {
        return maxAge;
    }

    /**
     * Sets the max age.
     * <p>
     * Note: Max age value is an integer number of seconds between 0 and 2^32-1 but the actual maximum cache time is
     * limited to 3 days. A default value of 60 seconds is assumed in the absence of the option.
     *
     * @param maxAge
     *            the maxAge to set
     */
    public void setMaxAge(String maxAge) {
        this.maxAge = maxAge;
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
        setMaxAge(null);
        if (other instanceof ResourceValueNotification) {
            setMaxAge(((ResourceValueNotification) other).getMaxAge());
            // TODO add setDeviceType
        }
    }

    /*
     * (non-Javadoc)
     *
     * @see java.lang.Object#clone()
     */
    @Override
    public ResourceValueNotification clone() {
        final ResourceValueNotification clone = new ResourceValueNotification(resource);
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
        result = prime * result + ((deviceType == null) ? 0 : deviceType.hashCode());
        result = prime * result + ((maxAge == null) ? 0 : maxAge.hashCode());
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
        if (!super.equals(obj)) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final ResourceValueNotification other = (ResourceValueNotification) obj;
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
        return "ResourceValueNotification [resource=" + resource + ", maxAge=" + maxAge + ", deviceType=" + deviceType
               + ", payload=" + super.toString() + "]";
    }

}
