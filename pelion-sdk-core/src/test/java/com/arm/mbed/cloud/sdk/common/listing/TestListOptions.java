package com.arm.mbed.cloud.sdk.common.listing;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNotSame;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;

import com.arm.mbed.cloud.sdk.common.Order;
import com.arm.mbed.cloud.sdk.common.listing.filtering.Filter;
import com.arm.mbed.cloud.sdk.common.listing.filtering.FilterOperator;
import com.arm.mbed.cloud.sdk.common.listing.filtering.Filters;

import nl.jqno.equalsverifier.EqualsVerifier;
import nl.jqno.equalsverifier.Warning;

public class TestListOptions {

    @Test
    public void testEncodeInclude() {
        ListOptions options = new ListOptions();
        options.addInclude(null);
        assertEquals(null, options.encodeInclude());
        options.addInclude(new IncludeField("fieldOne"));
        options.addInclude(new IncludeField("fieldOne"));
        options.addInclude(new IncludeField("FieldTwo"));
        options.includeTotalCount();
        assertEquals("field_one,field_two,total_count", options.encodeInclude());
    }

    @Test
    public void testSetOptions() {
        ListOptions options = new ListOptions(new Integer(3), new Long(3), null, "after", null, null);
        options.setOrder(Order.DESC);
        options.includeTotalCount();
        options.addEqualFilter("afield", "some value");
        options.addCustomFilter("field", FilterOperator.NOT_EQUAL, "value");
        ListOptions options2 = new ListOptions(new Integer(4), new Long(4), null, "other", null, null);
        options2.setOrder(Order.ASC);
        options2.addFilter("test_3", FilterOperator.LESS_THAN, "value1");
        assertNotEquals(options2.getOrder(), Order.DESC);
        assertNotEquals(options, options2);
        assertNotEquals(options.hashCode(), options2.hashCode());
        options2.setOptions(options);
        assertEquals(options, options2);
        assertEquals(options.hashCode(), options2.hashCode());
        assertEquals(Order.DESC, options2.getOrder());
        assertEquals("some value", options2.fetchEqualFilterValue("afield"));
    }

    @Test
    public void testClone() {
        final ListOptions options = new ListOptions(new Integer(4), new Long(4), null, "after", null, null);
        options.setOrder(Order.DESC);
        options.includeTotalCount();
        options.addCustomFilter("field", FilterOperator.NOT_EQUAL, "value");
        options.addEqualFilter("afield", "some value");
        ListOptions clone = options.clone();
        assertNotSame(options, clone);
        assertEquals(options, clone);
        assertTrue(clone.hasMaxResults());
        assertEquals(options.hashCode(), clone.hashCode());
        assertEquals("some value", clone.fetchEqualFilterValue("afield"));
    }

    @Test
    public void testSetFiltersFromJson() {
        String jsonFilter = "{\"custom_attributes\":{\"foo\":{\"$neq\":\"bar\"}},\"test3\":{\"$lte\":\"value1\",\"$eq\":\"value2\"}}";
        ListOptions options = new ListOptions();
        assertNull(options.getFilter());
        options.setFiltersFromJson(jsonFilter);
        ListOptions clonedOptions = options.clone();
        assertNotNull(clonedOptions.getFilter());
        assertTrue(clonedOptions.hasFilters("test3"));
        assertTrue(clonedOptions.hasFilter("test3", FilterOperator.EQUAL));
        assertTrue(clonedOptions.hasFilter("test3", FilterOperator.LESS_THAN));
        List<Filter> filters = clonedOptions.fetchFilters("test3");
        assertNotNull(filters);
        assertFalse(filters.isEmpty());
        Filter filter = filters.get(1);
        assertEquals(FilterOperator.EQUAL, filter.getOperator());
        assertEquals("value2", filter.getValue());
    }

    @Test
    public void testRetrieveFilterAsJson() {
        ListOptions options = new ListOptions();
        options.addCustomFilter("foo", FilterOperator.NOT_EQUAL, "bar");
        options.addLessThanFilter("test_3", "value1");
        assertEquals("{\"custom_attributes\":{\"foo\":{\"$neq\":\"bar\"}},\"test_3\":{\"$lte\":\"value1\"}}",
                     options.retrieveFilterAsJson());
    }

    @SuppressWarnings("boxing")
    @Test
    public void testEncoding() {
        ListOptions options = new ListOptions();
        assertFalse(options.hasFilters());
        options.addEqualFilter("test", "value1");
        options.addNotEqualFilter("test", "value2");
        options.addLessThanFilter("test", "value3");
        options.addGreaterThanFilter("test", "value4");
        options.addInFilter("test", "value1,value2");
        options.addInFilter("test2", Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10));
        Integer[] values = { 1, 2, 3, 4, 5, 6, 91 };
        options.addInFilter("test3", values);
        options.addNotInFilter("test", "value3,value4");
        options.addNotInFilter("test2", Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11));
        options.addNotInFilter("test3", values);
        options.addLikeFilter("test", "some test");
        assertTrue(options.hasFilters());
        assertTrue(options.hasFilters("test"));
        assertFalse(options.hasFilters("test1"));
        assertTrue(options.hasFilters("test2"));
        assertTrue(options.hasFilters("test3"));
        assertTrue(options.hasFilter("test", FilterOperator.IN));
        assertTrue(options.hasFilter("test", FilterOperator.GREATER_THAN));
        assertFalse(options.hasFilter("test2", FilterOperator.GREATER_THAN));
        assertTrue(options.hasFilter("test2", FilterOperator.IN));
        assertEquals("value1", options.encodeSingleEqualFilter("test"));
        assertEquals("value2", options.encodeSingleNotEqualFilter("test"));
        assertEquals("value3", options.encodeSingleLessThanFilter("test"));
        assertEquals("value4", options.encodeSingleGreaterThanFilter("test"));
        assertEquals("value1,value2", options.encodeSingleInFilter("test"));
        assertEquals("1,2,3,4,5,6,7,8,9,10", options.encodeSingleInFilter("test2"));
        assertEquals("1,2,3,4,5,6,91", options.encodeSingleInFilter("test3"));
        assertEquals("value3,value4", options.encodeSingleNotInFilter("test"));
        assertEquals("1,2,3,4,5,6,7,8,9,10,11", options.encodeSingleNotInFilter("test2"));
        assertEquals("1,2,3,4,5,6,91", options.encodeSingleNotInFilter("test3"));
        assertEquals("some test", options.encodeSingleLikeFilter("test"));
    }

    @Test
    public void equalsContract() {
        final Filter filter1 = new Filter("test1", FilterOperator.GREATER_THAN, Integer.valueOf(5));
        final Filter filter2 = new Filter("test2", FilterOperator.NOT_EQUAL, "test value");
        final Filters filters = new Filters();
        final Filters filters2 = new Filters();
        filters.add(filter1);
        filters.add(filter2);
        filters2.add(filter1);
        final ListOptions opt1 = new ListOptions(new Integer(3), new Long(3), null, "after", null, filters);
        final ListOptions opt2 = new ListOptions(new Integer(3), new Long(3), null, "after", null, filters);
        final ListOptions opt3 = new ListOptions(new Integer(3), new Long(3), null, "after", null, filters2);
        assertNotSame(opt1, opt2);
        assertEquals(opt1, opt2);
        assertNotEquals(opt1, opt3);
        assertNotEquals(opt2, opt3);

        EqualsVerifier.forClass(ListOptions.class).withRedefinedSuperclass().suppress(Warning.NONFINAL_FIELDS)
                      .suppress(Warning.STRICT_INHERITANCE).withPrefabValues(Filters.class, filters, filters2).verify();
    }
}
