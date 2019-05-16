package com.arm.mbed.cloud.sdk.accountmanagement.model;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;

import org.junit.Test;

public class TestCustomProperties {

    @Test
    public void testCustomProperties() {
        Map<String, String> fields = new Hashtable<>();
        fields.put("field1", "value1");
        fields.put("field2", "{\"a sub-key\":\"a value\"}");
        CustomProperties properties = CustomProperties.from(fields);
        assertTrue(properties.hasProperty("field1"));
        assertEquals(properties, properties.getProperties(CustomProperties.class));
        assertEquals("{\"field2\":{\"a sub-key\":\"a value\"},\"field1\":\"value1\"}",
                     properties.getProperties(String.class));
        PropertiesTestContainer container = new PropertiesTestContainer();
        container.setField1("value1");
        container.putField2("a sub-key", "a value");
        assertEquals(container, properties.getProperties(PropertiesTestContainer.class));
    }

    @SuppressWarnings("deprecation")
    @Test
    public void testGetPropertiesInFormerFormat() {
        Map<String, Map<String, String>> properties = new HashMap<>();
        Map<String, String> subproperties = new HashMap<>();
        subproperties.put("a sub-key", "a value");
        properties.put("field1", subproperties);
        subproperties = new HashMap<>();
        subproperties.put("another sub-key", "another value");
        properties.put("field2", subproperties);
        CustomProperties customProperties = CustomProperties.from(properties);
        assertEquals(properties, customProperties.getPropertiesInFormerFormat());

    }

    @Test
    public void testFromObject() {
        Map<String, String> fields = new Hashtable<>();
        fields.put("field1", "value1");
        fields.put("field2", "{\"a sub-key\":\"a value\"}");
        CustomProperties properties = new CustomProperties(fields);
        assertEquals(properties, CustomProperties.from(properties));
        assertEquals(properties,
                     CustomProperties.from("{\"field2\":{\"a sub-key\":\"a value\"},\"field1\":\"value1\"}"));
        assertEquals(properties,
                     new CustomProperties("{\"field2\":{\"a sub-key\":\"a value\"},\"field1\":\"value1\"}"));
        PropertiesTestContainer container = new PropertiesTestContainer();
        container.setField1("value1");
        container.putField2("a sub-key", "a value");
        assertEquals(properties, CustomProperties.from(properties));
        assertFalse(properties == properties.clone());
        assertTrue(properties.equals(properties.clone()));
    }

    private static class PropertiesTestContainer {
        private String field1;
        private Map<String, String> field2;

        /**
         * @param field1
         *            the field1 to set
         */
        public void setField1(String field1) {
            this.field1 = field1;
        }

        public void putField2(String key, String value) {
            if (field2 == null) {
                field2 = new HashMap<>();
            }
            field2.put(key, value);
        }

        /*
         * (non-Javadoc)
         *
         * @see java.lang.Object#hashCode()
         */
        @Override
        public int hashCode() {
            final int prime = 31;
            int result = 1;
            result = prime * result + ((field1 == null) ? 0 : field1.hashCode());
            result = prime * result + ((field2 == null) ? 0 : field2.hashCode());
            return result;
        }

        /*
         * (non-Javadoc)
         *
         * @see java.lang.Object#equals(java.lang.Object)
         */
        @Override
        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null) {
                return false;
            }
            if (getClass() != obj.getClass()) {
                return false;
            }
            PropertiesTestContainer other = (PropertiesTestContainer) obj;
            if (field1 == null) {
                if (other.field1 != null) {
                    return false;
                }
            } else if (!field1.equals(other.field1)) {
                return false;
            }
            if (field2 == null) {
                if (other.field2 != null) {
                    return false;
                }
            } else if (!field2.equals(other.field2)) {
                return false;
            }
            return true;
        }

    }
}
