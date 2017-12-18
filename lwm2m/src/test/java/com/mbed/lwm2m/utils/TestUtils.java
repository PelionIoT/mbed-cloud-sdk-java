package com.mbed.lwm2m.utils;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class TestUtils {

    @Test
    public void testToHex() {
        byte[] byteArray = { 0x50, 0x72, 0x32, -4, 0xC, 0x1A, 0x7F };
        assertEquals("507232FC0C1A7F".toLowerCase(), HexArray.toHex(byteArray).toLowerCase());
    }

}
