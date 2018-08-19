package com.arm.mbed.cloud.sdk.common;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Test;

public class TestSdkUtils {

    @Test
    public void testParseListString() {
        assertNull(SdkUtils.parseListString(null));
        assertArrayEquals(new ArrayList<>().toArray(), SdkUtils.parseListString("").toArray());
        final List<String> list = Arrays.asList("1", "2", "3", "4");
        final String csv = SdkUtils.joinList(list, ",");
        final String jsonArray = new JsonSerialiser().toJson(list);
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

}
