// This file was generated by the Pelion SDK foundation code generator.
// This unit test suite was autogenerated on Fri Jan 11 00:36:38 GMT 2019. Feel free to change its contents as you wish.
package com.arm.mbed.cloud.sdk.security.model;

import static org.junit.Assert.*;

import org.junit.Test;

/**
 * Unit tests for Model CertificateIssuerDao.
 */
public class TestCertificateIssuerDao {
    /**
     * Tests the clone method.
     */
    @Test
    public void testClone() {
        try {
            CertificateIssuerDao certificateissuerdao1 = new CertificateIssuerDao();
            CertificateIssuerDao certificateissuerdao2 = certificateissuerdao1.clone();
            assertNotNull(certificateissuerdao1);
            assertNotNull(certificateissuerdao2);
            assertNotSame(certificateissuerdao2, certificateissuerdao1);
            assertEquals(certificateissuerdao2, certificateissuerdao1);
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
            CertificateIssuerDao certificateissuerdao1 = new CertificateIssuerDao();
            CertificateIssuerDao certificateissuerdao2 = new CertificateIssuerDao();
            assertNotNull(certificateissuerdao1);
            assertNotNull(certificateissuerdao2);
            assertNotSame(certificateissuerdao2, certificateissuerdao1);
            assertEquals(certificateissuerdao2, certificateissuerdao1);
            assertEquals(certificateissuerdao2.hashCode(), certificateissuerdao1.hashCode());
            int hashCode = certificateissuerdao1.hashCode();
            for (int i = 0; i < 5; i++) {
                assertEquals(hashCode, certificateissuerdao1.hashCode());
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
            CertificateIssuerDao certificateissuerdao1 = new CertificateIssuerDao();
            CertificateIssuerDao certificateissuerdao2 = new CertificateIssuerDao();
            assertNotNull(certificateissuerdao1);
            assertNotNull(certificateissuerdao2);
            assertNotSame(certificateissuerdao2, certificateissuerdao1);
            assertEquals(certificateissuerdao2, certificateissuerdao1);
            assertEquals(certificateissuerdao2, certificateissuerdao1);
            assertEquals(certificateissuerdao1, certificateissuerdao2);
            assertEquals(certificateissuerdao1, certificateissuerdao1);
            assertFalse(certificateissuerdao1.equals(null));
        } catch (Exception exception) {
            fail(exception.getMessage());
        }
    }
}
