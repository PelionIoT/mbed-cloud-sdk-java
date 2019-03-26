// This file was generated by the Pelion SDK foundation code generator.
// This is an autogenerated unit test class. Do not modify its content as modifications will be lost at next code generation.
package com.arm.mbed.cloud.sdk.accounts.model;

import static org.junit.Assert.*;

import java.util.Date;
import org.junit.Test;

/**
 * Unit tests for Model SubtenantUser.
 */
@SuppressWarnings("PMD.AvoidDuplicateLiterals")
public class TestSubtenantUser {
    /**
     * Tests the clone method.
     */
    @SuppressWarnings("resource")
    @Test
    public void testClone() {
        try {
            SubtenantUser subtenantuser1 = new SubtenantUser("3275320e-bd1d-491c-b3b7-cb33c6209954", null,
                                                             "f1b9482e-5bd3-4511-abbe-d2cb5c14b8de",
                                                             new Date(1553611832569L), -113, null,
                                                             "5075aa93-a002-4060-bb0d-1bf97a51d379", true,
                                                             "e89a7899-e65d-4ac5-80b7-02f135e0b50e",
                                                             "9a7e99f0-a786-40e2-b795-04d88a10f644", 77, null, null,
                                                             false, "f567befc-21c2-4a00-ac38-db916153533b", -33,
                                                             "3e2dde59-beb5-4c55-a6aa-4e7a5bae646a",
                                                             SubtenantUserStatus.getDefault(), false, null, true,
                                                             new Date(1553611827451L),
                                                             "60a27273-7453-4ef3-b2f9-0afe53b722d7");
            SubtenantUser subtenantuser2 = subtenantuser1.clone();
            assertNotNull(subtenantuser1);
            assertNotNull(subtenantuser2);
            assertNotSame(subtenantuser2, subtenantuser1);
            assertEquals(subtenantuser2, subtenantuser1);
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
            SubtenantUser subtenantuser1 = new SubtenantUser("6bec491d-57c1-481b-a658-2dd08a5fa6ec", null,
                                                             "86d9726d-afdf-43a2-9fd3-b5d53140bdfa",
                                                             new Date(1553611829321L), 93, null,
                                                             "786e591f-35d8-4d37-ad3b-e951f883a398", false,
                                                             "e3c5bf6f-646d-4fee-88d5-d62869165454",
                                                             "50111cac-d368-41eb-b89b-4f33379db18c", -99, null, null,
                                                             true, "922ad788-3bc3-4608-8667-7a817a18d1c0", 68,
                                                             "ddae89a8-598b-4e80-8f88-ddc4512c6bc9",
                                                             SubtenantUserStatus.getDefault(), true, null, false,
                                                             new Date(1553611831098L),
                                                             "d9bf23a2-4c99-4f08-b74b-85787770a37c");
            SubtenantUser subtenantuser2 = new SubtenantUser("6bec491d-57c1-481b-a658-2dd08a5fa6ec", null,
                                                             "86d9726d-afdf-43a2-9fd3-b5d53140bdfa",
                                                             new Date(1553611829321L), 93, null,
                                                             "786e591f-35d8-4d37-ad3b-e951f883a398", false,
                                                             "e3c5bf6f-646d-4fee-88d5-d62869165454",
                                                             "50111cac-d368-41eb-b89b-4f33379db18c", -99, null, null,
                                                             true, "922ad788-3bc3-4608-8667-7a817a18d1c0", 68,
                                                             "ddae89a8-598b-4e80-8f88-ddc4512c6bc9",
                                                             SubtenantUserStatus.getDefault(), true, null, false,
                                                             new Date(1553611831098L),
                                                             "d9bf23a2-4c99-4f08-b74b-85787770a37c");
            assertNotNull(subtenantuser1);
            assertNotNull(subtenantuser2);
            assertNotSame(subtenantuser2, subtenantuser1);
            assertEquals(subtenantuser2, subtenantuser1);
            assertEquals(subtenantuser2.hashCode(), subtenantuser1.hashCode());
            int hashCode = subtenantuser1.hashCode();
            for (int i = 0; i < 5; i++) {
                assertEquals(hashCode, subtenantuser1.hashCode());
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
        SubtenantUser subtenantuser = new SubtenantUser("e77a7e25-7a93-42a2-84d0-b078a7a2d6ad", null,
                                                        "5893ad52-b4b0-41b8-bbe2-62fad88e89a4",
                                                        new Date(1553611827557L), 12, null,
                                                        "b647179b-04e7-4d2c-aa84-90368fb0f8d4", true,
                                                        "f96c138d-f5cf-4ce3-816b-df04793e2aa4",
                                                        "2cdcba64-0d01-4265-9406-a3227f40faee", 52, null, null, true,
                                                        "c81c9b44-56a4-4626-a7e0-d2c91b3e5668", 103,
                                                        "c9bfc0ea-011f-4d99-9887-db8d22880191",
                                                        SubtenantUserStatus.getDefault(), false, null, false,
                                                        new Date(1553611830081L),
                                                        "ecf2b05d-8a81-459b-84bf-c857229dda63");
        assertTrue(subtenantuser.isValid());
        SubtenantUser subtenantuserInvalid = new SubtenantUser(null, null, "f0849ed9-3db7-4b6f-aeee-a3158229c985",
                                                               new Date(1553611831807L), 0, null, null, true,
                                                               "89b84989-364a-4e65-9147-54a6d92bfc4a",
                                                               "5de76bb7-a635-4326-90d3-df2a3ac7ee22", 43, null, null,
                                                               true, "32226e58-b3df-44fe-bb4f-b9fc768dcd83", 101,
                                                               "e35cfbdb-9bbc-4f70-8cf0-8274ffbfe98b",
                                                               SubtenantUserStatus.getDefault(), true, null, false,
                                                               new Date(1553611829484L),
                                                               "11d373ac-c682-4d68-9c96-4241c9ac758b");
        assertFalse(subtenantuserInvalid.isValid());
    }

    /**
     * Tests the equals method.
     */
    @SuppressWarnings("resource")
    @Test
    public void testEquals() {
        try {
            SubtenantUser subtenantuser1 = new SubtenantUser("013d072c-858c-436a-9f79-8ad61d5ad7ba", null,
                                                             "f9a3a8cc-6823-4217-b3d9-67d95f4fa70c",
                                                             new Date(1553611833444L), -99, null,
                                                             "a6c46bb3-7c55-4d9a-8312-13a63a77c5c9", false,
                                                             "687a85b2-9ed6-48ca-846d-ad82a8b3f2bd",
                                                             "0c1616fb-1943-4147-ac45-216b97670916", -84, null, null,
                                                             true, "62ceb5a3-c8da-4006-870b-1015e24f4929", 28,
                                                             "1841c16f-ed69-43a0-91fc-ad66faf66ba3",
                                                             SubtenantUserStatus.getDefault(), true, null, true,
                                                             new Date(1553611833044L),
                                                             "a919f24c-36bf-47c0-a471-7ec746acb6b8");
            SubtenantUser subtenantuser2 = new SubtenantUser("013d072c-858c-436a-9f79-8ad61d5ad7ba", null,
                                                             "f9a3a8cc-6823-4217-b3d9-67d95f4fa70c",
                                                             new Date(1553611833444L), -99, null,
                                                             "a6c46bb3-7c55-4d9a-8312-13a63a77c5c9", false,
                                                             "687a85b2-9ed6-48ca-846d-ad82a8b3f2bd",
                                                             "0c1616fb-1943-4147-ac45-216b97670916", -84, null, null,
                                                             true, "62ceb5a3-c8da-4006-870b-1015e24f4929", 28,
                                                             "1841c16f-ed69-43a0-91fc-ad66faf66ba3",
                                                             SubtenantUserStatus.getDefault(), true, null, true,
                                                             new Date(1553611833044L),
                                                             "a919f24c-36bf-47c0-a471-7ec746acb6b8");
            SubtenantUser subtenantuser3 = new SubtenantUser("9ce856d3-1414-4820-a647-4f57155be9f8", null,
                                                             "98aac50c-c279-4327-9b20-87de33254dd1",
                                                             new Date(1553611831992L), -124, null,
                                                             "fa347a29-4ed9-4d7d-bfc9-5256c73be892", false,
                                                             "aa510f90-ad20-4aae-a4cc-c2b854bf643b",
                                                             "6fd57a55-3ff0-4e0e-ae8c-a6789ecf27fd", -111, null, null,
                                                             true, "3d1e3604-e796-4f25-b66f-3e6f60d972ee", 86,
                                                             "35f72aa2-89de-4b42-b8a5-facfe12121a4",
                                                             SubtenantUserStatus.getDefault(), true, null, true,
                                                             new Date(1553611825911L),
                                                             "1363e6a6-5615-412f-a745-9d28d1820eba");
            assertNotNull(subtenantuser1);
            assertNotNull(subtenantuser2);
            assertNotNull(subtenantuser3);
            assertNotSame(subtenantuser2, subtenantuser1);
            assertNotSame(subtenantuser3, subtenantuser1);
            assertEquals(subtenantuser2, subtenantuser1);
            assertEquals(subtenantuser2, subtenantuser1);
            assertEquals(subtenantuser1, subtenantuser2);
            assertEquals(subtenantuser1, subtenantuser1);
            assertFalse(subtenantuser1.equals(null));
            assertNotEquals(subtenantuser3, subtenantuser1);
        } catch (Exception exception) {
            fail(exception.getMessage());
        }
    }
}
