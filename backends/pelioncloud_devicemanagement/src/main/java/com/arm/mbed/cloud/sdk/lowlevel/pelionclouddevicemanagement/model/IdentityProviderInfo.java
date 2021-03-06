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
import io.swagger.annotations.ApiModelProperty;
import java.io.IOException;
import org.joda.time.DateTime;
import java.io.Serializable;

/**
 * IdentityProviderInfo
 */

public class IdentityProviderInfo implements Serializable {
    private static final long serialVersionUID = 1L;

    @SerializedName("account_id")
    private String accountId = null;

    @SerializedName("created_at")
    private DateTime createdAt = null;

    @SerializedName("description")
    private String description = null;

    @SerializedName("etag")
    private String etag = null;

    @SerializedName("id")
    private String id = null;

    @SerializedName("is_default")
    private Boolean isDefault = null;

    @SerializedName("name")
    private String name = null;

    /**
     * Entity name: always &#39;identity-provider&#39;
     */
    @JsonAdapter(ObjectEnum.Adapter.class)
    public enum ObjectEnum {
        PROVIDER("identity-provider");

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
    private ObjectEnum object = null;

    @SerializedName("saml2_attributes")
    private SAML2Info saml2Attributes = null;

    /**
     * Status of the identity provider.
     */
    @JsonAdapter(StatusEnum.Adapter.class)
    public enum StatusEnum {
        ACTIVE("ACTIVE"),

        SUSPENDED("SUSPENDED");

        private String value;

        StatusEnum(String value) {
            this.value = value;
        }

        public String getValue() {
            return value;
        }

        @Override
        public String toString() {
            return String.valueOf(value);
        }

        public static StatusEnum fromValue(String text) {
            for (StatusEnum b : StatusEnum.values()) {
                if (String.valueOf(b.value).equals(text)) {
                    return b;
                }
            }
            return null;
        }

        public static class Adapter extends TypeAdapter<StatusEnum> {
            @Override
            public void write(final JsonWriter jsonWriter, final StatusEnum enumeration) throws IOException {
                jsonWriter.value(enumeration.getValue());
            }

            @Override
            public StatusEnum read(final JsonReader jsonReader) throws IOException {
                String value = jsonReader.nextString();
                return StatusEnum.fromValue(String.valueOf(value));
            }
        }
    }

    @SerializedName("status")
    private StatusEnum status = null;

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

    @SerializedName("updated_at")
    private DateTime updatedAt = null;

    public IdentityProviderInfo accountId(String accountId) {
        this.accountId = accountId;
        return this;
    }

    /**
     * The ID of the account the identity provider belongs to.
     * 
     * @return accountId
     **/
    @ApiModelProperty(example = "01619571e2e90242ac12000600000000",
                      value = "The ID of the account the identity provider belongs to.")
    public String getAccountId() {
        return accountId;
    }

    public void setAccountId(String accountId) {
        this.accountId = accountId;
    }

    public IdentityProviderInfo createdAt(DateTime createdAt) {
        this.createdAt = createdAt;
        return this;
    }

    /**
     * Creation UTC time RFC3339.
     * 
     * @return createdAt
     **/
    @ApiModelProperty(example = "2018-02-13T09:35:20Z", value = "Creation UTC time RFC3339.")
    public DateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(DateTime createdAt) {
        this.createdAt = createdAt;
    }

    public IdentityProviderInfo description(String description) {
        this.description = description;
        return this;
    }

    /**
     * Description for the identity provider.
     * 
     * @return description
     **/
    @ApiModelProperty(value = "Description for the identity provider.")
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public IdentityProviderInfo etag(String etag) {
        this.etag = etag;
        return this;
    }

    /**
     * API resource entity version.
     * 
     * @return etag
     **/
    @ApiModelProperty(example = "1", required = true, value = "API resource entity version.")
    public String getEtag() {
        return etag;
    }

    public void setEtag(String etag) {
        this.etag = etag;
    }

    public IdentityProviderInfo id(String id) {
        this.id = id;
        return this;
    }

    /**
     * Entity ID.
     * 
     * @return id
     **/
    @ApiModelProperty(example = "01619571d01d0242ac12000600000000", required = true, value = "Entity ID.")
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    /**
     * Flag indicating whether this is the global default identity provider.
     * 
     * @return isDefault
     **/
    @ApiModelProperty(value = "Flag indicating whether this is the global default identity provider.")
    public Boolean isIsDefault() {
        return isDefault;
    }

    public IdentityProviderInfo name(String name) {
        this.name = name;
        return this;
    }

    /**
     * Name of the identity provider.
     * 
     * @return name
     **/
    @ApiModelProperty(required = true, value = "Name of the identity provider.")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public IdentityProviderInfo object(ObjectEnum object) {
        this.object = object;
        return this;
    }

    /**
     * Entity name: always &#39;identity-provider&#39;
     * 
     * @return object
     **/
    @ApiModelProperty(required = true, value = "Entity name: always 'identity-provider'")
    public ObjectEnum getObject() {
        return object;
    }

    public void setObject(ObjectEnum object) {
        this.object = object;
    }

    public IdentityProviderInfo saml2Attributes(SAML2Info saml2Attributes) {
        this.saml2Attributes = saml2Attributes;
        return this;
    }

    /**
     * SAML2 specific attributes.
     * 
     * @return saml2Attributes
     **/
    @ApiModelProperty(value = "SAML2 specific attributes.")
    public SAML2Info getSaml2Attributes() {
        return saml2Attributes;
    }

    public void setSaml2Attributes(SAML2Info saml2Attributes) {
        this.saml2Attributes = saml2Attributes;
    }

    public IdentityProviderInfo status(StatusEnum status) {
        this.status = status;
        return this;
    }

    /**
     * Status of the identity provider.
     * 
     * @return status
     **/
    @ApiModelProperty(value = "Status of the identity provider.")
    public StatusEnum getStatus() {
        return status;
    }

    public void setStatus(StatusEnum status) {
        this.status = status;
    }

    public IdentityProviderInfo type(TypeEnum type) {
        this.type = type;
        return this;
    }

    /**
     * Identity provider type.
     * 
     * @return type
     **/
    @ApiModelProperty(required = true, value = "Identity provider type.")
    public TypeEnum getType() {
        return type;
    }

    public void setType(TypeEnum type) {
        this.type = type;
    }

    public IdentityProviderInfo updatedAt(DateTime updatedAt) {
        this.updatedAt = updatedAt;
        return this;
    }

    /**
     * Last update UTC time RFC3339.
     * 
     * @return updatedAt
     **/
    @ApiModelProperty(example = "2018-02-14T15:24:14Z", value = "Last update UTC time RFC3339.")
    public DateTime getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(DateTime updatedAt) {
        this.updatedAt = updatedAt;
    }

    @Override
    public boolean equals(java.lang.Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        IdentityProviderInfo identityProviderInfo = (IdentityProviderInfo) o;
        return Objects.equals(this.accountId, identityProviderInfo.accountId)
               && Objects.equals(this.createdAt, identityProviderInfo.createdAt)
               && Objects.equals(this.description, identityProviderInfo.description)
               && Objects.equals(this.etag, identityProviderInfo.etag)
               && Objects.equals(this.id, identityProviderInfo.id)
               && Objects.equals(this.isDefault, identityProviderInfo.isDefault)
               && Objects.equals(this.name, identityProviderInfo.name)
               && Objects.equals(this.object, identityProviderInfo.object)
               && Objects.equals(this.saml2Attributes, identityProviderInfo.saml2Attributes)
               && Objects.equals(this.status, identityProviderInfo.status)
               && Objects.equals(this.type, identityProviderInfo.type)
               && Objects.equals(this.updatedAt, identityProviderInfo.updatedAt);
    }

    @Override
    public int hashCode() {
        return Objects.hash(accountId, createdAt, description, etag, id, isDefault, name, object, saml2Attributes,
                            status, type, updatedAt);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class IdentityProviderInfo {\n");

        sb.append("    accountId: ").append(toIndentedString(accountId)).append("\n");
        sb.append("    createdAt: ").append(toIndentedString(createdAt)).append("\n");
        sb.append("    description: ").append(toIndentedString(description)).append("\n");
        sb.append("    etag: ").append(toIndentedString(etag)).append("\n");
        sb.append("    id: ").append(toIndentedString(id)).append("\n");
        sb.append("    isDefault: ").append(toIndentedString(isDefault)).append("\n");
        sb.append("    name: ").append(toIndentedString(name)).append("\n");
        sb.append("    object: ").append(toIndentedString(object)).append("\n");
        sb.append("    saml2Attributes: ").append(toIndentedString(saml2Attributes)).append("\n");
        sb.append("    status: ").append(toIndentedString(status)).append("\n");
        sb.append("    type: ").append(toIndentedString(type)).append("\n");
        sb.append("    updatedAt: ").append(toIndentedString(updatedAt)).append("\n");
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
