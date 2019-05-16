package com.mbed.lwm2m.tlv;

/**
 * Length of the identifier
 * <p>
 * Identifier can be 8 bits or 16 bits long
 *
 */
public enum IdentifierLength {
    ONE_BYTE,
    TWO_BYTES;

    public static IdentifierLength determine(int typeField) {
        // Evaluates Bit 5:
        // 0 : the identifier field of this TLV is 1 byte long
        // 1 : the identifier field of this TLV is 2 bytes long
        return ((typeField & Mask.ID_LENGTH.getBinaryRepresentation()) == 0) ? ONE_BYTE : TWO_BYTES;
    }
}
