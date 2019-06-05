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
            SubtenantDarkThemeColorListOptions subtenantdarkthemecolorlistoptions1 = new SubtenantDarkThemeColorListOptions(Integer.valueOf(-44),
                                                                                                                            Long.valueOf(-38),
                                                                                                                            Order.getDefault(),
                                                                                                                            "940d2f64-363b-4fbf-83bd-c11549ec5705",
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
            SubtenantDarkThemeColorListOptions subtenantdarkthemecolorlistoptions1 = new SubtenantDarkThemeColorListOptions(Integer.valueOf(-43),
                                                                                                                            Long.valueOf(-100),
                                                                                                                            Order.getDefault(),
                                                                                                                            "68ced9fa-dfb0-422d-b732-974c2aa068bf",
                                                                                                                            null,
                                                                                                                            null);
            SubtenantDarkThemeColorListOptions subtenantdarkthemecolorlistoptions2 = new SubtenantDarkThemeColorListOptions(Integer.valueOf(-43),
                                                                                                                            Long.valueOf(-100),
                                                                                                                            Order.getDefault(),
                                                                                                                            "68ced9fa-dfb0-422d-b732-974c2aa068bf",
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
            SubtenantDarkThemeColorListOptions subtenantdarkthemecolorlistoptions1 = new SubtenantDarkThemeColorListOptions(Integer.valueOf(56),
                                                                                                                            Long.valueOf(30),
                                                                                                                            Order.getDefault(),
                                                                                                                            "5d482be8-534b-4441-91d5-708d05279f3a",
                                                                                                                            null,
                                                                                                                            null);
            SubtenantDarkThemeColorListOptions subtenantdarkthemecolorlistoptions2 = new SubtenantDarkThemeColorListOptions(Integer.valueOf(56),
                                                                                                                            Long.valueOf(30),
                                                                                                                            Order.getDefault(),
                                                                                                                            "5d482be8-534b-4441-91d5-708d05279f3a",
                                                                                                                            null,
                                                                                                                            null);
            SubtenantDarkThemeColorListOptions subtenantdarkthemecolorlistoptions3 = new SubtenantDarkThemeColorListOptions(Integer.valueOf(-52),
                                                                                                                            Long.valueOf(6),
                                                                                                                            Order.getDefault(),
                                                                                                                            "9def4d2e-b9a7-42b6-8c62-c37500e275ff",
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
