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
            SubtenantUserInvitationListOptions subtenantuserinvitationlistoptions1 = new SubtenantUserInvitationListOptions(Integer.valueOf(-110),
                                                                                                                            Long.valueOf(-126),
                                                                                                                            Order.getDefault(),
                                                                                                                            "1e1c1816-0192-4fc2-90bc-cee330bf69e8",
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
     * Tests the hashCode method.
     */
    @SuppressWarnings("resource")
    @Test
    public void testHashCode() {
        try {
            SubtenantUserInvitationListOptions subtenantuserinvitationlistoptions1 = new SubtenantUserInvitationListOptions(Integer.valueOf(78),
                                                                                                                            Long.valueOf(122),
                                                                                                                            Order.getDefault(),
                                                                                                                            "67cc961c-0d3a-4005-be67-f25999213cac",
                                                                                                                            null,
                                                                                                                            null);
            SubtenantUserInvitationListOptions subtenantuserinvitationlistoptions2 = new SubtenantUserInvitationListOptions(Integer.valueOf(78),
                                                                                                                            Long.valueOf(122),
                                                                                                                            Order.getDefault(),
                                                                                                                            "67cc961c-0d3a-4005-be67-f25999213cac",
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
            SubtenantUserInvitationListOptions subtenantuserinvitationlistoptions1 = new SubtenantUserInvitationListOptions(Integer.valueOf(49),
                                                                                                                            Long.valueOf(23),
                                                                                                                            Order.getDefault(),
                                                                                                                            "36db52ba-45ed-4881-93f1-831f47c04096",
                                                                                                                            null,
                                                                                                                            null);
            SubtenantUserInvitationListOptions subtenantuserinvitationlistoptions2 = new SubtenantUserInvitationListOptions(Integer.valueOf(49),
                                                                                                                            Long.valueOf(23),
                                                                                                                            Order.getDefault(),
                                                                                                                            "36db52ba-45ed-4881-93f1-831f47c04096",
                                                                                                                            null,
                                                                                                                            null);
            SubtenantUserInvitationListOptions subtenantuserinvitationlistoptions3 = new SubtenantUserInvitationListOptions(Integer.valueOf(63),
                                                                                                                            Long.valueOf(37),
                                                                                                                            Order.getDefault(),
                                                                                                                            "04636ee2-a9e5-4039-b744-d13f85ab2626",
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
