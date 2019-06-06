// This file was generated by the Pelion SDK foundation code generator.
// This is an autogenerated unit test class. Do not modify its content as modifications will be lost at next code generation.
package com.arm.mbed.cloud.sdk.accounts.model;

import static org.junit.Assert.*;

import java.util.Date;
import org.junit.Test;

/**
 * Unit tests for Model User.
 */
@SuppressWarnings("PMD.AvoidDuplicateLiterals")
public class TestUser {
    /**
     * Tests the clone method.
     */
    @SuppressWarnings("resource")
    @Test
    public void testClone() {
        try {
            User user1 = new User("bedebcaf929fb64c74860f9a9cc41c0c", null, "f3112127-7869-49ff-97ff-a9110e7c4e56",
                                  new Date(1559833685258L), 43, null, "4f209.6279e@4d5a2.me", false,
                                  "2247e883-11e6-4c28-834c-f804f5f6dc23", "bedebcaf929fb64c74860f9a9cc41c0c", false,
                                  true, true, 96, null, null, "3b316b7b-b88c-4331-92b3-3961eb782a66", -8,
                                  "c985ce0a-d384-46ef-916e-8a1e6f5e4122", UserStatus.getDefault(), null,
                                  new Date(1559833683590L), ",9l=");
            User user2 = user1.clone();
            assertNotNull(user1);
            assertNotNull(user2);
            assertNotSame(user2, user1);
            assertEquals(user2, user1);
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
            User user1 = new User("bedebcaf929fb64c74860f9a9cc41c0c", null, "59175769-ab09-4a86-92ae-cea532025a20",
                                  new Date(1559833682055L), 85, null, "653d4.534a2@afc31.me", true,
                                  "d62685d0-0ee2-47b1-acab-38c50a1b460f", "bedebcaf929fb64c74860f9a9cc41c0c", true,
                                  true, false, -93, null, null, "0dd690ed-9b3a-447b-b887-dab2bcd16166", -96,
                                  "adfce76e-7676-412f-8ded-6d7b756992ab", UserStatus.getDefault(), null,
                                  new Date(1559833681488L), ",9l=");
            User user2 = new User("bedebcaf929fb64c74860f9a9cc41c0c", null, "59175769-ab09-4a86-92ae-cea532025a20",
                                  new Date(1559833682055L), 85, null, "653d4.534a2@afc31.me", true,
                                  "d62685d0-0ee2-47b1-acab-38c50a1b460f", "bedebcaf929fb64c74860f9a9cc41c0c", true,
                                  true, false, -93, null, null, "0dd690ed-9b3a-447b-b887-dab2bcd16166", -96,
                                  "adfce76e-7676-412f-8ded-6d7b756992ab", UserStatus.getDefault(), null,
                                  new Date(1559833681488L), ",9l=");
            assertNotNull(user1);
            assertNotNull(user2);
            assertNotSame(user2, user1);
            assertEquals(user2, user1);
            assertEquals(user2.hashCode(), user1.hashCode());
            int hashCode = user1.hashCode();
            for (int i = 0; i < 5; i++) {
                assertEquals(hashCode, user1.hashCode());
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
        User user = new User("bedebcaf929fb64c74860f9a9cc41c0c", null, "e4f56b7c-3c0e-4a63-8add-c88a443c5672",
                             new Date(1559833685838L), -25, null, "3d414.98e0f@a81bd.me", false,
                             "a130171d-96ce-4a7e-9d81-2323e47105cc", "bedebcaf929fb64c74860f9a9cc41c0c", true, false,
                             true, 14, null, null, "74a3e36a-63c6-4788-855c-0df712c31560", 35,
                             "ea68c464-18e1-4a09-8f30-e4fa77610f95", UserStatus.getDefault(), null,
                             new Date(1559833681994L), ",9l=");
        assertTrue(user.isValid());
        User userInvalid = new User("D3\u0001\u0002\u001c53,ຣG�?*]\u001e.H555\u0016�?Ţ3Z533꧈�?�33譵┌猑\b\u001f5ㆌG3T)\u001f︬⊩ൾ3H535(35�?�5蘠͡Y333\u0007",
                                    null, "e3f984ed-c8de-44fd-bf41-99226b09c189", new Date(1559833683135L), -58, null,
                                    null, true,
                                    "8ca509d3-c265-48d8-b660-1ab686c4f5b95a38e236-d06c-4030-9553-c0929176b0aafa5029ae-0ee4-4941-b185-87271c9f1ba8",
                                    "D3\u0001\u0002\u001c53,ຣG�?*]\u001e.H555\u0016�?Ţ3Z533꧈�?�33譵┌猑\b\u001f5ㆌG3T)\u001f︬⊩ൾ3H535(35�?�5蘠͡Y333\u0007",
                                    false, false, false, 118, null, null, "bb3d7f62-636c-4f57-a427-fba251b9295c", -128,
                                    "ce8f73dc-cd02-4da8-a21e-db5909319db947d7d282-f8ec-496d-8f50-e6a9b95ea855e89a20dd-31f8-44e8-9de1-bf79cf9f459d",
                                    UserStatus.getDefault(), null, new Date(1559833678524L),
                                    "\u0016\f#:*\u0007\\\\;8B>)�?�8!Z;륆8\u000b\u000e\u0011/豪:%.鮹硈\u0017\u000e:⣗\f<je(-2炼1;\u000b.媶J<\f3]1d1\u000eh;h&");
        assertFalse(userInvalid.isValid());
    }

    /**
     * Tests the equals method.
     */
    @SuppressWarnings("resource")
    @Test
    public void testEquals() {
        try {
            User user1 = new User("bedebcaf929fb64c74860f9a9cc41c0c", null, "20725d8a-8b43-40de-be0a-d1bad2254465",
                                  new Date(1559833684227L), 59, null, "c3a85.08018@a318f.me", true,
                                  "c1e04f34-60a3-423f-ae82-20b137d67934", "bedebcaf929fb64c74860f9a9cc41c0c", false,
                                  false, false, -18, null, null, "e6b863f0-d76b-4913-8d22-e292d408e360", -95,
                                  "51d31b16-5f9a-4823-b301-cbb5db95d363", UserStatus.getDefault(), null,
                                  new Date(1559833677339L), ",9l=");
            User user2 = new User("bedebcaf929fb64c74860f9a9cc41c0c", null, "20725d8a-8b43-40de-be0a-d1bad2254465",
                                  new Date(1559833684227L), 59, null, "c3a85.08018@a318f.me", true,
                                  "c1e04f34-60a3-423f-ae82-20b137d67934", "bedebcaf929fb64c74860f9a9cc41c0c", false,
                                  false, false, -18, null, null, "e6b863f0-d76b-4913-8d22-e292d408e360", -95,
                                  "51d31b16-5f9a-4823-b301-cbb5db95d363", UserStatus.getDefault(), null,
                                  new Date(1559833677339L), ",9l=");
            User user3 = new User("bedebcaf929fb64c74860f9a9cc41c0c", null, "137759d1-7970-44b1-822b-9fa0380e20f6",
                                  new Date(1559833686155L), -61, null, "a8550.d8d38@61dcf.fr", true,
                                  "cedf9581-4b8e-4357-ae21-b39d987854dd", "bedebcaf929fb64c74860f9a9cc41c0c", false,
                                  false, false, 19, null, null, "829fec3f-1b25-4beb-b274-a788b7784793", 55,
                                  "a42a1b23-c9b6-4023-b741-020861a2c112", UserStatus.getDefault(), null,
                                  new Date(1559833678724L), ",9l=");
            assertNotNull(user1);
            assertNotNull(user2);
            assertNotNull(user3);
            assertNotSame(user2, user1);
            assertNotSame(user3, user1);
            assertEquals(user2, user1);
            assertEquals(user2, user1);
            assertEquals(user1, user2);
            assertEquals(user1, user1);
            assertFalse(user1.equals(null));
            assertNotEquals(user3, user1);
        } catch (Exception exception) {
            fail(exception.getMessage());
        }
    }
}
