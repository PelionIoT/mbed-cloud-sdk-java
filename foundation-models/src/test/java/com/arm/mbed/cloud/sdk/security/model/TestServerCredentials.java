// This file was generated by the Pelion SDK foundation code generator.
// This is an autogenerated unit test class. Do not modify its content as modifications will be lost at next code generation.
package com.arm.mbed.cloud.sdk.security.model;

import static org.junit.Assert.*;

import java.util.Date;
import org.junit.Test;

/**
 * Unit tests for Model ServerCredentials.
 */
@SuppressWarnings("PMD.AvoidDuplicateLiterals")
public class TestServerCredentials {
    /**
     * Tests the clone method.
     */
    @SuppressWarnings("resource")
    @Test
    public void testClone() {
        try {
            ServerCredentials servercredentials1 = new ServerCredentials(new Date(1553524605900L),
                                                                         "50f352cb-d05e-4cbd-a9e9-19722bcd6876",
                                                                         "71f48a55-b8e2-4e1b-a182-4406aa17ca33",
                                                                         "f95ab147-080b-4863-9c16-b79614717746");
            ServerCredentials servercredentials2 = servercredentials1.clone();
            assertNotNull(servercredentials1);
            assertNotNull(servercredentials2);
            assertNotSame(servercredentials2, servercredentials1);
            assertEquals(servercredentials2, servercredentials1);
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
            ServerCredentials servercredentials1 = new ServerCredentials(new Date(1553524607518L),
                                                                         "1f92fb96-f991-4c91-811c-87e3170f7ec9",
                                                                         "ed697f5c-067b-4540-8004-2f2ad9111cf4",
                                                                         "2ea54728-3673-481b-b647-867884c19122");
            ServerCredentials servercredentials2 = new ServerCredentials(new Date(1553524607518L),
                                                                         "1f92fb96-f991-4c91-811c-87e3170f7ec9",
                                                                         "ed697f5c-067b-4540-8004-2f2ad9111cf4",
                                                                         "2ea54728-3673-481b-b647-867884c19122");
            assertNotNull(servercredentials1);
            assertNotNull(servercredentials2);
            assertNotSame(servercredentials2, servercredentials1);
            assertEquals(servercredentials2, servercredentials1);
            assertEquals(servercredentials2.hashCode(), servercredentials1.hashCode());
            int hashCode = servercredentials1.hashCode();
            for (int i = 0; i < 5; i++) {
                assertEquals(hashCode, servercredentials1.hashCode());
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
        ServerCredentials servercredentials = new ServerCredentials(new Date(1553524613468L),
                                                                    "2844a4c0-c765-4c7a-b986-3ee80a677bfd",
                                                                    "61ef3195-b1c6-411f-939a-c049c9b48852",
                                                                    "67156a12-3222-4603-9a71-ac129ab49892");
        assertTrue(servercredentials.isValid());
    }

    /**
     * Tests the equals method.
     */
    @SuppressWarnings("resource")
    @Test
    public void testEquals() {
        try {
            ServerCredentials servercredentials1 = new ServerCredentials(new Date(1553524609576L),
                                                                         "db60683a-b43c-446e-a550-41c5f7e25f8d",
                                                                         "7d0458c1-3c92-4af6-8bd2-30ecd6752437",
                                                                         "afad7c4e-ed74-4c25-8f81-bc3d57ecc805");
            ServerCredentials servercredentials2 = new ServerCredentials(new Date(1553524609576L),
                                                                         "db60683a-b43c-446e-a550-41c5f7e25f8d",
                                                                         "7d0458c1-3c92-4af6-8bd2-30ecd6752437",
                                                                         "afad7c4e-ed74-4c25-8f81-bc3d57ecc805");
            ServerCredentials servercredentials3 = new ServerCredentials(new Date(1553524609380L),
                                                                         "f3b58576-504e-4a68-b6e0-fc5174dd4b2e",
                                                                         "2c53d33b-4add-44ca-8c9e-74ae352c67a5",
                                                                         "4b72fb5f-e704-4763-912c-75f25a366fa4");
            assertNotNull(servercredentials1);
            assertNotNull(servercredentials2);
            assertNotNull(servercredentials3);
            assertNotSame(servercredentials2, servercredentials1);
            assertNotSame(servercredentials3, servercredentials1);
            assertEquals(servercredentials2, servercredentials1);
            assertEquals(servercredentials2, servercredentials1);
            assertEquals(servercredentials1, servercredentials2);
            assertEquals(servercredentials1, servercredentials1);
            assertFalse(servercredentials1.equals(null));
            assertNotEquals(servercredentials3, servercredentials1);
        } catch (Exception exception) {
            fail(exception.getMessage());
        }
    }
}
