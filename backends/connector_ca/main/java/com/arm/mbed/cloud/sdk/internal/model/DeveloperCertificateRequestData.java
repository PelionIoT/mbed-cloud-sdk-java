/*
 * Connect CA API
 * Connect CA API provides methods to create and get Developer certificate. Also Connect CA provides server-credentials for Bootstarp and LWM2M Server.
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
import com.google.gson.annotations.SerializedName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;

/**
 * DeveloperCertificateRequestData
 */

public class DeveloperCertificateRequestData implements Serializable {
  private static final long serialVersionUID = 1L;

  @SerializedName("name")
  private String name = null;

  @SerializedName("description")
  private String description = null;

  public DeveloperCertificateRequestData name(String name) {
    this.name = name;
    return this;
  }

   /**
   * The name of the developer certificate, must be unique.
   * @return name
  **/
  @ApiModelProperty(example = "null", required = true, value = "The name of the developer certificate, must be unique.")
  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public DeveloperCertificateRequestData description(String description) {
    this.description = description;
    return this;
  }

   /**
   * A description for the developer certificate.
   * @return description
  **/
  @ApiModelProperty(example = "null", value = "A description for the developer certificate.")
  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    DeveloperCertificateRequestData developerCertificateRequestData = (DeveloperCertificateRequestData) o;
    return Objects.equals(this.name, developerCertificateRequestData.name) &&
        Objects.equals(this.description, developerCertificateRequestData.description);
  }

  @Override
  public int hashCode() {
    return Objects.hash(name, description);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class DeveloperCertificateRequestData {\n");
    
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    description: ").append(toIndentedString(description)).append("\n");
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

