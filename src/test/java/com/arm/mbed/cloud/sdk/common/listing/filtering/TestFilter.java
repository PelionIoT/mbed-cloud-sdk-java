package com.arm.mbed.cloud.sdk.common.listing.filtering;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class TestFilter {

    @Test
    public void testIsValid() {
        Filter filter = new Filter("Test", null, "Value");
        assertTrue(filter.isValid());
        filter = new Filter("Test", FilterOperator.EQUAL, null);
        assertFalse(filter.isValid());
        filter = new Filter(null, FilterOperator.EQUAL, new Integer(3));
        assertFalse(filter.isValid());
    }

    @Test
    public void testEquals() {
        Filter filter1 = new Filter("Test", null, "Value");
        Filter filter2 = new Filter("Test", null, "Value");
        assertEquals(filter1, filter2);
        filter1 = new Filter("Test", FilterOperator.EQUAL, "Value");
        filter2 = new Filter("Test", FilterOperator.EQUAL, "Value");
        assertEquals(filter1, filter2);
        assertEquals(filter1.hashCode(), filter2.hashCode());
        filter1 = new Filter("Test", FilterOperator.GREATER_THAN, "Value");
        filter2 = new Filter("Test", FilterOperator.EQUAL, "Value");
        assertNotEquals(filter1, filter2);
        filter1 = new Filter("Test", FilterOperator.EQUAL, new Integer(3));
        filter2 = new Filter("Test", FilterOperator.EQUAL, "Value");
        assertNotEquals(filter1, filter2);
        filter1 = new Filter("Test", FilterOperator.EQUAL, new Integer(3));
        filter2 = new Filter("Test", FilterOperator.EQUAL, "3");
        assertNotEquals(filter1, filter2);
        filter1 = new Filter("Test", FilterOperator.EQUAL, "3 ");
        filter2 = new Filter("Test", FilterOperator.EQUAL, "3");
        assertNotEquals(filter1, filter2);
        filter1 = new Filter("test1", FilterOperator.EQUAL, "3 ");
        filter2 = new Filter("test2", FilterOperator.EQUAL, "3");
        assertNotEquals(filter1, filter2);
    }

    @Test
    public void testClone() {
        Filter filter1 = new Filter("Test", FilterOperator.EQUAL, "Value");
        Filter filter2 = filter1.clone();
        assertEquals(filter1, filter2);
        assertFalse(filter1 == filter2);
        assertEquals(filter1.hashCode(), filter2.hashCode());
        filter1 = new CustomFilter("Test", null, "Value");
        filter2 = filter1.clone();
        assertEquals(filter1, filter2);
        assertFalse(filter1 == filter2);
        assertEquals(filter1.hashCode(), filter2.hashCode());
    }

    @Test
    public void testPrefix() {
        Filter filter = new Filter("Test", null, "Value");
        assertNull(filter.getPrefix());
        assertFalse(filter.hasPrefix());
        filter = new CustomFilter("Test", null, "Value");
        assertNotNull(filter.getPrefix());
        assertTrue(filter.hasPrefix());
    }

}
