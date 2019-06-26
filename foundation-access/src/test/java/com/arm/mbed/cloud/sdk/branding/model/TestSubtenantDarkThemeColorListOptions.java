// This file was generated by the Pelion SDK foundation code generator.
// This is an autogenerated unit test class. Do not modify its content as modifications will be lost at next code generation.
package com.arm.mbed.cloud.sdk.branding.model;

import static org.junit.Assert.*;

import com.arm.mbed.cloud.sdk.common.Order;
import org.junit.Test;

/**
 * Unit tests for Model SubtenantDarkThemeColorListOptions.
 */
@SuppressWarnings("PMD.AvoidDuplicateLiterals")
public class TestSubtenantDarkThemeColorListOptions {
    /**
     * Tests the clone method.
     */
    @SuppressWarnings("resource")
    @Test
    public void testClone() {
        try {
            SubtenantDarkThemeColorListOptions subtenantdarkthemecolorlistoptions1 = new SubtenantDarkThemeColorListOptions(Integer.valueOf(-52),
                                                                                                                            Long.valueOf(114),
                                                                                                                            Order.getDefault(),
                                                                                                                            "48500cc8-aeae-4667-929b-ee625e76d658",
                                                                                                                            null,
                                                                                                                            null);
            SubtenantDarkThemeColorListOptions subtenantdarkthemecolorlistoptions2 = subtenantdarkthemecolorlistoptions1.clone();
            assertNotNull(subtenantdarkthemecolorlistoptions1);
            assertNotNull(subtenantdarkthemecolorlistoptions2);
            assertNotSame(subtenantdarkthemecolorlistoptions2, subtenantdarkthemecolorlistoptions1);
            assertEquals(subtenantdarkthemecolorlistoptions2, subtenantdarkthemecolorlistoptions1);
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
            SubtenantDarkThemeColorListOptions subtenantdarkthemecolorlistoptions1 = new SubtenantDarkThemeColorListOptions(Integer.valueOf(9),
                                                                                                                            Long.valueOf(-8),
                                                                                                                            Order.getDefault(),
                                                                                                                            "78982279-e136-4ca2-90d4-6fe6af49a51f",
                                                                                                                            null,
                                                                                                                            null);
            SubtenantDarkThemeColorListOptions subtenantdarkthemecolorlistoptions2 = new SubtenantDarkThemeColorListOptions(Integer.valueOf(9),
                                                                                                                            Long.valueOf(-8),
                                                                                                                            Order.getDefault(),
                                                                                                                            "78982279-e136-4ca2-90d4-6fe6af49a51f",
                                                                                                                            null,
                                                                                                                            null);
            assertNotNull(subtenantdarkthemecolorlistoptions1);
            assertNotNull(subtenantdarkthemecolorlistoptions2);
            assertNotSame(subtenantdarkthemecolorlistoptions2, subtenantdarkthemecolorlistoptions1);
            assertEquals(subtenantdarkthemecolorlistoptions2, subtenantdarkthemecolorlistoptions1);
            assertEquals(subtenantdarkthemecolorlistoptions2.hashCode(),
                         subtenantdarkthemecolorlistoptions1.hashCode());
            int hashCode = subtenantdarkthemecolorlistoptions1.hashCode();
            for (int i = 0; i < 5; i++) {
                assertEquals(hashCode, subtenantdarkthemecolorlistoptions1.hashCode());
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
            SubtenantDarkThemeColorListOptions subtenantdarkthemecolorlistoptions1 = new SubtenantDarkThemeColorListOptions(Integer.valueOf(-107),
                                                                                                                            Long.valueOf(114),
                                                                                                                            Order.getDefault(),
                                                                                                                            "7ae31539-396d-4769-920c-528099a182b0",
                                                                                                                            null,
                                                                                                                            null);
            SubtenantDarkThemeColorListOptions subtenantdarkthemecolorlistoptions2 = new SubtenantDarkThemeColorListOptions(Integer.valueOf(-107),
                                                                                                                            Long.valueOf(114),
                                                                                                                            Order.getDefault(),
                                                                                                                            "7ae31539-396d-4769-920c-528099a182b0",
                                                                                                                            null,
                                                                                                                            null);
            SubtenantDarkThemeColorListOptions subtenantdarkthemecolorlistoptions3 = new SubtenantDarkThemeColorListOptions(Integer.valueOf(-65),
                                                                                                                            Long.valueOf(-45),
                                                                                                                            Order.getDefault(),
                                                                                                                            "85362047-f379-4a80-a626-1178e737cdcf",
                                                                                                                            null,
                                                                                                                            null);
            assertNotNull(subtenantdarkthemecolorlistoptions1);
            assertNotNull(subtenantdarkthemecolorlistoptions2);
            assertNotNull(subtenantdarkthemecolorlistoptions3);
            assertNotSame(subtenantdarkthemecolorlistoptions2, subtenantdarkthemecolorlistoptions1);
            assertNotSame(subtenantdarkthemecolorlistoptions3, subtenantdarkthemecolorlistoptions1);
            assertEquals(subtenantdarkthemecolorlistoptions2, subtenantdarkthemecolorlistoptions1);
            assertEquals(subtenantdarkthemecolorlistoptions2, subtenantdarkthemecolorlistoptions1);
            assertEquals(subtenantdarkthemecolorlistoptions1, subtenantdarkthemecolorlistoptions2);
            assertEquals(subtenantdarkthemecolorlistoptions1, subtenantdarkthemecolorlistoptions1);
            assertFalse(subtenantdarkthemecolorlistoptions1.equals(null));
            assertNotEquals(subtenantdarkthemecolorlistoptions3, subtenantdarkthemecolorlistoptions1);
        } catch (Exception exception) {
            fail(exception.getMessage());
        }
    }
}
