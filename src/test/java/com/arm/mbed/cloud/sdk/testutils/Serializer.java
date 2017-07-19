package com.arm.mbed.cloud.sdk.testutils;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;

import com.arm.mbed.cloud.sdk.common.ApiUtils;
import com.arm.mbed.cloud.sdk.common.ApiUtils.CaseConversion;

import io.vertx.core.json.JsonObject;

public class Serializer {
	/*
	 * Change result JSON entries to be snake case as expected by the test
	 * system
	 */
	public static String convertResultToJson(Object result) {
		return (result == null || result instanceof Void) ? "{}"
				: reformatJsonObject(JsonObject.mapFrom(result), CaseConversion.CAMEL_TO_SNAKE, false).encode();
	}

	public static <T> T convertStringToObject(String serializedObject, Class<T> objectClass) {
		if (objectClass == null || serializedObject == null || serializedObject.isEmpty()) {
			return null;
		}
		JsonObject jsonObject = new JsonObject(serializedObject);
		JsonObject transformedObject = reformatJsonObject(jsonObject, CaseConversion.SNAKE_TO_CAMEL, false);
		return transformedObject.mapTo(objectClass);
	}

	public static <T> T convertParametersToObject(Map<String, Object> objectFields, Class<T> objectClass) {
		if (objectClass == null || objectFields == null || objectFields.isEmpty()) {
			return null;
		}
		JsonObject jsonObject = new JsonObject(objectFields);
		JsonObject transformedObject = reformatJsonObject(jsonObject, CaseConversion.SNAKE_TO_CAMEL, false);
		return transformedObject.mapTo(objectClass);
	}

	private static JsonObject reformatJsonObject(JsonObject result, CaseConversion conversion, boolean capitalAtStart) {
		return (result == null) ? new JsonObject()
				: new JsonObject(reformatResultJsonMap(result.getMap(), conversion, capitalAtStart));
	}

	@SuppressWarnings("unchecked")
	private static Map<String, Object> reformatResultJsonMap(Map<String, Object> resultMap, CaseConversion conversion,
			boolean capitalAtStart) {
		Map<String, Object> formattedResult = new LinkedHashMap<String, Object>();
		for (Entry<String, Object> entry : resultMap.entrySet()) {
			formattedResult.put(ApiUtils.getCaseConverter(conversion).convert(entry.getKey(), capitalAtStart),
					(entry.getValue() instanceof Map<?, ?>)
							? reformatResultJsonMap((Map<String, Object>) entry.getValue(), conversion, capitalAtStart)
							: entry.getValue());
		}
		return formattedResult;
	}

}
