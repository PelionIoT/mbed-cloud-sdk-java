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
            CertificateEnrollment certificateenrollment1 = new CertificateEnrollment("_-]].-N",
                                                                                     new Date(1558003279164L),
                                                                                     "ac51952b-3a8f-4389-ba7c-7f18d97b6ced",
                                                                                     CertificateEnrollmentEnrollResult.getDefault(),
                                                                                     "fdb1748f-15c8-428a-9a3b-842d525ba866",
                                                                                     CertificateEnrollmentEnrollStatus.getDefault(),
                                                                                     "88f2565f-5592-41cc-95f5-1fb7bd49a5f0",
                                                                                     new Date(1558003277248L));
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
            CertificateEnrollment certificateenrollment1 = new CertificateEnrollment("_-]].-N",
                                                                                     new Date(1558003280547L),
                                                                                     "86ba9923-07e4-47b7-99e9-a9b396b8f6fe",
                                                                                     CertificateEnrollmentEnrollResult.getDefault(),
                                                                                     "9ff6e679-e541-43a4-8a7d-b23fc6c7f101",
                                                                                     CertificateEnrollmentEnrollStatus.getDefault(),
                                                                                     "d387e330-dd75-4304-ba42-c65445de0d9f",
                                                                                     new Date(1558003277641L));
            CertificateEnrollment certificateenrollment2 = new CertificateEnrollment("_-]].-N",
                                                                                     new Date(1558003280547L),
                                                                                     "86ba9923-07e4-47b7-99e9-a9b396b8f6fe",
                                                                                     CertificateEnrollmentEnrollResult.getDefault(),
                                                                                     "9ff6e679-e541-43a4-8a7d-b23fc6c7f101",
                                                                                     CertificateEnrollmentEnrollStatus.getDefault(),
                                                                                     "d387e330-dd75-4304-ba42-c65445de0d9f",
                                                                                     new Date(1558003277641L));
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
        CertificateEnrollment certificateenrollment = new CertificateEnrollment("_-]].-N", new Date(1558003282392L),
                                                                                "4fe6beaf-eca7-4fbc-bcbe-dba61f78a599",
                                                                                CertificateEnrollmentEnrollResult.getDefault(),
                                                                                "cc560844-f5c2-421b-80db-1ad789fba250",
                                                                                CertificateEnrollmentEnrollStatus.getDefault(),
                                                                                "15ab8221-ff44-448e-9ad2-2dfc58f95ac6",
                                                                                new Date(1558003281506L));
        assertTrue(certificateenrollment.isValid());
    }

    /**
     * Tests the equals method.
     */
    @SuppressWarnings("resource")
    @Test
    public void testEquals() {
        try {
            CertificateEnrollment certificateenrollment1 = new CertificateEnrollment("_-]].-N",
                                                                                     new Date(1558003276082L),
                                                                                     "980ab9a1-01c5-46d0-8786-629ea5817b91",
                                                                                     CertificateEnrollmentEnrollResult.getDefault(),
                                                                                     "65e50fca-72aa-4b06-930c-43932860d9a0",
                                                                                     CertificateEnrollmentEnrollStatus.getDefault(),
                                                                                     "0e1eb923-1e5f-466c-a7c1-912953ba8502",
                                                                                     new Date(1558003280719L));
            CertificateEnrollment certificateenrollment2 = new CertificateEnrollment("_-]].-N",
                                                                                     new Date(1558003276082L),
                                                                                     "980ab9a1-01c5-46d0-8786-629ea5817b91",
                                                                                     CertificateEnrollmentEnrollResult.getDefault(),
                                                                                     "65e50fca-72aa-4b06-930c-43932860d9a0",
                                                                                     CertificateEnrollmentEnrollStatus.getDefault(),
                                                                                     "0e1eb923-1e5f-466c-a7c1-912953ba8502",
                                                                                     new Date(1558003280719L));
            CertificateEnrollment certificateenrollment3 = new CertificateEnrollment("_-]].-N",
                                                                                     new Date(1558003282405L),
                                                                                     "fc267cd1-32eb-4583-bba3-d671d5530202",
                                                                                     CertificateEnrollmentEnrollResult.getDefault(),
                                                                                     "dcb2049f-0c04-4cc9-a81a-04ca214701e7",
                                                                                     CertificateEnrollmentEnrollStatus.getDefault(),
                                                                                     "58836bef-295c-4fe5-a1d4-d06f5c697b2a",
                                                                                     new Date(1558003281211L));
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