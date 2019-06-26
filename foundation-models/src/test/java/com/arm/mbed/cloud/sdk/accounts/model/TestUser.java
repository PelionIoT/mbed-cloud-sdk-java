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
            User user1 = new User("fc91ece4c663c84ce50ea8058379fe26", null, "c065cf93-8220-4d7b-847b-df3373974564",
                                  new Date(1561477837844L), 81, null, "a2657.15394@da20d.fr", false,
                                  "51936610-e02b-4e6c-9540-c29b2a4763a0", "fc91ece4c663c84ce50ea8058379fe26", false,
                                  true, true, 81, null, null, "44aed4a2-e8cf-4982-992e-16e9c6cbd414", 95,
                                  "e09dd21e-a8ed-4410-a0ff-7c2dea0ecd2d", UserStatus.getDefault(), null,
                                  new Date(1561477834946L), "5E7M_7");
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
            User user1 = new User("fc91ece4c663c84ce50ea8058379fe26", null, "cadec210-39fa-4e04-ae48-355fe9a1e707",
                                  new Date(1561477835779L), 126, null, "1fcea.da1bd@137f0.fr", true,
                                  "18a1a2d1-59d9-4905-abff-8c066e9286ef", "fc91ece4c663c84ce50ea8058379fe26", true,
                                  false, true, 16, null, null, "0e6fcc1f-28c4-4747-a145-c9f02dbe7598", -128,
                                  "53e251c2-3f06-4fc7-96f7-6294a29ba2bd", UserStatus.getDefault(), null,
                                  new Date(1561477835966L), "5E7M_7");
            User user2 = new User("fc91ece4c663c84ce50ea8058379fe26", null, "cadec210-39fa-4e04-ae48-355fe9a1e707",
                                  new Date(1561477835779L), 126, null, "1fcea.da1bd@137f0.fr", true,
                                  "18a1a2d1-59d9-4905-abff-8c066e9286ef", "fc91ece4c663c84ce50ea8058379fe26", true,
                                  false, true, 16, null, null, "0e6fcc1f-28c4-4747-a145-c9f02dbe7598", -128,
                                  "53e251c2-3f06-4fc7-96f7-6294a29ba2bd", UserStatus.getDefault(), null,
                                  new Date(1561477835966L), "5E7M_7");
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
        User user = new User("fc91ece4c663c84ce50ea8058379fe26", null, "a15ecee8-bab1-4d5c-8811-5a6af3d20e8f",
                             new Date(1561477841440L), -3, null, "ecae2.ec73b@d4b6c.fr", false,
                             "a3811c4b-dd52-4ddc-8091-0dcab2bad20a", "fc91ece4c663c84ce50ea8058379fe26", true, true,
                             false, -87, null, null, "2816cabe-9781-4be7-9789-7b9cb3a64e60", -42,
                             "c74fa925-ce7d-4381-a408-0e8b83f47a92", UserStatus.getDefault(), null,
                             new Date(1561477840437L), "5E7M_7");
        assertTrue(user.isValid());
        User userInvalid = new User("\u001ed玿Z쒤㸃▦&'d\\\\d=/\u0001b]b冑쟄ddbbb@\u0019dd_:bd\u0014G,dd+\\\\dbbbE`涮b\u0013粔AUbbbK襊\bO>db",
                                    null, "af32abfe-f5e8-44e9-a3af-6e3cd1ee0922", new Date(1561477834642L), 96, null,
                                    null, true,
                                    "47e77c6f-0d0b-490d-a354-bd4950cfffb51bbb9a8a-4130-4cc3-bb36-de18f3f5d43cbcf4b4ce-0ba2-4e99-9f47-aa2c08c0ffd3",
                                    "\u001ed玿Z쒤㸃▦&'d\\\\d=/\u0001b]b冑쟄ddbbb@\u0019dd_:bd\u0014G,dd+\\\\dbbbE`涮b\u0013粔AUbbbK襊\bO>db",
                                    false, false, false, -57, null, null, "66c3da51-1442-4497-ad50-bb7ddeca275a", 97,
                                    "b06b54c4-6852-472d-ab38-9d9d711fb60b18b71a73-eba7-4cdb-b311-18aad0d456793ca37bf5-52ca-4dea-9700-df7ef8191047",
                                    UserStatus.getDefault(), null, new Date(1561477839003L),
                                    "A?C'\u0018BJSJFI66�?�\u0014H暞O6K疧OCPD]\u0004HLUNCFKG@XY!6W6F6\u000f^69DA:᮷66\u0001⋧嶊D>266\u0019G");
        assertFalse(userInvalid.isValid());
    }

    /**
     * Tests the equals method.
     */
    @SuppressWarnings("resource")
    @Test
    public void testEquals() {
        try {
            User user1 = new User("fc91ece4c663c84ce50ea8058379fe26", null, "ecac8dba-0c6a-4093-b1d5-5c769d723cbd",
                                  new Date(1561477836506L), -118, null, "ac460.95e92@41805.fr", true,
                                  "952b0256-f06b-4ccf-bfb7-1c79b6ab84f2", "fc91ece4c663c84ce50ea8058379fe26", false,
                                  false, false, -80, null, null, "81ccb364-0f55-4792-8c1c-50310756914b", -95,
                                  "2491ac9d-27c7-4132-b01b-183def92dd6b", UserStatus.getDefault(), null,
                                  new Date(1561477841954L), "5E7M_7");
            User user2 = new User("fc91ece4c663c84ce50ea8058379fe26", null, "ecac8dba-0c6a-4093-b1d5-5c769d723cbd",
                                  new Date(1561477836506L), -118, null, "ac460.95e92@41805.fr", true,
                                  "952b0256-f06b-4ccf-bfb7-1c79b6ab84f2", "fc91ece4c663c84ce50ea8058379fe26", false,
                                  false, false, -80, null, null, "81ccb364-0f55-4792-8c1c-50310756914b", -95,
                                  "2491ac9d-27c7-4132-b01b-183def92dd6b", UserStatus.getDefault(), null,
                                  new Date(1561477841954L), "5E7M_7");
            User user3 = new User("fc91ece4c663c84ce50ea8058379fe26", null, "550a29b8-2f06-47c6-9707-d47a1c1edcee",
                                  new Date(1561477840869L), 89, null, "16be0.285c2@c12c8.me", true,
                                  "38dd8e88-363f-4bc4-b3df-d2b3026cc47b", "fc91ece4c663c84ce50ea8058379fe26", false,
                                  false, false, 124, null, null, "a6ff36a2-5356-4c1c-9cc1-cbfbddd61eea", -103,
                                  "f9e86db7-8252-4c72-9336-1bfa3dff0db1", UserStatus.getDefault(), null,
                                  new Date(1561477839406L), "5E7M_7");
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
