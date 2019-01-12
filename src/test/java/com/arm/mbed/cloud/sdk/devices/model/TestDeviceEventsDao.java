// This file was generated by the Pelion SDK foundation code generator.
// This is an autogenerated unit test class. Do not modify its content as modifications will be lost at next code generation.
package com.arm.mbed.cloud.sdk.devices.model;

import static org.junit.Assert.*;

import org.junit.Test;

/**
 * Unit tests for Model DeviceEventsDao.
 */
public class TestDeviceEventsDao {
    /**
     * Tests the clone method.
     */
    @Test
    public void testClone() {
        try {
            DeviceEventsDao deviceeventsdao1 = new DeviceEventsDao();
            DeviceEventsDao deviceeventsdao2 = deviceeventsdao1.clone();
            assertNotNull(deviceeventsdao1);
            assertNotNull(deviceeventsdao2);
            assertNotSame(deviceeventsdao2, deviceeventsdao1);
            assertEquals(deviceeventsdao2, deviceeventsdao1);
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
            DeviceEventsDao deviceeventsdao1 = new DeviceEventsDao();
            DeviceEventsDao deviceeventsdao2 = new DeviceEventsDao();
            assertNotNull(deviceeventsdao1);
            assertNotNull(deviceeventsdao2);
            assertNotSame(deviceeventsdao2, deviceeventsdao1);
            assertEquals(deviceeventsdao2, deviceeventsdao1);
            assertEquals(deviceeventsdao2.hashCode(), deviceeventsdao1.hashCode());
            int hashCode = deviceeventsdao1.hashCode();
            for (int i = 0; i < 5; i++) {
                assertEquals(hashCode, deviceeventsdao1.hashCode());
            }
        } catch (Exception exception) {
            fail(exception.getMessage());
        }
    }

    /**
     * Tests the equals method.
     */
    @Test
    public void testEquals() {
        try {
            DeviceEventsDao deviceeventsdao1 = new DeviceEventsDao();
            DeviceEventsDao deviceeventsdao2 = new DeviceEventsDao();
            assertNotNull(deviceeventsdao1);
            assertNotNull(deviceeventsdao2);
            assertNotSame(deviceeventsdao2, deviceeventsdao1);
            assertEquals(deviceeventsdao2, deviceeventsdao1);
            assertEquals(deviceeventsdao2, deviceeventsdao1);
            assertEquals(deviceeventsdao1, deviceeventsdao2);
            assertEquals(deviceeventsdao1, deviceeventsdao1);
            assertFalse(deviceeventsdao1.equals(null));
        } catch (Exception exception) {
            fail(exception.getMessage());
        }
    }
}
