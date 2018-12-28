// This file was generated by the Pelion SDK foundation code generator.
// This is an autogenerated unit test class. Do not modify its content as modifications will be lost at next code generation.
package com.arm.mbed.cloud.sdk.security.model;

import static org.junit.Assert.*;

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
        ServerCredentials servercredentials1 = new ServerCredentials(new java.util.Date(1546027082828L),
                                                                     "a4fb0227-50ab-44aa-965c-053b572bd896",
                                                                     "add6d43d-45ce-4f2e-ab85-a0fa7c6d036c",
                                                                     "e1bd9739-37cf-4f42-ab29-77300c9e4769");
        ServerCredentials servercredentials2 = servercredentials1.clone();
        assertNotNull(servercredentials1);
        assertNotNull(servercredentials2);
        assertNotSame(servercredentials2, servercredentials1);
        assertEquals(servercredentials2, servercredentials1);
    }

    /**
     * Tests the isValid method.
     */
    @Test
    public void testIsvalid() {
        ServerCredentials servercredentials = new ServerCredentials(new java.util.Date(1546027080495L),
                                                                    "6176d1de-8145-41f0-8d15-c34869d6774f",
                                                                    "3cc3c3ee-3d47-4f95-bfbe-f0ec67649f41",
                                                                    "cebf7703-2cbc-4fb8-b8bc-d3d14dd8226a");
        assertTrue(servercredentials.isValid());
    }

    /**
     * Tests the hashCode method.
     */
    @Test
    public void testHashcode() {
        ServerCredentials servercredentials1 = new ServerCredentials(new java.util.Date(1546027082199L),
                                                                     "8aa6dff6-244a-4ad0-a389-1a2c152adca8",
                                                                     "70e9dc91-efaf-4d62-8ee6-cae44a70bfa4",
                                                                     "7c4ea59a-855d-491b-96fe-83d7726bac18");
        ServerCredentials servercredentials2 = new ServerCredentials(new java.util.Date(1546027082199L),
                                                                     "8aa6dff6-244a-4ad0-a389-1a2c152adca8",
                                                                     "70e9dc91-efaf-4d62-8ee6-cae44a70bfa4",
                                                                     "7c4ea59a-855d-491b-96fe-83d7726bac18");
        assertNotNull(servercredentials1);
        assertNotNull(servercredentials2);
        assertNotSame(servercredentials2, servercredentials1);
        assertEquals(servercredentials2, servercredentials1);
        assertEquals(servercredentials2.hashCode(), servercredentials1.hashCode());
        int hashCode = servercredentials1.hashCode();
        for (int i = 0; i < 5; i++) {
            assertEquals(hashCode, servercredentials1.hashCode());
        }
    }

    /**
     * Tests the equals method.
     */
    @Test
    public void testEquals() {
        ServerCredentials servercredentials1 = new ServerCredentials(new java.util.Date(1546027074798L),
                                                                     "294165be-ac09-4c09-b080-1e0ba37cc41b",
                                                                     "a05ab4b7-b934-4cc1-b872-03880bf3b5c4",
                                                                     "332b2852-004c-4023-b4c5-77f364698c55");
        ServerCredentials servercredentials2 = new ServerCredentials(new java.util.Date(1546027074798L),
                                                                     "294165be-ac09-4c09-b080-1e0ba37cc41b",
                                                                     "a05ab4b7-b934-4cc1-b872-03880bf3b5c4",
                                                                     "332b2852-004c-4023-b4c5-77f364698c55");
        ServerCredentials servercredentials3 = new ServerCredentials(new java.util.Date(1546027078755L),
                                                                     "a18cfff9-c03a-4057-8262-e329c5f2ab54",
                                                                     "af175242-333c-4b7d-b783-619fc2003dad",
                                                                     "4443b4e1-0097-44a2-a17c-2a68a44931bd");
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
    }
}
