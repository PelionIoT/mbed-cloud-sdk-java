// This file was generated by the Pelion SDK foundation code generator.
// This is an autogenerated unit test class. Do not modify its content as modifications will be lost at next code generation.
package com.arm.mbed.cloud.sdk.accounts.model;

import static org.junit.Assert.*;

import org.junit.Test;

/**
 * Unit tests for Model LoginProfile.
 */
public class TestLoginProfile {
    /**
     * Tests the clone method.
     */
    @Test
    public void testClone() {
        try {
            LoginProfile loginprofile1 = new LoginProfile("85e39fdb-7393-43ae-be30-fb4e96bf93d1",
                                                          "89880a52-9754-42d1-b11d-564aca941319");
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
    @Test
    public void testHashCode() {
        try {
            LoginProfile loginprofile1 = new LoginProfile("57872a05-625c-48e7-be25-2f1b757a49a6",
                                                          "d434d635-e1bb-4e4a-89f7-b716690f0782");
            LoginProfile loginprofile2 = new LoginProfile("57872a05-625c-48e7-be25-2f1b757a49a6",
                                                          "d434d635-e1bb-4e4a-89f7-b716690f0782");
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
    @Test
    public void testIsValid() {
        LoginProfile loginprofile = new LoginProfile("830faf44-5221-4b8e-9960-c0c2dfd4bbed",
                                                     "45c45285-9a16-4074-b0f0-847e47be1b45");
        assertTrue(loginprofile.isValid());
    }

    /**
     * Tests the equals method.
     */
    @Test
    public void testEquals() {
        try {
            LoginProfile loginprofile1 = new LoginProfile("8f092971-4eab-41c4-a7ab-eb4a9ca98713",
                                                          "f389a1b6-b089-4286-b32f-32cd827646a7");
            LoginProfile loginprofile2 = new LoginProfile("8f092971-4eab-41c4-a7ab-eb4a9ca98713",
                                                          "f389a1b6-b089-4286-b32f-32cd827646a7");
            LoginProfile loginprofile3 = new LoginProfile("d238f854-3a9c-43eb-b678-1e01636c56f1",
                                                          "5a276e85-d2df-480d-b11e-d215ea822df2");
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