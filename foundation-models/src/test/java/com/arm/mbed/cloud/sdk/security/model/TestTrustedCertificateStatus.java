// This file was generated by the Pelion SDK foundation code generator.
// This is an autogenerated unit test class. Do not modify its content as modifications will be lost at next code generation.
package com.arm.mbed.cloud.sdk.security.model;

import static org.junit.Assert.*;

import org.junit.Test;

/**
 * Unit tests for Model TrustedCertificateStatus.
 */
@SuppressWarnings("PMD.AvoidDuplicateLiterals")
public class TestTrustedCertificateStatus {
    /**
     * Tests the getValue method.
     */
    @SuppressWarnings("resource")
    @Test
    public void testGetValue() {
        try {
            TrustedCertificateStatus trustedcertificatestatus = TrustedCertificateStatus.getValue(null);
            assertNotNull(trustedcertificatestatus);
            assertTrue(trustedcertificatestatus.isDefault());
            trustedcertificatestatus = TrustedCertificateStatus.getValue(TrustedCertificateStatus.getDefault()
                                                                                                 .getString());
            assertNotNull(trustedcertificatestatus);
            assertTrue(trustedcertificatestatus.isDefault());
            trustedcertificatestatus = TrustedCertificateStatus.getValue("ACTIVE");
            assertNotNull(trustedcertificatestatus);
            assertTrue(trustedcertificatestatus.isDefault());
            trustedcertificatestatus = TrustedCertificateStatus.getValue("INACTIVE");
            assertNotNull(trustedcertificatestatus);
            assertFalse(trustedcertificatestatus.isDefault());
            trustedcertificatestatus = TrustedCertificateStatus.getValue("26d6b2e8-cff5-4c27-98df-2e7ab47a1146");
            assertNotNull(trustedcertificatestatus);
            assertTrue(trustedcertificatestatus.isDefault());
        } catch (Exception exception) {
            fail(exception.getMessage());
        }
    }
}