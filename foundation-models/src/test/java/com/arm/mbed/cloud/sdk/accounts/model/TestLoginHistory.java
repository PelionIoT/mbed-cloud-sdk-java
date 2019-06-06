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
            LoginHistory loginhistory1 = new LoginHistory(new Date(1559833680456L),
                                                          "5254f8c7-4735-4cda-a6d6-e16960861132", false,
                                                          "c37d684f-c476-47ae-b6d3-f52c547d8878");
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
            LoginHistory loginhistory1 = new LoginHistory(new Date(1559833686842L),
                                                          "91d2a20b-f76d-44b0-8c58-aa77f94ba6a0", true,
                                                          "9627ea4d-26ab-409f-a644-6e371be2357a");
            LoginHistory loginhistory2 = new LoginHistory(new Date(1559833686842L),
                                                          "91d2a20b-f76d-44b0-8c58-aa77f94ba6a0", true,
                                                          "9627ea4d-26ab-409f-a644-6e371be2357a");
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
        LoginHistory loginhistory = new LoginHistory(new Date(1559833683520L), "d1d90029-95ef-44ec-b922-391d1b3e1b4e",
                                                     true, "a85d3335-852e-404a-aaa1-5c46dde6bbe8");
        assertTrue(loginhistory.isValid());
    }

    /**
     * Tests the equals method.
     */
    @SuppressWarnings("resource")
    @Test
    public void testEquals() {
        try {
            LoginHistory loginhistory1 = new LoginHistory(new Date(1559833686839L),
                                                          "8a55f039-30e8-47ad-b06e-dfa54fe52a46", true,
                                                          "847172ef-b7c9-4463-92b0-c44220f477ee");
            LoginHistory loginhistory2 = new LoginHistory(new Date(1559833686839L),
                                                          "8a55f039-30e8-47ad-b06e-dfa54fe52a46", true,
                                                          "847172ef-b7c9-4463-92b0-c44220f477ee");
            LoginHistory loginhistory3 = new LoginHistory(new Date(1559833686655L),
                                                          "4fd9bdd7-e2f6-44c4-bce1-c17c3f785544", true,
                                                          "6fc3e4f6-08ed-45df-aef6-52b0c72ced65");
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
