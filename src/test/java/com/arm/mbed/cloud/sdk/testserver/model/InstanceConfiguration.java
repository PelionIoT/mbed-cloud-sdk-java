/*
 * Mbed Cloud SDK Test Server
 * This is the specification of Mbed Cloud SDK test servers
 *
 * OpenAPI spec version: 1.0.0
 * Contact: ISG-cloud-eng-tools@arm.com
 *
 * NOTE: This class is auto generated by the swagger code generator program.
 * https://github.com/swagger-api/swagger-codegen.git
 * Do not edit the class manually.
 */


package com.arm.mbed.cloud.sdk.testserver.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.HashMap;
import java.util.Map;
import java.io.Serializable;

/**
 * Connection options to apply
 */
@ApiModel(description = "Connection options to apply")

public class InstanceConfiguration extends HashMap<String, Object> implements Serializable {
  private static final long serialVersionUID = 1L;

  @JsonProperty("apiKeys")
  private String apiKeys = null;

  @JsonProperty("host")
  private String host = null;

  @JsonProperty("autoStartDaemon")
  private Boolean autoStartDaemon = null;

  public InstanceConfiguration apiKeys(String apiKeys) {
    this.apiKeys = apiKeys;
    return this;
  }

   /**
   * Get apiKeys
   * @return apiKeys
  **/
  @ApiModelProperty(value = "")
  public String getApiKeys() {
    return apiKeys;
  }

  public void setApiKeys(String apiKeys) {
    this.apiKeys = apiKeys;
  }

  public InstanceConfiguration host(String host) {
    this.host = host;
    return this;
  }

   /**
   * Get host
   * @return host
  **/
  @ApiModelProperty(value = "")
  public String getHost() {
    return host;
  }

  public void setHost(String host) {
    this.host = host;
  }

  public InstanceConfiguration autoStartDaemon(Boolean autoStartDaemon) {
    this.autoStartDaemon = autoStartDaemon;
    return this;
  }

   /**
   * Get autoStartDaemon
   * @return autoStartDaemon
  **/
  @ApiModelProperty(value = "")
  public Boolean isAutoStartDaemon() {
    return autoStartDaemon;
  }

  public void setAutoStartDaemon(Boolean autoStartDaemon) {
    this.autoStartDaemon = autoStartDaemon;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    InstanceConfiguration instanceConfiguration = (InstanceConfiguration) o;
    return Objects.equals(this.apiKeys, instanceConfiguration.apiKeys) &&
        Objects.equals(this.host, instanceConfiguration.host) &&
        Objects.equals(this.autoStartDaemon, instanceConfiguration.autoStartDaemon) &&
        super.equals(o);
  }

  @Override
  public int hashCode() {
    return Objects.hash(apiKeys, host, autoStartDaemon, super.hashCode());
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class InstanceConfiguration {\n");
    sb.append("    ").append(toIndentedString(super.toString())).append("\n");
    sb.append("    apiKeys: ").append(toIndentedString(apiKeys)).append("\n");
    sb.append("    host: ").append(toIndentedString(host)).append("\n");
    sb.append("    autoStartDaemon: ").append(toIndentedString(autoStartDaemon)).append("\n");
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

