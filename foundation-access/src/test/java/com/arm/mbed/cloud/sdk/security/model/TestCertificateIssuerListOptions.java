// This file was generated by the Pelion SDK foundation code generator.
// This is an autogenerated unit test class. Do not modify its content as modifications will be lost at next code generation.
package com.arm.mbed.cloud.sdk.security.model;

import static org.junit.Assert.*;

import com.arm.mbed.cloud.sdk.common.Order;
import org.junit.Test;

/**
 * Unit tests for Model CertificateIssuerListOptions.
 */
@SuppressWarnings("PMD.AvoidDuplicateLiterals")
public class TestCertificateIssuerListOptions {
    /**
     * Tests the clone method.
     */
    @SuppressWarnings("resource")
    @Test
    public void testClone() {
        try {
            CertificateIssuerListOptions certificateissuerlistoptions1 = new CertificateIssuerListOptions(Integer.valueOf(50),
                                                                                                          Long.valueOf(-31),
                                                                                                          Order.getDefault(),
                                                                                                          "47ef6f16-01be-4879-aba9-06f06a7f30a4",
                                                                                                          null, null);
            CertificateIssuerListOptions certificateissuerlistoptions2 = certificateissuerlistoptions1.clone();
            assertNotNull(certificateissuerlistoptions1);
            assertNotNull(certificateissuerlistoptions2);
            assertNotSame(certificateissuerlistoptions2, certificateissuerlistoptions1);
            assertEquals(certificateissuerlistoptions2, certificateissuerlistoptions1);
        } catch (Exception exception) {
            fail(exception.getMessage());
        }
    }

    /**
     * Tests the hashCode method.
     */
    @SuppressWarnings("resource")
    @Test
    public void testHashCode() {
        try {
            CertificateIssuerListOptions certificateissuerlistoptions1 = new CertificateIssuerListOptions(Integer.valueOf(-14),
                                                                                                          Long.valueOf(-49),
                                                                                                          Order.getDefault(),
                                                                                                          "f208a0d4-6ad9-4983-8db8-85cd03362114",
                                                                                                          null, null);
            CertificateIssuerListOptions certificateissuerlistoptions2 = new CertificateIssuerListOptions(Integer.valueOf(-14),
                                                                                                          Long.valueOf(-49),
                                                                                                          Order.getDefault(),
                                                                                                          "f208a0d4-6ad9-4983-8db8-85cd03362114",
                                                                                                          null, null);
            assertNotNull(certificateissuerlistoptions1);
            assertNotNull(certificateissuerlistoptions2);
            assertNotSame(certificateissuerlistoptions2, certificateissuerlistoptions1);
            assertEquals(certificateissuerlistoptions2, certificateissuerlistoptions1);
            assertEquals(certificateissuerlistoptions2.hashCode(), certificateissuerlistoptions1.hashCode());
            int hashCode = certificateissuerlistoptions1.hashCode();
            for (int i = 0; i < 5; i++) {
                assertEquals(hashCode, certificateissuerlistoptions1.hashCode());
            }
        } catch (Exception exception) {
            fail(exception.getMessage());
        }
    }

    /**
     * Tests the equals method.
     */
    @SuppressWarnings("resource")
    @Test
    public void testEquals() {
        try {
            CertificateIssuerListOptions certificateissuerlistoptions1 = new CertificateIssuerListOptions(Integer.valueOf(66),
                                                                                                          Long.valueOf(46),
                                                                                                          Order.getDefault(),
                                                                                                          "173a3446-cefd-4e0a-8c88-83c63fce47f9",
                                                                                                          null, null);
            CertificateIssuerListOptions certificateissuerlistoptions2 = new CertificateIssuerListOptions(Integer.valueOf(66),
                                                                                                          Long.valueOf(46),
                                                                                                          Order.getDefault(),
                                                                                                          "173a3446-cefd-4e0a-8c88-83c63fce47f9",
                                                                                                          null, null);
            CertificateIssuerListOptions certificateissuerlistoptions3 = new CertificateIssuerListOptions(Integer.valueOf(110),
                                                                                                          Long.valueOf(-6),
                                                                                                          Order.getDefault(),
                                                                                                          "c60ed291-fd82-4148-aa8e-16910d39d2fc",
                                                                                                          null, null);
            assertNotNull(certificateissuerlistoptions1);
            assertNotNull(certificateissuerlistoptions2);
            assertNotNull(certificateissuerlistoptions3);
            assertNotSame(certificateissuerlistoptions2, certificateissuerlistoptions1);
            assertNotSame(certificateissuerlistoptions3, certificateissuerlistoptions1);
            assertEquals(certificateissuerlistoptions2, certificateissuerlistoptions1);
            assertEquals(certificateissuerlistoptions2, certificateissuerlistoptions1);
            assertEquals(certificateissuerlistoptions1, certificateissuerlistoptions2);
            assertEquals(certificateissuerlistoptions1, certificateissuerlistoptions1);
            assertFalse(certificateissuerlistoptions1.equals(null));
            assertNotEquals(certificateissuerlistoptions3, certificateissuerlistoptions1);
        } catch (Exception exception) {
            fail(exception.getMessage());
        }
    }
}
