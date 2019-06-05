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
            ServerCredentials servercredentials1 = new ServerCredentials(new Date(1559747930142L),
                                                                         "d761c7f3-4562-4231-b503-ecedb52df91f",
                                                                         "8222088b-6d58-4986-ba25-3aeeebdff802",
                                                                         "9e43c44e-32e3-4482-8587-c144e2c742bd");
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
            ServerCredentials servercredentials1 = new ServerCredentials(new Date(1559747932517L),
                                                                         "21d96497-42e9-4a46-86d5-983d1d4b3254",
                                                                         "5f792ab5-b607-4f03-8b14-b11c9091faa8",
                                                                         "de008974-3da1-41e6-af41-be87b6ae4453");
            ServerCredentials servercredentials2 = new ServerCredentials(new Date(1559747932517L),
                                                                         "21d96497-42e9-4a46-86d5-983d1d4b3254",
                                                                         "5f792ab5-b607-4f03-8b14-b11c9091faa8",
                                                                         "de008974-3da1-41e6-af41-be87b6ae4453");
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
        ServerCredentials servercredentials = new ServerCredentials(new Date(1559747934192L),
                                                                    "d07295d2-fd61-4995-9e65-f504e7b601f9",
                                                                    "65a1c1ea-21b0-42a1-8cbb-25b03b6d6d6e",
                                                                    "62268044-6add-4a2a-a6b6-9240298e4dac");
        assertTrue(servercredentials.isValid());
    }

    /**
     * Tests the equals method.
     */
    @SuppressWarnings("resource")
    @Test
    public void testEquals() {
        try {
            ServerCredentials servercredentials1 = new ServerCredentials(new Date(1559747931301L),
                                                                         "fbd36c47-1509-4080-a2c6-43838f98f3d7",
                                                                         "a38fd498-f9fb-4e8b-a612-4aa14506c280",
                                                                         "93d8b670-0917-48cf-8459-1bf76ac4c247");
            ServerCredentials servercredentials2 = new ServerCredentials(new Date(1559747931301L),
                                                                         "fbd36c47-1509-4080-a2c6-43838f98f3d7",
                                                                         "a38fd498-f9fb-4e8b-a612-4aa14506c280",
                                                                         "93d8b670-0917-48cf-8459-1bf76ac4c247");
            ServerCredentials servercredentials3 = new ServerCredentials(new Date(1559747933071L),
                                                                         "f5fdab11-15fa-4392-a8f4-13390bede90d",
                                                                         "c9f497d2-a213-44d1-8a21-24061eb7a3cc",
                                                                         "ef3ec327-86f4-4b72-a550-d0e3ee4ceed4");
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
