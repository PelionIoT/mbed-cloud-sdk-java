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
            SubtenantUserInvitationListOptions subtenantuserinvitationlistoptions1 = new SubtenantUserInvitationListOptions(Integer.valueOf(-11),
                                                                                                                            Long.valueOf(111),
                                                                                                                            Order.getDefault(),
                                                                                                                            "a22937cc-f676-4a43-b361-47450e10a49b",
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
            SubtenantUserInvitationListOptions subtenantuserinvitationlistoptions1 = new SubtenantUserInvitationListOptions(Integer.valueOf(24),
                                                                                                                            Long.valueOf(-67),
                                                                                                                            Order.getDefault(),
                                                                                                                            "bc0e7c58-c617-40d7-8516-58c6e69fc946",
                                                                                                                            null,
                                                                                                                            null);
            SubtenantUserInvitationListOptions subtenantuserinvitationlistoptions2 = new SubtenantUserInvitationListOptions(Integer.valueOf(24),
                                                                                                                            Long.valueOf(-67),
                                                                                                                            Order.getDefault(),
                                                                                                                            "bc0e7c58-c617-40d7-8516-58c6e69fc946",
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
            SubtenantUserInvitationListOptions subtenantuserinvitationlistoptions1 = new SubtenantUserInvitationListOptions(Integer.valueOf(-2),
                                                                                                                            Long.valueOf(-36),
                                                                                                                            Order.getDefault(),
                                                                                                                            "7c9f27ec-baf2-49e4-aabc-20856ee599b7",
                                                                                                                            null,
                                                                                                                            null);
            SubtenantUserInvitationListOptions subtenantuserinvitationlistoptions2 = new SubtenantUserInvitationListOptions(Integer.valueOf(-2),
                                                                                                                            Long.valueOf(-36),
                                                                                                                            Order.getDefault(),
                                                                                                                            "7c9f27ec-baf2-49e4-aabc-20856ee599b7",
                                                                                                                            null,
                                                                                                                            null);
            SubtenantUserInvitationListOptions subtenantuserinvitationlistoptions3 = new SubtenantUserInvitationListOptions(Integer.valueOf(-106),
                                                                                                                            Long.valueOf(17),
                                                                                                                            Order.getDefault(),
                                                                                                                            "930d802b-faf3-48d6-b9a4-90d5abe9f186",
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
