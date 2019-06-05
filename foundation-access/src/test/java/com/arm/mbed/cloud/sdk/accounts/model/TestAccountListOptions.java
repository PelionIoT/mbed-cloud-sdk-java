// This file was generated by the Pelion SDK foundation code generator.
// This is an autogenerated unit test class. Do not modify its content as modifications will be lost at next code generation.
package com.arm.mbed.cloud.sdk.accounts.model;

import static org.junit.Assert.*;

import com.arm.mbed.cloud.sdk.common.Order;
import com.arm.mbed.cloud.sdk.common.listing.ListOptionsEncoder;
import com.arm.mbed.cloud.sdk.common.listing.filtering.FilterOperator;
import java.util.Arrays;
import java.util.List;
import org.junit.Test;

/**
 * Unit tests for Model AccountListOptions.
 */
@SuppressWarnings("PMD.AvoidDuplicateLiterals")
public class TestAccountListOptions {
    /**
     * Tests the clone method.
     */
    @SuppressWarnings("resource")
    @Test
    public void testClone() {
        try {
            AccountListOptions accountlistoptions1 = new AccountListOptions(Integer.valueOf(39), Long.valueOf(-8),
                                                                            Order.getDefault(),
                                                                            "deb9972a-9342-48e2-a779-e9d005ca9564",
                                                                            null, null);
            AccountListOptions accountlistoptions2 = accountlistoptions1.clone();
            assertNotNull(accountlistoptions1);
            assertNotNull(accountlistoptions2);
            assertNotSame(accountlistoptions2, accountlistoptions1);
            assertEquals(accountlistoptions2, accountlistoptions1);
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
            AccountListOptions option = new AccountListOptions().equalToTier("2b9be9ae-a28b-4549-be0f-d0ad9d80f166")
                                                                .equalToStatus(AccountStatus.getDefault())
                                                                .inStatuses(Arrays.asList(AccountStatus.getDefault(),
                                                                                          AccountStatus.getDefault(),
                                                                                          AccountStatus.getDefault(),
                                                                                          AccountStatus.getDefault(),
                                                                                          AccountStatus.getDefault(),
                                                                                          AccountStatus.getDefault(),
                                                                                          AccountStatus.getDefault(),
                                                                                          AccountStatus.getDefault()))
                                                                .notInStatuses(Arrays.asList(AccountStatus.getDefault(),
                                                                                             AccountStatus.getDefault(),
                                                                                             AccountStatus.getDefault(),
                                                                                             AccountStatus.getDefault(),
                                                                                             AccountStatus.getDefault(),
                                                                                             AccountStatus.getDefault(),
                                                                                             AccountStatus.getDefault(),
                                                                                             AccountStatus.getDefault()))
                                                                .equalToEndMarket("ac83073a-2d57-4955-b485-4520f010ecba")
                                                                .likeCountry("59f478f8-decb-4a3e-98f2-15d543bd7451");
            assertTrue(option.hasFilters());
            assertTrue(option.hasFilters(AccountListOptions.TAG_FILTER_BY_TIER));
            assertTrue(option.hasFilter(AccountListOptions.TAG_FILTER_BY_TIER, FilterOperator.EQUAL));
            assertNotNull(option.getTierFilters());
            assertEquals("2b9be9ae-a28b-4549-be0f-d0ad9d80f166",
                         ListOptionsEncoder.encodeSingleEqualFilter(AccountListOptions.TAG_FILTER_BY_TIER, String.class,
                                                                    option));
            assertTrue(option.hasFilters(AccountListOptions.TAG_FILTER_BY_STATUS));
            assertTrue(option.hasFilter(AccountListOptions.TAG_FILTER_BY_STATUS, FilterOperator.EQUAL));
            assertNotNull(option.getStatusFilters());
            assertEquals(AccountStatus.getDefault(),
                         ListOptionsEncoder.encodeSingleEqualFilter(AccountListOptions.TAG_FILTER_BY_STATUS,
                                                                    AccountStatus.class, option));
            assertTrue(option.hasFilters(AccountListOptions.TAG_FILTER_BY_STATUS));
            assertTrue(option.hasFilter(AccountListOptions.TAG_FILTER_BY_STATUS, FilterOperator.IN));
            assertNotNull(option.getStatusFilters());
            assertEquals(Arrays.asList(AccountStatus.getDefault(), AccountStatus.getDefault(),
                                       AccountStatus.getDefault(), AccountStatus.getDefault(),
                                       AccountStatus.getDefault(), AccountStatus.getDefault(),
                                       AccountStatus.getDefault(), AccountStatus.getDefault()),
                         ListOptionsEncoder.encodeSingleInFilter(AccountListOptions.TAG_FILTER_BY_STATUS, List.class,
                                                                 option));
            assertTrue(option.hasFilters(AccountListOptions.TAG_FILTER_BY_STATUS));
            assertTrue(option.hasFilter(AccountListOptions.TAG_FILTER_BY_STATUS, FilterOperator.NOT_IN));
            assertNotNull(option.getStatusFilters());
            assertEquals(Arrays.asList(AccountStatus.getDefault(), AccountStatus.getDefault(),
                                       AccountStatus.getDefault(), AccountStatus.getDefault(),
                                       AccountStatus.getDefault(), AccountStatus.getDefault(),
                                       AccountStatus.getDefault(), AccountStatus.getDefault()),
                         ListOptionsEncoder.encodeSingleNotInFilter(AccountListOptions.TAG_FILTER_BY_STATUS, List.class,
                                                                    option));
            assertTrue(option.hasFilters(AccountListOptions.TAG_FILTER_BY_END_MARKET));
            assertTrue(option.hasFilter(AccountListOptions.TAG_FILTER_BY_END_MARKET, FilterOperator.EQUAL));
            assertNotNull(option.getEndMarketFilters());
            assertEquals("ac83073a-2d57-4955-b485-4520f010ecba",
                         ListOptionsEncoder.encodeSingleEqualFilter(AccountListOptions.TAG_FILTER_BY_END_MARKET,
                                                                    String.class, option));
            assertTrue(option.hasFilters(AccountListOptions.TAG_FILTER_BY_COUNTRY));
            assertTrue(option.hasFilter(AccountListOptions.TAG_FILTER_BY_COUNTRY, FilterOperator.LIKE));
            assertNotNull(option.getCountryFilters());
            assertEquals("59f478f8-decb-4a3e-98f2-15d543bd7451",
                         ListOptionsEncoder.encodeSingleLikeFilter(AccountListOptions.TAG_FILTER_BY_COUNTRY,
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
            AccountListOptions accountlistoptions1 = new AccountListOptions(Integer.valueOf(35), Long.valueOf(-100),
                                                                            Order.getDefault(),
                                                                            "8c01fe4e-2867-4a36-8712-e18d3d26ae48",
                                                                            null, null);
            AccountListOptions accountlistoptions2 = new AccountListOptions(Integer.valueOf(35), Long.valueOf(-100),
                                                                            Order.getDefault(),
                                                                            "8c01fe4e-2867-4a36-8712-e18d3d26ae48",
                                                                            null, null);
            assertNotNull(accountlistoptions1);
            assertNotNull(accountlistoptions2);
            assertNotSame(accountlistoptions2, accountlistoptions1);
            assertEquals(accountlistoptions2, accountlistoptions1);
            assertEquals(accountlistoptions2.hashCode(), accountlistoptions1.hashCode());
            int hashCode = accountlistoptions1.hashCode();
            for (int i = 0; i < 5; i++) {
                assertEquals(hashCode, accountlistoptions1.hashCode());
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
            AccountListOptions accountlistoptions1 = new AccountListOptions(Integer.valueOf(38), Long.valueOf(96),
                                                                            Order.getDefault(),
                                                                            "4efc14c5-7c05-4908-9f16-0af2aca0374e",
                                                                            null, null);
            AccountListOptions accountlistoptions2 = new AccountListOptions(Integer.valueOf(38), Long.valueOf(96),
                                                                            Order.getDefault(),
                                                                            "4efc14c5-7c05-4908-9f16-0af2aca0374e",
                                                                            null, null);
            AccountListOptions accountlistoptions3 = new AccountListOptions(Integer.valueOf(8), Long.valueOf(70),
                                                                            Order.getDefault(),
                                                                            "8c556d3c-12fd-496f-b376-8983e525728e",
                                                                            null, null);
            assertNotNull(accountlistoptions1);
            assertNotNull(accountlistoptions2);
            assertNotNull(accountlistoptions3);
            assertNotSame(accountlistoptions2, accountlistoptions1);
            assertNotSame(accountlistoptions3, accountlistoptions1);
            assertEquals(accountlistoptions2, accountlistoptions1);
            assertEquals(accountlistoptions2, accountlistoptions1);
            assertEquals(accountlistoptions1, accountlistoptions2);
            assertEquals(accountlistoptions1, accountlistoptions1);
            assertFalse(accountlistoptions1.equals(null));
            assertNotEquals(accountlistoptions3, accountlistoptions1);
        } catch (Exception exception) {
            fail(exception.getMessage());
        }
    }
}
