package com.arm.mbed.cloud.sdk.connect.model;

import com.arm.mbed.cloud.sdk.annotations.DefaultValue;
import com.arm.mbed.cloud.sdk.annotations.Internal;
import com.arm.mbed.cloud.sdk.annotations.Preamble;
import com.arm.mbed.cloud.sdk.common.SdkModel;

@Preamble(description = "Resource")
public class Resource implements SdkModel {
    /**
     * Serialisation Id.
     */
    private static final long serialVersionUID = 6360594606291188856L;
    /**
     * Related device ID.
     */
    private String deviceId;
    /**
     * Resource's url.
     */
    private String path;
    /**
     * Resource's type.
     */
    private final String type;
    /**
     * The content type of the resource.
     */
    private final String contentType;
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
     */
    @Internal
    public Resource(String deviceId, String path, String type, String contentType, boolean observable) {
        super();
        setDeviceId(deviceId);
        setPath(path);
        this.type = type;
        this.contentType = contentType;
        this.observable = observable;
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
        this(deviceId, path, null, null, false);
    }

    /**
     * Constructor.
     */
    public Resource() {
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
     * @return the type
     */
    public String getType() {
        return type;
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
     * States whether the resource is observable or not.
     * 
     * @return the observable
     */
    public boolean isObservable() {
        return observable;
    }

    /**
     * Gets a clone.
     * 
     * @return a clone
     * 
     * @see java.lang.Object#clone()
     */
    @Override
    public Resource clone() throws CloneNotSupportedException {
        return new Resource(deviceId, path, type, contentType, observable);
    }

}
