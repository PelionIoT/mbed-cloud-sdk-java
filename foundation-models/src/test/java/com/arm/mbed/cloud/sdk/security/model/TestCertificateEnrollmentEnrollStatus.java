// This file was generated by the Pelion SDK foundation code generator.
// This is an autogenerated unit test class. Do not modify its content as modifications will be lost at next code generation.
package com.arm.mbed.cloud.sdk.security.model;

import static org.junit.Assert.*;

import org.junit.Test;

/**
 * Unit tests for Model CertificateEnrollmentEnrollStatus.
 */
@SuppressWarnings("PMD.AvoidDuplicateLiterals")
public class TestCertificateEnrollmentEnrollStatus {
    /**
     * Tests the getValue method.
     */
    @SuppressWarnings("resource")
    @Test
    public void testGetValue() {
        try {
            CertificateEnrollmentEnrollStatus certificateenrollmentenrollstatus = CertificateEnrollmentEnrollStatus.getValue(null);
            assertNotNull(certificateenrollmentenrollstatus);
            assertTrue(certificateenrollmentenrollstatus.isDefault());
            certificateenrollmentenrollstatus = CertificateEnrollmentEnrollStatus.getValue(CertificateEnrollmentEnrollStatus.getDefault()
                                                                                                                            .getString());
            assertNotNull(certificateenrollmentenrollstatus);
            assertTrue(certificateenrollmentenrollstatus.isDefault());
            certificateenrollmentenrollstatus = CertificateEnrollmentEnrollStatus.getValue("COMPLETED");
            assertNotNull(certificateenrollmentenrollstatus);
            assertTrue(certificateenrollmentenrollstatus.isDefault());
            certificateenrollmentenrollstatus = CertificateEnrollmentEnrollStatus.getValue("new");
            assertNotNull(certificateenrollmentenrollstatus);
            assertFalse(certificateenrollmentenrollstatus.isDefault());
            certificateenrollmentenrollstatus = CertificateEnrollmentEnrollStatus.getValue("bb5f5cc2-a130-46b2-b02c-d58f9fdbe06e");
            assertNotNull(certificateenrollmentenrollstatus);
            assertTrue(certificateenrollmentenrollstatus.isDefault());
        } catch (Exception exception) {
            fail(exception.getMessage());
        }
    }
}
