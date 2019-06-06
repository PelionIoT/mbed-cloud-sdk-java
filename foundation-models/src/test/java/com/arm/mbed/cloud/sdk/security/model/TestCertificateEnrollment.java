// This file was generated by the Pelion SDK foundation code generator.
// This is an autogenerated unit test class. Do not modify its content as modifications will be lost at next code generation.
package com.arm.mbed.cloud.sdk.security.model;

import static org.junit.Assert.*;

import java.util.Date;
import org.junit.Test;

/**
 * Unit tests for Model CertificateEnrollment.
 */
@SuppressWarnings("PMD.AvoidDuplicateLiterals")
public class TestCertificateEnrollment {
    /**
     * Tests the clone method.
     */
    @SuppressWarnings("resource")
    @Test
    public void testClone() {
        try {
            CertificateEnrollment certificateenrollment1 = new CertificateEnrollment("y-]]]].6-y__C-",
                                                                                     new Date(1559833677331L),
                                                                                     "927d3c78-6cac-4426-af2f-a1d9241de0de",
                                                                                     CertificateEnrollmentEnrollResult.getDefault(),
                                                                                     "223bb88c-89a0-4f45-9295-e31f6b191a51",
                                                                                     CertificateEnrollmentEnrollStatus.getDefault(),
                                                                                     "b7432f34-f090-4c80-a655-dfde5c8d8939",
                                                                                     new Date(1559833676981L));
            CertificateEnrollment certificateenrollment2 = certificateenrollment1.clone();
            assertNotNull(certificateenrollment1);
            assertNotNull(certificateenrollment2);
            assertNotSame(certificateenrollment2, certificateenrollment1);
            assertEquals(certificateenrollment2, certificateenrollment1);
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
            CertificateEnrollment certificateenrollment1 = new CertificateEnrollment("y-]]]].6-y__C-",
                                                                                     new Date(1559833679610L),
                                                                                     "a88c2e8d-59d0-4f80-a2db-8ed124472441",
                                                                                     CertificateEnrollmentEnrollResult.getDefault(),
                                                                                     "96a07446-a48e-4262-8044-60143a52c647",
                                                                                     CertificateEnrollmentEnrollStatus.getDefault(),
                                                                                     "27fa8995-657f-439a-8746-26b1a0fe98fe",
                                                                                     new Date(1559833685560L));
            CertificateEnrollment certificateenrollment2 = new CertificateEnrollment("y-]]]].6-y__C-",
                                                                                     new Date(1559833679610L),
                                                                                     "a88c2e8d-59d0-4f80-a2db-8ed124472441",
                                                                                     CertificateEnrollmentEnrollResult.getDefault(),
                                                                                     "96a07446-a48e-4262-8044-60143a52c647",
                                                                                     CertificateEnrollmentEnrollStatus.getDefault(),
                                                                                     "27fa8995-657f-439a-8746-26b1a0fe98fe",
                                                                                     new Date(1559833685560L));
            assertNotNull(certificateenrollment1);
            assertNotNull(certificateenrollment2);
            assertNotSame(certificateenrollment2, certificateenrollment1);
            assertEquals(certificateenrollment2, certificateenrollment1);
            assertEquals(certificateenrollment2.hashCode(), certificateenrollment1.hashCode());
            int hashCode = certificateenrollment1.hashCode();
            for (int i = 0; i < 5; i++) {
                assertEquals(hashCode, certificateenrollment1.hashCode());
            }
        } catch (Exception exception) {
            fail(exception.getMessage());
        }
    }

    /**
     * Tests the isValid method.
     */
    @SuppressWarnings("resource")
    @Test
    public void testIsValid() {
        CertificateEnrollment certificateenrollment = new CertificateEnrollment("y-]]]].6-y__C-",
                                                                                new Date(1559833686200L),
                                                                                "94a44431-df55-4110-8f15-e2f2d68bfdde",
                                                                                CertificateEnrollmentEnrollResult.getDefault(),
                                                                                "08a66bce-45ff-40ee-8069-f0512e191b3b",
                                                                                CertificateEnrollmentEnrollStatus.getDefault(),
                                                                                "a2026d71-c916-4a51-893b-087805663a1e",
                                                                                new Date(1559833684153L));
        assertTrue(certificateenrollment.isValid());
    }

    /**
     * Tests the equals method.
     */
    @SuppressWarnings("resource")
    @Test
    public void testEquals() {
        try {
            CertificateEnrollment certificateenrollment1 = new CertificateEnrollment("y-]]]].6-y__C-",
                                                                                     new Date(1559833682702L),
                                                                                     "82d1e29b-e9fe-404b-916a-6fe98d7acc67",
                                                                                     CertificateEnrollmentEnrollResult.getDefault(),
                                                                                     "507b9726-591b-437f-a6e8-d1d34501c205",
                                                                                     CertificateEnrollmentEnrollStatus.getDefault(),
                                                                                     "3c06a58c-60f3-432e-8738-e6d83ca9826d",
                                                                                     new Date(1559833682570L));
            CertificateEnrollment certificateenrollment2 = new CertificateEnrollment("y-]]]].6-y__C-",
                                                                                     new Date(1559833682702L),
                                                                                     "82d1e29b-e9fe-404b-916a-6fe98d7acc67",
                                                                                     CertificateEnrollmentEnrollResult.getDefault(),
                                                                                     "507b9726-591b-437f-a6e8-d1d34501c205",
                                                                                     CertificateEnrollmentEnrollStatus.getDefault(),
                                                                                     "3c06a58c-60f3-432e-8738-e6d83ca9826d",
                                                                                     new Date(1559833682570L));
            CertificateEnrollment certificateenrollment3 = new CertificateEnrollment("y-]]]].6-y__C-",
                                                                                     new Date(1559833679408L),
                                                                                     "e10997b7-e683-4931-a787-9515211b4bdc",
                                                                                     CertificateEnrollmentEnrollResult.getDefault(),
                                                                                     "4801fa44-0e6f-4e7e-827f-28f8bb73afb0",
                                                                                     CertificateEnrollmentEnrollStatus.getDefault(),
                                                                                     "c9bb02b7-be22-40f9-a7df-f3869e13a83b",
                                                                                     new Date(1559833678413L));
            assertNotNull(certificateenrollment1);
            assertNotNull(certificateenrollment2);
            assertNotNull(certificateenrollment3);
            assertNotSame(certificateenrollment2, certificateenrollment1);
            assertNotSame(certificateenrollment3, certificateenrollment1);
            assertEquals(certificateenrollment2, certificateenrollment1);
            assertEquals(certificateenrollment2, certificateenrollment1);
            assertEquals(certificateenrollment1, certificateenrollment2);
            assertEquals(certificateenrollment1, certificateenrollment1);
            assertFalse(certificateenrollment1.equals(null));
            assertNotEquals(certificateenrollment3, certificateenrollment1);
        } catch (Exception exception) {
            fail(exception.getMessage());
        }
    }
}
