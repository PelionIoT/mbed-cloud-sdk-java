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
            FirmwareManifest firmwaremanifest1 = new FirmwareManifest(new Date(1559833681217L), -91,
                                                                      "43a266b9-c09f-44dd-a223-6fd2794a712f",
                                                                      "20ca56c2-91a9-4094-b207-38c3db79fc1a",
                                                                      "cf0d6ed2-b985-42f8-812c-4be2bb505047",
                                                                      "67c68992-2004-4e16-9514-2eda94717b72",
                                                                      "399735bd-1279-47f6-8373-911b37d01526",
                                                                      "f8a37213-f520-44ee-8460-65ec96d854c3",
                                                                      new Date(1559833677301L),
                                                                      new Date(1559833682525L));
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
            FirmwareManifest firmwaremanifest1 = new FirmwareManifest(new Date(1559833686551L), 102,
                                                                      "da35ab3b-9848-49ee-8bed-4c81b6fbcb12",
                                                                      "59383cd0-1608-49a3-9cdd-986f7bad251b",
                                                                      "f323b15f-cc25-4c62-8194-68d93e2b8f14",
                                                                      "08139ece-4211-4310-a3a6-f7d22a7f3949",
                                                                      "f757c7be-90a1-4768-ace8-7dd3df0bd896",
                                                                      "042c3304-3b30-4bd7-9f8b-9d79432b5df4",
                                                                      new Date(1559833677747L),
                                                                      new Date(1559833683320L));
            FirmwareManifest firmwaremanifest2 = new FirmwareManifest(new Date(1559833686551L), 102,
                                                                      "da35ab3b-9848-49ee-8bed-4c81b6fbcb12",
                                                                      "59383cd0-1608-49a3-9cdd-986f7bad251b",
                                                                      "f323b15f-cc25-4c62-8194-68d93e2b8f14",
                                                                      "08139ece-4211-4310-a3a6-f7d22a7f3949",
                                                                      "f757c7be-90a1-4768-ace8-7dd3df0bd896",
                                                                      "042c3304-3b30-4bd7-9f8b-9d79432b5df4",
                                                                      new Date(1559833677747L),
                                                                      new Date(1559833683320L));
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
        FirmwareManifest firmwaremanifest = new FirmwareManifest(new Date(1559833682708L), -16,
                                                                 "dcbe6259-a68c-43e1-96d4-44379d40f97f",
                                                                 "636a4c17-2b62-484e-bc28-4b1727111b33",
                                                                 "49b62bf2-a682-4c51-a216-6cbc991971b5",
                                                                 "48156ec3-bd62-4f6b-86ae-7e23ce21061f",
                                                                 "2a575f1e-7e22-463e-842b-229353d8edaa",
                                                                 "67481ddb-e062-422f-b5b9-d9cd964a97aa",
                                                                 new Date(1559833677187L), new Date(1559833680848L));
        assertTrue(firmwaremanifest.isValid());
        FirmwareManifest firmwaremanifestInvalid = new FirmwareManifest(new Date(1559833685708L), -9,
                                                                        "c53c1ef4-92cd-4dc7-bc7b-e070df385313",
                                                                        "6034cfbd-74ba-4e0c-8d49-24fe2dbd85867edff0e9-4c4f-4587-875f-2e0c3e6b1dfa94078dcd-7f6b-4e8f-bb90-aded8b9fb86eb4ada5ea-64ec-459d-88e6-9c102886013c0ff3c759-c1dc-44d7-89db-fbadb68ad455dc084cde-b8f4-4e97-891b-4208c82391da849c0310-8712-485e-a0fb-1f95fe875f7f6fed6fb9-2688-4f78-8aa2-575cfd1a476e6b1bf68a-5471-46d4-ad68-eb6f74570f7e9dd61f2e-bf31-4c52-a398-bf367980b59baeae98ec-135d-48e4-bb03-e64865f09d3ac3ba7080-7373-4112-8dbf-9104f54e0abba9352320-3042-48a4-89c9-917b4ff9492eb6821b6f-f23f-41a0-80e0-2f386b8b39fd619098c8-c0c9-46ab-8ddc-fb8604e65ec78272f02b-459c-4341-bcbd-060810b2ade46a255255-ecd3-47d1-baa5-fab99dea4f9187003f03-e088-42d2-ae4e-ed79c1c15632c1c6871e-2876-41f4-80ca-04e9336cfb7b80ab6da1-c847-4fd1-9dc0-21833c4b5f23e8b6a6f1-ab43-456e-aa4e-8d13e6782b17ac79993e-66e8-4fa4-b84b-936326f81a0f1e398479-831d-433c-84d7-81b4f5df7552ffdda67f-84fd-4193-817e-877d23e28751bb8a6b6e-10b4-4166-af6d-344344b27292ff877d13-a434-4072-b7eb-bd17b5f0de6d66890305-be93-443c-9820-eebb6d9434200009054c-8f9c-4b75-86bd-eb9e3f05d9d03789e0c2-6b65-48ad-b564-ba839f7a59f58d6d9fe7-3ef0-4fef-97d1-51bd07a9b4c0559bd745-24a4-4137-b651-e348928846372ad14d01-ccc2-4656-a7c4-9614b7c7f41e54b5ffc5-e7af-403d-9318-f1b760fb2d0ac03927de-6742-4654-afee-e79265e52747ec363e66-3450-48a0-83a3-7dc14b73cb66cccb9eef-ddd8-4210-b54c-b7461ca5644dc79a7b35-3072-48ac-a661-468a0ba064317bb6e537-445b-4209-b0e0-c00fa63d29f59714f375-467a-49bc-a0a5-4d9e6ef35c290cb208eb-6b44-49e7-909a-7b5e951deb1e405de4b6-e9a8-4163-a139-8a2f6cca84e6cd206819-7563-431b-a2ae-f3753dbbe1fa884d3bdf-6dd3-41d0-b699-887e08062c81cde68015-f6dd-4b99-887a-6598970fc1cf459325a8-c9a8-43e9-b0ea-18dc8b8bb5cdfde32706-0cc0-436e-ab1e-99dfad0b20f6d370e279-ee4a-4fa2-ab0d-5e1d7e45fa4661456d56-a16d-4d1e-b0be-29f4c16e74e0984ec6a5-4411-4b19-a375-2d162c152f410a3525f9-8653-4043-8700-2556fcfb8bbcbd0d0205-d2b2-49ff-a3fc-49b6b6a7fc4d6b1922be-69a7-4c0a-95a4-d1c5535b606c6ff54cc7-1d1e-480d-8604-8a9b827e72f639f301f1-86c7-4a04-859b-728c5f85d13b7282cce3-65a3-4d69-a931-f3345d9db339d330a15c-53f7-4401-909d-d3af2bd97524",
                                                                        "863a6ba6-0177-46d5-9be0-9568637dcc24",
                                                                        "8a94c79b-8d55-4506-937e-b54f24366dc3",
                                                                        "9e6033b0-319e-4046-b532-8278109e529e",
                                                                        "746d2c65-eea7-4a47-aa0b-698480e000d69cf5afde-fe49-4093-b4d6-2f5e032c2f1073d4826f-c921-4eb5-b3fb-872494987bd82969c748-bde6-4256-abbb-cde8c20facf3",
                                                                        new Date(1559833683249L),
                                                                        new Date(1559833681554L));
        assertFalse(firmwaremanifestInvalid.isValid());
    }

    /**
     * Tests the equals method.
     */
    @SuppressWarnings("resource")
    @Test
    public void testEquals() {
        try {
            FirmwareManifest firmwaremanifest1 = new FirmwareManifest(new Date(1559833679483L), -16,
                                                                      "78258f36-146f-4825-ba60-dae037fcd211",
                                                                      "8da17d1f-d723-46d1-826f-ba2f0c0ec1ac",
                                                                      "31faa453-54c8-4a16-9d9d-b4c4b65302e4",
                                                                      "f1f50d17-6236-4092-a046-06b71449ec2b",
                                                                      "9ed79e68-46d7-45a5-b25d-7b339262fe7c",
                                                                      "234268ea-f0ac-4f71-951c-6bb9b8fbd228",
                                                                      new Date(1559833678494L),
                                                                      new Date(1559833679065L));
            FirmwareManifest firmwaremanifest2 = new FirmwareManifest(new Date(1559833679483L), -16,
                                                                      "78258f36-146f-4825-ba60-dae037fcd211",
                                                                      "8da17d1f-d723-46d1-826f-ba2f0c0ec1ac",
                                                                      "31faa453-54c8-4a16-9d9d-b4c4b65302e4",
                                                                      "f1f50d17-6236-4092-a046-06b71449ec2b",
                                                                      "9ed79e68-46d7-45a5-b25d-7b339262fe7c",
                                                                      "234268ea-f0ac-4f71-951c-6bb9b8fbd228",
                                                                      new Date(1559833678494L),
                                                                      new Date(1559833679065L));
            FirmwareManifest firmwaremanifest3 = new FirmwareManifest(new Date(1559833680601L), -83,
                                                                      "aa6a9d91-e498-4cd6-b438-004ec914a130",
                                                                      "2eb56aff-8057-4771-b765-fa97319fd5b2",
                                                                      "1bdc2a63-3066-4270-8dee-3958c55c659a",
                                                                      "1132cf2f-2da6-468e-9a3e-620c452d3e16",
                                                                      "ea2fc6e0-1d26-46e9-ba7c-242d29a51c4d",
                                                                      "9357f9f5-4203-4df9-9e00-1e41ebf22237",
                                                                      new Date(1559833680967L),
                                                                      new Date(1559833683885L));
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
