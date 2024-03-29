// This file was generated by the Pelion SDK foundation code generator.
// This is an autogenerated unit test class. Do not modify its content as modifications will be lost at next code generation.
package com.arm.mbed.cloud.sdk.devices.model;

import static org.junit.Assert.*;

import java.util.Date;
import org.junit.Test;

/**
 * Unit tests for Model DeviceGroup.
 */
@SuppressWarnings("PMD.AvoidDuplicateLiterals")
public class TestDeviceGroup {
    /**
     * Tests the clone method.
     */
    @SuppressWarnings("resource")
    @Test
    public void testClone() {
        try {
            DeviceGroup devicegroup1 = new DeviceGroup(new Date(1574704668895L), null,
                                                       "851db5bb-26b1-4b9e-9c6c-a65b987e376f", 120,
                                                       "a3373cd1-a8a7-4af3-ab35-b7ac7326f415",
                                                       "6789c9c9-83ae-453a-876c-1442d230ee44",
                                                       new Date(1574704670125L));
            DeviceGroup devicegroup2 = devicegroup1.clone();
            assertNotNull(devicegroup1);
            assertNotNull(devicegroup2);
            assertNotSame(devicegroup2, devicegroup1);
            assertEquals(devicegroup2, devicegroup1);
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
            DeviceGroup devicegroup1 = new DeviceGroup(new Date(1574704668283L), null,
                                                       "4db51915-7dcd-473d-af63-3221bca2eb0f", 71,
                                                       "fdb01eff-5111-43eb-8191-4bac0bcb1215",
                                                       "ccc88ad0-c9f3-4007-8ead-ee4b73cf31bd",
                                                       new Date(1574704665146L));
            DeviceGroup devicegroup2 = new DeviceGroup(new Date(1574704668283L), null,
                                                       "4db51915-7dcd-473d-af63-3221bca2eb0f", 71,
                                                       "fdb01eff-5111-43eb-8191-4bac0bcb1215",
                                                       "ccc88ad0-c9f3-4007-8ead-ee4b73cf31bd",
                                                       new Date(1574704665146L));
            assertNotNull(devicegroup1);
            assertNotNull(devicegroup2);
            assertNotSame(devicegroup2, devicegroup1);
            assertEquals(devicegroup2, devicegroup1);
            assertEquals(devicegroup2.hashCode(), devicegroup1.hashCode());
            int hashCode = devicegroup1.hashCode();
            for (int i = 0; i < 5; i++) {
                assertEquals(hashCode, devicegroup1.hashCode());
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
        DeviceGroup devicegroup = new DeviceGroup(new Date(1574704669071L), null,
                                                  "2380bbe0-3620-4c80-ab36-f0588c10b7e3", 109,
                                                  "bc7d6484-e40a-445f-ad1a-350e33b264d6",
                                                  "56641472-8dd9-4a25-939e-020b6f422cbe", new Date(1574704670185L));
        assertTrue(devicegroup.isValid());
        DeviceGroup devicegroupInvalid = new DeviceGroup(new Date(1574704667895L), null,
                                                         "35bbfc35-67d5-4b75-ac61-50e5f3aaf847003ec29b-cdc3-47a1-a680-2577f9ad23165c2daa0d-1829-4bee-9a05-78f3fe1f0490b2cd700c-809a-4011-b79c-50ed1346b7c51bad78a1-b691-4fba-8019-edb163fce944b39d577a-3b2a-41c2-8742-476f156790a43c304659-e70f-426b-9b5e-5e495cf8c7a97f162f8d-3ad3-42c3-bb92-982b96c0885cac92335c-b4e9-4df7-841e-6ca0dd5528409a2e5338-3a29-4c5c-b74b-4d15d358e80d2c3819bf-b2ed-4e93-a9e7-a5ed4541197e60bd708e-cd66-4082-ac0f-3f9b8c81ff77e1e60a54-47d1-4da6-8fd2-d0ab38f0af76dc3918b4-dcba-42bc-80e2-9a061ab9ee39663c880a-f476-4c25-96dc-0e6918c76bca3ccbf66d-125b-4dab-81eb-7286e7f7303b60bfc041-4111-4c03-9cd7-4eac43032e8aa5c8128c-b793-4bf0-9ab7-84d14169f052947bab40-8a1b-4667-b71b-8dcba56812865e77c1be-0614-4b46-9c01-b554627c245827ce5934-c56b-4a5f-aca9-1311838724b39cec2d99-7897-4466-8c75-01eee615393f2f5ab5e4-9e0b-4720-8294-58c8fb73c11de1991de1-9162-41f0-8713-9c0201b46bc0f3472cce-2dc9-4c7f-afb8-f229b551cdc594f9e623-2b56-4d7d-987b-b7584362c65d2dbd90e4-4170-40e5-8bab-a461af22bfd59f1b2324-91bc-40a6-a117-0622b3f05d115e8e583e-045c-40dd-b153-5a92cdeaacfbada43946-7f28-4994-89d9-05a0b359865d98392280-76bf-491a-b88b-47c01fda601cc9af6a40-50ea-44ba-bafb-ed7ddd1998a0c19575ed-06a1-48ca-843a-bdec178ff641e67d54e4-cb5c-43c2-9b52-4119c4c5a836a270f938-42b7-4514-9006-f90e4853e21ea37a67a9-bb1d-46e3-a0ea-918dc1e08780993dd5d0-09e2-4f47-a4c5-d1d54c65ebef2e1bf6eb-791a-4651-8534-10ad7ef6ddb439b4a2fc-3184-42bb-8871-0b1f382e7c9ee458a8ef-b2ec-4f8e-9ca5-13b27c3a463a35f6c1a9-df8c-46f2-9495-a0dfff96deba6f1f6f1a-cb75-4bf8-a3c9-a5e191cd438fa887960d-efbe-48a7-8e66-128b6289b435a7263efd-030d-4193-b7ec-e42fdf9686f3faaf139c-3bfe-407b-974a-96152578c477b7b25d17-ed6d-4213-aa75-a3b6996da95561ccc801-19ae-4c2d-8732-d18b652c3098847ccb2f-19e9-44e0-8cc4-80957433fbbcf35921ca-9af6-4998-9987-741867e363efd90693ec-1dc3-42d6-becd-fa65f7383e404f20e21a-dddc-4848-bb0e-8d26e2ed970ac87fc20f-812f-4f24-8207-cda37995bc354dcf2aec-d901-4f6d-809c-2749538d111e5495bbf7-340c-4639-8344-910263dd8538f28e6d41-3248-4380-a977-77593775ea3d82f7b006-bc86-4e83-ab1a-128b1d5931d2",
                                                         -73, "fa6de627-be16-4aae-9f4c-cdded274c3f3",
                                                         "1fc222f9-4203-49ca-8752-4e104f4096222e55af85-ffac-4037-b866-a82aa1b7c459e42ee0c4-549c-480d-8251-8bfcce907f8b2122c9a0-74b0-45a9-8cf3-04a216f10969",
                                                         new Date(1574704662632L));
        assertFalse(devicegroupInvalid.isValid());
    }

    /**
     * Tests the equals method.
     */
    @SuppressWarnings("resource")
    @Test
    public void testEquals() {
        try {
            DeviceGroup devicegroup1 = new DeviceGroup(new Date(1574704661516L), null,
                                                       "1347600a-585c-46cc-a017-d883973892c8", 32,
                                                       "77bd7be3-a0ed-42aa-852a-51c23f619e08",
                                                       "d52ee516-c8f4-4d04-9578-cb4fb6107129",
                                                       new Date(1574704668414L));
            DeviceGroup devicegroup2 = new DeviceGroup(new Date(1574704661516L), null,
                                                       "1347600a-585c-46cc-a017-d883973892c8", 32,
                                                       "77bd7be3-a0ed-42aa-852a-51c23f619e08",
                                                       "d52ee516-c8f4-4d04-9578-cb4fb6107129",
                                                       new Date(1574704668414L));
            DeviceGroup devicegroup3 = new DeviceGroup(new Date(1574704670000L), null,
                                                       "56545a5e-0a6c-4636-b22f-97b4091a8d3a", -28,
                                                       "1fc466ae-d82d-4b7d-a287-60ea89567f7e",
                                                       "b1dbf620-f2e2-4f47-8a8d-199222c1c256",
                                                       new Date(1574704669531L));
            assertNotNull(devicegroup1);
            assertNotNull(devicegroup2);
            assertNotNull(devicegroup3);
            assertNotSame(devicegroup2, devicegroup1);
            assertNotSame(devicegroup3, devicegroup1);
            assertEquals(devicegroup2, devicegroup1);
            assertEquals(devicegroup2, devicegroup1);
            assertEquals(devicegroup1, devicegroup2);
            assertEquals(devicegroup1, devicegroup1);
            assertFalse(devicegroup1.equals(null));
            assertNotEquals(devicegroup3, devicegroup1);
        } catch (Exception exception) {
            fail(exception.getMessage());
        }
    }
}
