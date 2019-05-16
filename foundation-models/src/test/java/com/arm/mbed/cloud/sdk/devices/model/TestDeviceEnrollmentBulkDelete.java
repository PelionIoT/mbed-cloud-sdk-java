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
            DeviceEnrollmentBulkDelete deviceenrollmentbulkdelete1 = new DeviceEnrollmentBulkDelete("0b38f5bf-8ca9-4231-95d5-a12932f8341c",
                                                                                                    new Date(1558000750941L),
                                                                                                    new Date(1558000751249L),
                                                                                                    65,
                                                                                                    "42dc894e-b23e-41de-acee-71954e516535",
                                                                                                    "0cbb7e24-f67d-4794-acb4-6faf298b9e4c",
                                                                                                    "voQsn47N620M8fOlQZAmhRsy5khkLbvA",
                                                                                                    -76,
                                                                                                    DeviceEnrollmentBulkDeleteStatus.getDefault(),
                                                                                                    5);
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
            DeviceEnrollmentBulkDelete deviceenrollmentbulkdelete1 = new DeviceEnrollmentBulkDelete("8dab8c6b-743a-46ef-84c2-8ba849410571",
                                                                                                    new Date(1558000754930L),
                                                                                                    new Date(1558000746029L),
                                                                                                    -80,
                                                                                                    "98bfe7f1-c304-4d51-a570-b21823daa4a0",
                                                                                                    "84eb8e67-b797-4acc-bf41-06732ea5397c",
                                                                                                    "voQsn47N620M8fOlQZAmhRsy5khkLbvA",
                                                                                                    82,
                                                                                                    DeviceEnrollmentBulkDeleteStatus.getDefault(),
                                                                                                    121);
            DeviceEnrollmentBulkDelete deviceenrollmentbulkdelete2 = new DeviceEnrollmentBulkDelete("8dab8c6b-743a-46ef-84c2-8ba849410571",
                                                                                                    new Date(1558000754930L),
                                                                                                    new Date(1558000746029L),
                                                                                                    -80,
                                                                                                    "98bfe7f1-c304-4d51-a570-b21823daa4a0",
                                                                                                    "84eb8e67-b797-4acc-bf41-06732ea5397c",
                                                                                                    "voQsn47N620M8fOlQZAmhRsy5khkLbvA",
                                                                                                    82,
                                                                                                    DeviceEnrollmentBulkDeleteStatus.getDefault(),
                                                                                                    121);
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
        DeviceEnrollmentBulkDelete deviceenrollmentbulkdelete = new DeviceEnrollmentBulkDelete("8b7c8172-e544-47d3-85e8-2ffb478b491d",
                                                                                               new Date(1558000746946L),
                                                                                               new Date(1558000747530L),
                                                                                               100,
                                                                                               "603bdc61-053a-4250-8f6f-0c7270fadeff",
                                                                                               "a33be864-9900-41e2-8950-8ac1f81e2669",
                                                                                               "voQsn47N620M8fOlQZAmhRsy5khkLbvA",
                                                                                               -17,
                                                                                               DeviceEnrollmentBulkDeleteStatus.getDefault(),
                                                                                               -32);
        assertTrue(deviceenrollmentbulkdelete.isValid());
        DeviceEnrollmentBulkDelete deviceenrollmentbulkdeleteInvalid = new DeviceEnrollmentBulkDelete("686564d2-289e-49ba-97e0-54aa4d93d68f",
                                                                                                      new Date(1558000745845L),
                                                                                                      new Date(1558000754465L),
                                                                                                      -42,
                                                                                                      "52884746-1d6e-4e03-bfa2-4d9fd7254de8",
                                                                                                      "cc6b8295-e5fa-4c5b-a279-017b9ea7bd3b",
                                                                                                      "xBdi9FuPtUPS31tw1P9`ꕻrxB31aB`=PgPFx\u00163㲴,1jgP1rI\\\\jxGTgq:G\u000bPPF]KP3t",
                                                                                                      31,
                                                                                                      DeviceEnrollmentBulkDeleteStatus.getDefault(),
                                                                                                      -3);
        assertFalse(deviceenrollmentbulkdeleteInvalid.isValid());
    }

    /**
     * Tests the equals method.
     */
    @SuppressWarnings("resource")
    @Test
    public void testEquals() {
        try {
            DeviceEnrollmentBulkDelete deviceenrollmentbulkdelete1 = new DeviceEnrollmentBulkDelete("09c510e4-20c9-4051-b4c7-a25b0c40c005",
                                                                                                    new Date(1558000746162L),
                                                                                                    new Date(1558000753180L),
                                                                                                    19,
                                                                                                    "b126855c-0ec3-4201-9564-1375312f0ee9",
                                                                                                    "b0536d27-73c1-4600-8785-66f707aeeaa1",
                                                                                                    "voQsn47N620M8fOlQZAmhRsy5khkLbvA",
                                                                                                    39,
                                                                                                    DeviceEnrollmentBulkDeleteStatus.getDefault(),
                                                                                                    -29);
            DeviceEnrollmentBulkDelete deviceenrollmentbulkdelete2 = new DeviceEnrollmentBulkDelete("09c510e4-20c9-4051-b4c7-a25b0c40c005",
                                                                                                    new Date(1558000746162L),
                                                                                                    new Date(1558000753180L),
                                                                                                    19,
                                                                                                    "b126855c-0ec3-4201-9564-1375312f0ee9",
                                                                                                    "b0536d27-73c1-4600-8785-66f707aeeaa1",
                                                                                                    "voQsn47N620M8fOlQZAmhRsy5khkLbvA",
                                                                                                    39,
                                                                                                    DeviceEnrollmentBulkDeleteStatus.getDefault(),
                                                                                                    -29);
            DeviceEnrollmentBulkDelete deviceenrollmentbulkdelete3 = new DeviceEnrollmentBulkDelete("5c313a3f-138f-4ca9-b788-3e217a9fb920",
                                                                                                    new Date(1558000749963L),
                                                                                                    new Date(1558000753587L),
                                                                                                    -48,
                                                                                                    "a9d9a9cd-adbb-4919-b390-e7795eb3b221",
                                                                                                    "3d5852b1-0fba-422b-9b45-17e111371d7d",
                                                                                                    "voQsn47N620M8fOlQZAmhRsy5khkLbvA",
                                                                                                    101,
                                                                                                    DeviceEnrollmentBulkDeleteStatus.getDefault(),
                                                                                                    29);
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
