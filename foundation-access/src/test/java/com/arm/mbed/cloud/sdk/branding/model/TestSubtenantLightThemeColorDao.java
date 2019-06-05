// This file was generated by the Pelion SDK foundation code generator.
// This unit test suite was autogenerated on Tue Jun 04 15:39:38 UTC 2019. Feel free to change its contents as you wish.
package com.arm.mbed.cloud.sdk.branding.model;

import static org.junit.Assert.*;

import org.junit.Test;

/**
 * Unit tests for Model SubtenantLightThemeColorDao.
 */
@SuppressWarnings("PMD.AvoidDuplicateLiterals")
public class TestSubtenantLightThemeColorDao {
    /**
     * Tests the clone method.
     */
    @SuppressWarnings("resource")
    @Test
    public void testClone() {
        try {
            SubtenantLightThemeColorDao subtenantlightthemecolordao1 = new SubtenantLightThemeColorDao();
            SubtenantLightThemeColorDao subtenantlightthemecolordao2 = subtenantlightthemecolordao1.clone();
            assertNotNull(subtenantlightthemecolordao1);
            assertNotNull(subtenantlightthemecolordao2);
            assertNotSame(subtenantlightthemecolordao2, subtenantlightthemecolordao1);
            assertEquals(subtenantlightthemecolordao2, subtenantlightthemecolordao1);
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
            SubtenantLightThemeColorDao subtenantlightthemecolordao1 = new SubtenantLightThemeColorDao();
            SubtenantLightThemeColorDao subtenantlightthemecolordao2 = new SubtenantLightThemeColorDao();
            assertNotNull(subtenantlightthemecolordao1);
            assertNotNull(subtenantlightthemecolordao2);
            assertNotSame(subtenantlightthemecolordao2, subtenantlightthemecolordao1);
            assertEquals(subtenantlightthemecolordao2, subtenantlightthemecolordao1);
            assertEquals(subtenantlightthemecolordao2.hashCode(), subtenantlightthemecolordao1.hashCode());
            int hashCode = subtenantlightthemecolordao1.hashCode();
            for (int i = 0; i < 5; i++) {
                assertEquals(hashCode, subtenantlightthemecolordao1.hashCode());
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
            SubtenantLightThemeColorDao subtenantlightthemecolordao1 = new SubtenantLightThemeColorDao();
            SubtenantLightThemeColorDao subtenantlightthemecolordao2 = new SubtenantLightThemeColorDao();
            assertNotNull(subtenantlightthemecolordao1);
            assertNotNull(subtenantlightthemecolordao2);
            assertNotSame(subtenantlightthemecolordao2, subtenantlightthemecolordao1);
            assertEquals(subtenantlightthemecolordao2, subtenantlightthemecolordao1);
            assertEquals(subtenantlightthemecolordao2, subtenantlightthemecolordao1);
            assertEquals(subtenantlightthemecolordao1, subtenantlightthemecolordao2);
            assertEquals(subtenantlightthemecolordao1, subtenantlightthemecolordao1);
            assertFalse(subtenantlightthemecolordao1.equals(null));
        } catch (Exception exception) {
            fail(exception.getMessage());
        }
    }
}