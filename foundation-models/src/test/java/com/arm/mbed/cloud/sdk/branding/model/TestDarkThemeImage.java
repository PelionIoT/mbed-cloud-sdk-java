// This file was generated by the Pelion SDK foundation code generator.
// This is an autogenerated unit test class. Do not modify its content as modifications will be lost at next code generation.
package com.arm.mbed.cloud.sdk.branding.model;

import static org.junit.Assert.*;

import java.util.Date;
import org.junit.Test;

/**
 * Unit tests for Model DarkThemeImage.
 */
@SuppressWarnings("PMD.AvoidDuplicateLiterals")
public class TestDarkThemeImage {
    /**
     * Tests the clone method.
     */
    @SuppressWarnings("resource")
    @Test
    public void testClone() {
        try {
            DarkThemeImage darkthemeimage1 = new DarkThemeImage(DarkThemeImageReference.getDefault(),
                                                                "928edf90-458c-45d6-b104-f8b36a13b348",
                                                                new Date(1559758612235L));
            DarkThemeImage darkthemeimage2 = darkthemeimage1.clone();
            assertNotNull(darkthemeimage1);
            assertNotNull(darkthemeimage2);
            assertNotSame(darkthemeimage2, darkthemeimage1);
            assertEquals(darkthemeimage2, darkthemeimage1);
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
            DarkThemeImage darkthemeimage1 = new DarkThemeImage(DarkThemeImageReference.getDefault(),
                                                                "e15c60e3-bbf4-4b45-95dd-e6a38dd3727f",
                                                                new Date(1559758608044L));
            DarkThemeImage darkthemeimage2 = new DarkThemeImage(DarkThemeImageReference.getDefault(),
                                                                "e15c60e3-bbf4-4b45-95dd-e6a38dd3727f",
                                                                new Date(1559758608044L));
            assertNotNull(darkthemeimage1);
            assertNotNull(darkthemeimage2);
            assertNotSame(darkthemeimage2, darkthemeimage1);
            assertEquals(darkthemeimage2, darkthemeimage1);
            assertEquals(darkthemeimage2.hashCode(), darkthemeimage1.hashCode());
            int hashCode = darkthemeimage1.hashCode();
            for (int i = 0; i < 5; i++) {
                assertEquals(hashCode, darkthemeimage1.hashCode());
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
        DarkThemeImage darkthemeimage = new DarkThemeImage(DarkThemeImageReference.getDefault(),
                                                           "149020d4-f501-45d3-9d24-6ea56ca61b28",
                                                           new Date(1559758603984L));
        assertTrue(darkthemeimage.isValid());
        DarkThemeImage darkthemeimageInvalid = new DarkThemeImage(null, "e9f1565c-284c-4f29-8021-3ed63146b637",
                                                                  new Date(1559758610582L));
        assertFalse(darkthemeimageInvalid.isValid());
    }

    /**
     * Tests the equals method.
     */
    @SuppressWarnings("resource")
    @Test
    public void testEquals() {
        try {
            DarkThemeImage darkthemeimage1 = new DarkThemeImage(DarkThemeImageReference.getDefault(),
                                                                "170c2079-87c5-4791-b025-fe24999bf631",
                                                                new Date(1559758606019L));
            DarkThemeImage darkthemeimage2 = new DarkThemeImage(DarkThemeImageReference.getDefault(),
                                                                "170c2079-87c5-4791-b025-fe24999bf631",
                                                                new Date(1559758606019L));
            DarkThemeImage darkthemeimage3 = new DarkThemeImage(DarkThemeImageReference.getDefault(),
                                                                "8e42f6d3-656f-40dd-b344-f0f7aa177d24",
                                                                new Date(1559758609001L));
            assertNotNull(darkthemeimage1);
            assertNotNull(darkthemeimage2);
            assertNotNull(darkthemeimage3);
            assertNotSame(darkthemeimage2, darkthemeimage1);
            assertNotSame(darkthemeimage3, darkthemeimage1);
            assertEquals(darkthemeimage2, darkthemeimage1);
            assertEquals(darkthemeimage2, darkthemeimage1);
            assertEquals(darkthemeimage1, darkthemeimage2);
            assertEquals(darkthemeimage1, darkthemeimage1);
            assertFalse(darkthemeimage1.equals(null));
            assertNotEquals(darkthemeimage3, darkthemeimage1);
        } catch (Exception exception) {
            fail(exception.getMessage());
        }
    }
}
