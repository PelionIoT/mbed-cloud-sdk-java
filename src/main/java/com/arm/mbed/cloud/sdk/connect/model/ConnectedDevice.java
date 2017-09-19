package com.arm.mbed.cloud.sdk.connect.model;

import com.arm.mbed.cloud.sdk.annotations.DefaultValue;
import com.arm.mbed.cloud.sdk.annotations.Internal;
import com.arm.mbed.cloud.sdk.annotations.Preamble;
import com.arm.mbed.cloud.sdk.common.SdkModel;

@Preamble(description = "Connected device")
public class ConnectedDevice implements SdkModel {
    /**
     * Serialisation id.
     */
    private static final long serialVersionUID = 5058779082021017573L;
    /**
     * The ID of the device.
     */
    private String id;
    /**
     * Determines whether the device is in queue mode.
     */
    @DefaultValue(value = "false")
    private final boolean queueMode;
    /**
     * Type of endpoint. (Free text).
     */
    private final String type;

    /**
     * Internal constructor.
     * <p>
     * Note: Should not be used. Use {@link #ConnectedDevice()} instead.
     * 
     * @param id
     *            id
     * @param queueMode
     *            is queue mode
     * @param type
     *            type
     */
    @Internal
    public ConnectedDevice(String id, boolean queueMode, String type) {
        super();
        setId(id);
        this.queueMode = queueMode;
        this.type = type;
    }

    /**
     * Constructor.
     */
    public ConnectedDevice() {
        this(null, false, null);
    }

    /**
     * Gets the id.
     * 
     * @return the id
     */
    public String getId() {
        return id;
    }

    /**
     * Sets the id.
     * 
     * @param id
     *            the id to set
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * States whether the device is in queue mode.
     * 
     * @return the queueMode
     */
    public boolean isQueueMode() {
        return queueMode;
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
     * Gets a clone.
     * 
     * @return a clone
     * 
     * @see java.lang.Object#clone()
     */
    @Override
    public ConnectedDevice clone() throws CloneNotSupportedException {
        return new ConnectedDevice(id, queueMode, type);
    }

}
