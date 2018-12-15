package com.arm.pelion.sdk.foundation.generator.input;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Method {
    @JsonProperty(InputSchema.KEY_TAG)
    private String key;
    // @JsonAlias({ InputSchema.DESCRIPTION_TAG, InputSchema.SUMMARY_TAG })
    @JsonProperty(InputSchema.DESCRIPTION_TAG)
    private String description;
    @JsonProperty(InputSchema.SUMMARY_TAG)
    private String summary;
    @JsonProperty(InputSchema.GROUP_ID_TAG)
    private List<String> groupId;
    @JsonProperty(InputSchema.DROP_FIELDS_TAG)
    private List<String> dropFields;
    @JsonProperty(InputSchema.RENAMES_TAG)
    private List<Mapping> renames;
    @JsonProperty(InputSchema.FIELDS_TAG)
    private List<Field> parameters;
    @JsonProperty(InputSchema.METHOD_ID_TAG)
    private String id;
    @JsonProperty(InputSchema.PAGINATED_RESPONSE_TAG)
    private boolean hasPaginatedResponse;
    // @JsonProperty(InputSchema.METHOD_PARAMETER_MAP_TAG)
    // private List<Mapping> parameterMap;
    @JsonProperty(InputSchema.METHOD_DOES_NOT_RETURN_ITSELF_TAG)
    private boolean doesntReturnItself;
    @JsonProperty(InputSchema.CUSTOM_CODE_TAG)
    private boolean customCode;

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = Utils.getKey(key, false);
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<String> getDropFields() {
        return dropFields;
    }

    public void setDropFields(List<String> dropFields) {
        this.dropFields = dropFields;
    }

    public List<Mapping> getRenames() {
        return renames;
    }

    public void setRenames(List<Mapping> renames) {
        this.renames = renames;
    }

    public List<Field> getParameters() {
        return parameters;
    }

    public void setParameters(List<Field> parameters) {
        this.parameters = parameters;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = Utils.getKey(id, true);
    }

    public boolean hasPaginatedResponse() {
        return hasPaginatedResponse;
    }

    public void setHasPaginatedResponse(boolean hasPaginatedResponse) {
        this.hasPaginatedResponse = hasPaginatedResponse;
    }

    // public List<Mapping> getParameterMap() {
    // return parameterMap;
    // }
    //
    // public void setParameterMap(List<Mapping> parameterMap) {
    // this.parameterMap = parameterMap;
    // }

    public boolean doesntReturnItself() {
        return doesntReturnItself;
    }

    public void setDoesntReturnItself(boolean doesntReturnItself) {
        this.doesntReturnItself = doesntReturnItself;
    }

    public List<String> getGroupId() {
        return groupId;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public boolean isListMethod() {
        return isMethod(InputSchema.LIST_METHOD_TAG);
    }

    public boolean isCreateMethod() {
        return isMethod(InputSchema.CREATE_METHOD_TAG);
    }

    public boolean isReadMethod() {
        return isMethod(InputSchema.READ_METHOD_TAG);
    }

    public boolean isUpdateMethod() {
        return isMethod(InputSchema.UPDATE_METHOD_TAG);
    }

    public boolean isDeleteMethod() {
        return isMethod(InputSchema.DELETE_METHOD_TAG);
    }

    private boolean isMethod(String methodName) {
        final String methodKey = Utils.getKey(methodName, false);
        return methodKey == null ? false : methodKey.equals(key);
    }

    public boolean isCustomCode() {
        return customCode;
    }

    public void setCustomCode(boolean customCode) {
        this.customCode = customCode;
    }

    /**
     * @param groupId
     *            the groupId to set
     */
    public void setGroupId(String groupId) {
        this.groupId = Utils.getGroupId(groupId);
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
        final Method other = (Method) obj;
        if (key == null) {
            if (other.key != null) {
                return false;
            }
        } else if (!key.equals(other.key)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Method [key=" + key + ", description=" + description + ", summary=" + summary + ", groupId=" + groupId
               + ", dropFields=" + dropFields + ", renames=" + renames + ", id=" + id + ", hasPaginatedResponse="
               + hasPaginatedResponse + ", doesntReturnItself=" + doesntReturnItself + ", customCode=" + customCode
               + "]";
    }

}
