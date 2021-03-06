// This file was generated by the Pelion SDK foundation code generator.
// This is an autogenerated unit test class. Do not modify its content as modifications will be lost at next code generation.
package com.arm.mbed.cloud.sdk.accounts.model;

import static org.junit.Assert.*;

import org.junit.Test;

/**
 * Unit tests for Model OidcRequestClaimMapping.
 */
@SuppressWarnings("PMD.AvoidDuplicateLiterals")
public class TestOidcRequestClaimMapping {
    /**
     * Tests the clone method.
     */
    @SuppressWarnings("resource")
    @Test
    public void testClone() {
        try {
            OidcRequestClaimMapping oidcrequestclaimmapping1 = new OidcRequestClaimMapping("baebf.62d5e@3fb09.fr",
                                                                                           "a5930.2bfac@132ea.me",
                                                                                           "a7b3add1-e71a-4159-805a-062bd23f998e",
                                                                                           "c368ce2c-46e8-4e2b-8c37-c6a3713c6b1b",
                                                                                           "afdc3dd6-1e9d-4c55-a035-ece967b374a7",
                                                                                           "d28be750-354a-4392-9d3b-ea1d7857e554",
                                                                                           "feb679ab-730f-4571-a913-ff037093d8b0",
                                                                                           "dff21d0a-bd07-45e0-bcb0-3a026bb88667",
                                                                                           "607e6bdb-0593-490c-b5fb-bf05265cce2c");
            OidcRequestClaimMapping oidcrequestclaimmapping2 = oidcrequestclaimmapping1.clone();
            assertNotNull(oidcrequestclaimmapping1);
            assertNotNull(oidcrequestclaimmapping2);
            assertNotSame(oidcrequestclaimmapping2, oidcrequestclaimmapping1);
            assertEquals(oidcrequestclaimmapping2, oidcrequestclaimmapping1);
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
            OidcRequestClaimMapping oidcrequestclaimmapping1 = new OidcRequestClaimMapping("49ea7.2b041@55bb8.me",
                                                                                           "faa57.f9ded@03b8b.fr",
                                                                                           "3b91a1b1-98a4-4cf5-9d68-16560b1256dc",
                                                                                           "a00b2cc9-b1c8-40dd-9aac-301bf5a624bb",
                                                                                           "51737f15-9362-49fc-9c31-07f5d2da016a",
                                                                                           "01a47c2d-3404-4e37-af5d-c659ecbd32cd",
                                                                                           "f52867d0-e4ac-4727-8507-351eaf00fd45",
                                                                                           "6d1fc624-cefd-4c0a-9790-121fefe47b6e",
                                                                                           "57433ae8-5dfb-4058-a020-15d5343a8d8d");
            OidcRequestClaimMapping oidcrequestclaimmapping2 = new OidcRequestClaimMapping("49ea7.2b041@55bb8.me",
                                                                                           "faa57.f9ded@03b8b.fr",
                                                                                           "3b91a1b1-98a4-4cf5-9d68-16560b1256dc",
                                                                                           "a00b2cc9-b1c8-40dd-9aac-301bf5a624bb",
                                                                                           "51737f15-9362-49fc-9c31-07f5d2da016a",
                                                                                           "01a47c2d-3404-4e37-af5d-c659ecbd32cd",
                                                                                           "f52867d0-e4ac-4727-8507-351eaf00fd45",
                                                                                           "6d1fc624-cefd-4c0a-9790-121fefe47b6e",
                                                                                           "57433ae8-5dfb-4058-a020-15d5343a8d8d");
            assertNotNull(oidcrequestclaimmapping1);
            assertNotNull(oidcrequestclaimmapping2);
            assertNotSame(oidcrequestclaimmapping2, oidcrequestclaimmapping1);
            assertEquals(oidcrequestclaimmapping2, oidcrequestclaimmapping1);
            assertEquals(oidcrequestclaimmapping2.hashCode(), oidcrequestclaimmapping1.hashCode());
            int hashCode = oidcrequestclaimmapping1.hashCode();
            for (int i = 0; i < 5; i++) {
                assertEquals(hashCode, oidcrequestclaimmapping1.hashCode());
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
        OidcRequestClaimMapping oidcrequestclaimmapping = new OidcRequestClaimMapping("079cd.714c0@bfd20.me",
                                                                                      "b62ac.34f9b@55254.me",
                                                                                      "5d97015a-883c-4494-b6cf-d7eb9dbad273",
                                                                                      "126584e2-78cc-46fe-b559-7ee67f7bd349",
                                                                                      "7c63106e-10fe-4144-ba8d-e343bdb0739f",
                                                                                      "69492f4c-a0ba-41ae-9137-7cd3d02c10b1",
                                                                                      "b45c3653-d42b-4d33-b762-a6e2a0203e5a",
                                                                                      "8ae0fc1e-8168-4272-bb1e-b5e4c807817e",
                                                                                      "623672f3-3b48-4cf8-9552-7befefe65ebb");
        assertTrue(oidcrequestclaimmapping.isValid());
    }

    /**
     * Tests the equals method.
     */
    @SuppressWarnings("resource")
    @Test
    public void testEquals() {
        try {
            OidcRequestClaimMapping oidcrequestclaimmapping1 = new OidcRequestClaimMapping("d34ac.c1939@8b9ed.me",
                                                                                           "e21c3.67dc9@efc6f.fr",
                                                                                           "fe4fb58e-fb67-4d57-b304-fb15ef9b456b",
                                                                                           "0fa538b1-0c30-44f4-9eb0-a222bff5b7df",
                                                                                           "f3bb6399-f32c-4b84-ab1f-d211548170ac",
                                                                                           "b6c5f50c-4724-4731-8314-78273937b02b",
                                                                                           "e566ae74-7370-4220-bd6a-427f2dfcb045",
                                                                                           "ef580b8f-6397-4021-8436-afea80e0b6b6",
                                                                                           "da878a6b-46de-41d4-9d6e-5b3386e23301");
            OidcRequestClaimMapping oidcrequestclaimmapping2 = new OidcRequestClaimMapping("d34ac.c1939@8b9ed.me",
                                                                                           "e21c3.67dc9@efc6f.fr",
                                                                                           "fe4fb58e-fb67-4d57-b304-fb15ef9b456b",
                                                                                           "0fa538b1-0c30-44f4-9eb0-a222bff5b7df",
                                                                                           "f3bb6399-f32c-4b84-ab1f-d211548170ac",
                                                                                           "b6c5f50c-4724-4731-8314-78273937b02b",
                                                                                           "e566ae74-7370-4220-bd6a-427f2dfcb045",
                                                                                           "ef580b8f-6397-4021-8436-afea80e0b6b6",
                                                                                           "da878a6b-46de-41d4-9d6e-5b3386e23301");
            OidcRequestClaimMapping oidcrequestclaimmapping3 = new OidcRequestClaimMapping("be060.4cbb6@cc55b.me",
                                                                                           "1bf8a.87dc6@87d43.fr",
                                                                                           "fcb18e64-8ee3-442d-a2ed-2d7f75131114",
                                                                                           "2a6bba5a-bcc4-47c8-9cb4-d7d089905523",
                                                                                           "314aa58f-b12a-46d8-846b-ecfe2d59db44",
                                                                                           "20ec1737-fa9e-4d22-a6aa-470e0c0761be",
                                                                                           "47d68a84-1d57-4db8-9ecf-fe79c8dcd4c0",
                                                                                           "7a92bb43-aadf-4e85-8b39-42e7433ee23e",
                                                                                           "86158d90-8349-42bd-a337-ded74432fff3");
            assertNotNull(oidcrequestclaimmapping1);
            assertNotNull(oidcrequestclaimmapping2);
            assertNotNull(oidcrequestclaimmapping3);
            assertNotSame(oidcrequestclaimmapping2, oidcrequestclaimmapping1);
            assertNotSame(oidcrequestclaimmapping3, oidcrequestclaimmapping1);
            assertEquals(oidcrequestclaimmapping2, oidcrequestclaimmapping1);
            assertEquals(oidcrequestclaimmapping2, oidcrequestclaimmapping1);
            assertEquals(oidcrequestclaimmapping1, oidcrequestclaimmapping2);
            assertEquals(oidcrequestclaimmapping1, oidcrequestclaimmapping1);
            assertFalse(oidcrequestclaimmapping1.equals(null));
            assertNotEquals(oidcrequestclaimmapping3, oidcrequestclaimmapping1);
        } catch (Exception exception) {
            fail(exception.getMessage());
        }
    }
}
