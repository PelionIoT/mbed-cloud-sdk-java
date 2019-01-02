package com.arm.mbed.cloud.sdk.devicedirectory.model;

import java.util.Date;

import com.arm.mbed.cloud.sdk.annotations.DefaultValue;
import com.arm.mbed.cloud.sdk.annotations.Internal;
import com.arm.mbed.cloud.sdk.annotations.Preamble;
import com.arm.mbed.cloud.sdk.common.SdkModel;

@Preamble(description = "Device event model")
public class DeviceEvent implements SdkModel {

    /**
     * Serialisation ID.
     */
    private static final long serialVersionUID = 2307075354040045693L;

    /**
     * ID of the event.
     */
    private String id;
    /**
     * ID of device the event is for.
     */
    private final String deviceId;
    /**
     * Date and time of the event.
     */
    @DefaultValue("now()")
    private final Date eventDate;
    /**
     * Whether the event changed state.
     */
    @DefaultValue("false")
    private final boolean stateChanged;
    /**
     * Description of the event.
     */
    private final String description;
    /**
     * Changes made.
     */
    private final Object changes;
    /**
     * Description of the event type.
     */
    private final String typeDescription;
    /**
     * Type of the event.
     */
    private final String type;

    /**
     * Data pertaining to the event.
     */
    private final Object data;

    /**
     * Internal constructor.
     * <p>
     * Note: Should not be used. Use {@link #DeviceEvent()} instead.
     *
     * @param id
     *            id
     * @param deviceId
     *            device id
     * @param eventDate
     *            event date
     * @param stateChanged
     *            state changed
     * @param description
     *            description
     * @param changes
     *            changes
     * @param typeDescription
     *            type description
     * @param type
     *            type
     * @param data
     *            data
     */
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

    /**
     * Constructor.
     */
    public DeviceEvent() {
        this(null, null, new Date(), false, null, null, null, null, null);
    }

    /**
     * Gets id.
     *
     * @return the id
     */
    @Override
    public String getId() {
        return id;
    }

    /**
     * Sets id.
     *
     * @param id
     *            the id to set
     */
    public void setId(String id) {
        this.id = id;
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
     * Gets event date.
     *
     * @return the eventDate
     */
    public Date getEventDate() {
        return eventDate;
    }

    /**
     * Indicates whether state has changed.
     *
     * @return the stateChanged
     */
    public boolean isStateChanged() {
        return stateChanged;
    }

    /**
     * Gets description.
     *
     * @return the description
     */
    public String getDescription() {
        return description;
    }

    /**
     * Gets changes.
     *
     * @return the changes
     */
    public Object getChanges() {
        return changes;
    }

    /**
     * Gets type description.
     *
     * @return the typeDescription
     */
    public String getTypeDescription() {
        return typeDescription;
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
     * Gets data.
     *
     * @return the data
     */
    public Object getData() {
        return data;
    }

    /**
     * Gets a clone.
     *
     * @return a clone
     *
     * @see java.lang.Object#clone()
     */
    @Override
    public DeviceEvent clone() {
        return new DeviceEvent(id, deviceId, eventDate, stateChanged, description, changes, typeDescription, type,
                               data);
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

    /*
     * (non-Javadoc)
     *
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        return "DeviceEvent [id=" + id + ", deviceId=" + deviceId + ", eventDate=" + eventDate + ", stateChanged="
               + stateChanged + ", description=" + description + ", changes=" + changes + ", typeDescription="
               + typeDescription + ", type=" + type + ", data=" + data + "]";
    }

}
