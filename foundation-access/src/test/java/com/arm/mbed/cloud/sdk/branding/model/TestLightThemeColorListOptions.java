// This file was generated by the Pelion SDK foundation code generator.
// This is an autogenerated unit test class. Do not modify its content as modifications will be lost at next code generation.
package com.arm.mbed.cloud.sdk.branding.model;

import static org.junit.Assert.*;

import com.arm.mbed.cloud.sdk.common.Order;
import org.junit.Test;

/**
 * Unit tests for Model LightThemeColorListOptions.
 */
@SuppressWarnings("PMD.AvoidDuplicateLiterals")
public class TestLightThemeColorListOptions {
    /**
     * Tests the clone method.
     */
    @SuppressWarnings("resource")
    @Test
    public void testClone() {
        try {
            LightThemeColorListOptions lightthemecolorlistoptions1 = new LightThemeColorListOptions(Integer.valueOf(-123),
                                                                                                    Long.valueOf(-77),
                                                                                                    Order.getDefault(),
                                                                                                    "132f201e-f1a7-4697-8dff-8d6f38fe0fbd",
                                                                                                    null, null);
            LightThemeColorListOptions lightthemecolorlistoptions2 = lightthemecolorlistoptions1.clone();
            assertNotNull(lightthemecolorlistoptions1);
            assertNotNull(lightthemecolorlistoptions2);
            assertNotSame(lightthemecolorlistoptions2, lightthemecolorlistoptions1);
            assertEquals(lightthemecolorlistoptions2, lightthemecolorlistoptions1);
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
            LightThemeColorListOptions lightthemecolorlistoptions1 = new LightThemeColorListOptions(Integer.valueOf(81),
                                                                                                    Long.valueOf(-57),
                                                                                                    Order.getDefault(),
                                                                                                    "64c248d7-2a08-4782-9ded-9fd932fc20bb",
                                                                                                    null, null);
            LightThemeColorListOptions lightthemecolorlistoptions2 = new LightThemeColorListOptions(Integer.valueOf(81),
                                                                                                    Long.valueOf(-57),
                                                                                                    Order.getDefault(),
                                                                                                    "64c248d7-2a08-4782-9ded-9fd932fc20bb",
                                                                                                    null, null);
            assertNotNull(lightthemecolorlistoptions1);
            assertNotNull(lightthemecolorlistoptions2);
            assertNotSame(lightthemecolorlistoptions2, lightthemecolorlistoptions1);
            assertEquals(lightthemecolorlistoptions2, lightthemecolorlistoptions1);
            assertEquals(lightthemecolorlistoptions2.hashCode(), lightthemecolorlistoptions1.hashCode());
            int hashCode = lightthemecolorlistoptions1.hashCode();
            for (int i = 0; i < 5; i++) {
                assertEquals(hashCode, lightthemecolorlistoptions1.hashCode());
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
            LightThemeColorListOptions lightthemecolorlistoptions1 = new LightThemeColorListOptions(Integer.valueOf(71),
                                                                                                    Long.valueOf(-91),
                                                                                                    Order.getDefault(),
                                                                                                    "0065b51a-50c2-4c88-a71f-70f1723e3f83",
                                                                                                    null, null);
            LightThemeColorListOptions lightthemecolorlistoptions2 = new LightThemeColorListOptions(Integer.valueOf(71),
                                                                                                    Long.valueOf(-91),
                                                                                                    Order.getDefault(),
                                                                                                    "0065b51a-50c2-4c88-a71f-70f1723e3f83",
                                                                                                    null, null);
            LightThemeColorListOptions lightthemecolorlistoptions3 = new LightThemeColorListOptions(Integer.valueOf(-97),
                                                                                                    Long.valueOf(126),
                                                                                                    Order.getDefault(),
                                                                                                    "186effdc-976c-42e6-9bd5-da49ebaf6065",
                                                                                                    null, null);
            assertNotNull(lightthemecolorlistoptions1);
            assertNotNull(lightthemecolorlistoptions2);
            assertNotNull(lightthemecolorlistoptions3);
            assertNotSame(lightthemecolorlistoptions2, lightthemecolorlistoptions1);
            assertNotSame(lightthemecolorlistoptions3, lightthemecolorlistoptions1);
            assertEquals(lightthemecolorlistoptions2, lightthemecolorlistoptions1);
            assertEquals(lightthemecolorlistoptions2, lightthemecolorlistoptions1);
            assertEquals(lightthemecolorlistoptions1, lightthemecolorlistoptions2);
            assertEquals(lightthemecolorlistoptions1, lightthemecolorlistoptions1);
            assertFalse(lightthemecolorlistoptions1.equals(null));
            assertNotEquals(lightthemecolorlistoptions3, lightthemecolorlistoptions1);
        } catch (Exception exception) {
            fail(exception.getMessage());
        }
    }
}
