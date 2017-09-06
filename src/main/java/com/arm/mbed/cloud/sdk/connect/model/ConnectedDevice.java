package com.arm.mbed.cloud.sdk.connect.model;

import com.arm.mbed.cloud.sdk.annotations.DefaultValue;
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
    @DefaultValue(value = "false")
    private final boolean queueMode;
    /**
     * Type of endpoint. (Free text)
     */
    private final String type;

    public ConnectedDevice(String id, boolean queueMode, String type) {
        super();
        setId(id);
        this.queueMode = queueMode;
        this.type = type;
    }

    public ConnectedDevice() {
        this(null, false, null);
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
     * @return the type
     */
    public String getType() {
        return type;
    }

}
