// This file was generated by the Pelion SDK foundation code generator.
// This is an autogenerated unit test class. Do not modify its content as modifications will be lost at next code generation.
package com.arm.mbed.cloud.sdk.devices.model;

import static org.junit.Assert.*;

import java.util.Date;
import org.junit.Test;

/**
 * Unit tests for Model Device.
 */
@SuppressWarnings("PMD.AvoidDuplicateLiterals")
public class TestDevice {
    /**
     * Tests the clone method.
     */
    @SuppressWarnings("resource")
    @Test
    public void testClone() {
        try {
            Device device1 = new Device("914d2b82-9453-433f-a9b3-2202881a3a24", true, new Date(1559745297483L),
                                        new Date(1559745301912L), "df59c381-e506-44b5-8d64-9caea6b5c73c",
                                        new Date(1559745301718L), new Date(1559745298262L), null,
                                        DeviceDeployedState.getDefault(), "f38b6511-0382-412d-8c1a-d4907d884638",
                                        "246a3b9e-ee20-4e1f-a838-57f5df3772d7", "4175af3a-4d00-473d-a27e-3e5cd41", -6,
                                        "997bac11-8d06-44f6-8134-ebae609e7592", "da1132e7-cfa4-4829-86dd-a549934eb7aa",
                                        "4453f032-afdd-4475-89f9-39a1c9db8b36", new Date(1559745299032L),
                                        "f64ee962-5246-4dde-ab7b-1f952f8a2ded", "d3b3e6aa-5e4f-4dc1-9705-93904ca775d8",
                                        "3601833d-a892-4a77-83ea-8516e716416f",
                                        "9D9C5BDd9FBf9C82Daf77dD1b3b9deDDce1FF5EDFDA4DEDCEC7bcfDcdE6dAd2C",
                                        "18803703-03ba-49e1-9860-ac68d5ad2807", new Date(1559745294410L),
                                        DeviceMechanism.getDefault(), "98f9bc4b-b384-41df-8392-42acf55e7281",
                                        "211e84ce-1aa3-4859-b656-2a6185874658", "d16f80b9-f7bb-4499-beb7-1a368bd8747a",
                                        DeviceState.getDefault(), new Date(1559745296122L),
                                        "034dc027-91d0-47a4-b739-1eb61e11e49b");
            Device device2 = device1.clone();
            assertNotNull(device1);
            assertNotNull(device2);
            assertNotSame(device2, device1);
            assertEquals(device2, device1);
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
            Device device1 = new Device("26b463bc-203e-48db-911e-984311846c49", true, new Date(1559745298447L),
                                        new Date(1559745299628L), "d45aa75e-dc07-4f25-85fb-209a8af84df5",
                                        new Date(1559745296516L), new Date(1559745298641L), null,
                                        DeviceDeployedState.getDefault(), "6dd5faeb-b8c2-472c-bcd3-5aa402bf8d2d",
                                        "c6891c78-a4a7-4ff3-b142-9e66ca35dcc4", "bcdc29dd-6ef7-4e85-b9dc-1de21a5", 87,
                                        "9a2c3fb1-35d3-483c-a6ec-45962495346b", "d86ddb77-a4d8-4278-a7c5-2d8b5b9e3ea9",
                                        "60d13006-2d7f-44ad-92b7-07d357beadcc", new Date(1559745296016L),
                                        "559ffba6-0c9d-45a6-b014-d2f9fbbf4d73", "3645d8fa-edf9-4b4f-a00c-42da8fdb1d3d",
                                        "6d584286-8efc-45b5-86bc-294a9fa5a988",
                                        "9D9C5BDd9FBf9C82Daf77dD1b3b9deDDce1FF5EDFDA4DEDCEC7bcfDcdE6dAd2C",
                                        "83e1f3f7-5133-4c09-aa67-ae73ffd18333", new Date(1559745299059L),
                                        DeviceMechanism.getDefault(), "2ff70fc4-d320-4511-8d47-6de18dc68ff6",
                                        "3bb9b7e3-ddb5-40f8-a695-048f05b38dfe", "2496a56a-295c-40f6-8820-ee039848c0d0",
                                        DeviceState.getDefault(), new Date(1559745297838L),
                                        "e9b8c93e-8711-45c3-89e8-e8690c76f066");
            Device device2 = new Device("26b463bc-203e-48db-911e-984311846c49", true, new Date(1559745298447L),
                                        new Date(1559745299628L), "d45aa75e-dc07-4f25-85fb-209a8af84df5",
                                        new Date(1559745296516L), new Date(1559745298641L), null,
                                        DeviceDeployedState.getDefault(), "6dd5faeb-b8c2-472c-bcd3-5aa402bf8d2d",
                                        "c6891c78-a4a7-4ff3-b142-9e66ca35dcc4", "bcdc29dd-6ef7-4e85-b9dc-1de21a5", 87,
                                        "9a2c3fb1-35d3-483c-a6ec-45962495346b", "d86ddb77-a4d8-4278-a7c5-2d8b5b9e3ea9",
                                        "60d13006-2d7f-44ad-92b7-07d357beadcc", new Date(1559745296016L),
                                        "559ffba6-0c9d-45a6-b014-d2f9fbbf4d73", "3645d8fa-edf9-4b4f-a00c-42da8fdb1d3d",
                                        "6d584286-8efc-45b5-86bc-294a9fa5a988",
                                        "9D9C5BDd9FBf9C82Daf77dD1b3b9deDDce1FF5EDFDA4DEDCEC7bcfDcdE6dAd2C",
                                        "83e1f3f7-5133-4c09-aa67-ae73ffd18333", new Date(1559745299059L),
                                        DeviceMechanism.getDefault(), "2ff70fc4-d320-4511-8d47-6de18dc68ff6",
                                        "3bb9b7e3-ddb5-40f8-a695-048f05b38dfe", "2496a56a-295c-40f6-8820-ee039848c0d0",
                                        DeviceState.getDefault(), new Date(1559745297838L),
                                        "e9b8c93e-8711-45c3-89e8-e8690c76f066");
            assertNotNull(device1);
            assertNotNull(device2);
            assertNotSame(device2, device1);
            assertEquals(device2, device1);
            assertEquals(device2.hashCode(), device1.hashCode());
            int hashCode = device1.hashCode();
            for (int i = 0; i < 5; i++) {
                assertEquals(hashCode, device1.hashCode());
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
        Device device = new Device("73c28bd6-fd16-405c-98a4-8564b9bc59ee", true, new Date(1559745299607L),
                                   new Date(1559745297893L), "c7b3c5d0-8af6-4f1d-9c46-57a63202a7eb",
                                   new Date(1559745302629L), new Date(1559745300281L), null,
                                   DeviceDeployedState.getDefault(), "51aa6619-7502-4bee-9b13-de0eca636859",
                                   "0aff9420-4d19-4973-a1d2-ba9a492c40f1", "4dc6a698-964f-4778-9631-3dc6f19", -121,
                                   "e967684e-09b5-4c04-8945-782cf149e7f0", "3ff00440-7086-4d9f-bf98-58b44e646105",
                                   "f91dbb54-c555-4545-a64b-d6342c6b39ec", new Date(1559745294901L),
                                   "46df7356-918d-4d40-930d-cfa0528ce0c1", "ed24eb19-20ad-4ac3-80c1-0ad65e3f2dbb",
                                   "135db5c3-912f-44cb-932b-0a0a506ca609",
                                   "9D9C5BDd9FBf9C82Daf77dD1b3b9deDDce1FF5EDFDA4DEDCEC7bcfDcdE6dAd2C",
                                   "d974a3bc-662c-49f3-afbc-2f243075dfd2", new Date(1559745296024L),
                                   DeviceMechanism.getDefault(), "21026bdb-2cc9-4640-a122-997dfe8c86a9",
                                   "d95d9ee0-a46c-404d-9b87-86ab5044a863", "47bac2f2-5762-4f77-bfd0-2673824bce58",
                                   DeviceState.getDefault(), new Date(1559745296347L),
                                   "cea703ff-e8a1-4a92-912a-3d38012a410c");
        assertTrue(device.isValid());
        Device deviceInvalid = new Device("d2b54632-00d4-4fca-a110-78621b601e99", false, new Date(1559745295059L),
                                          new Date(1559745299464L),
                                          "c331016f-b614-4605-82b3-d1acfe3f283e5c634772-9fa1-44f4-82ac-971c5567a2d2cf3e891d-c8d5-4e0f-b88a-91caaf6e12471848372a-90b5-46d9-9950-d77b0a70a3e7010fce10-fc8d-4435-9112-5f6f52f1a990deb29813-0674-47bf-859e-e2e6164c912678ef4476-aad1-4d4a-b675-ce216b36aac5b0d84c52-34c7-485c-826a-2a3a4af8e619f9785689-e3c5-4263-8400-a7e2f9f897ba30345f52-a5bf-42e8-9891-61430fa8ca1ffcf8e809-c393-47fa-a92d-3f00204fae2a2300ad32-4309-48e7-95a3-054fa3dea6c2e752493c-96d0-4b10-b1fe-9841e5cf197c23f61f1f-6013-4203-8e94-06d95e1e44ec",
                                          new Date(1559745303147L), new Date(1559745296593L), null,
                                          DeviceDeployedState.getDefault(), "07ae88a2-34e1-43aa-8047-33732dae4679",
                                          "cb55c12a-8ee7-4bff-af70-4fb86722bd42e87e7271-edfb-4a43-921a-b138e6eeaf10e84bda1a-7e94-46c3-ac0d-46b266e45bc1423baa8d-3474-43f6-8731-d1c7fb5a884b84125ed3-28f1-46bf-8cf6-3fb52f806d63fdbacfed-1a80-4756-93a3-6ba1507c8a493195eebd-0dd4-4f31-ac5f-55f5aedfd4e2a4c77487-4c39-495a-9527-83778e1cb877ca40326f-9c38-40ed-b43a-3a7ef4c582d6b0778a1c-fd08-4cc8-8152-9c4ee3a53a2916a2c430-2f82-4557-b2e1-479c67cbb54fff6055aa-6c80-4424-91d0-0b25d22b4134ffb07b09-6dd0-4115-9f43-c05117b9b608c27a316d-9f38-4cfa-89a9-3d60ad03af5bf5c7906a-3fa6-4a68-9227-a22ee16eea1b723e7277-3782-4970-abf0-90078c7e5a63d6e89149-29c7-4558-a6c6-b9bd3435fd6bf2ed1cb8-215d-444a-ba81-f1714ec16c54e2360593-47fd-4854-acfc-76032be160fdcd27d736-a887-457d-b4c9-737baff1e9cc87203015-88dc-4da1-8d16-5248ce633554f5454302-66e2-49c1-b45b-4bf866d4dbeccdf79d2b-9c31-47e0-8812-dae49c069ca39f9373f4-983e-4d9d-a336-8e90ba394d661482836f-05e6-422c-b301-2a1b337073efce9843b1-a168-4070-9136-666cc45e513b06ffec92-e89f-4161-9e4d-76789d700b734db0ecac-dffc-4f7c-98a7-0b7e616f5deee5776c7b-e108-40dd-ad83-71d2a398f5c34da471d7-bbbd-41f4-85ba-a306387b415e77e6f037-5b2f-4d79-8a03-7ba4d231065d85598135-d68f-4d2e-a888-abc896fe917197fed421-09a2-4610-a091-2d1dc6f489bc589e18fd-d664-4d81-a929-484753583692325e12da-fc1e-46de-999f-ac7f33279a1029cd9887-7dda-448a-9a0c-4c3dc58023e880d5aa83-93fa-48e8-93d3-211ca7fb4b0c16633343-dbe3-4801-a21f-afe7066751e694f99e02-86a6-4ae7-ae00-5dda72ba42e65faa8169-66a8-4e42-acc5-64d2867b6fdc5040bf2d-6902-46a6-8069-8339759e4eff5832d626-4f72-41dc-9a27-fd7f27ce9d69ab9fa7a9-ee46-4f81-a054-accc2b3df43a299c82ed-443c-4b88-85cc-3672cf631eb57e7a289f-c23e-4bae-a581-0ec4473f7350ec75dbd1-c49f-4371-b95f-1c591d630525a49fc107-8b7e-4f67-b0b3-83fc82db143df02c8217-c84a-4812-ad2f-714c45b6c1c0d6940cc2-d982-47f5-985b-3925a996b67531c24364-b23b-4a45-8705-a70f1adc01d60685e9ef-fec4-45bb-9542-4bcb14ab63c04399bdba-1ef2-4c0f-8f22-f1d90eaff9a0902982c4-afe5-4629-a1ab-b1f433f32564d6116e30-4877-48c1-92d6-bfae66403de3e43d281b-a0aa-463d-9992-3981d596a87783cde9e8-cd23-4d67-9534-b6542985ee80",
                                          "8bded14d-645d-4e94-8742-a151b2be678a", -11,
                                          "d1df9461-0ec3-49de-8a47-b96450b75501744a177d-0d8f-46b6-b6d2-cbf4cf0179b8f90cd097-4647-457c-8366-d3e06690f56f1337ffe7-7ee0-4361-bce9-df900285f27afcf6a6a5-41cd-43fa-865b-d4232fcd83d784f53717-912a-4cb2-806f-4b409dd11e79b3d2a5ba-cdbe-4938-a508-87852c767ee1559a6f38-534a-473c-b7d1-9c6b33d356b693384e0b-3af0-4931-a14d-32692075ea9af5ebdeaf-eae3-4ca0-8b09-c8ed14eeeeaabac98554-a5dd-4276-8a31-4d98d17424a9d199dfdf-7cfd-4d97-bb1d-01d98aaf314b524a2079-1385-4270-ade8-dad08f8ee3dbf9210666-18aa-47f2-91c2-ac8ecad0882cf519b39f-bfd7-4066-9c33-f200beb13889",
                                          "521187b6-b78b-4d2b-9f77-687ffabaddd1",
                                          "8c9f78f7-d349-41f4-a680-ddfa471b3951f1a39462-33e5-47c2-9d9f-1764a96106d6",
                                          new Date(1559745298582L), "67d1052c-9195-4f4b-bb67-083cd3358edf",
                                          "50bbaed8-ff52-4a65-84f1-f1adf38246c8",
                                          "2f29612c-54ed-42c9-9ee5-6cef99f80073",
                                          "?I=\u0005<\u0010�?�=�?�\u000fU>�?;:毫\u0002\u0017;\u0011ᄺઞ>Y젷]뽚_=�?�KH\t駃W)OT@H>Y�?�0=ZL<?;K`ꉺ:;๢ᮑR>ᩧ=?:",
                                          "55204010-f08d-4435-9f8d-89f3af828935", new Date(1559745294605L),
                                          DeviceMechanism.getDefault(), "e5369298-346e-4df7-a80a-b18ddbd9a126",
                                          "b151df36-ba9f-4571-92ac-b91d4d31322b98c97af3-b915-40c4-a1b9-8a9ac6a237c52e7e43d3-9fee-421e-86ce-4c98a6865c21d73ad488-1d1a-4aa6-a386-dce38db13545",
                                          "832f3560-a68d-4a28-87d9-1d4870f79dc1", DeviceState.getDefault(),
                                          new Date(1559745298660L), "41ddc834-9ea4-4067-b205-30206f61febc");
        assertFalse(deviceInvalid.isValid());
    }

    /**
     * Tests the equals method.
     */
    @SuppressWarnings("resource")
    @Test
    public void testEquals() {
        try {
            Device device1 = new Device("fafb5a3b-43f6-4bc6-8300-d5cd6da20865", false, new Date(1559745301957L),
                                        new Date(1559745302032L), "de62a025-6f31-4fb8-af10-d28a233b1e75",
                                        new Date(1559745296299L), new Date(1559745297675L), null,
                                        DeviceDeployedState.getDefault(), "40993ad2-63c3-420b-bbaa-846261f08c80",
                                        "2e3db832-19a0-4fb8-b9a0-f4611ce03c8e", "3ebc2cd5-71a1-4bf8-9f04-10adaae", -113,
                                        "58c94efc-79d4-4dfa-af56-a6b90e20711b", "2929a986-bc85-4c88-9f87-1935da20f11c",
                                        "1cce6469-db66-45ea-9058-20652768c7ec", new Date(1559745293932L),
                                        "6bbb7981-481f-4b40-8ad4-655a54032e8c", "1c2c9844-05f8-4f57-bdd5-5fa6ef0427f4",
                                        "6dbdde4c-88a9-4740-8ab9-4ae24b705e1b",
                                        "9D9C5BDd9FBf9C82Daf77dD1b3b9deDDce1FF5EDFDA4DEDCEC7bcfDcdE6dAd2C",
                                        "b50a92fb-6b9b-43e2-aeda-7c1d587b30f8", new Date(1559745301812L),
                                        DeviceMechanism.getDefault(), "2722a13d-ddb2-44b0-9d8f-41f7d3fc288b",
                                        "52822f4e-009d-4d6e-8317-bdafbca70b2b", "1421613a-5090-4002-9f77-0f7d83ea5b19",
                                        DeviceState.getDefault(), new Date(1559745303449L),
                                        "564b9682-ab63-4fc4-93e4-dd4756e5d75e");
            Device device2 = new Device("fafb5a3b-43f6-4bc6-8300-d5cd6da20865", false, new Date(1559745301957L),
                                        new Date(1559745302032L), "de62a025-6f31-4fb8-af10-d28a233b1e75",
                                        new Date(1559745296299L), new Date(1559745297675L), null,
                                        DeviceDeployedState.getDefault(), "40993ad2-63c3-420b-bbaa-846261f08c80",
                                        "2e3db832-19a0-4fb8-b9a0-f4611ce03c8e", "3ebc2cd5-71a1-4bf8-9f04-10adaae", -113,
                                        "58c94efc-79d4-4dfa-af56-a6b90e20711b", "2929a986-bc85-4c88-9f87-1935da20f11c",
                                        "1cce6469-db66-45ea-9058-20652768c7ec", new Date(1559745293932L),
                                        "6bbb7981-481f-4b40-8ad4-655a54032e8c", "1c2c9844-05f8-4f57-bdd5-5fa6ef0427f4",
                                        "6dbdde4c-88a9-4740-8ab9-4ae24b705e1b",
                                        "9D9C5BDd9FBf9C82Daf77dD1b3b9deDDce1FF5EDFDA4DEDCEC7bcfDcdE6dAd2C",
                                        "b50a92fb-6b9b-43e2-aeda-7c1d587b30f8", new Date(1559745301812L),
                                        DeviceMechanism.getDefault(), "2722a13d-ddb2-44b0-9d8f-41f7d3fc288b",
                                        "52822f4e-009d-4d6e-8317-bdafbca70b2b", "1421613a-5090-4002-9f77-0f7d83ea5b19",
                                        DeviceState.getDefault(), new Date(1559745303449L),
                                        "564b9682-ab63-4fc4-93e4-dd4756e5d75e");
            Device device3 = new Device("2dd32133-6522-4b67-98b7-87bb1c5eed52", false, new Date(1559745300090L),
                                        new Date(1559745303431L), "d8a0a4bf-6b63-4763-8b4c-20e2dc26ad1d",
                                        new Date(1559745302895L), new Date(1559745300585L), null,
                                        DeviceDeployedState.getDefault(), "c42ef2de-bcce-41ac-b81d-2870326aea06",
                                        "2c901a58-03ea-4c40-8bb3-b2df2ca3dcf2", "ee3086ed-8afa-4a2a-884f-89169a1", -38,
                                        "6c0d4645-230f-40aa-9f76-5ac21e718026", "2f97dfb9-73fd-46ac-9830-d569ba14a9fa",
                                        "092250d4-a265-484b-ae93-068492f13849", new Date(1559745296932L),
                                        "2973432e-5e1a-4f91-af0f-8703021a0131", "c59af2e4-de4d-4c16-8873-16d02fffc6ad",
                                        "dcc3808a-c1d4-40d9-81a6-8a6b6d0726d8",
                                        "9D9C5BDd9FBf9C82Daf77dD1b3b9deDDce1FF5EDFDA4DEDCEC7bcfDcdE6dAd2C",
                                        "c27969ec-8b4b-4f3e-8fce-2d7b56ba756b", new Date(1559745301634L),
                                        DeviceMechanism.getDefault(), "81a9cfe7-fc8d-4df0-b2ac-63bd6b8e9eb9",
                                        "75d599d3-c4c8-4023-8d2c-a18ce8d5c8c3", "c5c427ec-c691-4028-af9f-9c8beeeb559a",
                                        DeviceState.getDefault(), new Date(1559745295620L),
                                        "07ea9f45-e78d-4d85-aead-78eb04bbb3b5");
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
        } catch (Exception exception) {
            fail(exception.getMessage());
        }
    }
}
