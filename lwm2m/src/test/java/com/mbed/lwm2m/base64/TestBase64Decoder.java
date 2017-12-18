package com.mbed.lwm2m.base64;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class TestBase64Decoder {

    @Test
    public void testDecodeString() {
        assertEquals("This is a test for decoding base64 encoded strings",
                Base64Decoder.decodeToUtf8("VGhpcyBpcyBhIHRlc3QgZm9yIGRlY29kaW5nIGJhc2U2NCBlbmNvZGVkIHN0cmluZ3M="));
    }

}
