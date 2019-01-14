// This file was generated by the Pelion SDK foundation code generator.
// This is an autogenerated class. Do not modify its content as modifications will be lost at next code generation.
package com.arm.mbed.cloud.sdk.devices.model;

import com.arm.mbed.cloud.sdk.annotations.Internal;
import com.arm.mbed.cloud.sdk.annotations.Preamble;
import com.arm.mbed.cloud.sdk.common.SdkModel;
import java.util.Date;
import java.util.Map;
import java.util.Objects;

/**
 * Model for a device events.
 */
@Preamble(description = "Model for a device events.")
@SuppressWarnings("PMD.CyclomaticComplexity")
public class DeviceEvents implements SdkModel {
    /**
     * Serialisation Id.
     */
    private static final long serialVersionUID = 3306736964522935L;

    /**
     * value.
     */
    private final Map<String, String> changes;

    /**
     * value.
     */
    private final Date createdAt;

    /**
     * Additional data relevant to the event.
     */
    private final Map<String, String> data;

    /**
     * value.
     */
    private final Date dateTime;

    /**
     * value.
     */
    private final String description;

    /**
     * value.
     */
    private final String deviceId;

    /**
     * Event code.
     */
    private final String eventType;

    /**
     * Category code which groups the event type by a summary category.
     */
    private final String eventTypeCategory;

    /**
     * Generic description of the event.
     */
    private final String eventTypeDescription;

    /**
     * value.
     */
    private String id;

    /**
     * value.
     */
    private final boolean stateChange;

    /**
     * Internal constructor.
     * <p>
     * Note: Should not be used. Use {@link #DeviceEvents()} instead.
     * 
     * @param changes
     *            value.
     * @param createdAt
     *            value.
     * @param data
     *            Additional data relevant to the event.
     * @param dateTime
     *            value.
     * @param description
     *            value.
     * @param deviceId
     *            value.
     * @param eventType
     *            Event code.
     * @param eventTypeCategory
     *            Category code which groups the event type by a summary category.
     * @param eventTypeDescription
     *            Generic description of the event.
     * @param id
     *            value.
     * @param stateChange
     *            value.
     */
    @Internal
    @SuppressWarnings("PMD.CyclomaticComplexity")
    public DeviceEvents(Map<String, String> changes, Date createdAt, Map<String, String> data, Date dateTime,
                        String description, String deviceId, String eventType, String eventTypeCategory,
                        String eventTypeDescription, String id, boolean stateChange) {
        super();
        this.changes = changes;
        this.createdAt = createdAt;
        this.data = data;
        this.dateTime = dateTime;
        this.description = description;
        this.deviceId = deviceId;
        this.eventType = eventType;
        this.eventTypeCategory = eventTypeCategory;
        this.eventTypeDescription = eventTypeDescription;
        this.stateChange = stateChange;
        setId(id);
    }

    /**
     * Internal constructor.
     * <p>
     * Note: Should not be used. Use {@link #DeviceEvents()} instead.
     * 
     * @param deviceEvents
     *            a device events.
     */
    @Internal
    public DeviceEvents(DeviceEvents deviceEvents) {
        this(deviceEvents == null ? null : deviceEvents.changes,
             deviceEvents == null ? new java.util.Date() : deviceEvents.createdAt,
             deviceEvents == null ? null : deviceEvents.data,
             deviceEvents == null ? new java.util.Date() : deviceEvents.dateTime,
             deviceEvents == null ? (String) null : deviceEvents.description,
             deviceEvents == null ? (String) null : deviceEvents.deviceId,
             deviceEvents == null ? (String) null : deviceEvents.eventType,
             deviceEvents == null ? (String) null : deviceEvents.eventTypeCategory,
             deviceEvents == null ? (String) null : deviceEvents.eventTypeDescription,
             deviceEvents == null ? (String) null : deviceEvents.id, deviceEvents != null && deviceEvents.stateChange);
    }

    /**
     * Constructor.
     */
    public DeviceEvents() {
        this(null, new java.util.Date(), null, new java.util.Date(), (String) null, (String) null, (String) null,
             (String) null, (String) null, (String) null, false);
    }

    /**
     * Constructor.
     * 
     * @param id
     *            value.
     */
    public DeviceEvents(String id) {
        this();
        setId(id);
    }

    /**
     * Internal constructor.
     * <p>
     * Note: Should not be used. Use {@link #DeviceEvents()} instead.
     * 
     * @param changes
     *            value.
     * @param createdAt
     *            value.
     * @param data
     *            Additional data relevant to the event.
     * @param dateTime
     *            value.
     * @param description
     *            value.
     * @param deviceId
     *            value.
     * @param eventType
     *            Event code.
     * @param eventTypeCategory
     *            Category code which groups the event type by a summary category.
     * @param eventTypeDescription
     *            Generic description of the event.
     * @param stateChange
     *            value.
     */
    @Internal
    public DeviceEvents(Map<String, String> changes, Date createdAt, Map<String, String> data, Date dateTime,
                        String description, String deviceId, String eventType, String eventTypeCategory,
                        String eventTypeDescription, boolean stateChange) {
        this(changes, createdAt, data, dateTime, description, deviceId, eventType, eventTypeCategory,
             eventTypeDescription, (String) null, stateChange);
    }

    /**
     * Gets value.
     * 
     * @return changes
     */
    public Map<String, String> getChanges() {
        return changes;
    }

    /**
     * Gets value.
     * 
     * @return createdAt
     */
    public Date getCreatedAt() {
        return createdAt;
    }

    /**
     * Gets additional data relevant to the event.
     * 
     * @return data
     */
    public Map<String, String> getData() {
        return data;
    }

    /**
     * Gets value.
     * 
     * @return dateTime
     */
    public Date getDateTime() {
        return dateTime;
    }

    /**
     * Gets value.
     * 
     * @return description
     */
    public String getDescription() {
        return description;
    }

    /**
     * Gets value.
     * 
     * @return deviceId
     */
    public String getDeviceId() {
        return deviceId;
    }

    /**
     * Gets event code.
     * 
     * @return eventType
     */
    public String getEventType() {
        return eventType;
    }

    /**
     * Gets category code which groups the event type by a summary category.
     * 
     * @return eventTypeCategory
     */
    public String getEventTypeCategory() {
        return eventTypeCategory;
    }

    /**
     * Gets generic description of the event.
     * 
     * @return eventTypeDescription
     */
    public String getEventTypeDescription() {
        return eventTypeDescription;
    }

    /**
     * Gets value.
     * 
     * @return id
     */
    @Override
    public String getId() {
        return id;
    }

    /**
     * Sets value.
     * 
     * @param id
     *            value.
     */
    @Override
    public void setId(String id) {
        this.id = id;
    }

    /**
     * Sets value.
     * <p>
     * Similar to {@link #setId(String)}
     * 
     * @param deviceEventsId
     *            value.
     */
    @Internal
    public void setDeviceEventsId(String deviceEventsId) {
        setId(deviceEventsId);
    }

    /**
     * Gets value.
     * 
     * @return stateChange
     */
    public boolean isStateChange() {
        return stateChange;
    }

    /**
     * Calculates the hash code of this instance based on field values.
     * <p>
     * 
     * @see java.lang.Object#hashCode()
     * @return hash code
     */
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((changes == null) ? 0 : changes.hashCode());
        result = prime * result + ((createdAt == null) ? 0 : createdAt.hashCode());
        result = prime * result + ((data == null) ? 0 : data.hashCode());
        result = prime * result + ((dateTime == null) ? 0 : dateTime.hashCode());
        result = prime * result + ((description == null) ? 0 : description.hashCode());
        result = prime * result + ((deviceId == null) ? 0 : deviceId.hashCode());
        result = prime * result + ((eventType == null) ? 0 : eventType.hashCode());
        result = prime * result + ((eventTypeCategory == null) ? 0 : eventTypeCategory.hashCode());
        result = prime * result + ((eventTypeDescription == null) ? 0 : eventTypeDescription.hashCode());
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        result = prime * result + Objects.hashCode(stateChange);
        return result;
    }

    /**
     * Method to ensure {@link #equals(Object)} is correct.
     * <p>
     * Note: see this article: <a href="https://www.artima.com/lejava/articles/equality.html">canEqual()</a>
     * 
     * @param other
     *            another object.
     * @return true if the other object is an instance of the class in which canEqual is (re)defined, false otherwise.
     */
    protected boolean canEqual(Object other) {
        return other instanceof DeviceEvents;
    }

    /**
     * Indicates whether some other object is "equal to" this one.
     * <p>
     * 
     * @see java.lang.Object#equals(java.lang.Object)
     * @param obj
     *            an object to compare with this instance.
     * @return true if this object is the same as the obj argument; false otherwise.
     */
    @Override
    @SuppressWarnings({ "PMD.ExcessiveMethodLength", "PMD.NcssMethodCount" })
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (!(obj instanceof DeviceEvents)) {
            return false;
        }
        final DeviceEvents other = (DeviceEvents) obj;
        if (!other.canEqual(this)) {
            return false;
        }
        if (changes == null) {
            if (other.changes != null) {
                return false;
            }
        } else if (!changes.equals(other.changes)) {
            return false;
        }
        if (createdAt == null) {
            if (other.createdAt != null) {
                return false;
            }
        } else if (!createdAt.equals(other.createdAt)) {
            return false;
        }
        if (data == null) {
            if (other.data != null) {
                return false;
            }
        } else if (!data.equals(other.data)) {
            return false;
        }
        if (dateTime == null) {
            if (other.dateTime != null) {
                return false;
            }
        } else if (!dateTime.equals(other.dateTime)) {
            return false;
        }
        if (description == null) {
            if (other.description != null) {
                return false;
            }
        } else if (!description.equals(other.description)) {
            return false;
        }
        if (deviceId == null) {
            if (other.deviceId != null) {
                return false;
            }
        } else if (!deviceId.equals(other.deviceId)) {
            return false;
        }
        if (eventType == null) {
            if (other.eventType != null) {
                return false;
            }
        } else if (!eventType.equals(other.eventType)) {
            return false;
        }
        if (eventTypeCategory == null) {
            if (other.eventTypeCategory != null) {
                return false;
            }
        } else if (!eventTypeCategory.equals(other.eventTypeCategory)) {
            return false;
        }
        if (eventTypeDescription == null) {
            if (other.eventTypeDescription != null) {
                return false;
            }
        } else if (!eventTypeDescription.equals(other.eventTypeDescription)) {
            return false;
        }
        if (id == null) {
            if (other.id != null) {
                return false;
            }
        } else if (!id.equals(other.id)) {
            return false;
        }
        if (stateChange != other.stateChange) {
            return false;
        }
        return true;
    }

    /**
     * Returns a string representation of the object.
     * <p>
     * 
     * @see java.lang.Object#toString()
     * @return the string representation
     */
    @Override
    public String toString() {
        return "DeviceEvents [changes=" + changes + ", createdAt=" + createdAt + ", data=" + data + ", dateTime="
               + dateTime + ", description=" + description + ", deviceId=" + deviceId + ", eventType=" + eventType
               + ", eventTypeCategory=" + eventTypeCategory + ", eventTypeDescription=" + eventTypeDescription + ", id="
               + id + ", stateChange=" + stateChange + "]";
    }

    /**
     * Checks whether the model is valid or not.
     * <p>
     * 
     * @see SdkModel#isValid()
     * @return true if the model is valid; false otherwise.
     */
    @Override
    public boolean isValid() {
        return true;
    }

    /**
     * Clones this instance.
     * <p>
     * 
     * @see java.lang.Object#clone()
     * @return a cloned instance
     */
    @Override
    public DeviceEvents clone() {
        return new DeviceEvents(this);
    }
}
