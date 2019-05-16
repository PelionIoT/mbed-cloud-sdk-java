package com.arm.mbed.cloud.sdk.subscribe.model;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import com.arm.mbed.cloud.sdk.annotations.Preamble;
import com.arm.mbed.cloud.sdk.connect.model.Resource;
import com.arm.mbed.cloud.sdk.subscribe.NotificationMessageValue;

@Preamble(description = "Java bean describing a device state change")
public class DeviceStateNotification implements NotificationMessageValue {
    /**
     * Serialisation Id.
     */
    private static final long serialVersionUID = 1638551463908650959L;
    private final DeviceState state;
    private final String deviceId;
    private String deviceType;
    private List<Resource> resources;

    /**
     * Constructor.
     *
     * @param state
     *            device state.
     * @param deviceId
     *            device ID.
     */
    public DeviceStateNotification(DeviceState state, String deviceId) {
        super();
        this.state = state;
        this.deviceId = deviceId;
        deviceType = null;
        resources = null;
    }

    public DeviceStateNotification() {
        this(DeviceState.UNKNOWN_ENUM, null);
    }

    /**
     * Gets device state.
     *
     * @return the state
     */
    public DeviceState getState() {
        return state;
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

    /*
     * (non-Javadoc)
     *
     * @see java.lang.Object#hashCode()
     */
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((deviceId == null) ? 0 : deviceId.hashCode());
        result = prime * result + ((deviceType == null) ? 0 : deviceType.hashCode());
        result = prime * result + ((resources == null) ? 0 : resources.hashCode());
        result = prime * result + ((state == null) ? 0 : state.hashCode());
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
        final DeviceStateNotification other = (DeviceStateNotification) obj;
        if (deviceId == null) {
            if (other.deviceId != null) {
                return false;
            }
        } else if (!deviceId.equals(other.deviceId)) {
            return false;
        }
        if (deviceType == null) {
            if (other.deviceType != null) {
                return false;
            }
        } else if (!deviceType.equals(other.deviceType)) {
            return false;
        }
        if (resources == null) {
            if (other.resources != null) {
                return false;
            }
        } else if (!resources.equals(other.resources)) {
            return false;
        }
        if (state != other.state) {
            return false;
        }
        return true;
    }

    /*
     * (non-Javadoc)
     *
     * @see java.lang.Object#clone()
     */
    @Override
    public DeviceStateNotification clone() {
        final DeviceStateNotification notification = new DeviceStateNotification(state, deviceId);
        notification.setDeviceType(deviceType);
        notification.setResources((resources == null) ? null : new ArrayList<>(resources));
        return notification;
    }

    @Override
    public Object getRawValue() {
        return this;
    }

    /*
     * (non-Javadoc)
     *
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        return "DeviceStateNotification [state=" + state + ", deviceId=" + deviceId + ", deviceType=" + deviceType
               + ", resources=" + resources + "]";
    }

}
