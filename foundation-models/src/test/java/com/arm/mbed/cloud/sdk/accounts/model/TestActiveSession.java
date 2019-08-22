// This file was generated by the Pelion SDK foundation code generator.
// This is an autogenerated unit test class. Do not modify its content as modifications will be lost at next code generation.
package com.arm.mbed.cloud.sdk.accounts.model;

import static org.junit.Assert.*;

import java.util.Date;
import org.junit.Test;

/**
 * Unit tests for Model ActiveSession.
 */
@SuppressWarnings("PMD.AvoidDuplicateLiterals")
public class TestActiveSession {
    /**
     * Tests the clone method.
     */
    @SuppressWarnings("resource")
    @Test
    public void testClone() {
        try {
            ActiveSession activesession1 = new ActiveSession("7eac9c4e9c53774dafadb1ee4efb11c1",
                                                             "7f2fc773-97fe-47dc-b912-326e5b26900a",
                                                             new Date(1566477456296L),
                                                             "6067a064-af30-4123-9f8c-aaae7b2f868e",
                                                             "153147ec-8267-439b-b0d5-4c0aa3c7da28");
            ActiveSession activesession2 = activesession1.clone();
            assertNotNull(activesession1);
            assertNotNull(activesession2);
            assertNotSame(activesession2, activesession1);
            assertEquals(activesession2, activesession1);
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
            ActiveSession activesession1 = new ActiveSession("7eac9c4e9c53774dafadb1ee4efb11c1",
                                                             "dbd0ce86-3197-45dc-997f-743f2f7555e4",
                                                             new Date(1566477455586L),
                                                             "1a89b8e6-10c4-46c8-ad5b-f3d6ca6527f8",
                                                             "5055c38d-014d-44bf-aa25-65b1353dfa81");
            ActiveSession activesession2 = new ActiveSession("7eac9c4e9c53774dafadb1ee4efb11c1",
                                                             "dbd0ce86-3197-45dc-997f-743f2f7555e4",
                                                             new Date(1566477455586L),
                                                             "1a89b8e6-10c4-46c8-ad5b-f3d6ca6527f8",
                                                             "5055c38d-014d-44bf-aa25-65b1353dfa81");
            assertNotNull(activesession1);
            assertNotNull(activesession2);
            assertNotSame(activesession2, activesession1);
            assertEquals(activesession2, activesession1);
            assertEquals(activesession2.hashCode(), activesession1.hashCode());
            int hashCode = activesession1.hashCode();
            for (int i = 0; i < 5; i++) {
                assertEquals(hashCode, activesession1.hashCode());
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
        ActiveSession activesession = new ActiveSession("7eac9c4e9c53774dafadb1ee4efb11c1",
                                                        "5e1a8cbc-ebde-4b85-a03f-764725bae4cf",
                                                        new Date(1566477461378L),
                                                        "262ff710-abd6-43e4-89cd-49baa666e958",
                                                        "1b76590a-eb97-481c-ac22-43e7173eed90");
        assertTrue(activesession.isValid());
    }

    /**
     * Tests the equals method.
     */
    @SuppressWarnings("resource")
    @Test
    public void testEquals() {
        try {
            ActiveSession activesession1 = new ActiveSession("7eac9c4e9c53774dafadb1ee4efb11c1",
                                                             "f3adeb80-a502-4614-a97a-8096cab360cc",
                                                             new Date(1566477457874L),
                                                             "30de5519-eb1b-4ae4-bfd0-08d55792ba49",
                                                             "81e8f3ad-1151-4d99-87e1-4e802c9a7987");
            ActiveSession activesession2 = new ActiveSession("7eac9c4e9c53774dafadb1ee4efb11c1",
                                                             "f3adeb80-a502-4614-a97a-8096cab360cc",
                                                             new Date(1566477457874L),
                                                             "30de5519-eb1b-4ae4-bfd0-08d55792ba49",
                                                             "81e8f3ad-1151-4d99-87e1-4e802c9a7987");
            ActiveSession activesession3 = new ActiveSession("7eac9c4e9c53774dafadb1ee4efb11c1",
                                                             "e1d4afff-8a00-4e91-8607-5c484220c5d5",
                                                             new Date(1566477453802L),
                                                             "8543c4b0-1fa9-44ce-a190-57f799ccda53",
                                                             "c2be0b66-dfc7-4ca0-82c7-eda74ef68917");
            assertNotNull(activesession1);
            assertNotNull(activesession2);
            assertNotNull(activesession3);
            assertNotSame(activesession2, activesession1);
            assertNotSame(activesession3, activesession1);
            assertEquals(activesession2, activesession1);
            assertEquals(activesession2, activesession1);
            assertEquals(activesession1, activesession2);
            assertEquals(activesession1, activesession1);
            assertFalse(activesession1.equals(null));
            assertNotEquals(activesession3, activesession1);
        } catch (Exception exception) {
            fail(exception.getMessage());
        }
    }
}
