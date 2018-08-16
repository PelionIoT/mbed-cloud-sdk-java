package com.arm.pelion.sdk.foundation.generator.input;

import java.util.Map;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Field {
    @JsonProperty(InputSchema.KEY_TAG)
    private Map<String, String> keys;
    private String description;
    @JsonProperty(InputSchema.API_FIELDNAME_TAG)
    private String apiFieldname;
    private boolean required;
    private String type;
    private String format;
    private String example;
    private Map<String, Object> items;
    private Map<String, Object> schema;
    @JsonProperty(InputSchema.CUSTOM_CODE_TAG)
    private boolean customCode;
    @JsonProperty(InputSchema.DEFAULT_VALUE_TAG)
    private String defaultValue;
    @JsonProperty(InputSchema.READ_ONLY_TAG)
    private boolean readOnly;
    private String pattern;

    // Java specific fields
    private boolean internal;
    @JsonProperty(InputSchema.LONG_DESCRIPTION_TAG)
    private String longDescription;

    public Field() {
        keys = null;
        description = null;
        apiFieldname = null;
        required = false;
        type = null;
        format = null;
        example = null;
        items = null;
        customCode = false;
        defaultValue = null;
        readOnly = false;
        internal = false;
        pattern = null;
        longDescription = null;
    }

    /**
     * @return the key
     */
    public String getKey() {
        return Utils.getKey(keys, true);
    }

    /**
     * @return the description
     */
    public String getDescription() {
        return description;
    }

    /**
     * @return the apiFieldname
     */
    public String getApiFieldname() {
        return apiFieldname;
    }

    /**
     * @return the required
     */
    public boolean isRequired() {
        return required;
    }

    /**
     * @return the type
     */
    public String getType() {
        return type;
    }

    /**
     * @return the format
     */
    public String getFormat() {
        return format;
    }

    /**
     * @return the example
     */
    public String getExample() {
        return example;
    }

    /**
     * @return the items
     */
    public Map<String, Object> getItems() {
        return items;
    }

    /**
     * @return the customCode
     */
    public boolean isCustomCode() {
        return customCode;
    }

    /**
     * @return the defaultValue
     */
    public String getDefaultValue() {
        return defaultValue;
    }

    /**
     * @return the pattern
     */
    public String getPattern() {
        return pattern;
    }

    /**
     * @param pattern
     *            the pattern to set
     */
    public void setPattern(String pattern) {
        this.pattern = pattern;
    }

    /**
     * @param key
     *            the key to set
     */
    public void setKeys(Map<String, String> key) {
        this.keys = key;
    }

    /**
     * @param description
     *            the description to set
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * @param apiFieldname
     *            the apiFieldname to set
     */
    public void setApiFieldname(String apiFieldname) {
        this.apiFieldname = apiFieldname;
    }

    /**
     * @param required
     *            the required to set
     */
    public void setRequired(boolean required) {
        this.required = required;
    }

    /**
     * @param type
     *            the type to set
     */
    public void setType(String type) {
        this.type = type;
    }

    /**
     * @param format
     *            the format to set
     */
    public void setFormat(String format) {
        this.format = format;
    }

    /**
     * @param example
     *            the example to set
     */
    public void setExample(String example) {
        this.example = example;
    }

    /**
     * @param items
     *            the items to set
     */
    public void setItems(Map<String, Object> items) {
        this.items = items;
    }

    /**
     * @param customCode
     *            the customCode to set
     */
    public void setCustomCode(boolean customCode) {
        this.customCode = customCode;
    }

    /**
     * @param defaultValue
     *            the defaultValue to set
     */
    public void setDefaultValue(String defaultValue) {
        this.defaultValue = defaultValue;
    }

    /**
     * @return the readOnly
     */
    public boolean isReadOnly() {
        return readOnly;
    }

    /**
     * @param readOnly
     *            the readOnly to set
     */
    public void setReadOnly(boolean readOnly) {
        this.readOnly = readOnly;
    }

    /**
     * @return the internal
     */
    public boolean isInternal() {
        return internal;
    }

    /**
     * @param internal
     *            the internal to set
     */
    public void setInternal(boolean internal) {
        this.internal = internal;
    }

    /**
     * @return the longDescription
     */
    public String getLongDescription() {
        return longDescription;
    }

    /**
     * @param longDescription
     *            the longDescription to set
     */
    public void setLongDescription(String longDescription) {
        this.longDescription = longDescription;
    }

    public boolean hasSchema() {
        return schema != null && !schema.isEmpty();
    }

    /**
     * @return the schema
     */
    public Map<String, Object> getSchema() {
        return schema;
    }

    /**
     * @param schema
     *            the schema to set
     */
    public void setSchema(Map<String, Object> schema) {
        this.schema = schema;
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
        Field other = (Field) obj;
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
        return "Field [key=" + getKey() + ", description=" + description + ", apiFieldname=" + apiFieldname
               + ", required=" + required + ", type=" + type + ", format=" + format + ", example=" + example
               + ", items=" + items + ", schema=" + schema + ", customCode=" + customCode + ", defaultValue="
               + defaultValue + ", readOnly=" + readOnly + ", pattern=" + pattern + ", internal=" + internal
               + ", longDescription=" + longDescription + "]";
    }

}
