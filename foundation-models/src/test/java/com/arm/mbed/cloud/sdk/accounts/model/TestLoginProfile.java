// This file was generated by the Pelion SDK foundation code generator.
// This is an autogenerated unit test class. Do not modify its content as modifications will be lost at next code generation.
package com.arm.mbed.cloud.sdk.accounts.model;

import static org.junit.Assert.*;

import org.junit.Test;

/**
 * Unit tests for Model LoginProfile.
 */
@SuppressWarnings("PMD.AvoidDuplicateLiterals")
public class TestLoginProfile {
    /**
     * Tests the clone method.
     */
    @SuppressWarnings("resource")
    @Test
    public void testClone() {
        try {
            LoginProfile loginprofile1 = new LoginProfile("3cfe74ad-2753-4ce8-8837-b7e35edc708e",
                                                          "72a53e70-dd99-4694-adff-d2384dba8c9a");
            LoginProfile loginprofile2 = loginprofile1.clone();
            assertNotNull(loginprofile1);
            assertNotNull(loginprofile2);
            assertNotSame(loginprofile2, loginprofile1);
            assertEquals(loginprofile2, loginprofile1);
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
            LoginProfile loginprofile1 = new LoginProfile("5a306366-7ab5-4082-b3be-25622ba59daf",
                                                          "725abb3a-1153-4b6c-ba29-40065a18b7a7");
            LoginProfile loginprofile2 = new LoginProfile("5a306366-7ab5-4082-b3be-25622ba59daf",
                                                          "725abb3a-1153-4b6c-ba29-40065a18b7a7");
            assertNotNull(loginprofile1);
            assertNotNull(loginprofile2);
            assertNotSame(loginprofile2, loginprofile1);
            assertEquals(loginprofile2, loginprofile1);
            assertEquals(loginprofile2.hashCode(), loginprofile1.hashCode());
            int hashCode = loginprofile1.hashCode();
            for (int i = 0; i < 5; i++) {
                assertEquals(hashCode, loginprofile1.hashCode());
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
        LoginProfile loginprofile = new LoginProfile("8360ad7f-09d7-478c-bd06-ca4e0941cb36",
                                                     "01b9933a-662c-4b24-b054-fc3f9725e19b");
        assertTrue(loginprofile.isValid());
    }

    /**
     * Tests the equals method.
     */
    @SuppressWarnings("resource")
    @Test
    public void testEquals() {
        try {
            LoginProfile loginprofile1 = new LoginProfile("0b91f0db-af31-48c8-8f0c-6b8e927a8c0f",
                                                          "1242b164-efca-4fcb-b829-f340a5001d12");
            LoginProfile loginprofile2 = new LoginProfile("0b91f0db-af31-48c8-8f0c-6b8e927a8c0f",
                                                          "1242b164-efca-4fcb-b829-f340a5001d12");
            LoginProfile loginprofile3 = new LoginProfile("9f7bcf17-c503-45ff-9fb3-57198d87d56c",
                                                          "144734c2-e1ca-4960-8454-8dd82de2b133");
            assertNotNull(loginprofile1);
            assertNotNull(loginprofile2);
            assertNotNull(loginprofile3);
            assertNotSame(loginprofile2, loginprofile1);
            assertNotSame(loginprofile3, loginprofile1);
            assertEquals(loginprofile2, loginprofile1);
            assertEquals(loginprofile2, loginprofile1);
            assertEquals(loginprofile1, loginprofile2);
            assertEquals(loginprofile1, loginprofile1);
            assertFalse(loginprofile1.equals(null));
            assertNotEquals(loginprofile3, loginprofile1);
        } catch (Exception exception) {
            fail(exception.getMessage());
        }
    }
}
