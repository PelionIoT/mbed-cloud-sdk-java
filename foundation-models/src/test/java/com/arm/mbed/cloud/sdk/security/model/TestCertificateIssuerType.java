// This file was generated by the Pelion SDK foundation code generator.
// This is an autogenerated unit test class. Do not modify its content as modifications will be lost at next code generation.
package com.arm.mbed.cloud.sdk.security.model;

import static org.junit.Assert.*;

import org.junit.Test;

/**
 * Unit tests for Model CertificateIssuerType.
 */
public class TestCertificateIssuerType {
    /**
     * Tests the getValue method.
     */
    @Test
    public void testGetValue() {
        try {
            CertificateIssuerType certificateissuertype = CertificateIssuerType.getValue(null);
            assertNotNull(certificateissuertype);
            assertTrue(certificateissuertype.isDefault());
            certificateissuertype = CertificateIssuerType.getValue(CertificateIssuerType.getDefault().getString());
            assertNotNull(certificateissuertype);
            assertTrue(certificateissuertype.isDefault());
            certificateissuertype = CertificateIssuerType.getValue("CFSSL_AUTH");
            assertNotNull(certificateissuertype);
            assertTrue(certificateissuertype.isDefault());
            certificateissuertype = CertificateIssuerType.getValue("GLOBAL_SIGN");
            assertNotNull(certificateissuertype);
            assertFalse(certificateissuertype.isDefault());
            certificateissuertype = CertificateIssuerType.getValue("bc05bbe6-2240-4698-aad1-48cc04cb9fcd");
            assertNotNull(certificateissuertype);
            assertTrue(certificateissuertype.isDefault());
        } catch (Exception exception) {
            fail(exception.getMessage());
        }
    }
}
