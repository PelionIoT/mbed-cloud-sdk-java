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
            ServerCredentials servercredentials1 = new ServerCredentials(new Date(1559745300012L),
                                                                         "f5e4996f-509a-489a-8fa3-06b9a4361b50",
                                                                         "302075f9-998d-4eb3-91a1-4c534af3b6f2",
                                                                         "841c7901-4f07-4ab2-9c17-8edf4b13b0f8");
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
            ServerCredentials servercredentials1 = new ServerCredentials(new Date(1559745301665L),
                                                                         "12bc043a-b12b-4d73-836e-4259dad1b5b5",
                                                                         "2e52b323-7536-4095-9d4a-baf344bd7c87",
                                                                         "52cc1df5-31fb-4d8a-a7fb-f1ea62bb31f7");
            ServerCredentials servercredentials2 = new ServerCredentials(new Date(1559745301665L),
                                                                         "12bc043a-b12b-4d73-836e-4259dad1b5b5",
                                                                         "2e52b323-7536-4095-9d4a-baf344bd7c87",
                                                                         "52cc1df5-31fb-4d8a-a7fb-f1ea62bb31f7");
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
        ServerCredentials servercredentials = new ServerCredentials(new Date(1559745294079L),
                                                                    "2d427538-4443-4d4a-9809-c3938e82fc2a",
                                                                    "77c3f5d8-b06e-4896-8a4b-4dcc9d2e0abb",
                                                                    "0f8b56e7-e496-44e5-88c8-2301815d8c53");
        assertTrue(servercredentials.isValid());
    }

    /**
     * Tests the equals method.
     */
    @SuppressWarnings("resource")
    @Test
    public void testEquals() {
        try {
            ServerCredentials servercredentials1 = new ServerCredentials(new Date(1559745298306L),
                                                                         "9ddd1491-c6db-4db2-a88c-dd77009c1e74",
                                                                         "3ba54a4a-a230-4c70-9bd1-56516f9c8c0e",
                                                                         "c7ae1b08-9f77-4338-86b9-7b7f4cf99c8b");
            ServerCredentials servercredentials2 = new ServerCredentials(new Date(1559745298306L),
                                                                         "9ddd1491-c6db-4db2-a88c-dd77009c1e74",
                                                                         "3ba54a4a-a230-4c70-9bd1-56516f9c8c0e",
                                                                         "c7ae1b08-9f77-4338-86b9-7b7f4cf99c8b");
            ServerCredentials servercredentials3 = new ServerCredentials(new Date(1559745300366L),
                                                                         "c9cb1b99-179a-49ee-9eee-347d27afe32e",
                                                                         "4320f109-c2b2-4787-b661-5a606f5cb015",
                                                                         "87c5447a-dd1b-41c9-8ea0-7aa75b1862c8");
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
