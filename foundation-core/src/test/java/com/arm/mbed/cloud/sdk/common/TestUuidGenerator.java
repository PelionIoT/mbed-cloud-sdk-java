package com.arm.mbed.cloud.sdk.common;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Test;

public class TestUuidGenerator {

    @Test
    public void testGenerate() {
        final String uuid1 = UuidGenerator.generate();
        final String uuid2 = UuidGenerator.generate();
        assertNotNull(uuid1);
        assertNotNull(uuid2);
        assertFalse(uuid1.isEmpty());
        assertFalse(uuid2.isEmpty());
        assertNotEquals(uuid2, uuid1);
    }

}
