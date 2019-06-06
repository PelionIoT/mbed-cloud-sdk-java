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
            DeviceGroup devicegroup1 = new DeviceGroup(new Date(1559833685644L), null,
                                                       "0ed783f3-9225-4840-b5ce-248392aebd7b", -86,
                                                       "3638e9d0-1fc7-4466-9d8b-e3a5ad757f09",
                                                       "a0f3898e-67f0-4990-82d8-51c674a45775",
                                                       new Date(1559833681001L));
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
            DeviceGroup devicegroup1 = new DeviceGroup(new Date(1559833686801L), null,
                                                       "31c30fdf-0f96-4138-8d6a-157f67b5c65c", -35,
                                                       "77bf6f61-ea2a-4e09-a981-09225d9ef080",
                                                       "608d092e-6e15-451d-ba0c-77f31c5d68e0",
                                                       new Date(1559833680498L));
            DeviceGroup devicegroup2 = new DeviceGroup(new Date(1559833686801L), null,
                                                       "31c30fdf-0f96-4138-8d6a-157f67b5c65c", -35,
                                                       "77bf6f61-ea2a-4e09-a981-09225d9ef080",
                                                       "608d092e-6e15-451d-ba0c-77f31c5d68e0",
                                                       new Date(1559833680498L));
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
        DeviceGroup devicegroup = new DeviceGroup(new Date(1559833686318L), null,
                                                  "50187b2e-1a66-4811-9335-2ab7c20c3c22", 15,
                                                  "de73fb7f-c493-4fc1-ac7c-31f73c10924f",
                                                  "76e3b07f-ae14-48f4-9d8f-72155dafdff3", new Date(1559833684583L));
        assertTrue(devicegroup.isValid());
        DeviceGroup devicegroupInvalid = new DeviceGroup(new Date(1559833686707L), null,
                                                         "2b55bf2e-913f-47ed-a9e6-78aa15d9fd0ca103ab56-250d-4b84-89f3-81309e59114d2c1ced6d-526d-458c-9abf-0883bf9f46b05010024d-dc5f-42b6-b786-21e2869aecefb4e1be64-b132-45ec-8335-13cdcb7fc4f40111db7a-233c-455b-a080-32a98a254d8a0dbe8d2c-fa79-4429-80de-973a3f6746da65b59451-7085-4900-84d4-c76b582beace80ad0229-6f79-48c9-9ef8-ab0bdf71fe57026c2de4-f677-4253-a65a-6bdf9bc869275f643cfe-2ddf-4b3e-a165-87ad20f5055fae1c1601-6865-42af-9a29-d98ed7b0a44dcdc58343-e3d6-4cc2-9dfc-6170c586f0b11d235856-7a49-434c-ab2b-efa800107d6971508098-786f-4456-ae97-cfeb93172d8d841a0ae6-228f-4e13-9372-1b878954235012046830-4a91-4287-998b-5c1314303236724cb2d6-1913-4915-8069-5199c42b037dfdae1229-5ddc-494f-983d-8881d94b2bc91b22341b-656e-4019-958a-c476f7dc3a2e06cb7794-169f-4b40-9fa7-66582834c70b519e2605-a12d-4d34-aba0-c0488f538837186b4fa9-17cc-4c2b-8719-128591df44cf2067b06c-aa8c-441b-a1c3-0539ea067d1915e8d846-7f39-491b-8742-da1fc5968c5bef1d1a8f-cd0e-49ce-ba32-42e3e210516005f63ca8-7965-407b-a8a8-4d235f76f87a61c539df-b8fc-4ff0-bd56-da0bf5fca0f81307b9b4-005c-416d-9413-a8d010d46de206dbf165-2347-42bc-a9d8-5ffb68e27aed454497a2-ee51-43c6-b340-0b6fe9334c9fa4535e20-198e-43bf-83b6-a3bfbecd266397189ec2-c06f-4f6a-bea9-d5ab9f2fc7e2f231b874-d467-4f19-bc30-8ec3c7394438b2f1b0ab-3373-4a2b-bc45-df59665b0890684934b7-8318-4ee4-bb5f-fe07607712180ab2747e-b656-4834-8381-79943ca5c918dc34b575-e042-4816-92f0-5e5d5a2f471c211cca41-7e06-4e5b-b936-0623338a691ac4158a0c-85ce-45e0-baa6-af8d627be6199c4e83bd-0307-49d8-bffc-96a6875b4a9bc4452b1a-5f6c-4cc4-b19b-9e07738397ddf354ac7f-7501-44d4-8c4d-51c34f293fbaed92740e-a5b2-4d24-818b-abdba366448b79e9bca9-cbc8-468c-8823-ebfc0cbecdd02cdce27c-4082-4657-8869-f32adb898be415f0830a-cb5c-4bde-9d44-2aeb0700dd28ecd4208c-7690-48f6-b001-23509cce489eaafaf6e7-0c42-4b8c-8e0f-036068aaf25d4a1d5fe1-c860-4750-af57-62bda388b12b657f650f-8bb6-4f1e-a41b-c84c06fc032a05721339-dab9-48c2-9a2f-32ea629058097b0bb649-aa15-4ea0-9d8b-ca6a2ff1642b798f448e-0054-4ad2-963f-6f8ffee2f9d5e7ef2769-c4a0-45cf-90cc-cc4f0e6c5829836b1805-1bc1-4563-bc87-52014b076a3b",
                                                         12, "bdd387cd-4884-4460-a6f1-783b87104b5b",
                                                         "8fa26ca0-33bc-4346-b750-b60f6997d6dc2fb4b0bb-e21d-42a1-bf74-230b88876a7536df227e-d0cd-4641-b4be-685f734609f2fc24f2c6-e396-4e09-b446-01bef494b795",
                                                         new Date(1559833684668L));
        assertFalse(devicegroupInvalid.isValid());
    }

    /**
     * Tests the equals method.
     */
    @SuppressWarnings("resource")
    @Test
    public void testEquals() {
        try {
            DeviceGroup devicegroup1 = new DeviceGroup(new Date(1559833681175L), null,
                                                       "b99793d1-0c1a-49fe-8acb-50da57a1a8c8", 27,
                                                       "b8a58f45-443a-4fa1-ac21-82b334c138d1",
                                                       "f65dc107-3aad-428a-a46a-dbcc7ae1e99f",
                                                       new Date(1559833686658L));
            DeviceGroup devicegroup2 = new DeviceGroup(new Date(1559833681175L), null,
                                                       "b99793d1-0c1a-49fe-8acb-50da57a1a8c8", 27,
                                                       "b8a58f45-443a-4fa1-ac21-82b334c138d1",
                                                       "f65dc107-3aad-428a-a46a-dbcc7ae1e99f",
                                                       new Date(1559833686658L));
            DeviceGroup devicegroup3 = new DeviceGroup(new Date(1559833678632L), null,
                                                       "6a6a1ae8-effd-45a4-b46d-58cde07d8c76", 28,
                                                       "66e5eb05-a129-4347-8cc6-c2487184a0fb",
                                                       "021e74a6-7c9d-4077-8ee9-6bde9a9a0b0f",
                                                       new Date(1559833683312L));
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
