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
import com.google.gson.TypeAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.io.Serializable;

/**
 * This object represents a user in requests towards mbed Cloud.
 */
@ApiModel(description = "This object represents a user in requests towards mbed Cloud.")

public class UserUpdateReq implements Serializable {
  private static final long serialVersionUID = 1L;

  @SerializedName("address")
  private String address = null;

  @SerializedName("email")
  private String email = null;

  @SerializedName("full_name")
  private String fullName = null;

  @SerializedName("groups")
  private List<String> groups = null;

  @SerializedName("is_gtc_accepted")
  private Boolean isGtcAccepted = null;

  @SerializedName("is_marketing_accepted")
  private Boolean isMarketingAccepted = null;

  @SerializedName("is_totp_enabled")
  private Boolean isTotpEnabled = null;

  @SerializedName("phone_number")
  private String phoneNumber = null;

  @SerializedName("status")
  private String status = null;

  @SerializedName("username")
  private String username = null;

  public UserUpdateReq address(String address) {
    this.address = address;
    return this;
  }

   /**
   * Address, not longer than 100 characters.
   * @return address
  **/
  @ApiModelProperty(value = "Address, not longer than 100 characters.")
  public String getAddress() {
    return address;
  }

  public void setAddress(String address) {
    this.address = address;
  }

  public UserUpdateReq email(String email) {
    this.email = email;
    return this;
  }

   /**
   * The email address, not longer than 254 characters.
   * @return email
  **/
  @ApiModelProperty(value = "The email address, not longer than 254 characters.")
  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public UserUpdateReq fullName(String fullName) {
    this.fullName = fullName;
    return this;
  }

   /**
   * The full name of the user, not longer than 100 characters.
   * @return fullName
  **/
  @ApiModelProperty(value = "The full name of the user, not longer than 100 characters.")
  public String getFullName() {
    return fullName;
  }

  public void setFullName(String fullName) {
    this.fullName = fullName;
  }

  public UserUpdateReq groups(List<String> groups) {
    this.groups = groups;
    return this;
  }

  public UserUpdateReq addGroupsItem(String groupsItem) {
    if (this.groups == null) {
      this.groups = new ArrayList<String>();
    }
    this.groups.add(groupsItem);
    return this;
  }

   /**
   * A list of group IDs this user belongs to.
   * @return groups
  **/
  @ApiModelProperty(value = "A list of group IDs this user belongs to.")
  public List<String> getGroups() {
    return groups;
  }

  public void setGroups(List<String> groups) {
    this.groups = groups;
  }

  public UserUpdateReq isGtcAccepted(Boolean isGtcAccepted) {
    this.isGtcAccepted = isGtcAccepted;
    return this;
  }

   /**
   * A flag indicating that the General Terms and Conditions has been accepted.
   * @return isGtcAccepted
  **/
  @ApiModelProperty(value = "A flag indicating that the General Terms and Conditions has been accepted.")
  public Boolean isIsGtcAccepted() {
    return isGtcAccepted;
  }

  public void setIsGtcAccepted(Boolean isGtcAccepted) {
    this.isGtcAccepted = isGtcAccepted;
  }

  public UserUpdateReq isMarketingAccepted(Boolean isMarketingAccepted) {
    this.isMarketingAccepted = isMarketingAccepted;
    return this;
  }

   /**
   * A flag indicating that receiving marketing information has been accepted.
   * @return isMarketingAccepted
  **/
  @ApiModelProperty(value = "A flag indicating that receiving marketing information has been accepted.")
  public Boolean isIsMarketingAccepted() {
    return isMarketingAccepted;
  }

  public void setIsMarketingAccepted(Boolean isMarketingAccepted) {
    this.isMarketingAccepted = isMarketingAccepted;
  }

  public UserUpdateReq isTotpEnabled(Boolean isTotpEnabled) {
    this.isTotpEnabled = isTotpEnabled;
    return this;
  }

   /**
   * A flag indicating whether 2-factor authentication (TOTP) has to be enabled or disabled.
   * @return isTotpEnabled
  **/
  @ApiModelProperty(value = "A flag indicating whether 2-factor authentication (TOTP) has to be enabled or disabled.")
  public Boolean isIsTotpEnabled() {
    return isTotpEnabled;
  }

  public void setIsTotpEnabled(Boolean isTotpEnabled) {
    this.isTotpEnabled = isTotpEnabled;
  }

  public UserUpdateReq phoneNumber(String phoneNumber) {
    this.phoneNumber = phoneNumber;
    return this;
  }

   /**
   * Phone number, not longer than 100 characters.
   * @return phoneNumber
  **/
  @ApiModelProperty(value = "Phone number, not longer than 100 characters.")
  public String getPhoneNumber() {
    return phoneNumber;
  }

  public void setPhoneNumber(String phoneNumber) {
    this.phoneNumber = phoneNumber;
  }

  public UserUpdateReq status(String status) {
    this.status = status;
    return this;
  }

   /**
   * The status of the user.
   * @return status
  **/
  @ApiModelProperty(value = "The status of the user.")
  public String getStatus() {
    return status;
  }

  public void setStatus(String status) {
    this.status = status;
  }

  public UserUpdateReq username(String username) {
    this.username = username;
    return this;
  }

   /**
   * A username containing alphanumerical letters and -,._@+&#x3D; characters. It must be at least 4 but not more than 30 character long.
   * @return username
  **/
  @ApiModelProperty(value = "A username containing alphanumerical letters and -,._@+= characters. It must be at least 4 but not more than 30 character long.")
  public String getUsername() {
    return username;
  }

  public void setUsername(String username) {
    this.username = username;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    UserUpdateReq userUpdateReq = (UserUpdateReq) o;
    return Objects.equals(this.address, userUpdateReq.address) &&
        Objects.equals(this.email, userUpdateReq.email) &&
        Objects.equals(this.fullName, userUpdateReq.fullName) &&
        Objects.equals(this.groups, userUpdateReq.groups) &&
        Objects.equals(this.isGtcAccepted, userUpdateReq.isGtcAccepted) &&
        Objects.equals(this.isMarketingAccepted, userUpdateReq.isMarketingAccepted) &&
        Objects.equals(this.isTotpEnabled, userUpdateReq.isTotpEnabled) &&
        Objects.equals(this.phoneNumber, userUpdateReq.phoneNumber) &&
        Objects.equals(this.status, userUpdateReq.status) &&
        Objects.equals(this.username, userUpdateReq.username);
  }

  @Override
  public int hashCode() {
    return Objects.hash(address, email, fullName, groups, isGtcAccepted, isMarketingAccepted, isTotpEnabled, phoneNumber, status, username);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class UserUpdateReq {\n");
    
    sb.append("    address: ").append(toIndentedString(address)).append("\n");
    sb.append("    email: ").append(toIndentedString(email)).append("\n");
    sb.append("    fullName: ").append(toIndentedString(fullName)).append("\n");
    sb.append("    groups: ").append(toIndentedString(groups)).append("\n");
    sb.append("    isGtcAccepted: ").append(toIndentedString(isGtcAccepted)).append("\n");
    sb.append("    isMarketingAccepted: ").append(toIndentedString(isMarketingAccepted)).append("\n");
    sb.append("    isTotpEnabled: ").append(toIndentedString(isTotpEnabled)).append("\n");
    sb.append("    phoneNumber: ").append(toIndentedString(phoneNumber)).append("\n");
    sb.append("    status: ").append(toIndentedString(status)).append("\n");
    sb.append("    username: ").append(toIndentedString(username)).append("\n");
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

