package com.arm.mbed.cloud.sdk.connect.model;

import com.arm.mbed.cloud.sdk.annotations.DefaultValue;
import com.arm.mbed.cloud.sdk.annotations.Internal;
import com.arm.mbed.cloud.sdk.annotations.Preamble;
import com.arm.mbed.cloud.sdk.common.SDKModel;

@Preamble(description = "Resource")
public class Resource implements SDKModel {
    /**
     * 
     */
    private static final long serialVersionUID = 6360594606291188856L;
    /**
     * Related device ID
     */
    private String deviceId;
    /**
     * Resource's url
     */
    private String path;
    /**
     * Resource's type
     */
    private final String type;
    /**
     * The content type of the resource
     */
    private final String contentType;
    /**
     * Whether you can subscribe to changes for this resource
     */
    @DefaultValue(value = "false")
    private final boolean observable;

    @Internal
    public Resource(String deviceId, String path, String type, String contentType, boolean observable) {
        super();
        setDeviceId(deviceId);
        setPath(path);
        this.type = type;
        this.contentType = contentType;
        this.observable = observable;
    }

    public Resource(String deviceId, String path) {
        this(deviceId, path, null, null, false);
    }

    public Resource() {
        this(null, null);
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

    /**
     * @return the path
     */
    public String getPath() {
        return path;
    }

    /**
     * @param path
     *            the path to set
     */
    public void setPath(String path) {
        this.path = path;
    }

    /**
     * Similar to {@link #setPath(String)}
     * 
     * @param path
     *            the path to set
     */
    public void setResourcePath(String path) {
        setPath(path);
    }

    /**
     * @return the type
     */
    public String getType() {
        return type;
    }

    /**
     * @return the contentType
     */
    public String getContentType() {
        return contentType;
    }

    /**
     * @return the observable
     */
    public boolean isObservable() {
        return observable;
    }

    /*
     * (non-Javadoc)
     * 
     * @see java.lang.Object#clone()
     */
    @Override
    public Resource clone() throws CloneNotSupportedException {
        return new Resource(deviceId, path, type, contentType, observable);
    }

}
