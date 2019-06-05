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
            LoginProfile loginprofile1 = new LoginProfile("f3e935a0-2f09-4119-be7f-1ec7bfaac626",
                                                          "b17e5b3d-185c-4bbe-8ab4-3c7d295efee0");
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
            LoginProfile loginprofile1 = new LoginProfile("760df447-b31d-4be2-8148-ac6b780eb9fd",
                                                          "ec8579f9-c119-4982-b5ba-958d21de4d58");
            LoginProfile loginprofile2 = new LoginProfile("760df447-b31d-4be2-8148-ac6b780eb9fd",
                                                          "ec8579f9-c119-4982-b5ba-958d21de4d58");
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
        LoginProfile loginprofile = new LoginProfile("8df40907-c060-467b-9202-6d5eae4b76a0",
                                                     "d8f669c4-3102-471b-8ea8-a54e0e81d760");
        assertTrue(loginprofile.isValid());
    }

    /**
     * Tests the equals method.
     */
    @SuppressWarnings("resource")
    @Test
    public void testEquals() {
        try {
            LoginProfile loginprofile1 = new LoginProfile("82dca248-ab43-4499-bc74-70eb8db0cde5",
                                                          "f472aa73-91da-42e7-8cec-dc39ac625f98");
            LoginProfile loginprofile2 = new LoginProfile("82dca248-ab43-4499-bc74-70eb8db0cde5",
                                                          "f472aa73-91da-42e7-8cec-dc39ac625f98");
            LoginProfile loginprofile3 = new LoginProfile("33e93dbc-fc90-446c-9e96-688c5149c981",
                                                          "51bc26db-0d33-4251-aec5-15a02cad170b");
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
