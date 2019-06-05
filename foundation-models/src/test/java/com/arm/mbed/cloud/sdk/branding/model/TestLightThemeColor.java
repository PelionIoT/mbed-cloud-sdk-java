// This file was generated by the Pelion SDK foundation code generator.
// This is an autogenerated unit test class. Do not modify its content as modifications will be lost at next code generation.
package com.arm.mbed.cloud.sdk.branding.model;

import static org.junit.Assert.*;

import java.util.Date;
import org.junit.Test;

/**
 * Unit tests for Model LightThemeColor.
 */
@SuppressWarnings("PMD.AvoidDuplicateLiterals")
public class TestLightThemeColor {
    /**
     * Tests the clone method.
     */
    @SuppressWarnings("resource")
    @Test
    public void testClone() {
        try {
            LightThemeColor lightthemecolor1 = new LightThemeColor("99112ad4-fb0b-4e60-a3d7-6b5bb49a89e8",
                                                                   LightThemeColorReference.getDefault(),
                                                                   new Date(1559747934357L));
            LightThemeColor lightthemecolor2 = lightthemecolor1.clone();
            assertNotNull(lightthemecolor1);
            assertNotNull(lightthemecolor2);
            assertNotSame(lightthemecolor2, lightthemecolor1);
            assertEquals(lightthemecolor2, lightthemecolor1);
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
            LightThemeColor lightthemecolor1 = new LightThemeColor("b45b65bb-edd8-4038-9375-c16ba427f162",
                                                                   LightThemeColorReference.getDefault(),
                                                                   new Date(1559747931893L));
            LightThemeColor lightthemecolor2 = new LightThemeColor("b45b65bb-edd8-4038-9375-c16ba427f162",
                                                                   LightThemeColorReference.getDefault(),
                                                                   new Date(1559747931893L));
            assertNotNull(lightthemecolor1);
            assertNotNull(lightthemecolor2);
            assertNotSame(lightthemecolor2, lightthemecolor1);
            assertEquals(lightthemecolor2, lightthemecolor1);
            assertEquals(lightthemecolor2.hashCode(), lightthemecolor1.hashCode());
            int hashCode = lightthemecolor1.hashCode();
            for (int i = 0; i < 5; i++) {
                assertEquals(hashCode, lightthemecolor1.hashCode());
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
        LightThemeColor lightthemecolor = new LightThemeColor("0f0239fc-decc-4473-9ab6-303fbae6f75d",
                                                              LightThemeColorReference.getDefault(),
                                                              new Date(1559747929642L));
        assertTrue(lightthemecolor.isValid());
        LightThemeColor lightthemecolorInvalid = new LightThemeColor("3857f66e-5725-4e82-9737-21c723596277",
                                                                     LightThemeColorReference.getDefault(),
                                                                     new Date(1559747932073L));
        assertFalse(lightthemecolorInvalid.isValid());
    }

    /**
     * Tests the equals method.
     */
    @SuppressWarnings("resource")
    @Test
    public void testEquals() {
        try {
            LightThemeColor lightthemecolor1 = new LightThemeColor("4f8d9356-63a3-4186-b9e9-c7fe7f542061",
                                                                   LightThemeColorReference.getDefault(),
                                                                   new Date(1559747926760L));
            LightThemeColor lightthemecolor2 = new LightThemeColor("4f8d9356-63a3-4186-b9e9-c7fe7f542061",
                                                                   LightThemeColorReference.getDefault(),
                                                                   new Date(1559747926760L));
            LightThemeColor lightthemecolor3 = new LightThemeColor("3579ede0-8c0b-49e6-8d14-7e0b7f63e680",
                                                                   LightThemeColorReference.getDefault(),
                                                                   new Date(1559747930639L));
            assertNotNull(lightthemecolor1);
            assertNotNull(lightthemecolor2);
            assertNotNull(lightthemecolor3);
            assertNotSame(lightthemecolor2, lightthemecolor1);
            assertNotSame(lightthemecolor3, lightthemecolor1);
            assertEquals(lightthemecolor2, lightthemecolor1);
            assertEquals(lightthemecolor2, lightthemecolor1);
            assertEquals(lightthemecolor1, lightthemecolor2);
            assertEquals(lightthemecolor1, lightthemecolor1);
            assertFalse(lightthemecolor1.equals(null));
            assertNotEquals(lightthemecolor3, lightthemecolor1);
        } catch (Exception exception) {
            fail(exception.getMessage());
        }
    }
}
