package com.mbed.lwm2m.tlv;

/**
 * Masks to apply to Type field in order to retrieve all necessary information regarding parsing
 */
public enum Mask {
    /**
     * Bits 7-6
     */
    ID_TYPE(0b11000000),
    /**
     * Bit 5
     */
    ID_LENGTH(0b00100000),
    /**
     * Bits 4-3
     */
    LENGTH_TYPE(0b00011000),
    /**
     * Bits 2-3
     */
    LENGTH(0b00000111);

    private final int binaryRepresentation;

    private Mask(int binaryRepresentation) {
        this.binaryRepresentation = binaryRepresentation;
    }

    /**
     * @return the binaryRepresentation
     */
    public int getBinaryRepresentation() {
        return binaryRepresentation;
    }

}
