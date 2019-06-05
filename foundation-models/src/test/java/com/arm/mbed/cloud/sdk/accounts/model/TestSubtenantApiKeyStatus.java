// This file was generated by the Pelion SDK foundation code generator.
// This is an autogenerated unit test class. Do not modify its content as modifications will be lost at next code generation.
package com.arm.mbed.cloud.sdk.accounts.model;

import static org.junit.Assert.*;

import org.junit.Test;

/**
 * Unit tests for Model SubtenantApiKeyStatus.
 */
@SuppressWarnings("PMD.AvoidDuplicateLiterals")
public class TestSubtenantApiKeyStatus {
    /**
     * Tests the getValue method.
     */
    @SuppressWarnings("resource")
    @Test
    public void testGetValue() {
        try {
            SubtenantApiKeyStatus subtenantapikeystatus = SubtenantApiKeyStatus.getValue(null);
            assertNotNull(subtenantapikeystatus);
            assertTrue(subtenantapikeystatus.isDefault());
            subtenantapikeystatus = SubtenantApiKeyStatus.getValue(SubtenantApiKeyStatus.getDefault().getString());
            assertNotNull(subtenantapikeystatus);
            assertTrue(subtenantapikeystatus.isDefault());
            subtenantapikeystatus = SubtenantApiKeyStatus.getValue("ACTIVE");
            assertNotNull(subtenantapikeystatus);
            assertTrue(subtenantapikeystatus.isDefault());
            subtenantapikeystatus = SubtenantApiKeyStatus.getValue("INACTIVE");
            assertNotNull(subtenantapikeystatus);
            assertFalse(subtenantapikeystatus.isDefault());
            subtenantapikeystatus = SubtenantApiKeyStatus.getValue("fdfe1354-b836-4199-8c58-b57d5e813ec6");
            assertNotNull(subtenantapikeystatus);
            assertTrue(subtenantapikeystatus.isDefault());
        } catch (Exception exception) {
            fail(exception.getMessage());
        }
    }
}
