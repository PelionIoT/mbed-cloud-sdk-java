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
            SubtenantDarkThemeColorListOptions subtenantdarkthemecolorlistoptions1 = new SubtenantDarkThemeColorListOptions(Integer.valueOf(27),
                                                                                                                            Long.valueOf(-18),
                                                                                                                            Order.getDefault(),
                                                                                                                            "f238bf1b-2dbc-48e7-bfe4-15c2fb83bff4",
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
            SubtenantDarkThemeColorListOptions subtenantdarkthemecolorlistoptions1 = new SubtenantDarkThemeColorListOptions(Integer.valueOf(-87),
                                                                                                                            Long.valueOf(41),
                                                                                                                            Order.getDefault(),
                                                                                                                            "703a7289-2ba0-41b1-b950-86e840540564",
                                                                                                                            null,
                                                                                                                            null);
            SubtenantDarkThemeColorListOptions subtenantdarkthemecolorlistoptions2 = new SubtenantDarkThemeColorListOptions(Integer.valueOf(-87),
                                                                                                                            Long.valueOf(41),
                                                                                                                            Order.getDefault(),
                                                                                                                            "703a7289-2ba0-41b1-b950-86e840540564",
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
            SubtenantDarkThemeColorListOptions subtenantdarkthemecolorlistoptions1 = new SubtenantDarkThemeColorListOptions(Integer.valueOf(105),
                                                                                                                            Long.valueOf(-60),
                                                                                                                            Order.getDefault(),
                                                                                                                            "8eb777cc-f1e9-433f-a04c-17fda6b8468b",
                                                                                                                            null,
                                                                                                                            null);
            SubtenantDarkThemeColorListOptions subtenantdarkthemecolorlistoptions2 = new SubtenantDarkThemeColorListOptions(Integer.valueOf(105),
                                                                                                                            Long.valueOf(-60),
                                                                                                                            Order.getDefault(),
                                                                                                                            "8eb777cc-f1e9-433f-a04c-17fda6b8468b",
                                                                                                                            null,
                                                                                                                            null);
            SubtenantDarkThemeColorListOptions subtenantdarkthemecolorlistoptions3 = new SubtenantDarkThemeColorListOptions(Integer.valueOf(-79),
                                                                                                                            Long.valueOf(-95),
                                                                                                                            Order.getDefault(),
                                                                                                                            "1cd003c8-d39a-42a3-975a-345f980ed584",
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
