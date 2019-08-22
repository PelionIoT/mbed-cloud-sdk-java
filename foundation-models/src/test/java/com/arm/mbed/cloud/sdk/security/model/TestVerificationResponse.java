// This file was generated by the Pelion SDK foundation code generator.
// This is an autogenerated unit test class. Do not modify its content as modifications will be lost at next code generation.
package com.arm.mbed.cloud.sdk.security.model;

import static org.junit.Assert.*;

import org.junit.Test;

/**
 * Unit tests for Model VerificationResponse.
 */
@SuppressWarnings("PMD.AvoidDuplicateLiterals")
public class TestVerificationResponse {
    /**
     * Tests the clone method.
     */
    @SuppressWarnings("resource")
    @Test
    public void testClone() {
        try {
            VerificationResponse verificationresponse1 = new VerificationResponse("63fd28b8-4c1a-4da4-9316-65d4fe79ced8",
                                                                                  true);
            VerificationResponse verificationresponse2 = verificationresponse1.clone();
            assertNotNull(verificationresponse1);
            assertNotNull(verificationresponse2);
            assertNotSame(verificationresponse2, verificationresponse1);
            assertEquals(verificationresponse2, verificationresponse1);
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
            VerificationResponse verificationresponse1 = new VerificationResponse("e8cc7d59-576c-43ee-a0ed-e4c9c671a5b8",
                                                                                  true);
            VerificationResponse verificationresponse2 = new VerificationResponse("e8cc7d59-576c-43ee-a0ed-e4c9c671a5b8",
                                                                                  true);
            assertNotNull(verificationresponse1);
            assertNotNull(verificationresponse2);
            assertNotSame(verificationresponse2, verificationresponse1);
            assertEquals(verificationresponse2, verificationresponse1);
            assertEquals(verificationresponse2.hashCode(), verificationresponse1.hashCode());
            int hashCode = verificationresponse1.hashCode();
            for (int i = 0; i < 5; i++) {
                assertEquals(hashCode, verificationresponse1.hashCode());
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
        VerificationResponse verificationresponse = new VerificationResponse("81513795-f907-4588-abcb-42acfc9da6cf",
                                                                             false);
        assertTrue(verificationresponse.isValid());
    }

    /**
     * Tests the equals method.
     */
    @SuppressWarnings("resource")
    @Test
    public void testEquals() {
        try {
            VerificationResponse verificationresponse1 = new VerificationResponse("ae39c61b-9191-4961-8d48-3244d0225122",
                                                                                  false);
            VerificationResponse verificationresponse2 = new VerificationResponse("ae39c61b-9191-4961-8d48-3244d0225122",
                                                                                  false);
            VerificationResponse verificationresponse3 = new VerificationResponse("1f99d0b2-1317-4b4b-853c-0e1baa51e41a",
                                                                                  false);
            assertNotNull(verificationresponse1);
            assertNotNull(verificationresponse2);
            assertNotNull(verificationresponse3);
            assertNotSame(verificationresponse2, verificationresponse1);
            assertNotSame(verificationresponse3, verificationresponse1);
            assertEquals(verificationresponse2, verificationresponse1);
            assertEquals(verificationresponse2, verificationresponse1);
            assertEquals(verificationresponse1, verificationresponse2);
            assertEquals(verificationresponse1, verificationresponse1);
            assertFalse(verificationresponse1.equals(null));
            assertNotEquals(verificationresponse3, verificationresponse1);
        } catch (Exception exception) {
            fail(exception.getMessage());
        }
    }
}
