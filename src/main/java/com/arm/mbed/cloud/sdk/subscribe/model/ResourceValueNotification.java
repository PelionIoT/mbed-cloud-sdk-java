package com.arm.mbed.cloud.sdk.subscribe.model;

import java.util.Objects;

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

    @Override
    public int hashCode() {
        return super.hashCode() + Objects.hash(deviceType, maxAge, resource);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!super.equals(obj)) {
            return false;
        }
        if (!(obj instanceof ResourceValueNotification)) {
            return false;
        }
        final ResourceValueNotification other = (ResourceValueNotification) obj;
        if (!other.canEqual(this)) {
            return false;
        }
        return Objects.equals(deviceType, other.deviceType) && Objects.equals(maxAge, other.maxAge)
               && Objects.equals(resource, other.resource);
    }

    /**
     * Method to ensure {@link #equals(Object)} is correct.
     *
     * <p>
     * Note: see this article: <a href="https://www.artima.com/lejava/articles/equality.html">canEqual()</a>
     * 
     * @param other
     *            another object.
     * @return true if the other object is an instance of the class in which canEqual is (re)defined, false otherwise.
     */
    @Override
    protected boolean canEqual(Object other) {
        return other instanceof ResourceValueNotification;
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
