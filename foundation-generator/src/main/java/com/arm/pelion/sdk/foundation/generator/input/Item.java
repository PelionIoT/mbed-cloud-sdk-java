package com.arm.pelion.sdk.foundation.generator.input;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Item {
    @JsonProperty(InputSchema.TYPE_TAG)
    private String type;
    @JsonProperty(InputSchema.FORMAT_TAG)
    private String format;
    @JsonProperty(InputSchema.FOREIGN_KEY_TAG)
    private ForeignKey foreignKey;

    public Item() {
        super();
        type = null;
        format = null;
        foreignKey = null;
    }

    public boolean hasType() {
        return Utils.has(type);
    }

    public boolean hasFormat() {
        return Utils.has(format);
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getFormat() {
        return format;
    }

    public void setFormat(String format) {
        this.format = format;
    }

    public ForeignKey getForeignKey() {
        return foreignKey;
    }

    public boolean hasForeignKey() {
        return foreignKey != null;
    }

    public void setForeignKey(ForeignKey foreignKey) {
        this.foreignKey = foreignKey;
    }

}
