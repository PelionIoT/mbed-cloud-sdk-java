package com.arm.pelion.sdk.foundation.generator.input;

import java.util.Locale;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Field {
    @JsonProperty(InputSchema.KEY_TAG)
    private String key;
    @JsonProperty(InputSchema.DESCRIPTION_TAG)
    private String description;
    @JsonProperty(InputSchema.REQUIRED_TAG)
    private boolean required;
    @JsonProperty(InputSchema.EXAMPLE_TAG)
    private Object example;
    @JsonProperty(InputSchema.ITEMS_TAG)
    private Item items;
    @JsonAlias({ InputSchema.CUSTOM_CODE_TAG, InputSchema.CUSTOM_GETTER_CODE_TAG, InputSchema.CUSTOM_SETTER_CODE_TAG })
    private boolean customCode;
    @JsonProperty(InputSchema.DEFAULT_VALUE_TAG)
    private String defaultValue;
    @JsonProperty(InputSchema.READ_ONLY_TAG)
    private boolean readOnly;
    @JsonProperty(InputSchema.PATTERN_TAG)
    private String pattern;
    @JsonProperty(InputSchema.ENUM_REFERENCE_TAG)
    private String enumRef;
    @JsonProperty(InputSchema.HASHTABLE_TAG)
    private AdditionalProperty additionalProperties;
    @JsonProperty(InputSchema.TYPE_TAG)
    private String type;
    @JsonProperty(InputSchema.FORMAT_TAG)
    private String format;
    @JsonProperty(InputSchema.FOREIGN_KEY_TAG)
    private ForeignKey foreignKey;
    @JsonProperty(InputSchema.PARAMETER_FIELDNAME_TAG)
    private String parameterFieldname;
    @JsonProperty(InputSchema.METHOD_PARAMETER_IS_EXTERNAL)
    private boolean isExternal;

    @JsonAlias({ InputSchema.INTERNAL_TAG, InputSchema.INTERNAL_FIELD_TAG })
    private boolean internal;
    // Java specific fields
    @JsonProperty(InputSchema.LONG_DESCRIPTION_TAG)
    private String longDescription;

    @JsonProperty(InputSchema.FIELD_DEPRECATION_TAG)
    private DeprecationNotice deprecationNotice;

    @JsonAlias({ InputSchema.MAXIMUM_ITEMS_TAG, InputSchema.MAXIMUM_LENGTH_TAG, InputSchema.MAXIMUM_PROPERTIES_TAG,
                 InputSchema.MAXIMUM_TAG })
    private Number maximum;
    @JsonAlias({ InputSchema.MINIMUM_ITEMS_TAG, InputSchema.MINIMUM_LENGTH_TAG, InputSchema.MINIMUM_PROPERTIES_TAG,
                 InputSchema.MINIMUM_TAG })
    private Number minimum;
    @JsonProperty(InputSchema.EXCLUSIVE_MAXIMUM_TAG)
    private boolean exclusiveMaximum;
    @JsonProperty(InputSchema.EXCLUSIVE_MINIMUM_TAG)
    private boolean exclusiveMinimum;

    public Field() {
        key = null;
        description = null;
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
        parameterFieldname = null;
        longDescription = null;
        additionalProperties = null;
        enumRef = null;
        foreignKey = null;
        isExternal = false;
        deprecationNotice = null;
        maximum = null;
        minimum = null;
        exclusiveMaximum = false;
        exclusiveMinimum = false;
    }

    /**
     * @return the key
     */
    public String getKey() {
        return key;
    }

    /**
     * @return the description
     */
    public String getDescription() {
        return description;
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
        return String.valueOf(example);
    }

    /**
     * @return the items
     */
    public Item getItems() {
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
    public void setKey(String key) {
        this.key = Utils.getKey(key, true);
    }

    /**
     * @param description
     *            the description to set
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * @param required
     *            the required to set
     */
    public void setRequired(Object required) {
        this.required = Boolean.parseBoolean(required.toString());
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
    public void setExample(Object example) {
        this.example = example;
    }

    /**
     * @param items
     *            the items to set
     */
    public void setItems(Item items) {
        this.items = items;
    }

    /**
     * @param customCode
     *            the customCode to set
     */
    public void setCustomCode(Object customCode) {
        if (customCode == null) {
            return;
        }

        if (customCode instanceof Boolean) {
            this.customCode = ((Boolean) customCode).booleanValue();
            return;
        }
        if (Boolean.parseBoolean(String.valueOf(customCode))) {
            this.customCode = true;
            return;
        }
        this.customCode = !String.valueOf(customCode).toLowerCase(Locale.UK).equals("false");
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

    public boolean hasAdditionalProperties() {
        return additionalProperties != null;
    }

    public AdditionalProperty getAdditionalProperties() {
        return additionalProperties;
    }

    public void setAdditionalProperties(AdditionalProperty additionalProperties) {
        this.additionalProperties = additionalProperties;
    }

    public boolean hasEnumRef() {
        return com.arm.pelion.sdk.foundation.generator.input.Utils.has(enumRef);
    }

    public String getEnumRef() {
        return enumRef;
    }

    public void setEnumRef(String enumRef) {
        this.enumRef = Utils.getKey(enumRef, false);
    }

    public ForeignKey getForeignKey() {
        return foreignKey;
    }

    public void setForeignKey(ForeignKey foreignKey) {
        this.foreignKey = foreignKey;
    }

    public boolean hasForeignKey() {
        return foreignKey != null;
    }

    public String getParameterFieldname() {
        return parameterFieldname;
    }

    public boolean hasParameterFieldName() {
        return com.arm.pelion.sdk.foundation.generator.input.Utils.has(parameterFieldname);
    }

    public void setParameterFieldname(String parameterFieldname) {
        this.parameterFieldname = Utils.getKey(parameterFieldname, true);
    }

    public boolean isExternal() {
        return isExternal;
    }

    public void setExternal(boolean isExternal) {
        this.isExternal = isExternal;
    }

    public String getProcessedFrom() {
        return getParameterFieldname();
    }

    public String getProcessedTo() {
        return Utils.getKey(key, true);
    }

    public DeprecationNotice getDeprecationNotice() {
        return deprecationNotice;
    }

    public void setDeprecationNotice(DeprecationNotice deprecationNotice) {
        this.deprecationNotice = deprecationNotice;
    }

    public boolean hasDeprecation() {
        return deprecationNotice != null;
    }

    public Number getMaximum() {
        if (isExclusiveMaximum()) {
            if (maximum instanceof Integer || maximum instanceof Byte || maximum instanceof Short) {
                return Integer.valueOf(maximum.intValue() - 1);
            }
            if (maximum instanceof Long) {
                return Long.valueOf(maximum.longValue() - 1L);
            }
        }
        return maximum;
    }

    public void setMaximum(Number maximum) {
        this.maximum = maximum;
    }

    public boolean hasMaximum() {
        return maximum != null;
    }

    public Number getMinimum() {
        if (isExclusiveMinimum()) {
            if (minimum instanceof Integer || minimum instanceof Byte || minimum instanceof Short) {
                return Integer.valueOf(minimum.intValue() + 1);
            }
            if (minimum instanceof Long) {
                return Long.valueOf(minimum.longValue() + 1L);
            }
        }
        return minimum;
    }

    public void setMinimum(Number minimum) {
        this.minimum = minimum;
    }

    public boolean hasMinimum() {
        return minimum != null;
    }

    public boolean isExclusiveMaximum() {
        return exclusiveMaximum;
    }

    public void setExclusiveMaximum(boolean exclusiveMaximum) {
        this.exclusiveMaximum = exclusiveMaximum;
    }

    public boolean isExclusiveMinimum() {
        return exclusiveMinimum;
    }

    public void setExclusiveMinimum(boolean exclusiveMinimum) {
        this.exclusiveMinimum = exclusiveMinimum;
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
        Field other = (Field) obj;
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
        return "Field [key=" + key + ", description=" + description + ", required=" + required + ", example=" + example
               + ", items=" + items + ", customCode=" + customCode + ", defaultValue=" + defaultValue + ", readOnly="
               + readOnly + ", pattern=" + pattern + ", enumRef=" + enumRef + ", additionalProperties="
               + additionalProperties + ", type=" + type + ", format=" + format + ", foreignKey=" + foreignKey
               + ", parameterFieldname=" + parameterFieldname + ", isExternal=" + isExternal + ", internal=" + internal
               + ", longDescription=" + longDescription + ", deprecationNotice=" + deprecationNotice + ", maximum="
               + maximum + ", minimum=" + minimum + ", exclusiveMaximum=" + exclusiveMaximum + ", exclusiveMinimum="
               + exclusiveMinimum + "]";
    }

}
