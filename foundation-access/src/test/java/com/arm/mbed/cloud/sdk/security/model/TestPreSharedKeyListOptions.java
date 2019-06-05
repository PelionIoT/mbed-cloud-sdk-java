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
            PreSharedKeyListOptions presharedkeylistoptions1 = new PreSharedKeyListOptions(Integer.valueOf(-119),
                                                                                           Long.valueOf(121),
                                                                                           Order.getDefault(),
                                                                                           "dcd38e26-88ef-4ed5-81fd-15a0126c0d87",
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
            PreSharedKeyListOptions presharedkeylistoptions1 = new PreSharedKeyListOptions(Integer.valueOf(99),
                                                                                           Long.valueOf(1),
                                                                                           Order.getDefault(),
                                                                                           "3ab4d653-12b6-41e8-91b8-3ef9a19b1224",
                                                                                           null, null);
            PreSharedKeyListOptions presharedkeylistoptions2 = new PreSharedKeyListOptions(Integer.valueOf(99),
                                                                                           Long.valueOf(1),
                                                                                           Order.getDefault(),
                                                                                           "3ab4d653-12b6-41e8-91b8-3ef9a19b1224",
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
            PreSharedKeyListOptions presharedkeylistoptions1 = new PreSharedKeyListOptions(Integer.valueOf(-73),
                                                                                           Long.valueOf(107),
                                                                                           Order.getDefault(),
                                                                                           "2bd447d4-f15d-463c-9755-b43636cd6105",
                                                                                           null, null);
            PreSharedKeyListOptions presharedkeylistoptions2 = new PreSharedKeyListOptions(Integer.valueOf(-73),
                                                                                           Long.valueOf(107),
                                                                                           Order.getDefault(),
                                                                                           "2bd447d4-f15d-463c-9755-b43636cd6105",
                                                                                           null, null);
            PreSharedKeyListOptions presharedkeylistoptions3 = new PreSharedKeyListOptions(Integer.valueOf(20),
                                                                                           Long.valueOf(-44),
                                                                                           Order.getDefault(),
                                                                                           "70acbc69-a531-43fe-89e6-7e796fa262ee",
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
