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
            SubtenantLightThemeColor subtenantlightthemecolor1 = new SubtenantLightThemeColor("629c2781-a5b2-4292-bded-ec2eee0da970",
                                                                                              SubtenantLightThemeColorReference.getDefault(),
                                                                                              new Date(1559745296738L));
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
            SubtenantLightThemeColor subtenantlightthemecolor1 = new SubtenantLightThemeColor("f2c2329b-27de-4e53-babe-1bd8b18c2724",
                                                                                              SubtenantLightThemeColorReference.getDefault(),
                                                                                              new Date(1559745302751L));
            SubtenantLightThemeColor subtenantlightthemecolor2 = new SubtenantLightThemeColor("f2c2329b-27de-4e53-babe-1bd8b18c2724",
                                                                                              SubtenantLightThemeColorReference.getDefault(),
                                                                                              new Date(1559745302751L));
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
        SubtenantLightThemeColor subtenantlightthemecolor = new SubtenantLightThemeColor("06fb9983-c2f7-4f4f-809b-06fcce923ec4",
                                                                                         SubtenantLightThemeColorReference.getDefault(),
                                                                                         new Date(1559745295464L));
        assertTrue(subtenantlightthemecolor.isValid());
        SubtenantLightThemeColor subtenantlightthemecolorInvalid = new SubtenantLightThemeColor("65f1a5da-94d9-4257-b775-67a5a9cf59fa",
                                                                                                SubtenantLightThemeColorReference.getDefault(),
                                                                                                new Date(1559745298374L));
        assertFalse(subtenantlightthemecolorInvalid.isValid());
    }

    /**
     * Tests the equals method.
     */
    @SuppressWarnings("resource")
    @Test
    public void testEquals() {
        try {
            SubtenantLightThemeColor subtenantlightthemecolor1 = new SubtenantLightThemeColor("6df165e5-ba80-4f38-a5b7-9641fe43bef3",
                                                                                              SubtenantLightThemeColorReference.getDefault(),
                                                                                              new Date(1559745295815L));
            SubtenantLightThemeColor subtenantlightthemecolor2 = new SubtenantLightThemeColor("6df165e5-ba80-4f38-a5b7-9641fe43bef3",
                                                                                              SubtenantLightThemeColorReference.getDefault(),
                                                                                              new Date(1559745295815L));
            SubtenantLightThemeColor subtenantlightthemecolor3 = new SubtenantLightThemeColor("7cec5093-3d7e-4338-8b61-ec9d2ca2edf6",
                                                                                              SubtenantLightThemeColorReference.getDefault(),
                                                                                              new Date(1559745300854L));
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
