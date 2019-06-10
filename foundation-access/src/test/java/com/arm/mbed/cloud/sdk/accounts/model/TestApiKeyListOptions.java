// This file was generated by the Pelion SDK foundation code generator.
// This is an autogenerated unit test class. Do not modify its content as modifications will be lost at next code generation.
package com.arm.mbed.cloud.sdk.accounts.model;

import static org.junit.Assert.*;

import com.arm.mbed.cloud.sdk.common.Order;
import com.arm.mbed.cloud.sdk.common.listing.ListOptionsEncoder;
import com.arm.mbed.cloud.sdk.common.listing.filtering.FilterOperator;
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
            ApiKeyListOptions apikeylistoptions1 = new ApiKeyListOptions(Integer.valueOf(12), Long.valueOf(38),
                                                                         Order.getDefault(),
                                                                         "00808965-549d-4854-bb40-1087035773e8", null,
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
     * Tests the filters method.
     */
    @SuppressWarnings("resource")
    @Test
    public void testFilters() {
        try {
            ApiKeyListOptions option = new ApiKeyListOptions().equalToOwner("88a7f783-9d1a-4951-aac4-5007c9d3537f")
                                                              .equalToKey("ddd763b8-32d8-49d6-bf8e-e02dc7b19de7");
            assertTrue(option.hasFilters());
            assertTrue(option.hasFilters(ApiKeyListOptions.TAG_FILTER_BY_OWNER));
            assertTrue(option.hasFilter(ApiKeyListOptions.TAG_FILTER_BY_OWNER, FilterOperator.EQUAL));
            assertNotNull(option.getOwnerFilters());
            assertEquals("88a7f783-9d1a-4951-aac4-5007c9d3537f",
                         ListOptionsEncoder.encodeSingleEqualFilter(ApiKeyListOptions.TAG_FILTER_BY_OWNER, String.class,
                                                                    option));
            assertTrue(option.hasFilters(ApiKeyListOptions.TAG_FILTER_BY_KEY));
            assertTrue(option.hasFilter(ApiKeyListOptions.TAG_FILTER_BY_KEY, FilterOperator.EQUAL));
            assertNotNull(option.getKeyFilters());
            assertEquals("ddd763b8-32d8-49d6-bf8e-e02dc7b19de7",
                         ListOptionsEncoder.encodeSingleEqualFilter(ApiKeyListOptions.TAG_FILTER_BY_KEY, String.class,
                                                                    option));
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
            ApiKeyListOptions apikeylistoptions1 = new ApiKeyListOptions(Integer.valueOf(-64), Long.valueOf(5),
                                                                         Order.getDefault(),
                                                                         "28bd0c96-8599-4515-8f8b-9405ef09fb7c", null,
                                                                         null);
            ApiKeyListOptions apikeylistoptions2 = new ApiKeyListOptions(Integer.valueOf(-64), Long.valueOf(5),
                                                                         Order.getDefault(),
                                                                         "28bd0c96-8599-4515-8f8b-9405ef09fb7c", null,
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
            ApiKeyListOptions apikeylistoptions1 = new ApiKeyListOptions(Integer.valueOf(80), Long.valueOf(119),
                                                                         Order.getDefault(),
                                                                         "cada9e7c-07c2-4cee-982c-29ac6d6fab0c", null,
                                                                         null);
            ApiKeyListOptions apikeylistoptions2 = new ApiKeyListOptions(Integer.valueOf(80), Long.valueOf(119),
                                                                         Order.getDefault(),
                                                                         "cada9e7c-07c2-4cee-982c-29ac6d6fab0c", null,
                                                                         null);
            ApiKeyListOptions apikeylistoptions3 = new ApiKeyListOptions(Integer.valueOf(63), Long.valueOf(-2),
                                                                         Order.getDefault(),
                                                                         "4bf44676-84ce-4a34-b793-daabf2b60693", null,
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
