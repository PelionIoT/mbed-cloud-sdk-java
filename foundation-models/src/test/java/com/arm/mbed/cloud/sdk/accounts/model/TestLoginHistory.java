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
            LoginHistory loginhistory1 = new LoginHistory(new Date(1567417601437L),
                                                          "6cd26d66-3d52-4e25-b7ed-c0aa0855c0b1", false,
                                                          "9780f4a8-229c-4a64-9917-16ba627d06ac");
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
            LoginHistory loginhistory1 = new LoginHistory(new Date(1567417609402L),
                                                          "88a8209f-8ec0-4584-8b48-d5d0b9f057d4", false,
                                                          "869bccfe-33e5-4ed7-84e3-851b9840126d");
            LoginHistory loginhistory2 = new LoginHistory(new Date(1567417609402L),
                                                          "88a8209f-8ec0-4584-8b48-d5d0b9f057d4", false,
                                                          "869bccfe-33e5-4ed7-84e3-851b9840126d");
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
        LoginHistory loginhistory = new LoginHistory(new Date(1567417602555L), "9d7f8c6b-f4e4-44ac-8dcf-f11065a7c85c",
                                                     true, "92c6561e-3ed8-4168-a5ea-e43d43a79c2a");
        assertTrue(loginhistory.isValid());
    }

    /**
     * Tests the equals method.
     */
    @SuppressWarnings("resource")
    @Test
    public void testEquals() {
        try {
            LoginHistory loginhistory1 = new LoginHistory(new Date(1567417602318L),
                                                          "da2e1c68-8b65-4c79-8355-29de48c0003f", false,
                                                          "6c51c36c-d2ab-4081-b95e-2dd88de2bdb1");
            LoginHistory loginhistory2 = new LoginHistory(new Date(1567417602318L),
                                                          "da2e1c68-8b65-4c79-8355-29de48c0003f", false,
                                                          "6c51c36c-d2ab-4081-b95e-2dd88de2bdb1");
            LoginHistory loginhistory3 = new LoginHistory(new Date(1567417607825L),
                                                          "b08fdcb9-8ae7-4d57-96be-7695e8451d2c", false,
                                                          "9efe0b01-932e-455b-8fe2-f560ede68af4");
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
