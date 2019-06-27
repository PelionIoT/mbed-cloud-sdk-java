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
            DeveloperCertificate developercertificate1 = new DeveloperCertificate("01f7ac16-6cb5-401c-b115-dc2f6356b5e8",
                                                                                  "6f3b6efc-d7d9-4262-8a57-12e932fdcce7",
                                                                                  new Date(1561632939184L),
                                                                                  "c01b8d96-b85d-4ebe-a3e1-fdc50841bb4a",
                                                                                  "b2e6e18a-b895-490b-84ca-9310bd317753",
                                                                                  "2cf3ab95-0171-49e6-a93b-950cb4d2c710",
                                                                                  "b852ec7c-a779-43cc-8b2b-61551cbdd8d5",
                                                                                  "3ce944f4-c4ff-4ab4-87bd-6e7f8d380b1f");
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
            DeveloperCertificate developercertificate1 = new DeveloperCertificate("8e09dfce-bb43-4795-b6b4-a30b89e61d9d",
                                                                                  "c82e01f2-0cb5-4db7-9707-3cfb701a048e",
                                                                                  new Date(1561632939952L),
                                                                                  "4cfae583-30eb-4bcd-8a1f-61897fdd8557",
                                                                                  "ab22bd16-2101-4622-bf72-8d03a85f0c72",
                                                                                  "c073a8cf-7787-491d-bfff-62097a33b736",
                                                                                  "f55237fc-f44a-4560-9d2b-62b6448012e7",
                                                                                  "854c008e-db17-4e6e-ab08-122815fc30a4");
            DeveloperCertificate developercertificate2 = new DeveloperCertificate("8e09dfce-bb43-4795-b6b4-a30b89e61d9d",
                                                                                  "c82e01f2-0cb5-4db7-9707-3cfb701a048e",
                                                                                  new Date(1561632939952L),
                                                                                  "4cfae583-30eb-4bcd-8a1f-61897fdd8557",
                                                                                  "ab22bd16-2101-4622-bf72-8d03a85f0c72",
                                                                                  "c073a8cf-7787-491d-bfff-62097a33b736",
                                                                                  "f55237fc-f44a-4560-9d2b-62b6448012e7",
                                                                                  "854c008e-db17-4e6e-ab08-122815fc30a4");
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
        DeveloperCertificate developercertificate = new DeveloperCertificate("9227703f-48b5-45e7-b6cb-6ebd92a0278f",
                                                                             "fd15294a-0f6f-4f67-bc03-9b174baf9936",
                                                                             new Date(1561632942156L),
                                                                             "6c41a56f-f1c6-4204-8b23-25cec98c2e61",
                                                                             "798c722e-420f-4b10-94db-e52169c02d05",
                                                                             "c3aa9717-e1e1-45e6-bd07-67d2a4e6750e",
                                                                             "74698bee-db42-4e9a-b0e7-ada48b462cb3",
                                                                             "81284bde-f910-422c-92e5-546e679ecc85");
        assertTrue(developercertificate.isValid());
        DeveloperCertificate developercertificateInvalid = new DeveloperCertificate("e7e9881f-b509-44a2-8aba-3129f0f0ebe9",
                                                                                    "67997641-5004-4412-b4af-0f891361cb6d",
                                                                                    new Date(1561632933024L),
                                                                                    "3373f572-6ecc-484a-b244-bde720b86f34",
                                                                                    "fd05debc-6a31-4762-8ca1-d246054c9449",
                                                                                    "71953db4-6f47-4ca4-bf24-d53cfbfc2b39",
                                                                                    null,
                                                                                    "be5715e8-2692-4822-ba0e-5828434d090e");
        assertFalse(developercertificateInvalid.isValid());
    }

    /**
     * Tests the equals method.
     */
    @SuppressWarnings("resource")
    @Test
    public void testEquals() {
        try {
            DeveloperCertificate developercertificate1 = new DeveloperCertificate("b5940580-5047-462a-a232-964b4e8f1706",
                                                                                  "2c741d5e-a352-4ff5-bf2e-29bb25a50330",
                                                                                  new Date(1561632936762L),
                                                                                  "13beaf48-5eb6-4962-a0ef-cdc11deda0cf",
                                                                                  "2fd429fb-f628-4bc0-b0d3-7b6335bc462f",
                                                                                  "184724f4-862d-47ac-bb9e-66c0a59bb48f",
                                                                                  "f13b44d9-af1b-4863-aa65-83a7d84aceaf",
                                                                                  "acf00dd7-e27a-421f-a4e9-700917d99d52");
            DeveloperCertificate developercertificate2 = new DeveloperCertificate("b5940580-5047-462a-a232-964b4e8f1706",
                                                                                  "2c741d5e-a352-4ff5-bf2e-29bb25a50330",
                                                                                  new Date(1561632936762L),
                                                                                  "13beaf48-5eb6-4962-a0ef-cdc11deda0cf",
                                                                                  "2fd429fb-f628-4bc0-b0d3-7b6335bc462f",
                                                                                  "184724f4-862d-47ac-bb9e-66c0a59bb48f",
                                                                                  "f13b44d9-af1b-4863-aa65-83a7d84aceaf",
                                                                                  "acf00dd7-e27a-421f-a4e9-700917d99d52");
            DeveloperCertificate developercertificate3 = new DeveloperCertificate("cb59dd6e-3b77-44e1-bff3-949312ccfe4d",
                                                                                  "dc20d9cb-efba-4b9f-9dcb-b580198a991c",
                                                                                  new Date(1561632935502L),
                                                                                  "b033f6f1-4b48-42f9-909c-ddc3e075f2e1",
                                                                                  "02cbe606-7a2d-4a85-9ea0-f42f22d5e0cb",
                                                                                  "7ee22e60-c7c8-472b-ac59-a44237e5fd6d",
                                                                                  "3eeb4904-1f65-472a-b7c4-99b0c367e7f6",
                                                                                  "271aa202-9bf0-47cd-af2e-8b7c755106be");
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
