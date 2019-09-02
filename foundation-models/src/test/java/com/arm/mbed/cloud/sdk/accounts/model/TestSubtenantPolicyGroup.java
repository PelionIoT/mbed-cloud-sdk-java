// This file was generated by the Pelion SDK foundation code generator.
// This is an autogenerated unit test class. Do not modify its content as modifications will be lost at next code generation.
package com.arm.mbed.cloud.sdk.accounts.model;

import static org.junit.Assert.*;

import java.util.Date;
import org.junit.Test;

/**
 * Unit tests for Model SubtenantPolicyGroup.
 */
@SuppressWarnings("PMD.AvoidDuplicateLiterals")
public class TestSubtenantPolicyGroup {
    /**
     * Tests the clone method.
     */
    @SuppressWarnings("resource")
    @Test
    public void testClone() {
        try {
            SubtenantPolicyGroup subtenantpolicygroup1 = new SubtenantPolicyGroup("5aac302d4dc51de8d52d8348d01b06c5",
                                                                                  -63, new Date(1567417604570L),
                                                                                  "5aac302d4dc51de8d52d8348d01b06c5",
                                                                                  "b9c3f5db-d05e-4ebe-b6cc-03c9ccab9769",
                                                                                  new Date(1567417605444L), -30);
            SubtenantPolicyGroup subtenantpolicygroup2 = subtenantpolicygroup1.clone();
            assertNotNull(subtenantpolicygroup1);
            assertNotNull(subtenantpolicygroup2);
            assertNotSame(subtenantpolicygroup2, subtenantpolicygroup1);
            assertEquals(subtenantpolicygroup2, subtenantpolicygroup1);
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
            SubtenantPolicyGroup subtenantpolicygroup1 = new SubtenantPolicyGroup("5aac302d4dc51de8d52d8348d01b06c5",
                                                                                  73, new Date(1567417603607L),
                                                                                  "5aac302d4dc51de8d52d8348d01b06c5",
                                                                                  "26c7702d-8037-4fa0-a828-d0071085a7fa",
                                                                                  new Date(1567417608830L), 36);
            SubtenantPolicyGroup subtenantpolicygroup2 = new SubtenantPolicyGroup("5aac302d4dc51de8d52d8348d01b06c5",
                                                                                  73, new Date(1567417603607L),
                                                                                  "5aac302d4dc51de8d52d8348d01b06c5",
                                                                                  "26c7702d-8037-4fa0-a828-d0071085a7fa",
                                                                                  new Date(1567417608830L), 36);
            assertNotNull(subtenantpolicygroup1);
            assertNotNull(subtenantpolicygroup2);
            assertNotSame(subtenantpolicygroup2, subtenantpolicygroup1);
            assertEquals(subtenantpolicygroup2, subtenantpolicygroup1);
            assertEquals(subtenantpolicygroup2.hashCode(), subtenantpolicygroup1.hashCode());
            int hashCode = subtenantpolicygroup1.hashCode();
            for (int i = 0; i < 5; i++) {
                assertEquals(hashCode, subtenantpolicygroup1.hashCode());
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
        SubtenantPolicyGroup subtenantpolicygroup = new SubtenantPolicyGroup("5aac302d4dc51de8d52d8348d01b06c5", 118,
                                                                             new Date(1567417600509L),
                                                                             "5aac302d4dc51de8d52d8348d01b06c5",
                                                                             "39e8c2be-5241-4546-8828-9e4588ef962d",
                                                                             new Date(1567417601303L), -92);
        assertTrue(subtenantpolicygroup.isValid());
        SubtenantPolicyGroup subtenantpolicygroupInvalid = new SubtenantPolicyGroup(null, 9, new Date(1567417609120L),
                                                                                    "@77_7\u0015�?�\u00037\u0002A⚻7\u000e_Z7LT7-;\u000377!<\u0004+Fﭸ7?\u000f_9B\u001b拨\u0011\u0014\u0014ᬾV\b7]>:7㚧졎\f\u0001\u0011`R)7滹\u0019",
                                                                                    "15f90020-7ec5-4c76-9dfb-9ca2846f21041019bc75-d378-4eeb-91d3-0fe349d47a436ffec9c2-bc02-4e44-8f1f-b58d5f927928",
                                                                                    new Date(1567417604802L), -60);
        assertFalse(subtenantpolicygroupInvalid.isValid());
    }

    /**
     * Tests the equals method.
     */
    @SuppressWarnings("resource")
    @Test
    public void testEquals() {
        try {
            SubtenantPolicyGroup subtenantpolicygroup1 = new SubtenantPolicyGroup("5aac302d4dc51de8d52d8348d01b06c5",
                                                                                  32, new Date(1567417602628L),
                                                                                  "5aac302d4dc51de8d52d8348d01b06c5",
                                                                                  "372bf7a3-eb1d-47e7-9b4f-4dfe9987caa2",
                                                                                  new Date(1567417609483L), -54);
            SubtenantPolicyGroup subtenantpolicygroup2 = new SubtenantPolicyGroup("5aac302d4dc51de8d52d8348d01b06c5",
                                                                                  32, new Date(1567417602628L),
                                                                                  "5aac302d4dc51de8d52d8348d01b06c5",
                                                                                  "372bf7a3-eb1d-47e7-9b4f-4dfe9987caa2",
                                                                                  new Date(1567417609483L), -54);
            SubtenantPolicyGroup subtenantpolicygroup3 = new SubtenantPolicyGroup("5aac302d4dc51de8d52d8348d01b06c5",
                                                                                  111, new Date(1567417609795L),
                                                                                  "5aac302d4dc51de8d52d8348d01b06c5",
                                                                                  "6a8f93ca-6ba3-4350-908d-39dc19e54832",
                                                                                  new Date(1567417607561L), 65);
            assertNotNull(subtenantpolicygroup1);
            assertNotNull(subtenantpolicygroup2);
            assertNotNull(subtenantpolicygroup3);
            assertNotSame(subtenantpolicygroup2, subtenantpolicygroup1);
            assertNotSame(subtenantpolicygroup3, subtenantpolicygroup1);
            assertEquals(subtenantpolicygroup2, subtenantpolicygroup1);
            assertEquals(subtenantpolicygroup2, subtenantpolicygroup1);
            assertEquals(subtenantpolicygroup1, subtenantpolicygroup2);
            assertEquals(subtenantpolicygroup1, subtenantpolicygroup1);
            assertFalse(subtenantpolicygroup1.equals(null));
            assertNotEquals(subtenantpolicygroup3, subtenantpolicygroup1);
        } catch (Exception exception) {
            fail(exception.getMessage());
        }
    }
}
