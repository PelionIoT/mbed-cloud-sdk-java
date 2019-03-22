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

import com.arm.mbed.cloud.sdk.annotations.Required;
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
        final List<EnumTestClass> listEnum = Arrays.asList(EnumTestClass.VALUE1, EnumTestClass.VALUE2);
        final String enumCsv = SdkUtils.joinList(listEnum, ",");
        assertEquals("value1,value2", enumCsv);
        final List<ModelTestClass> listModel = Arrays.asList(new ModelTestClass("test1", null),
                                                             new ModelTestClass("test2", null));
        final String modelCsv = SdkUtils.joinList(listModel, ",");
        assertEquals("test1,test2", modelCsv);
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
        assertEquals("this_is_a_function_name", SdkUtils.convertCamelToSnake(" " + testfunctionString + " "));
        assertEquals("this_is_a_class_name", SdkUtils.convertCamelToSnake(testClassString));
        assertEquals("device_event_retrieve", SdkUtils.convertCamelToSnake(testMalformedFunctionString));
        assertEquals("", SdkUtils.convertCamelToSnake(""));
        assertNull(SdkUtils.convertCamelToSnake(null));
        assertEquals("this_is_a_class_name", SdkUtils.convertCamelToSnake("this_is_a_class_name"));
        assertEquals("this_is_a_function_name", SdkUtils.convertCamelToSnake("thisIs A FunctionName"));
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

    @Test
    public final void testRequiredFieldMessage() {
        ModelTestClass model = new ModelTestClass();
        String message = SdkUtils.describeRequiredFields(model);
        assertNotNull(message);
        assertTrue(message.contains("fieldRequired"));
        assertTrue(message.contains("setFieldRequired"));
        assertFalse(message.contains("fieldNotRequired"));
        assertFalse(message.contains("setFieldNotRequired"));
    }

    @Test
    public final void testCheckModelValidity() {
        ModelTestClass model = new ModelTestClass();
        String message = SdkUtils.checkModelValidity(model, "some model");
        assertNotNull(message);
        assertTrue(message.contains("fieldRequired"));
        assertTrue(message.contains("setFieldRequired"));
        assertFalse(message.contains("fieldNotRequired"));
        assertFalse(message.contains("setFieldNotRequired"));
        model = new ModelTestClass(null, "some message");
        message = SdkUtils.checkModelValidity(model, "some model");
        assertNotNull(message);
        assertTrue(message.contains("fieldRequired"));
        assertTrue(message.contains("setFieldRequired"));
        assertFalse(message.contains("fieldNotRequired"));
        assertFalse(message.contains("setFieldNotRequired"));
        model = new ModelTestClass("some required message", null);
        message = SdkUtils.checkModelValidity(model, "some model");
        assertNull(message);
    }

    @Test
    public void testGetFileExtension() {

        String filePath = "201806-0157528bb84102420a01321400000000-activedevices.098052628912094123.gz";
        assertEquals("gz", SdkUtils.getFileExtension(filePath));
        assertTrue(SdkUtils.hasExtension(filePath));
        filePath = "C:\\Users\\adrcab01\\AppData\\Local\\Temp\\201806-0157528bb84102420a01321400000000-activedevices.5098052628912094123.7z";
        assertEquals("7z", SdkUtils.getFileExtension(filePath));
        assertTrue(SdkUtils.hasExtension(filePath));
        filePath = "https://s3.eu-west-1.amazonaws.com/billing-final-reports-9eb5/201806/7df13c0e372d4346a8aeeb1167d75116/201806-0157528bb84102420a01321400000000-firmwareupdates.csv.gz";
        assertEquals("csv.gz", SdkUtils.getFileExtension(filePath));
        assertTrue(SdkUtils.hasExtension(filePath));
        filePath = "201806-0157528bb84102420a01321400000000-activedevices.098052628912094123.";
        assertEquals("", SdkUtils.getFileExtension(filePath));
        assertFalse(SdkUtils.hasExtension(filePath));
        filePath = "C:\\Users\\adrcab01\\AppData\\Local\\Temp\\201806-0157528bb84102420a01321400000000-activedevices.5098052628912094123.7z ";
        assertEquals("7z", SdkUtils.getFileExtension(filePath));
        assertTrue(SdkUtils.hasExtension(filePath));

    }

    @Test
    public void testGetFileNameWithoutExtension() {
        String filePath = "201806-0157528bb84102420a01321400000000-activedevices.098052628912094123.gz";
        assertEquals("201806-0157528bb84102420a01321400000000-activedevices.098052628912094123",
                     SdkUtils.getFileNameWithoutExtension(filePath));
        filePath = "201806-0157528bb84102420a01321400000000-activedevices.5098052628912094123.7z";
        assertEquals("201806-0157528bb84102420a01321400000000-activedevices.5098052628912094123",
                     SdkUtils.getFileNameWithoutExtension(filePath));
        filePath = "201806-0157528bb84102420a01321400000000-firmwareupdates.csv.gz";
        assertEquals("201806-0157528bb84102420a01321400000000-firmwareupdates",
                     SdkUtils.getFileNameWithoutExtension(filePath));
        filePath = "201806-0157528bb84102420a01321400000000-firmwareupdates .csv.gz ";
        assertEquals("201806-0157528bb84102420a01321400000000-firmwareupdates ",
                     SdkUtils.getFileNameWithoutExtension(filePath));
    }

    private static enum EnumTestClass implements SdkEnum {
        VALUE1("value1"),
        VALUE2("value2");

        private final String value;

        private EnumTestClass(String value) {
            this.value = value;
        }

        @Override
        public boolean isUnknownValue() {
            return false;
        }

        @Override
        public boolean isDefault() {
            return false;
        }

        @Override
        public String getString() {
            return value;
        }

        @Override
        public <T extends SdkEnum> T merge(T obj1, T obj2) {
            return null;
        }

    }

    private static class ModelTestClass implements SdkModel {

        private static final long serialVersionUID = 3002377627702433692L;

        @Required
        private String fieldRequired;

        private String fieldNotRequired;

        public ModelTestClass() {
            this(null, null);
        }

        public ModelTestClass(String fieldRequired, String fieldNotRequired) {
            super();
            this.fieldRequired = fieldRequired;
            this.fieldNotRequired = fieldNotRequired;
        }

        public String getFieldRequired() {
            return fieldRequired;
        }

        @Required
        public void setFieldRequired(String fieldRequired) {
            this.fieldRequired = fieldRequired;
        }

        public String getFieldNotRequired() {
            return fieldNotRequired;
        }

        public void setFieldNotRequired(String fieldNotRequired) {
            this.fieldNotRequired = fieldNotRequired;
        }

        @Override
        public boolean isValid() {
            return fieldRequired != null;
        }

        @Override
        public String getId() {
            return getFieldRequired();
        }

        @Override
        public void setId(String id) {
            setFieldRequired(id);
        }

        @Override
        public ModelTestClass clone() {
            return new ModelTestClass(fieldRequired, fieldNotRequired);
        }

    }

}
