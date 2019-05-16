package com.arm.mbed.cloud.sdk.common.listing.filtering;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;

import org.junit.Test;

import nl.jqno.equalsverifier.EqualsVerifier;
import nl.jqno.equalsverifier.Warning;

public class TestFilters {

    @Test
    public void testClone() {
        Filter filter1 = new Filter("field1", null, "Value1");
        Filter filter11 = new Filter("field1", FilterOperator.NOT_EQUAL, "Value2");
        Filter filter2 = new Filter("field2", null, "Value1");
        Filters filters1 = new Filters();
        filters1.add(filter1);
        filters1.add(filter11);
        filters1.add(filter2);
        Filters filters2 = filters1.clone();
        assertEquals(filters1, filters2);
        assertFalse(filters1 == filters2);
    }

    @Test
    public void testEqualsObject() {
        Filter filter1 = new Filter("field1", null, "Value1");
        Filter filter11 = new Filter("field1", FilterOperator.NOT_EQUAL, "Value2");
        Filter filter2 = new Filter("field2", null, "Value1");
        Filters filters1 = new Filters();
        filters1.add(filter1);
        filters1.add(filter11);
        filters1.add(filter2);
        Filters filters2 = new Filters();
        filters2.add(filter1.clone());
        filters2.add(filter11.clone());
        filters2.add(filter2.clone());
        Filters filters3 = new Filters();
        filters3.add(filter1.clone());
        filters3.add(filter11.clone());
        assertEquals(filters1, filters2);
        assertNotEquals(filters1, filters3);
    }

    @Test
    public void equalsContract() {
        EqualsVerifier.forClass(Filters.class).suppress(Warning.TRANSIENT_FIELDS).verify();
    }

}
