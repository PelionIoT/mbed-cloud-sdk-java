// This file was generated by the Pelion SDK foundation code generator.
// This is an autogenerated unit test class. Do not modify its content as modifications will be lost at next code generation.
package com.arm.mbed.cloud.sdk.branding.model;

import static org.junit.Assert.*;

import com.arm.mbed.cloud.sdk.common.Order;
import org.junit.Test;

/**
 * Unit tests for Model SubtenantLightThemeImageListOptions.
 */
@SuppressWarnings("PMD.AvoidDuplicateLiterals")
public class TestSubtenantLightThemeImageListOptions {
    /**
     * Tests the clone method.
     */
    @SuppressWarnings("resource")
    @Test
    public void testClone() {
        try {
            SubtenantLightThemeImageListOptions subtenantlightthemeimagelistoptions1 = new SubtenantLightThemeImageListOptions(Integer.valueOf(-75),
                                                                                                                               Long.valueOf(-88),
                                                                                                                               Order.getDefault(),
                                                                                                                               "a9350fc5-f21f-4b42-8cbd-1ba389f93d15",
                                                                                                                               null,
                                                                                                                               null);
            SubtenantLightThemeImageListOptions subtenantlightthemeimagelistoptions2 = subtenantlightthemeimagelistoptions1.clone();
            assertNotNull(subtenantlightthemeimagelistoptions1);
            assertNotNull(subtenantlightthemeimagelistoptions2);
            assertNotSame(subtenantlightthemeimagelistoptions2, subtenantlightthemeimagelistoptions1);
            assertEquals(subtenantlightthemeimagelistoptions2, subtenantlightthemeimagelistoptions1);
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
            SubtenantLightThemeImageListOptions subtenantlightthemeimagelistoptions1 = new SubtenantLightThemeImageListOptions(Integer.valueOf(82),
                                                                                                                               Long.valueOf(1),
                                                                                                                               Order.getDefault(),
                                                                                                                               "e2255377-1b03-4199-be63-006dc36b1617",
                                                                                                                               null,
                                                                                                                               null);
            SubtenantLightThemeImageListOptions subtenantlightthemeimagelistoptions2 = new SubtenantLightThemeImageListOptions(Integer.valueOf(82),
                                                                                                                               Long.valueOf(1),
                                                                                                                               Order.getDefault(),
                                                                                                                               "e2255377-1b03-4199-be63-006dc36b1617",
                                                                                                                               null,
                                                                                                                               null);
            assertNotNull(subtenantlightthemeimagelistoptions1);
            assertNotNull(subtenantlightthemeimagelistoptions2);
            assertNotSame(subtenantlightthemeimagelistoptions2, subtenantlightthemeimagelistoptions1);
            assertEquals(subtenantlightthemeimagelistoptions2, subtenantlightthemeimagelistoptions1);
            assertEquals(subtenantlightthemeimagelistoptions2.hashCode(),
                         subtenantlightthemeimagelistoptions1.hashCode());
            int hashCode = subtenantlightthemeimagelistoptions1.hashCode();
            for (int i = 0; i < 5; i++) {
                assertEquals(hashCode, subtenantlightthemeimagelistoptions1.hashCode());
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
            SubtenantLightThemeImageListOptions subtenantlightthemeimagelistoptions1 = new SubtenantLightThemeImageListOptions(Integer.valueOf(-101),
                                                                                                                               Long.valueOf(-103),
                                                                                                                               Order.getDefault(),
                                                                                                                               "f5e4c90b-181e-435e-8d70-80f2769b7571",
                                                                                                                               null,
                                                                                                                               null);
            SubtenantLightThemeImageListOptions subtenantlightthemeimagelistoptions2 = new SubtenantLightThemeImageListOptions(Integer.valueOf(-101),
                                                                                                                               Long.valueOf(-103),
                                                                                                                               Order.getDefault(),
                                                                                                                               "f5e4c90b-181e-435e-8d70-80f2769b7571",
                                                                                                                               null,
                                                                                                                               null);
            SubtenantLightThemeImageListOptions subtenantlightthemeimagelistoptions3 = new SubtenantLightThemeImageListOptions(Integer.valueOf(-123),
                                                                                                                               Long.valueOf(108),
                                                                                                                               Order.getDefault(),
                                                                                                                               "4a0fabdb-b884-4a0e-8eaf-b59bbbb57a17",
                                                                                                                               null,
                                                                                                                               null);
            assertNotNull(subtenantlightthemeimagelistoptions1);
            assertNotNull(subtenantlightthemeimagelistoptions2);
            assertNotNull(subtenantlightthemeimagelistoptions3);
            assertNotSame(subtenantlightthemeimagelistoptions2, subtenantlightthemeimagelistoptions1);
            assertNotSame(subtenantlightthemeimagelistoptions3, subtenantlightthemeimagelistoptions1);
            assertEquals(subtenantlightthemeimagelistoptions2, subtenantlightthemeimagelistoptions1);
            assertEquals(subtenantlightthemeimagelistoptions2, subtenantlightthemeimagelistoptions1);
            assertEquals(subtenantlightthemeimagelistoptions1, subtenantlightthemeimagelistoptions2);
            assertEquals(subtenantlightthemeimagelistoptions1, subtenantlightthemeimagelistoptions1);
            assertFalse(subtenantlightthemeimagelistoptions1.equals(null));
            assertNotEquals(subtenantlightthemeimagelistoptions3, subtenantlightthemeimagelistoptions1);
        } catch (Exception exception) {
            fail(exception.getMessage());
        }
    }
}
