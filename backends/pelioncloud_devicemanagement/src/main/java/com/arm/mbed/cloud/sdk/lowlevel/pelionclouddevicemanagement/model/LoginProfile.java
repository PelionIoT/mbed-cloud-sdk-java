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
import com.google.gson.TypeAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.IOException;
import java.io.Serializable;

/**
 * Represents a user login profile in Device Management.
 */
@ApiModel(description = "Represents a user login profile in Device Management.")

public class LoginProfile implements Serializable {
    private static final long serialVersionUID = 1L;

    @SerializedName("id")
    private String id = null;

    @SerializedName("name")
    private String name = null;

    /**
     * Identity provider type.
     */
    @JsonAdapter(TypeEnum.Adapter.class)
    public enum TypeEnum {
        NATIVE("NATIVE"),

        MBED("MBED"),

        SAML2("SAML2"),

        OIDC("OIDC");

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

    public LoginProfile id(String id) {
        this.id = id;
        return this;
    }

    /**
     * ID of the identity provider.
     * 
     * @return id
     **/
    @ApiModelProperty(required = true, value = "ID of the identity provider.")
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    /**
     * Name of the identity provider.
     * 
     * @return name
     **/
    @ApiModelProperty(value = "Name of the identity provider.")
    public String getName() {
        return name;
    }

    /**
     * Identity provider type.
     * 
     * @return type
     **/
    @ApiModelProperty(value = "Identity provider type.")
    public TypeEnum getType() {
        return type;
    }

    @Override
    public boolean equals(java.lang.Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        LoginProfile loginProfile = (LoginProfile) o;
        return Objects.equals(this.id, loginProfile.id) && Objects.equals(this.name, loginProfile.name)
               && Objects.equals(this.type, loginProfile.type);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, type);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class LoginProfile {\n");

        sb.append("    id: ").append(toIndentedString(id)).append("\n");
        sb.append("    name: ").append(toIndentedString(name)).append("\n");
        sb.append("    type: ").append(toIndentedString(type)).append("\n");
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
