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
            DarkThemeColorListOptions darkthemecolorlistoptions1 = new DarkThemeColorListOptions(Integer.valueOf(74),
                                                                                                 Long.valueOf(59),
                                                                                                 Order.getDefault(),
                                                                                                 "63f9da13-6a65-4c25-8392-bcdfe4a6d6e4",
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
            DarkThemeColorListOptions darkthemecolorlistoptions1 = new DarkThemeColorListOptions(Integer.valueOf(114),
                                                                                                 Long.valueOf(113),
                                                                                                 Order.getDefault(),
                                                                                                 "769fb2ee-1574-4dad-83af-32b4c2ae1b63",
                                                                                                 null, null);
            DarkThemeColorListOptions darkthemecolorlistoptions2 = new DarkThemeColorListOptions(Integer.valueOf(114),
                                                                                                 Long.valueOf(113),
                                                                                                 Order.getDefault(),
                                                                                                 "769fb2ee-1574-4dad-83af-32b4c2ae1b63",
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
            DarkThemeColorListOptions darkthemecolorlistoptions1 = new DarkThemeColorListOptions(Integer.valueOf(-85),
                                                                                                 Long.valueOf(-121),
                                                                                                 Order.getDefault(),
                                                                                                 "5fbba6a1-c955-47bc-a03b-d66cdba7f17f",
                                                                                                 null, null);
            DarkThemeColorListOptions darkthemecolorlistoptions2 = new DarkThemeColorListOptions(Integer.valueOf(-85),
                                                                                                 Long.valueOf(-121),
                                                                                                 Order.getDefault(),
                                                                                                 "5fbba6a1-c955-47bc-a03b-d66cdba7f17f",
                                                                                                 null, null);
            DarkThemeColorListOptions darkthemecolorlistoptions3 = new DarkThemeColorListOptions(Integer.valueOf(35),
                                                                                                 Long.valueOf(-100),
                                                                                                 Order.getDefault(),
                                                                                                 "c02f4672-4759-4bf4-aad2-db02b68333c9",
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
