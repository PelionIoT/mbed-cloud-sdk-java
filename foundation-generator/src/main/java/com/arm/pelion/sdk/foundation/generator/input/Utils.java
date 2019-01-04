package com.arm.pelion.sdk.foundation.generator.input;

import java.util.Arrays;
import java.util.List;

import com.arm.mbed.cloud.sdk.common.ApiUtils;

public class Utils {

    public static String getKey(String key, boolean camel) {
        return key == null || key.equals("null")
               || key.equals("none") ? null
                                     : ApiUtils.convertSnakeToCamel(ApiUtils.convertCamelToSnake(key).replace("-", "_"),
                                                                    !camel);
    }

    public static List<String> getGroupId(String groupId) {
        return groupId == null ? null : processGroupIds(groupId);
    }

    private static List<String> processGroupIds(String groupId) {
        return Arrays.asList(fetchGroupId(groupId).split("\\."));
    }

    private static String fetchGroupId(String groupId) {
        String value = getKey(groupId, false);
        return value == null ? "" : value;
    }

    public static boolean has(String string) {
        return !(string == null || string.trim().isEmpty());
    }
}
