package com.arm.pelion.sdk.foundation.generator.input;

import java.util.List;
import java.util.stream.Collectors;

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
    @JsonProperty(InputSchema.METHODS_TAG)
    private List<Method> methods;
    @JsonProperty(InputSchema.RENAMES_TAG)
    private List<Mapping> renames;
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
        methods = null;
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

    public List<Mapping> getRenames() {
        return renames;
    }

    public void setRenames(List<Mapping> renames) {
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
        this.primaryKey = Utils.getKey(primaryKey, false);
    }

    public boolean hasPrimaryKey() {
        return primaryKey != null && !primaryKey.isEmpty();
    }

    public List<Method> getMethods() {
        return methods;
    }

    public void setMethods(List<Method> methods) {
        this.methods = methods;
    }

    public boolean hasMethods() {
        return methods != null && !methods.isEmpty();
    }

    public boolean hasMethod(String method) {
        final String methodKey = Utils.getKey(method, false);
        return methodKey == null
               || !hasMethods() ? false : methods.stream().filter(m -> methodKey.equals(m.getKey())).count() > 0;
    }

    public boolean hasOtherPaginatedMethod() {
        return !hasMethods() ? false : methods.stream().filter(m -> isOtherPaginatedMethod(m)).count() > 0;
    }

    public List<Method> getOtherPaginatedMethod() {
        return methods.stream().filter(m -> isOtherPaginatedMethod(m)).collect(Collectors.toList());
    }

    public Method getListMethod() {
        return methods.stream().filter(m -> m.isListMethod()).findFirst().orElse(null);
    }

    private boolean isOtherPaginatedMethod(Method m) {
        return m.hasPaginatedResponse() && !(m.isListMethod() || m.getReturnInformation().doesReturnItSelf());
    }

    public boolean hasListMethod() {
        return hasMethod(InputSchema.LIST_METHOD_TAG);
    }

    public boolean hasCreateMethod() {
        return hasMethod(InputSchema.CREATE_METHOD_TAG);
    }

    public boolean hasReadMethod() {
        return hasMethod(InputSchema.READ_METHOD_TAG);
    }

    public boolean hasUpdateMethod() {
        return hasMethod(InputSchema.UPDATE_METHOD_TAG);
    }

    public boolean hasDeleteMethod() {
        return hasMethod(InputSchema.DELETE_METHOD_TAG);
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
