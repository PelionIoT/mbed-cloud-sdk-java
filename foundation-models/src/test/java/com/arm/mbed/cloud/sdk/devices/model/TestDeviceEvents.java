// This file was generated by the Pelion SDK foundation code generator.
// This is an autogenerated unit test class. Do not modify its content as modifications will be lost at next code generation.
package com.arm.mbed.cloud.sdk.devices.model;

import static org.junit.Assert.*;

import java.util.Date;
import org.junit.Test;

/**
 * Unit tests for Model DeviceEvents.
 */
@SuppressWarnings("PMD.AvoidDuplicateLiterals")
public class TestDeviceEvents {
    /**
     * Tests the clone method.
     */
    @SuppressWarnings("resource")
    @Test
    public void testClone() {
        try {
            DeviceEvents deviceevents1 = new DeviceEvents(null, new Date(1610683989613L), null,
                                                          new Date(1610683991165L),
                                                          "460ef6da-f028-4ed0-99c9-56b8a6be7a65",
                                                          "23abbf86-beed-4559-910e-0291ad90abdf",
                                                          "6b4a2bb6-3e76-4199-a502-5f3c99c54f30",
                                                          "be6f24a8-ee2d-445f-ad4a-a8ab4f156d98",
                                                          "897869bd-7864-4510-ba07-5aa1bd04ca0d",
                                                          "bb8a3cde-3221-4963-a639-23fc500f0470", false);
            DeviceEvents deviceevents2 = deviceevents1.clone();
            assertNotNull(deviceevents1);
            assertNotNull(deviceevents2);
            assertNotSame(deviceevents2, deviceevents1);
            assertEquals(deviceevents2, deviceevents1);
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
            DeviceEvents deviceevents1 = new DeviceEvents(null, new Date(1610683987291L), null,
                                                          new Date(1610683986852L),
                                                          "849abd46-8eda-40ac-a72e-95b8008e97db",
                                                          "8122a2b3-bf46-49e5-896e-f0fab72f9e18",
                                                          "d94a4f7c-3b99-4493-8d44-4dba84f3b425",
                                                          "7b3846e0-101f-44f1-bb5a-cac6a9f0a952",
                                                          "27c03707-f3d0-4db9-b8bb-a470c28d2d9c",
                                                          "f6971779-5440-42a8-9d03-85c97102b8d2", true);
            DeviceEvents deviceevents2 = new DeviceEvents(null, new Date(1610683987291L), null,
                                                          new Date(1610683986852L),
                                                          "849abd46-8eda-40ac-a72e-95b8008e97db",
                                                          "8122a2b3-bf46-49e5-896e-f0fab72f9e18",
                                                          "d94a4f7c-3b99-4493-8d44-4dba84f3b425",
                                                          "7b3846e0-101f-44f1-bb5a-cac6a9f0a952",
                                                          "27c03707-f3d0-4db9-b8bb-a470c28d2d9c",
                                                          "f6971779-5440-42a8-9d03-85c97102b8d2", true);
            assertNotNull(deviceevents1);
            assertNotNull(deviceevents2);
            assertNotSame(deviceevents2, deviceevents1);
            assertEquals(deviceevents2, deviceevents1);
            assertEquals(deviceevents2.hashCode(), deviceevents1.hashCode());
            int hashCode = deviceevents1.hashCode();
            for (int i = 0; i < 5; i++) {
                assertEquals(hashCode, deviceevents1.hashCode());
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
        DeviceEvents deviceevents = new DeviceEvents(null, new Date(1610683988699L), null, new Date(1610683985799L),
                                                     "8760d5aa-f572-40bc-92f7-88bee2578936",
                                                     "d8e9cf0a-3852-44c8-a4de-20a6ef4d6e99",
                                                     "f75c39e8-9c83-45c2-a3d0-399f3debd7a1",
                                                     "e824031f-fad0-4472-9cc1-a0150a71fed9",
                                                     "9d0ed4d2-3d34-4a9b-b45a-c8bbac345f05",
                                                     "7153029c-8766-452d-bece-2398e39f3370", false);
        assertTrue(deviceevents.isValid());
    }

    /**
     * Tests the equals method.
     */
    @SuppressWarnings("resource")
    @Test
    public void testEquals() {
        try {
            DeviceEvents deviceevents1 = new DeviceEvents(null, new Date(1610683989098L), null,
                                                          new Date(1610683994836L),
                                                          "0e7ef1eb-f1c5-49ea-bde8-3be2558b5dcc",
                                                          "7e67b601-9299-45cb-9962-4ac5754d6926",
                                                          "a96b5d3c-0711-43a9-8f79-c598383fa17f",
                                                          "8b45d2fe-5111-49fc-89d0-47142dfc530c",
                                                          "160b3d98-5dc4-4f43-93d8-8a4e914d1146",
                                                          "25ac1581-3c88-481f-a1cf-19a1b7a4bd5e", true);
            DeviceEvents deviceevents2 = new DeviceEvents(null, new Date(1610683989098L), null,
                                                          new Date(1610683994836L),
                                                          "0e7ef1eb-f1c5-49ea-bde8-3be2558b5dcc",
                                                          "7e67b601-9299-45cb-9962-4ac5754d6926",
                                                          "a96b5d3c-0711-43a9-8f79-c598383fa17f",
                                                          "8b45d2fe-5111-49fc-89d0-47142dfc530c",
                                                          "160b3d98-5dc4-4f43-93d8-8a4e914d1146",
                                                          "25ac1581-3c88-481f-a1cf-19a1b7a4bd5e", true);
            DeviceEvents deviceevents3 = new DeviceEvents(null, new Date(1610683987890L), null,
                                                          new Date(1610683988478L),
                                                          "032892f6-cb27-45d1-b76b-b845a44c8d3c",
                                                          "dc1720cc-48b3-4970-912e-41df2aca6f06",
                                                          "b967f617-995b-4d69-810e-bcaedcfa1e80",
                                                          "34a0abbd-5932-404d-b101-c7c821590d27",
                                                          "cab290a1-9f6e-4fb9-954c-29c6027bccfc",
                                                          "b0b53924-d324-4a3f-8ac7-573bf75d47b6", true);
            assertNotNull(deviceevents1);
            assertNotNull(deviceevents2);
            assertNotNull(deviceevents3);
            assertNotSame(deviceevents2, deviceevents1);
            assertNotSame(deviceevents3, deviceevents1);
            assertEquals(deviceevents2, deviceevents1);
            assertEquals(deviceevents2, deviceevents1);
            assertEquals(deviceevents1, deviceevents2);
            assertEquals(deviceevents1, deviceevents1);
            assertFalse(deviceevents1.equals(null));
            assertNotEquals(deviceevents3, deviceevents1);
        } catch (Exception exception) {
            fail(exception.getMessage());
        }
    }
}
