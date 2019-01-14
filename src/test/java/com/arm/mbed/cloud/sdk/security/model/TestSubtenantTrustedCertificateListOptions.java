// This file was generated by the Pelion SDK foundation code generator.
// This is an autogenerated unit test class. Do not modify its content as modifications will be lost at next code generation.
package com.arm.mbed.cloud.sdk.security.model;

import static org.junit.Assert.*;

import com.arm.mbed.cloud.sdk.common.Order;
import org.junit.Test;

/**
 * Unit tests for Model SubtenantTrustedCertificateListOptions.
 */
public class TestSubtenantTrustedCertificateListOptions {
    /**
     * Tests the clone method.
     */
    @Test
    public void testClone() {
        try {
            SubtenantTrustedCertificateListOptions subtenanttrustedcertificatelistoptions1 = new SubtenantTrustedCertificateListOptions(Integer.valueOf(25),
                                                                                                                                        Long.valueOf(-126),
                                                                                                                                        Order.getDefault(),
                                                                                                                                        "39571219-14dc-4df2-badc-43a383053e14",
                                                                                                                                        null,
                                                                                                                                        null);
            SubtenantTrustedCertificateListOptions subtenanttrustedcertificatelistoptions2 = subtenanttrustedcertificatelistoptions1.clone();
            assertNotNull(subtenanttrustedcertificatelistoptions1);
            assertNotNull(subtenanttrustedcertificatelistoptions2);
            assertNotSame(subtenanttrustedcertificatelistoptions2, subtenanttrustedcertificatelistoptions1);
            assertEquals(subtenanttrustedcertificatelistoptions2, subtenanttrustedcertificatelistoptions1);
        } catch (Exception exception) {
            fail(exception.getMessage());
        }
    }

    /**
     * Tests the hashCode method.
     */
    @Test
    public void testHashCode() {
        try {
            SubtenantTrustedCertificateListOptions subtenanttrustedcertificatelistoptions1 = new SubtenantTrustedCertificateListOptions(Integer.valueOf(91),
                                                                                                                                        Long.valueOf(-17),
                                                                                                                                        Order.getDefault(),
                                                                                                                                        "381cb82e-8f37-4387-a3ff-f5c66bebf44f",
                                                                                                                                        null,
                                                                                                                                        null);
            SubtenantTrustedCertificateListOptions subtenanttrustedcertificatelistoptions2 = new SubtenantTrustedCertificateListOptions(Integer.valueOf(91),
                                                                                                                                        Long.valueOf(-17),
                                                                                                                                        Order.getDefault(),
                                                                                                                                        "381cb82e-8f37-4387-a3ff-f5c66bebf44f",
                                                                                                                                        null,
                                                                                                                                        null);
            assertNotNull(subtenanttrustedcertificatelistoptions1);
            assertNotNull(subtenanttrustedcertificatelistoptions2);
            assertNotSame(subtenanttrustedcertificatelistoptions2, subtenanttrustedcertificatelistoptions1);
            assertEquals(subtenanttrustedcertificatelistoptions2, subtenanttrustedcertificatelistoptions1);
            assertEquals(subtenanttrustedcertificatelistoptions2.hashCode(),
                         subtenanttrustedcertificatelistoptions1.hashCode());
            int hashCode = subtenanttrustedcertificatelistoptions1.hashCode();
            for (int i = 0; i < 5; i++) {
                assertEquals(hashCode, subtenanttrustedcertificatelistoptions1.hashCode());
            }
        } catch (Exception exception) {
            fail(exception.getMessage());
        }
    }

    /**
     * Tests the equals method.
     */
    @Test
    public void testEquals() {
        try {
            SubtenantTrustedCertificateListOptions subtenanttrustedcertificatelistoptions1 = new SubtenantTrustedCertificateListOptions(Integer.valueOf(104),
                                                                                                                                        Long.valueOf(-84),
                                                                                                                                        Order.getDefault(),
                                                                                                                                        "c8413911-725d-4c6e-9fac-2e9a27cc1f65",
                                                                                                                                        null,
                                                                                                                                        null);
            SubtenantTrustedCertificateListOptions subtenanttrustedcertificatelistoptions2 = new SubtenantTrustedCertificateListOptions(Integer.valueOf(104),
                                                                                                                                        Long.valueOf(-84),
                                                                                                                                        Order.getDefault(),
                                                                                                                                        "c8413911-725d-4c6e-9fac-2e9a27cc1f65",
                                                                                                                                        null,
                                                                                                                                        null);
            SubtenantTrustedCertificateListOptions subtenanttrustedcertificatelistoptions3 = new SubtenantTrustedCertificateListOptions(Integer.valueOf(20),
                                                                                                                                        Long.valueOf(28),
                                                                                                                                        Order.getDefault(),
                                                                                                                                        "eab26637-8a05-472d-8912-00ef4a3400f6",
                                                                                                                                        null,
                                                                                                                                        null);
            assertNotNull(subtenanttrustedcertificatelistoptions1);
            assertNotNull(subtenanttrustedcertificatelistoptions2);
            assertNotNull(subtenanttrustedcertificatelistoptions3);
            assertNotSame(subtenanttrustedcertificatelistoptions2, subtenanttrustedcertificatelistoptions1);
            assertNotSame(subtenanttrustedcertificatelistoptions3, subtenanttrustedcertificatelistoptions1);
            assertEquals(subtenanttrustedcertificatelistoptions2, subtenanttrustedcertificatelistoptions1);
            assertEquals(subtenanttrustedcertificatelistoptions2, subtenanttrustedcertificatelistoptions1);
            assertEquals(subtenanttrustedcertificatelistoptions1, subtenanttrustedcertificatelistoptions2);
            assertEquals(subtenanttrustedcertificatelistoptions1, subtenanttrustedcertificatelistoptions1);
            assertFalse(subtenanttrustedcertificatelistoptions1.equals(null));
            assertNotEquals(subtenanttrustedcertificatelistoptions3, subtenanttrustedcertificatelistoptions1);
        } catch (Exception exception) {
            fail(exception.getMessage());
        }
    }
}
