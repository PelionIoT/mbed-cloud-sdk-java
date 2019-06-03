// This file was generated by the Pelion SDK foundation code generator.
// This is an autogenerated unit test class. Do not modify its content as modifications will be lost at next code generation.
package com.arm.mbed.cloud.sdk.security.model;

import static org.junit.Assert.*;

import java.util.Date;
import org.junit.Test;

/**
 * Unit tests for Model DeveloperCertificate.
 */
@SuppressWarnings("PMD.AvoidDuplicateLiterals")
public class TestDeveloperCertificate {
    /**
     * Tests the clone method.
     */
    @SuppressWarnings("resource")
    @Test
    public void testClone() {
        try {
            DeveloperCertificate developercertificate1 = new DeveloperCertificate("5bb8cd06-6196-4f15-9643-f18e07cbc223",
                                                                                  "982659f2-81ee-4eec-80ed-60ec032a69ec",
                                                                                  new Date(1559560667827L),
                                                                                  "72522104-694a-4b9e-8c41-777c248200d6",
                                                                                  "17b4b929-dba5-4bd2-a316-0659e2cbfef9",
                                                                                  "5f278e11-ecb0-444d-bb3f-ee1c0450dd85",
                                                                                  "ed022ed9-a63b-451a-b603-66c50552a6bb",
                                                                                  "dfbc7e46-4073-4bc4-8335-f7fc95dee8a9");
            DeveloperCertificate developercertificate2 = developercertificate1.clone();
            assertNotNull(developercertificate1);
            assertNotNull(developercertificate2);
            assertNotSame(developercertificate2, developercertificate1);
            assertEquals(developercertificate2, developercertificate1);
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
            DeveloperCertificate developercertificate1 = new DeveloperCertificate("2080dfb1-4337-44d4-8774-77cda995340d",
                                                                                  "97082379-4ff4-457b-b6dc-8d8228d10b91",
                                                                                  new Date(1559560666837L),
                                                                                  "3fc40416-970f-4e56-8497-addbc6372dd5",
                                                                                  "44572f58-deb3-4327-a273-16ffe5f34cf8",
                                                                                  "e433e8d2-3a6c-486e-8a6d-42b7d03ada96",
                                                                                  "257c5af7-fc37-4b19-b93c-7a1c894e4289",
                                                                                  "739a4154-d031-46a2-b829-5fe5993c718e");
            DeveloperCertificate developercertificate2 = new DeveloperCertificate("2080dfb1-4337-44d4-8774-77cda995340d",
                                                                                  "97082379-4ff4-457b-b6dc-8d8228d10b91",
                                                                                  new Date(1559560666837L),
                                                                                  "3fc40416-970f-4e56-8497-addbc6372dd5",
                                                                                  "44572f58-deb3-4327-a273-16ffe5f34cf8",
                                                                                  "e433e8d2-3a6c-486e-8a6d-42b7d03ada96",
                                                                                  "257c5af7-fc37-4b19-b93c-7a1c894e4289",
                                                                                  "739a4154-d031-46a2-b829-5fe5993c718e");
            assertNotNull(developercertificate1);
            assertNotNull(developercertificate2);
            assertNotSame(developercertificate2, developercertificate1);
            assertEquals(developercertificate2, developercertificate1);
            assertEquals(developercertificate2.hashCode(), developercertificate1.hashCode());
            int hashCode = developercertificate1.hashCode();
            for (int i = 0; i < 5; i++) {
                assertEquals(hashCode, developercertificate1.hashCode());
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
        DeveloperCertificate developercertificate = new DeveloperCertificate("8b901fb7-ab89-46c0-804e-f28e7ca6dcc7",
                                                                             "ef70f670-8f11-44bf-aae5-1f31dfbde76a",
                                                                             new Date(1559560666657L),
                                                                             "fb0f16b3-8481-4768-9ab5-36b4794b66a5",
                                                                             "7e98a18d-5940-47d4-bc8c-537b494aa981",
                                                                             "9f51621f-bd26-4e77-9bc0-6796f8a9c101",
                                                                             "d4095b2c-23fa-4ebf-a12e-dcba34d90f9e",
                                                                             "4d11d0b8-ede9-4a64-bb50-b112010089f7");
        assertTrue(developercertificate.isValid());
        DeveloperCertificate developercertificateInvalid = new DeveloperCertificate("c2d0d4e6-eafe-4117-831c-f86fd7085a62",
                                                                                    "c7b5dd3d-dc18-4125-ae59-49239a9a397e",
                                                                                    new Date(1559560667415L),
                                                                                    "ae866062-ccde-41ef-8b7c-2bce141f37be",
                                                                                    "ebe27a9d-3e7f-4d99-9d09-2c413a633312",
                                                                                    "4f6759ae-9ced-4e81-8437-240dfc803a5e",
                                                                                    null,
                                                                                    "1e1965c9-eda1-40af-9882-6c2d02f3ce9b");
        assertFalse(developercertificateInvalid.isValid());
    }

    /**
     * Tests the equals method.
     */
    @SuppressWarnings("resource")
    @Test
    public void testEquals() {
        try {
            DeveloperCertificate developercertificate1 = new DeveloperCertificate("f7765b77-f645-419a-b11b-bc90e147d41a",
                                                                                  "cb705c26-1ab8-4dde-ad49-e60d47fdd8db",
                                                                                  new Date(1559560668827L),
                                                                                  "67af1b26-0151-4815-b70c-91c6511af7e2",
                                                                                  "a42f17db-e7b2-4470-b67c-1a61bff6e9fc",
                                                                                  "8ffca91d-862f-420d-84a4-f18ce3a1953d",
                                                                                  "a95f7cbe-9f4e-47da-8894-e712a9789ce6",
                                                                                  "b380376f-e77c-45c6-9ef2-b5ffbecc3808");
            DeveloperCertificate developercertificate2 = new DeveloperCertificate("f7765b77-f645-419a-b11b-bc90e147d41a",
                                                                                  "cb705c26-1ab8-4dde-ad49-e60d47fdd8db",
                                                                                  new Date(1559560668827L),
                                                                                  "67af1b26-0151-4815-b70c-91c6511af7e2",
                                                                                  "a42f17db-e7b2-4470-b67c-1a61bff6e9fc",
                                                                                  "8ffca91d-862f-420d-84a4-f18ce3a1953d",
                                                                                  "a95f7cbe-9f4e-47da-8894-e712a9789ce6",
                                                                                  "b380376f-e77c-45c6-9ef2-b5ffbecc3808");
            DeveloperCertificate developercertificate3 = new DeveloperCertificate("583297cc-b1ca-4bb0-b83a-6f7728071a05",
                                                                                  "ca862d12-465a-495a-8c3d-2b0b0fbc828f",
                                                                                  new Date(1559560668265L),
                                                                                  "7937cdfd-d5fd-47a5-895f-e8dc734482bc",
                                                                                  "89080e27-483b-4257-b4be-309d0e80ea49",
                                                                                  "d8777267-bc8a-443a-8493-2a13c251ed3f",
                                                                                  "c9bd198d-295c-412b-9ef4-6e90550a4e2f",
                                                                                  "e610088b-7d96-458a-a3af-2b30d70705fc");
            assertNotNull(developercertificate1);
            assertNotNull(developercertificate2);
            assertNotNull(developercertificate3);
            assertNotSame(developercertificate2, developercertificate1);
            assertNotSame(developercertificate3, developercertificate1);
            assertEquals(developercertificate2, developercertificate1);
            assertEquals(developercertificate2, developercertificate1);
            assertEquals(developercertificate1, developercertificate2);
            assertEquals(developercertificate1, developercertificate1);
            assertFalse(developercertificate1.equals(null));
            assertNotEquals(developercertificate3, developercertificate1);
        } catch (Exception exception) {
            fail(exception.getMessage());
        }
    }
}
