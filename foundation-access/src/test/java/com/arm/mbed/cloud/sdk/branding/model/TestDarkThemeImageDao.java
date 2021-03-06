// This file was generated by the Pelion SDK foundation code generator.
// This unit test suite was autogenerated on Mon Jun 03 11:17:45 UTC 2019. Feel free to change its contents as you wish.
package com.arm.mbed.cloud.sdk.branding.model;

import static org.junit.Assert.*;

import org.junit.Test;

/**
 * Unit tests for Model DarkThemeImageDao.
 */
@SuppressWarnings("PMD.AvoidDuplicateLiterals")
public class TestDarkThemeImageDao {
    /**
     * Tests the clone method.
     */
    @SuppressWarnings("resource")
    @Test
    public void testClone() {
        try {
            DarkThemeImageDao darkthemeimagedao1 = new DarkThemeImageDao();
            DarkThemeImageDao darkthemeimagedao2 = darkthemeimagedao1.clone();
            assertNotNull(darkthemeimagedao1);
            assertNotNull(darkthemeimagedao2);
            assertNotSame(darkthemeimagedao2, darkthemeimagedao1);
            assertEquals(darkthemeimagedao2, darkthemeimagedao1);
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
            DarkThemeImageDao darkthemeimagedao1 = new DarkThemeImageDao();
            DarkThemeImageDao darkthemeimagedao2 = new DarkThemeImageDao();
            assertNotNull(darkthemeimagedao1);
            assertNotNull(darkthemeimagedao2);
            assertNotSame(darkthemeimagedao2, darkthemeimagedao1);
            assertEquals(darkthemeimagedao2, darkthemeimagedao1);
            assertEquals(darkthemeimagedao2.hashCode(), darkthemeimagedao1.hashCode());
            int hashCode = darkthemeimagedao1.hashCode();
            for (int i = 0; i < 5; i++) {
                assertEquals(hashCode, darkthemeimagedao1.hashCode());
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
            DarkThemeImageDao darkthemeimagedao1 = new DarkThemeImageDao();
            DarkThemeImageDao darkthemeimagedao2 = new DarkThemeImageDao();
            assertNotNull(darkthemeimagedao1);
            assertNotNull(darkthemeimagedao2);
            assertNotSame(darkthemeimagedao2, darkthemeimagedao1);
            assertEquals(darkthemeimagedao2, darkthemeimagedao1);
            assertEquals(darkthemeimagedao2, darkthemeimagedao1);
            assertEquals(darkthemeimagedao1, darkthemeimagedao2);
            assertEquals(darkthemeimagedao1, darkthemeimagedao1);
            assertFalse(darkthemeimagedao1.equals(null));
        } catch (Exception exception) {
            fail(exception.getMessage());
        }
    }
}
