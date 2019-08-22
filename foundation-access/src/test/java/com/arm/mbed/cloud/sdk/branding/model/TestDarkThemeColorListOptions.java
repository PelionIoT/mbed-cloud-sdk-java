// This file was generated by the Pelion SDK foundation code generator.
// This is an autogenerated unit test class. Do not modify its content as modifications will be lost at next code generation.
package com.arm.mbed.cloud.sdk.branding.model;

import static org.junit.Assert.*;

import com.arm.mbed.cloud.sdk.common.Order;
import org.junit.Test;

/**
 * Unit tests for Model DarkThemeColorListOptions.
 */
@SuppressWarnings("PMD.AvoidDuplicateLiterals")
public class TestDarkThemeColorListOptions {
    /**
     * Tests the clone method.
     */
    @SuppressWarnings("resource")
    @Test
    public void testClone() {
        try {
            DarkThemeColorListOptions darkthemecolorlistoptions1 = new DarkThemeColorListOptions(Integer.valueOf(105),
                                                                                                 Long.valueOf(96),
                                                                                                 Order.getDefault(),
                                                                                                 "fb83aac2-2c7e-42d7-9fa9-5583b9c5847b",
                                                                                                 null, null);
            DarkThemeColorListOptions darkthemecolorlistoptions2 = darkthemecolorlistoptions1.clone();
            assertNotNull(darkthemecolorlistoptions1);
            assertNotNull(darkthemecolorlistoptions2);
            assertNotSame(darkthemecolorlistoptions2, darkthemecolorlistoptions1);
            assertEquals(darkthemecolorlistoptions2, darkthemecolorlistoptions1);
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
            DarkThemeColorListOptions darkthemecolorlistoptions1 = new DarkThemeColorListOptions(Integer.valueOf(14),
                                                                                                 Long.valueOf(-3),
                                                                                                 Order.getDefault(),
                                                                                                 "d4c82928-4366-4f28-82ff-394583f16326",
                                                                                                 null, null);
            DarkThemeColorListOptions darkthemecolorlistoptions2 = new DarkThemeColorListOptions(Integer.valueOf(14),
                                                                                                 Long.valueOf(-3),
                                                                                                 Order.getDefault(),
                                                                                                 "d4c82928-4366-4f28-82ff-394583f16326",
                                                                                                 null, null);
            assertNotNull(darkthemecolorlistoptions1);
            assertNotNull(darkthemecolorlistoptions2);
            assertNotSame(darkthemecolorlistoptions2, darkthemecolorlistoptions1);
            assertEquals(darkthemecolorlistoptions2, darkthemecolorlistoptions1);
            assertEquals(darkthemecolorlistoptions2.hashCode(), darkthemecolorlistoptions1.hashCode());
            int hashCode = darkthemecolorlistoptions1.hashCode();
            for (int i = 0; i < 5; i++) {
                assertEquals(hashCode, darkthemecolorlistoptions1.hashCode());
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
            DarkThemeColorListOptions darkthemecolorlistoptions1 = new DarkThemeColorListOptions(Integer.valueOf(-22),
                                                                                                 Long.valueOf(-117),
                                                                                                 Order.getDefault(),
                                                                                                 "79d10c01-3bd4-47ea-8d1d-039ff846bc53",
                                                                                                 null, null);
            DarkThemeColorListOptions darkthemecolorlistoptions2 = new DarkThemeColorListOptions(Integer.valueOf(-22),
                                                                                                 Long.valueOf(-117),
                                                                                                 Order.getDefault(),
                                                                                                 "79d10c01-3bd4-47ea-8d1d-039ff846bc53",
                                                                                                 null, null);
            DarkThemeColorListOptions darkthemecolorlistoptions3 = new DarkThemeColorListOptions(Integer.valueOf(79),
                                                                                                 Long.valueOf(40),
                                                                                                 Order.getDefault(),
                                                                                                 "d86b83f2-1047-4597-814e-737b0b4dd445",
                                                                                                 null, null);
            assertNotNull(darkthemecolorlistoptions1);
            assertNotNull(darkthemecolorlistoptions2);
            assertNotNull(darkthemecolorlistoptions3);
            assertNotSame(darkthemecolorlistoptions2, darkthemecolorlistoptions1);
            assertNotSame(darkthemecolorlistoptions3, darkthemecolorlistoptions1);
            assertEquals(darkthemecolorlistoptions2, darkthemecolorlistoptions1);
            assertEquals(darkthemecolorlistoptions2, darkthemecolorlistoptions1);
            assertEquals(darkthemecolorlistoptions1, darkthemecolorlistoptions2);
            assertEquals(darkthemecolorlistoptions1, darkthemecolorlistoptions1);
            assertFalse(darkthemecolorlistoptions1.equals(null));
            assertNotEquals(darkthemecolorlistoptions3, darkthemecolorlistoptions1);
        } catch (Exception exception) {
            fail(exception.getMessage());
        }
    }
}
