// This file was generated by the Pelion SDK foundation code generator.
// This is an autogenerated unit test class. Do not modify its content as modifications will be lost at next code generation.
package com.arm.mbed.cloud.sdk.accounts.model;

import static org.junit.Assert.*;

import org.junit.Test;

/**
 * Unit tests for Model ParentAccount.
 */
@SuppressWarnings("PMD.AvoidDuplicateLiterals")
public class TestParentAccount {
    /**
     * Tests the clone method.
     */
    @SuppressWarnings("resource")
    @Test
    public void testClone() {
        try {
            ParentAccount parentaccount1 = new ParentAccount("8d687.3b501@fc439.fr",
                                                             "dce599aa-9ded-45d1-b18d-9270af7bedc7",
                                                             "96151c6cca95ea57eac2ba8ede214aed");
            ParentAccount parentaccount2 = parentaccount1.clone();
            assertNotNull(parentaccount1);
            assertNotNull(parentaccount2);
            assertNotSame(parentaccount2, parentaccount1);
            assertEquals(parentaccount2, parentaccount1);
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
            ParentAccount parentaccount1 = new ParentAccount("31dcc.e7dc1@6549d.me",
                                                             "8cce2a03-25a8-4823-942a-88bf65403668",
                                                             "96151c6cca95ea57eac2ba8ede214aed");
            ParentAccount parentaccount2 = new ParentAccount("31dcc.e7dc1@6549d.me",
                                                             "8cce2a03-25a8-4823-942a-88bf65403668",
                                                             "96151c6cca95ea57eac2ba8ede214aed");
            assertNotNull(parentaccount1);
            assertNotNull(parentaccount2);
            assertNotSame(parentaccount2, parentaccount1);
            assertEquals(parentaccount2, parentaccount1);
            assertEquals(parentaccount2.hashCode(), parentaccount1.hashCode());
            int hashCode = parentaccount1.hashCode();
            for (int i = 0; i < 5; i++) {
                assertEquals(hashCode, parentaccount1.hashCode());
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
        ParentAccount parentaccount = new ParentAccount("8d033.82403@ba782.me", "86f4ea3a-4173-4970-9491-1f59275553f8",
                                                        "96151c6cca95ea57eac2ba8ede214aed");
        assertTrue(parentaccount.isValid());
        ParentAccount parentaccountInvalid = new ParentAccount("먖砮眶砢駉\u0004\u001f뤾맖祤䛻ꕞ먹\u0005磳맖묊>릤㎈�?>>\u001d몭#㛼\u0005릾禉�?\u00125\u0013砙\u0005둾맸*윮�?�삌簶릜긊Ⅳɲ릮࿯뙻3�?1�?\u0014�?뛋⌖륱祬>�?",
                                                               "c478ca50-018c-4c00-96c1-5f42fd4c531f3fd26e40-85f6-44c9-8dae-65258d762e8a6bfdb370-664d-403f-9e70-df2f47f4ad20",
                                                               "Z333\u0007Q^D;3�?\u0010(뱎0A333<3Z鵅�?�3U3\u001d]33<3H3ጃ%3䷼3\u00053\u0001ቖ?`3\u0016(3쾙�?3馛3S@Z3#3");
        assertFalse(parentaccountInvalid.isValid());
    }

    /**
     * Tests the equals method.
     */
    @SuppressWarnings("resource")
    @Test
    public void testEquals() {
        try {
            ParentAccount parentaccount1 = new ParentAccount("3b97c.73eb6@a068d.me",
                                                             "576f2789-5727-4ca0-9add-9f230ad95480",
                                                             "96151c6cca95ea57eac2ba8ede214aed");
            ParentAccount parentaccount2 = new ParentAccount("3b97c.73eb6@a068d.me",
                                                             "576f2789-5727-4ca0-9add-9f230ad95480",
                                                             "96151c6cca95ea57eac2ba8ede214aed");
            ParentAccount parentaccount3 = new ParentAccount("b5afb.4ed0a@dfe16.me",
                                                             "a4c1e067-8b2a-40d2-8b37-570ad0d4a39b",
                                                             "96151c6cca95ea57eac2ba8ede214aed");
            assertNotNull(parentaccount1);
            assertNotNull(parentaccount2);
            assertNotNull(parentaccount3);
            assertNotSame(parentaccount2, parentaccount1);
            assertNotSame(parentaccount3, parentaccount1);
            assertEquals(parentaccount2, parentaccount1);
            assertEquals(parentaccount2, parentaccount1);
            assertEquals(parentaccount1, parentaccount2);
            assertEquals(parentaccount1, parentaccount1);
            assertFalse(parentaccount1.equals(null));
            assertNotEquals(parentaccount3, parentaccount1);
        } catch (Exception exception) {
            fail(exception.getMessage());
        }
    }
}
