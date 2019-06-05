// This file was generated by the Pelion SDK foundation code generator.
// This is an autogenerated unit test class. Do not modify its content as modifications will be lost at next code generation.
package com.arm.mbed.cloud.sdk.deviceupdate.model;

import static org.junit.Assert.*;

import java.util.Date;
import org.junit.Test;

/**
 * Unit tests for Model FirmwareManifest.
 */
@SuppressWarnings("PMD.AvoidDuplicateLiterals")
public class TestFirmwareManifest {
    /**
     * Tests the clone method.
     */
    @SuppressWarnings("resource")
    @Test
    public void testClone() {
        try {
            FirmwareManifest firmwaremanifest1 = new FirmwareManifest(new Date(1559746946619L), 23,
                                                                      "deaeabec-0baf-426b-bc03-d1a9d1b9934c",
                                                                      "ef97be70-45f0-4c6c-a0da-eacc9a145aef",
                                                                      "b7fa7900-9cf6-4bac-953d-b93994313914",
                                                                      "ecc94851-88cc-49d8-b8a2-9cebfa2640f2",
                                                                      "57fd928f-e0f9-4e2f-aa7f-b60c99606a9c",
                                                                      "2d39e241-90ed-4f42-b88b-f8b195e9fcb9",
                                                                      new Date(1559746951838L),
                                                                      new Date(1559746954317L));
            FirmwareManifest firmwaremanifest2 = firmwaremanifest1.clone();
            assertNotNull(firmwaremanifest1);
            assertNotNull(firmwaremanifest2);
            assertNotSame(firmwaremanifest2, firmwaremanifest1);
            assertEquals(firmwaremanifest2, firmwaremanifest1);
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
            FirmwareManifest firmwaremanifest1 = new FirmwareManifest(new Date(1559746954967L), 40,
                                                                      "1a7309e5-2068-4152-83ed-631398cc73a7",
                                                                      "9a738873-a4bb-4e43-8237-581778d45ea7",
                                                                      "12a42622-40a2-4400-9e78-25384675354b",
                                                                      "a3813202-371e-4f96-a09e-62ecfb95a8a3",
                                                                      "44523d17-ce9c-4b01-9eea-fcbf3f7e9063",
                                                                      "5f7e4c7a-4d62-4f76-a5bc-f3b760873401",
                                                                      new Date(1559746955046L),
                                                                      new Date(1559746949435L));
            FirmwareManifest firmwaremanifest2 = new FirmwareManifest(new Date(1559746954967L), 40,
                                                                      "1a7309e5-2068-4152-83ed-631398cc73a7",
                                                                      "9a738873-a4bb-4e43-8237-581778d45ea7",
                                                                      "12a42622-40a2-4400-9e78-25384675354b",
                                                                      "a3813202-371e-4f96-a09e-62ecfb95a8a3",
                                                                      "44523d17-ce9c-4b01-9eea-fcbf3f7e9063",
                                                                      "5f7e4c7a-4d62-4f76-a5bc-f3b760873401",
                                                                      new Date(1559746955046L),
                                                                      new Date(1559746949435L));
            assertNotNull(firmwaremanifest1);
            assertNotNull(firmwaremanifest2);
            assertNotSame(firmwaremanifest2, firmwaremanifest1);
            assertEquals(firmwaremanifest2, firmwaremanifest1);
            assertEquals(firmwaremanifest2.hashCode(), firmwaremanifest1.hashCode());
            int hashCode = firmwaremanifest1.hashCode();
            for (int i = 0; i < 5; i++) {
                assertEquals(hashCode, firmwaremanifest1.hashCode());
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
        FirmwareManifest firmwaremanifest = new FirmwareManifest(new Date(1559746947865L), -88,
                                                                 "8028101e-ae62-429a-9111-66d08bfaaded",
                                                                 "c6db86a3-36a9-4055-abb2-2a11d7009aa3",
                                                                 "bb51b044-14db-43c0-a521-16cc9006cf23",
                                                                 "7def4dda-6918-42a7-946d-26d6194a5518",
                                                                 "702cd12b-43da-4241-b238-551260e692bd",
                                                                 "700322e4-2083-49d2-9091-a7af733b24b2",
                                                                 new Date(1559746948978L), new Date(1559746946391L));
        assertTrue(firmwaremanifest.isValid());
        FirmwareManifest firmwaremanifestInvalid = new FirmwareManifest(new Date(1559746946713L), -51,
                                                                        "80cc69ee-aa86-4d2c-864a-5a66efbdd2de",
                                                                        "c77dc30e-cbe2-4219-8581-adb7300c645bef1da5a3-e07c-4381-8dd1-fdd8d8f679685c2a50f0-6381-4acc-ad3e-2c1e3184788655c59f48-5ca6-40c7-8b01-973869817731e85ed879-c982-4176-b186-8397fb97fddae6ce636a-c7e6-4494-8353-e553a9d06b0cf81f88d8-57b3-414f-9f07-cb14dd47db0ab5ae98ba-6ce2-47d9-b46c-1db34020df90d9453317-e156-455f-a0d3-afbf6caeae7a3fc9d29f-b1d3-48b7-aa0e-ece974c10f79be26d0de-c071-40bf-b0fc-e7c8437f2e15daa91d3e-2757-4846-bf34-1f295d93fb51f37958e2-dd00-4ef7-8630-9639affbdaf2f255cdc2-5afc-4fbc-ba9a-e4ac29942cb94e8b5271-1eb8-4f84-8669-14c12472df8439891eec-6774-40da-90c7-6e0ae6957de740ad09d8-cfa7-409e-bc8f-f48d85b752637aae2073-4901-4a10-a4e1-e6a8570164ce73fccac7-8794-4aef-802a-c4e838c3324b2ce8b7b5-2633-428a-a9ba-60251d665960396e1ea8-1de3-4f7f-995f-0112fa2cdb948f06f456-8d8f-4bc8-8026-562f2c0c8b383550a984-9cab-4cdf-9fc9-1d654eaf4578983ed119-7257-43c3-8b5d-a80d18ec81fc9036f59f-be0f-4efc-8bc7-24280e0f6494a9463586-d471-4006-b72a-6c0f6f2e2c8ac24e66ae-1dfe-4551-8fd7-91fc3631071c6c1423bd-4d94-49e2-8907-496ea1805a814e83e063-4301-4e65-a551-a2b1f904847328938c45-8c14-4105-8589-7ad0e0371015c93ed9ae-6896-459d-852c-e99bcf8fe688048c24e1-566a-4732-8a54-3281932113537f741a7d-50d6-43eb-a8df-a91c32bdb0dbb82363b1-91e7-4c95-869d-5773c16029af6d15bf02-0145-44d4-8a6c-78b7cc129cf7c533f8a6-fc94-4741-a1ab-830255fa8635ffc7416d-6fda-4b9f-834a-dbda740c92896a9534ae-a6e5-470b-894a-6187481828bea79da0e5-cc47-4302-9c1b-9cf729603e685ddcc5cc-575b-40ca-bc5c-83015e1557ba9f28a77e-0d00-41d6-aed5-cf1287fb41325963bae0-308f-4943-9eda-d63062142d938e15e597-5f60-440f-afdc-027a7e6089d1a04c18b1-4d34-40d3-a4ee-226410a5a7dc76c309f8-c491-4faf-9f71-698d7243ef490e264fdc-c39b-49dd-ac3b-8f5001fc8427fff83b65-6f86-4cd5-9a54-e61ca9aa279ba64e534e-44f0-4fa1-afe4-857cf8cd8a6aba62bbbc-0d06-4978-a767-7f7257fb62845e6e3aac-8c20-41c6-bc1b-0ea90c8683c32746148c-c39f-4507-87f9-5582bebceeee03c81a51-d47a-416b-ad3a-e257d132754d54d60d39-db0b-4574-aeee-a310241498a506ca1111-12d1-4c6c-813f-2cb0bd579981b395a3a2-ef48-47ea-a541-6557162ccb6553cc6ca9-5430-4db6-9428-63b1e4111527",
                                                                        "80c2e7f3-457d-4114-a1a0-7d93ae6b6bac",
                                                                        "f7bd5b68-001a-45e8-9684-4b960c1a91a0",
                                                                        "e253bebb-3168-45b0-a018-ddf98031bf8b",
                                                                        "64956725-a7c2-4e02-b23a-926f67f2e214127fdb69-369c-482a-b179-9c417c9aac16054e3420-96ea-485e-95da-50eb4c51c405fa8451c6-f421-484f-9927-f1d322cb05c4",
                                                                        new Date(1559746946613L),
                                                                        new Date(1559746954295L));
        assertFalse(firmwaremanifestInvalid.isValid());
    }

    /**
     * Tests the equals method.
     */
    @SuppressWarnings("resource")
    @Test
    public void testEquals() {
        try {
            FirmwareManifest firmwaremanifest1 = new FirmwareManifest(new Date(1559746947042L), -33,
                                                                      "4f7713b9-4b93-47fc-8ad5-b8b46836bd65",
                                                                      "0212a312-091f-4930-b010-14cca05e8ef1",
                                                                      "f6b26521-2cae-4c05-a171-66f2e3e96e0b",
                                                                      "f96038bb-75d2-47ea-9e4b-2df3fc689a6e",
                                                                      "bd2552bf-4314-40cf-984d-3013c54b4636",
                                                                      "dae9b462-15f3-486f-b059-2f954ba89f43",
                                                                      new Date(1559746951559L),
                                                                      new Date(1559746952600L));
            FirmwareManifest firmwaremanifest2 = new FirmwareManifest(new Date(1559746947042L), -33,
                                                                      "4f7713b9-4b93-47fc-8ad5-b8b46836bd65",
                                                                      "0212a312-091f-4930-b010-14cca05e8ef1",
                                                                      "f6b26521-2cae-4c05-a171-66f2e3e96e0b",
                                                                      "f96038bb-75d2-47ea-9e4b-2df3fc689a6e",
                                                                      "bd2552bf-4314-40cf-984d-3013c54b4636",
                                                                      "dae9b462-15f3-486f-b059-2f954ba89f43",
                                                                      new Date(1559746951559L),
                                                                      new Date(1559746952600L));
            FirmwareManifest firmwaremanifest3 = new FirmwareManifest(new Date(1559746954490L), -41,
                                                                      "de168f77-1a3a-4181-87c6-b24feed71790",
                                                                      "46b1136b-6c38-4fc5-b4fb-4e7cda9d0e8b",
                                                                      "9bfb2f49-e030-4a3e-8037-2c665c450d48",
                                                                      "b63b48c8-b115-4359-af7a-d128ffcaa040",
                                                                      "cfa44325-940d-424a-b350-9ea5d473248a",
                                                                      "20145f06-f7c5-4e66-99f2-5ea1869e14dd",
                                                                      new Date(1559746946496L),
                                                                      new Date(1559746952740L));
            assertNotNull(firmwaremanifest1);
            assertNotNull(firmwaremanifest2);
            assertNotNull(firmwaremanifest3);
            assertNotSame(firmwaremanifest2, firmwaremanifest1);
            assertNotSame(firmwaremanifest3, firmwaremanifest1);
            assertEquals(firmwaremanifest2, firmwaremanifest1);
            assertEquals(firmwaremanifest2, firmwaremanifest1);
            assertEquals(firmwaremanifest1, firmwaremanifest2);
            assertEquals(firmwaremanifest1, firmwaremanifest1);
            assertFalse(firmwaremanifest1.equals(null));
            assertNotEquals(firmwaremanifest3, firmwaremanifest1);
        } catch (Exception exception) {
            fail(exception.getMessage());
        }
    }
}
