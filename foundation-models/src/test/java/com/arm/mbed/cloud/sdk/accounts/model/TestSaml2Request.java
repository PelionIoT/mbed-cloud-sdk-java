// This file was generated by the Pelion SDK foundation code generator.
// This is an autogenerated unit test class. Do not modify its content as modifications will be lost at next code generation.
package com.arm.mbed.cloud.sdk.accounts.model;

import static org.junit.Assert.*;

import org.junit.Test;

/**
 * Unit tests for Model Saml2Request.
 */
@SuppressWarnings("PMD.AvoidDuplicateLiterals")
public class TestSaml2Request {
    /**
     * Tests the clone method.
     */
    @SuppressWarnings("resource")
    @Test
    public void testClone() {
        try {
            Saml2Request saml2request1 = new Saml2Request(null, "ae476336-ce77-46d1-8451-2a3db1c83c62", null,
                                                          "737df7d1-0798-4a5b-9fb1-d421533b5f6b",
                                                          "7d4faa9c-d16a-4082-a98f-6dcdd7dcb227",
                                                          "c277bb36-14c9-4cee-90cc-901982675921");
            Saml2Request saml2request2 = saml2request1.clone();
            assertNotNull(saml2request1);
            assertNotNull(saml2request2);
            assertNotSame(saml2request2, saml2request1);
            assertEquals(saml2request2, saml2request1);
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
            Saml2Request saml2request1 = new Saml2Request(null, "4d4c3c3e-ee5d-4734-9fd7-1f90b5be28bb", null,
                                                          "29a9abaa-ec47-437b-8f4e-6fb608ea9060",
                                                          "d78c8bac-9a6a-4659-9028-7c3a89d4f704",
                                                          "de19fe1a-c02a-48b0-92e5-483afd895c8b");
            Saml2Request saml2request2 = new Saml2Request(null, "4d4c3c3e-ee5d-4734-9fd7-1f90b5be28bb", null,
                                                          "29a9abaa-ec47-437b-8f4e-6fb608ea9060",
                                                          "d78c8bac-9a6a-4659-9028-7c3a89d4f704",
                                                          "de19fe1a-c02a-48b0-92e5-483afd895c8b");
            assertNotNull(saml2request1);
            assertNotNull(saml2request2);
            assertNotSame(saml2request2, saml2request1);
            assertEquals(saml2request2, saml2request1);
            assertEquals(saml2request2.hashCode(), saml2request1.hashCode());
            int hashCode = saml2request1.hashCode();
            for (int i = 0; i < 5; i++) {
                assertEquals(hashCode, saml2request1.hashCode());
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
        Saml2Request saml2request = new Saml2Request(null, "15a72f73-3ee4-40e5-894c-e132457a2fa2", null,
                                                     "395511c9-27e7-4e3d-b716-bc2112344428",
                                                     "205b65bc-8c5f-42fd-bbdc-ae7aa81b98c0",
                                                     "45eef544-c889-4c60-9c6b-f408ba26c924");
        assertTrue(saml2request.isValid());
    }

    /**
     * Tests the equals method.
     */
    @SuppressWarnings("resource")
    @Test
    public void testEquals() {
        try {
            Saml2Request saml2request1 = new Saml2Request(null, "1d6bce09-7bd5-476a-8333-4659db71e0d9", null,
                                                          "6a786515-234f-425b-ab42-567b6559225c",
                                                          "2cdf3c7b-2cfd-43b4-8940-5504c7f9a9bc",
                                                          "152e4b09-63d9-4cc3-b057-167a4adf6501");
            Saml2Request saml2request2 = new Saml2Request(null, "1d6bce09-7bd5-476a-8333-4659db71e0d9", null,
                                                          "6a786515-234f-425b-ab42-567b6559225c",
                                                          "2cdf3c7b-2cfd-43b4-8940-5504c7f9a9bc",
                                                          "152e4b09-63d9-4cc3-b057-167a4adf6501");
            Saml2Request saml2request3 = new Saml2Request(null, "de2e0335-7823-4615-ba2e-6b68e50c53e2", null,
                                                          "d219b5da-6869-4eaa-b5c8-1177d353dbcf",
                                                          "00c98f5e-4d0e-4447-9443-d69a83980481",
                                                          "addfe1f8-c9d9-4198-b732-6f79e3f56bd6");
            assertNotNull(saml2request1);
            assertNotNull(saml2request2);
            assertNotNull(saml2request3);
            assertNotSame(saml2request2, saml2request1);
            assertNotSame(saml2request3, saml2request1);
            assertEquals(saml2request2, saml2request1);
            assertEquals(saml2request2, saml2request1);
            assertEquals(saml2request1, saml2request2);
            assertEquals(saml2request1, saml2request1);
            assertFalse(saml2request1.equals(null));
            assertNotEquals(saml2request3, saml2request1);
        } catch (Exception exception) {
            fail(exception.getMessage());
        }
    }
}
