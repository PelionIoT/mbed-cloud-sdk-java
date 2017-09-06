package com.arm.mbed.cloud.sdk.connect.model;

import java.util.List;

import com.arm.mbed.cloud.sdk.annotations.Preamble;
import com.arm.mbed.cloud.sdk.common.SDKModel;

@Preamble(description = "Presubscription")
public class Presubscription implements SDKModel {
    /**
     * 
     */
    private static final long serialVersionUID = -5268031934513375264L;
    /**
     * The device id (optionally having an * character at the end)
     */
    private String deviceId;
    /**
     * The device type
     */
    private String deviceType;
    /**
     * A list of resources to subscribe to. Allows wildcards to subscribe to multiple resources at once
     */
    private List<String> resourcePaths;

    public Presubscription() {
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
     * @return the deviceType
     */
    public String getDeviceType() {
        return deviceType;
    }

    /**
     * @param deviceType
     *            the deviceType to set
     */
    public void setDeviceType(String deviceType) {
        this.deviceType = deviceType;
    }

    /**
     * @return the resourcePaths
     */
    public List<String> getResourcePaths() {
        return resourcePaths;
    }

    /**
     * @param resourcePaths
     *            the resourcePaths to set
     */
    public void setResourcePaths(List<String> resourcePaths) {
        this.resourcePaths = resourcePaths;
    }

}
