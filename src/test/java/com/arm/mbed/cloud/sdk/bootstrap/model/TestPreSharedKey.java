package com.arm.mbed.cloud.sdk.bootstrap.model;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class TestPreSharedKey {

    @Test
    public void testIsSecretValid() {
        PreSharedKey key = new PreSharedKey();
        key.setSecret("4a4a4a4a4a4a4a4a4a4a4a4a4a4a4a4a");
        assertTrue(key.isSecretValid());
        key.setSecret("4a4a4a4a4h4a4a4a4a4a4a4a4a4a4a4a");
        assertFalse(key.isSecretValid());
        key.setSecret("4a4a");
        assertFalse(key.isSecretValid());
        key.setSecret("4a4a4a4a4h4a4a4a4a4a4a4a4a4a4a4ab");
        assertFalse(key.isSecretValid());
        key.setSecret("0x4a4a4a4a4a4a4a4a4a4a4a4a4a4a4a4a4a4a4a4a4a4a4a4a4a4a4a4a4a4a4a4a");
        assertTrue(key.isSecretValid());
        key.setSecret("0x4a4a4a4a4a4a4a4a");
        assertTrue(key.isSecretValid());
        key.setSecret("0x4a4a4a4a4a4a4a4");
        assertFalse(key.isSecretValid());

    }

    @Test
    public void testIsIdentifierValid() {
        PreSharedKey key = new PreSharedKey();
        key.setId("4a4a>=?4a4a4a4!~a4a4a");
        assertTrue(key.isIdentifierValid());
        key.setId("4a4a4a4a4a4a4a4a");
        assertTrue(key.isIdentifierValid());
        key.setId("4a4a4a4a4a4a4a4");
        assertFalse(key.isIdentifierValid());
        key.setId("4a4a4a4a4a4a4a4a4a4a4a4a4a4a4a4a4a4a4a4a4a4a4a4a4a4a4a4a4a4a4a4a");
        assertTrue(key.isIdentifierValid());
        key.setId("4a4a4a4a4a4a4a4a4a4a4a4a4a4a4a4a4a4a4a4a4a4a4a4a4a4a4a4a4a4a4a4ap");
        assertFalse(key.isIdentifierValid());
    }

    @Test
    public void testIsValid() {
        PreSharedKey key = new PreSharedKey();
        assertFalse(key.isValid());
        key.setId("4a4a>=?4a4a4a4!~a4a4a");
        assertTrue(key.isValid());
        key.setSecret("4a4a4a4a4a4a4a4a4a4a4a4a4a4a4a4a");
        assertTrue(key.isValid());
        key.setId(null);
        assertFalse(key.isValid());
    }

}
