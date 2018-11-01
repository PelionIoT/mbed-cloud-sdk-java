package com.arm.pelion.sdk.foundation.generator.input;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Entity {

    @JsonProperty(InputSchema.KEY_TAG)
    private String key;
    @JsonProperty(InputSchema.GROUP_ID_TAG)
    private List<String> groupId;
    @JsonProperty(InputSchema.DESCRIPTION_TAG)
    private String description;
    @JsonProperty(InputSchema.FIELDS_TAG)
    private List<Field> fields;
    @JsonProperty(InputSchema.RENAMES_TAG)
    private List<Renaming> renames;
    @JsonProperty(InputSchema.HASHTABLE_TAG)
    private AdditionalProperty additionalProperties;
    @JsonProperty(InputSchema.PRIMARY_KEY_TAG)
    private String primaryKey;

    // Java specific fields
    @JsonProperty(InputSchema.CUSTOM_CODE_TAG)
    private boolean customCode;
    @JsonProperty(InputSchema.LONG_DESCRIPTION_TAG)
    private String longDescription;
    @JsonProperty(InputSchema.INTERNAL_TAG)
    private boolean internal;

    public Entity() {
        key = null;
        groupId = null;
        description = null;
        fields = null;
        renames = null;
        customCode = false;
        longDescription = null;
        internal = false;
        additionalProperties = null;
        primaryKey = null;
    }

    public AdditionalProperty getAdditionalProperties() {
        return additionalProperties;
    }

    public void setAdditionalProperties(AdditionalProperty additionalProperties) {
        this.additionalProperties = additionalProperties;
    }

    public boolean hasAdditionalProperties() {
        return additionalProperties != null;
    }

    public List<Renaming> getRenames() {
        return renames;
    }

    public void setRenames(List<Renaming> renames) {
        this.renames = renames;
    }

    /**
     * @return the key
     */
    public String getKey() {
        return key;
    }

    /**
     * @return the groupId
     */
    public List<String> getGroupId() {
        return groupId;
    }

    /**
     * @return the description
     */
    public String getDescription() {
        return description;
    }

    /**
     * @return the longDescription
     */
    public String getLongDescription() {
        return longDescription;
    }

    /**
     * @return the customCode
     */
    public boolean isCustomCode() {
        return customCode;
    }

    /**
     * @return the internal
     */
    public boolean isInternal() {
        return internal;
    }

    /**
     * @return the fields
     */
    public List<Field> getFields() {
        return fields;
    }

    /**
     * @param key
     *            the key to set
     */
    public void setKey(String key) {
        this.key = Utils.getKey(key, false);
    }

    /**
     * @param groupId
     *            the groupId to set
     */
    public void setGroupId(String groupId) {
        this.groupId = Utils.getGroupId(groupId);
    }

    /**
     * @param description
     *            the description to set
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * @param longDescription
     *            the longDescription to set
     */
    public void setLongDescription(String longDescription) {
        this.longDescription = longDescription;
    }

    /**
     * @param customCode
     *            the customCode to set
     */
    public void setCustomCode(boolean customCode) {
        this.customCode = customCode;
    }

    /**
     * @param internal
     *            the internal to set
     */
    public void setInternal(boolean internal) {
        this.internal = internal;
    }

    /**
     * @param fields
     *            the fields to set
     */
    public void setFields(List<Field> fields) {
        this.fields = fields;
    }

    public boolean hasFields() {
        return fields != null && !fields.isEmpty();
    }

    public String getPrimaryKey() {
        return primaryKey;
    }

    public void setPrimaryKey(String primaryKey) {
        this.primaryKey = primaryKey;
    }

    /*
     * (non-Javadoc)
     *
     * @see java.lang.Object#hashCode()
     */
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((groupId == null) ? 0 : groupId.hashCode());
        result = prime * result + ((key == null) ? 0 : key.hashCode());
        return result;
    }

    /*
     * (non-Javadoc)
     *
     * @see java.lang.Object#equals(java.lang.Object)
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Entity other = (Entity) obj;
        if (groupId == null) {
            if (other.groupId != null) {
                return false;
            }
        } else if (!groupId.equals(other.groupId)) {
            return false;
        }
        if (key == null) {
            if (other.key != null) {
                return false;
            }
        } else if (!key.equals(other.key)) {
            return false;
        }
        return true;
    }

    /*
     * (non-Javadoc)
     *
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        return "Entity [key=" + getKey() + ", groupId=" + getGroupId() + ", customCode=" + customCode + "]";
    }

}
