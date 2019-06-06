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
            FirmwareManifest firmwaremanifest1 = new FirmwareManifest(new Date(1559835558575L), 3,
                                                                      "3e6a5288-2b6f-4ee6-a9e2-b7b5c64aaf4f",
                                                                      "f4401ce0-9db8-45c6-8fb1-ed420e7af5bc",
                                                                      "c6ad1bc9-637d-4767-8bc2-aace35c471cd",
                                                                      "ff9806b6-2596-4705-82bb-d0d2844c628e",
                                                                      "2719f669-1ef4-4355-bade-232d7a0e8c87",
                                                                      "f23ed385-8eb0-4925-b1ff-ddf534e6f3a0",
                                                                      new Date(1559835559278L),
                                                                      new Date(1559835556965L));
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
            FirmwareManifest firmwaremanifest1 = new FirmwareManifest(new Date(1559835554855L), 125,
                                                                      "42223489-da21-4625-a367-86ec12a8330d",
                                                                      "12fe6bba-7f6d-4fbb-9f44-2971f9f3771d",
                                                                      "838ccf49-e284-4356-a60e-b52b78e8c4c0",
                                                                      "b6ce070a-ae8d-42e9-b47c-a69f999fbeaf",
                                                                      "ca0a4066-1fc6-4e35-806f-d89cb90fde5d",
                                                                      "d974dc55-92a4-4cda-9109-95c133a0f9f3",
                                                                      new Date(1559835558639L),
                                                                      new Date(1559835557519L));
            FirmwareManifest firmwaremanifest2 = new FirmwareManifest(new Date(1559835554855L), 125,
                                                                      "42223489-da21-4625-a367-86ec12a8330d",
                                                                      "12fe6bba-7f6d-4fbb-9f44-2971f9f3771d",
                                                                      "838ccf49-e284-4356-a60e-b52b78e8c4c0",
                                                                      "b6ce070a-ae8d-42e9-b47c-a69f999fbeaf",
                                                                      "ca0a4066-1fc6-4e35-806f-d89cb90fde5d",
                                                                      "d974dc55-92a4-4cda-9109-95c133a0f9f3",
                                                                      new Date(1559835558639L),
                                                                      new Date(1559835557519L));
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
        FirmwareManifest firmwaremanifest = new FirmwareManifest(new Date(1559835551739L), 92,
                                                                 "7be12eca-14ab-46c6-88c3-d7389bad1169",
                                                                 "4c4d7c74-c806-4798-a44d-e675753bd65a",
                                                                 "b4e0259b-b3e4-4f1e-88d2-6b606cd3418e",
                                                                 "d4214edc-b5ca-45ed-b2e7-578f6cc18615",
                                                                 "5557bfc4-59f4-47d7-825f-a353ccb94039",
                                                                 "77e7c213-f8bd-41b5-a988-11ee43725455",
                                                                 new Date(1559835558605L), new Date(1559835559934L));
        assertTrue(firmwaremanifest.isValid());
        FirmwareManifest firmwaremanifestInvalid = new FirmwareManifest(new Date(1559835559139L), 68,
                                                                        "f4ceb754-fa0e-40b2-b04a-d4ea63d455f9",
                                                                        "b90e468c-6e67-40a7-b3cc-5f6ada5c37305287f84c-0b2f-4fd7-bb7c-d6bded1c79e86fa16065-b8bc-4189-b29b-42c215915ecae3a0541f-13b3-424b-9334-40fbbc05986056144a7c-b6da-4423-a955-38f45e603daf6126bce7-1828-4a6e-94aa-53478c1c3f7ccde087d5-67bd-4709-88a4-32ce4f657c4f3c845e33-10ce-4666-8090-55b5a746662535aca000-9bca-46e7-bff1-7de9f9bb6c3f5781129d-819e-4f5f-9335-2f456d40b50a2c23135b-681e-4791-800e-2697f159bec99417ddc6-a6d4-49d2-9eba-476757572f14618fad3b-b516-41a2-a3fb-e2e6c1839f12fb0c09ab-9647-4a9d-a29d-09559df17db1b9eef78f-ec71-4663-83b6-2259af4ab1c00e796166-d775-40e7-93b2-be4bef88f2fd92e04a03-ae6e-4979-8bd9-1af4a43b0fc71682e8c3-477f-4d7a-bdc1-07e3eb84eae7f3153f00-cc4d-4c1c-844d-632ac09769fccb7dd6f7-5f40-4c8f-a04d-d444d9c138cd860f7fee-3cd0-41ce-b920-b3f85825c468679893c5-07c5-4a51-b611-a51fbca4cc20c9bc4d15-c975-4293-83ee-67966417c3376b847a10-829a-4aa9-a33f-6443a08d32850f1ae2b3-468d-4185-837c-d5c7b14167fbd00987d5-0ebb-4b5e-b122-5e72593b64d795bd5ef2-ddd4-4f95-ac79-82d0f82acd70bcdcf1f0-27bd-419a-b372-af5d257d0f0551ba4690-74a7-4b19-aea2-6ef6ee2c595b30883b1e-acf7-43b4-a0d3-a1acdda988f8d09f36fa-eda8-4d8f-895b-2d187ac25ebf15a4ad1d-ae20-43aa-ac71-11bf686d7072f51e336b-82ab-4194-9409-ed2d2c79aa419d3e4643-70df-48b4-90a1-f5147b540a9a9347ebbd-682d-4b37-8c35-1c76b187e2202f0d595b-9c55-4c5a-ae71-52ed2551ce59184e98a3-2d3e-4f73-b0a2-11ede2b4433f6d7b370f-8baa-40c5-bdbe-6329a9fa88e908161489-42d8-4d00-82fe-2a76ff942e5972666660-3d56-4c36-b2c3-cd1017bf3bd67e7cdad8-1c57-4ac3-b50b-44279750cb1b2b52cca5-b9a3-4930-97dc-c96be047055769b1064a-af3a-434d-8a2e-42e1659577f61de035e0-3725-4a3d-8126-9b147a326d15b86c3a11-3614-4558-8289-82c5ee7645b5db777886-0874-4ef5-971e-e7282bb0d6969dc21d73-51d1-43f1-bdef-f42ab97eaf80dc59c5f9-2f55-4621-abc0-6c12360e294d77ee6f35-5d62-463c-a073-979f30ee056d335ff4f0-242d-4985-aad9-165cd85b578935fd5901-1337-4f19-924e-d970d7dcb2c291fdefbd-f82a-420f-8b66-f572df224c9f2351379a-4710-4875-9db1-b2fec5bcd27e8a356e95-c6bf-4249-8f47-17513ad5c21d71e6395c-eba2-4a38-aa20-b21daca9e7e898875a7a-4b71-4451-9116-0ee2ee59e300",
                                                                        "6b064d2e-2be2-4a94-807d-912664f656a3",
                                                                        "a8a03973-3eb9-49f2-a77c-8a73cab4abb3",
                                                                        "4dca14aa-5547-4ade-ad88-0d9342db445a",
                                                                        "8ee3a10e-800f-40bd-a086-57ae4df2c13460d7a449-6347-49d2-ba18-ac48a5bb104c83441208-0827-425d-b74c-40d729222196763255ef-8ff9-46bf-af78-0cebd8c8afab",
                                                                        new Date(1559835557118L),
                                                                        new Date(1559835555837L));
        assertFalse(firmwaremanifestInvalid.isValid());
    }

    /**
     * Tests the equals method.
     */
    @SuppressWarnings("resource")
    @Test
    public void testEquals() {
        try {
            FirmwareManifest firmwaremanifest1 = new FirmwareManifest(new Date(1559835560454L), -126,
                                                                      "ef53793f-f544-4b77-8c55-1559db2187cf",
                                                                      "8eef2d19-c605-408a-92fb-2208e9d95008",
                                                                      "b56e0535-e7ae-4ea3-b2ca-187ebcf3c743",
                                                                      "24a6f56b-b41a-46c7-bdf7-dcb002be0d45",
                                                                      "edb833a2-d5c9-4e39-a670-8976b7d4369d",
                                                                      "7e0b54d9-323e-4321-80bf-07ecb515124f",
                                                                      new Date(1559835559382L),
                                                                      new Date(1559835551580L));
            FirmwareManifest firmwaremanifest2 = new FirmwareManifest(new Date(1559835560454L), -126,
                                                                      "ef53793f-f544-4b77-8c55-1559db2187cf",
                                                                      "8eef2d19-c605-408a-92fb-2208e9d95008",
                                                                      "b56e0535-e7ae-4ea3-b2ca-187ebcf3c743",
                                                                      "24a6f56b-b41a-46c7-bdf7-dcb002be0d45",
                                                                      "edb833a2-d5c9-4e39-a670-8976b7d4369d",
                                                                      "7e0b54d9-323e-4321-80bf-07ecb515124f",
                                                                      new Date(1559835559382L),
                                                                      new Date(1559835551580L));
            FirmwareManifest firmwaremanifest3 = new FirmwareManifest(new Date(1559835560565L), -86,
                                                                      "beef62c4-fc83-4983-a1fa-91ca32c4b659",
                                                                      "c3960336-3066-47ca-8d07-7a5f9ceadbaf",
                                                                      "718bf944-3039-4636-b53b-30bc6a10fda6",
                                                                      "a5bf7832-a8f6-4dda-b3a0-7fca2e90c203",
                                                                      "1ba34d15-b86f-42cd-9bbe-c9ac2d2e7837",
                                                                      "9a7579d0-c932-4c23-85bc-9608d1775d72",
                                                                      new Date(1559835559185L),
                                                                      new Date(1559835555654L));
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
