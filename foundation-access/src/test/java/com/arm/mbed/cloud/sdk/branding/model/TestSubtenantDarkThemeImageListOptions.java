// This file was generated by the Pelion SDK foundation code generator.
// This is an autogenerated unit test class. Do not modify its content as modifications will be lost at next code generation.
package com.arm.mbed.cloud.sdk.branding.model;

import static org.junit.Assert.*;

import com.arm.mbed.cloud.sdk.common.Order;
import org.junit.Test;

/**
 * Unit tests for Model SubtenantDarkThemeImageListOptions.
 */
@SuppressWarnings("PMD.AvoidDuplicateLiterals")
public class TestSubtenantDarkThemeImageListOptions {
    /**
     * Tests the clone method.
     */
    @SuppressWarnings("resource")
    @Test
    public void testClone() {
        try {
            SubtenantDarkThemeImageListOptions subtenantdarkthemeimagelistoptions1 = new SubtenantDarkThemeImageListOptions(Integer.valueOf(22),
                                                                                                                            Long.valueOf(97),
                                                                                                                            Order.getDefault(),
                                                                                                                            "073704c7-9971-489b-b3b3-619759e4da79",
                                                                                                                            null,
                                                                                                                            null);
            SubtenantDarkThemeImageListOptions subtenantdarkthemeimagelistoptions2 = subtenantdarkthemeimagelistoptions1.clone();
            assertNotNull(subtenantdarkthemeimagelistoptions1);
            assertNotNull(subtenantdarkthemeimagelistoptions2);
            assertNotSame(subtenantdarkthemeimagelistoptions2, subtenantdarkthemeimagelistoptions1);
            assertEquals(subtenantdarkthemeimagelistoptions2, subtenantdarkthemeimagelistoptions1);
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
            SubtenantDarkThemeImageListOptions subtenantdarkthemeimagelistoptions1 = new SubtenantDarkThemeImageListOptions(Integer.valueOf(-58),
                                                                                                                            Long.valueOf(63),
                                                                                                                            Order.getDefault(),
                                                                                                                            "52a58a95-a247-4d56-a350-4343739203e0",
                                                                                                                            null,
                                                                                                                            null);
            SubtenantDarkThemeImageListOptions subtenantdarkthemeimagelistoptions2 = new SubtenantDarkThemeImageListOptions(Integer.valueOf(-58),
                                                                                                                            Long.valueOf(63),
                                                                                                                            Order.getDefault(),
                                                                                                                            "52a58a95-a247-4d56-a350-4343739203e0",
                                                                                                                            null,
                                                                                                                            null);
            assertNotNull(subtenantdarkthemeimagelistoptions1);
            assertNotNull(subtenantdarkthemeimagelistoptions2);
            assertNotSame(subtenantdarkthemeimagelistoptions2, subtenantdarkthemeimagelistoptions1);
            assertEquals(subtenantdarkthemeimagelistoptions2, subtenantdarkthemeimagelistoptions1);
            assertEquals(subtenantdarkthemeimagelistoptions2.hashCode(),
                         subtenantdarkthemeimagelistoptions1.hashCode());
            int hashCode = subtenantdarkthemeimagelistoptions1.hashCode();
            for (int i = 0; i < 5; i++) {
                assertEquals(hashCode, subtenantdarkthemeimagelistoptions1.hashCode());
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
            SubtenantDarkThemeImageListOptions subtenantdarkthemeimagelistoptions1 = new SubtenantDarkThemeImageListOptions(Integer.valueOf(69),
                                                                                                                            Long.valueOf(-16),
                                                                                                                            Order.getDefault(),
                                                                                                                            "8ee1bca9-e75c-45c1-b4ff-c53a956c6451",
                                                                                                                            null,
                                                                                                                            null);
            SubtenantDarkThemeImageListOptions subtenantdarkthemeimagelistoptions2 = new SubtenantDarkThemeImageListOptions(Integer.valueOf(69),
                                                                                                                            Long.valueOf(-16),
                                                                                                                            Order.getDefault(),
                                                                                                                            "8ee1bca9-e75c-45c1-b4ff-c53a956c6451",
                                                                                                                            null,
                                                                                                                            null);
            SubtenantDarkThemeImageListOptions subtenantdarkthemeimagelistoptions3 = new SubtenantDarkThemeImageListOptions(Integer.valueOf(-24),
                                                                                                                            Long.valueOf(29),
                                                                                                                            Order.getDefault(),
                                                                                                                            "12f49a32-04e2-48a2-8552-a6b29dbadd69",
                                                                                                                            null,
                                                                                                                            null);
            assertNotNull(subtenantdarkthemeimagelistoptions1);
            assertNotNull(subtenantdarkthemeimagelistoptions2);
            assertNotNull(subtenantdarkthemeimagelistoptions3);
            assertNotSame(subtenantdarkthemeimagelistoptions2, subtenantdarkthemeimagelistoptions1);
            assertNotSame(subtenantdarkthemeimagelistoptions3, subtenantdarkthemeimagelistoptions1);
            assertEquals(subtenantdarkthemeimagelistoptions2, subtenantdarkthemeimagelistoptions1);
            assertEquals(subtenantdarkthemeimagelistoptions2, subtenantdarkthemeimagelistoptions1);
            assertEquals(subtenantdarkthemeimagelistoptions1, subtenantdarkthemeimagelistoptions2);
            assertEquals(subtenantdarkthemeimagelistoptions1, subtenantdarkthemeimagelistoptions1);
            assertFalse(subtenantdarkthemeimagelistoptions1.equals(null));
            assertNotEquals(subtenantdarkthemeimagelistoptions3, subtenantdarkthemeimagelistoptions1);
        } catch (Exception exception) {
            fail(exception.getMessage());
        }
    }
}
