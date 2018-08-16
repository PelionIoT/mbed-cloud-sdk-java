package com.arm.pelion.sdk.foundation.generator.input;

import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Entity {

    @JsonProperty(InputSchema.KEY_TAG)
    private Map<String, String> keys;
    @JsonProperty(InputSchema.GROUP_ID_TAG)
    private Map<String, String> groupIds;
    private String description;

    @JsonProperty(InputSchema.CUSTOM_CODE_TAG)
    private boolean customCode;

    private List<Field> fields;

    // Java specific fields
    @JsonProperty(InputSchema.LONG_DESCRIPTION_TAG)
    private String longDescription;
    private boolean internal;

    public Entity() {
        // TODO Auto-generated constructor stub
    }

    /**
     * @return the key
     */
    public String getKey() {
        return Utils.getKey(keys, false);
    }

    /**
     * @return the groupId
     */
    public List<String> getGroupId() {
        return Utils.getGroupId(groupIds);
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
    public void setKeys(Map<String, String> keys) {
        this.keys = keys;
    }

    /**
     * @param groupId
     *            the groupId to set
     */
    public void setGroupIds(Map<String, String> groupIds) {
        this.groupIds = groupIds;
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

    /*
     * (non-Javadoc)
     *
     * @see java.lang.Object#hashCode()
     */
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((groupIds == null) ? 0 : groupIds.hashCode());
        result = prime * result + ((keys == null) ? 0 : keys.hashCode());
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
        Entity other = (Entity) obj;
        if (groupIds == null) {
            if (other.groupIds != null) {
                return false;
            }
        } else if (!groupIds.equals(other.groupIds)) {
            return false;
        }
        if (keys == null) {
            if (other.keys != null) {
                return false;
            }
        } else if (!keys.equals(other.keys)) {
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
