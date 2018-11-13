package com.arm.mbed.cloud.sdk.connect.model;

import com.arm.mbed.cloud.sdk.annotations.Preamble;
import com.arm.mbed.cloud.sdk.common.SdkEnum;
import com.mbed.lwm2m.EncodingType;

@Preamble(description = "The type of a resource value")
public enum ResourceValueType implements SdkEnum {
    STRING("string", EncodingType.PLAIN_TEXT),
    INTEGER("number", EncodingType.PLAIN_TEXT),
    NUMBER("number", EncodingType.PLAIN_TEXT),
    BYTES("byte", EncodingType.OCTET_STREAM),
    // TODO
    // OBJECT("json", EncodingType.JSON),
    // LWM2M("lwm2m", EncodingType.TLV),
    UNKNOWN_ENUM(SDK_UNKNOWN_ENUM_VALUE, null);

    private final String value;
    private final EncodingType contentType;

    /**
     * Constructor.
     * 
     * @param value
     *            string representation.
     * @param contentType
     *            corresponding content type
     */
    private ResourceValueType(String string, EncodingType contentType) {
        this.value = string;
        this.contentType = contentType;
    }

    /**
     * States whether it is the default value.
     * 
     * @see SdkEnum#isDefault()
     */
    @Override
    public boolean isDefault() {
        return this == getDefault();
    }

    /**
     * States whether the value is unknown and an error happened during parsing.
     * 
     * @see SdkEnum#isUnknownValue()
     */
    @Override
    public boolean isUnknownValue() {
        return this == getUnknownEnum();
    }

    /**
     * Gets default status.
     * 
     * @return default status.
     */
    public static ResourceValueType getDefault() {
        return STRING;
    }

    /**
     * Gets Unknown state value.
     * 
     * @return unknown state.
     */
    public static ResourceValueType getUnknownEnum() {
        return UNKNOWN_ENUM;
    }

    /**
     * Gets string representation.
     * 
     * @see SdkEnum#getString()
     */
    @Override
    public String getString() {
        return value;
    }

    /**
     * Gets corresponding content type.
     * 
     * @return corresponding content type.
     */
    public EncodingType getContentType() {
        return contentType;
    }

    /**
     * Gets string representation.
     * 
     * @see Object#toString()
     */
    @Override
    public String toString() {
        return getString();
    }

    /**
     * Merges two statuses.
     * 
     * @see SdkEnum#merge(SdkEnum, SdkEnum)
     */
    @Override
    public <T extends SdkEnum> T merge(T obj1, T obj2) {
        if (obj1 == null) {
            return obj2;
        }
        if (obj2 == null) {
            return obj1;
        }
        if (obj1.isDefault()) {
            return obj2;
        }
        if (obj2.isDefault()) {
            return obj1;
        }
        return obj2;
    }
}
