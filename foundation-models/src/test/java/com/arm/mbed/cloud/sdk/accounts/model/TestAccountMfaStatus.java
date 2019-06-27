// This file was generated by the Pelion SDK foundation code generator.
// This is an autogenerated unit test class. Do not modify its content as modifications will be lost at next code generation.
package com.arm.mbed.cloud.sdk.accounts.model;

import static org.junit.Assert.*;

import org.junit.Test;

/**
 * Unit tests for Model AccountMfaStatus.
 */
@SuppressWarnings("PMD.AvoidDuplicateLiterals")
public class TestAccountMfaStatus {
    /**
     * Tests the getValue method.
     */
    @SuppressWarnings("resource")
    @Test
    public void testGetValue() {
        try {
            AccountMfaStatus accountmfastatus = AccountMfaStatus.getValue(null);
            assertNotNull(accountmfastatus);
            assertTrue(accountmfastatus.isDefault());
            accountmfastatus = AccountMfaStatus.getValue(AccountMfaStatus.getDefault().getString());
            assertNotNull(accountmfastatus);
            assertTrue(accountmfastatus.isDefault());
            accountmfastatus = AccountMfaStatus.getValue("ENFORCED");
            assertNotNull(accountmfastatus);
            assertTrue(accountmfastatus.isDefault());
            accountmfastatus = AccountMfaStatus.getValue("optional");
            assertNotNull(accountmfastatus);
            assertFalse(accountmfastatus.isDefault());
            accountmfastatus = AccountMfaStatus.getValue("9d7cfc77-39ed-46ea-bbf6-54764685cfc8");
            assertNotNull(accountmfastatus);
            assertTrue(accountmfastatus.isDefault());
        } catch (Exception exception) {
            fail(exception.getMessage());
        }
    }
}
