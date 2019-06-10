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
            DeviceEnrollmentBulkCreate deviceenrollmentbulkcreate1 = new DeviceEnrollmentBulkCreate("c9893d70-1649-4c96-ab09-9b5b03fece7c",
                                                                                                    new Date(1560172169366L),
                                                                                                    new Date(1560172162201L),
                                                                                                    88,
                                                                                                    "e0df4720-627a-4b05-8193-6880ab121a06",
                                                                                                    "ea7beace-9673-4ce5-a794-25be8d2e233e",
                                                                                                    "s08ndZtfoPJYh434s0zE5i6525f08MX6",
                                                                                                    16,
                                                                                                    DeviceEnrollmentBulkCreateStatus.getDefault(),
                                                                                                    -108);
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
            DeviceEnrollmentBulkCreate deviceenrollmentbulkcreate1 = new DeviceEnrollmentBulkCreate("259768d9-3216-4bf1-98f1-40432febef99",
                                                                                                    new Date(1560172168690L),
                                                                                                    new Date(1560172161527L),
                                                                                                    13,
                                                                                                    "188460e2-127c-4d1a-8885-fbc46224a2ea",
                                                                                                    "9a3df30b-12cf-4e04-a4b1-8743fa35f27f",
                                                                                                    "s08ndZtfoPJYh434s0zE5i6525f08MX6",
                                                                                                    -100,
                                                                                                    DeviceEnrollmentBulkCreateStatus.getDefault(),
                                                                                                    -95);
            DeviceEnrollmentBulkCreate deviceenrollmentbulkcreate2 = new DeviceEnrollmentBulkCreate("259768d9-3216-4bf1-98f1-40432febef99",
                                                                                                    new Date(1560172168690L),
                                                                                                    new Date(1560172161527L),
                                                                                                    13,
                                                                                                    "188460e2-127c-4d1a-8885-fbc46224a2ea",
                                                                                                    "9a3df30b-12cf-4e04-a4b1-8743fa35f27f",
                                                                                                    "s08ndZtfoPJYh434s0zE5i6525f08MX6",
                                                                                                    -100,
                                                                                                    DeviceEnrollmentBulkCreateStatus.getDefault(),
                                                                                                    -95);
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
        DeviceEnrollmentBulkCreate deviceenrollmentbulkcreate = new DeviceEnrollmentBulkCreate("aa94c79d-b0df-4727-adc5-7da07db55888",
                                                                                               new Date(1560172164504L),
                                                                                               new Date(1560172170833L),
                                                                                               -73,
                                                                                               "251bdb5d-135b-457f-a5d9-44bf74eeb819",
                                                                                               "06cd71d5-0b5b-48a4-b290-2059efa6a7a6",
                                                                                               "s08ndZtfoPJYh434s0zE5i6525f08MX6",
                                                                                               -31,
                                                                                               DeviceEnrollmentBulkCreateStatus.getDefault(),
                                                                                               122);
        assertTrue(deviceenrollmentbulkcreate.isValid());
        DeviceEnrollmentBulkCreate deviceenrollmentbulkcreateInvalid = new DeviceEnrollmentBulkCreate("9fc800c7-237a-494e-91e8-4461e72e6764",
                                                                                                      new Date(1560172168423L),
                                                                                                      new Date(1560172166315L),
                                                                                                      60,
                                                                                                      "6d9cb7ab-71c9-4bd5-8823-f4f8145d4064",
                                                                                                      "73f8f3ce-3160-4205-91af-6d1ec4aaf605",
                                                                                                      "\u0007eK1Rꆪx1\u001cS7Hvku\\\\L㙿b71OOgeGOlSHLN\u0007Ie7[1W\u001cgl1WNw\u001d@lGFkbN1g℺Oee?RH",
                                                                                                      47,
                                                                                                      DeviceEnrollmentBulkCreateStatus.getDefault(),
                                                                                                      -50);
        assertFalse(deviceenrollmentbulkcreateInvalid.isValid());
    }

    /**
     * Tests the equals method.
     */
    @SuppressWarnings("resource")
    @Test
    public void testEquals() {
        try {
            DeviceEnrollmentBulkCreate deviceenrollmentbulkcreate1 = new DeviceEnrollmentBulkCreate("293f19e9-c066-41eb-ad32-5d2e65271a40",
                                                                                                    new Date(1560172164275L),
                                                                                                    new Date(1560172161547L),
                                                                                                    38,
                                                                                                    "0f39e511-d591-4180-ae39-e55fd8af90d4",
                                                                                                    "b26684b1-a192-48ba-b703-1474b0841172",
                                                                                                    "s08ndZtfoPJYh434s0zE5i6525f08MX6",
                                                                                                    -105,
                                                                                                    DeviceEnrollmentBulkCreateStatus.getDefault(),
                                                                                                    -96);
            DeviceEnrollmentBulkCreate deviceenrollmentbulkcreate2 = new DeviceEnrollmentBulkCreate("293f19e9-c066-41eb-ad32-5d2e65271a40",
                                                                                                    new Date(1560172164275L),
                                                                                                    new Date(1560172161547L),
                                                                                                    38,
                                                                                                    "0f39e511-d591-4180-ae39-e55fd8af90d4",
                                                                                                    "b26684b1-a192-48ba-b703-1474b0841172",
                                                                                                    "s08ndZtfoPJYh434s0zE5i6525f08MX6",
                                                                                                    -105,
                                                                                                    DeviceEnrollmentBulkCreateStatus.getDefault(),
                                                                                                    -96);
            DeviceEnrollmentBulkCreate deviceenrollmentbulkcreate3 = new DeviceEnrollmentBulkCreate("940bc6ef-cfbf-47e8-b1f4-328d03160598",
                                                                                                    new Date(1560172165731L),
                                                                                                    new Date(1560172162342L),
                                                                                                    -108,
                                                                                                    "c7ca97f7-045e-4024-8801-04db30ad4be3",
                                                                                                    "a3937f68-4d30-438a-b9a6-959aabe0ca1e",
                                                                                                    "s08ndZtfoPJYh434s0zE5i6525f08MX6",
                                                                                                    -89,
                                                                                                    DeviceEnrollmentBulkCreateStatus.getDefault(),
                                                                                                    99);
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
