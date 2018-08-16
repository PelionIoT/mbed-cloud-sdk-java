package com.arm.pelion.sdk.foundation.generator.input;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import com.arm.mbed.cloud.sdk.common.ApiUtils;

public class Utils {

    public static String getKey(Map<String, String> keys, boolean camel) {
        return keys == null ? null : ApiUtils.convertSnakeToCamel(keys.get(InputSchema.SNAKE_TAG), !camel);
    }

    public static List<String> getGroupId(Map<String, String> groupIds) {
        return groupIds == null ? new LinkedList<>() : processGroupIds(groupIds);
    }

    private static List<String> processGroupIds(Map<String, String> groupIds) {
        return Arrays.asList(fetchGroupId(groupIds).replace("_", "").split("\\."));
    }

    private static String fetchGroupId(Map<String, String> groupIds) {
        final String value = groupIds.get(InputSchema.SNAKE_TAG);
        return value == null ? "" : value;
    }
}
