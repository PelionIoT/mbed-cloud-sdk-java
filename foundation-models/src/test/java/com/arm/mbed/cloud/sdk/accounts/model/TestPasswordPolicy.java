// This file was generated by the Pelion SDK foundation code generator.
// This is an autogenerated unit test class. Do not modify its content as modifications will be lost at next code generation.
package com.arm.mbed.cloud.sdk.accounts.model;

import static org.junit.Assert.*;

import org.junit.Test;

/**
 * Unit tests for Model PasswordPolicy.
 */
public class TestPasswordPolicy {
    /**
     * Tests the clone method.
     */
    @Test
    public void testClone() {
        PasswordPolicy passwordpolicy1 = new PasswordPolicy("19ad1428-ccb3-49cd-9eca-7c259dcae5a7");
        PasswordPolicy passwordpolicy2 = passwordpolicy1.clone();
        assertNotNull(passwordpolicy1);
        assertNotNull(passwordpolicy2);
        assertNotSame(passwordpolicy2, passwordpolicy1);
        assertEquals(passwordpolicy2, passwordpolicy1);
    }

    /**
     * Tests the isValid method.
     */
    @Test
    public void testIsvalid() {
        PasswordPolicy passwordpolicy = new PasswordPolicy("1e171093-955c-427a-86a4-12661ae38f73");
        assertTrue(passwordpolicy.isValid());
    }

    /**
     * Tests the hashCode method.
     */
    @Test
    public void testHashcode() {
        PasswordPolicy passwordpolicy1 = new PasswordPolicy("556f3dfc-a009-4b71-b7c1-175269e17fe0");
        PasswordPolicy passwordpolicy2 = new PasswordPolicy("556f3dfc-a009-4b71-b7c1-175269e17fe0");
        assertNotNull(passwordpolicy1);
        assertNotNull(passwordpolicy2);
        assertNotSame(passwordpolicy2, passwordpolicy1);
        assertEquals(passwordpolicy2, passwordpolicy1);
        assertEquals(passwordpolicy2.hashCode(), passwordpolicy1.hashCode());
        int hashCode = passwordpolicy1.hashCode();
        for (int i = 0; i < 5; i++) {
            assertEquals(hashCode, passwordpolicy1.hashCode());
        }
    }

    /**
     * Tests the equals method.
     */
    @Test
    public void testEquals() {
        PasswordPolicy passwordpolicy1 = new PasswordPolicy("b8a98806-7c34-4c97-b297-6eb6842d7e1d");
        PasswordPolicy passwordpolicy2 = new PasswordPolicy("b8a98806-7c34-4c97-b297-6eb6842d7e1d");
        PasswordPolicy passwordpolicy3 = new PasswordPolicy("22ea97d5-51fb-4eb1-ac23-8fc9abb472e4");
        assertNotNull(passwordpolicy1);
        assertNotNull(passwordpolicy2);
        assertNotNull(passwordpolicy3);
        assertNotSame(passwordpolicy2, passwordpolicy1);
        assertNotSame(passwordpolicy3, passwordpolicy1);
        assertEquals(passwordpolicy2, passwordpolicy1);
        assertEquals(passwordpolicy2, passwordpolicy1);
        assertEquals(passwordpolicy1, passwordpolicy2);
        assertEquals(passwordpolicy1, passwordpolicy1);
        assertFalse(passwordpolicy1.equals(null));
        assertNotEquals(passwordpolicy3, passwordpolicy1);
    }
}
