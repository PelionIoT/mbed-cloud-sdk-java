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
            ServerCredentials servercredentials1 = new ServerCredentials(new Date(1561627143785L),
                                                                         "ef4b1f1d-7061-4d37-aca2-8ddeb382e482",
                                                                         "be2e3b1a-f87a-40d9-bbb8-98d702f2f297",
                                                                         "9397b1db-a5fb-46bc-b119-04f346531765");
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
            ServerCredentials servercredentials1 = new ServerCredentials(new Date(1561627146116L),
                                                                         "406a1dc2-e460-4009-8ff7-f255de7734f4",
                                                                         "4703876a-5927-40de-ad67-6cfabb8de5ff",
                                                                         "c68ae15d-8a40-4d65-9c7f-f51e7cc5da17");
            ServerCredentials servercredentials2 = new ServerCredentials(new Date(1561627146116L),
                                                                         "406a1dc2-e460-4009-8ff7-f255de7734f4",
                                                                         "4703876a-5927-40de-ad67-6cfabb8de5ff",
                                                                         "c68ae15d-8a40-4d65-9c7f-f51e7cc5da17");
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
        ServerCredentials servercredentials = new ServerCredentials(new Date(1561627143804L),
                                                                    "8797fb3d-4d1a-4a83-aebb-fb0308b6019e",
                                                                    "59d20827-ed97-4756-90bb-afb3c1ce55f7",
                                                                    "03fa601b-77f7-4ffc-8bdc-936cc85493fc");
        assertTrue(servercredentials.isValid());
    }

    /**
     * Tests the equals method.
     */
    @SuppressWarnings("resource")
    @Test
    public void testEquals() {
        try {
            ServerCredentials servercredentials1 = new ServerCredentials(new Date(1561627143924L),
                                                                         "c7e3d78a-13b0-4b22-b96e-0dcc2f65b4fd",
                                                                         "e3fbb550-20cf-4255-acb9-4e2a520a83c4",
                                                                         "dda6caea-8e50-43f6-ac60-6789cd50c7a0");
            ServerCredentials servercredentials2 = new ServerCredentials(new Date(1561627143924L),
                                                                         "c7e3d78a-13b0-4b22-b96e-0dcc2f65b4fd",
                                                                         "e3fbb550-20cf-4255-acb9-4e2a520a83c4",
                                                                         "dda6caea-8e50-43f6-ac60-6789cd50c7a0");
            ServerCredentials servercredentials3 = new ServerCredentials(new Date(1561627144975L),
                                                                         "dca7cf37-34a8-4f4c-9630-340c1df5b77d",
                                                                         "9249cc66-3b5a-43d5-8626-24693dadfa4f",
                                                                         "f0d7ef02-9028-45a5-85f9-17a8eefcc5b1");
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
