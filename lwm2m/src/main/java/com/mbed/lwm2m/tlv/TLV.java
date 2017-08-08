package com.mbed.lwm2m.tlv;

public interface TLV {
    /** HTTP Media type for OMA TLV content. */
    static final String HTTP_MEDIA_TYPE_LWM2M_TLV = "application/vnd.oma.lwm2m+tlv";

    static final int OBJECT_INSTANCE_BINARY_VALUE = 0b00000000;

    static final int RESOURCE_INSTANCE_BINARY_VALUE = 0b01000000;

    static final int MULTI_RESOURCE_BINARY_VALUE = 0b10000000;

    static final int RESOURCE_VALUE_BINARY_VALUE = 0b11000000;

    static final int TWO_BITS_BINARY_VALUE = 0b00000000;

    static final int ONE_BYTE_BINARY_VALUE = 0b00001000;

    static final int TWO_BYTES_BINARY_VALUE = 0b00010000;

    static final int THREE_BYTE_BINARY_VALUE = 0b00011000;
}
