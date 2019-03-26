// This file was generated by the Pelion SDK foundation code generator.
// This is an autogenerated unit test class. Do not modify its content as modifications will be lost at next code generation.
package com.arm.mbed.cloud.sdk.accounts.model;

import static org.junit.Assert.*;

import org.junit.Test;

/**
 * Unit tests for Model ApiKeyStatus.
 */
@SuppressWarnings("PMD.AvoidDuplicateLiterals")
public class TestApiKeyStatus {
    /**
     * Tests the getValue method.
     */
    @SuppressWarnings("resource")
    @Test
    public void testGetValue() {
        try {
            ApiKeyStatus apikeystatus = ApiKeyStatus.getValue(null);
            assertNotNull(apikeystatus);
            assertTrue(apikeystatus.isDefault());
            apikeystatus = ApiKeyStatus.getValue(ApiKeyStatus.getDefault().getString());
            assertNotNull(apikeystatus);
            assertTrue(apikeystatus.isDefault());
            apikeystatus = ApiKeyStatus.getValue("ACTIVE");
            assertNotNull(apikeystatus);
            assertTrue(apikeystatus.isDefault());
            apikeystatus = ApiKeyStatus.getValue("INACTIVE");
            assertNotNull(apikeystatus);
            assertFalse(apikeystatus.isDefault());
            apikeystatus = ApiKeyStatus.getValue("563b09d3-9035-4959-9529-7cb135d73cdc");
            assertNotNull(apikeystatus);
            assertTrue(apikeystatus.isDefault());
        } catch (Exception exception) {
            fail(exception.getMessage());
        }
    }
}
