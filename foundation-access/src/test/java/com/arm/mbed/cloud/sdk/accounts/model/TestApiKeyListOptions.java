// This file was generated by the Pelion SDK foundation code generator.
// This is an autogenerated unit test class. Do not modify its content as modifications will be lost at next code generation.
package com.arm.mbed.cloud.sdk.accounts.model;

import static org.junit.Assert.*;

import com.arm.mbed.cloud.sdk.common.Order;
import org.junit.Test;

/**
 * Unit tests for Model ApiKeyListOptions.
 */
@SuppressWarnings("PMD.AvoidDuplicateLiterals")
public class TestApiKeyListOptions {
    /**
     * Tests the clone method.
     */
    @SuppressWarnings("resource")
    @Test
    public void testClone() {
        try {
            ApiKeyListOptions apikeylistoptions1 = new ApiKeyListOptions(Integer.valueOf(33), Long.valueOf(25),
                                                                         Order.getDefault(),
                                                                         "583d3d87-8d21-4924-b8da-4edec51ff83c", null,
                                                                         null);
            ApiKeyListOptions apikeylistoptions2 = apikeylistoptions1.clone();
            assertNotNull(apikeylistoptions1);
            assertNotNull(apikeylistoptions2);
            assertNotSame(apikeylistoptions2, apikeylistoptions1);
            assertEquals(apikeylistoptions2, apikeylistoptions1);
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
            ApiKeyListOptions apikeylistoptions1 = new ApiKeyListOptions(Integer.valueOf(-98), Long.valueOf(-18),
                                                                         Order.getDefault(),
                                                                         "65340dc2-5d5c-47b4-b422-86183e47deed", null,
                                                                         null);
            ApiKeyListOptions apikeylistoptions2 = new ApiKeyListOptions(Integer.valueOf(-98), Long.valueOf(-18),
                                                                         Order.getDefault(),
                                                                         "65340dc2-5d5c-47b4-b422-86183e47deed", null,
                                                                         null);
            assertNotNull(apikeylistoptions1);
            assertNotNull(apikeylistoptions2);
            assertNotSame(apikeylistoptions2, apikeylistoptions1);
            assertEquals(apikeylistoptions2, apikeylistoptions1);
            assertEquals(apikeylistoptions2.hashCode(), apikeylistoptions1.hashCode());
            int hashCode = apikeylistoptions1.hashCode();
            for (int i = 0; i < 5; i++) {
                assertEquals(hashCode, apikeylistoptions1.hashCode());
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
            ApiKeyListOptions apikeylistoptions1 = new ApiKeyListOptions(Integer.valueOf(-104), Long.valueOf(106),
                                                                         Order.getDefault(),
                                                                         "f8c14caa-c7e3-4ac9-aff4-966719bc8e3a", null,
                                                                         null);
            ApiKeyListOptions apikeylistoptions2 = new ApiKeyListOptions(Integer.valueOf(-104), Long.valueOf(106),
                                                                         Order.getDefault(),
                                                                         "f8c14caa-c7e3-4ac9-aff4-966719bc8e3a", null,
                                                                         null);
            ApiKeyListOptions apikeylistoptions3 = new ApiKeyListOptions(Integer.valueOf(-56), Long.valueOf(71),
                                                                         Order.getDefault(),
                                                                         "5626cd7f-4ce2-4c07-b4d5-27ef84201ec6", null,
                                                                         null);
            assertNotNull(apikeylistoptions1);
            assertNotNull(apikeylistoptions2);
            assertNotNull(apikeylistoptions3);
            assertNotSame(apikeylistoptions2, apikeylistoptions1);
            assertNotSame(apikeylistoptions3, apikeylistoptions1);
            assertEquals(apikeylistoptions2, apikeylistoptions1);
            assertEquals(apikeylistoptions2, apikeylistoptions1);
            assertEquals(apikeylistoptions1, apikeylistoptions2);
            assertEquals(apikeylistoptions1, apikeylistoptions1);
            assertFalse(apikeylistoptions1.equals(null));
            assertNotEquals(apikeylistoptions3, apikeylistoptions1);
        } catch (Exception exception) {
            fail(exception.getMessage());
        }
    }
}
