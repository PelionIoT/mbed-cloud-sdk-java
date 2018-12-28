// This file was generated by the Pelion SDK foundation code generator.
// This is an autogenerated unit test class. Do not modify its content as modifications will be lost at next code generation.
package com.arm.mbed.cloud.sdk.devices.model;

import static org.junit.Assert.*;

import org.junit.Test;

/**
 * Unit tests for Model DeviceEnrollment.
 */
public class TestDeviceEnrollment {
    /**
     * Tests the clone method.
     */
    @Test
    public void testClone() {
        DeviceEnrollment deviceenrollment1 = new DeviceEnrollment("6b64979c-bbc1-481d-90d3-795b2066f344",
                                                                  new java.util.Date(1546027080860L),
                                                                  new java.util.Date(1546027077552L),
                                                                  "Z94F786L70r2F2xIdRbRwD1E2q4az8LM",
                                                                  "A-NNWLe75YNS8ln815emK6rUZ62Y03Dzl6i0HAU6V5fZRAfyBg:npGyR1N02047l4RY54h31Gui9Xc59zJk:di31NV3qsVeGv",
                                                                  new java.util.Date(1546027079515L),
                                                                  "v2269WfI2I8ZTGhoBHWfG75r5Z4I7nIt");
        DeviceEnrollment deviceenrollment2 = deviceenrollment1.clone();
        assertNotNull(deviceenrollment1);
        assertNotNull(deviceenrollment2);
        assertNotSame(deviceenrollment2, deviceenrollment1);
        assertEquals(deviceenrollment2, deviceenrollment1);
    }

    /**
     * Tests the isValid method.
     */
    @Test
    public void testIsvalid() {
        DeviceEnrollment deviceenrollment = new DeviceEnrollment("28536759-6cea-425b-9c54-b6a1fca1079b",
                                                                 new java.util.Date(1546027081903L),
                                                                 new java.util.Date(1546027082137L),
                                                                 "X7NzqVeBm62DR3E38QGg81XRI2DPolWa",
                                                                 "A-12:B0lp4x8eBCQy1Q33J2ET32xbOXgPc5148iBYa1B9:QUmav02:3T9yX9vt7KwVJ35v6pPND2cI8XvM1tt84I030d7DSAK",
                                                                 new java.util.Date(1546027075898L),
                                                                 "r9wkKLezhLDh45BRXa1t6Zqne58bX5I0");
        assertTrue(deviceenrollment.isValid());
        DeviceEnrollment deviceenrollmentInvalid = new DeviceEnrollment("0bf1afca-daf4-4f8f-97f4-18bb79f50c12",
                                                                        new java.util.Date(1546027079767L),
                                                                        new java.util.Date(1546027075546L),
                                                                        "RdyuyN2q77;RBlVjPWjPlPr^77.�?7^2;gPHPP7᤹PgnwUWr2(�?	Pn2IdPA77IL,",
                                                                        "XMUrORMcetwerU;m_`rS]ftmrtrmwpXfmhmItMwphc`_rc^谩_cwrSIOfOrM�?Xwm",
                                                                        new java.util.Date(1546027079543L),
                                                                        "RL펣O'ORvv[LUqLVOmHvUO6oxRLv6bLBV6TL?sTR<ROxsꉸ=<&R_v:XFRaJ_`aR");
        assertFalse(deviceenrollmentInvalid.isValid());
    }

    /**
     * Tests the hashCode method.
     */
    @Test
    public void testHashcode() {
        DeviceEnrollment deviceenrollment1 = new DeviceEnrollment("1f9c411e-88ed-4ff9-8b64-430f16e6fc09",
                                                                  new java.util.Date(1546027077301L),
                                                                  new java.util.Date(1546027077366L),
                                                                  "6ctJV5I5Kqjhqt6B253790U7M38KY41R",
                                                                  "A-9TdR90tPHd4GE05q090Ugb4KToG9PYjj77H6Ula0qU9kjD7oIACt5Nwwi1vBZ0GH9bmF9KWmmR8wBy3hK:fk0NwLJ2G0E7H",
                                                                  new java.util.Date(1546027081860L),
                                                                  "Cc4vlmvgI8Ej6jBvFizWB67L07fwo0i6");
        DeviceEnrollment deviceenrollment2 = new DeviceEnrollment("1f9c411e-88ed-4ff9-8b64-430f16e6fc09",
                                                                  new java.util.Date(1546027077301L),
                                                                  new java.util.Date(1546027077366L),
                                                                  "6ctJV5I5Kqjhqt6B253790U7M38KY41R",
                                                                  "A-9TdR90tPHd4GE05q090Ugb4KToG9PYjj77H6Ula0qU9kjD7oIACt5Nwwi1vBZ0GH9bmF9KWmmR8wBy3hK:fk0NwLJ2G0E7H",
                                                                  new java.util.Date(1546027081860L),
                                                                  "Cc4vlmvgI8Ej6jBvFizWB67L07fwo0i6");
        assertNotNull(deviceenrollment1);
        assertNotNull(deviceenrollment2);
        assertNotSame(deviceenrollment2, deviceenrollment1);
        assertEquals(deviceenrollment2, deviceenrollment1);
        assertEquals(deviceenrollment2.hashCode(), deviceenrollment1.hashCode());
        int hashCode = deviceenrollment1.hashCode();
        for (int i = 0; i < 5; i++) {
            assertEquals(hashCode, deviceenrollment1.hashCode());
        }
    }

    /**
     * Tests the equals method.
     */
    @Test
    public void testEquals() {
        DeviceEnrollment deviceenrollment1 = new DeviceEnrollment("8ea348d2-be7f-4d79-8365-3c489d50c523",
                                                                  new java.util.Date(1546027082448L),
                                                                  new java.util.Date(1546027081162L),
                                                                  "ck8hGnX6JIF45MX0R411t25QSYwm9XJz",
                                                                  "A-JRkNJjZ0004u8IQHW9I6uP4QNE9AnE5iU8pUEtkR:29wrqgY:rr278FP9944I8v241oFqEJlCfZnoWuGk39HM5h3qVXl7q0",
                                                                  new java.util.Date(1546027074253L),
                                                                  "uWh83Npem7Tx3E85411OUW0r4fW5CFiB");
        DeviceEnrollment deviceenrollment2 = new DeviceEnrollment("8ea348d2-be7f-4d79-8365-3c489d50c523",
                                                                  new java.util.Date(1546027082448L),
                                                                  new java.util.Date(1546027081162L),
                                                                  "ck8hGnX6JIF45MX0R411t25QSYwm9XJz",
                                                                  "A-JRkNJjZ0004u8IQHW9I6uP4QNE9AnE5iU8pUEtkR:29wrqgY:rr278FP9944I8v241oFqEJlCfZnoWuGk39HM5h3qVXl7q0",
                                                                  new java.util.Date(1546027074253L),
                                                                  "uWh83Npem7Tx3E85411OUW0r4fW5CFiB");
        DeviceEnrollment deviceenrollment3 = new DeviceEnrollment("c4170100-b07e-4810-af1f-c41dec0d09ad",
                                                                  new java.util.Date(1546027074300L),
                                                                  new java.util.Date(1546027075293L),
                                                                  "Y0pE76syPj60AIb2Hy3Mhk7OU1Rb19sl",
                                                                  "A-P:xpMv8KkhU7bfIh4wz6G4xR8Qs8vt8:nnvvygZ90ps0kI17:erIy1:pb0oyI3iEdm5qIiUFQW9tK4zbs9q3V3FDRttDi3N",
                                                                  new java.util.Date(1546027075691L),
                                                                  "X1JIZCFH669RvJbKjNK4MqZQBKC6hcr7");
        assertNotNull(deviceenrollment1);
        assertNotNull(deviceenrollment2);
        assertNotNull(deviceenrollment3);
        assertNotSame(deviceenrollment2, deviceenrollment1);
        assertNotSame(deviceenrollment3, deviceenrollment1);
        assertEquals(deviceenrollment2, deviceenrollment1);
        assertEquals(deviceenrollment2, deviceenrollment1);
        assertEquals(deviceenrollment1, deviceenrollment2);
        assertEquals(deviceenrollment1, deviceenrollment1);
        assertFalse(deviceenrollment1.equals(null));
        assertNotEquals(deviceenrollment3, deviceenrollment1);
    }
}
