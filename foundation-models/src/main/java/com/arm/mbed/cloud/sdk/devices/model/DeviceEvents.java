// This file was generated by the Pelion SDK foundation code generator.
// This is an autogenerated class. Do not modify its content as modifications will be lost at next code generation.
package com.arm.mbed.cloud.sdk.devices.model;

import com.arm.mbed.cloud.sdk.annotations.Internal;
import com.arm.mbed.cloud.sdk.annotations.Preamble;
import com.arm.mbed.cloud.sdk.common.SdkModel;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.util.Date;
import java.util.Map;
import java.util.Objects;

/**
 * Model for a device events. */
@Preamble(
    description = "Model for a device events."
)
public class DeviceEvents implements SdkModel {
  /**
   * Serialisation Id. */
  private static final long serialVersionUID = 3306736964522935L;

  /**
   * Additional data relevant to the event. */
  private Map<String, String> changes;

  /**
   * value. */
  private Date createdAt;

  /**
   * value. */
  private Map<String, String> data;

  /**
   * value. */
  private Date dateTime;

  /**
   * value. */
  private String description;

  /**
   * value. */
  private String deviceId;

  /**
   * Event code. */
  private String eventType;

  /**
   * Category code which groups the event type by a summary category. */
  private String eventTypeCategory;

  /**
   * Generic description of the event. */
  private String eventTypeDescription;

  /**
   * value. */
  private String id;

  /**
   * value. */
  private boolean stateChange;

  /**
   * Internal constructor.
   * <p>
   * Note: Should not be used. Use {@link #DeviceEvents()} instead.
   * @param changes Additional data relevant to the event.
   * @param createdAt value.
   * @param data value.
   * @param dateTime value.
   * @param description value.
   * @param deviceId value.
   * @param eventType Event code.
   * @param eventTypeCategory Category code which groups the event type by a summary category.
   * @param eventTypeDescription Generic description of the event.
   * @param id value.
   * @param stateChange value.
   */
  @Internal
  public DeviceEvents(Map<String, String> changes, Date createdAt, Map<String, String> data,
      Date dateTime, String description, String deviceId, String eventType,
      String eventTypeCategory, String eventTypeDescription, String id, boolean stateChange) {
    super();
    setChanges(changes);
    setCreatedAt(createdAt);
    setData(data);
    setDateTime(dateTime);
    setDescription(description);
    setDeviceId(deviceId);
    setEventType(eventType);
    setEventTypeCategory(eventTypeCategory);
    setEventTypeDescription(eventTypeDescription);
    setId(id);
    setStateChange(stateChange);
  }

  /**
   * Internal constructor.
   * <p>
   * Note: Should not be used. Use {@link #DeviceEvents()} instead.
   * @param deviceEvents a device events.
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
        deviceEvents == null ? (String) null : deviceEvents.id,
        deviceEvents == null ? false : deviceEvents.stateChange);
  }

  /**
   * Constructor.
   */
  public DeviceEvents() {
    this(null,
        new java.util.Date(),
        null,
        new java.util.Date(),
        (String) null,
        (String) null,
        (String) null,
        (String) null,
        (String) null,
        (String) null,
        false);
  }

  /**
   * Constructor.
   * @param id value.
   */
  public DeviceEvents(String id) {
    this();
    setId(id);
  }

  /**
   * Gets additional data relevant to the event.
   * @return changes
   */
  public Map<String, String> getChanges() {
    return changes;
  }

  /**
   * Sets additional data relevant to the event.
   * @param changes Additional data relevant to the event.
   */
  public void setChanges(Map<String, String> changes) {
    this.changes = changes;
  }

  /**
   * Gets value.
   * @return createdAt
   */
  public Date getCreatedAt() {
    return createdAt;
  }

  /**
   * Sets value.
   * @param createdAt value.
   */
  public void setCreatedAt(Date createdAt) {
    this.createdAt = createdAt;
  }

  /**
   * Gets value.
   * @return data
   */
  public Map<String, String> getData() {
    return data;
  }

  /**
   * Sets value.
   * @param data value.
   */
  public void setData(Map<String, String> data) {
    this.data = data;
  }

  /**
   * Gets value.
   * @return dateTime
   */
  public Date getDateTime() {
    return dateTime;
  }

  /**
   * Sets value.
   * @param dateTime value.
   */
  public void setDateTime(Date dateTime) {
    this.dateTime = dateTime;
  }

  /**
   * Gets value.
   * @return description
   */
  public String getDescription() {
    return description;
  }

  /**
   * Sets value.
   * @param description value.
   */
  public void setDescription(String description) {
    this.description = description;
  }

  /**
   * Gets value.
   * @return deviceId
   */
  public String getDeviceId() {
    return deviceId;
  }

  /**
   * Sets value.
   * @param deviceId value.
   */
  public void setDeviceId(String deviceId) {
    this.deviceId = deviceId;
  }

  /**
   * Gets event code.
   * @return eventType
   */
  public String getEventType() {
    return eventType;
  }

  /**
   * Sets event code.
   * @param eventType Event code.
   */
  public void setEventType(String eventType) {
    this.eventType = eventType;
  }

  /**
   * Gets category code which groups the event type by a summary category.
   * @return eventTypeCategory
   */
  public String getEventTypeCategory() {
    return eventTypeCategory;
  }

  /**
   * Sets category code which groups the event type by a summary category.
   * @param eventTypeCategory Category code which groups the event type by a summary category.
   */
  public void setEventTypeCategory(String eventTypeCategory) {
    this.eventTypeCategory = eventTypeCategory;
  }

  /**
   * Gets generic description of the event.
   * @return eventTypeDescription
   */
  public String getEventTypeDescription() {
    return eventTypeDescription;
  }

  /**
   * Sets generic description of the event.
   * @param eventTypeDescription Generic description of the event.
   */
  public void setEventTypeDescription(String eventTypeDescription) {
    this.eventTypeDescription = eventTypeDescription;
  }

  /**
   * Gets value.
   * @return id
   */
  @Override
  public String getId() {
    return id;
  }

  /**
   * Sets value.
   * @param id value.
   */
  @Override
  public void setId(String id) {
    this.id = id;
  }

  /**
   * Sets value.
   * <p>
   * Similar to {@link #setId(String)}
   * @param deviceEventsId value.
   */
  @Internal
  public void setDeviceEventsId(String deviceEventsId) {
    setId(deviceEventsId);
  }

  /**
   * Gets value.
   * @return stateChange
   */
  public boolean isStateChange() {
    return stateChange;
  }

  /**
   * Sets value.
   * @param stateChange value.
   */
  public void setStateChange(boolean stateChange) {
    this.stateChange = stateChange;
  }

  /**
   * Calculates the hash code of this instance based on field values.
   * <p>
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
    result = prime * result +  Objects.hashCode(stateChange);
    return result;
  }

  /**
   * Indicates whether some other object is "equal to" this one.
   * <p>
   * @see java.lang.Object#equals(java.lang.Object)
   * @param obj an object to compare with this instance.
   * @return true if this object is the same as the obj argument; false otherwise.
   */
  @Override
  public boolean equals(Object obj) {
    if (this == obj) {
      return true;
    }
    if (obj == null) {
      return false;
    }
    if (!getClass().isAssignableFrom(obj.getClass()))  {
      return false;
    }
    final DeviceEvents other = (DeviceEvents) obj;
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
   * @see java.lang.Object#toString()
   * @return the string representation
   */
  @Override
  public String toString() {
    return "DeviceEvents [changes=" + changes
        + ", createdAt=" + createdAt
        + ", data=" + data
        + ", dateTime=" + dateTime
        + ", description=" + description
        + ", deviceId=" + deviceId
        + ", eventType=" + eventType
        + ", eventTypeCategory=" + eventTypeCategory
        + ", eventTypeDescription=" + eventTypeDescription
        + ", id=" + id
        + ", stateChange=" + stateChange + "]";
  }

  /**
   * Checks whether the model is valid or not.
   * <p>
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
   * @see java.lang.Object#clone()
   * @return a cloned instance
   */
  @Override
  public DeviceEvents clone() {
    return new DeviceEvents(this);
  }
}
