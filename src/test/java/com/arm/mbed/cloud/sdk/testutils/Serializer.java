package com.arm.mbed.cloud.sdk.testutils;

import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import com.arm.mbed.cloud.sdk.common.ApiUtils;
import com.arm.mbed.cloud.sdk.common.ApiUtils.CaseConversion;

import io.vertx.core.json.JsonArray;
import io.vertx.core.json.JsonObject;

public class Serializer {
    @SuppressWarnings({ "rawtypes", "unchecked" })
    private static final Set<Class> WRAPPER_TYPES = new HashSet(Arrays.asList(Boolean.class, Character.class,
            Byte.class, Short.class, Integer.class, Long.class, Float.class, Double.class, Void.class, String.class));

    /*
     * Change result JSON entries to be snake case as expected by the test system
     */
    public static String convertResultToJson(Object result) {
        return (result == null || result instanceof Void) ? "{}"
                : (result instanceof List) ? reformatJsonList((List<?>) result).encode()
                        : reformatJsonObject(JsonObject.mapFrom(result), CaseConversion.CAMEL_TO_SNAKE, false).encode();
    }

    public static JsonArray reformatJsonList(List<?> result) {
        JsonArray array = new JsonArray();
        for (Object object : result) {
            array.add(reformatJsonObject(JsonObject.mapFrom(object), CaseConversion.CAMEL_TO_SNAKE, false));
        }
        return array;
    }

    public static <T> T convertStringToObject(String serializedObject, Class<T> objectClass) throws APICallException {
        if (objectClass == null || serializedObject == null || serializedObject.isEmpty()) {
            return null;
        }
        JsonObject jsonObject = new JsonObject(serializedObject);
        JsonObject transformedObject = reformatJsonObject(jsonObject, CaseConversion.SNAKE_TO_CAMEL, false);
        return createObjectInstance(objectClass, transformedObject);
    }

    public static <T> T convertParametersToObject(Map<String, Object> objectFields, Class<T> objectClass)
            throws APICallException {
        if (objectClass == null || objectFields == null || objectFields.isEmpty()) {
            return null;
        }
        JsonObject jsonObject = new JsonObject(objectFields);
        JsonObject transformedObject = reformatJsonObject(jsonObject, CaseConversion.SNAKE_TO_CAMEL, false);
        return createObjectInstance(objectClass, transformedObject);
    }

    public static <T> T convertParametersToObjectFromAbstractClasses(Map<String, Object> objectFields,
            Class<T> objectClass) throws APICallException {
        if (objectClass == null || objectFields == null || objectFields.isEmpty()) {
            return null;
        }
        Set<Class<? extends T>> children = ReflectionUtils.getClassChildren(objectClass);
        if (children == null) {
            return convertParametersToObject(objectFields, objectClass);
        }
        APICallException e = null;
        for (Class<? extends T> child : children) {
            try {
                return convertParametersToObject(objectFields, child);
            } catch (APICallException e1) {
                e = e1;
            }
        }
        throw (e == null) ? new APICallException() : e;
    }

    private static <T> T createObjectInstance(Class<T> objectClass, JsonObject transformedObject)
            throws APICallException {
        return (!isPrimitiveOrWrapperType(objectClass)) ? convertObject(objectClass, transformedObject)
                : convertPrimitive(objectClass, transformedObject);
    }

    private static JsonObject reformatJsonObject(JsonObject result, CaseConversion conversion, boolean capitalAtStart) {
        return (result == null) ? new JsonObject()
                : new JsonObject(reformatResultJsonMap(result.getMap(), conversion, capitalAtStart));
    }

    private static boolean isPrimitiveOrWrapperType(Class<?> clazz) throws APICallException {
        try {
            return (clazz != null) && (clazz.isPrimitive() || WRAPPER_TYPES.contains(clazz));
        } catch (IllegalArgumentException | ClassCastException e) {
            throw new APICallException(e);
        }
    }

    private static <T> T convertObject(Class<T> objectClass, JsonObject transformedObject) throws APICallException {
        try {
            return transformedObject.mapTo(objectClass);
        } catch (IllegalArgumentException | ClassCastException e) {
            throw new APICallException(e);
        }
    }

    @SuppressWarnings("unchecked")
    private static <T> T convertPrimitive(Class<T> objectClass, JsonObject transformedObject) throws APICallException {
        try {
            if (transformedObject.fieldNames().size() != 1) {
                throw new IllegalArgumentException(transformedObject.encode());
            }
            String fieldName = transformedObject.fieldNames().iterator().next();

            if (objectClass == String.class) {
                return (T) transformedObject.getString(fieldName);
            }
            if (objectClass == Character.class || objectClass == char.class) {
                String value = transformedObject.getString(fieldName);
                return (T) ((value == null || value.isEmpty()) ? null : value.toCharArray()[0]);
            }
            if (objectClass == Boolean.class || objectClass == boolean.class) {
                Object value = transformedObject.getValue(fieldName);
                if (value instanceof String) {
                    return (T) new Boolean(Boolean.parseBoolean((String) value));
                }
                return (T) transformedObject.getBoolean(fieldName);
            }
            if (objectClass == Double.class || objectClass == double.class || objectClass == Float.class
                    || objectClass == float.class) {
                Object value = transformedObject.getValue(fieldName);
                if (value instanceof String) {
                    return (T) new Double(Double.parseDouble((String) value));
                }
                return (T) transformedObject.getDouble(fieldName);
            }
            if (objectClass == Integer.class || objectClass == int.class || objectClass == Long.class
                    || objectClass == long.class) {
                Object value = transformedObject.getValue(fieldName);
                if (value instanceof String) {
                    return (T) new Long(Long.parseLong((String) value));
                }
                return (T) transformedObject.getLong(fieldName);
            }
            if (objectClass == Short.class || objectClass == short.class || objectClass == Byte.class
                    || objectClass == byte.class) {
                Object value = transformedObject.getValue(fieldName);
                if (value instanceof String) {
                    return (T) new Integer(Integer.parseInt((String) value));
                }
                return (T) transformedObject.getInteger(fieldName);
            }
        } catch (IllegalArgumentException | ClassCastException e) {
            throw new APICallException(e);
        }
        return null;
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
