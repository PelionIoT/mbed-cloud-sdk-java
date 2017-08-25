package com.arm.mbed.cloud.sdk.connect.model;

import com.arm.mbed.cloud.sdk.annotations.Preamble;
import com.arm.mbed.cloud.sdk.common.SDKModel;

@Preamble(description = "Connected device")
public class ConnectedDevice implements SDKModel {
    /**
     * 
     */
    private static final long serialVersionUID = 5058779082021017573L;
    /**
     * The ID of the device
     */
    private String id;
    /**
     * Determines whether the device is in queue mode.
     */
    private boolean queueMode;
    /**
     * Type of endpoint. (Free text)
     */
    private String type;

    public ConnectedDevice() {
        super();
    }

    /**
     * @return the id
     */
    public String getId() {
        return id;
    }

    /**
     * @param id
     *            the id to set
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * @return the queueMode
     */
    public boolean isQueueMode() {
        return queueMode;
    }

    /**
     * @param queueMode
     *            the queueMode to set
     */
    public void setQueueMode(boolean queueMode) {
        this.queueMode = queueMode;
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

}
