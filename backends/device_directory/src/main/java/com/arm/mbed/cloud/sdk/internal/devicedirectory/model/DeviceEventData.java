/*
 * Device Directory API
 * This is the API Documentation for the Device Directory service.
 *
 * OpenAPI spec version: 3
 * 
 *
 * NOTE: This class is auto generated by the swagger code generator program.
 * https://github.com/swagger-api/swagger-codegen.git
 * Do not edit the class manually.
 */


package com.arm.mbed.cloud.sdk.internal.devicedirectory.model;

import java.util.Objects;
import com.google.gson.TypeAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.joda.time.DateTime;
import java.io.Serializable;

/**
 * DeviceEventData
 */

public class DeviceEventData implements Serializable {
  private static final long serialVersionUID = 1L;

  @SerializedName("changes")
  private Map<String, String> changes = null;

  @SerializedName("created_at")
  private DateTime createdAt = null;

  @SerializedName("data")
  private Map<String, String> data = null;

  @SerializedName("date_time")
  private DateTime dateTime = null;

  @SerializedName("description")
  private String description = null;

  @SerializedName("device_id")
  private String deviceId = null;

  @SerializedName("etag")
  private DateTime etag = null;

  @SerializedName("event_type")
  private String eventType = null;

  @SerializedName("event_type_category")
  private String eventTypeCategory = null;

  @SerializedName("event_type_description")
  private String eventTypeDescription = null;

  @SerializedName("id")
  private String id = null;

  @SerializedName("object")
  private String object = null;

  @SerializedName("state_change")
  private Boolean stateChange = null;

  public DeviceEventData changes(Map<String, String> changes) {
    this.changes = changes;
    return this;
  }

  public DeviceEventData putChangesItem(String key, String changesItem) {
    if (this.changes == null) {
      this.changes = new HashMap<String, String>();
    }
    this.changes.put(key, changesItem);
    return this;
  }

   /**
   * Get changes
   * @return changes
  **/
  @ApiModelProperty(example = "{}", value = "")
  public Map<String, String> getChanges() {
    return changes;
  }

  public void setChanges(Map<String, String> changes) {
    this.changes = changes;
  }

  public DeviceEventData createdAt(DateTime createdAt) {
    this.createdAt = createdAt;
    return this;
  }

   /**
   * Get createdAt
   * @return createdAt
  **/
  @ApiModelProperty(example = "2017-05-22T12:37:55.576563Z", value = "")
  public DateTime getCreatedAt() {
    return createdAt;
  }

  public void setCreatedAt(DateTime createdAt) {
    this.createdAt = createdAt;
  }

  public DeviceEventData data(Map<String, String> data) {
    this.data = data;
    return this;
  }

  public DeviceEventData putDataItem(String key, String dataItem) {
    if (this.data == null) {
      this.data = new HashMap<String, String>();
    }
    this.data.put(key, dataItem);
    return this;
  }

   /**
   * Additional data relevant to the event.
   * @return data
  **/
  @ApiModelProperty(example = "{\"campaign_id\":\"00000000000000000000000000000000\"}", value = "Additional data relevant to the event.")
  public Map<String, String> getData() {
    return data;
  }

  public void setData(Map<String, String> data) {
    this.data = data;
  }

  public DeviceEventData dateTime(DateTime dateTime) {
    this.dateTime = dateTime;
    return this;
  }

   /**
   * Get dateTime
   * @return dateTime
  **/
  @ApiModelProperty(example = "2017-05-22T12:37:55.576563Z", required = true, value = "")
  public DateTime getDateTime() {
    return dateTime;
  }

  public void setDateTime(DateTime dateTime) {
    this.dateTime = dateTime;
  }

  public DeviceEventData description(String description) {
    this.description = description;
    return this;
  }

   /**
   * Get description
   * @return description
  **/
  @ApiModelProperty(example = "Device record created", value = "")
  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public DeviceEventData deviceId(String deviceId) {
    this.deviceId = deviceId;
    return this;
  }

   /**
   * Get deviceId
   * @return deviceId
  **/
  @ApiModelProperty(example = "00000000000000000000000000000000", value = "")
  public String getDeviceId() {
    return deviceId;
  }

  public void setDeviceId(String deviceId) {
    this.deviceId = deviceId;
  }

  public DeviceEventData etag(DateTime etag) {
    this.etag = etag;
    return this;
  }

   /**
   * Get etag
   * @return etag
  **/
  @ApiModelProperty(example = "2017-05-22T12:37:55.576563Z", value = "")
  public DateTime getEtag() {
    return etag;
  }

  public void setEtag(DateTime etag) {
    this.etag = etag;
  }

  public DeviceEventData eventType(String eventType) {
    this.eventType = eventType;
    return this;
  }

   /**
   * Event code
   * @return eventType
  **/
  @ApiModelProperty(example = "UPD2_100", value = "Event code")
  public String getEventType() {
    return eventType;
  }

  public void setEventType(String eventType) {
    this.eventType = eventType;
  }

  public DeviceEventData eventTypeCategory(String eventTypeCategory) {
    this.eventTypeCategory = eventTypeCategory;
    return this;
  }

   /**
   * Category code which groups the event type by a summary category.
   * @return eventTypeCategory
  **/
  @ApiModelProperty(example = "FAIL_MANIFEST_REJECTED", value = "Category code which groups the event type by a summary category.")
  public String getEventTypeCategory() {
    return eventTypeCategory;
  }

  public void setEventTypeCategory(String eventTypeCategory) {
    this.eventTypeCategory = eventTypeCategory;
  }

  public DeviceEventData eventTypeDescription(String eventTypeDescription) {
    this.eventTypeDescription = eventTypeDescription;
    return this;
  }

   /**
   * Generic description of the event
   * @return eventTypeDescription
  **/
  @ApiModelProperty(example = "FAIL", value = "Generic description of the event")
  public String getEventTypeDescription() {
    return eventTypeDescription;
  }

  public void setEventTypeDescription(String eventTypeDescription) {
    this.eventTypeDescription = eventTypeDescription;
  }

  public DeviceEventData id(String id) {
    this.id = id;
    return this;
  }

   /**
   * Get id
   * @return id
  **/
  @ApiModelProperty(example = "00000000000000000000000000000000", required = true, value = "")
  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public DeviceEventData object(String object) {
    this.object = object;
    return this;
  }

   /**
   * The API resource entity.
   * @return object
  **/
  @ApiModelProperty(example = "device-event", value = "The API resource entity.")
  public String getObject() {
    return object;
  }

  public void setObject(String object) {
    this.object = object;
  }

  public DeviceEventData stateChange(Boolean stateChange) {
    this.stateChange = stateChange;
    return this;
  }

   /**
   * Get stateChange
   * @return stateChange
  **/
  @ApiModelProperty(value = "")
  public Boolean isStateChange() {
    return stateChange;
  }

  public void setStateChange(Boolean stateChange) {
    this.stateChange = stateChange;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    DeviceEventData deviceEventData = (DeviceEventData) o;
    return Objects.equals(this.changes, deviceEventData.changes) &&
        Objects.equals(this.createdAt, deviceEventData.createdAt) &&
        Objects.equals(this.data, deviceEventData.data) &&
        Objects.equals(this.dateTime, deviceEventData.dateTime) &&
        Objects.equals(this.description, deviceEventData.description) &&
        Objects.equals(this.deviceId, deviceEventData.deviceId) &&
        Objects.equals(this.etag, deviceEventData.etag) &&
        Objects.equals(this.eventType, deviceEventData.eventType) &&
        Objects.equals(this.eventTypeCategory, deviceEventData.eventTypeCategory) &&
        Objects.equals(this.eventTypeDescription, deviceEventData.eventTypeDescription) &&
        Objects.equals(this.id, deviceEventData.id) &&
        Objects.equals(this.object, deviceEventData.object) &&
        Objects.equals(this.stateChange, deviceEventData.stateChange);
  }

  @Override
  public int hashCode() {
    return Objects.hash(changes, createdAt, data, dateTime, description, deviceId, etag, eventType, eventTypeCategory, eventTypeDescription, id, object, stateChange);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class DeviceEventData {\n");
    
    sb.append("    changes: ").append(toIndentedString(changes)).append("\n");
    sb.append("    createdAt: ").append(toIndentedString(createdAt)).append("\n");
    sb.append("    data: ").append(toIndentedString(data)).append("\n");
    sb.append("    dateTime: ").append(toIndentedString(dateTime)).append("\n");
    sb.append("    description: ").append(toIndentedString(description)).append("\n");
    sb.append("    deviceId: ").append(toIndentedString(deviceId)).append("\n");
    sb.append("    etag: ").append(toIndentedString(etag)).append("\n");
    sb.append("    eventType: ").append(toIndentedString(eventType)).append("\n");
    sb.append("    eventTypeCategory: ").append(toIndentedString(eventTypeCategory)).append("\n");
    sb.append("    eventTypeDescription: ").append(toIndentedString(eventTypeDescription)).append("\n");
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    object: ").append(toIndentedString(object)).append("\n");
    sb.append("    stateChange: ").append(toIndentedString(stateChange)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(java.lang.Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }

}

