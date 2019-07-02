package com.arm.mbed.cloud.sdk.subscribe.model;

import java.util.LinkedList;
import java.util.List;

import com.arm.mbed.cloud.sdk.annotations.Preamble;
import com.arm.mbed.cloud.sdk.subscribe.NotificationMessageValue;

@Preamble(description = "Java bean describing a Pelion notification")
public class AllNotifications implements NotificationMessageValue {
    /**
     * Serialisation Id.
     */
    private static final long serialVersionUID = 6449359435771334198L;

    private List<ResourceValueNotification> resourceValueNotifications;
    private List<AsynchronousResponseNotification> asynchronousResponseNotifications;
    private List<DeviceStateNotification> deviceStateNotifications;

    /**
     * Constructor.
     * 
     * @param resourceValueNotifications
     *            list of notifications.
     * @param asynchronousResponseNotifications
     *            list of notifications.
     * @param deviceStateNotifications
     *            list of notifications.
     */
    public AllNotifications(List<ResourceValueNotification> resourceValueNotifications,
                            List<AsynchronousResponseNotification> asynchronousResponseNotifications,
                            List<DeviceStateNotification> deviceStateNotifications) {
        super();
        this.resourceValueNotifications = resourceValueNotifications;
        this.asynchronousResponseNotifications = asynchronousResponseNotifications;
        this.deviceStateNotifications = deviceStateNotifications;
    }

    /**
     * Constructor.
     */
    public AllNotifications() {
        this(null, null, null);
    }

    /**
     * States whether there are resource value notifications or not.
     * 
     * @return true if there are. False otherwise.
     */
    public boolean hasResourceValueNotifications() {
        return resourceValueNotifications != null && !resourceValueNotifications.isEmpty();
    }

    /**
     * Gets the resource value notifications.
     * 
     * @return corresponding notification list.
     */
    public List<ResourceValueNotification> getResourceValueNotifications() {
        return resourceValueNotifications;
    }

    /**
     * Sets the resource value notifications.
     * 
     * @param resourceValueNotifications
     *            notification list to set.
     */
    public void setResourceValueNotifications(List<ResourceValueNotification> resourceValueNotifications) {
        this.resourceValueNotifications = resourceValueNotifications;
    }

    /**
     * States whether there are asynchronous response notifications or not.
     * 
     * @return true if there are. False otherwise.
     */
    public boolean hasAsynchronousResponseNotifications() {
        return asynchronousResponseNotifications != null && !asynchronousResponseNotifications.isEmpty();
    }

    /**
     * Gets the asynchronous response notifications.
     * 
     * @return corresponding notification list.
     */
    public List<AsynchronousResponseNotification> getAsynchronousResponseNotifications() {
        return asynchronousResponseNotifications;
    }

    /**
     * Sets the asynchronous response notifications.
     * 
     * @param asynchronousResponseNotifications
     *            notification list to set.
     */
    public void
           setAsynchronousResponseNotifications(List<AsynchronousResponseNotification> asynchronousResponseNotifications) {
        this.asynchronousResponseNotifications = asynchronousResponseNotifications;
    }

    /**
     * States whether there are device state notifications or not.
     * 
     * @return true if there are. False otherwise.
     */
    public boolean hasDeviceStateNotifications() {
        return deviceStateNotifications != null && !deviceStateNotifications.isEmpty();
    }

    /**
     * Gets the device state notifications.
     * 
     * @return corresponding notification list.
     */
    public List<DeviceStateNotification> getDeviceStateNotifications() {
        return deviceStateNotifications;
    }

    /**
     * Sets the device state notifications.
     * 
     * @param deviceStateNotifications
     *            notification list to set.
     */
    public void setDeviceStateNotifications(List<DeviceStateNotification> deviceStateNotifications) {
        this.deviceStateNotifications = deviceStateNotifications;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result
                 + ((asynchronousResponseNotifications == null) ? 0 : asynchronousResponseNotifications.hashCode());
        result = prime * result + ((deviceStateNotifications == null) ? 0 : deviceStateNotifications.hashCode());
        result = prime * result + ((resourceValueNotifications == null) ? 0 : resourceValueNotifications.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (!(obj instanceof AllNotifications)) {
            return false;
        }
        final AllNotifications other = (AllNotifications) obj;
        if (!other.canEqual(this)) {
            return false;
        }
        if (asynchronousResponseNotifications == null) {
            if (other.asynchronousResponseNotifications != null) {
                return false;
            }
        } else if (!asynchronousResponseNotifications.equals(other.asynchronousResponseNotifications)) {
            return false;
        }
        if (deviceStateNotifications == null) {
            if (other.deviceStateNotifications != null) {
                return false;
            }
        } else if (!deviceStateNotifications.equals(other.deviceStateNotifications)) {
            return false;
        }
        if (resourceValueNotifications == null) {
            if (other.resourceValueNotifications != null) {
                return false;
            }
        } else if (!resourceValueNotifications.equals(other.resourceValueNotifications)) {
            return false;
        }
        return true;
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
    protected boolean canEqual(Object other) {
        return other instanceof AllNotifications;
    }

    /*
     * (non-Javadoc)
     *
     * @see java.lang.Object#clone()
     */
    @Override
    public AllNotifications clone() {
        final AllNotifications clone = new AllNotifications();
        if (hasAsynchronousResponseNotifications()) {
            clone.setAsynchronousResponseNotifications(new LinkedList<>(getAsynchronousResponseNotifications()));
        }
        if (hasDeviceStateNotifications()) {
            clone.setDeviceStateNotifications(new LinkedList<>(getDeviceStateNotifications()));
        }
        if (hasResourceValueNotifications()) {
            clone.setResourceValueNotifications(new LinkedList<>(getResourceValueNotifications()));
        }
        return clone;
    }

    @Override
    public String toString() {
        return "AllNotifications [resourceValueNotifications=" + resourceValueNotifications
               + ", asynchronousResponseNotifications=" + asynchronousResponseNotifications
               + ", deviceStateNotifications=" + deviceStateNotifications + "]";
    }

    @Override
    public Object getRawValue() {
        return this;
    }

}
