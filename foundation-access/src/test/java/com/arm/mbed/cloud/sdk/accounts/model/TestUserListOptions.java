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
 * Unit tests for Model UserListOptions.
 */
@SuppressWarnings("PMD.AvoidDuplicateLiterals")
public class TestUserListOptions {
    /**
     * Tests the clone method.
     */
    @SuppressWarnings("resource")
    @Test
    public void testClone() {
        try {
            UserListOptions userlistoptions1 = new UserListOptions(Integer.valueOf(-30), Long.valueOf(106),
                                                                   Order.getDefault(),
                                                                   "c05bc37d-a885-4c5a-80ba-1f2faa7d7adb", null, null);
            UserListOptions userlistoptions2 = userlistoptions1.clone();
            assertNotNull(userlistoptions1);
            assertNotNull(userlistoptions2);
            assertNotSame(userlistoptions2, userlistoptions1);
            assertEquals(userlistoptions2, userlistoptions1);
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
            // Cannot test Filter [field=loginProfiles, spec field=loginProfiles, tag=TAG_FILTER_BY_LOGIN_PROFILES,
            // operator=equal to, type=List<LoginProfile>, isVerified=true] because the field is a list and the filter
            // only accepts single values
            UserListOptions option = new UserListOptions().equalToStatus(UserStatus.getDefault())
                                                          .inStatuses(Arrays.asList(UserStatus.getDefault(),
                                                                                    UserStatus.getDefault(),
                                                                                    UserStatus.getDefault(),
                                                                                    UserStatus.getDefault(),
                                                                                    UserStatus.getDefault(),
                                                                                    UserStatus.getDefault()))
                                                          .notInStatuses(Arrays.asList(UserStatus.getDefault(),
                                                                                       UserStatus.getDefault(),
                                                                                       UserStatus.getDefault(),
                                                                                       UserStatus.getDefault(),
                                                                                       UserStatus.getDefault()))
                                                          .equalToEmail("4b594.1e9b4@a94b9.me");
            assertTrue(option.hasFilters());
            // Cannot test Filter [field=loginProfiles, spec field=loginProfiles, tag=TAG_FILTER_BY_LOGIN_PROFILES,
            // operator=equal to, type=List<LoginProfile>, isVerified=true] because the field is a list and the filter
            // only accepts single values
            assertTrue(option.hasFilters(UserListOptions.TAG_FILTER_BY_STATUS));
            assertTrue(option.hasFilter(UserListOptions.TAG_FILTER_BY_STATUS, FilterOperator.EQUAL));
            assertNotNull(option.getStatusFilters());
            assertEquals(UserStatus.getDefault(),
                         ListOptionsEncoder.encodeSingleEqualFilter(UserListOptions.TAG_FILTER_BY_STATUS,
                                                                    UserStatus.class, option));
            assertTrue(option.hasFilters(UserListOptions.TAG_FILTER_BY_STATUS));
            assertTrue(option.hasFilter(UserListOptions.TAG_FILTER_BY_STATUS, FilterOperator.IN));
            assertNotNull(option.getStatusFilters());
            assertEquals(Arrays.asList(UserStatus.getDefault(), UserStatus.getDefault(), UserStatus.getDefault(),
                                       UserStatus.getDefault(), UserStatus.getDefault(), UserStatus.getDefault()),
                         ListOptionsEncoder.encodeSingleInFilter(UserListOptions.TAG_FILTER_BY_STATUS, List.class,
                                                                 option));
            assertTrue(option.hasFilters(UserListOptions.TAG_FILTER_BY_STATUS));
            assertTrue(option.hasFilter(UserListOptions.TAG_FILTER_BY_STATUS, FilterOperator.NOT_IN));
            assertNotNull(option.getStatusFilters());
            assertEquals(Arrays.asList(UserStatus.getDefault(), UserStatus.getDefault(), UserStatus.getDefault(),
                                       UserStatus.getDefault(), UserStatus.getDefault()),
                         ListOptionsEncoder.encodeSingleNotInFilter(UserListOptions.TAG_FILTER_BY_STATUS, List.class,
                                                                    option));
            assertTrue(option.hasFilters(UserListOptions.TAG_FILTER_BY_EMAIL));
            assertTrue(option.hasFilter(UserListOptions.TAG_FILTER_BY_EMAIL, FilterOperator.EQUAL));
            assertNotNull(option.getEmailFilters());
            assertEquals("4b594.1e9b4@a94b9.me",
                         ListOptionsEncoder.encodeSingleEqualFilter(UserListOptions.TAG_FILTER_BY_EMAIL, String.class,
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
            UserListOptions userlistoptions1 = new UserListOptions(Integer.valueOf(-101), Long.valueOf(-65),
                                                                   Order.getDefault(),
                                                                   "921dc417-00fa-4300-b409-64c0312f3e84", null, null);
            UserListOptions userlistoptions2 = new UserListOptions(Integer.valueOf(-101), Long.valueOf(-65),
                                                                   Order.getDefault(),
                                                                   "921dc417-00fa-4300-b409-64c0312f3e84", null, null);
            assertNotNull(userlistoptions1);
            assertNotNull(userlistoptions2);
            assertNotSame(userlistoptions2, userlistoptions1);
            assertEquals(userlistoptions2, userlistoptions1);
            assertEquals(userlistoptions2.hashCode(), userlistoptions1.hashCode());
            int hashCode = userlistoptions1.hashCode();
            for (int i = 0; i < 5; i++) {
                assertEquals(hashCode, userlistoptions1.hashCode());
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
            UserListOptions userlistoptions1 = new UserListOptions(Integer.valueOf(112), Long.valueOf(-72),
                                                                   Order.getDefault(),
                                                                   "b22150f6-abe8-4c5f-ac9b-2cbda159ebbd", null, null);
            UserListOptions userlistoptions2 = new UserListOptions(Integer.valueOf(112), Long.valueOf(-72),
                                                                   Order.getDefault(),
                                                                   "b22150f6-abe8-4c5f-ac9b-2cbda159ebbd", null, null);
            UserListOptions userlistoptions3 = new UserListOptions(Integer.valueOf(19), Long.valueOf(-108),
                                                                   Order.getDefault(),
                                                                   "10aea711-32b4-4ca4-9797-3de4e2ae3110", null, null);
            assertNotNull(userlistoptions1);
            assertNotNull(userlistoptions2);
            assertNotNull(userlistoptions3);
            assertNotSame(userlistoptions2, userlistoptions1);
            assertNotSame(userlistoptions3, userlistoptions1);
            assertEquals(userlistoptions2, userlistoptions1);
            assertEquals(userlistoptions2, userlistoptions1);
            assertEquals(userlistoptions1, userlistoptions2);
            assertEquals(userlistoptions1, userlistoptions1);
            assertFalse(userlistoptions1.equals(null));
            assertNotEquals(userlistoptions3, userlistoptions1);
        } catch (Exception exception) {
            fail(exception.getMessage());
        }
    }
}
