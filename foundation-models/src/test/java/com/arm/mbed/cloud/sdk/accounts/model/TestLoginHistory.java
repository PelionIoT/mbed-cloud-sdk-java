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
            LoginHistory loginhistory1 = new LoginHistory(new Date(1559752150639L),
                                                          "4627f0c5-a885-4aab-9204-fee404fcb6c3", false,
                                                          "da54882d-7abd-4174-87a0-866590db4b06");
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
            LoginHistory loginhistory1 = new LoginHistory(new Date(1559752147352L),
                                                          "b3744a08-8a22-491d-87c6-fda85d05e78a", false,
                                                          "048e609a-098a-48d7-88f4-85b2942fb866");
            LoginHistory loginhistory2 = new LoginHistory(new Date(1559752147352L),
                                                          "b3744a08-8a22-491d-87c6-fda85d05e78a", false,
                                                          "048e609a-098a-48d7-88f4-85b2942fb866");
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
        LoginHistory loginhistory = new LoginHistory(new Date(1559752144264L), "3932f757-cbb0-4dad-a8d2-67db12fa0a4b",
                                                     false, "3b845bf4-7bf6-4e00-86f3-3d539b945ef2");
        assertTrue(loginhistory.isValid());
    }

    /**
     * Tests the equals method.
     */
    @SuppressWarnings("resource")
    @Test
    public void testEquals() {
        try {
            LoginHistory loginhistory1 = new LoginHistory(new Date(1559752144488L),
                                                          "95be5517-63ca-4333-b226-b5867ee91cc2", false,
                                                          "f35cd145-8b58-4bcb-83ee-2f0233314403");
            LoginHistory loginhistory2 = new LoginHistory(new Date(1559752144488L),
                                                          "95be5517-63ca-4333-b226-b5867ee91cc2", false,
                                                          "f35cd145-8b58-4bcb-83ee-2f0233314403");
            LoginHistory loginhistory3 = new LoginHistory(new Date(1559752144201L),
                                                          "2d4061fe-aa79-450e-8218-33798f643f28", false,
                                                          "07aea521-f75e-4396-b74c-1a3e719fbfb8");
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
