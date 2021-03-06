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
            ServerCredentials servercredentials1 = new ServerCredentials(new Date(1574704668706L),
                                                                         "d8400468-4458-4650-937e-3a37a9d71ad7",
                                                                         "ba83423b-405f-4dbf-9f4d-368da1d204e4",
                                                                         "b1eb4991-2051-4e59-b5eb-aa22f32b3028");
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
            ServerCredentials servercredentials1 = new ServerCredentials(new Date(1574704662442L),
                                                                         "f6686ef6-7a62-47c3-974e-02b26f5f722c",
                                                                         "3d65355c-f644-425e-af7c-b10dd9c1702c",
                                                                         "f465167a-a1c6-42cd-8c56-028b7fced6be");
            ServerCredentials servercredentials2 = new ServerCredentials(new Date(1574704662442L),
                                                                         "f6686ef6-7a62-47c3-974e-02b26f5f722c",
                                                                         "3d65355c-f644-425e-af7c-b10dd9c1702c",
                                                                         "f465167a-a1c6-42cd-8c56-028b7fced6be");
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
        ServerCredentials servercredentials = new ServerCredentials(new Date(1574704670366L),
                                                                    "4b756791-6471-4e79-afae-2cd72d97e9ca",
                                                                    "5ce9d898-d653-4d89-8c03-630d825186b4",
                                                                    "f5d7a875-8d2e-4ea6-845c-3731f091bbe8");
        assertTrue(servercredentials.isValid());
    }

    /**
     * Tests the equals method.
     */
    @SuppressWarnings("resource")
    @Test
    public void testEquals() {
        try {
            ServerCredentials servercredentials1 = new ServerCredentials(new Date(1574704665250L),
                                                                         "b116795d-9a9a-43d3-b51b-1b4447de6aea",
                                                                         "e8e85163-8320-4bc5-864e-21c5d87d3ebe",
                                                                         "ec07982a-3ea0-49f8-8a56-f24468accf48");
            ServerCredentials servercredentials2 = new ServerCredentials(new Date(1574704665250L),
                                                                         "b116795d-9a9a-43d3-b51b-1b4447de6aea",
                                                                         "e8e85163-8320-4bc5-864e-21c5d87d3ebe",
                                                                         "ec07982a-3ea0-49f8-8a56-f24468accf48");
            ServerCredentials servercredentials3 = new ServerCredentials(new Date(1574704667741L),
                                                                         "4359fad0-c68b-4eae-a2d5-ed3d98d936b9",
                                                                         "fa5379e8-200d-45ac-9055-95e178551fef",
                                                                         "a5cb74b9-63f5-4f51-a6de-dd9ab9086ec0");
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
