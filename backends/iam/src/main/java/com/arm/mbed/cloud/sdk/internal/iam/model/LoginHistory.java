/*
 * Account Management API
 * API for managing accounts, users, creating API keys, uploading trusted certificates
 *
 * OpenAPI spec version: v3
 * 
 *
 * NOTE: This class is auto generated by the swagger code generator program.
 * https://github.com/swagger-api/swagger-codegen.git
 * Do not edit the class manually.
 */


package com.arm.mbed.cloud.sdk.internal.iam.model;

import java.util.Objects;
import com.google.gson.annotations.SerializedName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.joda.time.DateTime;
import java.io.Serializable;

/**
 * LoginHistory
 */

public class LoginHistory implements Serializable {
  private static final long serialVersionUID = 1L;

  @SerializedName("date")
  private DateTime date = null;

  @SerializedName("ip_address")
  private String ipAddress = null;

  @SerializedName("user_agent")
  private String userAgent = null;

  @SerializedName("success")
  private Boolean success = null;

  public LoginHistory date(DateTime date) {
    this.date = date;
    return this;
  }

   /**
   * UTC time RFC3339 for this login attempt.
   * @return date
  **/
  @ApiModelProperty(example = "null", required = true, value = "UTC time RFC3339 for this login attempt.")
  public DateTime getDate() {
    return date;
  }

  public void setDate(DateTime date) {
    this.date = date;
  }

  public LoginHistory ipAddress(String ipAddress) {
    this.ipAddress = ipAddress;
    return this;
  }

   /**
   * IP address of the client.
   * @return ipAddress
  **/
  @ApiModelProperty(example = "null", required = true, value = "IP address of the client.")
  public String getIpAddress() {
    return ipAddress;
  }

  public void setIpAddress(String ipAddress) {
    this.ipAddress = ipAddress;
  }

  public LoginHistory userAgent(String userAgent) {
    this.userAgent = userAgent;
    return this;
  }

   /**
   * User Agent header from the login request.
   * @return userAgent
  **/
  @ApiModelProperty(example = "null", required = true, value = "User Agent header from the login request.")
  public String getUserAgent() {
    return userAgent;
  }

  public void setUserAgent(String userAgent) {
    this.userAgent = userAgent;
  }

  public LoginHistory success(Boolean success) {
    this.success = success;
    return this;
  }

   /**
   * Flag indicating whether login attempt was successful or not.
   * @return success
  **/
  @ApiModelProperty(example = "null", required = true, value = "Flag indicating whether login attempt was successful or not.")
  public Boolean getSuccess() {
    return success;
  }

  public void setSuccess(Boolean success) {
    this.success = success;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    LoginHistory loginHistory = (LoginHistory) o;
    return Objects.equals(this.date, loginHistory.date) &&
        Objects.equals(this.ipAddress, loginHistory.ipAddress) &&
        Objects.equals(this.userAgent, loginHistory.userAgent) &&
        Objects.equals(this.success, loginHistory.success);
  }

  @Override
  public int hashCode() {
    return Objects.hash(date, ipAddress, userAgent, success);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class LoginHistory {\n");
    
    sb.append("    date: ").append(toIndentedString(date)).append("\n");
    sb.append("    ipAddress: ").append(toIndentedString(ipAddress)).append("\n");
    sb.append("    userAgent: ").append(toIndentedString(userAgent)).append("\n");
    sb.append("    success: ").append(toIndentedString(success)).append("\n");
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

