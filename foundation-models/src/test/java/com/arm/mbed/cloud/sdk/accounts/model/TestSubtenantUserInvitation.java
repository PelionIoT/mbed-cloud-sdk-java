// This file was generated by the Pelion SDK foundation code generator.
// This is an autogenerated unit test class. Do not modify its content as modifications will be lost at next code generation.
package com.arm.mbed.cloud.sdk.accounts.model;

import static org.junit.Assert.*;

import java.util.Date;
import org.junit.Test;

/**
 * Unit tests for Model SubtenantUserInvitation.
 */
@SuppressWarnings("PMD.AvoidDuplicateLiterals")
public class TestSubtenantUserInvitation {
    /**
     * Tests the clone method.
     */
    @SuppressWarnings("resource")
    @Test
    public void testClone() {
        try {
            SubtenantUserInvitation subtenantuserinvitation1 = new SubtenantUserInvitation("ebb6e571ba299e09d8e8859accae6efa",
                                                                                           new Date(1558003282474L),
                                                                                           "c3c23.cde77@154c9.fr",
                                                                                           new Date(1558003274876L),
                                                                                           "ebb6e571ba299e09d8e8859accae6efa",
                                                                                           null,
                                                                                           new Date(1558003275173L),
                                                                                           "ebb6e571ba299e09d8e8859accae6efa");
            SubtenantUserInvitation subtenantuserinvitation2 = subtenantuserinvitation1.clone();
            assertNotNull(subtenantuserinvitation1);
            assertNotNull(subtenantuserinvitation2);
            assertNotSame(subtenantuserinvitation2, subtenantuserinvitation1);
            assertEquals(subtenantuserinvitation2, subtenantuserinvitation1);
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
            SubtenantUserInvitation subtenantuserinvitation1 = new SubtenantUserInvitation("ebb6e571ba299e09d8e8859accae6efa",
                                                                                           new Date(1558003282407L),
                                                                                           "11532.64f3a@40625.fr",
                                                                                           new Date(1558003279142L),
                                                                                           "ebb6e571ba299e09d8e8859accae6efa",
                                                                                           null,
                                                                                           new Date(1558003279949L),
                                                                                           "ebb6e571ba299e09d8e8859accae6efa");
            SubtenantUserInvitation subtenantuserinvitation2 = new SubtenantUserInvitation("ebb6e571ba299e09d8e8859accae6efa",
                                                                                           new Date(1558003282407L),
                                                                                           "11532.64f3a@40625.fr",
                                                                                           new Date(1558003279142L),
                                                                                           "ebb6e571ba299e09d8e8859accae6efa",
                                                                                           null,
                                                                                           new Date(1558003279949L),
                                                                                           "ebb6e571ba299e09d8e8859accae6efa");
            assertNotNull(subtenantuserinvitation1);
            assertNotNull(subtenantuserinvitation2);
            assertNotSame(subtenantuserinvitation2, subtenantuserinvitation1);
            assertEquals(subtenantuserinvitation2, subtenantuserinvitation1);
            assertEquals(subtenantuserinvitation2.hashCode(), subtenantuserinvitation1.hashCode());
            int hashCode = subtenantuserinvitation1.hashCode();
            for (int i = 0; i < 5; i++) {
                assertEquals(hashCode, subtenantuserinvitation1.hashCode());
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
        SubtenantUserInvitation subtenantuserinvitation = new SubtenantUserInvitation("ebb6e571ba299e09d8e8859accae6efa",
                                                                                      new Date(1558003280550L),
                                                                                      "d2b9a.28d07@e7475.fr",
                                                                                      new Date(1558003281766L),
                                                                                      "ebb6e571ba299e09d8e8859accae6efa",
                                                                                      null, new Date(1558003276418L),
                                                                                      "ebb6e571ba299e09d8e8859accae6efa");
        assertTrue(subtenantuserinvitation.isValid());
        SubtenantUserInvitation subtenantuserinvitationInvalid = new SubtenantUserInvitation(null,
                                                                                             new Date(1558003274607L),
                                                                                             null,
                                                                                             new Date(1558003275885L),
                                                                                             "\u000143兲ᥢ3& ][[枠34P\u0006[43=44V44覠뺔ຫ&\b㘒\u001e\u001f餆S.4:F\t333!?3,!4Wᰓ(3O\u0004綱骾B3\u0012",
                                                                                             null,
                                                                                             new Date(1558003276926L),
                                                                                             "\u000143兲ᥢ3& ][[枠34P\u0006[43=44V44覠뺔ຫ&\b㘒\u001e\u001f餆S.4:F\t333!?3,!4Wᰓ(3O\u0004綱骾B3\u0012");
        assertFalse(subtenantuserinvitationInvalid.isValid());
    }

    /**
     * Tests the equals method.
     */
    @SuppressWarnings("resource")
    @Test
    public void testEquals() {
        try {
            SubtenantUserInvitation subtenantuserinvitation1 = new SubtenantUserInvitation("ebb6e571ba299e09d8e8859accae6efa",
                                                                                           new Date(1558003279845L),
                                                                                           "20d2f.83b4d@733f4.fr",
                                                                                           new Date(1558003278526L),
                                                                                           "ebb6e571ba299e09d8e8859accae6efa",
                                                                                           null,
                                                                                           new Date(1558003273544L),
                                                                                           "ebb6e571ba299e09d8e8859accae6efa");
            SubtenantUserInvitation subtenantuserinvitation2 = new SubtenantUserInvitation("ebb6e571ba299e09d8e8859accae6efa",
                                                                                           new Date(1558003279845L),
                                                                                           "20d2f.83b4d@733f4.fr",
                                                                                           new Date(1558003278526L),
                                                                                           "ebb6e571ba299e09d8e8859accae6efa",
                                                                                           null,
                                                                                           new Date(1558003273544L),
                                                                                           "ebb6e571ba299e09d8e8859accae6efa");
            SubtenantUserInvitation subtenantuserinvitation3 = new SubtenantUserInvitation("ebb6e571ba299e09d8e8859accae6efa",
                                                                                           new Date(1558003281287L),
                                                                                           "98a74.8dd29@dd5a7.me",
                                                                                           new Date(1558003282888L),
                                                                                           "ebb6e571ba299e09d8e8859accae6efa",
                                                                                           null,
                                                                                           new Date(1558003277236L),
                                                                                           "ebb6e571ba299e09d8e8859accae6efa");
            assertNotNull(subtenantuserinvitation1);
            assertNotNull(subtenantuserinvitation2);
            assertNotNull(subtenantuserinvitation3);
            assertNotSame(subtenantuserinvitation2, subtenantuserinvitation1);
            assertNotSame(subtenantuserinvitation3, subtenantuserinvitation1);
            assertEquals(subtenantuserinvitation2, subtenantuserinvitation1);
            assertEquals(subtenantuserinvitation2, subtenantuserinvitation1);
            assertEquals(subtenantuserinvitation1, subtenantuserinvitation2);
            assertEquals(subtenantuserinvitation1, subtenantuserinvitation1);
            assertFalse(subtenantuserinvitation1.equals(null));
            assertNotEquals(subtenantuserinvitation3, subtenantuserinvitation1);
        } catch (Exception exception) {
            fail(exception.getMessage());
        }
    }
}