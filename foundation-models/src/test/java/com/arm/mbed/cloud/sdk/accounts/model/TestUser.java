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
            User user1 = new User("1fb3d6dc3467de6fb631f982b0ebed24", null, "2ea49323-b529-45dd-af2d-49d752ad8df1",
                                  new Date(1559745294191L), -29, null, "185c4.2ae69@37777.me", false,
                                  "f2e25773-97c9-4041-bc30-3c333b939d24", "1fb3d6dc3467de6fb631f982b0ebed24", false,
                                  false, false, -90, null, null, "9bb65b62-3e2f-4865-8849-dbb293120a6d", -44,
                                  "70161c70-6b8a-4cd6-9804-151de21296d8", UserStatus.getDefault(), null,
                                  new Date(1559745302735L), ",,@c==_,");
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
            User user1 = new User("1fb3d6dc3467de6fb631f982b0ebed24", null, "fbcb6f86-cf72-4a1a-888a-09352aaf51ca",
                                  new Date(1559745298777L), 117, null, "76d6a.150e2@61053.fr", false,
                                  "37f3c212-cb51-4d7f-b6f3-4b7b85933aa7", "1fb3d6dc3467de6fb631f982b0ebed24", false,
                                  false, true, 78, null, null, "9b1f0abd-1128-4446-b127-e53eb970bac5", -8,
                                  "c4d3b525-72b1-48eb-bfe0-1421cbf8e738", UserStatus.getDefault(), null,
                                  new Date(1559745297057L), ",,@c==_,");
            User user2 = new User("1fb3d6dc3467de6fb631f982b0ebed24", null, "fbcb6f86-cf72-4a1a-888a-09352aaf51ca",
                                  new Date(1559745298777L), 117, null, "76d6a.150e2@61053.fr", false,
                                  "37f3c212-cb51-4d7f-b6f3-4b7b85933aa7", "1fb3d6dc3467de6fb631f982b0ebed24", false,
                                  false, true, 78, null, null, "9b1f0abd-1128-4446-b127-e53eb970bac5", -8,
                                  "c4d3b525-72b1-48eb-bfe0-1421cbf8e738", UserStatus.getDefault(), null,
                                  new Date(1559745297057L), ",,@c==_,");
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
        User user = new User("1fb3d6dc3467de6fb631f982b0ebed24", null, "1f120590-a982-42ab-ad41-331c6235f85c",
                             new Date(1559745300472L), 117, null, "f2f6d.63eee@32e66.fr", true,
                             "9a1d1ce1-074f-44f4-b024-8bc2abe0fe86", "1fb3d6dc3467de6fb631f982b0ebed24", true, true,
                             false, 76, null, null, "e349adda-743a-4f90-892a-1f49524b7284", -7,
                             "e33e4df0-11f8-4093-a2d3-8d18d33f0c39", UserStatus.getDefault(), null,
                             new Date(1559745300132L), ",,@c==_,");
        assertTrue(user.isValid());
        User userInvalid = new User("왌꿣-[(5┕5๹5&B\u001e5Oa`㟖苔5G\f-\u001a曤뗧E\u000fM5\u0005핂OK盀绯=5OZ]5\u0007,5㻪\u0012�?�,[5PZ5┑5\u000fᾰ媙$$5燫",
                                    null, "db2d6334-eb7e-4699-938a-9c60fced8d00", new Date(1559745295572L), 121, null,
                                    null, false,
                                    "1383b3ed-7e52-478d-82a7-b2a0a00df3df5227e6fb-c3d6-435f-afbd-ad9edf94b52efde8207c-1004-42f6-aa0b-6dac1c6e66c3",
                                    "왌꿣-[(5┕5๹5&B\u001e5Oa`㟖苔5G\f-\u001a曤뗧E\u000fM5\u0005핂OK盀绯=5OZ]5\u0007,5㻪\u0012�?�,[5PZ5┑5\u000fᾰ媙$$5燫",
                                    true, true, true, -122, null, null, "0feee643-6fa4-4858-b1a4-a3c8532483eb", -3,
                                    "4ef43ff2-18ee-49c4-95da-7b0c6480ded0fd4577f7-48c1-4c11-bc0c-c24820b05e03c38bd098-b79f-4c3c-b9aa-79e5dc3dd472",
                                    UserStatus.getDefault(), null, new Date(1559745294514L),
                                    "\u001d\\\\?b&C>AV\u001ba0;>a?`5�?�Ua\u001d3-.`牶NH[\u001fOa4[BbOaaV`I\u000f\u0003Yb䊗�?�?E`\u000f>DEa\u000b>bTa");
        assertFalse(userInvalid.isValid());
    }

    /**
     * Tests the equals method.
     */
    @SuppressWarnings("resource")
    @Test
    public void testEquals() {
        try {
            User user1 = new User("1fb3d6dc3467de6fb631f982b0ebed24", null, "8035c4c5-1036-4a6d-9a46-52835bf76d74",
                                  new Date(1559745296379L), -121, null, "0ce61.8b54b@fc6aa.fr", true,
                                  "caae3c79-9ced-4ae8-8a94-953ac88b283b", "1fb3d6dc3467de6fb631f982b0ebed24", true,
                                  true, false, 113, null, null, "e5fabaae-ae54-478c-b281-23e17aa20c24", 46,
                                  "1ad71196-fe98-4532-8b5b-43c13af2ed21", UserStatus.getDefault(), null,
                                  new Date(1559745303197L), ",,@c==_,");
            User user2 = new User("1fb3d6dc3467de6fb631f982b0ebed24", null, "8035c4c5-1036-4a6d-9a46-52835bf76d74",
                                  new Date(1559745296379L), -121, null, "0ce61.8b54b@fc6aa.fr", true,
                                  "caae3c79-9ced-4ae8-8a94-953ac88b283b", "1fb3d6dc3467de6fb631f982b0ebed24", true,
                                  true, false, 113, null, null, "e5fabaae-ae54-478c-b281-23e17aa20c24", 46,
                                  "1ad71196-fe98-4532-8b5b-43c13af2ed21", UserStatus.getDefault(), null,
                                  new Date(1559745303197L), ",,@c==_,");
            User user3 = new User("1fb3d6dc3467de6fb631f982b0ebed24", null, "0e60b211-425e-4e28-a630-24e67d33152e",
                                  new Date(1559745297978L), 14, null, "3be58.f9bab@d9c3b.fr", true,
                                  "2fa7d957-8f25-4d9b-9ccf-f67a0bbd994b", "1fb3d6dc3467de6fb631f982b0ebed24", true,
                                  true, false, -76, null, null, "369734b2-e039-40ed-8a63-f2fa04ee8ea8", 58,
                                  "cd8d2a90-1557-4b01-88cb-55bdc371d5fb", UserStatus.getDefault(), null,
                                  new Date(1559745296799L), ",,@c==_,");
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
