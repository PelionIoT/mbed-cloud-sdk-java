/*
 * Pelion Device Management API
 * Pelion Device Management API build from the publicly defined API definitions.
 *
 * OpenAPI spec version: 3
 * 
 *
 * NOTE: This class is auto generated by the swagger code generator program.
 * https://github.com/swagger-api/swagger-codegen.git
 * Do not edit the class manually.
 */

package com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.model;

import java.util.Objects;
import com.google.gson.annotations.SerializedName;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;

/**
 * Fields
 */

public class Fields implements Serializable {
    private static final long serialVersionUID = 1L;

    @SerializedName("message")
    private String message = null;

    @SerializedName("name")
    private String name = null;

    public Fields message(String message) {
        this.message = message;
        return this;
    }

    /**
     * Error description.
     * 
     * @return message
     **/
    @ApiModelProperty(value = "Error description.")
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Fields name(String name) {
        this.name = name;
        return this;
    }

    /**
     * The field name in the failed validation request.
     * 
     * @return name
     **/
    @ApiModelProperty(value = "The field name in the failed validation request.")
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
        Fields fields = (Fields) o;
        return Objects.equals(this.message, fields.message) && Objects.equals(this.name, fields.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(message, name);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class Fields {\n");

        sb.append("    message: ").append(toIndentedString(message)).append("\n");
        sb.append("    name: ").append(toIndentedString(name)).append("\n");
        sb.append("}");
        return sb.toString();
    }

    /**
     * Convert the given object to string with each line indented by 4 spaces (except the first line).
     */
    private String toIndentedString(java.lang.Object o) {
        if (o == null) {
            return "null";
        }
        return o.toString().replace("\n", "\n    ");
    }

}
