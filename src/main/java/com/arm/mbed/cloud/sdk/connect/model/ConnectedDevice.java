package com.arm.mbed.cloud.sdk.connect.model;

import com.arm.mbed.cloud.sdk.annotations.Preamble;

@Preamble(description = "Connected device")
public class ConnectedDevice {
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
