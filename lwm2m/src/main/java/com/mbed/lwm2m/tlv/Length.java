package com.mbed.lwm2m.tlv;

import com.mbed.lwm2m.DecodingException;

/**
 * TLV Length
 */
public enum Length {
    /**
     * No length field. The value immediately follows the Identifier field and is of the length indicated by Bits 2-0 of
     * Type field
     */
    THREE_BITS(TLV.TWO_BITS_BINARY_VALUE),
    /**
     * The length field is of 8 bits and Bits 2-0 of Type field must be ignored
     */
    ONE_BYTE(TLV.ONE_BYTE_BINARY_VALUE),
    /**
     * The length field is 16 bits and Bits 2-0 of Type field must be ignored
     */
    TWO_BYTES(TLV.TWO_BYTES_BINARY_VALUE),
    /**
     * The length field is of 24 bits and Bits 2-0 of Type field must be ignored
     */
    THREE_BYTE(TLV.THREE_BYTE_BINARY_VALUE);
    private final int binaryRepresentation;

    private Length(int binaryRepresentation) {
        this.binaryRepresentation = binaryRepresentation;
    }

    /**
     * @return the binaryRepresentation
     */
    public int getBinaryRepresentation() {
        return binaryRepresentation;
    }

    public static Length getType(int typeField) throws DecodingException {
        int lengthValue = typeField & Mask.LENGTH_TYPE.getBinaryRepresentation();
        switch (lengthValue) {
            case TLV.TWO_BITS_BINARY_VALUE:
                return Length.THREE_BITS;
            case TLV.ONE_BYTE_BINARY_VALUE:
                return Length.ONE_BYTE;
            case TLV.TWO_BYTES_BINARY_VALUE:
                return Length.TWO_BYTES;
            case TLV.THREE_BYTE_BINARY_VALUE:
                return THREE_BYTE;
            default:
                break;
        }
        throw new DecodingException("Unknown length value: " + String.valueOf(lengthValue));

    }

}
