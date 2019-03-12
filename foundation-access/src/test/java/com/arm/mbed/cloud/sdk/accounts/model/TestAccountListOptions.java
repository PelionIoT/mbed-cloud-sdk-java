// This file was generated by the Pelion SDK foundation code generator.
// This is an autogenerated unit test class. Do not modify its content as modifications will be lost at next code generation.
package com.arm.mbed.cloud.sdk.accounts.model;

import static org.junit.Assert.*;

import com.arm.mbed.cloud.sdk.common.Order;
import org.junit.Test;

/**
 * Unit tests for Model AccountListOptions.
 */
@SuppressWarnings("PMD.AvoidDuplicateLiterals")
public class TestAccountListOptions {
    /**
     * Tests the clone method.
     */
    @SuppressWarnings("resource")
    @Test
    public void testClone() {
        try {
            AccountListOptions accountlistoptions1 = new AccountListOptions(Integer.valueOf(27), Long.valueOf(-61),
                                                                            Order.getDefault(),
                                                                            "8d542aa7-c0ee-4f45-822b-f4ee52b06026",
                                                                            null, null);
            AccountListOptions accountlistoptions2 = accountlistoptions1.clone();
            assertNotNull(accountlistoptions1);
            assertNotNull(accountlistoptions2);
            assertNotSame(accountlistoptions2, accountlistoptions1);
            assertEquals(accountlistoptions2, accountlistoptions1);
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
            AccountListOptions accountlistoptions1 = new AccountListOptions(Integer.valueOf(-117), Long.valueOf(101),
                                                                            Order.getDefault(),
                                                                            "e435e332-d862-474c-9325-a0799c02f362",
                                                                            null, null);
            AccountListOptions accountlistoptions2 = new AccountListOptions(Integer.valueOf(-117), Long.valueOf(101),
                                                                            Order.getDefault(),
                                                                            "e435e332-d862-474c-9325-a0799c02f362",
                                                                            null, null);
            assertNotNull(accountlistoptions1);
            assertNotNull(accountlistoptions2);
            assertNotSame(accountlistoptions2, accountlistoptions1);
            assertEquals(accountlistoptions2, accountlistoptions1);
            assertEquals(accountlistoptions2.hashCode(), accountlistoptions1.hashCode());
            int hashCode = accountlistoptions1.hashCode();
            for (int i = 0; i < 5; i++) {
                assertEquals(hashCode, accountlistoptions1.hashCode());
            }
        } catch (Exception exception) {
            fail(exception.getMessage());
        }
    }

    /**
     * Tests the equals method.
     */
    @SuppressWarnings("resource")
    @Test
    public void testEquals() {
        try {
            AccountListOptions accountlistoptions1 = new AccountListOptions(Integer.valueOf(95), Long.valueOf(59),
                                                                            Order.getDefault(),
                                                                            "08a68e9d-5b89-44af-9dd7-7722898d41cb",
                                                                            null, null);
            AccountListOptions accountlistoptions2 = new AccountListOptions(Integer.valueOf(95), Long.valueOf(59),
                                                                            Order.getDefault(),
                                                                            "08a68e9d-5b89-44af-9dd7-7722898d41cb",
                                                                            null, null);
            AccountListOptions accountlistoptions3 = new AccountListOptions(Integer.valueOf(-68), Long.valueOf(2),
                                                                            Order.getDefault(),
                                                                            "dbc4aba8-32d3-4182-8b70-71d9dbf58546",
                                                                            null, null);
            assertNotNull(accountlistoptions1);
            assertNotNull(accountlistoptions2);
            assertNotNull(accountlistoptions3);
            assertNotSame(accountlistoptions2, accountlistoptions1);
            assertNotSame(accountlistoptions3, accountlistoptions1);
            assertEquals(accountlistoptions2, accountlistoptions1);
            assertEquals(accountlistoptions2, accountlistoptions1);
            assertEquals(accountlistoptions1, accountlistoptions2);
            assertEquals(accountlistoptions1, accountlistoptions1);
            assertFalse(accountlistoptions1.equals(null));
            assertNotEquals(accountlistoptions3, accountlistoptions1);
        } catch (Exception exception) {
            fail(exception.getMessage());
        }
    }
}
