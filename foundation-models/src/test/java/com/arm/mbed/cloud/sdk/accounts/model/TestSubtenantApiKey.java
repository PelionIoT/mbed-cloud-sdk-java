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
            SubtenantApiKey subtenantapikey1 = new SubtenantApiKey("71fdba82137d3d88b328e27f0b30ef6d",
                                                                   new Date(1559754637831L), -75,
                                                                   "71fdba82137d3d88b328e27f0b30ef6d",
                                                                   "3bc04f1c-4a9e-472c-b981-fc7103fa6462", -84,
                                                                   "6e326e9c-8f0e-4d40-a8cb-e309fd098786",
                                                                   "71fdba82137d3d88b328e27f0b30ef6d",
                                                                   SubtenantApiKeyStatus.getDefault(),
                                                                   new Date(1559754638184L));
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
            SubtenantApiKey subtenantapikey1 = new SubtenantApiKey("71fdba82137d3d88b328e27f0b30ef6d",
                                                                   new Date(1559754643451L), 82,
                                                                   "71fdba82137d3d88b328e27f0b30ef6d",
                                                                   "d9a8f7bc-aded-45db-8967-c9eb7525d58c", -56,
                                                                   "dfed5c4e-9f40-47cf-bd87-02cd91453bba",
                                                                   "71fdba82137d3d88b328e27f0b30ef6d",
                                                                   SubtenantApiKeyStatus.getDefault(),
                                                                   new Date(1559754640554L));
            SubtenantApiKey subtenantapikey2 = new SubtenantApiKey("71fdba82137d3d88b328e27f0b30ef6d",
                                                                   new Date(1559754643451L), 82,
                                                                   "71fdba82137d3d88b328e27f0b30ef6d",
                                                                   "d9a8f7bc-aded-45db-8967-c9eb7525d58c", -56,
                                                                   "dfed5c4e-9f40-47cf-bd87-02cd91453bba",
                                                                   "71fdba82137d3d88b328e27f0b30ef6d",
                                                                   SubtenantApiKeyStatus.getDefault(),
                                                                   new Date(1559754640554L));
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
        SubtenantApiKey subtenantapikey = new SubtenantApiKey("71fdba82137d3d88b328e27f0b30ef6d",
                                                              new Date(1559754635165L), 120,
                                                              "71fdba82137d3d88b328e27f0b30ef6d",
                                                              "36c05647-9d42-481d-a3bc-3b8b9014e76f", 125,
                                                              "f366be41-dfb2-4721-9d18-6e6dfc96d7eb",
                                                              "71fdba82137d3d88b328e27f0b30ef6d",
                                                              SubtenantApiKeyStatus.getDefault(),
                                                              new Date(1559754638197L));
        assertTrue(subtenantapikey.isValid());
        SubtenantApiKey subtenantapikeyInvalid = new SubtenantApiKey(null, new Date(1559754640832L), -27,
                                                                     ";\u000b\u0007屨&\u0007H_c5Y\u0005툵44㗑\u00165cc)4c∳녔cc4\u000f뉢4힚54棞4c뀇c\bcঌ5�?�?F\tጷTcc鎻댮\u0013$$c:c\u0017F-\u0018",
                                                                     "c50a18cc-06c3-486f-9d62-cbc8683ac39e", -28, null,
                                                                     ";\u000b\u0007屨&\u0007H_c5Y\u0005툵44㗑\u00165cc)4c∳녔cc4\u000f뉢4힚54棞4c뀇c\bcঌ5�?�?F\tጷTcc鎻댮\u0013$$c:c\u0017F-\u0018",
                                                                     SubtenantApiKeyStatus.getDefault(),
                                                                     new Date(1559754637205L));
        assertFalse(subtenantapikeyInvalid.isValid());
    }

    /**
     * Tests the equals method.
     */
    @SuppressWarnings("resource")
    @Test
    public void testEquals() {
        try {
            SubtenantApiKey subtenantapikey1 = new SubtenantApiKey("71fdba82137d3d88b328e27f0b30ef6d",
                                                                   new Date(1559754637823L), 41,
                                                                   "71fdba82137d3d88b328e27f0b30ef6d",
                                                                   "c1c178ce-1320-4213-a50c-cf67d3b87af2", 1,
                                                                   "b54bd1fd-620c-4d69-96c9-221eb7c8bce7",
                                                                   "71fdba82137d3d88b328e27f0b30ef6d",
                                                                   SubtenantApiKeyStatus.getDefault(),
                                                                   new Date(1559754641404L));
            SubtenantApiKey subtenantapikey2 = new SubtenantApiKey("71fdba82137d3d88b328e27f0b30ef6d",
                                                                   new Date(1559754637823L), 41,
                                                                   "71fdba82137d3d88b328e27f0b30ef6d",
                                                                   "c1c178ce-1320-4213-a50c-cf67d3b87af2", 1,
                                                                   "b54bd1fd-620c-4d69-96c9-221eb7c8bce7",
                                                                   "71fdba82137d3d88b328e27f0b30ef6d",
                                                                   SubtenantApiKeyStatus.getDefault(),
                                                                   new Date(1559754641404L));
            SubtenantApiKey subtenantapikey3 = new SubtenantApiKey("71fdba82137d3d88b328e27f0b30ef6d",
                                                                   new Date(1559754635456L), -85,
                                                                   "71fdba82137d3d88b328e27f0b30ef6d",
                                                                   "de78e286-b42c-4dd3-b1ef-ce14f8eb544f", -15,
                                                                   "a41dbde9-df53-4be0-a147-20e14e700ee9",
                                                                   "71fdba82137d3d88b328e27f0b30ef6d",
                                                                   SubtenantApiKeyStatus.getDefault(),
                                                                   new Date(1559754638366L));
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
