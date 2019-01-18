// This file was generated by the Pelion SDK foundation code generator.
// This is an autogenerated unit test class. Do not modify its content as modifications will be lost at next code generation.
package com.arm.mbed.cloud.sdk.accounts.model;

import static org.junit.Assert.*;

import java.util.Date;
import org.junit.Test;

/**
 * Unit tests for Model UserInvitation.
 */
public class TestUserInvitation {
    /**
     * Tests the clone method.
     */
    @Test
    public void testClone() {
        try {
            UserInvitation userinvitation1 = new UserInvitation("6004a89d-1769-4633-9742-99affc1511a9",
                                                                new Date(1547730059193L),
                                                                "cb7df142-8762-41ff-bdd1-4f4e742ecea8",
                                                                new Date(1547730055172L),
                                                                "05df29b8-0a8a-42d9-9716-68745bb4baae", null,
                                                                new Date(1547730052375L),
                                                                "3ecf9dbc-51c8-4132-b542-b38f14bec425");
            UserInvitation userinvitation2 = userinvitation1.clone();
            assertNotNull(userinvitation1);
            assertNotNull(userinvitation2);
            assertNotSame(userinvitation2, userinvitation1);
            assertEquals(userinvitation2, userinvitation1);
        } catch (Exception exception) {
            fail(exception.getMessage());
        }
    }

    /**
     * Tests the hashCode method.
     */
    @Test
    public void testHashCode() {
        try {
            UserInvitation userinvitation1 = new UserInvitation("962a81ea-8b46-47c7-b86b-966b2ef2983d",
                                                                new Date(1547730059225L),
                                                                "f6cf2c92-8fc2-4693-9a47-e594da5b46fd",
                                                                new Date(1547730053273L),
                                                                "56dc227c-942e-4709-9230-ca6cf5581779", null,
                                                                new Date(1547730057250L),
                                                                "d9d56a96-a41b-4b0d-9f8c-214a4866f905");
            UserInvitation userinvitation2 = new UserInvitation("962a81ea-8b46-47c7-b86b-966b2ef2983d",
                                                                new Date(1547730059225L),
                                                                "f6cf2c92-8fc2-4693-9a47-e594da5b46fd",
                                                                new Date(1547730053273L),
                                                                "56dc227c-942e-4709-9230-ca6cf5581779", null,
                                                                new Date(1547730057250L),
                                                                "d9d56a96-a41b-4b0d-9f8c-214a4866f905");
            assertNotNull(userinvitation1);
            assertNotNull(userinvitation2);
            assertNotSame(userinvitation2, userinvitation1);
            assertEquals(userinvitation2, userinvitation1);
            assertEquals(userinvitation2.hashCode(), userinvitation1.hashCode());
            int hashCode = userinvitation1.hashCode();
            for (int i = 0; i < 5; i++) {
                assertEquals(hashCode, userinvitation1.hashCode());
            }
        } catch (Exception exception) {
            fail(exception.getMessage());
        }
    }

    /**
     * Tests the isValid method.
     */
    @Test
    public void testIsValid() {
        UserInvitation userinvitation = new UserInvitation("b3dafd88-eed4-4812-97d9-f67abda00eae",
                                                           new Date(1547730058469L),
                                                           "d646ad84-cc87-4f17-9d4e-f39d79b2060b",
                                                           new Date(1547730058083L),
                                                           "5ba7cc1f-c991-409e-8113-a64b264e4635", null,
                                                           new Date(1547730059719L),
                                                           "e44a965e-8573-404b-b7cf-728f9629b48a");
        assertTrue(userinvitation.isValid());
        UserInvitation userinvitationInvalid = new UserInvitation("823faf74-32f6-43d3-b8a3-bd0131cd5db8",
                                                                  new Date(1547730053123L), null,
                                                                  new Date(1547730059847L),
                                                                  "a26d5416-63b7-4382-949b-a8d69dad7b07", null,
                                                                  new Date(1547730057016L),
                                                                  "40c5d5c4-85ea-45da-880d-6849146ee2a2");
        assertFalse(userinvitationInvalid.isValid());
    }

    /**
     * Tests the equals method.
     */
    @Test
    public void testEquals() {
        try {
            UserInvitation userinvitation1 = new UserInvitation("98238d20-81e5-4c7f-8780-108f9ed26f28",
                                                                new Date(1547730058569L),
                                                                "54cb1a91-f54a-4cd7-84ab-af40f14aacd4",
                                                                new Date(1547730050513L),
                                                                "7968fb47-5685-48c9-8323-833549d49940", null,
                                                                new Date(1547730053761L),
                                                                "92ec2511-cb63-4eda-b1c7-287d55f324eb");
            UserInvitation userinvitation2 = new UserInvitation("98238d20-81e5-4c7f-8780-108f9ed26f28",
                                                                new Date(1547730058569L),
                                                                "54cb1a91-f54a-4cd7-84ab-af40f14aacd4",
                                                                new Date(1547730050513L),
                                                                "7968fb47-5685-48c9-8323-833549d49940", null,
                                                                new Date(1547730053761L),
                                                                "92ec2511-cb63-4eda-b1c7-287d55f324eb");
            UserInvitation userinvitation3 = new UserInvitation("5b399d49-6238-4171-b033-f49853bf5e64",
                                                                new Date(1547730053849L),
                                                                "6ff231cf-f9f4-42a8-9a2d-765d54076b79",
                                                                new Date(1547730050520L),
                                                                "5e09a24f-a2fa-447b-8b3a-9cf17c598f4a", null,
                                                                new Date(1547730050530L),
                                                                "b9b8622b-2e91-4442-bd59-23a31dcad311");
            assertNotNull(userinvitation1);
            assertNotNull(userinvitation2);
            assertNotNull(userinvitation3);
            assertNotSame(userinvitation2, userinvitation1);
            assertNotSame(userinvitation3, userinvitation1);
            assertEquals(userinvitation2, userinvitation1);
            assertEquals(userinvitation2, userinvitation1);
            assertEquals(userinvitation1, userinvitation2);
            assertEquals(userinvitation1, userinvitation1);
            assertFalse(userinvitation1.equals(null));
            assertNotEquals(userinvitation3, userinvitation1);
        } catch (Exception exception) {
            fail(exception.getMessage());
        }
    }
}