package com.arm.mbed.cloud.sdk.connect.model;

import java.util.ArrayList;
import java.util.List;

import com.arm.mbed.cloud.sdk.annotations.Preamble;
import com.arm.mbed.cloud.sdk.common.SdkModel;
import com.arm.mbed.cloud.sdk.devicedirectory.model.Device;

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
     * 
     * @param device
     *            device.
     * @param resourcePaths
     *            resource paths.
     */
    public Presubscription(Device device, List<String> resourcePaths) {
        this((device == null) ? null : device.getId(), null, resourcePaths);
    }

    /**
     * Constructor.
     * 
     * @param resource
     *            A resource to pre-subscribe to.
     */
    public Presubscription(Resource resource) {
        this((resource == null) ? null : resource.getDeviceId(), null, getResourcePath(resource));
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

    /**
     * Determines whether the model instance is valid i.e. all required fields have been set.
     * 
     * @return true if instance is valid. False otherwise.
     */
    @Override
    public boolean isValid() {
        return true;
    }

    private static List<String> getResourcePath(Resource resource) {
        if (resource == null || !resource.isValid()) {
            return null;
        }
        final List<String> list = new ArrayList<>(1);
        list.add(resource.getPath());
        return list;
    }

    /*
     * (non-Javadoc)
     * 
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        return "Presubscription [deviceId=" + deviceId + ", deviceType=" + deviceType + ", resourcePaths="
                + resourcePaths + "]";
    }

}
