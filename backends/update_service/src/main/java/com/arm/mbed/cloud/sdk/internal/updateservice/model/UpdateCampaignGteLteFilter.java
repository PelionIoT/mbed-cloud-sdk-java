/*
 * Update Service API
 * This is the API documentation for the Mbed deployment service, which is part of the update service.
 *
 * OpenAPI spec version: 3
 * 
 *
 * NOTE: This class is auto generated by the swagger code generator program.
 * https://github.com/swagger-api/swagger-codegen.git
 * Do not edit the class manually.
 */


package com.arm.mbed.cloud.sdk.internal.updateservice.model;

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
 * UpdateCampaignGteLteFilter
 */

public class UpdateCampaignGteLteFilter implements Serializable {
  private static final long serialVersionUID = 1L;

  @SerializedName("created_at")
  private DateTime createdAt = null;

  @SerializedName("etag")
  private DateTime etag = null;

  @SerializedName("finished")
  private DateTime finished = null;

  @SerializedName("started_at")
  private DateTime startedAt = null;

  @SerializedName("updated_at")
  private DateTime updatedAt = null;

  @SerializedName("when")
  private DateTime when = null;

  public UpdateCampaignGteLteFilter createdAt(DateTime createdAt) {
    this.createdAt = createdAt;
    return this;
  }

   /**
   * Get createdAt
   * @return createdAt
  **/
  @ApiModelProperty(value = "")
  public DateTime getCreatedAt() {
    return createdAt;
  }

  public void setCreatedAt(DateTime createdAt) {
    this.createdAt = createdAt;
  }

  public UpdateCampaignGteLteFilter etag(DateTime etag) {
    this.etag = etag;
    return this;
  }

   /**
   * Get etag
   * @return etag
  **/
  @ApiModelProperty(value = "")
  public DateTime getEtag() {
    return etag;
  }

  public void setEtag(DateTime etag) {
    this.etag = etag;
  }

  public UpdateCampaignGteLteFilter finished(DateTime finished) {
    this.finished = finished;
    return this;
  }

   /**
   * Get finished
   * @return finished
  **/
  @ApiModelProperty(value = "")
  public DateTime getFinished() {
    return finished;
  }

  public void setFinished(DateTime finished) {
    this.finished = finished;
  }

  public UpdateCampaignGteLteFilter startedAt(DateTime startedAt) {
    this.startedAt = startedAt;
    return this;
  }

   /**
   * Get startedAt
   * @return startedAt
  **/
  @ApiModelProperty(value = "")
  public DateTime getStartedAt() {
    return startedAt;
  }

  public void setStartedAt(DateTime startedAt) {
    this.startedAt = startedAt;
  }

  public UpdateCampaignGteLteFilter updatedAt(DateTime updatedAt) {
    this.updatedAt = updatedAt;
    return this;
  }

   /**
   * Get updatedAt
   * @return updatedAt
  **/
  @ApiModelProperty(value = "")
  public DateTime getUpdatedAt() {
    return updatedAt;
  }

  public void setUpdatedAt(DateTime updatedAt) {
    this.updatedAt = updatedAt;
  }

  public UpdateCampaignGteLteFilter when(DateTime when) {
    this.when = when;
    return this;
  }

   /**
   * Get when
   * @return when
  **/
  @ApiModelProperty(value = "")
  public DateTime getWhen() {
    return when;
  }

  public void setWhen(DateTime when) {
    this.when = when;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    UpdateCampaignGteLteFilter updateCampaignGteLteFilter = (UpdateCampaignGteLteFilter) o;
    return Objects.equals(this.createdAt, updateCampaignGteLteFilter.createdAt) &&
        Objects.equals(this.etag, updateCampaignGteLteFilter.etag) &&
        Objects.equals(this.finished, updateCampaignGteLteFilter.finished) &&
        Objects.equals(this.startedAt, updateCampaignGteLteFilter.startedAt) &&
        Objects.equals(this.updatedAt, updateCampaignGteLteFilter.updatedAt) &&
        Objects.equals(this.when, updateCampaignGteLteFilter.when);
  }

  @Override
  public int hashCode() {
    return Objects.hash(createdAt, etag, finished, startedAt, updatedAt, when);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class UpdateCampaignGteLteFilter {\n");
    
    sb.append("    createdAt: ").append(toIndentedString(createdAt)).append("\n");
    sb.append("    etag: ").append(toIndentedString(etag)).append("\n");
    sb.append("    finished: ").append(toIndentedString(finished)).append("\n");
    sb.append("    startedAt: ").append(toIndentedString(startedAt)).append("\n");
    sb.append("    updatedAt: ").append(toIndentedString(updatedAt)).append("\n");
    sb.append("    when: ").append(toIndentedString(when)).append("\n");
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

