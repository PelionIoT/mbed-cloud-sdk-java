package com.arm.mbed.cloud.sdk.common.listing;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import java.util.List;

import org.junit.Test;

import com.arm.mbed.cloud.sdk.common.listing.filtering.Filter;
import com.arm.mbed.cloud.sdk.common.listing.filtering.FilterOperator;

public class TestListOptions {

    @Test
    public void testEncodeInclude() {
        ListOptions options = new ListOptions();
        options.addInclude(null);
        assertEquals(null, options.encodeInclude());
        options.addInclude(new IncludeField("fieldOne"));
        options.addInclude(new IncludeField("FieldTwo"));
        assertEquals("field_one,field_two", options.encodeInclude());
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
