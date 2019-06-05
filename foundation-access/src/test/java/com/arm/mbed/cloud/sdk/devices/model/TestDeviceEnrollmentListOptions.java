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
            DeviceEnrollmentListOptions deviceenrollmentlistoptions1 = new DeviceEnrollmentListOptions(Integer.valueOf(64),
                                                                                                       Long.valueOf(-41),
                                                                                                       Order.getDefault(),
                                                                                                       "a0dec5fd-0dad-49c8-8d9a-3c12da2f3289",
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
            DeviceEnrollmentListOptions deviceenrollmentlistoptions1 = new DeviceEnrollmentListOptions(Integer.valueOf(-76),
                                                                                                       Long.valueOf(42),
                                                                                                       Order.getDefault(),
                                                                                                       "5390e92e-af8c-4b6d-bf02-2aefe3cc3ee8",
                                                                                                       null, null);
            DeviceEnrollmentListOptions deviceenrollmentlistoptions2 = new DeviceEnrollmentListOptions(Integer.valueOf(-76),
                                                                                                       Long.valueOf(42),
                                                                                                       Order.getDefault(),
                                                                                                       "5390e92e-af8c-4b6d-bf02-2aefe3cc3ee8",
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
            DeviceEnrollmentListOptions deviceenrollmentlistoptions1 = new DeviceEnrollmentListOptions(Integer.valueOf(-53),
                                                                                                       Long.valueOf(3),
                                                                                                       Order.getDefault(),
                                                                                                       "7e088268-e035-49d7-a789-cea6fd40f95a",
                                                                                                       null, null);
            DeviceEnrollmentListOptions deviceenrollmentlistoptions2 = new DeviceEnrollmentListOptions(Integer.valueOf(-53),
                                                                                                       Long.valueOf(3),
                                                                                                       Order.getDefault(),
                                                                                                       "7e088268-e035-49d7-a789-cea6fd40f95a",
                                                                                                       null, null);
            DeviceEnrollmentListOptions deviceenrollmentlistoptions3 = new DeviceEnrollmentListOptions(Integer.valueOf(83),
                                                                                                       Long.valueOf(117),
                                                                                                       Order.getDefault(),
                                                                                                       "8a4a41bc-6253-4b18-91fd-b2bbd9b4a30d",
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
