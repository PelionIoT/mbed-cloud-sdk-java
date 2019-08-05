// This file was generated by the Pelion SDK foundation code generator.
// This is an autogenerated unit test class. Do not modify its content as modifications will be lost at next code generation.
package com.arm.mbed.cloud.sdk.security.model;

import static org.junit.Assert.*;

import java.util.Date;
import org.junit.Test;

/**
 * Unit tests for Model ServerCredentials.
 */
@SuppressWarnings("PMD.AvoidDuplicateLiterals")
public class TestServerCredentials {
    /**
     * Tests the clone method.
     */
    @SuppressWarnings("resource")
    @Test
    public void testClone() {
        try {
            ServerCredentials servercredentials1 = new ServerCredentials(new Date(1565006439149L),
                                                                         "a3691297-5b23-4285-a8be-27b276fa5540",
                                                                         "c6cccad3-6da2-4e18-b491-f550ed717df2",
                                                                         "cc41e824-78a9-498c-b989-fc9cbe0d4e06");
            ServerCredentials servercredentials2 = servercredentials1.clone();
            assertNotNull(servercredentials1);
            assertNotNull(servercredentials2);
            assertNotSame(servercredentials2, servercredentials1);
            assertEquals(servercredentials2, servercredentials1);
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
            ServerCredentials servercredentials1 = new ServerCredentials(new Date(1565006438256L),
                                                                         "61a4821f-ce47-460f-afaf-90f95d715f8c",
                                                                         "05460ed6-ddde-42f1-af39-3890e3921159",
                                                                         "d389fc0a-9ec6-45d6-ba1d-9db5cb824243");
            ServerCredentials servercredentials2 = new ServerCredentials(new Date(1565006438256L),
                                                                         "61a4821f-ce47-460f-afaf-90f95d715f8c",
                                                                         "05460ed6-ddde-42f1-af39-3890e3921159",
                                                                         "d389fc0a-9ec6-45d6-ba1d-9db5cb824243");
            assertNotNull(servercredentials1);
            assertNotNull(servercredentials2);
            assertNotSame(servercredentials2, servercredentials1);
            assertEquals(servercredentials2, servercredentials1);
            assertEquals(servercredentials2.hashCode(), servercredentials1.hashCode());
            int hashCode = servercredentials1.hashCode();
            for (int i = 0; i < 5; i++) {
                assertEquals(hashCode, servercredentials1.hashCode());
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
        ServerCredentials servercredentials = new ServerCredentials(new Date(1565006436077L),
                                                                    "4fc38639-1d8e-45b4-a3ba-7760f55c3914",
                                                                    "3488174b-6cb0-40be-8a34-4674a9595d4c",
                                                                    "baf7ee43-068a-4be3-8c2a-5861732bf4aa");
        assertTrue(servercredentials.isValid());
    }

    /**
     * Tests the equals method.
     */
    @SuppressWarnings("resource")
    @Test
    public void testEquals() {
        try {
            ServerCredentials servercredentials1 = new ServerCredentials(new Date(1565006439635L),
                                                                         "89a66a87-b6f3-4434-9f24-566b7947965d",
                                                                         "3f71beba-b981-4d95-b10d-e3998b38d8ae",
                                                                         "ee9def6b-b8b3-47ca-8274-27a74a30aa83");
            ServerCredentials servercredentials2 = new ServerCredentials(new Date(1565006439635L),
                                                                         "89a66a87-b6f3-4434-9f24-566b7947965d",
                                                                         "3f71beba-b981-4d95-b10d-e3998b38d8ae",
                                                                         "ee9def6b-b8b3-47ca-8274-27a74a30aa83");
            ServerCredentials servercredentials3 = new ServerCredentials(new Date(1565006435857L),
                                                                         "e47dda90-249c-4b40-bdb3-39c056e90160",
                                                                         "b732aa4c-6348-4246-a5cf-4ad1ef7e2d32",
                                                                         "423720d9-68c3-4e7c-bdd9-4b969597c473");
            assertNotNull(servercredentials1);
            assertNotNull(servercredentials2);
            assertNotNull(servercredentials3);
            assertNotSame(servercredentials2, servercredentials1);
            assertNotSame(servercredentials3, servercredentials1);
            assertEquals(servercredentials2, servercredentials1);
            assertEquals(servercredentials2, servercredentials1);
            assertEquals(servercredentials1, servercredentials2);
            assertEquals(servercredentials1, servercredentials1);
            assertFalse(servercredentials1.equals(null));
            assertNotEquals(servercredentials3, servercredentials1);
        } catch (Exception exception) {
            fail(exception.getMessage());
        }
    }
}
