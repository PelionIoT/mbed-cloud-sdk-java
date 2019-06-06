// This file was generated by the Pelion SDK foundation code generator.
// This is an autogenerated unit test class. Do not modify its content as modifications will be lost at next code generation.
package com.arm.mbed.cloud.sdk.branding.model;

import static org.junit.Assert.*;

import org.junit.Test;

/**
 * Unit tests for Model DarkThemeImageListDao.
 */
@SuppressWarnings("PMD.AvoidDuplicateLiterals")
public class TestDarkThemeImageListDao {
    /**
     * Tests the clone method.
     */
    @SuppressWarnings("resource")
    @Test
    public void testClone() {
        try {
            DarkThemeImageListDao darkthemeimagelistdao1 = new DarkThemeImageListDao();
            DarkThemeImageListDao darkthemeimagelistdao2 = darkthemeimagelistdao1.clone();
            assertNotNull(darkthemeimagelistdao1);
            assertNotNull(darkthemeimagelistdao2);
            assertNotSame(darkthemeimagelistdao2, darkthemeimagelistdao1);
            assertEquals(darkthemeimagelistdao2, darkthemeimagelistdao1);
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
            DarkThemeImageListDao darkthemeimagelistdao1 = new DarkThemeImageListDao();
            DarkThemeImageListDao darkthemeimagelistdao2 = new DarkThemeImageListDao();
            assertNotNull(darkthemeimagelistdao1);
            assertNotNull(darkthemeimagelistdao2);
            assertNotSame(darkthemeimagelistdao2, darkthemeimagelistdao1);
            assertEquals(darkthemeimagelistdao2, darkthemeimagelistdao1);
            assertEquals(darkthemeimagelistdao2.hashCode(), darkthemeimagelistdao1.hashCode());
            int hashCode = darkthemeimagelistdao1.hashCode();
            for (int i = 0; i < 5; i++) {
                assertEquals(hashCode, darkthemeimagelistdao1.hashCode());
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
            DarkThemeImageListDao darkthemeimagelistdao1 = new DarkThemeImageListDao();
            DarkThemeImageListDao darkthemeimagelistdao2 = new DarkThemeImageListDao();
            assertNotNull(darkthemeimagelistdao1);
            assertNotNull(darkthemeimagelistdao2);
            assertNotSame(darkthemeimagelistdao2, darkthemeimagelistdao1);
            assertEquals(darkthemeimagelistdao2, darkthemeimagelistdao1);
            assertEquals(darkthemeimagelistdao2, darkthemeimagelistdao1);
            assertEquals(darkthemeimagelistdao1, darkthemeimagelistdao2);
            assertEquals(darkthemeimagelistdao1, darkthemeimagelistdao1);
            assertFalse(darkthemeimagelistdao1.equals(null));
        } catch (Exception exception) {
            fail(exception.getMessage());
        }
    }
}
