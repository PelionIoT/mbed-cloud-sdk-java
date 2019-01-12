// This file was generated by the Pelion SDK foundation code generator.
// This is an autogenerated unit test class. Do not modify its content as modifications will be lost at next code generation.
package com.arm.mbed.cloud.sdk.accounts.model;

import static org.junit.Assert.*;

import org.junit.Test;

/**
 * Unit tests for Model UserStatus.
 */
public class TestUserStatus {
    /**
     * Tests the getValue method.
     */
    @Test
    public void testGetValue() {
        try {
            UserStatus userstatus = UserStatus.getValue(null);
            assertNotNull(userstatus);
            assertTrue(userstatus.isDefault());
            userstatus = UserStatus.getValue(UserStatus.getDefault().getString());
            assertNotNull(userstatus);
            assertTrue(userstatus.isDefault());
            userstatus = UserStatus.getValue("ACTIVE");
            assertNotNull(userstatus);
            assertTrue(userstatus.isDefault());
            userstatus = UserStatus.getValue("ENROLLING");
            assertNotNull(userstatus);
            assertFalse(userstatus.isDefault());
            userstatus = UserStatus.getValue("f8a4b748-79db-4c0f-925f-0c868c8fa792");
            assertNotNull(userstatus);
            assertTrue(userstatus.isDefault());
        } catch (Exception exception) {
            fail(exception.getMessage());
        }
    }
}
