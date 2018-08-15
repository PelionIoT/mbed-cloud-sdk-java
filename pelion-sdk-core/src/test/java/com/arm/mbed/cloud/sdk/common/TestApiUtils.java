package com.arm.mbed.cloud.sdk.common;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.util.Date;

import org.junit.Test;

import com.arm.mbed.cloud.sdk.annotations.Required;
import com.arm.mbed.cloud.sdk.common.ApiUtils.CaseConversion;

public class TestApiUtils {

    @SuppressWarnings("boxing")
    @Test
    public final void testCheckNotNull() {
        Integer test = null;
        SdkLogger logger = new SdkLogger();
        try {
            ApiUtils.checkNotNull(logger, test, "test");
            fail("Check has not worked");
        } catch (MbedCloudException e) {
            assertTrue(true);
        }
        test = 5;
        try {
            ApiUtils.checkNotNull(logger, test, "test");
            assertTrue(true);
        } catch (MbedCloudException e) {
            fail("Check has not worked");
        }
        try {
            ApiUtils.checkNotNull(new SdkLogger(), new Date(), "now()");
        } catch (Exception e) {
            fail("No exception should have been raised");
        }
        try {
            ApiUtils.checkNotNull(logger, null, "test");
            fail("Check has not worked");
        } catch (MbedCloudException e) {
            assertTrue(true);
        }

    }

    @SuppressWarnings("unused")
    private static class ModelClass implements SdkModel {

        private static final long serialVersionUID = -1025322916863664007L;

        @Required
        private Integer field1;

        @Required
        private String field2;
        private Object field3;

        public ModelClass(Integer field1, String field2, Object field3) {
            super();
            this.field1 = field1;
            this.field2 = field2;
            this.field3 = field3;
        }

        public ModelClass() {
            super();
            field1 = null;
            field2 = null;
            field3 = null;
        }

        /**
         * @param field1
         *            the field1 to set
         */
        @Required
        public void setField1(Integer field1) {
            this.field1 = field1;
        }

        /**
         * @param field2
         *            the field2 to set
         */
        @Required
        public void setField2(String field2) {
            this.field2 = field2;
        }

        /**
         * @param field3
         *            the field3 to set
         */
        public void setField3(Object field3) {
            this.field3 = field3;
        }

        @Override
        public ModelClass clone() {
            return this;
        }

        @Override
        public boolean isValid() {
            return field1 != null && field2 != null;
        }

        @Override
        public String getId() {
            return null;
        }

        @Override
        public void setId(String id) {
            // Nothing to do

        }

    }

    @SuppressWarnings("boxing")
    @Test
    public final void testCheckModelValidity() {
        SdkLogger logger = new SdkLogger();
        ModelClass test = null;
        try {
            ApiUtils.checkModelValidity(logger, test, "test");
            assertTrue(true);
        } catch (MbedCloudException e) {
            fail("No exception should have been raised");
        }
        test = new ModelClass(1, "Test", null);
        try {
            ApiUtils.checkModelValidity(logger, test, "test");
            assertTrue(true);
        } catch (MbedCloudException e) {
            fail("Check has not worked");
        }
        test = new ModelClass(1, "", null);
        try {
            ApiUtils.checkModelValidity(logger, test, "test");
        } catch (Exception e) {
            fail("No exception should have been raised");
        }
        test = new ModelClass(1, null, "Test");
        try {
            ApiUtils.checkModelValidity(logger, test, "test");
            fail("Check has not worked");
        } catch (MbedCloudException e) {
            assertTrue(true);
        }
        test = new ModelClass(null, "test", "Test");
        try {
            ApiUtils.checkModelValidity(logger, test, "test");
            fail("Check has not worked");
        } catch (MbedCloudException e) {
            assertTrue(true);
        }
        test = new ModelClass(null, null, "Test");
        try {
            ApiUtils.checkModelValidity(logger, test, "test");
            fail("Check has not worked");
        } catch (MbedCloudException e) {
            assertTrue(true);
        }
    }

    @Test
    public final void testConvertSnakeToCamel() {
        String testfunctionString = "this_is_a_function_name";
        String testClassString = "this_is_a_class_name";
        assertEquals("thisIsAFunctionName", ApiUtils.convertSnakeToCamel(testfunctionString, false));
        assertEquals("ThisIsAClassName", ApiUtils.convertSnakeToCamel(testClassString, true));
        assertEquals(null, ApiUtils.convertSnakeToCamel(null, true));
        assertEquals("", ApiUtils.convertSnakeToCamel("", true));
        assertEquals("ThisIsAClassName", ApiUtils.convertSnakeToCamel("ThisIsAClassName", true));
        assertEquals("thisIsAFunctionName", ApiUtils.convertSnakeToCamel("thisIsAFunctionName", false));

    }

    @Test
    public final void testConvertCamelToSnake() {
        String testfunctionString = "thisIsAFunctionName";
        String testClassString = "ThisIsAClassName";
        assertEquals("this_is_a_function_name", ApiUtils.convertCamelToSnake(testfunctionString));
        assertEquals("this_is_a_class_name", ApiUtils.convertCamelToSnake(testClassString));
        assertEquals("", ApiUtils.convertCamelToSnake(""));
        assertEquals(null, ApiUtils.convertCamelToSnake(null));
        assertEquals("this_is_a_class_name", ApiUtils.convertCamelToSnake("this_is_a_class_name"));
    }

    @Test
    public final void testGetCaseConverter() {
        String testfunctionString = "thisIsAFunctionName";
        String testClassString = "ThisIsAClassName";
        String tempText = ApiUtils.getCaseConverter(CaseConversion.CAMEL_TO_SNAKE).convert(testfunctionString, false);
        assertNotNull(tempText);
        assertNotEquals(testfunctionString, tempText);
        assertEquals(testfunctionString,
                     ApiUtils.getCaseConverter(CaseConversion.SNAKE_TO_CAMEL).convert(tempText, false));
        tempText = ApiUtils.getCaseConverter(CaseConversion.CAMEL_TO_SNAKE).convert(testClassString, true);
        assertNotNull(tempText);
        assertNotEquals(testClassString, tempText);
        assertEquals(testClassString, ApiUtils.getCaseConverter(CaseConversion.SNAKE_TO_CAMEL).convert(tempText, true));
    }

    @Test
    public final void testNormalisePath() {
        assertNull(ApiUtils.normalisePath(null));
        assertTrue(ApiUtils.normalisePath("").isEmpty());
        assertTrue(ApiUtils.normalisePath("/").isEmpty());
        String path = "test/path";
        assertEquals(path, ApiUtils.normalisePath(path));
        String path2 = "/" + path;
        assertEquals(path, ApiUtils.normalisePath(path2));
    }

    @Test
    public final void testNormaliseResourcePath() {
        assertNull(ApiUtils.normaliseResourcePath(null));
        assertTrue(ApiUtils.normaliseResourcePath("").equals("/"));
        assertTrue(ApiUtils.normaliseResourcePath("/").equals("/"));
        String path = "test/path";
        assertNotEquals(path, ApiUtils.normaliseResourcePath(path));
        String path2 = "/" + path;
        assertEquals(path2, ApiUtils.normaliseResourcePath(path2));
    }

    @Test
    public final void testComparePaths() {
        assertTrue(ApiUtils.comparePaths(null, null));
        assertFalse(ApiUtils.comparePaths(null, ""));
        assertFalse(ApiUtils.comparePaths("", null));
        assertTrue(ApiUtils.comparePaths("/test/1", "test/1"));
        assertTrue(ApiUtils.comparePaths("test/2", "/test/2"));
    }

    @Test
    public void testAllDateManipulations() {
        String timestamp = "1971-12-08T01:04:45+12:45";
        String timestampInUtc = "1971-12-07T12:19:45.000Z";
        try {
            Date dateInNZ = ApiUtils.convertStringToDate(timestamp);
            Date dateInUTC = ApiUtils.convertStringToDate(timestampInUtc);
            assertEquals(dateInUTC, dateInNZ);
            assertEquals(timestampInUtc, ApiUtils.toUtcTimestamp(dateInNZ));

        } catch (MbedCloudException e) {
            fail(e.getMessage());
        }

    }
}
