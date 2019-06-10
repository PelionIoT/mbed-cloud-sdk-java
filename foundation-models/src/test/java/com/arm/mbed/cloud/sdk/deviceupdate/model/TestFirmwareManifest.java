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
            FirmwareManifest firmwaremanifest1 = new FirmwareManifest(new Date(1560172166731L), 8,
                                                                      "fd250043-0af8-4bf9-8815-706a213288ad",
                                                                      "8cddbc5b-ad57-45ba-96df-5379122ea232",
                                                                      "57f4927c-25a7-4a33-9f31-2c6b9e569ac5",
                                                                      "9c314901-3fdf-4686-b8b1-bc58f0faa290",
                                                                      "dba62cb8-5d5c-4089-9b93-f5856aa55db8",
                                                                      "1d9c9983-5d26-44db-a2b1-232c2830ae0f",
                                                                      new Date(1560172162748L),
                                                                      new Date(1560172166555L));
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
            FirmwareManifest firmwaremanifest1 = new FirmwareManifest(new Date(1560172166549L), -93,
                                                                      "deb39cd3-3515-4da4-b154-75ad4f56dd20",
                                                                      "ddc412a2-e5c6-443c-93f1-4c3cd568a3ba",
                                                                      "543b0258-3bcb-41e9-a064-b377f4d30efe",
                                                                      "70e06842-d421-4d98-a53a-c7c9571883bd",
                                                                      "dd6827ad-1a1e-4d9b-a5cc-b78dc374ad36",
                                                                      "02eb6bca-2df4-4d1d-8cc0-1048dc83cc31",
                                                                      new Date(1560172160869L),
                                                                      new Date(1560172167338L));
            FirmwareManifest firmwaremanifest2 = new FirmwareManifest(new Date(1560172166549L), -93,
                                                                      "deb39cd3-3515-4da4-b154-75ad4f56dd20",
                                                                      "ddc412a2-e5c6-443c-93f1-4c3cd568a3ba",
                                                                      "543b0258-3bcb-41e9-a064-b377f4d30efe",
                                                                      "70e06842-d421-4d98-a53a-c7c9571883bd",
                                                                      "dd6827ad-1a1e-4d9b-a5cc-b78dc374ad36",
                                                                      "02eb6bca-2df4-4d1d-8cc0-1048dc83cc31",
                                                                      new Date(1560172160869L),
                                                                      new Date(1560172167338L));
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
        FirmwareManifest firmwaremanifest = new FirmwareManifest(new Date(1560172169560L), -116,
                                                                 "7ce59bc1-70a8-43fe-bbb4-6f371cd5f565",
                                                                 "fd2e8ed3-a9cc-40e0-a9d7-32b65e9c40a8",
                                                                 "b71318d3-dd03-4bf1-a8a0-64d9c4b211ea",
                                                                 "d76e892f-21c4-47fd-9609-3c76a7177cac",
                                                                 "f806cf49-58d6-48ac-a8a6-5ea6ed8fa09f",
                                                                 "f6cf5523-aa9d-4fe1-b7c3-66695baf7d6a",
                                                                 new Date(1560172162967L), new Date(1560172165334L));
        assertTrue(firmwaremanifest.isValid());
        FirmwareManifest firmwaremanifestInvalid = new FirmwareManifest(new Date(1560172163508L), 73,
                                                                        "c7a93765-ba48-4260-abb9-d5ecb403f30b",
                                                                        "49e737d6-9272-4d3e-8025-468f1fe9409e62ae8b2e-4bb0-4ffe-85ee-4923cadba00331e7c415-dcd1-440e-ad51-567bc4b11db205d4d7b0-a1c1-464b-a979-cc96b7858d90ae43ec83-712d-4c1d-8343-e8ee302cc1fc71c024eb-4299-4d2f-bcf8-709e3d8c66739c75d1aa-03c8-4f43-981c-08e7fef225d22baabb3a-f167-433d-bba6-49f78a063c09c7d70c58-be49-4e7e-9a44-dad836d94c9be076c371-f1dc-4cb7-82cc-3c7a913b59c196515e19-fe1e-485b-99e9-a1cae1840218b19040bd-9449-456a-aed2-0db816e2da4da9494a3f-5a11-4bb9-b086-14276d723b9300f402ef-a91b-4322-96b3-d89f0a8045d497b1bd08-64f6-47ab-bd04-52b14db8974f0c531e71-a3a9-47f0-a04e-b1002b4f7f6c604e28f5-b67d-4c91-82af-073825107ea72dab31ca-338b-45aa-b71f-97a0a3004a129a26b253-3c84-4a53-a6d3-3c152312df1d190f6052-6df6-4be9-999c-ecaf1d9cc2ee5d836d10-4c93-4fb7-9d2d-b88c994176e54faf5211-e6b4-40a1-8924-4ace7d49ee0bc08d4972-25d8-47e2-bae4-5ac1ae3f1aa317630a0c-e3b8-42cc-aabf-4ec458daa29c27de54cf-f85b-4cb5-945f-d3750fe8441aa0fb43ba-e83a-4fa6-8da2-be49008c998f735e0df2-5490-4cac-92aa-4d6e2a686d8cf035873c-9cab-44df-8008-a08170337376345a1ae4-9bbd-4ece-8b2e-39154c539b865f13556b-f748-4aaf-8523-24dfe1a927c8bdc177cd-86b8-4f65-b9c5-1b5b678c5d2e9aceb51b-ebf0-44cf-a589-b2848bdc96aa6bb351e7-002f-404f-99bd-d15a098d3fa1fa0e9cef-f6f8-4651-9fc2-9e1bb73b529050569da9-7005-41ef-9649-524803aebceefa7ba7c2-1b17-45d3-b6d2-f242d1754d376da869ab-ba59-42d5-823e-df410efc880e46e6cf26-4e99-467c-85ff-a7ed277dc432698ef003-adfb-42a6-81fa-ff64302cc22858a932c4-1ed2-4588-bc9b-cfd3b3c11b4be57e60fd-2e7b-4a83-99ca-1e598929c78920fc9463-2cf2-4bc7-831a-02fcc6821a2b66a6cc5d-0d17-4902-9b5c-2e9737ee9d90c022632f-9b84-49aa-8d7f-0033968c18fc118b0197-73bd-401a-b0ec-0d9ca09d8ce178d9a774-7976-42e0-9fa1-c933be7f41ef7a710558-a548-4c74-9b42-13b4575378d426d6141e-8a1c-4a64-8e6a-1ec86208ca909d45bcfc-cae6-4fc0-bd09-6917ad34b8f2b2689c35-bf20-4efc-92f0-d625d2250473b9f607d7-41ae-4045-9a4e-f66d8b552e79d5248cac-84fa-4302-b67e-9ddb8834ec7ebb43eafb-6d98-427f-99bc-051ff925dbb47f39912e-caae-4ba8-86df-5b3e58d20e51abeac304-ab6d-491d-907e-d367c822d4e9b4ab36dc-2964-4ace-aee1-174ddfa14f0b",
                                                                        "538e383f-19f5-46a9-96d7-bafb812bc96f",
                                                                        "5d380ffd-7642-4447-ab84-be965c546ce6",
                                                                        "d8b105e5-ec0e-499d-bf32-d3d52f90e9ca",
                                                                        "40f65c38-ca66-4f7f-a598-9e5b7764a87d33123af5-86a7-4579-92bf-fb6cb2ec32539ed9db10-5a0f-4b09-8b7e-f18f34b5f3d73cbfc70b-df48-4ff4-bfa6-afb3392a07b1",
                                                                        new Date(1560172170042L),
                                                                        new Date(1560172166336L));
        assertFalse(firmwaremanifestInvalid.isValid());
    }

    /**
     * Tests the equals method.
     */
    @SuppressWarnings("resource")
    @Test
    public void testEquals() {
        try {
            FirmwareManifest firmwaremanifest1 = new FirmwareManifest(new Date(1560172164578L), -96,
                                                                      "54f33223-c3fd-496c-bad4-0236968ecfb4",
                                                                      "7bd316d8-704f-4a1b-8276-fed99fd840fb",
                                                                      "652346d8-d0ca-4552-b0de-cccc8ef41e4f",
                                                                      "3efe7cfb-b7f3-4176-91e0-b57f36819b54",
                                                                      "6c1ce241-1a00-41ba-a981-813a0f143a8f",
                                                                      "98fdc06e-6ad5-468d-b464-86617b8e5b9f",
                                                                      new Date(1560172161116L),
                                                                      new Date(1560172164672L));
            FirmwareManifest firmwaremanifest2 = new FirmwareManifest(new Date(1560172164578L), -96,
                                                                      "54f33223-c3fd-496c-bad4-0236968ecfb4",
                                                                      "7bd316d8-704f-4a1b-8276-fed99fd840fb",
                                                                      "652346d8-d0ca-4552-b0de-cccc8ef41e4f",
                                                                      "3efe7cfb-b7f3-4176-91e0-b57f36819b54",
                                                                      "6c1ce241-1a00-41ba-a981-813a0f143a8f",
                                                                      "98fdc06e-6ad5-468d-b464-86617b8e5b9f",
                                                                      new Date(1560172161116L),
                                                                      new Date(1560172164672L));
            FirmwareManifest firmwaremanifest3 = new FirmwareManifest(new Date(1560172170499L), -120,
                                                                      "d2ecabe2-384e-4c1f-a53f-56028bb3c631",
                                                                      "47c0e1d4-72ab-423d-ab45-4ff2c042bb2b",
                                                                      "938b01ac-6182-4f36-9de0-fe958a6bfae8",
                                                                      "a8539d99-021c-4523-9071-efe83ba5fe2b",
                                                                      "e8269121-7870-4c22-9dd6-ead4e895599d",
                                                                      "261b7a21-236c-4537-b522-9303a3aba6d1",
                                                                      new Date(1560172167533L),
                                                                      new Date(1560172163848L));
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
