// This file was generated by the Pelion SDK foundation code generator.
// This is an autogenerated unit test class. Do not modify its content as modifications will be lost at next code generation.
package com.arm.mbed.cloud.sdk.deviceupdate.model;

import static org.junit.Assert.*;

import org.junit.Test;

/**
 * Unit tests for Model FirmwareImageListDao.
 */
@SuppressWarnings("PMD.AvoidDuplicateLiterals")
public class TestFirmwareImageListDao {
    /**
     * Tests the clone method.
     */
    @SuppressWarnings("resource")
    @Test
    public void testClone() {
        try {
            FirmwareImageListDao firmwareimagelistdao1 = new FirmwareImageListDao();
            FirmwareImageListDao firmwareimagelistdao2 = firmwareimagelistdao1.clone();
            assertNotNull(firmwareimagelistdao1);
            assertNotNull(firmwareimagelistdao2);
            assertNotSame(firmwareimagelistdao2, firmwareimagelistdao1);
            assertEquals(firmwareimagelistdao2, firmwareimagelistdao1);
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
            FirmwareImageListDao firmwareimagelistdao1 = new FirmwareImageListDao();
            FirmwareImageListDao firmwareimagelistdao2 = new FirmwareImageListDao();
            assertNotNull(firmwareimagelistdao1);
            assertNotNull(firmwareimagelistdao2);
            assertNotSame(firmwareimagelistdao2, firmwareimagelistdao1);
            assertEquals(firmwareimagelistdao2, firmwareimagelistdao1);
            assertEquals(firmwareimagelistdao2.hashCode(), firmwareimagelistdao1.hashCode());
            int hashCode = firmwareimagelistdao1.hashCode();
            for (int i = 0; i < 5; i++) {
                assertEquals(hashCode, firmwareimagelistdao1.hashCode());
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
            FirmwareImageListDao firmwareimagelistdao1 = new FirmwareImageListDao();
            FirmwareImageListDao firmwareimagelistdao2 = new FirmwareImageListDao();
            assertNotNull(firmwareimagelistdao1);
            assertNotNull(firmwareimagelistdao2);
            assertNotSame(firmwareimagelistdao2, firmwareimagelistdao1);
            assertEquals(firmwareimagelistdao2, firmwareimagelistdao1);
            assertEquals(firmwareimagelistdao2, firmwareimagelistdao1);
            assertEquals(firmwareimagelistdao1, firmwareimagelistdao2);
            assertEquals(firmwareimagelistdao1, firmwareimagelistdao1);
            assertFalse(firmwareimagelistdao1.equals(null));
        } catch (Exception exception) {
            fail(exception.getMessage());
        }
    }
}
