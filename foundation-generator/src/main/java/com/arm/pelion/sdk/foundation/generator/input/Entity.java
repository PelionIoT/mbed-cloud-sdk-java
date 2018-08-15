package com.arm.pelion.sdk.foundation.generator.input;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Entity {
    @JsonProperty("_kEY")
    private String key;
    @JsonProperty("group_id")
    private List<String> groupId;
    private String description;

    @JsonProperty("custom_code")
    private boolean customCode;

    private List<Field> fields;

    // Java specific fields
    @JsonProperty("long_description")
    private String longDescription;
    private boolean internal;

    public Entity() {
        // TODO Auto-generated constructor stub
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
        this.key = key;
    }

    /**
     * @param groupId
     *            the groupId to set
     */
    public void setGroupId(List<String> groupId) {
        this.groupId = groupId;
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
        Entity other = (Entity) obj;
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
        return "Entity [key=" + key + ", groupId=" + groupId + ", customCode=" + customCode + "]";
    }

}
