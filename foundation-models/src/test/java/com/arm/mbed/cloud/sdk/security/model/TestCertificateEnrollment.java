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
            CertificateEnrollment certificateenrollment1 = new CertificateEnrollment("J-].l.", new Date(1557969575392L),
                                                                                     "55b26b2b-4edc-45f2-b391-de783c62932b",
                                                                                     CertificateEnrollmentEnrollResult.getDefault(),
                                                                                     "dc8a5bef-761d-4495-b661-47bd6223a682",
                                                                                     CertificateEnrollmentEnrollStatus.getDefault(),
                                                                                     "91acbc51-262b-4a84-8080-53496f5f2eb6",
                                                                                     new Date(1557969576562L));
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
            CertificateEnrollment certificateenrollment1 = new CertificateEnrollment("J-].l.", new Date(1557969575749L),
                                                                                     "d7662426-cff8-4470-a378-1ab010fbb5a1",
                                                                                     CertificateEnrollmentEnrollResult.getDefault(),
                                                                                     "bcdb3db0-b3b1-46de-8f6a-88cf39565a0d",
                                                                                     CertificateEnrollmentEnrollStatus.getDefault(),
                                                                                     "8133e6b4-a7d6-4973-8ba7-41e249672924",
                                                                                     new Date(1557969576787L));
            CertificateEnrollment certificateenrollment2 = new CertificateEnrollment("J-].l.", new Date(1557969575749L),
                                                                                     "d7662426-cff8-4470-a378-1ab010fbb5a1",
                                                                                     CertificateEnrollmentEnrollResult.getDefault(),
                                                                                     "bcdb3db0-b3b1-46de-8f6a-88cf39565a0d",
                                                                                     CertificateEnrollmentEnrollStatus.getDefault(),
                                                                                     "8133e6b4-a7d6-4973-8ba7-41e249672924",
                                                                                     new Date(1557969576787L));
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
        CertificateEnrollment certificateenrollment = new CertificateEnrollment("J-].l.", new Date(1557969572027L),
                                                                                "80f8dee2-dd09-452d-b557-b5ebf265b1ed",
                                                                                CertificateEnrollmentEnrollResult.getDefault(),
                                                                                "d61f1314-2a43-4bf2-b488-05a3c64f1b37",
                                                                                CertificateEnrollmentEnrollStatus.getDefault(),
                                                                                "300dc77d-c6ae-4c8d-89f8-427fddde3506",
                                                                                new Date(1557969573539L));
        assertTrue(certificateenrollment.isValid());
    }

    /**
     * Tests the equals method.
     */
    @SuppressWarnings("resource")
    @Test
    public void testEquals() {
        try {
            CertificateEnrollment certificateenrollment1 = new CertificateEnrollment("J-].l.", new Date(1557969573783L),
                                                                                     "0470a240-7b9d-4598-9bcf-471e1d0adf96",
                                                                                     CertificateEnrollmentEnrollResult.getDefault(),
                                                                                     "3f3ff2fc-b491-42c1-a95f-e0bc3c93b2ca",
                                                                                     CertificateEnrollmentEnrollStatus.getDefault(),
                                                                                     "9a2d3525-33fe-42cd-b5e5-90320f708c55",
                                                                                     new Date(1557969570999L));
            CertificateEnrollment certificateenrollment2 = new CertificateEnrollment("J-].l.", new Date(1557969573783L),
                                                                                     "0470a240-7b9d-4598-9bcf-471e1d0adf96",
                                                                                     CertificateEnrollmentEnrollResult.getDefault(),
                                                                                     "3f3ff2fc-b491-42c1-a95f-e0bc3c93b2ca",
                                                                                     CertificateEnrollmentEnrollStatus.getDefault(),
                                                                                     "9a2d3525-33fe-42cd-b5e5-90320f708c55",
                                                                                     new Date(1557969570999L));
            CertificateEnrollment certificateenrollment3 = new CertificateEnrollment("J-].l.", new Date(1557969575682L),
                                                                                     "faf9d323-d715-41eb-a28a-6b6cb5f703e7",
                                                                                     CertificateEnrollmentEnrollResult.getDefault(),
                                                                                     "da3e3457-f38c-4522-b5ad-a5fd1c379017",
                                                                                     CertificateEnrollmentEnrollStatus.getDefault(),
                                                                                     "90f705c2-eb5e-4117-8963-94e7606b0f8d",
                                                                                     new Date(1557969575961L));
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
