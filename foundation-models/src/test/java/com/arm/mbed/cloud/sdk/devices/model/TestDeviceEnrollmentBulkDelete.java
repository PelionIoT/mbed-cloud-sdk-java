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
            DeviceEnrollmentBulkDelete deviceenrollmentbulkdelete1 = new DeviceEnrollmentBulkDelete("78685d4c-309b-4e78-adb8-e003bb6fda5b",
                                                                                                    new Date(1559754639302L),
                                                                                                    new Date(1559754637228L),
                                                                                                    -39,
                                                                                                    "fa89aa36-abc0-493c-b665-39def6fdad28",
                                                                                                    "165b912d-719c-428f-9ad7-d357ba9c19b5",
                                                                                                    "DFB4FcMOcZ21RxT197XnA09458e3hq5Z",
                                                                                                    -14,
                                                                                                    DeviceEnrollmentBulkDeleteStatus.getDefault(),
                                                                                                    -105);
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
            DeviceEnrollmentBulkDelete deviceenrollmentbulkdelete1 = new DeviceEnrollmentBulkDelete("4cd9285c-a311-4f31-a02f-e158c3935754",
                                                                                                    new Date(1559754639187L),
                                                                                                    new Date(1559754639116L),
                                                                                                    76,
                                                                                                    "464c43c3-2768-467d-bfc0-773546825331",
                                                                                                    "72dfddef-adf6-4f2a-8e8e-954648693576",
                                                                                                    "DFB4FcMOcZ21RxT197XnA09458e3hq5Z",
                                                                                                    -58,
                                                                                                    DeviceEnrollmentBulkDeleteStatus.getDefault(),
                                                                                                    36);
            DeviceEnrollmentBulkDelete deviceenrollmentbulkdelete2 = new DeviceEnrollmentBulkDelete("4cd9285c-a311-4f31-a02f-e158c3935754",
                                                                                                    new Date(1559754639187L),
                                                                                                    new Date(1559754639116L),
                                                                                                    76,
                                                                                                    "464c43c3-2768-467d-bfc0-773546825331",
                                                                                                    "72dfddef-adf6-4f2a-8e8e-954648693576",
                                                                                                    "DFB4FcMOcZ21RxT197XnA09458e3hq5Z",
                                                                                                    -58,
                                                                                                    DeviceEnrollmentBulkDeleteStatus.getDefault(),
                                                                                                    36);
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
        DeviceEnrollmentBulkDelete deviceenrollmentbulkdelete = new DeviceEnrollmentBulkDelete("146c0bad-8dac-4007-b0b5-5e2cb7766640",
                                                                                               new Date(1559754635917L),
                                                                                               new Date(1559754636793L),
                                                                                               88,
                                                                                               "67d8f939-5346-4485-9b56-aa41a1474a9a",
                                                                                               "4a8915d5-fea8-4d8c-8e9b-5cb3b5f957f9",
                                                                                               "DFB4FcMOcZ21RxT197XnA09458e3hq5Z",
                                                                                               41,
                                                                                               DeviceEnrollmentBulkDeleteStatus.getDefault(),
                                                                                               -121);
        assertTrue(deviceenrollmentbulkdelete.isValid());
        DeviceEnrollmentBulkDelete deviceenrollmentbulkdeleteInvalid = new DeviceEnrollmentBulkDelete("80ecb8b3-a649-4325-94be-a37b8e712cae",
                                                                                                      new Date(1559754640993L),
                                                                                                      new Date(1559754643816L),
                                                                                                      -111,
                                                                                                      "573bf78f-f2a8-445b-9d6f-b0704c271653",
                                                                                                      "f9dd3072-f9fc-43f7-b0a6-febb3aa068ff",
                                                                                                      "6CpJEiNaQdUsPjCSKC`Sg6p6kYKC䕃g୯꯯dGQklCWpCCiQNs`GpEtddEPNCgEf!6ES",
                                                                                                      -16,
                                                                                                      DeviceEnrollmentBulkDeleteStatus.getDefault(),
                                                                                                      92);
        assertFalse(deviceenrollmentbulkdeleteInvalid.isValid());
    }

    /**
     * Tests the equals method.
     */
    @SuppressWarnings("resource")
    @Test
    public void testEquals() {
        try {
            DeviceEnrollmentBulkDelete deviceenrollmentbulkdelete1 = new DeviceEnrollmentBulkDelete("5ae821a3-4bc7-42c7-a898-aff2e9266b34",
                                                                                                    new Date(1559754642563L),
                                                                                                    new Date(1559754641244L),
                                                                                                    50,
                                                                                                    "589f7fdf-2efd-4283-a226-8842fc11d998",
                                                                                                    "09a51bdf-0b22-40ea-8bf6-d2402d687097",
                                                                                                    "DFB4FcMOcZ21RxT197XnA09458e3hq5Z",
                                                                                                    -115,
                                                                                                    DeviceEnrollmentBulkDeleteStatus.getDefault(),
                                                                                                    113);
            DeviceEnrollmentBulkDelete deviceenrollmentbulkdelete2 = new DeviceEnrollmentBulkDelete("5ae821a3-4bc7-42c7-a898-aff2e9266b34",
                                                                                                    new Date(1559754642563L),
                                                                                                    new Date(1559754641244L),
                                                                                                    50,
                                                                                                    "589f7fdf-2efd-4283-a226-8842fc11d998",
                                                                                                    "09a51bdf-0b22-40ea-8bf6-d2402d687097",
                                                                                                    "DFB4FcMOcZ21RxT197XnA09458e3hq5Z",
                                                                                                    -115,
                                                                                                    DeviceEnrollmentBulkDeleteStatus.getDefault(),
                                                                                                    113);
            DeviceEnrollmentBulkDelete deviceenrollmentbulkdelete3 = new DeviceEnrollmentBulkDelete("8cb6d8df-0f32-4d2a-ade9-d5f3edc62977",
                                                                                                    new Date(1559754644992L),
                                                                                                    new Date(1559754641743L),
                                                                                                    83,
                                                                                                    "f152c488-74a9-4ad5-84cd-e05f4245e4d7",
                                                                                                    "a82852a4-64f4-411b-9bb1-9e0ef1707d43",
                                                                                                    "DFB4FcMOcZ21RxT197XnA09458e3hq5Z",
                                                                                                    100,
                                                                                                    DeviceEnrollmentBulkDeleteStatus.getDefault(),
                                                                                                    -17);
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
