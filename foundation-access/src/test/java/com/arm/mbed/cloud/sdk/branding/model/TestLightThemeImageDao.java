// This file was generated by the Pelion SDK foundation code generator.
// This unit test suite was autogenerated on Mon Jun 03 11:17:45 UTC 2019. Feel free to change its contents as you wish.
package com.arm.mbed.cloud.sdk.branding.model;

import static org.junit.Assert.*;

import org.junit.Test;

/**
 * Unit tests for Model LightThemeImageDao.
 */
@SuppressWarnings("PMD.AvoidDuplicateLiterals")
public class TestLightThemeImageDao {
    /**
     * Tests the clone method.
     */
    @SuppressWarnings("resource")
    @Test
    public void testClone() {
        try {
            LightThemeImageDao lightthemeimagedao1 = new LightThemeImageDao();
            LightThemeImageDao lightthemeimagedao2 = lightthemeimagedao1.clone();
            assertNotNull(lightthemeimagedao1);
            assertNotNull(lightthemeimagedao2);
            assertNotSame(lightthemeimagedao2, lightthemeimagedao1);
            assertEquals(lightthemeimagedao2, lightthemeimagedao1);
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
            LightThemeImageDao lightthemeimagedao1 = new LightThemeImageDao();
            LightThemeImageDao lightthemeimagedao2 = new LightThemeImageDao();
            assertNotNull(lightthemeimagedao1);
            assertNotNull(lightthemeimagedao2);
            assertNotSame(lightthemeimagedao2, lightthemeimagedao1);
            assertEquals(lightthemeimagedao2, lightthemeimagedao1);
            assertEquals(lightthemeimagedao2.hashCode(), lightthemeimagedao1.hashCode());
            int hashCode = lightthemeimagedao1.hashCode();
            for (int i = 0; i < 5; i++) {
                assertEquals(hashCode, lightthemeimagedao1.hashCode());
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
            LightThemeImageDao lightthemeimagedao1 = new LightThemeImageDao();
            LightThemeImageDao lightthemeimagedao2 = new LightThemeImageDao();
            assertNotNull(lightthemeimagedao1);
            assertNotNull(lightthemeimagedao2);
            assertNotSame(lightthemeimagedao2, lightthemeimagedao1);
            assertEquals(lightthemeimagedao2, lightthemeimagedao1);
            assertEquals(lightthemeimagedao2, lightthemeimagedao1);
            assertEquals(lightthemeimagedao1, lightthemeimagedao2);
            assertEquals(lightthemeimagedao1, lightthemeimagedao1);
            assertFalse(lightthemeimagedao1.equals(null));
        } catch (Exception exception) {
            fail(exception.getMessage());
        }
    }
}
