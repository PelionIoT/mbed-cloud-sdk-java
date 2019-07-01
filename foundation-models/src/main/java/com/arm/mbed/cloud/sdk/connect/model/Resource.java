package com.arm.mbed.cloud.sdk.connect.model;

import com.arm.mbed.cloud.sdk.annotations.DefaultValue;
import com.arm.mbed.cloud.sdk.annotations.Internal;
import com.arm.mbed.cloud.sdk.annotations.PerformsNoOperation;
import com.arm.mbed.cloud.sdk.annotations.Preamble;
import com.arm.mbed.cloud.sdk.annotations.Required;
import com.arm.mbed.cloud.sdk.common.SdkModel;
import com.arm.mbed.cloud.sdk.devices.model.Device;

@Preamble(description = "Resource")
public class Resource implements SdkModel {
    /**
     * Serialisation Id.
     */
    private static final long serialVersionUID = 6360594606291188856L;
    /**
     * Related device ID.
     */
    @Required
    private String deviceId;
    /**
     * Resource's url.
     */
    @Required
    private String path;
    /**
     * Resource's type.
     */
    private final String resourceType;
    /**
     * The content type of the resource.
     */
    private final String contentType;
    /**
     * Interface description that defines a name or URI that indicates how to interact with the target resource. It
     * describes a generic interface type, such as a "sensor".
     */
    private final String interfaceDescription;
    /**
     * Whether you can subscribe to changes for this resource.
     */
    @DefaultValue(value = "false")
    private final boolean observable;

    /**
     * Internal constructor.
     * <p>
     * Note: Should not be used. Use {@link #Resource(String, String)} instead.
     *
     * @param deviceId
     *            device id
     * @param path
     *            path
     * @param type
     *            type
     * @param contentType
     *            content type
     * @param observable
     *            observable
     * @param interfaceDescription
     *            interface description
     */
    @Internal
    public Resource(String deviceId, String path, String resourceType, String contentType, boolean observable,
                    String interfaceDescription) {
        super();
        setDeviceId(deviceId);
        setPath(path);
        this.resourceType = resourceType;
        this.contentType = contentType;
        this.observable = observable;
        this.interfaceDescription = interfaceDescription;
    }

    /**
     * Internal constructor.
     * <p>
     * Note: Should not be used. Use {@link #Resource(String, String)} instead.
     *
     * @param deviceId
     *            device id
     * @param path
     *            path
     * @param type
     *            type
     * @param contentType
     *            content type
     */
    @Internal
    public Resource(String deviceId, String path, String type, String contentType) {
        this(deviceId, path, type, contentType, false, null);
    }

    /**
     * Constructor.
     *
     * @param deviceId
     *            device id.
     * @param path
     *            resource path.
     */
    public Resource(String deviceId, String path) {
        this(deviceId, path, null, null);
    }

    /**
     * Constructor.
     * 
     * @deprecated use {@link #Resource(Device, String)} instead
     * @param device
     *            device.
     * @param path
     *            resource path.
     */
    @Deprecated
    public Resource(com.arm.mbed.cloud.sdk.devicedirectory.model.Device device, String path) {
        this((device == null) ? null : device.getId(), path);
    }

    /**
     * Constructor.
     * 
     * @param device
     *            device.
     * @param path
     *            resource path.
     */
    public Resource(Device device, String path) {
        this((device == null) ? null : device.getId(), path);
    }

    /**
     * Constructor.
     */
    public Resource() {
        this(null, null, null, null);
    }

    /**
     * Creates an observable resource.
     *
     * @param deviceId
     *            device id.
     * @param path
     *            resource path.
     * @return corresponding observable resource
     */
    public static Resource newObservableResource(String deviceId, String path) {
        return new Resource(deviceId, path, null, null, true, null);
    }

    /**
     * Creates an observable resource.
     * 
     * @deprecated use {@link #newObservableResource(Device, String)} instead.
     * @param device
     *            device .
     * @param path
     *            resource path.
     * @return corresponding observable resource
     */
    @Deprecated
    public static Resource newObservableResource(com.arm.mbed.cloud.sdk.devicedirectory.model.Device device,
                                                 String path) {
        return newObservableResource((device == null) ? null : device.getId(), path);
    }

    /**
     * Creates an observable resource.
     *
     * @param device
     *            device.
     * @param path
     *            resource path.
     * @return corresponding observable resource
     */

    public static Resource newObservableResource(Device device, String path) {
        return newObservableResource((device == null) ? null : device.getId(), path);
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
     * Gets resource Id.
     *
     * @return resource Id.
     */
    @Internal
    @Override
    public String getId() {
        return getDeviceId() + getPath();
    }

    /*
     * (non-Javadoc)
     *
     * @see com.arm.mbed.cloud.sdk.common.SdkModel#setId(java.lang.String)
     */
    @PerformsNoOperation
    @Internal
    @Override
    public void setId(String id) {
        // Nothing to do

    }

    /**
     * Sets device id.
     *
     * @param deviceId
     *            the deviceId to set
     */
    @Required
    public void setDeviceId(String deviceId) {
        this.deviceId = deviceId;
    }

    /**
     * Gets resource path.
     *
     * @return the path
     */
    public String getPath() {
        return path;
    }

    /**
     * Sets resource path.
     *
     * @param path
     *            the path to set
     */
    @Required
    public void setPath(String path) {
        this.path = path;
    }

    /**
     * Sets resource path.
     * <p>
     * Similar to {@link #setPath(String)}
     *
     * @param path
     *            the path to set
     */
    @Internal
    public void setResourcePath(String path) {
        setPath(path);
    }

    /**
     * Gets type.
     *
     * @deprecated use {@link #getResourceType()} instead
     * @return the type
     */
    @Deprecated
    public String getType() {
        return resourceType;
    }

    /**
     * Gets type.
     *
     * @return the type
     */
    public String getResourceType() {
        return resourceType;
    }

    /**
     * Gets content type.
     *
     * @return the contentType
     */
    public String getContentType() {
        return contentType;
    }

    /**
     * States whether you can subscribe to changes for this resource or not (whether the resource is observable or not).
     *
     * @return the observable
     */
    public boolean isObservable() {
        return observable;
    }

    /**
     * Gets the interface description that defines a name or URI that indicates how to interact with the target
     * resource.
     * <p>
     * It describes a generic interface type, such as a "sensor".
     *
     * @return the interface description
     */
    public String getInterfaceDescription() {
        return interfaceDescription;
    }

    /**
     * Gets a clone.
     *
     * @return a clone
     *
     * @see java.lang.Object#clone()
     */
    @Override
    public Resource clone() {
        return new Resource(deviceId, path, resourceType, contentType, observable, interfaceDescription);
    }

    /**
     * Determines whether all required fields have been set and therefore if the model instance is valid.
     *
     * @return true if instance is valid. False otherwise.
     */
    @Override
    public boolean isValid() {
        return deviceId != null && path != null;
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
        result = prime * result + ((path == null) ? 0 : path.hashCode());
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
        final Resource other = (Resource) obj;
        if (deviceId == null) {
            if (other.deviceId != null) {
                return false;
            }
        } else if (!deviceId.equals(other.deviceId)) {
            return false;
        }
        if (path == null) {
            if (other.path != null) {
                return false;
            }
        } else if (!path.equals(other.path)) {
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
        return "Resource [deviceId=" + deviceId + ", path=" + path + ", resourceType=" + resourceType + ", contentType="
               + contentType + ", interfaceDescription=" + interfaceDescription + ", observable=" + observable + "]";
    }

}
