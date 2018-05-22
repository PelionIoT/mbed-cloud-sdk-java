/*
 * Bootstrap API
 * Mbed Cloud Bootstrap API allows web applications to control the device bootstrapping process.
 *
 * OpenAPI spec version: 2
 * 
 *
 * NOTE: This class is auto generated by the swagger code generator program.
 * https://github.com/swagger-api/swagger-codegen.git
 * Do not edit the class manually.
 */


package com.arm.mbed.cloud.sdk.internal.connectorbootstrap.model;

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
 * PreSharedKeyWithoutSecret
 */

public class PreSharedKeyWithoutSecret implements Serializable {
  private static final long serialVersionUID = 1L;

  @SerializedName("created_at")
  private DateTime createdAt = null;

  @SerializedName("endpoint_name")
  private String endpointName = null;

  public PreSharedKeyWithoutSecret createdAt(DateTime createdAt) {
    this.createdAt = createdAt;
    return this;
  }

   /**
   * The date-time (RFC3339) when this pre-shared key was uploaded to Mbed Cloud.
   * @return createdAt
  **/
  @ApiModelProperty(example = "2017-07-21T17:32:28.012Z", value = "The date-time (RFC3339) when this pre-shared key was uploaded to Mbed Cloud.")
  public DateTime getCreatedAt() {
    return createdAt;
  }

  public void setCreatedAt(DateTime createdAt) {
    this.createdAt = createdAt;
  }

  public PreSharedKeyWithoutSecret endpointName(String endpointName) {
    this.endpointName = endpointName;
    return this;
  }

   /**
   * The unique endpoint identifier that this pre-shared key applies to. 16-64 [printable](https://en.wikipedia.org/wiki/ASCII#Printable_characters) (non-control) ASCII characters.
   * @return endpointName
  **/
  @ApiModelProperty(example = "myEndpoint.host.com", required = true, value = "The unique endpoint identifier that this pre-shared key applies to. 16-64 [printable](https://en.wikipedia.org/wiki/ASCII#Printable_characters) (non-control) ASCII characters.")
  public String getEndpointName() {
    return endpointName;
  }

  public void setEndpointName(String endpointName) {
    this.endpointName = endpointName;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    PreSharedKeyWithoutSecret preSharedKeyWithoutSecret = (PreSharedKeyWithoutSecret) o;
    return Objects.equals(this.createdAt, preSharedKeyWithoutSecret.createdAt) &&
        Objects.equals(this.endpointName, preSharedKeyWithoutSecret.endpointName);
  }

  @Override
  public int hashCode() {
    return Objects.hash(createdAt, endpointName);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class PreSharedKeyWithoutSecret {\n");
    
    sb.append("    createdAt: ").append(toIndentedString(createdAt)).append("\n");
    sb.append("    endpointName: ").append(toIndentedString(endpointName)).append("\n");
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

