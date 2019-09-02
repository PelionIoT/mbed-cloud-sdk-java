// This file was generated by the Pelion SDK foundation code generator.
// This is an autogenerated unit test class. Do not modify its content as modifications will be lost at next code generation.
package com.arm.mbed.cloud.sdk.accounts.model;

import static org.junit.Assert.*;

import org.junit.Test;

/**
 * Unit tests for Model PolicyInheritedType.
 */
@SuppressWarnings("PMD.AvoidDuplicateLiterals")
public class TestPolicyInheritedType {
    /**
     * Tests the getValue method.
     */
    @SuppressWarnings("resource")
    @Test
    public void testGetValue() {
        try {
            PolicyInheritedType policyinheritedtype = PolicyInheritedType.getValue(null);
            assertNotNull(policyinheritedtype);
            assertTrue(policyinheritedtype.isDefault());
            policyinheritedtype = PolicyInheritedType.getValue(PolicyInheritedType.getDefault().getString());
            assertNotNull(policyinheritedtype);
            assertTrue(policyinheritedtype.isDefault());
            policyinheritedtype = PolicyInheritedType.getValue("ACCOUNT");
            assertNotNull(policyinheritedtype);
            assertTrue(policyinheritedtype.isDefault());
            policyinheritedtype = PolicyInheritedType.getValue("template");
            assertNotNull(policyinheritedtype);
            assertFalse(policyinheritedtype.isDefault());
            policyinheritedtype = PolicyInheritedType.getValue("552d5bfd-354b-4f29-82f1-fc05b94cd384");
            assertNotNull(policyinheritedtype);
            assertTrue(policyinheritedtype.isDefault());
        } catch (Exception exception) {
            fail(exception.getMessage());
        }
    }
}
