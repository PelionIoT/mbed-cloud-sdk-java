package com.arm.mbed.cloud.sdk.common;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import org.junit.Test;

import com.arm.mbed.cloud.sdk.common.ApiUtils.CaseConversion;

public class TestApiUtils {

    @SuppressWarnings("boxing")
    @Test
    public final void testCheckNotNull() {
        Integer test = null;
        SDKLogger logger = new SDKLogger();
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

    }

    @Test
    public final void testConvertSnakeToCamel() {
        String testfunctionString = "this_is_a_function_name";
        String testClassString = "this_is_a_class_name";
        assertEquals("thisIsAFunctionName", ApiUtils.convertSnakeToCamel(testfunctionString, false));
        assertEquals("ThisIsAClassName", ApiUtils.convertSnakeToCamel(testClassString, true));
    }

    @Test
    public final void testConvertCamelToSnake() {
        String testfunctionString = "thisIsAFunctionName";
        String testClassString = "ThisIsAClassName";
        assertEquals("this_is_a_function_name", ApiUtils.convertCamelToSnake(testfunctionString));
        assertEquals("this_is_a_class_name", ApiUtils.convertCamelToSnake(testClassString));
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

}
