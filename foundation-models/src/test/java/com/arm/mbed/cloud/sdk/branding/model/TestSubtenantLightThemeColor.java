// This file was generated by the Pelion SDK foundation code generator.
// This is an autogenerated unit test class. Do not modify its content as modifications will be lost at next code generation.
package com.arm.mbed.cloud.sdk.branding.model;

import static org.junit.Assert.*;

import java.util.Date;
import org.junit.Test;

/**
 * Unit tests for Model SubtenantLightThemeColor.
 */
@SuppressWarnings("PMD.AvoidDuplicateLiterals")
public class TestSubtenantLightThemeColor {
    /**
     * Tests the clone method.
     */
    @SuppressWarnings("resource")
    @Test
    public void testClone() {
        try {
            SubtenantLightThemeColor subtenantlightthemecolor1 = new SubtenantLightThemeColor("e9aeb992-437e-47e4-9c54-b0e7555a3bf4",
                                                                                              SubtenantLightThemeColorReference.getDefault(),
                                                                                              new Date(1559747928468L));
            SubtenantLightThemeColor subtenantlightthemecolor2 = subtenantlightthemecolor1.clone();
            assertNotNull(subtenantlightthemecolor1);
            assertNotNull(subtenantlightthemecolor2);
            assertNotSame(subtenantlightthemecolor2, subtenantlightthemecolor1);
            assertEquals(subtenantlightthemecolor2, subtenantlightthemecolor1);
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
            SubtenantLightThemeColor subtenantlightthemecolor1 = new SubtenantLightThemeColor("850f5393-a00e-46fb-87d2-0b46080aa7fa",
                                                                                              SubtenantLightThemeColorReference.getDefault(),
                                                                                              new Date(1559747934620L));
            SubtenantLightThemeColor subtenantlightthemecolor2 = new SubtenantLightThemeColor("850f5393-a00e-46fb-87d2-0b46080aa7fa",
                                                                                              SubtenantLightThemeColorReference.getDefault(),
                                                                                              new Date(1559747934620L));
            assertNotNull(subtenantlightthemecolor1);
            assertNotNull(subtenantlightthemecolor2);
            assertNotSame(subtenantlightthemecolor2, subtenantlightthemecolor1);
            assertEquals(subtenantlightthemecolor2, subtenantlightthemecolor1);
            assertEquals(subtenantlightthemecolor2.hashCode(), subtenantlightthemecolor1.hashCode());
            int hashCode = subtenantlightthemecolor1.hashCode();
            for (int i = 0; i < 5; i++) {
                assertEquals(hashCode, subtenantlightthemecolor1.hashCode());
            }
        } catch (Exception exception) {
            fail(exception.getMessage());
        }
    }

    /**
     * Tests the isValid method.
     */
    @SuppressWarnings("resource")
    @Test
    public void testIsValid() {
        SubtenantLightThemeColor subtenantlightthemecolor = new SubtenantLightThemeColor("33bffbc2-d3fa-44ad-b98c-e276b64f0ce4",
                                                                                         SubtenantLightThemeColorReference.getDefault(),
                                                                                         new Date(1559747927620L));
        assertTrue(subtenantlightthemecolor.isValid());
        SubtenantLightThemeColor subtenantlightthemecolorInvalid = new SubtenantLightThemeColor("1034bbb8-2766-450f-91e3-92f00f6b882d",
                                                                                                SubtenantLightThemeColorReference.getDefault(),
                                                                                                new Date(1559747926098L));
        assertFalse(subtenantlightthemecolorInvalid.isValid());
    }

    /**
     * Tests the equals method.
     */
    @SuppressWarnings("resource")
    @Test
    public void testEquals() {
        try {
            SubtenantLightThemeColor subtenantlightthemecolor1 = new SubtenantLightThemeColor("a1a8c4e9-f034-4a2c-9468-2cd34db6bb2d",
                                                                                              SubtenantLightThemeColorReference.getDefault(),
                                                                                              new Date(1559747928329L));
            SubtenantLightThemeColor subtenantlightthemecolor2 = new SubtenantLightThemeColor("a1a8c4e9-f034-4a2c-9468-2cd34db6bb2d",
                                                                                              SubtenantLightThemeColorReference.getDefault(),
                                                                                              new Date(1559747928329L));
            SubtenantLightThemeColor subtenantlightthemecolor3 = new SubtenantLightThemeColor("f3cc5037-ef9a-4d81-9f8c-7548ce20de14",
                                                                                              SubtenantLightThemeColorReference.getDefault(),
                                                                                              new Date(1559747930313L));
            assertNotNull(subtenantlightthemecolor1);
            assertNotNull(subtenantlightthemecolor2);
            assertNotNull(subtenantlightthemecolor3);
            assertNotSame(subtenantlightthemecolor2, subtenantlightthemecolor1);
            assertNotSame(subtenantlightthemecolor3, subtenantlightthemecolor1);
            assertEquals(subtenantlightthemecolor2, subtenantlightthemecolor1);
            assertEquals(subtenantlightthemecolor2, subtenantlightthemecolor1);
            assertEquals(subtenantlightthemecolor1, subtenantlightthemecolor2);
            assertEquals(subtenantlightthemecolor1, subtenantlightthemecolor1);
            assertFalse(subtenantlightthemecolor1.equals(null));
            assertNotEquals(subtenantlightthemecolor3, subtenantlightthemecolor1);
        } catch (Exception exception) {
            fail(exception.getMessage());
        }
    }
}
