package com.arm.mbed.cloud.sdk.connect.model;

import com.arm.mbed.cloud.sdk.annotations.Internal;
import com.arm.mbed.cloud.sdk.annotations.Preamble;
import com.arm.mbed.cloud.sdk.common.SdkModel;

@Preamble(description = "Websocket")
public class Websocket implements SdkModel {
    /**
     * Serialisation Id.
     */
    private static final long serialVersionUID = -2958403512624867762L;

    /**
     * Channel Id.
     */
    private String id;

    /**
     * Queue size.
     */
    private final int queueSize;

    /**
     * Websocket status.
     */
    private final WebsocketStatus status;

    /**
     * Constructor.
     * 
     * @param id
     *            channel id.
     * @param queueSize
     *            queue size.
     * @param status
     *            socket status.
     */
    @Internal
    public Websocket(String id, int queueSize, WebsocketStatus status) {
        super();
        this.id = id;
        this.queueSize = queueSize;
        this.status = status;
    }

    /**
     * Constructor.
     */
    public Websocket() {
        this(null, 0, WebsocketStatus.getDefault());

    }

    /**
     * Gets the unique identifier of the channel.
     */
    @Override
    public String getId() {
        return id;
    }

    /**
     * Sets the unique identifier of the channel.
     */
    @Override
    public void setId(String id) {
        this.id = id;
    }

    /**
     * Gets the number of events in the channel's event queue waiting to be delivered.
     * 
     * @return the number of events in the channel's event queue waiting to be delivered.
     */
    public int getQueueSize() {
        return queueSize;
    }

    /**
     * Gets the channel status.
     * 
     * @return the channel status.
     */
    public WebsocketStatus getStatus() {
        return status;
    }

    /**
     * Gets a clone.
     *
     * @return a clone.
     *
     * @see java.lang.Object#clone()
     */
    @Override
    public Websocket clone() {
        return new Websocket(id, queueSize, status);
    }

    /**
     * Determines whether all required fields have been set and therefore if the model instance is valid.
     *
     * @return true if instance is valid. False otherwise.
     */
    @Override
    public boolean isValid() {
        return true;
    }

    @Override
    public String toString() {
        return "Websocket [id=" + id + ", queueSize=" + queueSize + ", status=" + status + "]";
    }

}
