// This file was generated by the Pelion SDK foundation code generator.
// This is an autogenerated unit test class. Do not modify its content as modifications will be lost at next code generation.
package com.arm.mbed.cloud.sdk.accounts.model;

import static org.junit.Assert.*;

import org.junit.Test;

/**
 * Unit tests for Model SubtenantIdentityProviderStatus.
 */
@SuppressWarnings("PMD.AvoidDuplicateLiterals")
public class TestSubtenantIdentityProviderStatus {
    /**
     * Tests the getValue method.
     */
    @SuppressWarnings("resource")
    @Test
    public void testGetValue() {
        try {
            SubtenantIdentityProviderStatus subtenantidentityproviderstatus = SubtenantIdentityProviderStatus.getValue(null);
            assertNotNull(subtenantidentityproviderstatus);
            assertTrue(subtenantidentityproviderstatus.isDefault());
            subtenantidentityproviderstatus = SubtenantIdentityProviderStatus.getValue(SubtenantIdentityProviderStatus.getDefault()
                                                                                                                      .getString());
            assertNotNull(subtenantidentityproviderstatus);
            assertTrue(subtenantidentityproviderstatus.isDefault());
            subtenantidentityproviderstatus = SubtenantIdentityProviderStatus.getValue("ACTIVE");
            assertNotNull(subtenantidentityproviderstatus);
            assertTrue(subtenantidentityproviderstatus.isDefault());
            subtenantidentityproviderstatus = SubtenantIdentityProviderStatus.getValue("SUSPENDED");
            assertNotNull(subtenantidentityproviderstatus);
            assertFalse(subtenantidentityproviderstatus.isDefault());
            subtenantidentityproviderstatus = SubtenantIdentityProviderStatus.getValue("27aef724-14ec-41b5-9c43-d054d3d35b47");
            assertNotNull(subtenantidentityproviderstatus);
            assertTrue(subtenantidentityproviderstatus.isDefault());
        } catch (Exception exception) {
            fail(exception.getMessage());
        }
    }
}
