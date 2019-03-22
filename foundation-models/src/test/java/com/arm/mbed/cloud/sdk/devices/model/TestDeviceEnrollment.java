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
            DeviceEnrollment deviceenrollment1 = new DeviceEnrollment("f41a0428-a012-4636-a178-487c7e489977",
                                                                      new Date(1553200101554L),
                                                                      new Date(1553200098875L),
                                                                      "W6YiEEFI40SAPZ3ubr9AQa6vf7mXT6m8",
                                                                      "A-IZ61a3I92PBvwLY2EQ3KKkgbv959kD9sf4Vbn366t2230PK5Av3hgbWL7s87IDdzM2QzfH4:ocX9NWX0wrAz0V5EMA7Bl4i",
                                                                      new Date(1553200098415L),
                                                                      "k9j3dV0qCa402w6k6j9HW6px8hx64EUu");
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
            DeviceEnrollment deviceenrollment1 = new DeviceEnrollment("8e405531-e9e0-456e-82de-4c4ae6c059d7",
                                                                      new Date(1553200100251L),
                                                                      new Date(1553200100248L),
                                                                      "Jhk4I5d75PkD410kp2679Vb873W51727",
                                                                      "A-:47vTq5a90zcVjP4qylhr3kJYbbt4ssQnlCJR12w00:djYxV77KRh3OmUsiGmDr:8dSWb:mxGIq1MhI57HsB00KsSu:hL7q",
                                                                      new Date(1553200100649L),
                                                                      "z26hF5WqDXN1w6cFyUk7ue488J5wc9w7");
            DeviceEnrollment deviceenrollment2 = new DeviceEnrollment("8e405531-e9e0-456e-82de-4c4ae6c059d7",
                                                                      new Date(1553200100251L),
                                                                      new Date(1553200100248L),
                                                                      "Jhk4I5d75PkD410kp2679Vb873W51727",
                                                                      "A-:47vTq5a90zcVjP4qylhr3kJYbbt4ssQnlCJR12w00:djYxV77KRh3OmUsiGmDr:8dSWb:mxGIq1MhI57HsB00KsSu:hL7q",
                                                                      new Date(1553200100649L),
                                                                      "z26hF5WqDXN1w6cFyUk7ue488J5wc9w7");
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
        DeviceEnrollment deviceenrollment = new DeviceEnrollment("49a24410-c2fe-4548-895b-d1deda9915b0",
                                                                 new Date(1553200098848L), new Date(1553200096132L),
                                                                 "ssCM2cpvf1IRnlumJ7fWn000Q6eEh1z3",
                                                                 "A-g76ZhkUbJ4c32S6VY9utZS2q:CEMvMmFz496j2ZHvKU87aToZx:j92J9DCY1hpm28sR6jh6b4L110pQwM1GIjF2x8dX9zqJ",
                                                                 new Date(1553200096573L),
                                                                 "ssRE04W8ER9mn2cK3a7diuOKHzn02LY6");
        assertTrue(deviceenrollment.isValid());
        DeviceEnrollment deviceenrollmentInvalid = new DeviceEnrollment("5b4acc1a-0db5-4331-9e60-c0092eea747b",
                                                                        new Date(1553200095380L),
                                                                        new Date(1553200098094L),
                                                                        "cl1B=uGOGrGG\u0000NP盚馣cfqf_VႋG\\\\cGOc꽳=uB3plQhgclgxxNu:cO\u000bBchu1uguJ1K`1",
                                                                        null, new Date(1553200098423L),
                                                                        "뫟2mmDExBmoBmQ@�?�6ⓠm.DNmoT6\u0010^B6xwxmKB\u0012:L_coIsBmxx6NPom\u0013DHo/?t\u0018N;");
        assertFalse(deviceenrollmentInvalid.isValid());
    }

    /**
     * Tests the equals method.
     */
    @SuppressWarnings("resource")
    @Test
    public void testEquals() {
        try {
            DeviceEnrollment deviceenrollment1 = new DeviceEnrollment("85f3cd32-47c6-4de2-8ca7-7212dbd64236",
                                                                      new Date(1553200102540L),
                                                                      new Date(1553200093453L),
                                                                      "7j2J6TMOFleF7Yy9z6Fu7by0Oz3RTJ9a",
                                                                      "A-aUKJkq4SHxS6LI7:J0vDB3RSZM7h66QVxYoQJdg9piM9u19sW3K2c2XiPhZCY9h6JMIIqqbu2ByjdCloSu40bs:pS:83Crb",
                                                                      new Date(1553200101757L),
                                                                      "jqs5siE254XmI366wg1Ftb8Hbg4LO3lh");
            DeviceEnrollment deviceenrollment2 = new DeviceEnrollment("85f3cd32-47c6-4de2-8ca7-7212dbd64236",
                                                                      new Date(1553200102540L),
                                                                      new Date(1553200093453L),
                                                                      "7j2J6TMOFleF7Yy9z6Fu7by0Oz3RTJ9a",
                                                                      "A-aUKJkq4SHxS6LI7:J0vDB3RSZM7h66QVxYoQJdg9piM9u19sW3K2c2XiPhZCY9h6JMIIqqbu2ByjdCloSu40bs:pS:83Crb",
                                                                      new Date(1553200101757L),
                                                                      "jqs5siE254XmI366wg1Ftb8Hbg4LO3lh");
            DeviceEnrollment deviceenrollment3 = new DeviceEnrollment("87922fde-c7ea-4082-9658-f8500c1bc9e0",
                                                                      new Date(1553200098035L),
                                                                      new Date(1553200093573L),
                                                                      "p6d8hf8HF3PnSZDH8DLj3xAw2PPQq3fm",
                                                                      "A-ba2aw25DS5o9shghsm0OH6P3wXt451gkR9zK4QhqSVuxOjr2W66o0::6O6Y5F360nDm0kpB:v:6MPqLRy0f6MTy9z07:0EB",
                                                                      new Date(1553200101199L),
                                                                      "AY81FYi7rEulZwza5kvxtj4JbucSd6GU");
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
