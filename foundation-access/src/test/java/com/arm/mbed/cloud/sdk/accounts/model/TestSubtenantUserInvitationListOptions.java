// This file was generated by the Pelion SDK foundation code generator.
// This is an autogenerated unit test class. Do not modify its content as modifications will be lost at next code generation.
package com.arm.mbed.cloud.sdk.accounts.model;

import static org.junit.Assert.*;

import com.arm.mbed.cloud.sdk.common.Order;
import org.junit.Test;

/**
 * Unit tests for Model SubtenantUserInvitationListOptions.
 */
@SuppressWarnings("PMD.AvoidDuplicateLiterals")
public class TestSubtenantUserInvitationListOptions {
    /**
     * Tests the clone method.
     */
    @SuppressWarnings("resource")
    @Test
    public void testClone() {
        try {
            SubtenantUserInvitationListOptions subtenantuserinvitationlistoptions1 = new SubtenantUserInvitationListOptions(Integer.valueOf(18),
                                                                                                                            Long.valueOf(-93),
                                                                                                                            Order.getDefault(),
                                                                                                                            "52f689ba-747a-4abf-a1bf-72a827f00707",
                                                                                                                            null,
                                                                                                                            null);
            SubtenantUserInvitationListOptions subtenantuserinvitationlistoptions2 = subtenantuserinvitationlistoptions1.clone();
            assertNotNull(subtenantuserinvitationlistoptions1);
            assertNotNull(subtenantuserinvitationlistoptions2);
            assertNotSame(subtenantuserinvitationlistoptions2, subtenantuserinvitationlistoptions1);
            assertEquals(subtenantuserinvitationlistoptions2, subtenantuserinvitationlistoptions1);
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
            SubtenantUserInvitationListOptions option = new SubtenantUserInvitationListOptions();
            assertFalse(option.hasFilters());
            // Cannot test Filter [field=loginProfiles, spec field=loginProfiles, tag=TAG_FILTER_BY_LOGIN_PROFILES,
            // operator=equal to, type=List<LoginProfile>, isVerified=true] because the field is a list and the filter
            // only accepts single values
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
            SubtenantUserInvitationListOptions subtenantuserinvitationlistoptions1 = new SubtenantUserInvitationListOptions(Integer.valueOf(-94),
                                                                                                                            Long.valueOf(-45),
                                                                                                                            Order.getDefault(),
                                                                                                                            "bec7b7a0-d784-477b-8ffc-a3b6e6688680",
                                                                                                                            null,
                                                                                                                            null);
            SubtenantUserInvitationListOptions subtenantuserinvitationlistoptions2 = new SubtenantUserInvitationListOptions(Integer.valueOf(-94),
                                                                                                                            Long.valueOf(-45),
                                                                                                                            Order.getDefault(),
                                                                                                                            "bec7b7a0-d784-477b-8ffc-a3b6e6688680",
                                                                                                                            null,
                                                                                                                            null);
            assertNotNull(subtenantuserinvitationlistoptions1);
            assertNotNull(subtenantuserinvitationlistoptions2);
            assertNotSame(subtenantuserinvitationlistoptions2, subtenantuserinvitationlistoptions1);
            assertEquals(subtenantuserinvitationlistoptions2, subtenantuserinvitationlistoptions1);
            assertEquals(subtenantuserinvitationlistoptions2.hashCode(),
                         subtenantuserinvitationlistoptions1.hashCode());
            int hashCode = subtenantuserinvitationlistoptions1.hashCode();
            for (int i = 0; i < 5; i++) {
                assertEquals(hashCode, subtenantuserinvitationlistoptions1.hashCode());
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
            SubtenantUserInvitationListOptions subtenantuserinvitationlistoptions1 = new SubtenantUserInvitationListOptions(Integer.valueOf(74),
                                                                                                                            Long.valueOf(-50),
                                                                                                                            Order.getDefault(),
                                                                                                                            "5637fd55-69f5-4c80-b28b-4c783fc66336",
                                                                                                                            null,
                                                                                                                            null);
            SubtenantUserInvitationListOptions subtenantuserinvitationlistoptions2 = new SubtenantUserInvitationListOptions(Integer.valueOf(74),
                                                                                                                            Long.valueOf(-50),
                                                                                                                            Order.getDefault(),
                                                                                                                            "5637fd55-69f5-4c80-b28b-4c783fc66336",
                                                                                                                            null,
                                                                                                                            null);
            SubtenantUserInvitationListOptions subtenantuserinvitationlistoptions3 = new SubtenantUserInvitationListOptions(Integer.valueOf(45),
                                                                                                                            Long.valueOf(94),
                                                                                                                            Order.getDefault(),
                                                                                                                            "6c2795a9-61d0-49f0-a2cb-4e25057e2897",
                                                                                                                            null,
                                                                                                                            null);
            assertNotNull(subtenantuserinvitationlistoptions1);
            assertNotNull(subtenantuserinvitationlistoptions2);
            assertNotNull(subtenantuserinvitationlistoptions3);
            assertNotSame(subtenantuserinvitationlistoptions2, subtenantuserinvitationlistoptions1);
            assertNotSame(subtenantuserinvitationlistoptions3, subtenantuserinvitationlistoptions1);
            assertEquals(subtenantuserinvitationlistoptions2, subtenantuserinvitationlistoptions1);
            assertEquals(subtenantuserinvitationlistoptions2, subtenantuserinvitationlistoptions1);
            assertEquals(subtenantuserinvitationlistoptions1, subtenantuserinvitationlistoptions2);
            assertEquals(subtenantuserinvitationlistoptions1, subtenantuserinvitationlistoptions1);
            assertFalse(subtenantuserinvitationlistoptions1.equals(null));
            assertNotEquals(subtenantuserinvitationlistoptions3, subtenantuserinvitationlistoptions1);
        } catch (Exception exception) {
            fail(exception.getMessage());
        }
    }
}
