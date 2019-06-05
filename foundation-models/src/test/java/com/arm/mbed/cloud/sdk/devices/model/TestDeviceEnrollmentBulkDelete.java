// This file was generated by the Pelion SDK foundation code generator.
// This is an autogenerated unit test class. Do not modify its content as modifications will be lost at next code generation.
package com.arm.mbed.cloud.sdk.devices.model;

import static org.junit.Assert.*;

import java.util.Date;
import org.junit.Test;

/**
 * Unit tests for Model DeviceEnrollmentBulkDelete.
 */
@SuppressWarnings("PMD.AvoidDuplicateLiterals")
public class TestDeviceEnrollmentBulkDelete {
    /**
     * Tests the clone method.
     */
    @SuppressWarnings("resource")
    @Test
    public void testClone() {
        try {
            DeviceEnrollmentBulkDelete deviceenrollmentbulkdelete1 = new DeviceEnrollmentBulkDelete("2118420b-cd5b-4442-b11b-499cb7f9d5b4",
                                                                                                    new Date(1559747932556L),
                                                                                                    new Date(1559747927704L),
                                                                                                    -34,
                                                                                                    "e0d56262-1365-404d-99c4-670f43f843d1",
                                                                                                    "7d77018b-b3c7-4b1b-97a2-8313457b78dd",
                                                                                                    "oVX9Z9Y5IdJpQ49dLNocXs8qsRNw8R8e",
                                                                                                    107,
                                                                                                    DeviceEnrollmentBulkDeleteStatus.getDefault(),
                                                                                                    39);
            DeviceEnrollmentBulkDelete deviceenrollmentbulkdelete2 = deviceenrollmentbulkdelete1.clone();
            assertNotNull(deviceenrollmentbulkdelete1);
            assertNotNull(deviceenrollmentbulkdelete2);
            assertNotSame(deviceenrollmentbulkdelete2, deviceenrollmentbulkdelete1);
            assertEquals(deviceenrollmentbulkdelete2, deviceenrollmentbulkdelete1);
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
            DeviceEnrollmentBulkDelete deviceenrollmentbulkdelete1 = new DeviceEnrollmentBulkDelete("7b5fb3a4-dc79-484e-ae79-5d5abbd05879",
                                                                                                    new Date(1559747930969L),
                                                                                                    new Date(1559747925769L),
                                                                                                    -1,
                                                                                                    "a85d562b-5831-4f43-a228-e3e23ea53dda",
                                                                                                    "b66428f2-5f1f-467b-89c7-8e0ff357183d",
                                                                                                    "oVX9Z9Y5IdJpQ49dLNocXs8qsRNw8R8e",
                                                                                                    90,
                                                                                                    DeviceEnrollmentBulkDeleteStatus.getDefault(),
                                                                                                    4);
            DeviceEnrollmentBulkDelete deviceenrollmentbulkdelete2 = new DeviceEnrollmentBulkDelete("7b5fb3a4-dc79-484e-ae79-5d5abbd05879",
                                                                                                    new Date(1559747930969L),
                                                                                                    new Date(1559747925769L),
                                                                                                    -1,
                                                                                                    "a85d562b-5831-4f43-a228-e3e23ea53dda",
                                                                                                    "b66428f2-5f1f-467b-89c7-8e0ff357183d",
                                                                                                    "oVX9Z9Y5IdJpQ49dLNocXs8qsRNw8R8e",
                                                                                                    90,
                                                                                                    DeviceEnrollmentBulkDeleteStatus.getDefault(),
                                                                                                    4);
            assertNotNull(deviceenrollmentbulkdelete1);
            assertNotNull(deviceenrollmentbulkdelete2);
            assertNotSame(deviceenrollmentbulkdelete2, deviceenrollmentbulkdelete1);
            assertEquals(deviceenrollmentbulkdelete2, deviceenrollmentbulkdelete1);
            assertEquals(deviceenrollmentbulkdelete2.hashCode(), deviceenrollmentbulkdelete1.hashCode());
            int hashCode = deviceenrollmentbulkdelete1.hashCode();
            for (int i = 0; i < 5; i++) {
                assertEquals(hashCode, deviceenrollmentbulkdelete1.hashCode());
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
        DeviceEnrollmentBulkDelete deviceenrollmentbulkdelete = new DeviceEnrollmentBulkDelete("01069cd2-c6db-4f3a-8d8e-8ab5a4e58303",
                                                                                               new Date(1559747931707L),
                                                                                               new Date(1559747929438L),
                                                                                               -89,
                                                                                               "0e5ca25e-9452-4b0c-b6e9-90fb2c12b1dc",
                                                                                               "4682b48b-a6a4-4cc0-aa92-725e967a1bec",
                                                                                               "oVX9Z9Y5IdJpQ49dLNocXs8qsRNw8R8e",
                                                                                               -36,
                                                                                               DeviceEnrollmentBulkDeleteStatus.getDefault(),
                                                                                               32);
        assertTrue(deviceenrollmentbulkdelete.isValid());
        DeviceEnrollmentBulkDelete deviceenrollmentbulkdeleteInvalid = new DeviceEnrollmentBulkDelete("eca3a466-a66c-423f-ad85-d6a2a9476753",
                                                                                                      new Date(1559747932759L),
                                                                                                      new Date(1559747929701L),
                                                                                                      72,
                                                                                                      "6f364192-5e95-4dd4-bd91-0f88adffd57a",
                                                                                                      "a2821664-0b00-42f2-89e3-aabc9747d25b",
                                                                                                      "7?Sv7Wr717KrgfUKP6൦6vKK\u0018KMjr퉹㶣?6l欿h@mO[킄ESvW窠7r\fTWn噅arP7v\u0013tKPSM",
                                                                                                      74,
                                                                                                      DeviceEnrollmentBulkDeleteStatus.getDefault(),
                                                                                                      67);
        assertFalse(deviceenrollmentbulkdeleteInvalid.isValid());
    }

    /**
     * Tests the equals method.
     */
    @SuppressWarnings("resource")
    @Test
    public void testEquals() {
        try {
            DeviceEnrollmentBulkDelete deviceenrollmentbulkdelete1 = new DeviceEnrollmentBulkDelete("adac73e1-5064-49c5-b44f-418cc6bc0505",
                                                                                                    new Date(1559747932340L),
                                                                                                    new Date(1559747935088L),
                                                                                                    -91,
                                                                                                    "dcf0d077-c322-4ab4-978c-e4073267c38b",
                                                                                                    "ec9294d7-01ca-4596-8b34-eb32ea7d5455",
                                                                                                    "oVX9Z9Y5IdJpQ49dLNocXs8qsRNw8R8e",
                                                                                                    -114,
                                                                                                    DeviceEnrollmentBulkDeleteStatus.getDefault(),
                                                                                                    72);
            DeviceEnrollmentBulkDelete deviceenrollmentbulkdelete2 = new DeviceEnrollmentBulkDelete("adac73e1-5064-49c5-b44f-418cc6bc0505",
                                                                                                    new Date(1559747932340L),
                                                                                                    new Date(1559747935088L),
                                                                                                    -91,
                                                                                                    "dcf0d077-c322-4ab4-978c-e4073267c38b",
                                                                                                    "ec9294d7-01ca-4596-8b34-eb32ea7d5455",
                                                                                                    "oVX9Z9Y5IdJpQ49dLNocXs8qsRNw8R8e",
                                                                                                    -114,
                                                                                                    DeviceEnrollmentBulkDeleteStatus.getDefault(),
                                                                                                    72);
            DeviceEnrollmentBulkDelete deviceenrollmentbulkdelete3 = new DeviceEnrollmentBulkDelete("a0537521-d481-464b-8254-e413e416a2a1",
                                                                                                    new Date(1559747925673L),
                                                                                                    new Date(1559747933918L),
                                                                                                    95,
                                                                                                    "d7900147-06d7-48c5-8f90-ccf23a377226",
                                                                                                    "647dc7cc-dda2-4007-86b1-6168a01a5c41",
                                                                                                    "oVX9Z9Y5IdJpQ49dLNocXs8qsRNw8R8e",
                                                                                                    -27,
                                                                                                    DeviceEnrollmentBulkDeleteStatus.getDefault(),
                                                                                                    -38);
            assertNotNull(deviceenrollmentbulkdelete1);
            assertNotNull(deviceenrollmentbulkdelete2);
            assertNotNull(deviceenrollmentbulkdelete3);
            assertNotSame(deviceenrollmentbulkdelete2, deviceenrollmentbulkdelete1);
            assertNotSame(deviceenrollmentbulkdelete3, deviceenrollmentbulkdelete1);
            assertEquals(deviceenrollmentbulkdelete2, deviceenrollmentbulkdelete1);
            assertEquals(deviceenrollmentbulkdelete2, deviceenrollmentbulkdelete1);
            assertEquals(deviceenrollmentbulkdelete1, deviceenrollmentbulkdelete2);
            assertEquals(deviceenrollmentbulkdelete1, deviceenrollmentbulkdelete1);
            assertFalse(deviceenrollmentbulkdelete1.equals(null));
            assertNotEquals(deviceenrollmentbulkdelete3, deviceenrollmentbulkdelete1);
        } catch (Exception exception) {
            fail(exception.getMessage());
        }
    }
}
