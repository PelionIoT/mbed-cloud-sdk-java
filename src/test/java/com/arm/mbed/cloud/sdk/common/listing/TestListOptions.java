package com.arm.mbed.cloud.sdk.common.listing;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import java.util.List;

import org.junit.Test;

import com.arm.mbed.cloud.sdk.common.Order;
import com.arm.mbed.cloud.sdk.common.listing.filtering.Filter;
import com.arm.mbed.cloud.sdk.common.listing.filtering.FilterOperator;

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
        ListOptions options = new ListOptions(new Integer(3), null, "after", null, null);
        options.setOrder(Order.DESC);
        options.includeTotalCount();
        options.addEqualFilter("afield", "some value");
        options.addCustomFilter("field", FilterOperator.NOT_EQUAL, "value");
        ListOptions options2 = new ListOptions(new Integer(4), null, "other", null, null);
        options2.setOrder(Order.ASC);
        options2.addFilter("test_3", FilterOperator.LESS_THAN, "value1");
        assertNotEquals(options2.getOrder(), Order.DESC);
        assertNotEquals(options, options2);
        assertNotEquals(options.hashCode(), options2.hashCode());
        options2.setOptions(options);
        assertEquals(options, options2);
        assertEquals(options.hashCode(), options2.hashCode());
        assertEquals(options2.getOrder(), Order.DESC);
        assertEquals("some value", options2.fetchEqualFilterValue("afield"));
    }

    @Test
    public void testClone() {
        ListOptions options = new ListOptions(new Integer(4), null, "after", null, null);
        options.setOrder(Order.DESC);
        options.includeTotalCount();
        options.addCustomFilter("field", FilterOperator.NOT_EQUAL, "value");
        options.addEqualFilter("afield", "some value");
        ListOptions clone = options.clone();
        assertEquals(options, clone);
        assertFalse(options == clone);
        assertEquals(options.hashCode(), clone.hashCode());
        assertEquals("some value", clone.fetchEqualFilterValue("afield"));

    }

    @Test
    public void testSetFiltersFromJson() {
        String jsonFilter = "{\"custom_attributes\":{\"foo\":{\"$neq\":\"bar\"}},\"test3\":{\"$lte\":\"value1\",\"$eq\":\"value2\"}}";
        ListOptions options = new ListOptions();
        assertNull(options.getFilter());
        options.setFiltersFromJson(jsonFilter);
        assertNotNull(options.getFilter());
        List<Filter> filters = options.fetchFilters("test3");
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
        options.addFilter("test_3", FilterOperator.LESS_THAN, "value1");
        assertEquals("{\"custom_attributes\":{\"foo\":{\"$neq\":\"bar\"}},\"test_3\":{\"$lte\":\"value1\"}}",
                options.retrieveFilterAsJson());
    }

}
