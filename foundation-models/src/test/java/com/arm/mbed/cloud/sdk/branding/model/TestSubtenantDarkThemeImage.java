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
                                                                                           "a690ce3e-127c-41d7-b534-7f89940ba9cb",
                                                                                           new Date(1559745297037L));
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
                                                                                           "cb978e68-1992-46fb-b25f-d7af3fd3f1f0",
                                                                                           new Date(1559745298426L));
            SubtenantDarkThemeImage subtenantdarkthemeimage2 = new SubtenantDarkThemeImage(SubtenantDarkThemeImageReference.getDefault(),
                                                                                           "cb978e68-1992-46fb-b25f-d7af3fd3f1f0",
                                                                                           new Date(1559745298426L));
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
                                                                                      "f8c6b4f4-5f74-4558-8179-1e4438fa9719",
                                                                                      new Date(1559745298575L));
        assertTrue(subtenantdarkthemeimage.isValid());
        SubtenantDarkThemeImage subtenantdarkthemeimageInvalid = new SubtenantDarkThemeImage(SubtenantDarkThemeImageReference.getDefault(),
                                                                                             "40c0db4f-c18a-4828-acd5-e2e7c2742615",
                                                                                             new Date(1559745300356L));
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
                                                                                           "199f665c-922d-4168-9394-707d09366e59",
                                                                                           new Date(1559745303516L));
            SubtenantDarkThemeImage subtenantdarkthemeimage2 = new SubtenantDarkThemeImage(SubtenantDarkThemeImageReference.getDefault(),
                                                                                           "199f665c-922d-4168-9394-707d09366e59",
                                                                                           new Date(1559745303516L));
            SubtenantDarkThemeImage subtenantdarkthemeimage3 = new SubtenantDarkThemeImage(SubtenantDarkThemeImageReference.getDefault(),
                                                                                           "233474c6-c1c1-4afa-be23-81ff2a5703e0",
                                                                                           new Date(1559745303607L));
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
