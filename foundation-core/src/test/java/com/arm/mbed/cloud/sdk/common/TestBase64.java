package com.arm.mbed.cloud.sdk.common;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.nio.ByteBuffer;

import org.junit.Test;

import nl.jqno.equalsverifier.EqualsVerifier;
import nl.jqno.equalsverifier.Warning;

public class TestBase64 {

    @Test
    public void testDecodingEncoding() {
        String encodedSource = "VGhpcyBpcyBhIHRlc3QgZm9yIGRlY29kaW5nIGJhc2U2NCBlbmNvZGVkIHN0cmluZ3M=";
        byte[] encodedByteArray = { 0x56, 0x47, 0x68, 0x70, 0x63, 0x79, 0x42, 0x70, 0x63, 0x79, 0x42, 0x68, 0x49, 0x48,
                                    0x52, 0x6c, 0x63, 0x33, 0x51, 0x67, 0x5a, 0x6d, 0x39, 0x79, 0x49, 0x47, 0x52, 0x6c,
                                    0x59, 0x32, 0x39, 0x6b, 0x61, 0x57, 0x35, 0x6e, 0x49, 0x47, 0x4a, 0x68, 0x63, 0x32,
                                    0x55, 0x32, 0x4e, 0x43, 0x42, 0x6c, 0x62, 0x6d, 0x4e, 0x76, 0x5a, 0x47, 0x56, 0x6b,
                                    0x49, 0x48, 0x4e, 0x30, 0x63, 0x6d, 0x6c, 0x75, 0x5a, 0x33, 0x4d, 0x3d };
        String expectedDecodedValue = "This is a test for decoding base64 encoded strings";
        byte[] expectedDecodedByteArray = { 0x54, 0x68, 0x69, 0x73, 0x20, 0x69, 0x73, 0x20, 0x61, 0x20, 0x74, 0x65,
                                            0x73, 0x74, 0x20, 0x66, 0x6f, 0x72, 0x20, 0x64, 0x65, 0x63, 0x6f, 0x64,
                                            0x69, 0x6e, 0x67, 0x20, 0x62, 0x61, 0x73, 0x65, 0x36, 0x34, 0x20, 0x65,
                                            0x6e, 0x63, 0x6f, 0x64, 0x65, 0x64, 0x20, 0x73, 0x74, 0x72, 0x69, 0x6e,
                                            0x67, 0x73 };
        Base64 test = new Base64((String) null);
        assertTrue(test.isEmpty());
        test = Base64.decode(encodedSource);
        assertNotNull(test);
        assertFalse(test.isEmpty());
        assertEquals(encodedSource, test.getEncodedString());
        assertEquals(expectedDecodedValue, test.getUnencodedString());
        test = new Base64(expectedDecodedValue);
        assertEquals(expectedDecodedValue, test.getUnencodedString());
        assertEquals(encodedSource, test.getEncodedString());
        ByteBuffer buffer = ByteBuffer.wrap(expectedDecodedByteArray);
        test = new Base64(buffer);
        assertEquals(expectedDecodedValue, test.getUnencodedString());
        assertEquals(encodedSource, test.getEncodedString());
        buffer = ByteBuffer.wrap(encodedByteArray);
        test = Base64.decode(buffer);
        assertArrayEquals(expectedDecodedByteArray, test.getUnencodedArray());
        assertArrayEquals(expectedDecodedByteArray, test.getUnencodedBuffer().array());
        assertArrayEquals(encodedByteArray, test.getEncodedBuffer().array());
    }

    @Test
    public void equalsContract() {
        EqualsVerifier.forClass(Base64.class).suppress(Warning.STRICT_INHERITANCE).verify();
    }

}
