package com.mbed.lwm2m.base64;

import java.nio.ByteBuffer;

import org.apache.commons.codec.binary.Base64;

public class Base64Encoder {

    public Base64Encoder() {
        super();
    }

    // TODO
    // public static <T> String encodeBase64(List<T> sequence, EncodingType contentType) throws DecodingException {
    // if (sequence == null || contentType == null || contentType == EncodingType.UNKNOWN) {
    // return null;
    // }
    //
    // switch (contentType) {
    // case JSON:
    // case TLV:
    // default:
    // break;
    //
    // }
    // return null;
    // }

    public static byte[] encode(ByteBuffer input) {
        if (input == null) {
            return null;
        }
        return encode(input.array());
    }

    public static String encodeToUTF8(ByteBuffer input) {
        if (input == null) {
            return null;
        }
        return encodeToUTF8(input.array());
    }

    public static byte[] encode(byte[] input) {
        if (input == null) {
            return null;
        }
        return Base64.encodeBase64(input);
    }

    public static String encodeToUTF8(byte[] input) {
        if (input == null) {
            return null;
        }
        return Base64.encodeBase64String(input);
    }

}
