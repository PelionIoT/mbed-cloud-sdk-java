// This file was generated by the Pelion SDK foundation code generator.
// This is an autogenerated unit test class. Do not modify its content as modifications will be lost at next code generation.
package com.arm.mbed.cloud.sdk.accounts.model;

import static org.junit.Assert.*;

import org.junit.Test;

/**
 * Unit tests for Model Policy.
 */
@SuppressWarnings("PMD.AvoidDuplicateLiterals")
public class TestPolicy {
    /**
     * Tests the clone method.
     */
    @SuppressWarnings("resource")
    @Test
    public void testClone() {
        try {
            Policy policy1 = new Policy("08e11742-2918-4368-9914-e45ab77d0730", false,
                                        "fd074df7-af59-4874-986e-cb51a74c8bf5", false,
                                        "3a158b6a-e2d0-4f22-a803-eab3358c8f79");
            Policy policy2 = policy1.clone();
            assertNotNull(policy1);
            assertNotNull(policy2);
            assertNotSame(policy2, policy1);
            assertEquals(policy2, policy1);
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
            Policy policy1 = new Policy("c1140726-18b7-4e04-93c5-8b8e968fee00", true,
                                        "085e8f85-e637-4628-9ef4-913ce13895ef", false,
                                        "0b4c6e77-bb09-4fad-a162-3034d0b41cd0");
            Policy policy2 = new Policy("c1140726-18b7-4e04-93c5-8b8e968fee00", true,
                                        "085e8f85-e637-4628-9ef4-913ce13895ef", false,
                                        "0b4c6e77-bb09-4fad-a162-3034d0b41cd0");
            assertNotNull(policy1);
            assertNotNull(policy2);
            assertNotSame(policy2, policy1);
            assertEquals(policy2, policy1);
            assertEquals(policy2.hashCode(), policy1.hashCode());
            int hashCode = policy1.hashCode();
            for (int i = 0; i < 5; i++) {
                assertEquals(hashCode, policy1.hashCode());
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
        Policy policy = new Policy("f78b7b19-895e-4d49-89bf-8d7f7662403f", true, "ccb1d287-b03f-48e0-b301-8b27ef49be3f",
                                   false, "50c12c54-9808-49cc-a391-22b19d94897a");
        assertTrue(policy.isValid());
    }

    /**
     * Tests the equals method.
     */
    @SuppressWarnings("resource")
    @Test
    public void testEquals() {
        try {
            Policy policy1 = new Policy("8e2b5d8e-2c3a-4092-911e-299658d55d79", true,
                                        "253466cf-bd82-4266-a788-f39b2ba2a92f", false,
                                        "6a644d1d-ea98-4f02-8acf-7bb959a5f1fd");
            Policy policy2 = new Policy("8e2b5d8e-2c3a-4092-911e-299658d55d79", true,
                                        "253466cf-bd82-4266-a788-f39b2ba2a92f", false,
                                        "6a644d1d-ea98-4f02-8acf-7bb959a5f1fd");
            Policy policy3 = new Policy("55218c8f-9647-4011-8d72-e79da29c681f", true,
                                        "496ea0e5-e010-482a-b6a9-b1de64557ba8", false,
                                        "a97fbccd-a558-44c6-bdda-6f55df2ca19d");
            assertNotNull(policy1);
            assertNotNull(policy2);
            assertNotNull(policy3);
            assertNotSame(policy2, policy1);
            assertNotSame(policy3, policy1);
            assertEquals(policy2, policy1);
            assertEquals(policy2, policy1);
            assertEquals(policy1, policy2);
            assertEquals(policy1, policy1);
            assertFalse(policy1.equals(null));
            assertNotEquals(policy3, policy1);
        } catch (Exception exception) {
            fail(exception.getMessage());
        }
    }
}
