// This file was generated by the Pelion SDK foundation code generator.
// This is an autogenerated unit test class. Do not modify its content as modifications will be lost at next code generation.
package com.arm.mbed.cloud.sdk.devices.model;

import static org.junit.Assert.*;

import java.util.Date;
import org.junit.Test;

/**
 * Unit tests for Model DeviceEnrollmentBulkCreate.
 */
@SuppressWarnings("PMD.AvoidDuplicateLiterals")
public class TestDeviceEnrollmentBulkCreate {
    /**
     * Tests the clone method.
     */
    @SuppressWarnings("resource")
    @Test
    public void testClone() {
        try {
            DeviceEnrollmentBulkCreate deviceenrollmentbulkcreate1 = new DeviceEnrollmentBulkCreate("85018e64-60c7-47a2-aa08-8840bd0affc3",
                                                                                                    new Date(1552426066084L),
                                                                                                    new Date(1552426067425L),
                                                                                                    -86,
                                                                                                    "32b5236e-40d5-46d2-899a-65b279ad3f98",
                                                                                                    "b941f5a9-196b-4191-b544-93cda6d6861e",
                                                                                                    "9MLa1qWC25baNrB814fmo689Zzok4lav",
                                                                                                    -83,
                                                                                                    DeviceEnrollmentBulkCreateStatus.getDefault(),
                                                                                                    -73);
            DeviceEnrollmentBulkCreate deviceenrollmentbulkcreate2 = deviceenrollmentbulkcreate1.clone();
            assertNotNull(deviceenrollmentbulkcreate1);
            assertNotNull(deviceenrollmentbulkcreate2);
            assertNotSame(deviceenrollmentbulkcreate2, deviceenrollmentbulkcreate1);
            assertEquals(deviceenrollmentbulkcreate2, deviceenrollmentbulkcreate1);
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
            DeviceEnrollmentBulkCreate deviceenrollmentbulkcreate1 = new DeviceEnrollmentBulkCreate("744c230e-3ba7-4502-914a-7e1beb1a0dbd",
                                                                                                    new Date(1552426063975L),
                                                                                                    new Date(1552426066314L),
                                                                                                    -53,
                                                                                                    "b4597677-83ac-44db-9328-0b4f442a4174",
                                                                                                    "e3878fc4-7109-4fa8-9e1c-0859a089bafc",
                                                                                                    "YQten44rfdF7tul0B1W76Bv190k80VrH",
                                                                                                    -62,
                                                                                                    DeviceEnrollmentBulkCreateStatus.getDefault(),
                                                                                                    41);
            DeviceEnrollmentBulkCreate deviceenrollmentbulkcreate2 = new DeviceEnrollmentBulkCreate("744c230e-3ba7-4502-914a-7e1beb1a0dbd",
                                                                                                    new Date(1552426063975L),
                                                                                                    new Date(1552426066314L),
                                                                                                    -53,
                                                                                                    "b4597677-83ac-44db-9328-0b4f442a4174",
                                                                                                    "e3878fc4-7109-4fa8-9e1c-0859a089bafc",
                                                                                                    "YQten44rfdF7tul0B1W76Bv190k80VrH",
                                                                                                    -62,
                                                                                                    DeviceEnrollmentBulkCreateStatus.getDefault(),
                                                                                                    41);
            assertNotNull(deviceenrollmentbulkcreate1);
            assertNotNull(deviceenrollmentbulkcreate2);
            assertNotSame(deviceenrollmentbulkcreate2, deviceenrollmentbulkcreate1);
            assertEquals(deviceenrollmentbulkcreate2, deviceenrollmentbulkcreate1);
            assertEquals(deviceenrollmentbulkcreate2.hashCode(), deviceenrollmentbulkcreate1.hashCode());
            int hashCode = deviceenrollmentbulkcreate1.hashCode();
            for (int i = 0; i < 5; i++) {
                assertEquals(hashCode, deviceenrollmentbulkcreate1.hashCode());
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
        DeviceEnrollmentBulkCreate deviceenrollmentbulkcreate = new DeviceEnrollmentBulkCreate("c60671fc-ce6e-4c95-8c5a-335d2d5b4a81",
                                                                                               new Date(1552426063676L),
                                                                                               new Date(1552426069088L),
                                                                                               -1,
                                                                                               "28e6f692-ea1e-4aa8-87a6-1e20d01d6783",
                                                                                               "0d3485e1-a7c6-4d3d-839a-0c6beba67538",
                                                                                               "Qc1w4BXWV0wvl060sxm5H5IB54hXN4kN",
                                                                                               -54,
                                                                                               DeviceEnrollmentBulkCreateStatus.getDefault(),
                                                                                               -51);
        assertTrue(deviceenrollmentbulkcreate.isValid());
        DeviceEnrollmentBulkCreate deviceenrollmentbulkcreateInvalid = new DeviceEnrollmentBulkCreate("48156836-8f22-42f7-afe5-b885a31cefff",
                                                                                                      new Date(1552426069025L),
                                                                                                      new Date(1552426070004L),
                                                                                                      -97,
                                                                                                      "edbe6351-dda7-4969-a21a-a0f4a44b3852",
                                                                                                      "265285f9-83e4-4f5a-968d-dc8965e91283",
                                                                                                      "Pvpwi:Gwf&vCr>55GW5IECEᚾh`E:vX3EJjU�?�k5=E3W<UvPv;3jJwUwG쇌\\\\I5CJG",
                                                                                                      13,
                                                                                                      DeviceEnrollmentBulkCreateStatus.getDefault(),
                                                                                                      -56);
        assertFalse(deviceenrollmentbulkcreateInvalid.isValid());
    }

    /**
     * Tests the equals method.
     */
    @SuppressWarnings("resource")
    @Test
    public void testEquals() {
        try {
            DeviceEnrollmentBulkCreate deviceenrollmentbulkcreate1 = new DeviceEnrollmentBulkCreate("ca984dad-890b-43cf-a06a-342de962ed09",
                                                                                                    new Date(1552426066981L),
                                                                                                    new Date(1552426069985L),
                                                                                                    -81,
                                                                                                    "50e8ca5d-dd6d-4766-bfed-0ef5a53038f7",
                                                                                                    "6450b4ff-f59a-456d-aa7b-0cc200a7d068",
                                                                                                    "ur15hUHZ0067aD2v195JE6K2k9pUkvd7",
                                                                                                    42,
                                                                                                    DeviceEnrollmentBulkCreateStatus.getDefault(),
                                                                                                    -78);
            DeviceEnrollmentBulkCreate deviceenrollmentbulkcreate2 = new DeviceEnrollmentBulkCreate("ca984dad-890b-43cf-a06a-342de962ed09",
                                                                                                    new Date(1552426066981L),
                                                                                                    new Date(1552426069985L),
                                                                                                    -81,
                                                                                                    "50e8ca5d-dd6d-4766-bfed-0ef5a53038f7",
                                                                                                    "6450b4ff-f59a-456d-aa7b-0cc200a7d068",
                                                                                                    "ur15hUHZ0067aD2v195JE6K2k9pUkvd7",
                                                                                                    42,
                                                                                                    DeviceEnrollmentBulkCreateStatus.getDefault(),
                                                                                                    -78);
            DeviceEnrollmentBulkCreate deviceenrollmentbulkcreate3 = new DeviceEnrollmentBulkCreate("ec259ad7-4345-4c4f-ab04-c30e87ede231",
                                                                                                    new Date(1552426072861L),
                                                                                                    new Date(1552426066356L),
                                                                                                    7,
                                                                                                    "7f2a370b-95ac-4f3c-81f1-197d2ebf9317",
                                                                                                    "c20f89b2-ae54-4971-94c7-7915e3274494",
                                                                                                    "IhAgbJfwnhC4snJ9R9ftqjz36gD533Il",
                                                                                                    38,
                                                                                                    DeviceEnrollmentBulkCreateStatus.getDefault(),
                                                                                                    71);
            assertNotNull(deviceenrollmentbulkcreate1);
            assertNotNull(deviceenrollmentbulkcreate2);
            assertNotNull(deviceenrollmentbulkcreate3);
            assertNotSame(deviceenrollmentbulkcreate2, deviceenrollmentbulkcreate1);
            assertNotSame(deviceenrollmentbulkcreate3, deviceenrollmentbulkcreate1);
            assertEquals(deviceenrollmentbulkcreate2, deviceenrollmentbulkcreate1);
            assertEquals(deviceenrollmentbulkcreate2, deviceenrollmentbulkcreate1);
            assertEquals(deviceenrollmentbulkcreate1, deviceenrollmentbulkcreate2);
            assertEquals(deviceenrollmentbulkcreate1, deviceenrollmentbulkcreate1);
            assertFalse(deviceenrollmentbulkcreate1.equals(null));
            assertNotEquals(deviceenrollmentbulkcreate3, deviceenrollmentbulkcreate1);
        } catch (Exception exception) {
            fail(exception.getMessage());
        }
    }
}
