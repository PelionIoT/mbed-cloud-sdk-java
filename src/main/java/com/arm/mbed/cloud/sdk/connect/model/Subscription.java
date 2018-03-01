package com.arm.mbed.cloud.sdk.connect.model;

import java.util.ArrayList;
import java.util.List;

import com.arm.mbed.cloud.sdk.annotations.Preamble;
import com.arm.mbed.cloud.sdk.common.SdkModel;

@Preamble(description = "Subscription")
public class Subscription implements SdkModel {
    /**
     * Serialisation id.
     */
    private static final long serialVersionUID = -3023068375015106835L;
    /**
     * The device id.
     */
    private String deviceId;
    /**
     * list of subscribed resources.
     */
    private List<String> resourcePaths;

    /**
     * Constructor.
     *
     * @param deviceId
     *            device id.
     * @param resourcePaths
     *            resource paths.
     */
    public Subscription(String deviceId, List<String> resourcePaths) {
        super();
        setDeviceId(deviceId);
        setResourcePaths(resourcePaths);
    }

    /**
     * Constructor.
     *
     * @param resource
     *            A resource to subscribe to.
     */
    public Subscription(Resource resource) {
        this((resource == null) ? null : resource.getDeviceId(), getResourcePath(resource));
    }

    /**
     * Constructor.
     */
    public Subscription() {
        this(null, null);
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
    public Subscription clone() {
        return new Subscription(deviceId, resourcePaths);
    }

    /**
     * Determines whether all required fields have been set and therefore if the model instance is valid.
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
        return "Subscription [deviceId=" + deviceId + ", resourcePaths=" + resourcePaths + "]";
    }

    @Override
    public String getId() {
        return getDeviceId();
    }

}
