// This file was generated by the Pelion SDK foundation code generator.
// This is an autogenerated unit test class. Do not modify its content as modifications will be lost at next code generation.
package com.arm.mbed.cloud.sdk.accounts.model;

import static org.junit.Assert.*;

import java.util.Date;
import org.junit.Test;

/**
 * Unit tests for Model LoginHistory.
 */
@SuppressWarnings("PMD.AvoidDuplicateLiterals")
public class TestLoginHistory {
    /**
     * Tests the clone method.
     */
    @SuppressWarnings("resource")
    @Test
    public void testClone() {
        try {
            LoginHistory loginhistory1 = new LoginHistory(new Date(1558003273788L),
                                                          "d31d37a8-15b6-4e7e-ac22-590d2d9b86fa", false,
                                                          "9d09212a-40d7-4885-af91-208f70a6e85b");
            LoginHistory loginhistory2 = loginhistory1.clone();
            assertNotNull(loginhistory1);
            assertNotNull(loginhistory2);
            assertNotSame(loginhistory2, loginhistory1);
            assertEquals(loginhistory2, loginhistory1);
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
            LoginHistory loginhistory1 = new LoginHistory(new Date(1558003283056L),
                                                          "d99fb172-e3cf-40ba-8bdf-efa7445a398d", false,
                                                          "4dad2df0-38c6-454b-9cc7-5e36bd7fc81a");
            LoginHistory loginhistory2 = new LoginHistory(new Date(1558003283056L),
                                                          "d99fb172-e3cf-40ba-8bdf-efa7445a398d", false,
                                                          "4dad2df0-38c6-454b-9cc7-5e36bd7fc81a");
            assertNotNull(loginhistory1);
            assertNotNull(loginhistory2);
            assertNotSame(loginhistory2, loginhistory1);
            assertEquals(loginhistory2, loginhistory1);
            assertEquals(loginhistory2.hashCode(), loginhistory1.hashCode());
            int hashCode = loginhistory1.hashCode();
            for (int i = 0; i < 5; i++) {
                assertEquals(hashCode, loginhistory1.hashCode());
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
        LoginHistory loginhistory = new LoginHistory(new Date(1558003279458L), "ef588d68-8762-4694-9e07-e2a956f40832",
                                                     true, "dda5d300-3355-4a3c-af66-9cf6db3e8ad3");
        assertTrue(loginhistory.isValid());
    }

    /**
     * Tests the equals method.
     */
    @SuppressWarnings("resource")
    @Test
    public void testEquals() {
        try {
            LoginHistory loginhistory1 = new LoginHistory(new Date(1558003278271L),
                                                          "d6dffac2-1523-4f6d-8285-47f36c6556e7", false,
                                                          "1f66939d-c62a-4840-a8bd-0682cee7d860");
            LoginHistory loginhistory2 = new LoginHistory(new Date(1558003278271L),
                                                          "d6dffac2-1523-4f6d-8285-47f36c6556e7", false,
                                                          "1f66939d-c62a-4840-a8bd-0682cee7d860");
            LoginHistory loginhistory3 = new LoginHistory(new Date(1558003275629L),
                                                          "32c8abfb-0dfa-43b3-be14-2548335aafe6", false,
                                                          "579cbeaf-d94c-4114-a386-45d2849b9553");
            assertNotNull(loginhistory1);
            assertNotNull(loginhistory2);
            assertNotNull(loginhistory3);
            assertNotSame(loginhistory2, loginhistory1);
            assertNotSame(loginhistory3, loginhistory1);
            assertEquals(loginhistory2, loginhistory1);
            assertEquals(loginhistory2, loginhistory1);
            assertEquals(loginhistory1, loginhistory2);
            assertEquals(loginhistory1, loginhistory1);
            assertFalse(loginhistory1.equals(null));
            assertNotEquals(loginhistory3, loginhistory1);
        } catch (Exception exception) {
            fail(exception.getMessage());
        }
    }
}