package com.arm.mbed.cloud.sdk.subscribe.model;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

import com.arm.mbed.cloud.sdk.annotations.Preamble;
import com.arm.mbed.cloud.sdk.connect.model.Resource;
import com.arm.mbed.cloud.sdk.subscribe.NotificationMessageValue;

@Preamble(description = "Java bean describing a device state change")
public class DeviceStateNotification implements NotificationMessageValue {
    /**
     * Serialisation Id.
     */
    private static final long serialVersionUID = 1638551463908650959L;
    private final DeviceState event;
    private final String deviceId;
    private final String endpointName;
    private String deviceType;
    private List<Resource> resources;

    /**
     * Constructor.
     *
     * @param event
     *            device event.
     * @param deviceId
     *            device ID.
     * @param endpointName
     *            endpoint name
     */
    public DeviceStateNotification(DeviceState event, String deviceId, String endpointName) {
        super();
        this.event = event;
        this.deviceId = deviceId;
        this.endpointName = endpointName;
        deviceType = null;
        resources = null;
    }

    public DeviceStateNotification() {
        this(DeviceState.UNKNOWN_ENUM, null, null);
    }

    /**
     * Gets device state.
     *
     * @deprecated use {@link #getEvent()} instead.
     * @return the state
     */
    @Deprecated
    public DeviceState getState() {
        return event;
    }

    /**
     * Gets device event.
     *
     * @return the event that happened (i.e. change of state)
     */
    public DeviceState getEvent() {
        return event;
    }

    /**
     * Gets device Id.
     *
     * @return the deviceId
     */
    public String getDeviceId() {
        return deviceId;
    }

    /**
     * Gets the device endpoint name.
     * 
     * @return the endpoint name.
     */
    public String getEndpointName() {
        return endpointName;
    }

    /**
     * Gets resources.
     *
     * @return the resources
     */
    public List<Resource> getResources() {
        return resources;
    }

    /**
     * Sets resources.
     *
     * @param resources
     *            the resources to set
     */
    public void setResources(List<Resource> resources) {
        this.resources = resources;
    }

    /**
     * Gets device type.
     *
     * @return the deviceType.
     */
    public String getDeviceType() {
        return deviceType;
    }

    /**
     * Sets device type.
     *
     * @param deviceType
     *            the deviceType to set
     */
    public void setDeviceType(String deviceType) {
        this.deviceType = deviceType;
    }

    /**
     * Adds a device resource.
     *
     * @param resource
     *            resource
     */
    public void addResource(Resource resource) {
        if (resource == null) {
            return;
        }
        if (this.resources == null) {
            this.resources = new LinkedList<>();
        }
        this.resources.add(resource);
    }

    @Override
    public int hashCode() {
        return Objects.hash(deviceId, deviceType, endpointName, event, resources);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (!(obj instanceof DeviceStateNotification)) {
            return false;
        }
        final DeviceStateNotification other = (DeviceStateNotification) obj;
        if (!other.canEqual(this)) {
            return false;
        }
        return Objects.equals(deviceId, other.deviceId) && Objects.equals(deviceType, other.deviceType)
               && Objects.equals(endpointName, other.endpointName) && event == other.event
               && Objects.equals(resources, other.resources);
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
        return other instanceof DeviceStateNotification;
    }

    /*
     * (non-Javadoc)
     *
     * @see java.lang.Object#clone()
     */
    @Override
    public DeviceStateNotification clone() {
        final DeviceStateNotification notification = new DeviceStateNotification(event, deviceId, endpointName);
        notification.setDeviceType(deviceType);
        notification.setResources((resources == null) ? null : new ArrayList<>(resources));
        return notification;
    }

    @Override
    public Object getRawValue() {
        return this;
    }

    @Override
    public String toString() {
        return "DeviceStateNotification [event=" + event + ", deviceId=" + deviceId + ", endpointName=" + endpointName
               + ", deviceType=" + deviceType + ", resources=" + resources + "]";
    }

}
