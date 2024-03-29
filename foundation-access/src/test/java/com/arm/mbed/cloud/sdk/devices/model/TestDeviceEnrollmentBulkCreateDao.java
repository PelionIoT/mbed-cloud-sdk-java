// This file was generated by the Pelion SDK foundation code generator.
// This unit test suite was autogenerated on Fri Jan 11 00:36:38 GMT 2019. Feel free to change its contents as you wish.
package com.arm.mbed.cloud.sdk.devices.model;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNotSame;
import static org.junit.Assert.fail;

import org.junit.Test;

/**
 * Unit tests for Model DeviceEnrollmentBulkCreateDao.
 */
public class TestDeviceEnrollmentBulkCreateDao {
    /**
     * Tests the clone method.
     */
    @SuppressWarnings("resource")
    @Test
    public void testClone() {
        try {
            DeviceEnrollmentBulkCreateDao deviceenrollmentbulkcreatedao1 = new DeviceEnrollmentBulkCreateDao();
            DeviceEnrollmentBulkCreateDao deviceenrollmentbulkcreatedao2 = deviceenrollmentbulkcreatedao1.clone();
            assertNotNull(deviceenrollmentbulkcreatedao1);
            assertNotNull(deviceenrollmentbulkcreatedao2);
            assertNotSame(deviceenrollmentbulkcreatedao2, deviceenrollmentbulkcreatedao1);
            assertEquals(deviceenrollmentbulkcreatedao2, deviceenrollmentbulkcreatedao1);
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
            DeviceEnrollmentBulkCreateDao deviceenrollmentbulkcreatedao1 = new DeviceEnrollmentBulkCreateDao();
            DeviceEnrollmentBulkCreateDao deviceenrollmentbulkcreatedao2 = new DeviceEnrollmentBulkCreateDao();
            assertNotNull(deviceenrollmentbulkcreatedao1);
            assertNotNull(deviceenrollmentbulkcreatedao2);
            assertNotSame(deviceenrollmentbulkcreatedao2, deviceenrollmentbulkcreatedao1);
            assertEquals(deviceenrollmentbulkcreatedao2, deviceenrollmentbulkcreatedao1);
            assertEquals(deviceenrollmentbulkcreatedao2.hashCode(), deviceenrollmentbulkcreatedao1.hashCode());
            int hashCode = deviceenrollmentbulkcreatedao1.hashCode();
            for (int i = 0; i < 5; i++) {
                assertEquals(hashCode, deviceenrollmentbulkcreatedao1.hashCode());
            }
        } catch (Exception exception) {
            fail(exception.getMessage());
        }
    }

    /**
     * Tests the equals method.
     */
    @SuppressWarnings("resource")
    @Test
    public void testEquals() {
        try {
            DeviceEnrollmentBulkCreateDao deviceenrollmentbulkcreatedao1 = new DeviceEnrollmentBulkCreateDao();
            DeviceEnrollmentBulkCreateDao deviceenrollmentbulkcreatedao2 = new DeviceEnrollmentBulkCreateDao();
            assertNotNull(deviceenrollmentbulkcreatedao1);
            assertNotNull(deviceenrollmentbulkcreatedao2);
            assertNotSame(deviceenrollmentbulkcreatedao2, deviceenrollmentbulkcreatedao1);
            assertEquals(deviceenrollmentbulkcreatedao2, deviceenrollmentbulkcreatedao1);
            assertEquals(deviceenrollmentbulkcreatedao2, deviceenrollmentbulkcreatedao1);
            assertEquals(deviceenrollmentbulkcreatedao1, deviceenrollmentbulkcreatedao2);
            assertEquals(deviceenrollmentbulkcreatedao1, deviceenrollmentbulkcreatedao1);
            assertFalse(deviceenrollmentbulkcreatedao1.equals(null));
        } catch (Exception exception) {
            fail(exception.getMessage());
        }
    }
}
