package com.mbed.lwm2m.utils;

import org.apache.commons.codec.binary.Hex;

/**
 * Utility class to convert byte array to string.
 */
public class HexArray {

    public static String toHex(byte[] value) {
        if (value == null) {
            return null;
        }
        return Hex.encodeHexString(value);
    }

}
