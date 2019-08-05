// This file was generated by the Pelion SDK foundation code generator.
// This is an autogenerated unit test class. Do not modify its content as modifications will be lost at next code generation.
package com.arm.mbed.cloud.sdk.branding.model;

import static org.junit.Assert.*;

import org.junit.Test;

/**
 * Unit tests for Model SubtenantDarkThemeColorReference.
 */
@SuppressWarnings("PMD.AvoidDuplicateLiterals")
public class TestSubtenantDarkThemeColorReference {
    /**
     * Tests the getValue method.
     */
    @SuppressWarnings("resource")
    @Test
    public void testGetValue() {
        try {
            SubtenantDarkThemeColorReference subtenantdarkthemecolorreference = SubtenantDarkThemeColorReference.getValue(null);
            assertNotNull(subtenantdarkthemecolorreference);
            assertTrue(subtenantdarkthemecolorreference.isDefault());
            subtenantdarkthemecolorreference = SubtenantDarkThemeColorReference.getValue(SubtenantDarkThemeColorReference.getDefault()
                                                                                                                         .getString());
            assertNotNull(subtenantdarkthemecolorreference);
            assertTrue(subtenantdarkthemecolorreference.isDefault());
            subtenantdarkthemecolorreference = SubtenantDarkThemeColorReference.getValue("CANVAS_BACKGROUND");
            assertNotNull(subtenantdarkthemecolorreference);
            assertTrue(subtenantdarkthemecolorreference.isDefault());
            subtenantdarkthemecolorreference = SubtenantDarkThemeColorReference.getValue("canvas_background_font_color");
            assertNotNull(subtenantdarkthemecolorreference);
            assertFalse(subtenantdarkthemecolorreference.isDefault());
            subtenantdarkthemecolorreference = SubtenantDarkThemeColorReference.getValue("bbbcdc06-950d-4b21-8a68-ee4fc6f07dbf");
            assertNotNull(subtenantdarkthemecolorreference);
            assertTrue(subtenantdarkthemecolorreference.isDefault());
        } catch (Exception exception) {
            fail(exception.getMessage());
        }
    }
}
