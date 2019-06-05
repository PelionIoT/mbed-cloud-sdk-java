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
            DeveloperCertificate developercertificate1 = new DeveloperCertificate("bc20ccbf-aa8b-4827-9379-904e7da0fd4c",
                                                                                  "540ff4a1-311a-4e97-9725-dbdc6b728b1b",
                                                                                  new Date(1559745301861L),
                                                                                  "15dcef65-7a18-4b99-8abb-35ad401d71ae",
                                                                                  "28168061-91b5-49ac-b56a-0892851b70bf",
                                                                                  "60610c44-f2f1-4739-81df-1be4d5d18e56",
                                                                                  "f1a907eb-2906-4f0d-a686-0815e2132c4c",
                                                                                  "e5cda0ce-8edc-4b2a-9404-3ce5cf8168ec");
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
            DeveloperCertificate developercertificate1 = new DeveloperCertificate("34a5fce6-1e25-4b82-a3ce-cbcc87602a08",
                                                                                  "f54b353e-253e-4360-b5c4-3a47d8c1a0af",
                                                                                  new Date(1559745298565L),
                                                                                  "d1efb836-2836-465b-9df4-612966959055",
                                                                                  "2f6873f4-46fb-42ec-bb6d-9a2161279c9a",
                                                                                  "632d638d-c5bc-472a-927c-bebc0e92fd6f",
                                                                                  "c3254a53-5a36-448d-a48a-dd4dfdd543fb",
                                                                                  "c66e2e49-d0d1-4800-941b-f128f04a3b17");
            DeveloperCertificate developercertificate2 = new DeveloperCertificate("34a5fce6-1e25-4b82-a3ce-cbcc87602a08",
                                                                                  "f54b353e-253e-4360-b5c4-3a47d8c1a0af",
                                                                                  new Date(1559745298565L),
                                                                                  "d1efb836-2836-465b-9df4-612966959055",
                                                                                  "2f6873f4-46fb-42ec-bb6d-9a2161279c9a",
                                                                                  "632d638d-c5bc-472a-927c-bebc0e92fd6f",
                                                                                  "c3254a53-5a36-448d-a48a-dd4dfdd543fb",
                                                                                  "c66e2e49-d0d1-4800-941b-f128f04a3b17");
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
        DeveloperCertificate developercertificate = new DeveloperCertificate("f9d9c028-36c4-4ce0-b55d-30e746366d1b",
                                                                             "a10e597a-5cd9-4a66-8d12-17cf22f44394",
                                                                             new Date(1559745300776L),
                                                                             "6c055d30-57f2-4ab9-bc23-bca23573f9e2",
                                                                             "99c8fbc5-a170-4cf9-8814-d3e4474afced",
                                                                             "8f3a635e-4612-4d6d-a8a1-bd4fc038890d",
                                                                             "7500c4e7-eca7-4396-9222-3afd11dd3fc7",
                                                                             "b62ec4c4-fa29-403a-8905-c037bfd612fb");
        assertTrue(developercertificate.isValid());
        DeveloperCertificate developercertificateInvalid = new DeveloperCertificate("b5ff0437-096f-463d-bb31-1e770cb606e8",
                                                                                    "e3433394-8628-4a8a-add4-233f6f1ade24",
                                                                                    new Date(1559745294301L),
                                                                                    "3a85d0d6-6e40-4337-a56d-b167708cc95b",
                                                                                    "045b9017-37be-4744-9fdb-9ed32c4e5613",
                                                                                    "21dc79c5-8812-4563-b229-af41ef956c49",
                                                                                    null,
                                                                                    "291dfd2a-53fe-4c93-9308-d54d2d8fafa7");
        assertFalse(developercertificateInvalid.isValid());
    }

    /**
     * Tests the equals method.
     */
    @SuppressWarnings("resource")
    @Test
    public void testEquals() {
        try {
            DeveloperCertificate developercertificate1 = new DeveloperCertificate("44bfcc1e-6d94-4dd9-968a-34fe21942cc7",
                                                                                  "ba81b562-826d-4fb5-bc90-e7997eb960d5",
                                                                                  new Date(1559745295855L),
                                                                                  "1ef8de1a-ec18-47b4-9b23-c0b5ab798643",
                                                                                  "04c6dc91-dd6c-4ad5-9556-26d4b0bd6cb3",
                                                                                  "70449385-785f-4d12-ab55-9ba50ae28ff3",
                                                                                  "5fd3f97c-59d5-4fcc-b60a-22f03af7aedb",
                                                                                  "c40ee50c-d789-43ee-8c0d-432d056db29f");
            DeveloperCertificate developercertificate2 = new DeveloperCertificate("44bfcc1e-6d94-4dd9-968a-34fe21942cc7",
                                                                                  "ba81b562-826d-4fb5-bc90-e7997eb960d5",
                                                                                  new Date(1559745295855L),
                                                                                  "1ef8de1a-ec18-47b4-9b23-c0b5ab798643",
                                                                                  "04c6dc91-dd6c-4ad5-9556-26d4b0bd6cb3",
                                                                                  "70449385-785f-4d12-ab55-9ba50ae28ff3",
                                                                                  "5fd3f97c-59d5-4fcc-b60a-22f03af7aedb",
                                                                                  "c40ee50c-d789-43ee-8c0d-432d056db29f");
            DeveloperCertificate developercertificate3 = new DeveloperCertificate("eded5c58-7b98-4330-9580-de3f82fcd533",
                                                                                  "57cdd51b-5f55-4367-b786-a973f74fd1c7",
                                                                                  new Date(1559745298025L),
                                                                                  "bb5997b1-da62-45a9-ab5e-8b2d9213079d",
                                                                                  "7d0cfaf6-10fc-4d17-945d-80f8ac2f806b",
                                                                                  "a687bb3d-e71e-441d-9b59-6b7d1dcf37f7",
                                                                                  "7ede01ff-cc55-4b40-b884-6c39b220a1a1",
                                                                                  "d9616c6c-9d3b-44df-b902-5e8cf0cdebe7");
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
