package com.arm.mbed.cloud.sdk.subscribe.model;

import com.arm.mbed.cloud.sdk.annotations.Preamble;
import com.arm.mbed.cloud.sdk.subscribe.NotificationMessageValue;

@Preamble(description = "Java bean describing a device state change")
public class DeviceStateNotification implements NotificationMessageValue {
    /**
     * 
     */
    private static final long serialVersionUID = 1638551463908650959L;
    private DeviceState state;
    private String deviceId;
    // TODO add more fields

    public DeviceStateNotification(DeviceState state, String deviceId) {
        super();
        this.state = state;
        this.deviceId = deviceId;
    }

    public DeviceStateNotification() {
        this(DeviceState.UNKNOWN_ENUM, null);
    }

    /**
     * @return the state
     */
    public DeviceState getState() {
        return state;
    }

    /**
     * @param state
     *            the state to set
     */
    public void setState(DeviceState state) {
        this.state = state;
    }

    /**
     * @return the deviceId
     */
    public String getDeviceId() {
        return deviceId;
    }

    /**
     * @param deviceId
     *            the deviceId to set
     */
    public void setDeviceId(String deviceId) {
        this.deviceId = deviceId;
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
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        DeviceStateNotification other = (DeviceStateNotification) obj;
        if (deviceId == null) {
            if (other.deviceId != null)
                return false;
        } else if (!deviceId.equals(other.deviceId))
            return false;
        if (state != other.state)
            return false;
        return true;
    }

    /*
     * (non-Javadoc)
     * 
     * @see java.lang.Object#clone()
     */
    @Override
    public DeviceStateNotification clone() {
        return new DeviceStateNotification(state, deviceId);
    }

}
