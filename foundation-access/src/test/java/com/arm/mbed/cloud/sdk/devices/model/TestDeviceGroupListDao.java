// This file was generated by the Pelion SDK foundation code generator.
// This is an autogenerated unit test class. Do not modify its content as modifications will be lost at next code generation.
package com.arm.mbed.cloud.sdk.devices.model;

import static org.junit.Assert.*;

import org.junit.Test;

/**
 * Unit tests for Model DeviceGroupListDao.
 */
@SuppressWarnings("PMD.AvoidDuplicateLiterals")
public class TestDeviceGroupListDao {
    /**
     * Tests the clone method.
     */
    @SuppressWarnings("resource")
    @Test
    public void testClone() {
        try {
            DeviceGroupListDao devicegrouplistdao1 = new DeviceGroupListDao();
            DeviceGroupListDao devicegrouplistdao2 = devicegrouplistdao1.clone();
            assertNotNull(devicegrouplistdao1);
            assertNotNull(devicegrouplistdao2);
            assertNotSame(devicegrouplistdao2, devicegrouplistdao1);
            assertEquals(devicegrouplistdao2, devicegrouplistdao1);
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
            DeviceGroupListDao devicegrouplistdao1 = new DeviceGroupListDao();
            DeviceGroupListDao devicegrouplistdao2 = new DeviceGroupListDao();
            assertNotNull(devicegrouplistdao1);
            assertNotNull(devicegrouplistdao2);
            assertNotSame(devicegrouplistdao2, devicegrouplistdao1);
            assertEquals(devicegrouplistdao2, devicegrouplistdao1);
            assertEquals(devicegrouplistdao2.hashCode(), devicegrouplistdao1.hashCode());
            int hashCode = devicegrouplistdao1.hashCode();
            for (int i = 0; i < 5; i++) {
                assertEquals(hashCode, devicegrouplistdao1.hashCode());
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
            DeviceGroupListDao devicegrouplistdao1 = new DeviceGroupListDao();
            DeviceGroupListDao devicegrouplistdao2 = new DeviceGroupListDao();
            assertNotNull(devicegrouplistdao1);
            assertNotNull(devicegrouplistdao2);
            assertNotSame(devicegrouplistdao2, devicegrouplistdao1);
            assertEquals(devicegrouplistdao2, devicegrouplistdao1);
            assertEquals(devicegrouplistdao2, devicegrouplistdao1);
            assertEquals(devicegrouplistdao1, devicegrouplistdao2);
            assertEquals(devicegrouplistdao1, devicegrouplistdao1);
            assertFalse(devicegrouplistdao1.equals(null));
        } catch (Exception exception) {
            fail(exception.getMessage());
        }
    }
}
