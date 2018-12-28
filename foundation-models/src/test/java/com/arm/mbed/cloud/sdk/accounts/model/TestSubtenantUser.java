// This file was generated by the Pelion SDK foundation code generator.
// This is an autogenerated unit test class. Do not modify its content as modifications will be lost at next code generation.
package com.arm.mbed.cloud.sdk.accounts.model;

import static org.junit.Assert.*;

import org.junit.Test;

/**
 * Unit tests for Model SubtenantUser.
 */
public class TestSubtenantUser {
    /**
     * Tests the clone method.
     */
    @Test
    public void testClone() {
        SubtenantUser subtenantuser1 = new SubtenantUser("35297be0-99ca-46b7-a735-11dea384ff65",
                                                         "aa0131b8-96e3-4ca5-89d1-12eb00728e51",
                                                         new java.util.Date(1546027080915L), 17,
                                                         "ceaebd4f-c52b-446e-b4a7-4342e944f386", false,
                                                         "c6cd69e1-e5bb-4aad-865e-10fc5def6668",
                                                         "1ddd1a41-6bf2-4089-ada2-cc679cf35576", -34, null, null, true,
                                                         "d9b8b0a7-7062-447a-9ea8-110ed672781d", -58,
                                                         "ae0b6a94-42fe-47cd-a098-20d10039f59c",
                                                         com.arm.mbed.cloud.sdk.accounts.model.SubtenantUserStatus.getDefault(),
                                                         false, false, new java.util.Date(1546027073328L),
                                                         "5d81db54-ef6a-4202-9dd3-74627a76e9b0");
        SubtenantUser subtenantuser2 = subtenantuser1.clone();
        assertNotNull(subtenantuser1);
        assertNotNull(subtenantuser2);
        assertNotSame(subtenantuser2, subtenantuser1);
        assertEquals(subtenantuser2, subtenantuser1);
    }

    /**
     * Tests the isValid method.
     */
    @Test
    public void testIsvalid() {
        SubtenantUser subtenantuser = new SubtenantUser("d7263126-f86c-4477-81c9-7c3f5ceff8fd",
                                                        "266bf611-abfb-4e10-ad01-faa3c1eb2abc",
                                                        new java.util.Date(1546027081205L), 99,
                                                        "54f3ba0e-7eed-4f9a-b0eb-74709cfc4df6", false,
                                                        "332e3497-d264-494c-81fc-94e80cdbb9f1",
                                                        "b139a8ff-87a5-4322-8f07-08f86c4fce03", -94, null, null, true,
                                                        "7ca9baf2-9959-4c01-b45e-08ed84edcbec", 56,
                                                        "c95973aa-edf0-4a81-8f32-302eaf3f8731",
                                                        com.arm.mbed.cloud.sdk.accounts.model.SubtenantUserStatus.getDefault(),
                                                        false, false, new java.util.Date(1546027080333L),
                                                        "a717b118-45ee-4492-b808-79147aa111c5");
        assertTrue(subtenantuser.isValid());
    }

    /**
     * Tests the hashCode method.
     */
    @Test
    public void testHashcode() {
        SubtenantUser subtenantuser1 = new SubtenantUser("708ebcec-8c92-4fac-bf1a-fe4999558fa4",
                                                         "a5cae9f9-4f9e-46e9-b60a-170f3dc129e0",
                                                         new java.util.Date(1546027079048L), 12,
                                                         "c34e8956-66da-4162-8d2d-95ffa3484cd3", false,
                                                         "0976d695-e880-42be-98c8-73a40980f970",
                                                         "a35842d4-50a5-430c-9e4b-21903488ee09", 53, null, null, false,
                                                         "6e377553-4f2e-4516-8360-c7d1812f4d89", -22,
                                                         "68bacacf-678c-4f3d-a4d6-92f785e00ab6",
                                                         com.arm.mbed.cloud.sdk.accounts.model.SubtenantUserStatus.getDefault(),
                                                         false, true, new java.util.Date(1546027079028L),
                                                         "4ea24ba1-efd0-4e06-8491-81e008b323e4");
        SubtenantUser subtenantuser2 = new SubtenantUser("708ebcec-8c92-4fac-bf1a-fe4999558fa4",
                                                         "a5cae9f9-4f9e-46e9-b60a-170f3dc129e0",
                                                         new java.util.Date(1546027079048L), 12,
                                                         "c34e8956-66da-4162-8d2d-95ffa3484cd3", false,
                                                         "0976d695-e880-42be-98c8-73a40980f970",
                                                         "a35842d4-50a5-430c-9e4b-21903488ee09", 53, null, null, false,
                                                         "6e377553-4f2e-4516-8360-c7d1812f4d89", -22,
                                                         "68bacacf-678c-4f3d-a4d6-92f785e00ab6",
                                                         com.arm.mbed.cloud.sdk.accounts.model.SubtenantUserStatus.getDefault(),
                                                         false, true, new java.util.Date(1546027079028L),
                                                         "4ea24ba1-efd0-4e06-8491-81e008b323e4");
        assertNotNull(subtenantuser1);
        assertNotNull(subtenantuser2);
        assertNotSame(subtenantuser2, subtenantuser1);
        assertEquals(subtenantuser2, subtenantuser1);
        assertEquals(subtenantuser2.hashCode(), subtenantuser1.hashCode());
        int hashCode = subtenantuser1.hashCode();
        for (int i = 0; i < 5; i++) {
            assertEquals(hashCode, subtenantuser1.hashCode());
        }
    }

    /**
     * Tests the equals method.
     */
    @Test
    public void testEquals() {
        SubtenantUser subtenantuser1 = new SubtenantUser("7de4e7a4-b617-47b5-ba80-bc2793da4c4c",
                                                         "9a4956de-e7fb-47c2-8631-a32c10c58191",
                                                         new java.util.Date(1546027080801L), -55,
                                                         "cb7caa29-ecdf-4e4e-b2e7-24e5fb041d7e", false,
                                                         "114ef5a0-ad05-4d7a-965b-4d8bd4825e53",
                                                         "1b2c3e46-1394-4ea3-82fb-3d5b663b32bf", 72, null, null, false,
                                                         "4f185b8b-b56e-49ac-81cd-b705b1cf9da0", 33,
                                                         "134dedac-3544-45cf-9abc-0ec0d94d4065",
                                                         com.arm.mbed.cloud.sdk.accounts.model.SubtenantUserStatus.getDefault(),
                                                         false, true, new java.util.Date(1546027074092L),
                                                         "17186316-f1c3-4ab7-8a8a-0c9f465f0aa6");
        SubtenantUser subtenantuser2 = new SubtenantUser("7de4e7a4-b617-47b5-ba80-bc2793da4c4c",
                                                         "9a4956de-e7fb-47c2-8631-a32c10c58191",
                                                         new java.util.Date(1546027080801L), -55,
                                                         "cb7caa29-ecdf-4e4e-b2e7-24e5fb041d7e", false,
                                                         "114ef5a0-ad05-4d7a-965b-4d8bd4825e53",
                                                         "1b2c3e46-1394-4ea3-82fb-3d5b663b32bf", 72, null, null, false,
                                                         "4f185b8b-b56e-49ac-81cd-b705b1cf9da0", 33,
                                                         "134dedac-3544-45cf-9abc-0ec0d94d4065",
                                                         com.arm.mbed.cloud.sdk.accounts.model.SubtenantUserStatus.getDefault(),
                                                         false, true, new java.util.Date(1546027074092L),
                                                         "17186316-f1c3-4ab7-8a8a-0c9f465f0aa6");
        SubtenantUser subtenantuser3 = new SubtenantUser("3af3ee5c-0cc6-47d1-be7e-cf380f1cd977",
                                                         "d41e3fd5-bd09-41be-a282-d35c5d1f5689",
                                                         new java.util.Date(1546027082216L), -117,
                                                         "f89e4c14-a5f6-42a5-9686-070eb6052ee6", false,
                                                         "19a79b7d-4ca8-4c22-8fdb-45e345bc2bf2",
                                                         "0027f7da-dc50-4270-9481-887ea295c3ca", 88, null, null, true,
                                                         "ef331234-b19c-4a18-b1b4-71d8a171ff4f", 82,
                                                         "0a182d95-3fee-4dea-9521-7698ea01285a",
                                                         com.arm.mbed.cloud.sdk.accounts.model.SubtenantUserStatus.getDefault(),
                                                         false, false, new java.util.Date(1546027076895L),
                                                         "ec2b15c5-5552-49b8-9eed-f8bda2b12d53");
        assertNotNull(subtenantuser1);
        assertNotNull(subtenantuser2);
        assertNotNull(subtenantuser3);
        assertNotSame(subtenantuser2, subtenantuser1);
        assertNotSame(subtenantuser3, subtenantuser1);
        assertEquals(subtenantuser2, subtenantuser1);
        assertEquals(subtenantuser2, subtenantuser1);
        assertEquals(subtenantuser1, subtenantuser2);
        assertEquals(subtenantuser1, subtenantuser1);
        assertFalse(subtenantuser1.equals(null));
        assertNotEquals(subtenantuser3, subtenantuser1);
    }
}
