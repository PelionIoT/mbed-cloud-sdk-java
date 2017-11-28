package com.arm.mbed.cloud.sdk.common.listing.filtering;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.HashMap;
import java.util.Map;

import org.junit.Test;

public class TestFilterMarshaller {
    @Test
    public void testEncodeFilter() {
        Filter filter = new CustomFilter("foo", FilterOperator.GREATER_THAN, "bar");
        assertEquals("custom_attributes__foo__gte=bar", new FilterMarshaller(null).encodeFilter(filter, "foo"));
        filter = new Filter("foo", FilterOperator.GREATER_THAN, "bar");
        assertEquals("foo__gte=bar", new FilterMarshaller(null).encodeFilter(filter, "foo"));
        filter = new Filter("foo", FilterOperator.EQUAL, "bar");
        assertEquals("foo=bar", new FilterMarshaller(null).encodeFilter(filter, "foo"));
        assertEquals("test_1=bar", new FilterMarshaller(null).encodeFilter(filter, "test_1"));
    }

    @Test
    public void testEncodeFilters() {
        Filters filters = new Filters();
        filters.add(new CustomFilter("foo", FilterOperator.GREATER_THAN, "bar"));
        filters.add(new Filter("key", FilterOperator.EQUAL, "value"));
        assertEquals("custom_attributes__foo__gte=bar&key=value", new FilterMarshaller(null).encode(filters));
        Map<String, String> mapping = new HashMap<>(1);
        mapping.put("foo", "test_1");
        mapping.put("key", "test_2");
        assertEquals("custom_attributes__test_1__gte=bar&test_2=value", new FilterMarshaller(mapping).encode(filters));
        filters = new Filters();
        filters.add(new CustomFilter("fooBar", FilterOperator.GREATER_THAN, "top"));
        filters.add(new Filter("key", FilterOperator.EQUAL, "value"));
        assertEquals("custom_attributes__foo_bar__gte=top&key=value", new FilterMarshaller(null).encode(filters));
        // TODO add more test cases
    }

    @Test
    public void testDecodeFilter() {
        String query = "custom_attributes__foo=bar";
        Filter filter = new FilterMarshaller(null).decodeFilter(query);
        assertNotNull(filter);
        assertTrue(filter.isValid());
        assertTrue(filter instanceof CustomFilter);
        assertEquals(FilterOperator.EQUAL, filter.getOperator());
        assertEquals("foo", filter.getFieldName());
        assertEquals("bar", filter.getValue());
        query = "foo__neq=bar";
        filter = new FilterMarshaller(null).decodeFilter(query);
        assertNotNull(filter);
        assertTrue(filter.isValid());
        assertFalse(filter instanceof CustomFilter);
        assertEquals(FilterOperator.NOT_EQUAL, filter.getOperator());
        assertEquals("foo", filter.getFieldName());
        assertEquals("bar", filter.getValue());
        query = "test_1__neq=bar";
        filter = new FilterMarshaller(null).decodeFilter(query);
        assertNotNull(filter);
        assertTrue(filter.isValid());
        assertFalse(filter instanceof CustomFilter);
        assertEquals(FilterOperator.NOT_EQUAL, filter.getOperator());
        assertEquals("test1", filter.getFieldName());
        assertEquals("bar", filter.getValue());
        query = "test_1=bar";
        filter = new FilterMarshaller(null).decodeFilter(query);
        assertNotNull(filter);
        assertTrue(filter.isValid());
        assertFalse(filter instanceof CustomFilter);
        assertEquals(FilterOperator.EQUAL, filter.getOperator());
        assertEquals("test1", filter.getFieldName());
        assertEquals("bar", filter.getValue());
        query = "test_foo=bar";
        filter = new FilterMarshaller(null).decodeFilter(query);
        assertNotNull(filter);
        assertTrue(filter.isValid());
        assertFalse(filter instanceof CustomFilter);
        assertEquals(FilterOperator.EQUAL, filter.getOperator());
        assertEquals("testFoo", filter.getFieldName());
        assertEquals("bar", filter.getValue());
        // TODO add more test cases
    }

    @Test
    public void testDecode() {
        String query = "custom_attributes__foo__neq=bar&key__lte=value";
        Filters filters = new FilterMarshaller(null).decode(query);
        assertNotNull(filters);
        assertFalse(filters.isEmpty());
        assertEquals("{\"custom_attributes\":{\"foo\":{\"$neq\":\"bar\"}},\"key\":{\"$lte\":\"value\"}}",
                FilterMarshaller.toJson(filters));
        Map<String, String> mapping = new HashMap<>(1);
        mapping.put("foo", "test_1");
        mapping.put("key", "test_2");
        query = "custom_attributes__test_1__neq=bar&test_2__lte=value&test_3=value";
        filters = new FilterMarshaller(mapping).decode(query);
        assertNotNull(filters);
        assertFalse(filters.isEmpty());
        assertEquals(
                "{\"custom_attributes\":{\"foo\":{\"$neq\":\"bar\"}},\"key\":{\"$lte\":\"value\"},\"test3\":{\"$eq\":\"value\"}}",
                FilterMarshaller.toJson(filters));
        // TODO add more test cases
    }

    @Test
    public void testToJson() {
        assertEquals(null, FilterMarshaller.toJson(null));
        String filterJson = "{\"foo\":{\"$eq\":\"bar\"}}";
        Filters filters = new Filters();
        FilterMarshaller.parseFilter(filterJson, "foo", filters, false);
        assertEquals(filterJson, FilterMarshaller.toJson(filters));
        filterJson = "{\"custom_attributes\":{\"foo\":{\"$neq\":\"bar\"}},\"id\":{\"$eq\":\"new_device_id\"}}";
        filters = FilterMarshaller.fromJson(filterJson);
        assertEquals(filterJson, FilterMarshaller.toJson(filters));
        filterJson = "{\"foo\":\"bar\",\"key\":\"value\"}";
        filters = FilterMarshaller.fromJson(filterJson);
        assertEquals("{\"foo\":{\"$eq\":\"bar\"},\"key\":{\"$eq\":\"value\"}}", FilterMarshaller.toJson(filters));
    }

    @Test
    public void testFromJson() {
        assertEquals(null, FilterMarshaller.fromJson(null));
        String filterJson = "{\"custom_attributes\": { \"foo\": { \"$neq\": \"bar\" }},\"id\": { \"$eq\": \"new_device_id\" }}";
        Filters filters = FilterMarshaller.fromJson(filterJson);
        assertFalse(filters.isEmpty());
        assertTrue(filters.hasFilters("foo"));
        assertTrue(filters.hasFilters("foo", FilterOperator.NOT_EQUAL));
        assertTrue(filters.hasFilters("id"));
        assertTrue(filters.hasFilters("id", FilterOperator.EQUAL));
        assertTrue(filters.hasCustomFilters());
        filterJson = "{ \"foo\":  \"bar\" ,\"id\":  \"new_device_id\" }";
        filters = FilterMarshaller.fromJson(filterJson);
        assertFalse(filters.isEmpty());
        assertTrue(filters.hasFilters("foo"));
        assertTrue(filters.hasFilters("foo", FilterOperator.EQUAL));
        assertTrue(filters.hasFilters("id"));
        assertTrue(filters.hasFilters("id", FilterOperator.EQUAL));
        assertFalse(filters.hasCustomFilters());
    }

    @Test
    public void testParseFilter() {
        String filterJson = "{ \"foo\": { \"$eq\": \"bar\" }}";
        Filters filters = new Filters();
        FilterMarshaller.parseFilter(filterJson, "foo", filters, false);
        assertFalse(filters.isEmpty());
        assertTrue(filters.hasFilters("foo"));
        assertTrue(filters.hasFilters("foo", FilterOperator.EQUAL));
    }

}
