package com.arm.mbed.cloud.sdk.connect.model;

import java.util.List;

import com.arm.mbed.cloud.sdk.annotations.Preamble;
import com.arm.mbed.cloud.sdk.common.SdkModel;

@Preamble(description = "Presubscription")
public class Presubscription implements SdkModel {
    /**
     * Serialisation id.
     */
    private static final long serialVersionUID = -5268031934513375264L;
    /**
     * The device id (optionally having an * character at the end).
     */
    private String deviceId;
    /**
     * The device type.
     */
    private String deviceType;
    /**
     * A list of resources to subscribe to. Allows wildcards to subscribe to multiple resources at once.
     */
    private List<String> resourcePaths;

    /**
     * Constructor.
     * 
     * @param deviceId
     *            device id.
     * @param deviceType
     *            device type.
     * @param resourcePaths
     *            resource paths.
     */
    public Presubscription(String deviceId, String deviceType, List<String> resourcePaths) {
        super();
        setDeviceId(deviceId);
        setDeviceType(deviceType);
        setResourcePaths(resourcePaths);
    }

    /**
     * Constructor.
     */
    public Presubscription() {
        this(null, null, null);
    }

    /**
     * Gets device id.
     * 
     * @return the deviceId
     */
    public String getDeviceId() {
        return deviceId;
    }

    /**
     * Sets device id.
     * 
     * @param deviceId
     *            the deviceId to set
     */
    public void setDeviceId(String deviceId) {
        this.deviceId = deviceId;
    }

    /**
     * Gets device type.
     * 
     * @return the deviceType
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
     * Gets resource paths.
     * 
     * @return the resourcePaths
     */
    public List<String> getResourcePaths() {
        return resourcePaths;
    }

    /**
     * Sets resource paths.
     * 
     * @param resourcePaths
     *            the resourcePaths to set
     */
    public void setResourcePaths(List<String> resourcePaths) {
        this.resourcePaths = resourcePaths;
    }

    /**
     * Gets a clone.
     * 
     * @return a clone
     * 
     * @see java.lang.Object#clone()
     */
    @Override
    public Presubscription clone() throws CloneNotSupportedException {
        return new Presubscription(deviceId, deviceType, resourcePaths);
    }

}
