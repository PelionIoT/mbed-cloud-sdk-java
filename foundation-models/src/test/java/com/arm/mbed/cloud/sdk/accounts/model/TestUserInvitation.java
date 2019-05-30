// This file was generated by the Pelion SDK foundation code generator.
// This is an autogenerated unit test class. Do not modify its content as modifications will be lost at next code generation.
package com.arm.mbed.cloud.sdk.accounts.model;

import static org.junit.Assert.*;

import java.util.Date;
import org.junit.Test;

/**
 * Unit tests for Model UserInvitation.
 */
@SuppressWarnings("PMD.AvoidDuplicateLiterals")
public class TestUserInvitation {
    /**
     * Tests the clone method.
     */
    @SuppressWarnings("resource")
    @Test
    public void testClone() {
        try {
            UserInvitation userinvitation1 = new UserInvitation("ae7a4e096c0cf61badbe341c63408ff3",
                                                                new Date(1559148835354L), "0ae8e.67abd@5d4b0.fr",
                                                                new Date(1559148826422L),
                                                                "ae7a4e096c0cf61badbe341c63408ff3", null,
                                                                new Date(1559148828006L),
                                                                "ae7a4e096c0cf61badbe341c63408ff3");
            UserInvitation userinvitation2 = userinvitation1.clone();
            assertNotNull(userinvitation1);
            assertNotNull(userinvitation2);
            assertNotSame(userinvitation2, userinvitation1);
            assertEquals(userinvitation2, userinvitation1);
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
            UserInvitation userinvitation1 = new UserInvitation("ae7a4e096c0cf61badbe341c63408ff3",
                                                                new Date(1559148826789L), "fae40.127d2@fb6a9.fr",
                                                                new Date(1559148834401L),
                                                                "ae7a4e096c0cf61badbe341c63408ff3", null,
                                                                new Date(1559148826512L),
                                                                "ae7a4e096c0cf61badbe341c63408ff3");
            UserInvitation userinvitation2 = new UserInvitation("ae7a4e096c0cf61badbe341c63408ff3",
                                                                new Date(1559148826789L), "fae40.127d2@fb6a9.fr",
                                                                new Date(1559148834401L),
                                                                "ae7a4e096c0cf61badbe341c63408ff3", null,
                                                                new Date(1559148826512L),
                                                                "ae7a4e096c0cf61badbe341c63408ff3");
            assertNotNull(userinvitation1);
            assertNotNull(userinvitation2);
            assertNotSame(userinvitation2, userinvitation1);
            assertEquals(userinvitation2, userinvitation1);
            assertEquals(userinvitation2.hashCode(), userinvitation1.hashCode());
            int hashCode = userinvitation1.hashCode();
            for (int i = 0; i < 5; i++) {
                assertEquals(hashCode, userinvitation1.hashCode());
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
        UserInvitation userinvitation = new UserInvitation("ae7a4e096c0cf61badbe341c63408ff3", new Date(1559148833082L),
                                                           "4d03b.7e297@0d00b.fr", new Date(1559148829038L),
                                                           "ae7a4e096c0cf61badbe341c63408ff3", null,
                                                           new Date(1559148827569L),
                                                           "ae7a4e096c0cf61badbe341c63408ff3");
        assertTrue(userinvitation.isValid());
        UserInvitation userinvitationInvalid = new UserInvitation("52*皆2?\u0015U25B⠢5\u0017궞\u000b5#\b2훹2\u00045HD�?�5O2[25\u0002222`FQﳎED鋂2%㓗5钀522\u0015뢬!H\u0016225茡5㮔2",
                                                                  new Date(1559148829158L), null,
                                                                  new Date(1559148834226L),
                                                                  "52*皆2?\u0015U25B⠢5\u0017궞\u000b5#\b2훹2\u00045HD�?�5O2[25\u0002222`FQﳎED鋂2%㓗5钀522\u0015뢬!H\u0016225茡5㮔2",
                                                                  null, new Date(1559148833749L),
                                                                  "52*皆2?\u0015U25B⠢5\u0017궞\u000b5#\b2훹2\u00045HD�?�5O2[25\u0002222`FQﳎED鋂2%㓗5钀522\u0015뢬!H\u0016225茡5㮔2");
        assertFalse(userinvitationInvalid.isValid());
    }

    /**
     * Tests the equals method.
     */
    @SuppressWarnings("resource")
    @Test
    public void testEquals() {
        try {
            UserInvitation userinvitation1 = new UserInvitation("ae7a4e096c0cf61badbe341c63408ff3",
                                                                new Date(1559148829212L), "759d1.01c8e@491f7.fr",
                                                                new Date(1559148832811L),
                                                                "ae7a4e096c0cf61badbe341c63408ff3", null,
                                                                new Date(1559148826785L),
                                                                "ae7a4e096c0cf61badbe341c63408ff3");
            UserInvitation userinvitation2 = new UserInvitation("ae7a4e096c0cf61badbe341c63408ff3",
                                                                new Date(1559148829212L), "759d1.01c8e@491f7.fr",
                                                                new Date(1559148832811L),
                                                                "ae7a4e096c0cf61badbe341c63408ff3", null,
                                                                new Date(1559148826785L),
                                                                "ae7a4e096c0cf61badbe341c63408ff3");
            UserInvitation userinvitation3 = new UserInvitation("ae7a4e096c0cf61badbe341c63408ff3",
                                                                new Date(1559148828319L), "32732.9c962@bbcdf.fr",
                                                                new Date(1559148834028L),
                                                                "ae7a4e096c0cf61badbe341c63408ff3", null,
                                                                new Date(1559148825947L),
                                                                "ae7a4e096c0cf61badbe341c63408ff3");
            assertNotNull(userinvitation1);
            assertNotNull(userinvitation2);
            assertNotNull(userinvitation3);
            assertNotSame(userinvitation2, userinvitation1);
            assertNotSame(userinvitation3, userinvitation1);
            assertEquals(userinvitation2, userinvitation1);
            assertEquals(userinvitation2, userinvitation1);
            assertEquals(userinvitation1, userinvitation2);
            assertEquals(userinvitation1, userinvitation1);
            assertFalse(userinvitation1.equals(null));
            assertNotEquals(userinvitation3, userinvitation1);
        } catch (Exception exception) {
            fail(exception.getMessage());
        }
    }
}
