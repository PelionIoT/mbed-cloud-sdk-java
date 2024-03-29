// This file was generated by the Pelion SDK foundation code generator.
// This is an autogenerated unit test class. Do not modify its content as modifications will be lost at next code generation.
package com.arm.mbed.cloud.sdk.accounts.model;

import static org.junit.Assert.*;

import com.arm.mbed.cloud.sdk.common.Order;
import org.junit.Test;

/**
 * Unit tests for Model SubtenantIdentityProviderListOptions.
 */
@SuppressWarnings("PMD.AvoidDuplicateLiterals")
public class TestSubtenantIdentityProviderListOptions {
    /**
     * Tests the clone method.
     */
    @SuppressWarnings("resource")
    @Test
    public void testClone() {
        try {
            SubtenantIdentityProviderListOptions subtenantidentityproviderlistoptions1 = new SubtenantIdentityProviderListOptions(Integer.valueOf(115),
                                                                                                                                  Long.valueOf(-105),
                                                                                                                                  Order.getDefault(),
                                                                                                                                  "b17f717b-ea07-4b1f-8f6b-5b0d4d727a72",
                                                                                                                                  null,
                                                                                                                                  null);
            SubtenantIdentityProviderListOptions subtenantidentityproviderlistoptions2 = subtenantidentityproviderlistoptions1.clone();
            assertNotNull(subtenantidentityproviderlistoptions1);
            assertNotNull(subtenantidentityproviderlistoptions2);
            assertNotSame(subtenantidentityproviderlistoptions2, subtenantidentityproviderlistoptions1);
            assertEquals(subtenantidentityproviderlistoptions2, subtenantidentityproviderlistoptions1);
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
            SubtenantIdentityProviderListOptions subtenantidentityproviderlistoptions1 = new SubtenantIdentityProviderListOptions(Integer.valueOf(35),
                                                                                                                                  Long.valueOf(-90),
                                                                                                                                  Order.getDefault(),
                                                                                                                                  "e8d0da9c-c88b-45fe-89e9-6509741aef23",
                                                                                                                                  null,
                                                                                                                                  null);
            SubtenantIdentityProviderListOptions subtenantidentityproviderlistoptions2 = new SubtenantIdentityProviderListOptions(Integer.valueOf(35),
                                                                                                                                  Long.valueOf(-90),
                                                                                                                                  Order.getDefault(),
                                                                                                                                  "e8d0da9c-c88b-45fe-89e9-6509741aef23",
                                                                                                                                  null,
                                                                                                                                  null);
            assertNotNull(subtenantidentityproviderlistoptions1);
            assertNotNull(subtenantidentityproviderlistoptions2);
            assertNotSame(subtenantidentityproviderlistoptions2, subtenantidentityproviderlistoptions1);
            assertEquals(subtenantidentityproviderlistoptions2, subtenantidentityproviderlistoptions1);
            assertEquals(subtenantidentityproviderlistoptions2.hashCode(),
                         subtenantidentityproviderlistoptions1.hashCode());
            int hashCode = subtenantidentityproviderlistoptions1.hashCode();
            for (int i = 0; i < 5; i++) {
                assertEquals(hashCode, subtenantidentityproviderlistoptions1.hashCode());
            }
        } catch (Exception exception) {
            fail(exception.getMessage());
        }
    }

    /**
     * Tests the equals method.
     */
    @SuppressWarnings("resource")
    @Test
    public void testEquals() {
        try {
            SubtenantIdentityProviderListOptions subtenantidentityproviderlistoptions1 = new SubtenantIdentityProviderListOptions(Integer.valueOf(-107),
                                                                                                                                  Long.valueOf(-106),
                                                                                                                                  Order.getDefault(),
                                                                                                                                  "9c749b49-2a71-49ee-b068-ee815fec79e8",
                                                                                                                                  null,
                                                                                                                                  null);
            SubtenantIdentityProviderListOptions subtenantidentityproviderlistoptions2 = new SubtenantIdentityProviderListOptions(Integer.valueOf(-107),
                                                                                                                                  Long.valueOf(-106),
                                                                                                                                  Order.getDefault(),
                                                                                                                                  "9c749b49-2a71-49ee-b068-ee815fec79e8",
                                                                                                                                  null,
                                                                                                                                  null);
            SubtenantIdentityProviderListOptions subtenantidentityproviderlistoptions3 = new SubtenantIdentityProviderListOptions(Integer.valueOf(15),
                                                                                                                                  Long.valueOf(-102),
                                                                                                                                  Order.getDefault(),
                                                                                                                                  "f8eb9baa-588d-4be4-be98-06a336c36a73",
                                                                                                                                  null,
                                                                                                                                  null);
            assertNotNull(subtenantidentityproviderlistoptions1);
            assertNotNull(subtenantidentityproviderlistoptions2);
            assertNotNull(subtenantidentityproviderlistoptions3);
            assertNotSame(subtenantidentityproviderlistoptions2, subtenantidentityproviderlistoptions1);
            assertNotSame(subtenantidentityproviderlistoptions3, subtenantidentityproviderlistoptions1);
            assertEquals(subtenantidentityproviderlistoptions2, subtenantidentityproviderlistoptions1);
            assertEquals(subtenantidentityproviderlistoptions2, subtenantidentityproviderlistoptions1);
            assertEquals(subtenantidentityproviderlistoptions1, subtenantidentityproviderlistoptions2);
            assertEquals(subtenantidentityproviderlistoptions1, subtenantidentityproviderlistoptions1);
            assertFalse(subtenantidentityproviderlistoptions1.equals(null));
            assertNotEquals(subtenantidentityproviderlistoptions3, subtenantidentityproviderlistoptions1);
        } catch (Exception exception) {
            fail(exception.getMessage());
        }
    }
}
