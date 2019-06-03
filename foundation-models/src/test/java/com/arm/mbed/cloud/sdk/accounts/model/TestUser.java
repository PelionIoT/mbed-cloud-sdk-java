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
            User user1 = new User("3f3bfa45b47fdcef3cd0baefcc7b4d9a", null, "cc41761c-2762-4b72-a3a5-515fa95dc425",
                                  new Date(1559560671455L), -50, null, "a3963.a6f80@4ca6a.fr", true,
                                  "543e4484-c65f-4696-9b43-7b9d1070d4e0", "3f3bfa45b47fdcef3cd0baefcc7b4d9a", true,
                                  false, true, -63, null, null, "32f2f9b7-c3b6-4114-8839-21cc36689757", -60,
                                  "bddfc5d2-2ce0-46f3-9c57-a13a4499886b", UserStatus.getDefault(), null,
                                  new Date(1559560670496L), "__2=7U");
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
            User user1 = new User("3f3bfa45b47fdcef3cd0baefcc7b4d9a", null, "9f2133c0-c694-44a5-bfd4-1de00ea001b6",
                                  new Date(1559560672489L), 122, null, "8aaf8.7faa9@fd920.me", true,
                                  "74f96017-53ac-4a11-a0e6-a813c6f09d60", "3f3bfa45b47fdcef3cd0baefcc7b4d9a", false,
                                  true, false, -19, null, null, "f9c6f44c-0d68-43f5-bdf7-01b2401c3e1c", -67,
                                  "4f990822-1c15-42ef-a7fd-4abb39226b98", UserStatus.getDefault(), null,
                                  new Date(1559560672700L), "__2=7U");
            User user2 = new User("3f3bfa45b47fdcef3cd0baefcc7b4d9a", null, "9f2133c0-c694-44a5-bfd4-1de00ea001b6",
                                  new Date(1559560672489L), 122, null, "8aaf8.7faa9@fd920.me", true,
                                  "74f96017-53ac-4a11-a0e6-a813c6f09d60", "3f3bfa45b47fdcef3cd0baefcc7b4d9a", false,
                                  true, false, -19, null, null, "f9c6f44c-0d68-43f5-bdf7-01b2401c3e1c", -67,
                                  "4f990822-1c15-42ef-a7fd-4abb39226b98", UserStatus.getDefault(), null,
                                  new Date(1559560672700L), "__2=7U");
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
        User user = new User("3f3bfa45b47fdcef3cd0baefcc7b4d9a", null, "11ee2105-2c77-4343-b58f-404417fac07f",
                             new Date(1559560672749L), 27, null, "0489d.58016@60d57.me", false,
                             "fc2b84b7-a774-4789-9e91-8dcc50db9585", "3f3bfa45b47fdcef3cd0baefcc7b4d9a", true, true,
                             true, 97, null, null, "90e26ced-0205-448d-9157-8323db3c4be0", 79,
                             "590e8fcf-b4b7-40d9-8dc0-19b9898d2009", UserStatus.getDefault(), null,
                             new Date(1559560672293L), "__2=7U");
        assertTrue(user.isValid());
        User userInvalid = new User("傿!6碚⫔2'>\t栦\u001c6Y8\u001d�?8\u001f\u00176ट22梋)8饦B?翓[6齭�?�8821\u001aM\u001588\u0011َ6+6_88F1\u0004666[86맱I1_",
                                    null, "55ee3d28-a65e-4510-bcee-defb405effdf", new Date(1559560670499L), -60, null,
                                    null, true,
                                    "e6962123-4aa7-45a8-8b0c-a71e59eee05acb134627-93a9-4cf8-b504-da19037453c4e95b2f1c-472a-4d64-a083-defa224df02a",
                                    "傿!6碚⫔2'>\t栦\u001c6Y8\u001d�?8\u001f\u00176ट22梋)8饦B?翓[6齭�?�8821\u001aM\u001588\u0011َ6+6_88F1\u0004666[86맱I1_",
                                    true, false, false, 1, null, null, "64a9014a-1570-4a98-8d83-26e419a990ed", -71,
                                    "7408fa9c-1a53-4b87-977a-6aaaac6c2d49aaacb98b-91d8-46ce-9ab8-5a41226f6e8e9d435b0e-5a31-4675-8d99-54f6d570741b",
                                    UserStatus.getDefault(), null, new Date(1559560663715L),
                                    "?뿭ZC:4뫯W^\u000495鮳:霥'�?4Ὑ834;6(#\u001eLϿ䳚/Y1;Z^\u00125;DO9䰡G6M\u000b^\u0003D<갹6ᷮT<9[J闳\u001bF^3");
        assertFalse(userInvalid.isValid());
    }

    /**
     * Tests the equals method.
     */
    @SuppressWarnings("resource")
    @Test
    public void testEquals() {
        try {
            User user1 = new User("3f3bfa45b47fdcef3cd0baefcc7b4d9a", null, "edf3abc8-545b-4630-9736-9479632c714b",
                                  new Date(1559560664146L), -2, null, "a6505.204e5@e16f9.fr", false,
                                  "11a5d2d4-5f27-4b62-8b27-500448b8c2a9", "3f3bfa45b47fdcef3cd0baefcc7b4d9a", true,
                                  false, true, -19, null, null, "c09839fe-9c49-4fb2-ac85-d53192f148dd", -42,
                                  "81949727-6604-4b94-8adb-fc7956aede82", UserStatus.getDefault(), null,
                                  new Date(1559560668984L), "__2=7U");
            User user2 = new User("3f3bfa45b47fdcef3cd0baefcc7b4d9a", null, "edf3abc8-545b-4630-9736-9479632c714b",
                                  new Date(1559560664146L), -2, null, "a6505.204e5@e16f9.fr", false,
                                  "11a5d2d4-5f27-4b62-8b27-500448b8c2a9", "3f3bfa45b47fdcef3cd0baefcc7b4d9a", true,
                                  false, true, -19, null, null, "c09839fe-9c49-4fb2-ac85-d53192f148dd", -42,
                                  "81949727-6604-4b94-8adb-fc7956aede82", UserStatus.getDefault(), null,
                                  new Date(1559560668984L), "__2=7U");
            User user3 = new User("3f3bfa45b47fdcef3cd0baefcc7b4d9a", null, "1f854a36-7bcd-4385-80f9-d48664353983",
                                  new Date(1559560668475L), 30, null, "c526a.623ef@a65c9.fr", false,
                                  "da975329-e347-4739-8521-f8aa79f19f80", "3f3bfa45b47fdcef3cd0baefcc7b4d9a", true,
                                  false, true, 40, null, null, "a0e04719-1349-4e7c-9e72-3e65f7cf3885", 58,
                                  "2cb671e3-068e-46ee-b5fd-50ee743250d6", UserStatus.getDefault(), null,
                                  new Date(1559560665431L), "__2=7U");
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
