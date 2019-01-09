package com.arm.mbed.cloud.sdk.common;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Test;

import com.arm.mbed.cloud.sdk.common.SdkUtils.CaseConversion;

public class TestSdkUtils {

    @Test
    public void testParseListString() {
        assertNull(SdkUtils.parseListString(null));
        assertArrayEquals(new ArrayList<>().toArray(), SdkUtils.parseListString("").toArray());
        final List<String> list = Arrays.asList("1", "2", "3", "4");
        final String csv = SdkUtils.joinList(list, ",");
        final String jsonArray = "[\"1\",\"2\",\"3\",\"4\"]";// new JsonSerialiser().toJson(list);
        assertArrayEquals(list.toArray(), SdkUtils.parseListString(csv).toArray());
        assertArrayEquals(list.toArray(), SdkUtils.parseListString(jsonArray).toArray());
    }

    @Test
    public void testJoinList() {
        assertNull(SdkUtils.joinList(null, ""));
        assertNull(SdkUtils.joinList(new ArrayList<>(), ""));
        final List<String> list = Arrays.asList("1", "2", "3", "4");
        final String separator = "+-/+_$£&^%!()(&^";
        assertEquals(String.join(separator, list), SdkUtils.joinList(list, separator));
    }

    @Test
    public void testUrlEquals() {
        try {
            assertTrue(SdkUtils.urlEquals(null, null));
            URL url = new URL("http://test");
            assertFalse(SdkUtils.urlEquals(null, url));
            assertFalse(SdkUtils.urlEquals(url, null));
            assertTrue(SdkUtils.urlEquals(url, url));
            assertTrue(SdkUtils.urlEquals(url, new URL("http://test")));
            assertTrue(SdkUtils.urlEquals(new URL("http://test"), url));
            assertFalse(SdkUtils.urlEquals(new URL("http://other"), url));
        } catch (MalformedURLException exception) {
            fail(exception.getMessage());
        }
    }

    @Test
    public void testHexArray() {
        assertNull(SdkUtils.toHex(null));
        byte[] value = { (byte) 255, (byte) 255 };
        assertEquals("ffff", SdkUtils.toHex(value));
    }

    @Test
    public final void testConvertSnakeToCamel() {
        String testfunctionString = "this_is_a_function_name";
        String testClassString = "this_is_a_class_name";
        assertEquals("thisIsAFunctionName", SdkUtils.convertSnakeToCamel(testfunctionString, false));
        assertEquals("ThisIsAClassName", SdkUtils.convertSnakeToCamel(testClassString, true));
        assertEquals(null, SdkUtils.convertSnakeToCamel(null, true));
        assertEquals("", SdkUtils.convertSnakeToCamel("", true));
        assertEquals("ThisIsAClassName", SdkUtils.convertSnakeToCamel("ThisIsAClassName", true));
        assertEquals("thisIsAFunctionName", SdkUtils.convertSnakeToCamel("thisIsAFunctionName", false));

    }

    @Test
    public final void testConvertCamelToSnake() {
        String testfunctionString = "thisIsAFunctionName";
        String testClassString = "ThisIsAClassName";
        String testMalformedFunctionString = "Device_Event_retrieve";
        assertEquals("this_is_a_function_name", SdkUtils.convertCamelToSnake(testfunctionString));
        assertEquals("this_is_a_class_name", SdkUtils.convertCamelToSnake(testClassString));
        assertEquals("device_event_retrieve", SdkUtils.convertCamelToSnake(testMalformedFunctionString));
        assertEquals("", SdkUtils.convertCamelToSnake(""));
        assertNull(SdkUtils.convertCamelToSnake(null));
        assertEquals("this_is_a_class_name", SdkUtils.convertCamelToSnake("this_is_a_class_name"));

    }

    @Test
    public final void testGetCaseConverter() {
        String testfunctionString = "thisIsAFunctionName";
        String testClassString = "ThisIsAClassName";
        String tempText = SdkUtils.getCaseConverter(CaseConversion.CAMEL_TO_SNAKE).convert(testfunctionString, false);
        assertNotNull(tempText);
        assertNotEquals(testfunctionString, tempText);
        assertEquals(testfunctionString,
                     SdkUtils.getCaseConverter(CaseConversion.SNAKE_TO_CAMEL).convert(tempText, false));
        tempText = SdkUtils.getCaseConverter(CaseConversion.CAMEL_TO_SNAKE).convert(testClassString, true);
        assertNotNull(tempText);
        assertNotEquals(testClassString, tempText);
        assertEquals(testClassString, SdkUtils.getCaseConverter(CaseConversion.SNAKE_TO_CAMEL).convert(tempText, true));
    }

}
