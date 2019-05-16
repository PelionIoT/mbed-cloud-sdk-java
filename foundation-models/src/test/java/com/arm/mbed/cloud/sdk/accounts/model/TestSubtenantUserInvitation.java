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
            SubtenantUserInvitation subtenantuserinvitation1 = new SubtenantUserInvitation("bc05f908d0c49f1d35eb7cbe17ca2cb5",
                                                                                           new Date(1557969575846L),
                                                                                           "553bc.39f7c@5700e.fr",
                                                                                           new Date(1557969579025L),
                                                                                           "bc05f908d0c49f1d35eb7cbe17ca2cb5",
                                                                                           null,
                                                                                           new Date(1557969576388L),
                                                                                           "bc05f908d0c49f1d35eb7cbe17ca2cb5");
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
            SubtenantUserInvitation subtenantuserinvitation1 = new SubtenantUserInvitation("bc05f908d0c49f1d35eb7cbe17ca2cb5",
                                                                                           new Date(1557969573418L),
                                                                                           "487cd.6072c@579ab.fr",
                                                                                           new Date(1557969577420L),
                                                                                           "bc05f908d0c49f1d35eb7cbe17ca2cb5",
                                                                                           null,
                                                                                           new Date(1557969575608L),
                                                                                           "bc05f908d0c49f1d35eb7cbe17ca2cb5");
            SubtenantUserInvitation subtenantuserinvitation2 = new SubtenantUserInvitation("bc05f908d0c49f1d35eb7cbe17ca2cb5",
                                                                                           new Date(1557969573418L),
                                                                                           "487cd.6072c@579ab.fr",
                                                                                           new Date(1557969577420L),
                                                                                           "bc05f908d0c49f1d35eb7cbe17ca2cb5",
                                                                                           null,
                                                                                           new Date(1557969575608L),
                                                                                           "bc05f908d0c49f1d35eb7cbe17ca2cb5");
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
        SubtenantUserInvitation subtenantuserinvitation = new SubtenantUserInvitation("bc05f908d0c49f1d35eb7cbe17ca2cb5",
                                                                                      new Date(1557969569603L),
                                                                                      "2ecdb.28d11@b1ed3.fr",
                                                                                      new Date(1557969570484L),
                                                                                      "bc05f908d0c49f1d35eb7cbe17ca2cb5",
                                                                                      null, new Date(1557969570377L),
                                                                                      "bc05f908d0c49f1d35eb7cbe17ca2cb5");
        assertTrue(subtenantuserinvitation.isValid());
        SubtenantUserInvitation subtenantuserinvitationInvalid = new SubtenantUserInvitation(null,
                                                                                             new Date(1557969577663L),
                                                                                             null,
                                                                                             new Date(1557969575052L),
                                                                                             "/(6\u001b\u00166Y%N--\t66(-6�?�XI R\u000e6賺諸<6-6]66薿\u001e6\u0003\u0006@?66;ꄡP\u0013\u0002ꢷB6#A6\u0016XMM]\u0018^೹",
                                                                                             null,
                                                                                             new Date(1557969572310L),
                                                                                             "/(6\u001b\u00166Y%N--\t66(-6�?�XI R\u000e6賺諸<6-6]66薿\u001e6\u0003\u0006@?66;ꄡP\u0013\u0002ꢷB6#A6\u0016XMM]\u0018^೹");
        assertFalse(subtenantuserinvitationInvalid.isValid());
    }

    /**
     * Tests the equals method.
     */
    @SuppressWarnings("resource")
    @Test
    public void testEquals() {
        try {
            SubtenantUserInvitation subtenantuserinvitation1 = new SubtenantUserInvitation("bc05f908d0c49f1d35eb7cbe17ca2cb5",
                                                                                           new Date(1557969572694L),
                                                                                           "df6c6.bac9d@fd64e.me",
                                                                                           new Date(1557969572571L),
                                                                                           "bc05f908d0c49f1d35eb7cbe17ca2cb5",
                                                                                           null,
                                                                                           new Date(1557969571687L),
                                                                                           "bc05f908d0c49f1d35eb7cbe17ca2cb5");
            SubtenantUserInvitation subtenantuserinvitation2 = new SubtenantUserInvitation("bc05f908d0c49f1d35eb7cbe17ca2cb5",
                                                                                           new Date(1557969572694L),
                                                                                           "df6c6.bac9d@fd64e.me",
                                                                                           new Date(1557969572571L),
                                                                                           "bc05f908d0c49f1d35eb7cbe17ca2cb5",
                                                                                           null,
                                                                                           new Date(1557969571687L),
                                                                                           "bc05f908d0c49f1d35eb7cbe17ca2cb5");
            SubtenantUserInvitation subtenantuserinvitation3 = new SubtenantUserInvitation("bc05f908d0c49f1d35eb7cbe17ca2cb5",
                                                                                           new Date(1557969575398L),
                                                                                           "61d69.342b8@80986.fr",
                                                                                           new Date(1557969574635L),
                                                                                           "bc05f908d0c49f1d35eb7cbe17ca2cb5",
                                                                                           null,
                                                                                           new Date(1557969573705L),
                                                                                           "bc05f908d0c49f1d35eb7cbe17ca2cb5");
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
