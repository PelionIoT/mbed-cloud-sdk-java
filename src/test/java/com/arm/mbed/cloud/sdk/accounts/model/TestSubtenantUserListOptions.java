// This file was generated by the Pelion SDK foundation code generator.
// This is an autogenerated unit test class. Do not modify its content as modifications will be lost at next code generation.
package com.arm.mbed.cloud.sdk.accounts.model;

import static org.junit.Assert.*;

import com.arm.mbed.cloud.sdk.common.Order;
import org.junit.Test;

/**
 * Unit tests for Model SubtenantUserListOptions.
 */
public class TestSubtenantUserListOptions {
    /**
     * Tests the clone method.
     */
    @Test
    public void testClone() {
        try {
            SubtenantUserListOptions subtenantuserlistoptions1 = new SubtenantUserListOptions(Integer.valueOf(-124),
                                                                                              Long.valueOf(-13),
                                                                                              Order.getDefault(),
                                                                                              "68422aed-3d88-4e51-8ffc-37ea0ad3d5b8",
                                                                                              null, null);
            SubtenantUserListOptions subtenantuserlistoptions2 = subtenantuserlistoptions1.clone();
            assertNotNull(subtenantuserlistoptions1);
            assertNotNull(subtenantuserlistoptions2);
            assertNotSame(subtenantuserlistoptions2, subtenantuserlistoptions1);
            assertEquals(subtenantuserlistoptions2, subtenantuserlistoptions1);
        } catch (Exception exception) {
            fail(exception.getMessage());
        }
    }

    /**
     * Tests the hashCode method.
     */
    @Test
    public void testHashCode() {
        try {
            SubtenantUserListOptions subtenantuserlistoptions1 = new SubtenantUserListOptions(Integer.valueOf(-124),
                                                                                              Long.valueOf(-44),
                                                                                              Order.getDefault(),
                                                                                              "3029b93a-c03d-4f0a-8626-90d0233de980",
                                                                                              null, null);
            SubtenantUserListOptions subtenantuserlistoptions2 = new SubtenantUserListOptions(Integer.valueOf(-124),
                                                                                              Long.valueOf(-44),
                                                                                              Order.getDefault(),
                                                                                              "3029b93a-c03d-4f0a-8626-90d0233de980",
                                                                                              null, null);
            assertNotNull(subtenantuserlistoptions1);
            assertNotNull(subtenantuserlistoptions2);
            assertNotSame(subtenantuserlistoptions2, subtenantuserlistoptions1);
            assertEquals(subtenantuserlistoptions2, subtenantuserlistoptions1);
            assertEquals(subtenantuserlistoptions2.hashCode(), subtenantuserlistoptions1.hashCode());
            int hashCode = subtenantuserlistoptions1.hashCode();
            for (int i = 0; i < 5; i++) {
                assertEquals(hashCode, subtenantuserlistoptions1.hashCode());
            }
        } catch (Exception exception) {
            fail(exception.getMessage());
        }
    }

    /**
     * Tests the equals method.
     */
    @Test
    public void testEquals() {
        try {
            SubtenantUserListOptions subtenantuserlistoptions1 = new SubtenantUserListOptions(Integer.valueOf(-71),
                                                                                              Long.valueOf(-70),
                                                                                              Order.getDefault(),
                                                                                              "44651ccb-912a-42e0-9c46-532c46eefed6",
                                                                                              null, null);
            SubtenantUserListOptions subtenantuserlistoptions2 = new SubtenantUserListOptions(Integer.valueOf(-71),
                                                                                              Long.valueOf(-70),
                                                                                              Order.getDefault(),
                                                                                              "44651ccb-912a-42e0-9c46-532c46eefed6",
                                                                                              null, null);
            SubtenantUserListOptions subtenantuserlistoptions3 = new SubtenantUserListOptions(Integer.valueOf(94),
                                                                                              Long.valueOf(-53),
                                                                                              Order.getDefault(),
                                                                                              "129576fb-50b2-4ce6-9fab-e029099e8450",
                                                                                              null, null);
            assertNotNull(subtenantuserlistoptions1);
            assertNotNull(subtenantuserlistoptions2);
            assertNotNull(subtenantuserlistoptions3);
            assertNotSame(subtenantuserlistoptions2, subtenantuserlistoptions1);
            assertNotSame(subtenantuserlistoptions3, subtenantuserlistoptions1);
            assertEquals(subtenantuserlistoptions2, subtenantuserlistoptions1);
            assertEquals(subtenantuserlistoptions2, subtenantuserlistoptions1);
            assertEquals(subtenantuserlistoptions1, subtenantuserlistoptions2);
            assertEquals(subtenantuserlistoptions1, subtenantuserlistoptions1);
            assertFalse(subtenantuserlistoptions1.equals(null));
            assertNotEquals(subtenantuserlistoptions3, subtenantuserlistoptions1);
        } catch (Exception exception) {
            fail(exception.getMessage());
        }
    }
}
