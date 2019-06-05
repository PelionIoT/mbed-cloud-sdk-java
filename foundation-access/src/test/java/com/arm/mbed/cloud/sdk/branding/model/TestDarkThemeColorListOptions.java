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
            DarkThemeColorListOptions darkthemecolorlistoptions1 = new DarkThemeColorListOptions(Integer.valueOf(-66),
                                                                                                 Long.valueOf(54),
                                                                                                 Order.getDefault(),
                                                                                                 "b1f87a83-1ed7-4911-b3e8-5a8bc5a047b0",
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
            DarkThemeColorListOptions darkthemecolorlistoptions1 = new DarkThemeColorListOptions(Integer.valueOf(69),
                                                                                                 Long.valueOf(98),
                                                                                                 Order.getDefault(),
                                                                                                 "bb823fe7-4922-436c-b133-1d6be53d9b9b",
                                                                                                 null, null);
            DarkThemeColorListOptions darkthemecolorlistoptions2 = new DarkThemeColorListOptions(Integer.valueOf(69),
                                                                                                 Long.valueOf(98),
                                                                                                 Order.getDefault(),
                                                                                                 "bb823fe7-4922-436c-b133-1d6be53d9b9b",
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
            DarkThemeColorListOptions darkthemecolorlistoptions1 = new DarkThemeColorListOptions(Integer.valueOf(34),
                                                                                                 Long.valueOf(93),
                                                                                                 Order.getDefault(),
                                                                                                 "cc095a5c-980d-47b2-87be-0750af71ec65",
                                                                                                 null, null);
            DarkThemeColorListOptions darkthemecolorlistoptions2 = new DarkThemeColorListOptions(Integer.valueOf(34),
                                                                                                 Long.valueOf(93),
                                                                                                 Order.getDefault(),
                                                                                                 "cc095a5c-980d-47b2-87be-0750af71ec65",
                                                                                                 null, null);
            DarkThemeColorListOptions darkthemecolorlistoptions3 = new DarkThemeColorListOptions(Integer.valueOf(78),
                                                                                                 Long.valueOf(77),
                                                                                                 Order.getDefault(),
                                                                                                 "9b7cc1f0-802c-41d5-bf1c-33396bd58fa7",
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
