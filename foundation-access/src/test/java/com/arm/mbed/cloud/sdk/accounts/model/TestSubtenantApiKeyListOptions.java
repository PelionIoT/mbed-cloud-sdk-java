// This file was generated by the Pelion SDK foundation code generator.
// This is an autogenerated unit test class. Do not modify its content as modifications will be lost at next code generation.
package com.arm.mbed.cloud.sdk.accounts.model;

import static org.junit.Assert.*;

import com.arm.mbed.cloud.sdk.common.Order;
import com.arm.mbed.cloud.sdk.common.listing.ListOptionsEncoder;
import com.arm.mbed.cloud.sdk.common.listing.filtering.FilterOperator;
import org.junit.Test;

/**
 * Unit tests for Model SubtenantApiKeyListOptions.
 */
@SuppressWarnings("PMD.AvoidDuplicateLiterals")
public class TestSubtenantApiKeyListOptions {
    /**
     * Tests the clone method.
     */
    @SuppressWarnings("resource")
    @Test
    public void testClone() {
        try {
            SubtenantApiKeyListOptions subtenantapikeylistoptions1 = new SubtenantApiKeyListOptions(Integer.valueOf(36),
                                                                                                    Long.valueOf(72),
                                                                                                    Order.getDefault(),
                                                                                                    "ee641afe-ae8e-483f-b59f-4656634fa78d",
                                                                                                    null, null);
            SubtenantApiKeyListOptions subtenantapikeylistoptions2 = subtenantapikeylistoptions1.clone();
            assertNotNull(subtenantapikeylistoptions1);
            assertNotNull(subtenantapikeylistoptions2);
            assertNotSame(subtenantapikeylistoptions2, subtenantapikeylistoptions1);
            assertEquals(subtenantapikeylistoptions2, subtenantapikeylistoptions1);
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
            SubtenantApiKeyListOptions option = new SubtenantApiKeyListOptions().equalToOwner("3cc3e01c-ee19-44cb-8934-45091fec3242")
                                                                                .equalToKey("ff8a6583-f87f-4f56-b3a4-ad6473578604");
            assertTrue(option.hasFilters());
            assertTrue(option.hasFilters(SubtenantApiKeyListOptions.TAG_FILTER_BY_OWNER));
            assertTrue(option.hasFilter(SubtenantApiKeyListOptions.TAG_FILTER_BY_OWNER, FilterOperator.EQUAL));
            assertNotNull(option.getOwnerFilters());
            assertEquals("3cc3e01c-ee19-44cb-8934-45091fec3242",
                         ListOptionsEncoder.encodeSingleEqualFilter(SubtenantApiKeyListOptions.TAG_FILTER_BY_OWNER,
                                                                    String.class, option));
            assertTrue(option.hasFilters(SubtenantApiKeyListOptions.TAG_FILTER_BY_KEY));
            assertTrue(option.hasFilter(SubtenantApiKeyListOptions.TAG_FILTER_BY_KEY, FilterOperator.EQUAL));
            assertNotNull(option.getKeyFilters());
            assertEquals("ff8a6583-f87f-4f56-b3a4-ad6473578604",
                         ListOptionsEncoder.encodeSingleEqualFilter(SubtenantApiKeyListOptions.TAG_FILTER_BY_KEY,
                                                                    String.class, option));
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
            SubtenantApiKeyListOptions subtenantapikeylistoptions1 = new SubtenantApiKeyListOptions(Integer.valueOf(-55),
                                                                                                    Long.valueOf(-125),
                                                                                                    Order.getDefault(),
                                                                                                    "de757e9f-6a52-4ec3-86d6-4bac001db084",
                                                                                                    null, null);
            SubtenantApiKeyListOptions subtenantapikeylistoptions2 = new SubtenantApiKeyListOptions(Integer.valueOf(-55),
                                                                                                    Long.valueOf(-125),
                                                                                                    Order.getDefault(),
                                                                                                    "de757e9f-6a52-4ec3-86d6-4bac001db084",
                                                                                                    null, null);
            assertNotNull(subtenantapikeylistoptions1);
            assertNotNull(subtenantapikeylistoptions2);
            assertNotSame(subtenantapikeylistoptions2, subtenantapikeylistoptions1);
            assertEquals(subtenantapikeylistoptions2, subtenantapikeylistoptions1);
            assertEquals(subtenantapikeylistoptions2.hashCode(), subtenantapikeylistoptions1.hashCode());
            int hashCode = subtenantapikeylistoptions1.hashCode();
            for (int i = 0; i < 5; i++) {
                assertEquals(hashCode, subtenantapikeylistoptions1.hashCode());
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
            SubtenantApiKeyListOptions subtenantapikeylistoptions1 = new SubtenantApiKeyListOptions(Integer.valueOf(-20),
                                                                                                    Long.valueOf(-110),
                                                                                                    Order.getDefault(),
                                                                                                    "b50253f4-1c8a-4ebe-9c8d-9a8aa060a902",
                                                                                                    null, null);
            SubtenantApiKeyListOptions subtenantapikeylistoptions2 = new SubtenantApiKeyListOptions(Integer.valueOf(-20),
                                                                                                    Long.valueOf(-110),
                                                                                                    Order.getDefault(),
                                                                                                    "b50253f4-1c8a-4ebe-9c8d-9a8aa060a902",
                                                                                                    null, null);
            SubtenantApiKeyListOptions subtenantapikeylistoptions3 = new SubtenantApiKeyListOptions(Integer.valueOf(91),
                                                                                                    Long.valueOf(49),
                                                                                                    Order.getDefault(),
                                                                                                    "9539c895-8255-4c29-8ebd-34907f5e7d6e",
                                                                                                    null, null);
            assertNotNull(subtenantapikeylistoptions1);
            assertNotNull(subtenantapikeylistoptions2);
            assertNotNull(subtenantapikeylistoptions3);
            assertNotSame(subtenantapikeylistoptions2, subtenantapikeylistoptions1);
            assertNotSame(subtenantapikeylistoptions3, subtenantapikeylistoptions1);
            assertEquals(subtenantapikeylistoptions2, subtenantapikeylistoptions1);
            assertEquals(subtenantapikeylistoptions2, subtenantapikeylistoptions1);
            assertEquals(subtenantapikeylistoptions1, subtenantapikeylistoptions2);
            assertEquals(subtenantapikeylistoptions1, subtenantapikeylistoptions1);
            assertFalse(subtenantapikeylistoptions1.equals(null));
            assertNotEquals(subtenantapikeylistoptions3, subtenantapikeylistoptions1);
        } catch (Exception exception) {
            fail(exception.getMessage());
        }
    }
}
