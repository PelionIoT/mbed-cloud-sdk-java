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
            ParentAccount parentaccount1 = new ParentAccount("bc4da.c742d@deae1.fr",
                                                             "d863a1b5-7b3d-49de-9f09-2c1beb645ad8",
                                                             "3f3bfa45b47fdcef3cd0baefcc7b4d9a");
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
            ParentAccount parentaccount1 = new ParentAccount("70129.672cd@8613a.me",
                                                             "f435794d-e26b-45da-91ad-7de4aeb1febd",
                                                             "3f3bfa45b47fdcef3cd0baefcc7b4d9a");
            ParentAccount parentaccount2 = new ParentAccount("70129.672cd@8613a.me",
                                                             "f435794d-e26b-45da-91ad-7de4aeb1febd",
                                                             "3f3bfa45b47fdcef3cd0baefcc7b4d9a");
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
        ParentAccount parentaccount = new ParentAccount("ba7a2.d082a@f3745.me", "b3803de6-8a5a-4324-81ef-dcf43d084d83",
                                                        "3f3bfa45b47fdcef3cd0baefcc7b4d9a");
        assertTrue(parentaccount.isValid());
        ParentAccount parentaccountInvalid = new ParentAccount("\u0001⩯┤礑檱瑶\u0017䌭\u0016>素䖬\u000e\u0004'‗⻲潑!\u0005\u0003藟\u0003䦞Ⱨ�?(�??\u0005肨肬\u0012>\u001d㰸\u000f>ቲ崚2�?�쩨貘䈷\f�?�ᜠ�?\u0003㶦�?�?竻�?�\u00070\u000f䑨ㇳ렑⴮3䊛",
                                                               "2b8799f5-2bcb-4891-adf8-71bc2034924a61314f44-b5e2-466b-9592-846f30fc2439cd5aa515-c164-4108-ad7d-d8f55e18df97",
                                                               "傿!6碚⫔2'>\t栦\u001c6Y8\u001d�?8\u001f\u00176ट22梋)8饦B?翓[6齭�?�8821\u001aM\u001588\u0011َ6+6_88F1\u0004666[86맱I1_");
        assertFalse(parentaccountInvalid.isValid());
    }

    /**
     * Tests the equals method.
     */
    @SuppressWarnings("resource")
    @Test
    public void testEquals() {
        try {
            ParentAccount parentaccount1 = new ParentAccount("eece7.bfaf4@11ed7.fr",
                                                             "2c87aa85-0045-4c7c-9f9e-9eb4c6709aa2",
                                                             "3f3bfa45b47fdcef3cd0baefcc7b4d9a");
            ParentAccount parentaccount2 = new ParentAccount("eece7.bfaf4@11ed7.fr",
                                                             "2c87aa85-0045-4c7c-9f9e-9eb4c6709aa2",
                                                             "3f3bfa45b47fdcef3cd0baefcc7b4d9a");
            ParentAccount parentaccount3 = new ParentAccount("f12f4.dede1@e0e33.me",
                                                             "184516ae-87f1-4892-9422-16ec3996d797",
                                                             "3f3bfa45b47fdcef3cd0baefcc7b4d9a");
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
