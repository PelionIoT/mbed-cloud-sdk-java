// This file was generated by the Pelion SDK foundation code generator.
// This is an autogenerated unit test class. Do not modify its content as modifications will be lost at next code generation.
package com.arm.mbed.cloud.sdk.devices.model;

import static org.junit.Assert.*;

import org.junit.Test;

/**
 * Unit tests for Model DeviceEnrollmentBulkCreateStatus.
 */
@SuppressWarnings("PMD.AvoidDuplicateLiterals")
public class TestDeviceEnrollmentBulkCreateStatus {
    /**
     * Tests the getValue method.
     */
    @SuppressWarnings("resource")
    @Test
    public void testGetValue() {
        try {
            DeviceEnrollmentBulkCreateStatus deviceenrollmentbulkcreatestatus = DeviceEnrollmentBulkCreateStatus.getValue(null);
            assertNotNull(deviceenrollmentbulkcreatestatus);
            assertTrue(deviceenrollmentbulkcreatestatus.isDefault());
            deviceenrollmentbulkcreatestatus = DeviceEnrollmentBulkCreateStatus.getValue(DeviceEnrollmentBulkCreateStatus.getDefault()
                                                                                                                         .getString());
            assertNotNull(deviceenrollmentbulkcreatestatus);
            assertTrue(deviceenrollmentbulkcreatestatus.isDefault());
            deviceenrollmentbulkcreatestatus = DeviceEnrollmentBulkCreateStatus.getValue("COMPLETED");
            assertNotNull(deviceenrollmentbulkcreatestatus);
            assertTrue(deviceenrollmentbulkcreatestatus.isDefault());
            deviceenrollmentbulkcreatestatus = DeviceEnrollmentBulkCreateStatus.getValue("new");
            assertNotNull(deviceenrollmentbulkcreatestatus);
            assertFalse(deviceenrollmentbulkcreatestatus.isDefault());
            deviceenrollmentbulkcreatestatus = DeviceEnrollmentBulkCreateStatus.getValue("c55c792f-d0c2-4362-9d29-2db9d19a2586");
            assertNotNull(deviceenrollmentbulkcreatestatus);
            assertTrue(deviceenrollmentbulkcreatestatus.isDefault());
        } catch (Exception exception) {
            fail(exception.getMessage());
        }
    }
}
