/*
 * Update Service API
 * This is the API Documentation for the mbed deployment service which is part of the update service.
 *
 * OpenAPI spec version: 3
 * 
 *
 * NOTE: This class is auto generated by the swagger code generator program.
 * https://github.com/swagger-api/swagger-codegen.git
 * Do not edit the class manually.
 */


package com.arm.mbed.cloud.sdk.internal.model;

import java.util.Objects;
import com.arm.mbed.cloud.sdk.internal.model.ManifestContents;
import com.google.gson.annotations.SerializedName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.joda.time.DateTime;
import java.io.Serializable;

/**
 * FirmwareManifest
 */

public class FirmwareManifest implements Serializable {
  private static final long serialVersionUID = 1L;

  @SerializedName("datafile")
  private byte[] datafile = null;

  @SerializedName("description")
  private String description = null;

  @SerializedName("timestamp")
  private DateTime timestamp = null;

  @SerializedName("created_at")
  private DateTime createdAt = null;

  @SerializedName("object")
  private String object = null;

  @SerializedName("updated_at")
  private DateTime updatedAt = null;

  @SerializedName("manifest_contents")
  private ManifestContents manifestContents = null;

  @SerializedName("etag")
  private DateTime etag = null;

  @SerializedName("device_class")
  private String deviceClass = null;

  @SerializedName("id")
  private String id = null;

  @SerializedName("name")
  private String name = null;

  public FirmwareManifest datafile(byte[] datafile) {
    this.datafile = datafile;
    return this;
  }

   /**
   * Get datafile
   * @return datafile
  **/
  @ApiModelProperty(example = "null", required = true, value = "")
  public byte[] getDatafile() {
    return datafile;
  }

  public void setDatafile(byte[] datafile) {
    this.datafile = datafile;
  }

  public FirmwareManifest description(String description) {
    this.description = description;
    return this;
  }

   /**
   * The description of the object.
   * @return description
  **/
  @ApiModelProperty(example = "null", required = true, value = "The description of the object.")
  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public FirmwareManifest timestamp(DateTime timestamp) {
    this.timestamp = timestamp;
    return this;
  }

   /**
   * The version of the firmware manifest (as a timestamp).
   * @return timestamp
  **/
  @ApiModelProperty(example = "null", required = true, value = "The version of the firmware manifest (as a timestamp).")
  public DateTime getTimestamp() {
    return timestamp;
  }

  public void setTimestamp(DateTime timestamp) {
    this.timestamp = timestamp;
  }

  public FirmwareManifest createdAt(DateTime createdAt) {
    this.createdAt = createdAt;
    return this;
  }

   /**
   * The time the object was created.
   * @return createdAt
  **/
  @ApiModelProperty(example = "null", required = true, value = "The time the object was created.")
  public DateTime getCreatedAt() {
    return createdAt;
  }

  public void setCreatedAt(DateTime createdAt) {
    this.createdAt = createdAt;
  }

  public FirmwareManifest object(String object) {
    this.object = object;
    return this;
  }

   /**
   * The API resource entity.
   * @return object
  **/
  @ApiModelProperty(example = "null", required = true, value = "The API resource entity.")
  public String getObject() {
    return object;
  }

  public void setObject(String object) {
    this.object = object;
  }

  public FirmwareManifest updatedAt(DateTime updatedAt) {
    this.updatedAt = updatedAt;
    return this;
  }

   /**
   * The time the object was updated.
   * @return updatedAt
  **/
  @ApiModelProperty(example = "null", required = true, value = "The time the object was updated.")
  public DateTime getUpdatedAt() {
    return updatedAt;
  }

  public void setUpdatedAt(DateTime updatedAt) {
    this.updatedAt = updatedAt;
  }

  public FirmwareManifest manifestContents(ManifestContents manifestContents) {
    this.manifestContents = manifestContents;
    return this;
  }

   /**
   * Get manifestContents
   * @return manifestContents
  **/
  @ApiModelProperty(example = "null", required = true, value = "")
  public ManifestContents getManifestContents() {
    return manifestContents;
  }

  public void setManifestContents(ManifestContents manifestContents) {
    this.manifestContents = manifestContents;
  }

  public FirmwareManifest etag(DateTime etag) {
    this.etag = etag;
    return this;
  }

   /**
   * The entity instance signature.
   * @return etag
  **/
  @ApiModelProperty(example = "null", required = true, value = "The entity instance signature.")
  public DateTime getEtag() {
    return etag;
  }

  public void setEtag(DateTime etag) {
    this.etag = etag;
  }

  public FirmwareManifest deviceClass(String deviceClass) {
    this.deviceClass = deviceClass;
    return this;
  }

   /**
   * The class of device.
   * @return deviceClass
  **/
  @ApiModelProperty(example = "null", required = true, value = "The class of device.")
  public String getDeviceClass() {
    return deviceClass;
  }

  public void setDeviceClass(String deviceClass) {
    this.deviceClass = deviceClass;
  }

  public FirmwareManifest id(String id) {
    this.id = id;
    return this;
  }

   /**
   * The ID of the firmware manifest.
   * @return id
  **/
  @ApiModelProperty(example = "null", required = true, value = "The ID of the firmware manifest.")
  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public FirmwareManifest name(String name) {
    this.name = name;
    return this;
  }

   /**
   * The name of the object.
   * @return name
  **/
  @ApiModelProperty(example = "null", required = true, value = "The name of the object.")
  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    FirmwareManifest firmwareManifest = (FirmwareManifest) o;
    return Objects.equals(this.datafile, firmwareManifest.datafile) &&
        Objects.equals(this.description, firmwareManifest.description) &&
        Objects.equals(this.timestamp, firmwareManifest.timestamp) &&
        Objects.equals(this.createdAt, firmwareManifest.createdAt) &&
        Objects.equals(this.object, firmwareManifest.object) &&
        Objects.equals(this.updatedAt, firmwareManifest.updatedAt) &&
        Objects.equals(this.manifestContents, firmwareManifest.manifestContents) &&
        Objects.equals(this.etag, firmwareManifest.etag) &&
        Objects.equals(this.deviceClass, firmwareManifest.deviceClass) &&
        Objects.equals(this.id, firmwareManifest.id) &&
        Objects.equals(this.name, firmwareManifest.name);
  }

  @Override
  public int hashCode() {
    return Objects.hash(datafile, description, timestamp, createdAt, object, updatedAt, manifestContents, etag, deviceClass, id, name);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class FirmwareManifest {\n");
    
    sb.append("    datafile: ").append(toIndentedString(datafile)).append("\n");
    sb.append("    description: ").append(toIndentedString(description)).append("\n");
    sb.append("    timestamp: ").append(toIndentedString(timestamp)).append("\n");
    sb.append("    createdAt: ").append(toIndentedString(createdAt)).append("\n");
    sb.append("    object: ").append(toIndentedString(object)).append("\n");
    sb.append("    updatedAt: ").append(toIndentedString(updatedAt)).append("\n");
    sb.append("    manifestContents: ").append(toIndentedString(manifestContents)).append("\n");
    sb.append("    etag: ").append(toIndentedString(etag)).append("\n");
    sb.append("    deviceClass: ").append(toIndentedString(deviceClass)).append("\n");
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
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
