// This file was generated by the Pelion SDK foundation code generator.
// This is an autogenerated unit test class. Do not modify its content as modifications will be lost at next code generation.
package com.arm.mbed.cloud.sdk.security.model;

import static org.junit.Assert.*;

import java.util.Date;
import org.junit.Test;

/**
 * Unit tests for Model CertificateIssuerConfig.
 */
@SuppressWarnings("PMD.AvoidDuplicateLiterals")
public class TestCertificateIssuerConfig {
    /**
     * Tests the clone method.
     */
    @SuppressWarnings("resource")
    @Test
    public void testClone() {
        try {
            CertificateIssuerConfig certificateissuerconfig1 = new CertificateIssuerConfig("25df7dc1-9c53-4ace-8c16-83acfa3b6d85",
                                                                                           new Date(1559148833985L),
                                                                                           "05e9f85e-8232-4d94-bb85-9b223b4843d9",
                                                                                           "14a6d281-0401-4864-a39c-0ea771f03096",
                                                                                           new Date(1559148825836L));
            CertificateIssuerConfig certificateissuerconfig2 = certificateissuerconfig1.clone();
            assertNotNull(certificateissuerconfig1);
            assertNotNull(certificateissuerconfig2);
            assertNotSame(certificateissuerconfig2, certificateissuerconfig1);
            assertEquals(certificateissuerconfig2, certificateissuerconfig1);
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
            CertificateIssuerConfig certificateissuerconfig1 = new CertificateIssuerConfig("45309030-c955-4518-94c1-f98b4c8d5a42",
                                                                                           new Date(1559148831518L),
                                                                                           "ef7b359a-67b6-4253-8324-fc565a1ac0f2",
                                                                                           "044f9d74-59be-49fb-9c63-eaa088a8bd3e",
                                                                                           new Date(1559148827566L));
            CertificateIssuerConfig certificateissuerconfig2 = new CertificateIssuerConfig("45309030-c955-4518-94c1-f98b4c8d5a42",
                                                                                           new Date(1559148831518L),
                                                                                           "ef7b359a-67b6-4253-8324-fc565a1ac0f2",
                                                                                           "044f9d74-59be-49fb-9c63-eaa088a8bd3e",
                                                                                           new Date(1559148827566L));
            assertNotNull(certificateissuerconfig1);
            assertNotNull(certificateissuerconfig2);
            assertNotSame(certificateissuerconfig2, certificateissuerconfig1);
            assertEquals(certificateissuerconfig2, certificateissuerconfig1);
            assertEquals(certificateissuerconfig2.hashCode(), certificateissuerconfig1.hashCode());
            int hashCode = certificateissuerconfig1.hashCode();
            for (int i = 0; i < 5; i++) {
                assertEquals(hashCode, certificateissuerconfig1.hashCode());
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
        CertificateIssuerConfig certificateissuerconfig = new CertificateIssuerConfig("e0dc951e-29af-4cec-8c1b-2e5797f5cb69",
                                                                                      new Date(1559148825954L),
                                                                                      "8e299b00-a35b-49f8-a58e-84ae3fbf9b6b",
                                                                                      "7d65daec-40fd-43ff-9627-f0d9436a8c47",
                                                                                      new Date(1559148831631L));
        assertTrue(certificateissuerconfig.isValid());
        CertificateIssuerConfig certificateissuerconfigInvalid = new CertificateIssuerConfig(null,
                                                                                             new Date(1559148828631L),
                                                                                             "8ec7dd52-29af-40cb-9d40-a7c45ef1aebb",
                                                                                             null,
                                                                                             new Date(1559148825690L));
        assertFalse(certificateissuerconfigInvalid.isValid());
    }

    /**
     * Tests the equals method.
     */
    @SuppressWarnings("resource")
    @Test
    public void testEquals() {
        try {
            CertificateIssuerConfig certificateissuerconfig1 = new CertificateIssuerConfig("06445b9b-6269-4291-b355-9af35b254e22",
                                                                                           new Date(1559148829265L),
                                                                                           "77c92059-16ed-4414-860c-fd729261765d",
                                                                                           "32b41b6d-54a6-4c02-be63-08af759f0bf2",
                                                                                           new Date(1559148826758L));
            CertificateIssuerConfig certificateissuerconfig2 = new CertificateIssuerConfig("06445b9b-6269-4291-b355-9af35b254e22",
                                                                                           new Date(1559148829265L),
                                                                                           "77c92059-16ed-4414-860c-fd729261765d",
                                                                                           "32b41b6d-54a6-4c02-be63-08af759f0bf2",
                                                                                           new Date(1559148826758L));
            CertificateIssuerConfig certificateissuerconfig3 = new CertificateIssuerConfig("1a31fc08-7e49-4c20-9271-56e018f5ff9b",
                                                                                           new Date(1559148832118L),
                                                                                           "6d99275a-8160-4467-be50-6b54a1e6cacb",
                                                                                           "1cdb0292-cd26-4b64-91fd-46294d6634dd",
                                                                                           new Date(1559148835150L));
            assertNotNull(certificateissuerconfig1);
            assertNotNull(certificateissuerconfig2);
            assertNotNull(certificateissuerconfig3);
            assertNotSame(certificateissuerconfig2, certificateissuerconfig1);
            assertNotSame(certificateissuerconfig3, certificateissuerconfig1);
            assertEquals(certificateissuerconfig2, certificateissuerconfig1);
            assertEquals(certificateissuerconfig2, certificateissuerconfig1);
            assertEquals(certificateissuerconfig1, certificateissuerconfig2);
            assertEquals(certificateissuerconfig1, certificateissuerconfig1);
            assertFalse(certificateissuerconfig1.equals(null));
            assertNotEquals(certificateissuerconfig3, certificateissuerconfig1);
        } catch (Exception exception) {
            fail(exception.getMessage());
        }
    }
}
