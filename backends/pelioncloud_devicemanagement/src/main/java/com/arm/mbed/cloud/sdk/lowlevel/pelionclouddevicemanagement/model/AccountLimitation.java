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
import org.joda.time.DateTime;
import java.io.Serializable;

/**
 * This object represents an account limitation.
 */
@ApiModel(description = "This object represents an account limitation.")

public class AccountLimitation implements Serializable {
    private static final long serialVersionUID = 1L;

    @SerializedName("billing_period")
    private Integer billingPeriod = null;

    @SerializedName("created_at")
    private DateTime createdAt = null;

    @SerializedName("description")
    private String description = null;

    @SerializedName("etag")
    private String etag = null;

    @SerializedName("id")
    private String id = null;

    @SerializedName("inherited")
    private Boolean inherited = null;

    @SerializedName("inherited_from")
    private String inheritedFrom = null;

    /**
     * Indicates the type of the entity where the limitation is inherited from.
     */
    @JsonAdapter(InheritedTypeEnum.Adapter.class)
    public enum InheritedTypeEnum {
        ACCOUNT("account"),

        TEMPLATE("template"),

        TIER_TEMPLATE("tier_template");

        private String value;

        InheritedTypeEnum(String value) {
            this.value = value;
        }

        public String getValue() {
            return value;
        }

        @Override
        public String toString() {
            return String.valueOf(value);
        }

        public static InheritedTypeEnum fromValue(String text) {
            for (InheritedTypeEnum b : InheritedTypeEnum.values()) {
                if (String.valueOf(b.value).equals(text)) {
                    return b;
                }
            }
            return null;
        }

        public static class Adapter extends TypeAdapter<InheritedTypeEnum> {
            @Override
            public void write(final JsonWriter jsonWriter, final InheritedTypeEnum enumeration) throws IOException {
                jsonWriter.value(enumeration.getValue());
            }

            @Override
            public InheritedTypeEnum read(final JsonReader jsonReader) throws IOException {
                String value = jsonReader.nextString();
                return InheritedTypeEnum.fromValue(String.valueOf(value));
            }
        }
    }

    @SerializedName("inherited_type")
    private InheritedTypeEnum inheritedType = null;

    @SerializedName("inherited_value")
    private AccountLimitationInheritedValue inheritedValue = null;

    @SerializedName("limit")
    private Long limit = null;

    @SerializedName("name")
    private String name = null;

    /**
     * Entity name: always &#39;limitation&#39;
     */
    @JsonAdapter(ObjectEnum.Adapter.class)
    public enum ObjectEnum {
        LIMITATION("limitation");

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

    @SerializedName("quota")
    private Long quota = null;

    @SerializedName("updated_at")
    private DateTime updatedAt = null;

    public AccountLimitation billingPeriod(Integer billingPeriod) {
        this.billingPeriod = billingPeriod;
        return this;
    }

    /**
     * Billing period of the account limitation. minimum: 1 maximum: 120
     * 
     * @return billingPeriod
     **/
    @ApiModelProperty(example = "1", value = "Billing period of the account limitation.")
    public Integer getBillingPeriod() {
        return billingPeriod;
    }

    public void setBillingPeriod(Integer billingPeriod) {
        this.billingPeriod = billingPeriod;
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

    /**
     * Description of the account limitation.
     * 
     * @return description
     **/
    @ApiModelProperty(value = "Description of the account limitation.")
    public String getDescription() {
        return description;
    }

    /**
     * API resource entity version.
     * 
     * @return etag
     **/
    @ApiModelProperty(example = "1", value = "API resource entity version.")
    public String getEtag() {
        return etag;
    }

    /**
     * Entity ID.
     * 
     * @return id
     **/
    @ApiModelProperty(example = "01619571d01d0242ac12000600000000", value = "Entity ID.")
    public String getId() {
        return id;
    }

    /**
     * Flag indicating whether this limitation is inherited.
     * 
     * @return inherited
     **/
    @ApiModelProperty(value = "Flag indicating whether this limitation is inherited.")
    public Boolean isInherited() {
        return inherited;
    }

    /**
     * Indicates where this limit is inherited from.
     * 
     * @return inheritedFrom
     **/
    @ApiModelProperty(value = "Indicates where this limit is inherited from.")
    public String getInheritedFrom() {
        return inheritedFrom;
    }

    /**
     * Indicates the type of the entity where the limitation is inherited from.
     * 
     * @return inheritedType
     **/
    @ApiModelProperty(value = "Indicates the type of the entity where the limitation is inherited from.")
    public InheritedTypeEnum getInheritedType() {
        return inheritedType;
    }

    public AccountLimitation inheritedValue(AccountLimitationInheritedValue inheritedValue) {
        this.inheritedValue = inheritedValue;
        return this;
    }

    /**
     * Get inheritedValue
     * 
     * @return inheritedValue
     **/
    @ApiModelProperty(value = "")
    public AccountLimitationInheritedValue getInheritedValue() {
        return inheritedValue;
    }

    public void setInheritedValue(AccountLimitationInheritedValue inheritedValue) {
        this.inheritedValue = inheritedValue;
    }

    public AccountLimitation limit(Long limit) {
        this.limit = limit;
        return this;
    }

    /**
     * The value of the limit.
     * 
     * @return limit
     **/
    @ApiModelProperty(example = "25", value = "The value of the limit.")
    public Long getLimit() {
        return limit;
    }

    public void setLimit(Long limit) {
        this.limit = limit;
    }

    public AccountLimitation name(String name) {
        this.name = name;
        return this;
    }

    /**
     * Name of the account limitation.
     * 
     * @return name
     **/
    @ApiModelProperty(example = "iam_limit_user_count", value = "Name of the account limitation.")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    /**
     * Entity name: always &#39;limitation&#39;
     * 
     * @return object
     **/
    @ApiModelProperty(value = "Entity name: always 'limitation'")
    public ObjectEnum getObject() {
        return object;
    }

    public AccountLimitation quota(Long quota) {
        this.quota = quota;
        return this;
    }

    /**
     * Quota of the account limitation.
     * 
     * @return quota
     **/
    @ApiModelProperty(example = "0", value = "Quota of the account limitation.")
    public Long getQuota() {
        return quota;
    }

    public void setQuota(Long quota) {
        this.quota = quota;
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

    @Override
    public boolean equals(java.lang.Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        AccountLimitation accountLimitation = (AccountLimitation) o;
        return Objects.equals(this.billingPeriod, accountLimitation.billingPeriod)
               && Objects.equals(this.createdAt, accountLimitation.createdAt)
               && Objects.equals(this.description, accountLimitation.description)
               && Objects.equals(this.etag, accountLimitation.etag) && Objects.equals(this.id, accountLimitation.id)
               && Objects.equals(this.inherited, accountLimitation.inherited)
               && Objects.equals(this.inheritedFrom, accountLimitation.inheritedFrom)
               && Objects.equals(this.inheritedType, accountLimitation.inheritedType)
               && Objects.equals(this.inheritedValue, accountLimitation.inheritedValue)
               && Objects.equals(this.limit, accountLimitation.limit)
               && Objects.equals(this.name, accountLimitation.name)
               && Objects.equals(this.object, accountLimitation.object)
               && Objects.equals(this.quota, accountLimitation.quota)
               && Objects.equals(this.updatedAt, accountLimitation.updatedAt);
    }

    @Override
    public int hashCode() {
        return Objects.hash(billingPeriod, createdAt, description, etag, id, inherited, inheritedFrom, inheritedType,
                            inheritedValue, limit, name, object, quota, updatedAt);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class AccountLimitation {\n");

        sb.append("    billingPeriod: ").append(toIndentedString(billingPeriod)).append("\n");
        sb.append("    createdAt: ").append(toIndentedString(createdAt)).append("\n");
        sb.append("    description: ").append(toIndentedString(description)).append("\n");
        sb.append("    etag: ").append(toIndentedString(etag)).append("\n");
        sb.append("    id: ").append(toIndentedString(id)).append("\n");
        sb.append("    inherited: ").append(toIndentedString(inherited)).append("\n");
        sb.append("    inheritedFrom: ").append(toIndentedString(inheritedFrom)).append("\n");
        sb.append("    inheritedType: ").append(toIndentedString(inheritedType)).append("\n");
        sb.append("    inheritedValue: ").append(toIndentedString(inheritedValue)).append("\n");
        sb.append("    limit: ").append(toIndentedString(limit)).append("\n");
        sb.append("    name: ").append(toIndentedString(name)).append("\n");
        sb.append("    object: ").append(toIndentedString(object)).append("\n");
        sb.append("    quota: ").append(toIndentedString(quota)).append("\n");
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
