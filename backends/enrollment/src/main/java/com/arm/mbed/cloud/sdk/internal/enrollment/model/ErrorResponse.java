/*
 * Enrollment API
 * Connect Enrollment Service allows users to claim the ownership of a device which is not yet assigned to an account. A device without an assigned account can be a device purchased from the open market (OEM dealer) or a device transferred from an account to another. More information in [Device ownership: First-to-claim](/docs/current/connecting/device-ownership-first-to-claim-by-enrollment-list.html) document. 
 *
 * OpenAPI spec version: 3
 * 
 *
 * NOTE: This class is auto generated by the swagger code generator program.
 * https://github.com/swagger-api/swagger-codegen.git
 * Do not edit the class manually.
 */


package com.arm.mbed.cloud.sdk.internal.enrollment.model;

import java.util.Objects;
import com.arm.mbed.cloud.sdk.internal.enrollment.model.Field;
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

  /**
   * Response code.
   */
  @JsonAdapter(CodeEnum.Adapter.class)
  public enum CodeEnum {
    NUMBER_400(400),
    
    NUMBER_401(401),
    
    NUMBER_404(404);

    private Integer value;

    CodeEnum(Integer value) {
      this.value = value;
    }

    public Integer getValue() {
      return value;
    }

    @Override
    public String toString() {
      return String.valueOf(value);
    }

    public static CodeEnum fromValue(String text) {
      for (CodeEnum b : CodeEnum.values()) {
        if (String.valueOf(b.value).equals(text)) {
          return b;
        }
      }
      return null;
    }

    public static class Adapter extends TypeAdapter<CodeEnum> {
      @Override
      public void write(final JsonWriter jsonWriter, final CodeEnum enumeration) throws IOException {
        jsonWriter.value(enumeration.getValue());
      }

      @Override
      public CodeEnum read(final JsonReader jsonReader) throws IOException {
        Integer value = jsonReader.nextInt();
        return CodeEnum.fromValue(String.valueOf(value));
      }
    }
  }

  @SerializedName("code")
  private CodeEnum code = null;

  @SerializedName("fields")
  private List<Field> fields = null;

  @SerializedName("message")
  private String message = null;

  /**
   * Entity name, always &#39;error&#39;.
   */
  @JsonAdapter(ObjectEnum.Adapter.class)
  public enum ObjectEnum {
    ERROR("error");

    private String value;

    ObjectEnum(String value) {
      this.value = value;
    }

    public String getValue() {
      return value;
    }

    @Override
    public String toString() {
      return String.valueOf(value);
    }

    public static ObjectEnum fromValue(String text) {
      for (ObjectEnum b : ObjectEnum.values()) {
        if (String.valueOf(b.value).equals(text)) {
          return b;
        }
      }
      return null;
    }

    public static class Adapter extends TypeAdapter<ObjectEnum> {
      @Override
      public void write(final JsonWriter jsonWriter, final ObjectEnum enumeration) throws IOException {
        jsonWriter.value(enumeration.getValue());
      }

      @Override
      public ObjectEnum read(final JsonReader jsonReader) throws IOException {
        String value = jsonReader.nextString();
        return ObjectEnum.fromValue(String.valueOf(value));
      }
    }
  }

  @SerializedName("object")
  private ObjectEnum object = ObjectEnum.ERROR;

  @SerializedName("request_id")
  private String requestId = null;

  /**
   * Error type.
   */
  @JsonAdapter(TypeEnum.Adapter.class)
  public enum TypeEnum {
    VALIDATION_ERROR("validation_error"),
    
    INVALID_TOKEN("invalid_token"),
    
    INVALID_APIKEY("invalid_apikey"),
    
    REAUTH_REQUIRED("reauth_required"),
    
    ACCESS_DENIED("access_denied"),
    
    ACCOUNT_LIMIT_EXCEEDED("account_limit_exceeded"),
    
    NOT_FOUND("not_found"),
    
    METHOD_NOT_SUPPORTED("method_not_supported"),
    
    NOT_ACCEPTABLE("not_acceptable"),
    
    DUPLICATE("duplicate"),
    
    PRECONDITION_FAILED("precondition_failed"),
    
    UNSUPPORTED_MEDIA_TYPE("unsupported_media_type"),
    
    RATE_LIMIT_EXCEEDED("rate_limit_exceeded"),
    
    INTERNAL_SERVER_ERROR("internal_server_error"),
    
    SYSTEM_UNAVAILABLE("system_unavailable");

    private String value;

    TypeEnum(String value) {
      this.value = value;
    }

    public String getValue() {
      return value;
    }

    @Override
    public String toString() {
      return String.valueOf(value);
    }

    public static TypeEnum fromValue(String text) {
      for (TypeEnum b : TypeEnum.values()) {
        if (String.valueOf(b.value).equals(text)) {
          return b;
        }
      }
      return null;
    }

    public static class Adapter extends TypeAdapter<TypeEnum> {
      @Override
      public void write(final JsonWriter jsonWriter, final TypeEnum enumeration) throws IOException {
        jsonWriter.value(enumeration.getValue());
      }

      @Override
      public TypeEnum read(final JsonReader jsonReader) throws IOException {
        String value = jsonReader.nextString();
        return TypeEnum.fromValue(String.valueOf(value));
      }
    }
  }

  @SerializedName("type")
  private TypeEnum type = null;

  public ErrorResponse code(CodeEnum code) {
    this.code = code;
    return this;
  }

   /**
   * Response code.
   * @return code
  **/
  @ApiModelProperty(example = "400", value = "Response code.")
  public CodeEnum getCode() {
    return code;
  }

  public void setCode(CodeEnum code) {
    this.code = code;
  }

  public ErrorResponse fields(List<Field> fields) {
    this.fields = fields;
    return this;
  }

  public ErrorResponse addFieldsItem(Field fieldsItem) {
    if (this.fields == null) {
      this.fields = new ArrayList<Field>();
    }
    this.fields.add(fieldsItem);
    return this;
  }

   /**
   * Failed input fields during request object validation.
   * @return fields
  **/
  @ApiModelProperty(example = "[{\"enrollment_identity\":\"Invalid enrollment identity\"}]", value = "Failed input fields during request object validation.")
  public List<Field> getFields() {
    return fields;
  }

  public void setFields(List<Field> fields) {
    this.fields = fields;
  }

  public ErrorResponse message(String message) {
    this.message = message;
    return this;
  }

   /**
   * A human readable message with detailed info.
   * @return message
  **/
  @ApiModelProperty(example = "An error description.", value = "A human readable message with detailed info.")
  public String getMessage() {
    return message;
  }

  public void setMessage(String message) {
    this.message = message;
  }

  public ErrorResponse object(ObjectEnum object) {
    this.object = object;
    return this;
  }

   /**
   * Entity name, always &#39;error&#39;.
   * @return object
  **/
  @ApiModelProperty(example = "error", value = "Entity name, always 'error'.")
  public ObjectEnum getObject() {
    return object;
  }

  public void setObject(ObjectEnum object) {
    this.object = object;
  }

  public ErrorResponse requestId(String requestId) {
    this.requestId = requestId;
    return this;
  }

   /**
   * Request ID.
   * @return requestId
  **/
  @ApiModelProperty(example = "00005a4e027f0a580a01081c00000000", value = "Request ID.")
  public String getRequestId() {
    return requestId;
  }

  public void setRequestId(String requestId) {
    this.requestId = requestId;
  }

  public ErrorResponse type(TypeEnum type) {
    this.type = type;
    return this;
  }

   /**
   * Error type.
   * @return type
  **/
  @ApiModelProperty(example = "validation_error", value = "Error type.")
  public TypeEnum getType() {
    return type;
  }

  public void setType(TypeEnum type) {
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

