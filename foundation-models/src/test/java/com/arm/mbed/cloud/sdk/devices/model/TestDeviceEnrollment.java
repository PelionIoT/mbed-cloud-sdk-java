// This file was generated by the Pelion SDK foundation code generator.
// This is an autogenerated unit test class. Do not modify its content as modifications will be lost at next code generation.
package com.arm.mbed.cloud.sdk.devices.model;

import static org.junit.Assert.*;

import java.util.Date;
import org.junit.Test;

/**
 * Unit tests for Model DeviceEnrollment.
 */
@SuppressWarnings("PMD.AvoidDuplicateLiterals")
public class TestDeviceEnrollment {
    /**
     * Tests the clone method.
     */
    @SuppressWarnings("resource")
    @Test
    public void testClone() {
        try {
            DeviceEnrollment deviceenrollment1 = new DeviceEnrollment("70f911ea-58ae-4864-aa10-9f5a1944497f",
                                                                      new Date(1559754641492L),
                                                                      new Date(1559754641351L),
                                                                      "DFB4FcMOcZ21RxT197XnA09458e3hq5Z",
                                                                      "A-1PJF3rfqesr6xQ1ncC8ZzIQ1Tre72cPpqB59687tEh4e5:r5uhkAtM4Jr9Q4sf9f8wbCnpA1iMLpL7M8uM8609EEo:lQLtX",
                                                                      new Date(1559754642801L),
                                                                      "DFB4FcMOcZ21RxT197XnA09458e3hq5Z");
            DeviceEnrollment deviceenrollment2 = deviceenrollment1.clone();
            assertNotNull(deviceenrollment1);
            assertNotNull(deviceenrollment2);
            assertNotSame(deviceenrollment2, deviceenrollment1);
            assertEquals(deviceenrollment2, deviceenrollment1);
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
            DeviceEnrollment deviceenrollment1 = new DeviceEnrollment("d8778143-320a-4e26-90ee-da3ed0e03948",
                                                                      new Date(1559754641251L),
                                                                      new Date(1559754643691L),
                                                                      "DFB4FcMOcZ21RxT197XnA09458e3hq5Z",
                                                                      "A-1PJF3rfqesr6xQ1ncC8ZzIQ1Tre72cPpqB59687tEh4e5:r5uhkAtM4Jr9Q4sf9f8wbCnpA1iMLpL7M8uM8609EEo:lQLtX",
                                                                      new Date(1559754643581L),
                                                                      "DFB4FcMOcZ21RxT197XnA09458e3hq5Z");
            DeviceEnrollment deviceenrollment2 = new DeviceEnrollment("d8778143-320a-4e26-90ee-da3ed0e03948",
                                                                      new Date(1559754641251L),
                                                                      new Date(1559754643691L),
                                                                      "DFB4FcMOcZ21RxT197XnA09458e3hq5Z",
                                                                      "A-1PJF3rfqesr6xQ1ncC8ZzIQ1Tre72cPpqB59687tEh4e5:r5uhkAtM4Jr9Q4sf9f8wbCnpA1iMLpL7M8uM8609EEo:lQLtX",
                                                                      new Date(1559754643581L),
                                                                      "DFB4FcMOcZ21RxT197XnA09458e3hq5Z");
            assertNotNull(deviceenrollment1);
            assertNotNull(deviceenrollment2);
            assertNotSame(deviceenrollment2, deviceenrollment1);
            assertEquals(deviceenrollment2, deviceenrollment1);
            assertEquals(deviceenrollment2.hashCode(), deviceenrollment1.hashCode());
            int hashCode = deviceenrollment1.hashCode();
            for (int i = 0; i < 5; i++) {
                assertEquals(hashCode, deviceenrollment1.hashCode());
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
        DeviceEnrollment deviceenrollment = new DeviceEnrollment("49827b1b-6bca-40ae-bfad-ee4d8918c7b2",
                                                                 new Date(1559754643620L), new Date(1559754642985L),
                                                                 "DFB4FcMOcZ21RxT197XnA09458e3hq5Z",
                                                                 "A-1PJF3rfqesr6xQ1ncC8ZzIQ1Tre72cPpqB59687tEh4e5:r5uhkAtM4Jr9Q4sf9f8wbCnpA1iMLpL7M8uM8609EEo:lQLtX",
                                                                 new Date(1559754639023L),
                                                                 "DFB4FcMOcZ21RxT197XnA09458e3hq5Z");
        assertTrue(deviceenrollment.isValid());
        DeviceEnrollment deviceenrollmentInvalid = new DeviceEnrollment("342873be-6340-4c19-b25c-5c44adc3157f",
                                                                        new Date(1559754644103L),
                                                                        new Date(1559754644264L),
                                                                        "6CpJEiNaQdUsPjCSKC`Sg6p6kYKC䕃g୯꯯dGQklCWpCCiQNs`GpEtddEPNCgEf!6ES",
                                                                        null, new Date(1559754643860L),
                                                                        "6CpJEiNaQdUsPjCSKC`Sg6p6kYKC䕃g୯꯯dGQklCWpCCiQNs`GpEtddEPNCgEf!6ES");
        assertFalse(deviceenrollmentInvalid.isValid());
    }

    /**
     * Tests the equals method.
     */
    @SuppressWarnings("resource")
    @Test
    public void testEquals() {
        try {
            DeviceEnrollment deviceenrollment1 = new DeviceEnrollment("9d72f49e-5ee8-435b-81c2-5bbf945a9f2f",
                                                                      new Date(1559754635986L),
                                                                      new Date(1559754636117L),
                                                                      "DFB4FcMOcZ21RxT197XnA09458e3hq5Z",
                                                                      "A-1PJF3rfqesr6xQ1ncC8ZzIQ1Tre72cPpqB59687tEh4e5:r5uhkAtM4Jr9Q4sf9f8wbCnpA1iMLpL7M8uM8609EEo:lQLtX",
                                                                      new Date(1559754635389L),
                                                                      "DFB4FcMOcZ21RxT197XnA09458e3hq5Z");
            DeviceEnrollment deviceenrollment2 = new DeviceEnrollment("9d72f49e-5ee8-435b-81c2-5bbf945a9f2f",
                                                                      new Date(1559754635986L),
                                                                      new Date(1559754636117L),
                                                                      "DFB4FcMOcZ21RxT197XnA09458e3hq5Z",
                                                                      "A-1PJF3rfqesr6xQ1ncC8ZzIQ1Tre72cPpqB59687tEh4e5:r5uhkAtM4Jr9Q4sf9f8wbCnpA1iMLpL7M8uM8609EEo:lQLtX",
                                                                      new Date(1559754635389L),
                                                                      "DFB4FcMOcZ21RxT197XnA09458e3hq5Z");
            DeviceEnrollment deviceenrollment3 = new DeviceEnrollment("dc79b0a4-6b2f-4887-833a-73a4617422d4",
                                                                      new Date(1559754643494L),
                                                                      new Date(1559754642654L),
                                                                      "DFB4FcMOcZ21RxT197XnA09458e3hq5Z",
                                                                      "A-1PJF3rfqesr6xQ1ncC8ZzIQ1Tre72cPpqB59687tEh4e5:r5uhkAtM4Jr9Q4sf9f8wbCnpA1iMLpL7M8uM8609EEo:lQLtX",
                                                                      new Date(1559754641228L),
                                                                      "DFB4FcMOcZ21RxT197XnA09458e3hq5Z");
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
        } catch (Exception exception) {
            fail(exception.getMessage());
        }
    }
}
