package com.arm.mbed.cloud.sdk.devicedirectory.model;

import java.util.Date;

import com.arm.mbed.cloud.sdk.annotations.DefaultValue;
import com.arm.mbed.cloud.sdk.annotations.Internal;
import com.arm.mbed.cloud.sdk.annotations.Preamble;
import com.arm.mbed.cloud.sdk.common.SdkModel;

@Preamble(description = "Device event model")
public class DeviceEvent implements SdkModel {

    /**
     * 
     */
    private static final long serialVersionUID = 2307075354040045693L;

    /**
     * ID of the event
     */
    private String id;
    /**
     * ID of device the event is for
     */
    private final String deviceId;
    /**
     * Date and time of the event
     */
    @DefaultValue("now()")
    private final Date eventDate;
    /**
     * Whether the event changed state
     */
    @DefaultValue("false")
    private final boolean stateChanged;
    /**
     * Description of the event
     */
    private final String description;
    /**
     * Changes made
     */
    private final Object changes;
    /**
     * Description of the event type
     */
    private final String typeDescription;
    /**
     * Type of the event
     */
    private final String type;

    /**
     * Data pertaining to the event
     */
    private final Object data;

    @Internal
    public DeviceEvent(String id, String deviceId, Date eventDate, boolean stateChanged, String description,
            Object changes, String typeDescription, String type, Object data) {
        super();
        this.id = id;
        this.deviceId = deviceId;
        this.eventDate = eventDate;
        this.stateChanged = stateChanged;
        this.description = description;
        this.changes = changes;
        this.typeDescription = typeDescription;
        this.type = type;
        this.data = data;
    }

    public DeviceEvent() {
        this(null, null, new Date(), false, null, null, null, null, null);
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
     * @return the deviceId
     */
    public String getDeviceId() {
        return deviceId;
    }

    /**
     * @return the eventDate
     */
    public Date getEventDate() {
        return eventDate;
    }

    /**
     * @return the stateChanged
     */
    public boolean isStateChanged() {
        return stateChanged;
    }

    /**
     * @return the description
     */
    public String getDescription() {
        return description;
    }

    /**
     * @return the changes
     */
    public Object getChanges() {
        return changes;
    }

    /**
     * @return the typeDescription
     */
    public String getTypeDescription() {
        return typeDescription;
    }

    /**
     * @return the type
     */
    public String getType() {
        return type;
    }

    /**
     * @return the data
     */
    public Object getData() {
        return data;
    }

    /*
     * (non-Javadoc)
     * 
     * @see java.lang.Object#clone()
     */
    @Override
    public DeviceEvent clone() throws CloneNotSupportedException {
        return new DeviceEvent(id, deviceId, eventDate, stateChanged, description, changes, typeDescription, type,
                data);
    }

}
