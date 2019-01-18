// This file was generated by the Pelion SDK foundation code generator.
// This is an autogenerated unit test class. Do not modify its content as modifications will be lost at next code generation.
package com.arm.mbed.cloud.sdk.security.model;

import static org.junit.Assert.*;

import java.util.Date;
import org.junit.Test;

/**
 * Unit tests for Model ServerCredentials.
 */
public class TestServerCredentials {
    /**
     * Tests the clone method.
     */
    @Test
    public void testClone() {
        try {
            ServerCredentials servercredentials1 = new ServerCredentials(new Date(1547730059330L),
                                                                         "58ae0a30-9e31-4046-96f9-32769f379ad8",
                                                                         "ff80bc96-cc9c-4942-af35-d9d3e778b6d8",
                                                                         "92ea958a-5ee2-4b47-ba71-fd61ec82bf70");
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
    @Test
    public void testHashCode() {
        try {
            ServerCredentials servercredentials1 = new ServerCredentials(new Date(1547730051250L),
                                                                         "97bfd93c-a89a-488b-bc9d-416aed44d532",
                                                                         "192fc8a3-c75e-42dc-9f96-0b455cc8d5fa",
                                                                         "61c7e764-9472-4041-9395-9be4c7f3015b");
            ServerCredentials servercredentials2 = new ServerCredentials(new Date(1547730051250L),
                                                                         "97bfd93c-a89a-488b-bc9d-416aed44d532",
                                                                         "192fc8a3-c75e-42dc-9f96-0b455cc8d5fa",
                                                                         "61c7e764-9472-4041-9395-9be4c7f3015b");
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
    @Test
    public void testIsValid() {
        ServerCredentials servercredentials = new ServerCredentials(new Date(1547730052756L),
                                                                    "fd992b33-a728-43c5-aa1e-ba5fb29d4176",
                                                                    "7e712183-1e94-4150-9e7e-5ff08dc742d6",
                                                                    "6008aa29-ae97-490f-8f8a-dd9754c309e7");
        assertTrue(servercredentials.isValid());
    }

    /**
     * Tests the equals method.
     */
    @Test
    public void testEquals() {
        try {
            ServerCredentials servercredentials1 = new ServerCredentials(new Date(1547730051048L),
                                                                         "7b5f8c74-049c-4d52-b37c-49adff6d1cc8",
                                                                         "459bf77f-de35-4335-a0f7-6ca8e4d654d1",
                                                                         "979d75e0-848e-4366-90ab-c901a3125694");
            ServerCredentials servercredentials2 = new ServerCredentials(new Date(1547730051048L),
                                                                         "7b5f8c74-049c-4d52-b37c-49adff6d1cc8",
                                                                         "459bf77f-de35-4335-a0f7-6ca8e4d654d1",
                                                                         "979d75e0-848e-4366-90ab-c901a3125694");
            ServerCredentials servercredentials3 = new ServerCredentials(new Date(1547730058268L),
                                                                         "95d26fc2-8145-47bc-92d9-92fead8b4e2c",
                                                                         "a11b000a-bab3-4f61-9f90-59ca1a2c9511",
                                                                         "02bf7188-4f68-4a0f-931c-a195430b9fc3");
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