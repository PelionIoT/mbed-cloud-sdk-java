// This file was generated by the Pelion SDK foundation code generator.
// This is an autogenerated unit test class. Do not modify its content as modifications will be lost at next code generation.
package com.arm.mbed.cloud.sdk.security.model;

import static org.junit.Assert.*;

import com.arm.mbed.cloud.sdk.common.Order;
import org.junit.Test;

/**
 * Unit tests for Model PreSharedKeyListOptions.
 */
@SuppressWarnings("PMD.AvoidDuplicateLiterals")
public class TestPreSharedKeyListOptions {
    /**
     * Tests the clone method.
     */
    @SuppressWarnings("resource")
    @Test
    public void testClone() {
        try {
            PreSharedKeyListOptions presharedkeylistoptions1 = new PreSharedKeyListOptions(Integer.valueOf(102),
                                                                                           Long.valueOf(-21),
                                                                                           Order.getDefault(),
                                                                                           "3a148308-f9ed-4d0b-a16f-5b75fe86e8ec",
                                                                                           null, null);
            PreSharedKeyListOptions presharedkeylistoptions2 = presharedkeylistoptions1.clone();
            assertNotNull(presharedkeylistoptions1);
            assertNotNull(presharedkeylistoptions2);
            assertNotSame(presharedkeylistoptions2, presharedkeylistoptions1);
            assertEquals(presharedkeylistoptions2, presharedkeylistoptions1);
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
            PreSharedKeyListOptions presharedkeylistoptions1 = new PreSharedKeyListOptions(Integer.valueOf(-10),
                                                                                           Long.valueOf(-25),
                                                                                           Order.getDefault(),
                                                                                           "0dd6357e-ac03-4d78-9964-7b2fe248733f",
                                                                                           null, null);
            PreSharedKeyListOptions presharedkeylistoptions2 = new PreSharedKeyListOptions(Integer.valueOf(-10),
                                                                                           Long.valueOf(-25),
                                                                                           Order.getDefault(),
                                                                                           "0dd6357e-ac03-4d78-9964-7b2fe248733f",
                                                                                           null, null);
            assertNotNull(presharedkeylistoptions1);
            assertNotNull(presharedkeylistoptions2);
            assertNotSame(presharedkeylistoptions2, presharedkeylistoptions1);
            assertEquals(presharedkeylistoptions2, presharedkeylistoptions1);
            assertEquals(presharedkeylistoptions2.hashCode(), presharedkeylistoptions1.hashCode());
            int hashCode = presharedkeylistoptions1.hashCode();
            for (int i = 0; i < 5; i++) {
                assertEquals(hashCode, presharedkeylistoptions1.hashCode());
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
            PreSharedKeyListOptions presharedkeylistoptions1 = new PreSharedKeyListOptions(Integer.valueOf(67),
                                                                                           Long.valueOf(-86),
                                                                                           Order.getDefault(),
                                                                                           "24eb9801-a60f-4490-9750-c743db2d0d9a",
                                                                                           null, null);
            PreSharedKeyListOptions presharedkeylistoptions2 = new PreSharedKeyListOptions(Integer.valueOf(67),
                                                                                           Long.valueOf(-86),
                                                                                           Order.getDefault(),
                                                                                           "24eb9801-a60f-4490-9750-c743db2d0d9a",
                                                                                           null, null);
            PreSharedKeyListOptions presharedkeylistoptions3 = new PreSharedKeyListOptions(Integer.valueOf(-27),
                                                                                           Long.valueOf(73),
                                                                                           Order.getDefault(),
                                                                                           "565dcaee-b453-4ec2-8d98-f8e0e1f2f6cf",
                                                                                           null, null);
            assertNotNull(presharedkeylistoptions1);
            assertNotNull(presharedkeylistoptions2);
            assertNotNull(presharedkeylistoptions3);
            assertNotSame(presharedkeylistoptions2, presharedkeylistoptions1);
            assertNotSame(presharedkeylistoptions3, presharedkeylistoptions1);
            assertEquals(presharedkeylistoptions2, presharedkeylistoptions1);
            assertEquals(presharedkeylistoptions2, presharedkeylistoptions1);
            assertEquals(presharedkeylistoptions1, presharedkeylistoptions2);
            assertEquals(presharedkeylistoptions1, presharedkeylistoptions1);
            assertFalse(presharedkeylistoptions1.equals(null));
            assertNotEquals(presharedkeylistoptions3, presharedkeylistoptions1);
        } catch (Exception exception) {
            fail(exception.getMessage());
        }
    }
}
