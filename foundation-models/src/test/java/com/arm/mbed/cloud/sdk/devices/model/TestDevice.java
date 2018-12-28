// This file was generated by the Pelion SDK foundation code generator.
// This is an autogenerated unit test class. Do not modify its content as modifications will be lost at next code generation.
package com.arm.mbed.cloud.sdk.devices.model;

import static org.junit.Assert.*;

import org.junit.Test;

/**
 * Unit tests for Model Device.
 */
public class TestDevice {
    /**
     * Tests the clone method.
     */
    @Test
    public void testClone() {
        Device device1 = new Device("68f471c1-aa9f-4797-95e6-a49d4840289b", true, new java.util.Date(1546027077332L),
                                    new java.util.Date(1546027080709L), "5feaef04-500e-4840-92f9-be9248c3a20b",
                                    new java.util.Date(1546027075246L), new java.util.Date(1546027082161L), null,
                                    com.arm.mbed.cloud.sdk.devices.model.DeviceDeployedState.getDefault(),
                                    "dde07c26-3807-4663-8ea3-89376a3b4fa0", "599dbc2a-c0eb-4b8b-9db4-1f9c89abd113",
                                    "81ff5b3c-9c58-44fb-a5af-ca5cdbd52f29", 85, "6113a3c1-5ec2-44c0-b3e4-18e9f69f9f3f",
                                    "6be20de2-6f0c-4b76-8c97-df2d049b6c97", "1d7ba57e-9127-4c0e-a14e-adf4ae0f0c64",
                                    new java.util.Date(1546027080748L), "814d6c94-4b51-40c9-b9d4-2039c8087402",
                                    "82e5b36e-076a-4e95-af94-55eaa4919aa9", "9933dff9-6976-4947-91ef-0f8d49334715",
                                    "CdCCF7F8dCF8e389d6f151C8fCAa634bcfF2DcdeAb1dfCd04Cf59fe5F7bECEaB",
                                    "dd__fd6_b_2___f777d_b53__276_e0_", "b68e8dc0-ac68-446d-ad2e-eccf09e038eb",
                                    new java.util.Date(1546027074738L), "ebaeaf__92c_5d4_c53f2_b_b4e__7cf",
                                    "a0df79ba-51fa-4ebc-ac13-d14d769e9629", new java.util.Date(1546027080141L),
                                    com.arm.mbed.cloud.sdk.devices.model.DeviceLifecycleStatus.getDefault(),
                                    "d53fad26-d068-43f3-91ae-44712177c76c", new java.util.Date(1546027078219L),
                                    com.arm.mbed.cloud.sdk.devices.model.DeviceMechanism.getDefault(),
                                    "bc6b837c-56b2-48a9-a8c0-ff161a1a149f", "f9313434-9cba-418c-80e2-6cc2e94f8e22",
                                    true, "9cfd069b-34bb-4160-86df-f4d19bdc9c96",
                                    com.arm.mbed.cloud.sdk.devices.model.DeviceState.getDefault(), true,
                                    new java.util.Date(1546027077773L), "b0064e59-a35f-4ee6-b479-50b70bff099a");
        Device device2 = device1.clone();
        assertNotNull(device1);
        assertNotNull(device2);
        assertNotSame(device2, device1);
        assertEquals(device2, device1);
    }

    /**
     * Tests the isValid method.
     */
    @Test
    public void testIsvalid() {
        Device device = new Device("f3911e76-0ffe-4a30-937d-e3d4dd24cf86", true, new java.util.Date(1546027075249L),
                                   new java.util.Date(1546027082226L), "734d6065-4aaa-44a3-8ad4-4a1455294324",
                                   new java.util.Date(1546027077561L), new java.util.Date(1546027073653L), null,
                                   com.arm.mbed.cloud.sdk.devices.model.DeviceDeployedState.getDefault(),
                                   "4ae51e1f-7cec-4bb3-93fc-658105c972fc", "9383b078-6b65-4acc-b8c0-86202970914e",
                                   "09ee41b0-c01c-463d-8292-6b9ffe2c7ee3", 69, "46691c81-4bbc-46c3-9d0b-aa4fd4b5d050",
                                   "967a5d07-099c-4c47-a391-ebca111be1b4", "cb9645ad-7e32-423d-983d-91f2f0b1de39",
                                   new java.util.Date(1546027077762L), "8c2ad074-c3da-4e76-92b8-b9e76a23b011",
                                   "01708e8e-1f0f-4de8-b090-6045f15807cc", "2f297196-a9ed-4a4b-b3d1-b930ce3bfaf7",
                                   "6C1BdCCdfD7EFDdCE2FAcfd2fB9Ad9faEAEe3eb42e1C2b42C55bC8eD7e19fecF",
                                   "__92_3_a5094___4__376de5f_567aac", "96fa8f78-17ba-49c7-a800-5aa1d3e42cd3",
                                   new java.util.Date(1546027079077L), "6e_e3_c_a9e0________7__dea99____",
                                   "88e043c5-f831-4fb2-b4ef-8b359ebeb2eb", new java.util.Date(1546027079372L),
                                   com.arm.mbed.cloud.sdk.devices.model.DeviceLifecycleStatus.getDefault(),
                                   "cb406758-11ff-41c7-93d2-6f66b8c5834f", new java.util.Date(1546027082317L),
                                   com.arm.mbed.cloud.sdk.devices.model.DeviceMechanism.getDefault(),
                                   "8a77d5cb-e8a6-46dd-b1ff-3242a0ece533", "cc4f0b63-0bc7-479c-bdeb-0977c1463464",
                                   false, "28ca077e-e41d-4981-ae42-9ce805545de5",
                                   com.arm.mbed.cloud.sdk.devices.model.DeviceState.getDefault(), false,
                                   new java.util.Date(1546027075332L), "e9b8d744-bd6e-4b1c-a3f5-91bf29cee84d");
        assertTrue(device.isValid());
        Device deviceInvalid = new Device("057a4b45-2814-4929-a182-08fb1fbcad21", false,
                                          new java.util.Date(1546027077600L), new java.util.Date(1546027075019L),
                                          "1daec1f5-6bb9-4192-bcc1-f1efea5c3d60", new java.util.Date(1546027077084L),
                                          new java.util.Date(1546027078679L), null,
                                          com.arm.mbed.cloud.sdk.devices.model.DeviceDeployedState.getDefault(),
                                          "9e823867-2090-4cf3-9c9f-3b60bf9804bb",
                                          "e2e6dfdb-bc35-4c56-9b6b-2a0ad8446a65",
                                          "9dde602c-a17f-43fc-9884-4cd3d800ae28", 72,
                                          "fbff2014-931a-4055-a095-1cfee0875e1d",
                                          "f4e19454-d475-4eed-8250-0b235bb453ec",
                                          "88bfc480-bdd0-41a8-bed2-24426a2008d2", new java.util.Date(1546027073091L),
                                          "0e8d601d-1462-4b91-af62-921e38bdc3ec",
                                          "cf20d318-ac57-4998-b1e6-8fa76ff5e3ec",
                                          "68bf051e-9f57-4b21-b555-6a21b4a4b29c",
                                          "Q劈OⰯ�?ZJKퟟKW?<?L>P=鎋\\`SL�?@J(@R:>?/�?�<$M>;?M;_99㟧KH?9IS%",
                                          "cO32>cڟ7짠3P$%3ccY``'䂿cc`5죠锌3cKc3,c``O%c䄧c렄722`醗졨c``5C22?2(c䄔",
                                          "71b70173-d3f6-41c6-bdb5-1c581f36c030", new java.util.Date(1546027077034L),
                                          "2e5Ɬ2`5`55252Fe'`55Q졭.ee2ʧ`/Ve;▅55`e5NV25�?5e55퉿B`225`ꓓ2",
                                          "4c48f92f-9191-4486-befa-5d43a08f764d", new java.util.Date(1546027079631L),
                                          com.arm.mbed.cloud.sdk.devices.model.DeviceLifecycleStatus.getDefault(),
                                          "557c1849-b75c-4b00-8c44-7e0fac1bf732", new java.util.Date(1546027078213L),
                                          com.arm.mbed.cloud.sdk.devices.model.DeviceMechanism.getDefault(),
                                          "31946763-8117-421b-9708-4acf8f0f5c0f",
                                          "1c340e9b-7939-4c70-8a13-ea0890753071", false,
                                          "faa155a9-b8ee-41f7-b453-67e1f2079fdf",
                                          com.arm.mbed.cloud.sdk.devices.model.DeviceState.getDefault(), false,
                                          new java.util.Date(1546027079867L), "fdbfac04-6602-4753-9f62-6ec967a9728d");
        assertFalse(deviceInvalid.isValid());
    }

    /**
     * Tests the hashCode method.
     */
    @Test
    public void testHashcode() {
        Device device1 = new Device("bf0bdae5-44fa-40d0-8634-34c131fbd682", false, new java.util.Date(1546027073320L),
                                    new java.util.Date(1546027078001L), "e32685e9-c1ac-47e4-9888-56409b1f24bf",
                                    new java.util.Date(1546027080051L), new java.util.Date(1546027081628L), null,
                                    com.arm.mbed.cloud.sdk.devices.model.DeviceDeployedState.getDefault(),
                                    "4a26de60-1fe9-4740-a7dc-485311c03963", "c1cf4090-95c6-4684-9670-816a6ac28397",
                                    "db8a3587-6be6-4857-a95a-180070bb4dfb", 118, "2254d069-2223-47fe-8d2f-bf56f2eec988",
                                    "518083a6-2370-4f0a-bf5f-cc7aef572f43", "8c317651-2f17-497b-9490-c926c787d8bd",
                                    new java.util.Date(1546027073221L), "c45dc7d8-90dd-4f07-8b32-b698ed0964b9",
                                    "095fea7c-eaf5-4d79-9de1-44cf7cd9997e", "2ef1c7b8-f2d0-4662-b73d-1f29bed03d66",
                                    "0C32ABd7abFDDDaacb79bbDa4B14C0ED52bfE0bcFa0FCCAFeBE7EDdbc7c0eE40",
                                    "3_f8____dc6c693_b0_c139f74_f__5_", "1c2a753e-4c3a-4c11-8765-f7c7137ae77e",
                                    new java.util.Date(1546027073356L), "9_9ccc_b_d_ba250_4d_86de___b___c",
                                    "08801f56-0265-4ca1-a5f2-9bbcc569cfc5", new java.util.Date(1546027072677L),
                                    com.arm.mbed.cloud.sdk.devices.model.DeviceLifecycleStatus.getDefault(),
                                    "ef8a40f9-61e4-48eb-9fa2-255d6fec34fd", new java.util.Date(1546027078367L),
                                    com.arm.mbed.cloud.sdk.devices.model.DeviceMechanism.getDefault(),
                                    "8c9c6520-bf47-4e1b-8f51-ad5b18f7e577", "0eb0a1be-d330-4119-92b9-72282bb2ef9a",
                                    true, "c72e746b-a803-486f-957b-e0b9f35c6ad8",
                                    com.arm.mbed.cloud.sdk.devices.model.DeviceState.getDefault(), false,
                                    new java.util.Date(1546027080219L), "1e93a863-f5ef-4cca-ba08-31217de06501");
        Device device2 = new Device("bf0bdae5-44fa-40d0-8634-34c131fbd682", false, new java.util.Date(1546027073320L),
                                    new java.util.Date(1546027078001L), "e32685e9-c1ac-47e4-9888-56409b1f24bf",
                                    new java.util.Date(1546027080051L), new java.util.Date(1546027081628L), null,
                                    com.arm.mbed.cloud.sdk.devices.model.DeviceDeployedState.getDefault(),
                                    "4a26de60-1fe9-4740-a7dc-485311c03963", "c1cf4090-95c6-4684-9670-816a6ac28397",
                                    "db8a3587-6be6-4857-a95a-180070bb4dfb", 118, "2254d069-2223-47fe-8d2f-bf56f2eec988",
                                    "518083a6-2370-4f0a-bf5f-cc7aef572f43", "8c317651-2f17-497b-9490-c926c787d8bd",
                                    new java.util.Date(1546027073221L), "c45dc7d8-90dd-4f07-8b32-b698ed0964b9",
                                    "095fea7c-eaf5-4d79-9de1-44cf7cd9997e", "2ef1c7b8-f2d0-4662-b73d-1f29bed03d66",
                                    "0C32ABd7abFDDDaacb79bbDa4B14C0ED52bfE0bcFa0FCCAFeBE7EDdbc7c0eE40",
                                    "3_f8____dc6c693_b0_c139f74_f__5_", "1c2a753e-4c3a-4c11-8765-f7c7137ae77e",
                                    new java.util.Date(1546027073356L), "9_9ccc_b_d_ba250_4d_86de___b___c",
                                    "08801f56-0265-4ca1-a5f2-9bbcc569cfc5", new java.util.Date(1546027072677L),
                                    com.arm.mbed.cloud.sdk.devices.model.DeviceLifecycleStatus.getDefault(),
                                    "ef8a40f9-61e4-48eb-9fa2-255d6fec34fd", new java.util.Date(1546027078367L),
                                    com.arm.mbed.cloud.sdk.devices.model.DeviceMechanism.getDefault(),
                                    "8c9c6520-bf47-4e1b-8f51-ad5b18f7e577", "0eb0a1be-d330-4119-92b9-72282bb2ef9a",
                                    true, "c72e746b-a803-486f-957b-e0b9f35c6ad8",
                                    com.arm.mbed.cloud.sdk.devices.model.DeviceState.getDefault(), false,
                                    new java.util.Date(1546027080219L), "1e93a863-f5ef-4cca-ba08-31217de06501");
        assertNotNull(device1);
        assertNotNull(device2);
        assertNotSame(device2, device1);
        assertEquals(device2, device1);
        assertEquals(device2.hashCode(), device1.hashCode());
        int hashCode = device1.hashCode();
        for (int i = 0; i < 5; i++) {
            assertEquals(hashCode, device1.hashCode());
        }
    }

    /**
     * Tests the equals method.
     */
    @Test
    public void testEquals() {
        Device device1 = new Device("acedd4de-8082-4a83-8255-809b14a167d6", false, new java.util.Date(1546027079807L),
                                    new java.util.Date(1546027073014L), "72f950da-9e27-4cf1-bb47-8c601b794f15",
                                    new java.util.Date(1546027082330L), new java.util.Date(1546027073183L), null,
                                    com.arm.mbed.cloud.sdk.devices.model.DeviceDeployedState.getDefault(),
                                    "d402e8f8-3602-4a86-8f80-c1140089f4eb", "b651cf0f-69d3-4d39-964c-e6aeec298b67",
                                    "29b616e9-e18b-49bf-af7f-cb7c69065404", 13, "87f5229c-356e-44d1-99f1-4db9cfb5b369",
                                    "b44c0a93-2580-4175-9a45-db972f9af9a4", "99da640f-3cf8-4210-b759-d6f458c934bd",
                                    new java.util.Date(1546027078345L), "d28d0cf9-a27d-4406-aa86-2bd76ffa65fa",
                                    "d0e5e20b-eaa9-474e-829f-f962fb2dc4fb", "32ede390-c74f-40dc-95ae-15fdfa580c33",
                                    "A1EAad38Dace3CE7b1daF9BDdA57a802ad37DC9f1Dcebe3A5bFDFBf9EB33bdff",
                                    "8288f__5_aca___71_1_60b_7837_938", "f120416f-74b0-4035-b817-e593021610c7",
                                    new java.util.Date(1546027076107L), "83__f5__b_a4d6_17e_4e2fd5b_1___3",
                                    "ef6fce51-2ab0-4abc-a96b-55f7b64457c0", new java.util.Date(1546027077381L),
                                    com.arm.mbed.cloud.sdk.devices.model.DeviceLifecycleStatus.getDefault(),
                                    "95670cda-5316-4815-9295-47f6f977e5ae", new java.util.Date(1546027072467L),
                                    com.arm.mbed.cloud.sdk.devices.model.DeviceMechanism.getDefault(),
                                    "a7158d44-80c7-450f-9709-e836b93b2491", "b3d6ecfc-1651-46af-b31b-ba7060952e90",
                                    false, "3f2b2376-c527-470b-86cf-2f207ce901e7",
                                    com.arm.mbed.cloud.sdk.devices.model.DeviceState.getDefault(), true,
                                    new java.util.Date(1546027074313L), "5ea7a20d-55c8-4e46-a49a-76417229daab");
        Device device2 = new Device("acedd4de-8082-4a83-8255-809b14a167d6", false, new java.util.Date(1546027079807L),
                                    new java.util.Date(1546027073014L), "72f950da-9e27-4cf1-bb47-8c601b794f15",
                                    new java.util.Date(1546027082330L), new java.util.Date(1546027073183L), null,
                                    com.arm.mbed.cloud.sdk.devices.model.DeviceDeployedState.getDefault(),
                                    "d402e8f8-3602-4a86-8f80-c1140089f4eb", "b651cf0f-69d3-4d39-964c-e6aeec298b67",
                                    "29b616e9-e18b-49bf-af7f-cb7c69065404", 13, "87f5229c-356e-44d1-99f1-4db9cfb5b369",
                                    "b44c0a93-2580-4175-9a45-db972f9af9a4", "99da640f-3cf8-4210-b759-d6f458c934bd",
                                    new java.util.Date(1546027078345L), "d28d0cf9-a27d-4406-aa86-2bd76ffa65fa",
                                    "d0e5e20b-eaa9-474e-829f-f962fb2dc4fb", "32ede390-c74f-40dc-95ae-15fdfa580c33",
                                    "A1EAad38Dace3CE7b1daF9BDdA57a802ad37DC9f1Dcebe3A5bFDFBf9EB33bdff",
                                    "8288f__5_aca___71_1_60b_7837_938", "f120416f-74b0-4035-b817-e593021610c7",
                                    new java.util.Date(1546027076107L), "83__f5__b_a4d6_17e_4e2fd5b_1___3",
                                    "ef6fce51-2ab0-4abc-a96b-55f7b64457c0", new java.util.Date(1546027077381L),
                                    com.arm.mbed.cloud.sdk.devices.model.DeviceLifecycleStatus.getDefault(),
                                    "95670cda-5316-4815-9295-47f6f977e5ae", new java.util.Date(1546027072467L),
                                    com.arm.mbed.cloud.sdk.devices.model.DeviceMechanism.getDefault(),
                                    "a7158d44-80c7-450f-9709-e836b93b2491", "b3d6ecfc-1651-46af-b31b-ba7060952e90",
                                    false, "3f2b2376-c527-470b-86cf-2f207ce901e7",
                                    com.arm.mbed.cloud.sdk.devices.model.DeviceState.getDefault(), true,
                                    new java.util.Date(1546027074313L), "5ea7a20d-55c8-4e46-a49a-76417229daab");
        Device device3 = new Device("7c283a9e-3185-4d10-9b6f-9a7008a665b6", false, new java.util.Date(1546027076500L),
                                    new java.util.Date(1546027079568L), "580d5a92-4719-4737-b860-e8f2a02abe85",
                                    new java.util.Date(1546027072624L), new java.util.Date(1546027081225L), null,
                                    com.arm.mbed.cloud.sdk.devices.model.DeviceDeployedState.getDefault(),
                                    "c44f4742-6523-4894-a821-10b011fe155d", "d9688b88-15d7-4660-abf5-339e32c613d4",
                                    "490f736e-d1d4-458c-a6c6-d26883a7c3bd", -101,
                                    "a17a0cd5-8c61-4d95-8c3d-8b028bd59d8e", "5cb440a8-7d68-4e15-a479-f4d8878805fb",
                                    "f85765d6-8f2d-4045-98b9-be0c2c809898", new java.util.Date(1546027072781L),
                                    "238e4e3e-1e29-4fd4-a7f6-fac34c022505", "f375b714-f9df-4829-8354-7c6b62ff09c7",
                                    "970576ac-9d8c-4513-802e-e7bd8b13a121",
                                    "BaAEDeF4EbDFED01Ac7CdEcc2f2aFdAd3fDEdDC6fE2F80Cb6B9f5F4caB2a7afa",
                                    "__ab6__f__3163d1d_19c5___9c__ca2", "23791aa5-c3b4-4821-924f-70d634d5676c",
                                    new java.util.Date(1546027078016L), "aa_600_dd__7e__33dbf_e_6a_f__e3_",
                                    "fedace64-a3e9-4053-bce3-cf75218f3b3d", new java.util.Date(1546027079402L),
                                    com.arm.mbed.cloud.sdk.devices.model.DeviceLifecycleStatus.getDefault(),
                                    "23c85cc3-29bc-4cd7-8d9d-18de3bfc9e0c", new java.util.Date(1546027079287L),
                                    com.arm.mbed.cloud.sdk.devices.model.DeviceMechanism.getDefault(),
                                    "fcbe8a0c-4a13-4470-9c01-ac63fe17e3a2", "beb7366a-e5c8-4799-b022-018e43f0bbcc",
                                    true, "a48a083a-c1dc-49c1-9729-3dfae977e34c",
                                    com.arm.mbed.cloud.sdk.devices.model.DeviceState.getDefault(), false,
                                    new java.util.Date(1546027075427L), "51e9f9c9-778f-4ac8-afca-33eef9e3db33");
        assertNotNull(device1);
        assertNotNull(device2);
        assertNotNull(device3);
        assertNotSame(device2, device1);
        assertNotSame(device3, device1);
        assertEquals(device2, device1);
        assertEquals(device2, device1);
        assertEquals(device1, device2);
        assertEquals(device1, device1);
        assertFalse(device1.equals(null));
        assertNotEquals(device3, device1);
    }
}
