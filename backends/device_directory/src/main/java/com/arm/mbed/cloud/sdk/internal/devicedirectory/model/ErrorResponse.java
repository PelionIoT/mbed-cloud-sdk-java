/*
 * Device Directory API
 * This is the API Documentation for the Mbed Device Directory service.
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
import com.arm.mbed.cloud.sdk.internal.devicedirectory.model.ErrorResponseFields;
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
 * ErrorResponse
 */

public class ErrorResponse implements Serializable {
  private static final long serialVersionUID = 1L;

  @SerializedName("code")
  private Integer code = null;

  @SerializedName("fields")
  private List<ErrorResponseFields> fields = null;

  @SerializedName("message")
  private String message = null;

  @SerializedName("object")
  private String object = null;

  @SerializedName("request_id")
  private String requestId = null;

  @SerializedName("type")
  private String type = null;

  public ErrorResponse code(Integer code) {
    this.code = code;
    return this;
  }

   /**
   * Response code
   * @return code
  **/
  @ApiModelProperty(example = "400", value = "Response code")
  public Integer getCode() {
    return code;
  }

  public void setCode(Integer code) {
    this.code = code;
  }

  public ErrorResponse fields(List<ErrorResponseFields> fields) {
    this.fields = fields;
    return this;
  }

  public ErrorResponse addFieldsItem(ErrorResponseFields fieldsItem) {
    if (this.fields == null) {
      this.fields = new ArrayList<ErrorResponseFields>();
    }
    this.fields.add(fieldsItem);
    return this;
  }

   /**
   * Get fields
   * @return fields
  **/
  @ApiModelProperty(value = "")
  public List<ErrorResponseFields> getFields() {
    return fields;
  }

  public void setFields(List<ErrorResponseFields> fields) {
    this.fields = fields;
  }

  public ErrorResponse message(String message) {
    this.message = message;
    return this;
  }

   /**
   * Get message
   * @return message
  **/
  @ApiModelProperty(example = "A human readable informative explanation", value = "")
  public String getMessage() {
    return message;
  }

  public void setMessage(String message) {
    this.message = message;
  }

  public ErrorResponse object(String object) {
    this.object = object;
    return this;
  }

   /**
   * Get object
   * @return object
  **/
  @ApiModelProperty(example = "error", value = "")
  public String getObject() {
    return object;
  }

  public void setObject(String object) {
    this.object = object;
  }

  public ErrorResponse requestId(String requestId) {
    this.requestId = requestId;
    return this;
  }

   /**
   * Get requestId
   * @return requestId
  **/
  @ApiModelProperty(example = "request_id", value = "")
  public String getRequestId() {
    return requestId;
  }

  public void setRequestId(String requestId) {
    this.requestId = requestId;
  }

  public ErrorResponse type(String type) {
    this.type = type;
    return this;
  }

   /**
   * Get type
   * @return type
  **/
  @ApiModelProperty(example = "validation_error", value = "")
  public String getType() {
    return type;
  }

  public void setType(String type) {
    this.type = type;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ErrorResponse errorResponse = (ErrorResponse) o;
    return Objects.equals(this.code, errorResponse.code) &&
        Objects.equals(this.fields, errorResponse.fields) &&
        Objects.equals(this.message, errorResponse.message) &&
        Objects.equals(this.object, errorResponse.object) &&
        Objects.equals(this.requestId, errorResponse.requestId) &&
        Objects.equals(this.type, errorResponse.type);
  }

  @Override
  public int hashCode() {
    return Objects.hash(code, fields, message, object, requestId, type);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ErrorResponse {\n");
    
    sb.append("    code: ").append(toIndentedString(code)).append("\n");
    sb.append("    fields: ").append(toIndentedString(fields)).append("\n");
    sb.append("    message: ").append(toIndentedString(message)).append("\n");
    sb.append("    object: ").append(toIndentedString(object)).append("\n");
    sb.append("    requestId: ").append(toIndentedString(requestId)).append("\n");
    sb.append("    type: ").append(toIndentedString(type)).append("\n");
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

