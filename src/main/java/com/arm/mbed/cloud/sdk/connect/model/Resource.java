package com.arm.mbed.cloud.sdk.connect.model;

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
    private String type;
    /**
     * The content type of the resource
     */
    private String contentType;
    /**
     * Whether you can subscribe to changes for this resource
     */
    private boolean observable;

    public Resource() {
        super();
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
     * @return the type
     */
    public String getType() {
        return type;
    }

    /**
     * @param type
     *            the type to set
     */
    public void setType(String type) {
        this.type = type;
    }

    /**
     * @return the contentType
     */
    public String getContentType() {
        return contentType;
    }

    /**
     * @param contentType
     *            the contentType to set
     */
    public void setContentType(String contentType) {
        this.contentType = contentType;
    }

    /**
     * @return the observable
     */
    public boolean isObservable() {
        return observable;
    }

    /**
     * @param observable
     *            the observable to set
     */
    public void setObservable(boolean observable) {
        this.observable = observable;
    }

}
