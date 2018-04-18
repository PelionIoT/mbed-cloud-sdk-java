package com.arm.mbed.cloud.sdk.connect.model;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import com.arm.mbed.cloud.sdk.annotations.Internal;
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
     * Gets presubscription Id.
     *
     * @return presubscription id.
     */
    @Internal
    @Override
    public String getId() {
        return String.valueOf(hashCode());
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
     * Adds a resource path to subscribe to.
     *
     * @param resourcePath
     *            path to subscribe to.
     */
    public void addResourcePath(String resourcePath) {
        if (resourcePath == null || resourcePath.isEmpty()) {
            return;
        }
        if (resourcePaths == null) {
            setResourcePaths(new LinkedList<>());
        }
        resourcePaths.add(resourcePath);
    }

    /**
     * Adds a resource to subscribe to.
     *
     * @param resource
     *            resource to subscribe to.
     */
    public void addResource(Resource resource) {
        if (resource == null || !resource.isValid()) {
            return;
        }
        addResourcePath(resource.getPath());
        setDeviceId(resource.getDeviceId());
    }

    /**
     * Sets resources to subscribe to.
     *
     * @param resources
     *            the resources to set
     */
    public void setResources(List<Resource> resources) {
        if (resources == null) {
            return;
        }
        for (final Resource resource : resources) {
            addResource(resource);
        }
    }

    /**
     * Gets a clone.
     *
     * @return a clone
     *
     * @see java.lang.Object#clone()
     */
    @Override
    public Presubscription clone() {
        return new Presubscription(deviceId, deviceType, resourcePaths);
    }

    /**
     * Determines whether all required fields have been set and therefore if the model instance is valid.
     *
     * @return true if instance is valid. False otherwise.
     */
    @Override
    public boolean isValid() {
        return deviceId != null || resourcePaths != null || deviceType != null;
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
        result = prime * result + ((resourcePaths == null) ? 0 : resourcePaths.hashCode());
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
        Presubscription other = (Presubscription) obj;
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
        if (resourcePaths == null) {
            if (other.resourcePaths != null) {
                return false;
            }
        } else if (!resourcePaths.equals(other.resourcePaths)) {
            return false;
        }
        return true;
    }

}
