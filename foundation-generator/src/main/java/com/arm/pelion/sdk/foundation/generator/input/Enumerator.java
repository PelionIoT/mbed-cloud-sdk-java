package com.arm.pelion.sdk.foundation.generator.input;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Enumerator {
    @JsonProperty(InputSchema.KEY_TAG)
    private String key;
    @JsonProperty(InputSchema.ENTITY_REFERENCE_TAG)
    private String entityRef;
    @JsonProperty(InputSchema.GROUP_ID_TAG)
    private List<String> groupId;
    @JsonProperty(InputSchema.ENUM_NAME_TAG)
    private String name;
    @JsonProperty(InputSchema.FIELD_REFERENCE_TAG)
    private String fieldRef;

    @JsonProperty(InputSchema.ENUM_VALUES_TAG)
    private List<String> values;
    @JsonProperty(InputSchema.DESCRIPTION_TAG)
    private String description;

    // Java specific fields
    @JsonProperty(InputSchema.CUSTOM_CODE_TAG)
    private boolean customCode;
    @JsonProperty(InputSchema.LONG_DESCRIPTION_TAG)
    private String longDescription;
    @JsonProperty(InputSchema.INTERNAL_TAG)
    private boolean internal;

    public Enumerator() {
        super();
        key = null;
        entityRef = null;
        name = null;
        fieldRef = null;
        groupId = null;
        values = null;
        customCode = false;
        longDescription = null;
        internal = false;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getEntityRef() {
        return entityRef;
    }

    public void setEntityRef(String entityRef) {
        this.entityRef = entityRef;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFieldRef() {
        return fieldRef;
    }

    public void setFieldRef(String fieldRef) {
        this.fieldRef = fieldRef;
    }

    public List<String> getGroupId() {
        return groupId;
    }

    public void setGroupId(String groupId) {
        this.groupId = Utils.getGroupId(groupId);
    }

    public List<String> getValues() {
        return values;
    }

    public boolean hasValues() {
        return values != null && !values.isEmpty();
    }

    public void setValues(List<String> values) {
        this.values = values;
    }

    public boolean isCustomCode() {
        return customCode;
    }

    public void setCustomCode(boolean customCode) {
        this.customCode = customCode;
    }

    public String getLongDescription() {
        return longDescription;
    }

    public void setLongDescription(String longDescription) {
        this.longDescription = longDescription;
    }

    public boolean isInternal() {
        return internal;
    }

    public void setInternal(boolean internal) {
        this.internal = internal;
    }

    public void setGroupId(List<String> groupId) {
        this.groupId = groupId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((key == null) ? 0 : key.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Enumerator other = (Enumerator) obj;
        if (key == null) {
            if (other.key != null)
                return false;
        } else if (!key.equals(other.key))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "Enumerator [key=" + getKey() + ", entityRef=" + entityRef + ", name=" + name + ", fieldRef=" + fieldRef
               + ", groupId=" + groupId + ", values=" + values + ", description=" + description + ", customCode="
               + customCode + ", longDescription=" + longDescription + ", internal=" + internal + "]";
    }

}
