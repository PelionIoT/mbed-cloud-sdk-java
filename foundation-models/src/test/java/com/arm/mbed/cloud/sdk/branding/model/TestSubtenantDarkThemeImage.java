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
                                                                                           "a825a8f7-9dbc-4b1b-a932-87c1551b8aeb",
                                                                                           new Date(1559752150570L));
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
                                                                                           "d978f087-4790-4b01-8f6c-71b84e321fc2",
                                                                                           new Date(1559752148530L));
            SubtenantDarkThemeImage subtenantdarkthemeimage2 = new SubtenantDarkThemeImage(SubtenantDarkThemeImageReference.getDefault(),
                                                                                           "d978f087-4790-4b01-8f6c-71b84e321fc2",
                                                                                           new Date(1559752148530L));
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
                                                                                      "40ff55c0-1e0e-4f10-8999-3afd8e211551",
                                                                                      new Date(1559752147204L));
        assertTrue(subtenantdarkthemeimage.isValid());
        SubtenantDarkThemeImage subtenantdarkthemeimageInvalid = new SubtenantDarkThemeImage(SubtenantDarkThemeImageReference.getDefault(),
                                                                                             "b3bde85d-d348-4460-b0a4-31bff7da3b10",
                                                                                             new Date(1559752145815L));
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
                                                                                           "68f23af4-e004-4007-aa53-f233e5e1927d",
                                                                                           new Date(1559752150886L));
            SubtenantDarkThemeImage subtenantdarkthemeimage2 = new SubtenantDarkThemeImage(SubtenantDarkThemeImageReference.getDefault(),
                                                                                           "68f23af4-e004-4007-aa53-f233e5e1927d",
                                                                                           new Date(1559752150886L));
            SubtenantDarkThemeImage subtenantdarkthemeimage3 = new SubtenantDarkThemeImage(SubtenantDarkThemeImageReference.getDefault(),
                                                                                           "3525c0e5-43e3-4ea0-947f-77bdfa63475e",
                                                                                           new Date(1559752151512L));
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
