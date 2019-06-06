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
            DeveloperCertificate developercertificate1 = new DeveloperCertificate("d9f95c4a-0135-4729-8812-9c469c7a68f7",
                                                                                  "29e56e4b-7179-4221-be48-4dfe6e294507",
                                                                                  new Date(1559833685237L),
                                                                                  "af49ab0e-bba6-4098-b9bc-fabe5fa02e27",
                                                                                  "7ab64d05-d923-42ad-a6df-f825deae5188",
                                                                                  "d152ad2a-7fa6-4027-b240-319b284bce13",
                                                                                  "2d17f89b-7c15-4d62-8cd3-8d733a1ce3f0",
                                                                                  "f40e7920-146d-4667-85ea-471f789600ce");
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
            DeveloperCertificate developercertificate1 = new DeveloperCertificate("874b42ef-19f9-4f05-bd50-f0fc1c8d7681",
                                                                                  "256a25d9-b85e-4706-b5c2-3a0346d3466b",
                                                                                  new Date(1559833686935L),
                                                                                  "7d487f54-224f-46ac-bf0d-45b1842bc10a",
                                                                                  "cc63964f-39c7-4735-89cd-3b827e71c374",
                                                                                  "52396448-9a6b-4033-ab44-6f55b79af919",
                                                                                  "3b18901a-456c-46d1-9bca-57103e771b97",
                                                                                  "dec39f57-fc69-4b95-a879-0790ef0d76db");
            DeveloperCertificate developercertificate2 = new DeveloperCertificate("874b42ef-19f9-4f05-bd50-f0fc1c8d7681",
                                                                                  "256a25d9-b85e-4706-b5c2-3a0346d3466b",
                                                                                  new Date(1559833686935L),
                                                                                  "7d487f54-224f-46ac-bf0d-45b1842bc10a",
                                                                                  "cc63964f-39c7-4735-89cd-3b827e71c374",
                                                                                  "52396448-9a6b-4033-ab44-6f55b79af919",
                                                                                  "3b18901a-456c-46d1-9bca-57103e771b97",
                                                                                  "dec39f57-fc69-4b95-a879-0790ef0d76db");
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
        DeveloperCertificate developercertificate = new DeveloperCertificate("b3428e85-e790-492f-a652-2316982127c9",
                                                                             "cb3346fa-d1db-43ad-8b2a-036f76385d7b",
                                                                             new Date(1559833683403L),
                                                                             "ed25fbba-434c-45ba-95c5-c2fd4e5d4405",
                                                                             "accaa076-ae3c-46eb-8cf2-e1305420db63",
                                                                             "a909eeea-9337-4223-a6a2-e1fd1e659eee",
                                                                             "d59c2eca-2637-4bae-a4bf-47927f4d623b",
                                                                             "d3117e2b-d136-4fc0-ab12-25fa6e6d9be4");
        assertTrue(developercertificate.isValid());
        DeveloperCertificate developercertificateInvalid = new DeveloperCertificate("edfa4ff1-78bd-40f5-9b24-b4692a29efb1",
                                                                                    "314f54bd-32ec-41a3-b779-9ec88487c559",
                                                                                    new Date(1559833678023L),
                                                                                    "c55cb609-793e-4f63-97ba-be26d3f6933f",
                                                                                    "908f41b3-c5cb-4f4c-b0c1-e9db67248cdb",
                                                                                    "e8950a72-59e5-4288-ab24-8b72a5c2bcac",
                                                                                    null,
                                                                                    "088ae239-48cc-4c67-bb32-35b7523bc99a");
        assertFalse(developercertificateInvalid.isValid());
    }

    /**
     * Tests the equals method.
     */
    @SuppressWarnings("resource")
    @Test
    public void testEquals() {
        try {
            DeveloperCertificate developercertificate1 = new DeveloperCertificate("982d78d6-cbb4-4464-a8f7-bae06ea50e74",
                                                                                  "4d9b8a6d-1eb1-49b0-aea9-599cb6206f07",
                                                                                  new Date(1559833684298L),
                                                                                  "4f04f919-0bca-4b1d-9bbe-fc5a8201a656",
                                                                                  "ae1ce62c-724d-475f-8d93-827dcc6c72db",
                                                                                  "0c96477e-10f6-4b35-a80f-16be3eac706c",
                                                                                  "bc63c5fd-27da-4e46-be82-5102d4b7f13e",
                                                                                  "8a38a7c8-3d16-4718-9cfd-319bfe5b7bb1");
            DeveloperCertificate developercertificate2 = new DeveloperCertificate("982d78d6-cbb4-4464-a8f7-bae06ea50e74",
                                                                                  "4d9b8a6d-1eb1-49b0-aea9-599cb6206f07",
                                                                                  new Date(1559833684298L),
                                                                                  "4f04f919-0bca-4b1d-9bbe-fc5a8201a656",
                                                                                  "ae1ce62c-724d-475f-8d93-827dcc6c72db",
                                                                                  "0c96477e-10f6-4b35-a80f-16be3eac706c",
                                                                                  "bc63c5fd-27da-4e46-be82-5102d4b7f13e",
                                                                                  "8a38a7c8-3d16-4718-9cfd-319bfe5b7bb1");
            DeveloperCertificate developercertificate3 = new DeveloperCertificate("463eff43-e4f6-42cb-ac76-39393ab0bb1a",
                                                                                  "9b55b31d-3cdb-49eb-9d9f-c100acb70857",
                                                                                  new Date(1559833683030L),
                                                                                  "8db359cb-8f6f-42be-a54f-9b99eba67dfc",
                                                                                  "73ac898e-bbf4-4352-aa9a-517540b19c96",
                                                                                  "d8e3458c-e9f9-4af9-b75d-7144218c069d",
                                                                                  "39142762-000c-4ba5-a95f-f01796bd91df",
                                                                                  "9f43b9e7-a71e-4534-bb37-8da7dd466abd");
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
