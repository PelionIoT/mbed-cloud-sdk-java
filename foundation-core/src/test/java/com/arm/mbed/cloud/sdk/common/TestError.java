package com.arm.mbed.cloud.sdk.common;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotSame;

import org.junit.Test;

import nl.jqno.equalsverifier.EqualsVerifier;
import nl.jqno.equalsverifier.Warning;

public class TestError {

    @Test
    public void testClone() {
        Error error = new Error(205, "some type", "some message", "requestId_10");
        Error clone = error.clone();
        assertNotSame(error, clone);
        assertEquals(error, clone);
    }

    @Test
    public void equalsContract() {
        EqualsVerifier.forClass(Error.class).suppress(Warning.NONFINAL_FIELDS).verify();
    }
}
