// This file was generated by the Pelion SDK foundation code generator.
// This is an autogenerated unit test class. Do not modify its content as modifications will be lost at next code generation.
package com.arm.mbed.cloud.sdk.devices.model;

import static org.junit.Assert.*;

import java.util.Date;
import org.junit.Test;

/**
 * Unit tests for Model DeviceEnrollmentDenial.
 */
@SuppressWarnings("PMD.AvoidDuplicateLiterals")
public class TestDeviceEnrollmentDenial {
    /**
     * Tests the clone method.
     */
    @SuppressWarnings("resource")
    @Test
    public void testClone() {
        try {
            DeviceEnrollmentDenial deviceenrollmentdenial1 = new DeviceEnrollmentDenial("3f3bfa45b47fdcef3cd0baefcc7b4d9a",
                                                                                        new Date(1559560672527L),
                                                                                        "9751d8e5-d41e-40b0-a14b-984b48583b7f",
                                                                                        "3f3bfa45b47fdcef3cd0baefcc7b4d9a",
                                                                                        "3f3bfa45b47fdcef3cd0baefcc7b4d9a");
            DeviceEnrollmentDenial deviceenrollmentdenial2 = deviceenrollmentdenial1.clone();
            assertNotNull(deviceenrollmentdenial1);
            assertNotNull(deviceenrollmentdenial2);
            assertNotSame(deviceenrollmentdenial2, deviceenrollmentdenial1);
            assertEquals(deviceenrollmentdenial2, deviceenrollmentdenial1);
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
            DeviceEnrollmentDenial deviceenrollmentdenial1 = new DeviceEnrollmentDenial("3f3bfa45b47fdcef3cd0baefcc7b4d9a",
                                                                                        new Date(1559560673174L),
                                                                                        "fe4ec808-5f76-4545-a677-2675e1a82e8f",
                                                                                        "3f3bfa45b47fdcef3cd0baefcc7b4d9a",
                                                                                        "3f3bfa45b47fdcef3cd0baefcc7b4d9a");
            DeviceEnrollmentDenial deviceenrollmentdenial2 = new DeviceEnrollmentDenial("3f3bfa45b47fdcef3cd0baefcc7b4d9a",
                                                                                        new Date(1559560673174L),
                                                                                        "fe4ec808-5f76-4545-a677-2675e1a82e8f",
                                                                                        "3f3bfa45b47fdcef3cd0baefcc7b4d9a",
                                                                                        "3f3bfa45b47fdcef3cd0baefcc7b4d9a");
            assertNotNull(deviceenrollmentdenial1);
            assertNotNull(deviceenrollmentdenial2);
            assertNotSame(deviceenrollmentdenial2, deviceenrollmentdenial1);
            assertEquals(deviceenrollmentdenial2, deviceenrollmentdenial1);
            assertEquals(deviceenrollmentdenial2.hashCode(), deviceenrollmentdenial1.hashCode());
            int hashCode = deviceenrollmentdenial1.hashCode();
            for (int i = 0; i < 5; i++) {
                assertEquals(hashCode, deviceenrollmentdenial1.hashCode());
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
        DeviceEnrollmentDenial deviceenrollmentdenial = new DeviceEnrollmentDenial("3f3bfa45b47fdcef3cd0baefcc7b4d9a",
                                                                                   new Date(1559560670251L),
                                                                                   "cefe4200-5ba8-4909-a00c-5f8fd6f1bd6b",
                                                                                   "3f3bfa45b47fdcef3cd0baefcc7b4d9a",
                                                                                   "3f3bfa45b47fdcef3cd0baefcc7b4d9a");
        assertTrue(deviceenrollmentdenial.isValid());
        DeviceEnrollmentDenial deviceenrollmentdenialInvalid = new DeviceEnrollmentDenial("傿!6碚⫔2'>\t栦\u001c6Y8\u001d�?8\u001f\u00176ट22梋)8饦B?翓[6齭�?�8821\u001aM\u001588\u0011َ6+6_88F1\u0004666[86맱I1_",
                                                                                          new Date(1559560668567L),
                                                                                          "1ebbbe0e-4633-416e-82de-301073e00227",
                                                                                          "傿!6碚⫔2'>\t栦\u001c6Y8\u001d�?8\u001f\u00176ट22梋)8饦B?翓[6齭�?�8821\u001aM\u001588\u0011َ6+6_88F1\u0004666[86맱I1_",
                                                                                          "傿!6碚⫔2'>\t栦\u001c6Y8\u001d�?8\u001f\u00176ट22梋)8饦B?翓[6齭�?�8821\u001aM\u001588\u0011َ6+6_88F1\u0004666[86맱I1_");
        assertFalse(deviceenrollmentdenialInvalid.isValid());
    }

    /**
     * Tests the equals method.
     */
    @SuppressWarnings("resource")
    @Test
    public void testEquals() {
        try {
            DeviceEnrollmentDenial deviceenrollmentdenial1 = new DeviceEnrollmentDenial("3f3bfa45b47fdcef3cd0baefcc7b4d9a",
                                                                                        new Date(1559560669712L),
                                                                                        "49f7d035-50d7-4e25-bb7a-f86c11b80060",
                                                                                        "3f3bfa45b47fdcef3cd0baefcc7b4d9a",
                                                                                        "3f3bfa45b47fdcef3cd0baefcc7b4d9a");
            DeviceEnrollmentDenial deviceenrollmentdenial2 = new DeviceEnrollmentDenial("3f3bfa45b47fdcef3cd0baefcc7b4d9a",
                                                                                        new Date(1559560669712L),
                                                                                        "49f7d035-50d7-4e25-bb7a-f86c11b80060",
                                                                                        "3f3bfa45b47fdcef3cd0baefcc7b4d9a",
                                                                                        "3f3bfa45b47fdcef3cd0baefcc7b4d9a");
            DeviceEnrollmentDenial deviceenrollmentdenial3 = new DeviceEnrollmentDenial("3f3bfa45b47fdcef3cd0baefcc7b4d9a",
                                                                                        new Date(1559560667434L),
                                                                                        "6977ad61-1676-49e3-b826-13b04ece4c10",
                                                                                        "3f3bfa45b47fdcef3cd0baefcc7b4d9a",
                                                                                        "3f3bfa45b47fdcef3cd0baefcc7b4d9a");
            assertNotNull(deviceenrollmentdenial1);
            assertNotNull(deviceenrollmentdenial2);
            assertNotNull(deviceenrollmentdenial3);
            assertNotSame(deviceenrollmentdenial2, deviceenrollmentdenial1);
            assertNotSame(deviceenrollmentdenial3, deviceenrollmentdenial1);
            assertEquals(deviceenrollmentdenial2, deviceenrollmentdenial1);
            assertEquals(deviceenrollmentdenial2, deviceenrollmentdenial1);
            assertEquals(deviceenrollmentdenial1, deviceenrollmentdenial2);
            assertEquals(deviceenrollmentdenial1, deviceenrollmentdenial1);
            assertFalse(deviceenrollmentdenial1.equals(null));
            assertNotEquals(deviceenrollmentdenial3, deviceenrollmentdenial1);
        } catch (Exception exception) {
            fail(exception.getMessage());
        }
    }
}
