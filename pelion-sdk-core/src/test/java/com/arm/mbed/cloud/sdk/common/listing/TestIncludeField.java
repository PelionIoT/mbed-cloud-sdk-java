package com.arm.mbed.cloud.sdk.common.listing;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;

import org.junit.Test;

import nl.jqno.equalsverifier.EqualsVerifier;
import nl.jqno.equalsverifier.Warning;

public class TestIncludeField {

    @Test
    public void testEncode() {
        IncludeField include = new IncludeField("FieldNumberOne");
        assertEquals("field_number_one", include.encode());
    }

    @Test
    public void testEqualsObject() {
        IncludeField include1 = new IncludeField("FieldNumberOne");
        IncludeField include2 = new IncludeField("FieldNumberOne");
        IncludeField include3 = new IncludeField("FieldNumberTwo");
        assertEquals(include1, include2);
        assertEquals(include1.hashCode(), include2.hashCode());
        assertFalse(include1 == include2);
        assertNotEquals(include3, include2);
        assertNotEquals(include3, include1);
        assertNotEquals(include3.hashCode(), include1.hashCode());
        assertFalse(include3 == include2);
    }

    @Test
    public void equalsContract() {
        EqualsVerifier.forClass(IncludeField.class).suppress(Warning.STRICT_INHERITANCE).verify();
    }

    @Test
    public void testClone() {
        IncludeField include1 = new IncludeField("FieldNumberOne");
        IncludeField include2 = include1.clone();
        assertEquals(include1, include2);
        assertFalse(include1 == include2);
        assertEquals(include1.hashCode(), include2.hashCode());
    }

}
