/*
 * Mbed Cloud API
 * The full Mbed Cloud API
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
import java.util.HashMap;
import java.util.Map;
import org.joda.time.DateTime;
import java.io.Serializable;

/**
 * DeviceGroup
 */

public class DeviceGroup implements Serializable {
    private static final long serialVersionUID = 1L;

    @SerializedName("created_at")
    private DateTime createdAt = null;

    @SerializedName("custom_attributes")
    private Map<String, String> customAttributes = null;

    @SerializedName("description")
    private String description = null;

    @SerializedName("devices_count")
    private Integer devicesCount = null;

    @SerializedName("etag")
    private DateTime etag = null;

    @SerializedName("id")
    private String id = null;

    @SerializedName("name")
    private String name = null;

    @SerializedName("object")
    private String object = null;

    @SerializedName("updated_at")
    private DateTime updatedAt = null;

    public DeviceGroup createdAt(DateTime createdAt) {
        this.createdAt = createdAt;
        return this;
    }

    /**
     * The time the campaign was created.
     * 
     * @return createdAt
     **/
    @ApiModelProperty(example = "2017-05-22T12:37:55.576563Z", value = "The time the campaign was created.")
    public DateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(DateTime createdAt) {
        this.createdAt = createdAt;
    }

    public DeviceGroup customAttributes(Map<String, String> customAttributes) {
        this.customAttributes = customAttributes;
        return this;
    }

    public DeviceGroup putCustomAttributesItem(String key, String customAttributesItem) {
        if (this.customAttributes == null) {
            this.customAttributes = new HashMap<String, String>();
        }
        this.customAttributes.put(key, customAttributesItem);
        return this;
    }

    /**
     * Up to ten custom key-value attributes. Note that keys cannot begin with a number. Both keys and values are
     * limited to 128 characters. Updating this field replaces existing contents.
     * 
     * @return customAttributes
     **/
    @ApiModelProperty(example = "{\"key\":\"value\"}",
                      value = "Up to ten custom key-value attributes. Note that keys cannot begin with a number. Both keys and values are limited to 128 characters. Updating this field replaces existing contents.")
    public Map<String, String> getCustomAttributes() {
        return customAttributes;
    }

    public void setCustomAttributes(Map<String, String> customAttributes) {
        this.customAttributes = customAttributes;
    }

    public DeviceGroup description(String description) {
        this.description = description;
        return this;
    }

    /**
     * The description of the group.
     * 
     * @return description
     **/
    @ApiModelProperty(example = "Devices on the factory floor.", value = "The description of the group.")
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public DeviceGroup devicesCount(Integer devicesCount) {
        this.devicesCount = devicesCount;
        return this;
    }

    /**
     * The number of devices in this group.
     * 
     * @return devicesCount
     **/
    @ApiModelProperty(example = "10", value = "The number of devices in this group.")
    public Integer getDevicesCount() {
        return devicesCount;
    }

    public void setDevicesCount(Integer devicesCount) {
        this.devicesCount = devicesCount;
    }

    public DeviceGroup etag(DateTime etag) {
        this.etag = etag;
        return this;
    }

    /**
     * Get etag
     * 
     * @return etag
     **/
    @ApiModelProperty(example = "2017-05-22T12:37:55.576563Z", value = "")
    public DateTime getEtag() {
        return etag;
    }

    public void setEtag(DateTime etag) {
        this.etag = etag;
    }

    public DeviceGroup id(String id) {
        this.id = id;
        return this;
    }

    /**
     * The group ID.
     * 
     * @return id
     **/
    @ApiModelProperty(example = "015c3029f6f7000000000001001000c3", value = "The group ID.")
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public DeviceGroup name(String name) {
        this.name = name;
        return this;
    }

    /**
     * Name of the group.
     * 
     * @return name
     **/
    @ApiModelProperty(example = "My devices", value = "Name of the group.")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public DeviceGroup object(String object) {
        this.object = object;
        return this;
    }

    /**
     * Entity name: always &#39;device-group&#39;.
     * 
     * @return object
     **/
    @ApiModelProperty(example = "device-group", value = "Entity name: always 'device-group'.")
    public String getObject() {
        return object;
    }

    public void setObject(String object) {
        this.object = object;
    }

    public DeviceGroup updatedAt(DateTime updatedAt) {
        this.updatedAt = updatedAt;
        return this;
    }

    /**
     * The time the object was updated.
     * 
     * @return updatedAt
     **/
    @ApiModelProperty(example = "2017-05-22T12:37:55.576563Z", value = "The time the object was updated.")
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
        DeviceGroup deviceGroup = (DeviceGroup) o;
        return Objects.equals(this.createdAt, deviceGroup.createdAt)
               && Objects.equals(this.customAttributes, deviceGroup.customAttributes)
               && Objects.equals(this.description, deviceGroup.description)
               && Objects.equals(this.devicesCount, deviceGroup.devicesCount)
               && Objects.equals(this.etag, deviceGroup.etag) && Objects.equals(this.id, deviceGroup.id)
               && Objects.equals(this.name, deviceGroup.name) && Objects.equals(this.object, deviceGroup.object)
               && Objects.equals(this.updatedAt, deviceGroup.updatedAt);
    }

    @Override
    public int hashCode() {
        return Objects.hash(createdAt, customAttributes, description, devicesCount, etag, id, name, object, updatedAt);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class DeviceGroup {\n");

        sb.append("    createdAt: ").append(toIndentedString(createdAt)).append("\n");
        sb.append("    customAttributes: ").append(toIndentedString(customAttributes)).append("\n");
        sb.append("    description: ").append(toIndentedString(description)).append("\n");
        sb.append("    devicesCount: ").append(toIndentedString(devicesCount)).append("\n");
        sb.append("    etag: ").append(toIndentedString(etag)).append("\n");
        sb.append("    id: ").append(toIndentedString(id)).append("\n");
        sb.append("    name: ").append(toIndentedString(name)).append("\n");
        sb.append("    object: ").append(toIndentedString(object)).append("\n");
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