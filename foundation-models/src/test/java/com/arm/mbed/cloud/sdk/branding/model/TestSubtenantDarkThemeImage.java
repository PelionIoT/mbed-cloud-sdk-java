// This file was generated by the Pelion SDK foundation code generator.
// This is an autogenerated unit test class. Do not modify its content as modifications will be lost at next code generation.
package com.arm.mbed.cloud.sdk.branding.model;

import static org.junit.Assert.*;

import java.util.Date;
import org.junit.Test;

/**
 * Unit tests for Model SubtenantDarkThemeImage.
 */
@SuppressWarnings("PMD.AvoidDuplicateLiterals")
public class TestSubtenantDarkThemeImage {
    /**
     * Tests the clone method.
     */
    @SuppressWarnings("resource")
    @Test
    public void testClone() {
        try {
            SubtenantDarkThemeImage subtenantdarkthemeimage1 = new SubtenantDarkThemeImage(SubtenantDarkThemeImageReference.getDefault(),
                                                                                           "7ae81825-c4a2-422f-8789-406122788b60",
                                                                                           new Date(1559746951099L));
            SubtenantDarkThemeImage subtenantdarkthemeimage2 = subtenantdarkthemeimage1.clone();
            assertNotNull(subtenantdarkthemeimage1);
            assertNotNull(subtenantdarkthemeimage2);
            assertNotSame(subtenantdarkthemeimage2, subtenantdarkthemeimage1);
            assertEquals(subtenantdarkthemeimage2, subtenantdarkthemeimage1);
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
            SubtenantDarkThemeImage subtenantdarkthemeimage1 = new SubtenantDarkThemeImage(SubtenantDarkThemeImageReference.getDefault(),
                                                                                           "c8d391e1-2154-4477-a08d-fc57faf1b46f",
                                                                                           new Date(1559746946605L));
            SubtenantDarkThemeImage subtenantdarkthemeimage2 = new SubtenantDarkThemeImage(SubtenantDarkThemeImageReference.getDefault(),
                                                                                           "c8d391e1-2154-4477-a08d-fc57faf1b46f",
                                                                                           new Date(1559746946605L));
            assertNotNull(subtenantdarkthemeimage1);
            assertNotNull(subtenantdarkthemeimage2);
            assertNotSame(subtenantdarkthemeimage2, subtenantdarkthemeimage1);
            assertEquals(subtenantdarkthemeimage2, subtenantdarkthemeimage1);
            assertEquals(subtenantdarkthemeimage2.hashCode(), subtenantdarkthemeimage1.hashCode());
            int hashCode = subtenantdarkthemeimage1.hashCode();
            for (int i = 0; i < 5; i++) {
                assertEquals(hashCode, subtenantdarkthemeimage1.hashCode());
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
        SubtenantDarkThemeImage subtenantdarkthemeimage = new SubtenantDarkThemeImage(SubtenantDarkThemeImageReference.getDefault(),
                                                                                      "c5c10480-daef-40f7-8981-dcd6c193a172",
                                                                                      new Date(1559746950281L));
        assertTrue(subtenantdarkthemeimage.isValid());
        SubtenantDarkThemeImage subtenantdarkthemeimageInvalid = new SubtenantDarkThemeImage(SubtenantDarkThemeImageReference.getDefault(),
                                                                                             "7be15e03-1ca9-479c-af1e-21e481677e27",
                                                                                             new Date(1559746954492L));
        assertFalse(subtenantdarkthemeimageInvalid.isValid());
    }

    /**
     * Tests the equals method.
     */
    @SuppressWarnings("resource")
    @Test
    public void testEquals() {
        try {
            SubtenantDarkThemeImage subtenantdarkthemeimage1 = new SubtenantDarkThemeImage(SubtenantDarkThemeImageReference.getDefault(),
                                                                                           "fa5e7090-7e8e-4469-9f69-1048ce9170eb",
                                                                                           new Date(1559746953660L));
            SubtenantDarkThemeImage subtenantdarkthemeimage2 = new SubtenantDarkThemeImage(SubtenantDarkThemeImageReference.getDefault(),
                                                                                           "fa5e7090-7e8e-4469-9f69-1048ce9170eb",
                                                                                           new Date(1559746953660L));
            SubtenantDarkThemeImage subtenantdarkthemeimage3 = new SubtenantDarkThemeImage(SubtenantDarkThemeImageReference.getDefault(),
                                                                                           "c72a001c-7181-4f57-9f48-b7e0bb48974c",
                                                                                           new Date(1559746948889L));
            assertNotNull(subtenantdarkthemeimage1);
            assertNotNull(subtenantdarkthemeimage2);
            assertNotNull(subtenantdarkthemeimage3);
            assertNotSame(subtenantdarkthemeimage2, subtenantdarkthemeimage1);
            assertNotSame(subtenantdarkthemeimage3, subtenantdarkthemeimage1);
            assertEquals(subtenantdarkthemeimage2, subtenantdarkthemeimage1);
            assertEquals(subtenantdarkthemeimage2, subtenantdarkthemeimage1);
            assertEquals(subtenantdarkthemeimage1, subtenantdarkthemeimage2);
            assertEquals(subtenantdarkthemeimage1, subtenantdarkthemeimage1);
            assertFalse(subtenantdarkthemeimage1.equals(null));
            assertNotEquals(subtenantdarkthemeimage3, subtenantdarkthemeimage1);
        } catch (Exception exception) {
            fail(exception.getMessage());
        }
    }
}
