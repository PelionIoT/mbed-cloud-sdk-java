/*
 * billing REST API documentation
 * This document contains the public REST API definitions of the mbed-billing service.
 *
 * OpenAPI spec version: 1.4.4
 * 
 *
 * NOTE: This class is auto generated by the swagger code generator program.
 * https://github.com/swagger-api/swagger-codegen.git
 * Do not edit the class manually.
 */


package com.arm.mbed.cloud.sdk.internal.billing.model;

import java.util.Objects;
import com.google.gson.TypeAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.IOException;
import org.joda.time.DateTime;
import java.io.Serializable;

/**
 * Previously active service package.
 */
@ApiModel(description = "Previously active service package.")

public class PreviousServicePackage implements Serializable {
  private static final long serialVersionUID = 1L;

  @SerializedName("created")
  private DateTime created = null;

  @SerializedName("end_time")
  private DateTime endTime = null;

  @SerializedName("expires")
  private DateTime expires = null;

  @SerializedName("firmware_update_count")
  private Integer firmwareUpdateCount = null;

  @SerializedName("id")
  private String id = null;

  @SerializedName("modified")
  private DateTime modified = null;

  @SerializedName("next_id")
  private String nextId = null;

  @SerializedName("previous_id")
  private String previousId = null;

  /**
   * Reason why this service package was ended
   */
  @JsonAdapter(ReasonEnum.Adapter.class)
  public enum ReasonEnum {
    RENEWED("renewed"),
    
    TERMINATED("terminated");

    private String value;

    ReasonEnum(String value) {
      this.value = value;
    }

    public String getValue() {
      return value;
    }

    @Override
    public String toString() {
      return String.valueOf(value);
    }

    public static ReasonEnum fromValue(String text) {
      for (ReasonEnum b : ReasonEnum.values()) {
        if (String.valueOf(b.value).equals(text)) {
          return b;
        }
      }
      return null;
    }

    public static class Adapter extends TypeAdapter<ReasonEnum> {
      @Override
      public void write(final JsonWriter jsonWriter, final ReasonEnum enumeration) throws IOException {
        jsonWriter.value(enumeration.getValue());
      }

      @Override
      public ReasonEnum read(final JsonReader jsonReader) throws IOException {
        String value = jsonReader.nextString();
        return ReasonEnum.fromValue(String.valueOf(value));
      }
    }
  }

  @SerializedName("reason")
  private ReasonEnum reason = null;

  @SerializedName("start_time")
  private DateTime startTime = null;

  public PreviousServicePackage created(DateTime created) {
    this.created = created;
    return this;
  }

   /**
   * Service package creation time in RFC3339 date-time with UTC time zone.
   * @return created
  **/
  @ApiModelProperty(required = true, value = "Service package creation time in RFC3339 date-time with UTC time zone.")
  public DateTime getCreated() {
    return created;
  }

  public void setCreated(DateTime created) {
    this.created = created;
  }

  public PreviousServicePackage endTime(DateTime endTime) {
    this.endTime = endTime;
    return this;
  }

   /**
   * Service package end time in RFC3339 date-time with UTC time zone.
   * @return endTime
  **/
  @ApiModelProperty(required = true, value = "Service package end time in RFC3339 date-time with UTC time zone.")
  public DateTime getEndTime() {
    return endTime;
  }

  public void setEndTime(DateTime endTime) {
    this.endTime = endTime;
  }

  public PreviousServicePackage expires(DateTime expires) {
    this.expires = expires;
    return this;
  }

   /**
   * Service package expiration time in RFC3339 date-time with UTC time zone.
   * @return expires
  **/
  @ApiModelProperty(required = true, value = "Service package expiration time in RFC3339 date-time with UTC time zone.")
  public DateTime getExpires() {
    return expires;
  }

  public void setExpires(DateTime expires) {
    this.expires = expires;
  }

  public PreviousServicePackage firmwareUpdateCount(Integer firmwareUpdateCount) {
    this.firmwareUpdateCount = firmwareUpdateCount;
    return this;
  }

   /**
   * Size of firmware update quota of this service package.
   * @return firmwareUpdateCount
  **/
  @ApiModelProperty(required = true, value = "Size of firmware update quota of this service package.")
  public Integer getFirmwareUpdateCount() {
    return firmwareUpdateCount;
  }

  public void setFirmwareUpdateCount(Integer firmwareUpdateCount) {
    this.firmwareUpdateCount = firmwareUpdateCount;
  }

  public PreviousServicePackage id(String id) {
    this.id = id;
    return this;
  }

   /**
   * ID of this service package.
   * @return id
  **/
  @ApiModelProperty(required = true, value = "ID of this service package.")
  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public PreviousServicePackage modified(DateTime modified) {
    this.modified = modified;
    return this;
  }

   /**
   * Service package latest modified time in RFC3339 date-time with UTC time zone.
   * @return modified
  **/
  @ApiModelProperty(required = true, value = "Service package latest modified time in RFC3339 date-time with UTC time zone.")
  public DateTime getModified() {
    return modified;
  }

  public void setModified(DateTime modified) {
    this.modified = modified;
  }

  public PreviousServicePackage nextId(String nextId) {
    this.nextId = nextId;
    return this;
  }

   /**
   * Next service package ID if this service package has a pending renewal or null.
   * @return nextId
  **/
  @ApiModelProperty(value = "Next service package ID if this service package has a pending renewal or null.")
  public String getNextId() {
    return nextId;
  }

  public void setNextId(String nextId) {
    this.nextId = nextId;
  }

  public PreviousServicePackage previousId(String previousId) {
    this.previousId = previousId;
    return this;
  }

   /**
   * Previous service package ID.
   * @return previousId
  **/
  @ApiModelProperty(value = "Previous service package ID.")
  public String getPreviousId() {
    return previousId;
  }

  public void setPreviousId(String previousId) {
    this.previousId = previousId;
  }

  public PreviousServicePackage reason(ReasonEnum reason) {
    this.reason = reason;
    return this;
  }

   /**
   * Reason why this service package was ended
   * @return reason
  **/
  @ApiModelProperty(required = true, value = "Reason why this service package was ended")
  public ReasonEnum getReason() {
    return reason;
  }

  public void setReason(ReasonEnum reason) {
    this.reason = reason;
  }

  public PreviousServicePackage startTime(DateTime startTime) {
    this.startTime = startTime;
    return this;
  }

   /**
   * Service package start time in RFC3339 date-time with UTC time zone.
   * @return startTime
  **/
  @ApiModelProperty(required = true, value = "Service package start time in RFC3339 date-time with UTC time zone.")
  public DateTime getStartTime() {
    return startTime;
  }

  public void setStartTime(DateTime startTime) {
    this.startTime = startTime;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    PreviousServicePackage previousServicePackage = (PreviousServicePackage) o;
    return Objects.equals(this.created, previousServicePackage.created) &&
        Objects.equals(this.endTime, previousServicePackage.endTime) &&
        Objects.equals(this.expires, previousServicePackage.expires) &&
        Objects.equals(this.firmwareUpdateCount, previousServicePackage.firmwareUpdateCount) &&
        Objects.equals(this.id, previousServicePackage.id) &&
        Objects.equals(this.modified, previousServicePackage.modified) &&
        Objects.equals(this.nextId, previousServicePackage.nextId) &&
        Objects.equals(this.previousId, previousServicePackage.previousId) &&
        Objects.equals(this.reason, previousServicePackage.reason) &&
        Objects.equals(this.startTime, previousServicePackage.startTime);
  }

  @Override
  public int hashCode() {
    return Objects.hash(created, endTime, expires, firmwareUpdateCount, id, modified, nextId, previousId, reason, startTime);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class PreviousServicePackage {\n");
    
    sb.append("    created: ").append(toIndentedString(created)).append("\n");
    sb.append("    endTime: ").append(toIndentedString(endTime)).append("\n");
    sb.append("    expires: ").append(toIndentedString(expires)).append("\n");
    sb.append("    firmwareUpdateCount: ").append(toIndentedString(firmwareUpdateCount)).append("\n");
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    modified: ").append(toIndentedString(modified)).append("\n");
    sb.append("    nextId: ").append(toIndentedString(nextId)).append("\n");
    sb.append("    previousId: ").append(toIndentedString(previousId)).append("\n");
    sb.append("    reason: ").append(toIndentedString(reason)).append("\n");
    sb.append("    startTime: ").append(toIndentedString(startTime)).append("\n");
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

