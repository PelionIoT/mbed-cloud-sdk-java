// This file was generated by the Pelion SDK foundation code generator.
// This is an autogenerated unit test class. Do not modify its content as modifications will be lost at next code generation.
package com.arm.mbed.cloud.sdk.devices.model;

import static org.junit.Assert.*;

import com.arm.mbed.cloud.sdk.common.Order;
import org.junit.Test;

/**
 * Unit tests for Model DeviceEnrollmentListOptions.
 */
@SuppressWarnings("PMD.AvoidDuplicateLiterals")
public class TestDeviceEnrollmentListOptions {
    /**
     * Tests the clone method.
     */
    @SuppressWarnings("resource")
    @Test
    public void testClone() {
        try {
            DeviceEnrollmentListOptions deviceenrollmentlistoptions1 = new DeviceEnrollmentListOptions(Integer.valueOf(118),
                                                                                                       Long.valueOf(45),
                                                                                                       Order.getDefault(),
                                                                                                       "7130493e-281c-46c1-b4f9-034e1c91f987",
                                                                                                       null, null);
            DeviceEnrollmentListOptions deviceenrollmentlistoptions2 = deviceenrollmentlistoptions1.clone();
            assertNotNull(deviceenrollmentlistoptions1);
            assertNotNull(deviceenrollmentlistoptions2);
            assertNotSame(deviceenrollmentlistoptions2, deviceenrollmentlistoptions1);
            assertEquals(deviceenrollmentlistoptions2, deviceenrollmentlistoptions1);
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
            DeviceEnrollmentListOptions deviceenrollmentlistoptions1 = new DeviceEnrollmentListOptions(Integer.valueOf(-96),
                                                                                                       Long.valueOf(10),
                                                                                                       Order.getDefault(),
                                                                                                       "f24f62f6-4cd4-4a67-b7fc-e304ddef2e1e",
                                                                                                       null, null);
            DeviceEnrollmentListOptions deviceenrollmentlistoptions2 = new DeviceEnrollmentListOptions(Integer.valueOf(-96),
                                                                                                       Long.valueOf(10),
                                                                                                       Order.getDefault(),
                                                                                                       "f24f62f6-4cd4-4a67-b7fc-e304ddef2e1e",
                                                                                                       null, null);
            assertNotNull(deviceenrollmentlistoptions1);
            assertNotNull(deviceenrollmentlistoptions2);
            assertNotSame(deviceenrollmentlistoptions2, deviceenrollmentlistoptions1);
            assertEquals(deviceenrollmentlistoptions2, deviceenrollmentlistoptions1);
            assertEquals(deviceenrollmentlistoptions2.hashCode(), deviceenrollmentlistoptions1.hashCode());
            int hashCode = deviceenrollmentlistoptions1.hashCode();
            for (int i = 0; i < 5; i++) {
                assertEquals(hashCode, deviceenrollmentlistoptions1.hashCode());
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
            DeviceEnrollmentListOptions deviceenrollmentlistoptions1 = new DeviceEnrollmentListOptions(Integer.valueOf(-36),
                                                                                                       Long.valueOf(76),
                                                                                                       Order.getDefault(),
                                                                                                       "861170ed-6e9f-4fc3-8f0b-3cb4ef5ae6b1",
                                                                                                       null, null);
            DeviceEnrollmentListOptions deviceenrollmentlistoptions2 = new DeviceEnrollmentListOptions(Integer.valueOf(-36),
                                                                                                       Long.valueOf(76),
                                                                                                       Order.getDefault(),
                                                                                                       "861170ed-6e9f-4fc3-8f0b-3cb4ef5ae6b1",
                                                                                                       null, null);
            DeviceEnrollmentListOptions deviceenrollmentlistoptions3 = new DeviceEnrollmentListOptions(Integer.valueOf(-38),
                                                                                                       Long.valueOf(-109),
                                                                                                       Order.getDefault(),
                                                                                                       "fbbb9871-1500-455b-94d6-6aab6291a5de",
                                                                                                       null, null);
            assertNotNull(deviceenrollmentlistoptions1);
            assertNotNull(deviceenrollmentlistoptions2);
            assertNotNull(deviceenrollmentlistoptions3);
            assertNotSame(deviceenrollmentlistoptions2, deviceenrollmentlistoptions1);
            assertNotSame(deviceenrollmentlistoptions3, deviceenrollmentlistoptions1);
            assertEquals(deviceenrollmentlistoptions2, deviceenrollmentlistoptions1);
            assertEquals(deviceenrollmentlistoptions2, deviceenrollmentlistoptions1);
            assertEquals(deviceenrollmentlistoptions1, deviceenrollmentlistoptions2);
            assertEquals(deviceenrollmentlistoptions1, deviceenrollmentlistoptions1);
            assertFalse(deviceenrollmentlistoptions1.equals(null));
            assertNotEquals(deviceenrollmentlistoptions3, deviceenrollmentlistoptions1);
        } catch (Exception exception) {
            fail(exception.getMessage());
        }
    }
}
