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
            ServerCredentials servercredentials1 = new ServerCredentials(new Date(1553611833650L),
                                                                         "ce243fd1-653f-4919-a2bf-ebd86875c00e",
                                                                         "c7f8dbe2-46a3-4505-a5e1-1dd6a10b4fa8",
                                                                         "8b965325-d139-4fd9-98cb-192bf7b31e9f");
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
            ServerCredentials servercredentials1 = new ServerCredentials(new Date(1553611828202L),
                                                                         "fd8effb7-e78a-42f0-8f52-f7ad20666d44",
                                                                         "cec80cd6-6aee-4483-b70c-f230057642d3",
                                                                         "b88b6e5e-22a9-4877-a7c8-23c916070d89");
            ServerCredentials servercredentials2 = new ServerCredentials(new Date(1553611828202L),
                                                                         "fd8effb7-e78a-42f0-8f52-f7ad20666d44",
                                                                         "cec80cd6-6aee-4483-b70c-f230057642d3",
                                                                         "b88b6e5e-22a9-4877-a7c8-23c916070d89");
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
        ServerCredentials servercredentials = new ServerCredentials(new Date(1553611825274L),
                                                                    "86878db9-4d73-4f6c-95bb-e60e00650e5e",
                                                                    "ad3c41e5-6919-4b1d-a56a-424fcfd2411e",
                                                                    "c03f3f23-fe8b-4b8e-946a-9a27ad70c7c0");
        assertTrue(servercredentials.isValid());
    }

    /**
     * Tests the equals method.
     */
    @SuppressWarnings("resource")
    @Test
    public void testEquals() {
        try {
            ServerCredentials servercredentials1 = new ServerCredentials(new Date(1553611827346L),
                                                                         "b1e8fe59-02eb-4cf8-9ab2-eb6eebea6f8a",
                                                                         "182bf941-1639-4f72-8739-183ce36631c5",
                                                                         "9a6ac6e3-129e-4ab9-8360-8ee9fa4c1451");
            ServerCredentials servercredentials2 = new ServerCredentials(new Date(1553611827346L),
                                                                         "b1e8fe59-02eb-4cf8-9ab2-eb6eebea6f8a",
                                                                         "182bf941-1639-4f72-8739-183ce36631c5",
                                                                         "9a6ac6e3-129e-4ab9-8360-8ee9fa4c1451");
            ServerCredentials servercredentials3 = new ServerCredentials(new Date(1553611832433L),
                                                                         "fd44e9a8-0087-482e-a4ba-4b3066544b6f",
                                                                         "af5329a3-5d7e-43bb-811c-6ef485cadc39",
                                                                         "30912ec3-0b2d-4ac9-ab3f-056081959148");
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
