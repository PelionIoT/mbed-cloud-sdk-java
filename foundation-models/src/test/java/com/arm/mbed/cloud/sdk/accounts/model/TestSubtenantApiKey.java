// This file was generated by the Pelion SDK foundation code generator.
// This is an autogenerated unit test class. Do not modify its content as modifications will be lost at next code generation.
package com.arm.mbed.cloud.sdk.accounts.model;

import static org.junit.Assert.*;

import java.util.Date;
import org.junit.Test;

/**
 * Unit tests for Model SubtenantApiKey.
 */
@SuppressWarnings("PMD.AvoidDuplicateLiterals")
public class TestSubtenantApiKey {
    /**
     * Tests the clone method.
     */
    @SuppressWarnings("resource")
    @Test
    public void testClone() {
        try {
            SubtenantApiKey subtenantapikey1 = new SubtenantApiKey("acbf655bdeac77c770ad4964fcb1f81f",
                                                                   new Date(1559747930624L), -23,
                                                                   "acbf655bdeac77c770ad4964fcb1f81f",
                                                                   "1e931934-8f10-4be7-bf53-bd502f88405c", -31,
                                                                   "f384d7f8-3945-4322-a110-18209167cf6c",
                                                                   "acbf655bdeac77c770ad4964fcb1f81f",
                                                                   SubtenantApiKeyStatus.getDefault(),
                                                                   new Date(1559747932376L));
            SubtenantApiKey subtenantapikey2 = subtenantapikey1.clone();
            assertNotNull(subtenantapikey1);
            assertNotNull(subtenantapikey2);
            assertNotSame(subtenantapikey2, subtenantapikey1);
            assertEquals(subtenantapikey2, subtenantapikey1);
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
            SubtenantApiKey subtenantapikey1 = new SubtenantApiKey("acbf655bdeac77c770ad4964fcb1f81f",
                                                                   new Date(1559747929028L), 63,
                                                                   "acbf655bdeac77c770ad4964fcb1f81f",
                                                                   "da340b05-c712-4d14-a5e7-0eadc4d3500e", 8,
                                                                   "85eb452d-c30b-43b6-8595-04b619a7c807",
                                                                   "acbf655bdeac77c770ad4964fcb1f81f",
                                                                   SubtenantApiKeyStatus.getDefault(),
                                                                   new Date(1559747925810L));
            SubtenantApiKey subtenantapikey2 = new SubtenantApiKey("acbf655bdeac77c770ad4964fcb1f81f",
                                                                   new Date(1559747929028L), 63,
                                                                   "acbf655bdeac77c770ad4964fcb1f81f",
                                                                   "da340b05-c712-4d14-a5e7-0eadc4d3500e", 8,
                                                                   "85eb452d-c30b-43b6-8595-04b619a7c807",
                                                                   "acbf655bdeac77c770ad4964fcb1f81f",
                                                                   SubtenantApiKeyStatus.getDefault(),
                                                                   new Date(1559747925810L));
            assertNotNull(subtenantapikey1);
            assertNotNull(subtenantapikey2);
            assertNotSame(subtenantapikey2, subtenantapikey1);
            assertEquals(subtenantapikey2, subtenantapikey1);
            assertEquals(subtenantapikey2.hashCode(), subtenantapikey1.hashCode());
            int hashCode = subtenantapikey1.hashCode();
            for (int i = 0; i < 5; i++) {
                assertEquals(hashCode, subtenantapikey1.hashCode());
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
        SubtenantApiKey subtenantapikey = new SubtenantApiKey("acbf655bdeac77c770ad4964fcb1f81f",
                                                              new Date(1559747935023L), 65,
                                                              "acbf655bdeac77c770ad4964fcb1f81f",
                                                              "8ef6617a-224e-4648-bc2a-93dcc391f28a", -2,
                                                              "26a2b7d9-5c13-4422-8801-12dc5458a16f",
                                                              "acbf655bdeac77c770ad4964fcb1f81f",
                                                              SubtenantApiKeyStatus.getDefault(),
                                                              new Date(1559747928746L));
        assertTrue(subtenantapikey.isValid());
        SubtenantApiKey subtenantapikeyInvalid = new SubtenantApiKey(null, new Date(1559747926698L), 27,
                                                                     "ꀊ+(褑32\f3X\u0005;\\\\2\u001aA䣽-2ᗜN22&\\\\X\u00023\u00023OJ3\u00012Z*\u000f2\u0007I�?3V3젎3'\u00142Σ뛄\b<XN磀뾆)3.廉",
                                                                     "c46e2256-c2e1-4afe-b152-0fcae1a63bf7", -17, null,
                                                                     "ꀊ+(褑32\f3X\u0005;\\\\2\u001aA䣽-2ᗜN22&\\\\X\u00023\u00023OJ3\u00012Z*\u000f2\u0007I�?3V3젎3'\u00142Σ뛄\b<XN磀뾆)3.廉",
                                                                     SubtenantApiKeyStatus.getDefault(),
                                                                     new Date(1559747933918L));
        assertFalse(subtenantapikeyInvalid.isValid());
    }

    /**
     * Tests the equals method.
     */
    @SuppressWarnings("resource")
    @Test
    public void testEquals() {
        try {
            SubtenantApiKey subtenantapikey1 = new SubtenantApiKey("acbf655bdeac77c770ad4964fcb1f81f",
                                                                   new Date(1559747933701L), 120,
                                                                   "acbf655bdeac77c770ad4964fcb1f81f",
                                                                   "22217740-9430-4272-9bef-516c2680ba87", 113,
                                                                   "1322b7f4-e927-43ab-9b63-17d0ec7464fe",
                                                                   "acbf655bdeac77c770ad4964fcb1f81f",
                                                                   SubtenantApiKeyStatus.getDefault(),
                                                                   new Date(1559747931715L));
            SubtenantApiKey subtenantapikey2 = new SubtenantApiKey("acbf655bdeac77c770ad4964fcb1f81f",
                                                                   new Date(1559747933701L), 120,
                                                                   "acbf655bdeac77c770ad4964fcb1f81f",
                                                                   "22217740-9430-4272-9bef-516c2680ba87", 113,
                                                                   "1322b7f4-e927-43ab-9b63-17d0ec7464fe",
                                                                   "acbf655bdeac77c770ad4964fcb1f81f",
                                                                   SubtenantApiKeyStatus.getDefault(),
                                                                   new Date(1559747931715L));
            SubtenantApiKey subtenantapikey3 = new SubtenantApiKey("acbf655bdeac77c770ad4964fcb1f81f",
                                                                   new Date(1559747935080L), 116,
                                                                   "acbf655bdeac77c770ad4964fcb1f81f",
                                                                   "fc097c17-305a-45cb-92a8-dfc8945488db", 9,
                                                                   "ac6c169c-3377-4e8f-8da6-75fe6db7b730",
                                                                   "acbf655bdeac77c770ad4964fcb1f81f",
                                                                   SubtenantApiKeyStatus.getDefault(),
                                                                   new Date(1559747932761L));
            assertNotNull(subtenantapikey1);
            assertNotNull(subtenantapikey2);
            assertNotNull(subtenantapikey3);
            assertNotSame(subtenantapikey2, subtenantapikey1);
            assertNotSame(subtenantapikey3, subtenantapikey1);
            assertEquals(subtenantapikey2, subtenantapikey1);
            assertEquals(subtenantapikey2, subtenantapikey1);
            assertEquals(subtenantapikey1, subtenantapikey2);
            assertEquals(subtenantapikey1, subtenantapikey1);
            assertFalse(subtenantapikey1.equals(null));
            assertNotEquals(subtenantapikey3, subtenantapikey1);
        } catch (Exception exception) {
            fail(exception.getMessage());
        }
    }
}
