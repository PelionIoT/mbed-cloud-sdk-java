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
            SubtenantUserInvitation subtenantuserinvitation1 = new SubtenantUserInvitation("acc8cb178a5cea59a0ac26cbc2e1911d",
                                                                                           new Date(1559746951134L),
                                                                                           "a1712.c1b63@6b008.fr",
                                                                                           new Date(1559746951180L),
                                                                                           "acc8cb178a5cea59a0ac26cbc2e1911d",
                                                                                           null,
                                                                                           new Date(1559746955696L),
                                                                                           "acc8cb178a5cea59a0ac26cbc2e1911d");
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
            SubtenantUserInvitation subtenantuserinvitation1 = new SubtenantUserInvitation("acc8cb178a5cea59a0ac26cbc2e1911d",
                                                                                           new Date(1559746951143L),
                                                                                           "6455f.64719@accfc.me",
                                                                                           new Date(1559746952907L),
                                                                                           "acc8cb178a5cea59a0ac26cbc2e1911d",
                                                                                           null,
                                                                                           new Date(1559746947089L),
                                                                                           "acc8cb178a5cea59a0ac26cbc2e1911d");
            SubtenantUserInvitation subtenantuserinvitation2 = new SubtenantUserInvitation("acc8cb178a5cea59a0ac26cbc2e1911d",
                                                                                           new Date(1559746951143L),
                                                                                           "6455f.64719@accfc.me",
                                                                                           new Date(1559746952907L),
                                                                                           "acc8cb178a5cea59a0ac26cbc2e1911d",
                                                                                           null,
                                                                                           new Date(1559746947089L),
                                                                                           "acc8cb178a5cea59a0ac26cbc2e1911d");
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
        SubtenantUserInvitation subtenantuserinvitation = new SubtenantUserInvitation("acc8cb178a5cea59a0ac26cbc2e1911d",
                                                                                      new Date(1559746947677L),
                                                                                      "d0a03.690b3@791b6.me",
                                                                                      new Date(1559746955547L),
                                                                                      "acc8cb178a5cea59a0ac26cbc2e1911d",
                                                                                      null, new Date(1559746953085L),
                                                                                      "acc8cb178a5cea59a0ac26cbc2e1911d");
        assertTrue(subtenantuserinvitation.isValid());
        SubtenantUserInvitation subtenantuserinvitationInvalid = new SubtenantUserInvitation(null,
                                                                                             new Date(1559746952083L),
                                                                                             null,
                                                                                             new Date(1559746954482L),
                                                                                             "4 4䣛4\f4O434膗A膶3�?�⠿3VB+3\u0011휈/旺)4ﾾ)4K?\u0014*NὯ>㙥M櫉ऻU4>P3\\\\鲄ힰ44'33械\u0017항T]E",
                                                                                             null,
                                                                                             new Date(1559746953210L),
                                                                                             "4 4䣛4\f4O434膗A膶3�?�⠿3VB+3\u0011휈/旺)4ﾾ)4K?\u0014*NὯ>㙥M櫉ऻU4>P3\\\\鲄ힰ44'33械\u0017항T]E");
        assertFalse(subtenantuserinvitationInvalid.isValid());
    }

    /**
     * Tests the equals method.
     */
    @SuppressWarnings("resource")
    @Test
    public void testEquals() {
        try {
            SubtenantUserInvitation subtenantuserinvitation1 = new SubtenantUserInvitation("acc8cb178a5cea59a0ac26cbc2e1911d",
                                                                                           new Date(1559746953811L),
                                                                                           "8ae03.dc9d0@317f2.fr",
                                                                                           new Date(1559746947536L),
                                                                                           "acc8cb178a5cea59a0ac26cbc2e1911d",
                                                                                           null,
                                                                                           new Date(1559746955498L),
                                                                                           "acc8cb178a5cea59a0ac26cbc2e1911d");
            SubtenantUserInvitation subtenantuserinvitation2 = new SubtenantUserInvitation("acc8cb178a5cea59a0ac26cbc2e1911d",
                                                                                           new Date(1559746953811L),
                                                                                           "8ae03.dc9d0@317f2.fr",
                                                                                           new Date(1559746947536L),
                                                                                           "acc8cb178a5cea59a0ac26cbc2e1911d",
                                                                                           null,
                                                                                           new Date(1559746955498L),
                                                                                           "acc8cb178a5cea59a0ac26cbc2e1911d");
            SubtenantUserInvitation subtenantuserinvitation3 = new SubtenantUserInvitation("acc8cb178a5cea59a0ac26cbc2e1911d",
                                                                                           new Date(1559746953775L),
                                                                                           "82f7a.fb2fa@aad0c.me",
                                                                                           new Date(1559746954882L),
                                                                                           "acc8cb178a5cea59a0ac26cbc2e1911d",
                                                                                           null,
                                                                                           new Date(1559746950108L),
                                                                                           "acc8cb178a5cea59a0ac26cbc2e1911d");
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
