package com.arm.mbed.cloud.sdk.testutils;

import java.io.IOException;
import java.util.Arrays;
import java.util.Date;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import org.joda.time.DateTime;
import org.joda.time.DateTimeZone;
import org.joda.time.format.DateTimeFormatter;
import org.joda.time.format.ISODateTimeFormat;

import com.arm.mbed.cloud.sdk.common.ApiUtils;
import com.arm.mbed.cloud.sdk.common.ApiUtils.CaseConversion;
import com.arm.mbed.cloud.sdk.common.SdkEnum;
import com.arm.mbed.cloud.sdk.common.listing.ListResponse;
import com.arm.mbed.cloud.sdk.common.listing.filtering.FilterMarshaller;
import com.arm.mbed.cloud.sdk.common.listing.filtering.Filters;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;
import com.fasterxml.jackson.databind.module.SimpleModule;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;

import io.vertx.core.json.Json;
import io.vertx.core.json.JsonArray;
import io.vertx.core.json.JsonObject;

public class Serializer {
    private static class SDKEnumSerializer extends StdSerializer<SdkEnum> {
        /**
         * 
         */
        private static final long serialVersionUID = 6535238302576144975L;

        public SDKEnumSerializer() {
            this(null);
        }

        public SDKEnumSerializer(Class<SdkEnum> t) {
            super(t);
        }

        @Override
        public void serialize(SdkEnum value, JsonGenerator jgen, SerializerProvider provider)
                throws IOException, JsonProcessingException {

            jgen.writeString((value == null) ? null : value.getString());

        }
    }

    private static class DateSerializer extends StdSerializer<Date> {
        /**
         * 
         */
        private static final long serialVersionUID = 4811129002272093745L;
        private static final DateTimeFormatter DATE_ISO_FORMATTER = ISODateTimeFormat.dateTime();

        public DateSerializer() {
            this(null);
        }

        public DateSerializer(Class<Date> t) {
            super(t);
        }

        @SuppressWarnings("cast")
        @Override
        public void serialize(Date value, JsonGenerator jgen, SerializerProvider provider) throws IOException {
            jgen.writeString((value == null) ? null
                    : DATE_ISO_FORMATTER.print(new DateTime((Date) value).toDateTime(DateTimeZone.UTC)));

        }
    }

    private static class SDKFiltersDeserializer extends StdDeserializer<Filters> {

        /**
         * 
         */
        private static final long serialVersionUID = -1389360632544518602L;

        protected SDKFiltersDeserializer(Class<Filters> vc) {
            super(vc);
        }

        public SDKFiltersDeserializer() {
            this(null);
        }

        @Override
        public Filters deserialize(JsonParser p, DeserializationContext ctxt)
                throws IOException, JsonProcessingException {
            return FilterMarshaller.fromJson(p.getValueAsString());
        }

    }

    static {
        SimpleModule module = new SimpleModule();
        module.addSerializer(SdkEnum.class, new SDKEnumSerializer());
        module.addSerializer(Date.class, new DateSerializer());
        module.addDeserializer(Filters.class, new SDKFiltersDeserializer());
        Json.mapper.registerModule(module);
        Json.prettyMapper.registerModule(module);
    }
    @SuppressWarnings({ "rawtypes", "unchecked" })
    private static final Set<Class> WRAPPER_TYPES = new HashSet(Arrays.asList(Boolean.class, Character.class,
            Byte.class, Short.class, Integer.class, Long.class, Float.class, Double.class, Void.class, String.class));

    /*
     * Change result JSON entries to be snake case as expected by the test system
     */
    public static String convertResultToJson(Object result) {
        return (result == null || result instanceof Void) ? "{}"
                : (result instanceof String) ? reformatString((String) result)
                        : (result instanceof List) ? reformatJsonList((List<?>) result).encode()
                                : (result instanceof ListResponse)
                                        ? reformatJsonListResponse((ListResponse<?>) result).encode()
                                        : reformatJsonObject(JsonObject.mapFrom(result), CaseConversion.CAMEL_TO_SNAKE,
                                                false).encode();
    }

    private static String reformatString(String result) {
        result = result.trim();
        if (!result.startsWith("{")) {
            result = "{\"message\":\"" + result + "\"}";
        }
        return result;
    }

    public static JsonObject reformatJsonListResponse(ListResponse<?> result) {
        List<?> data = result.getData();
        JsonArray array = null;
        if (data != null) {
            array = reformatJsonList(data);
        }
        result.setData(null);
        JsonObject jsonObject = reformatJsonObject(JsonObject.mapFrom(result), CaseConversion.CAMEL_TO_SNAKE, false);
        if (array != null) {
            jsonObject.put("data", array);
        }
        return jsonObject;
    }

    public static JsonArray reformatJsonList(List<?> result) {
        JsonArray array = new JsonArray();
        for (Object object : result) {
            try {
                if (isPrimitiveOrWrapperType(object.getClass())) {
                    array.add(object);
                } else {
                    array.add(reformatJsonObject(JsonObject.mapFrom(object), CaseConversion.CAMEL_TO_SNAKE, false));
                }
            } catch (APICallException e) {
                e.printStackTrace();
            }
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

    @SuppressWarnings("unchecked")
    public static <T> List<T> convertParametersToListObject(Map<String, Object> objectFields, Class<T> contentClass)
            throws APICallException {
        if (objectFields == null || contentClass == null || objectFields.isEmpty() || objectFields.size() > 1) {
            return null;
        }
        List<T> value = new LinkedList<>();
        try {
            JsonArray jsonArray = new JsonArray((String) objectFields.get(objectFields.keySet().iterator().next()));
            if (isPrimitiveOrWrapperType(contentClass)) {
                for (Object obj : jsonArray.getList()) {
                    value.add((T) obj);
                }
            } else {
                JsonArray transformedObject = reformatJsonArray(jsonArray, CaseConversion.SNAKE_TO_CAMEL, false);
                for (Object obj : transformedObject.getList()) {
                    value.add(createObjectInstance(contentClass, (JsonObject) obj));
                }
            }
        } catch (Exception e) {
            throw new APICallException(e);
        }
        return value;// createObjectInstance(objectClass, transformedObject);
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

    private static JsonArray reformatJsonArray(JsonArray result, CaseConversion conversion, boolean capitalAtStart) {
        if (result == null || result.isEmpty()) {
            return new JsonArray();
        }
        List<Object> reformatedList = new LinkedList<>();
        for (Object obj : result.getList()) {
            if (obj instanceof JsonObject || obj instanceof Map) {
                @SuppressWarnings("unchecked")
                JsonObject jsonObject = (obj instanceof JsonObject) ? (JsonObject) obj
                        : new JsonObject((Map<String, Object>) obj);
                reformatedList.add(reformatJsonObject(jsonObject, conversion, capitalAtStart));
            } else {
                reformatedList.add(obj);
            }
        }
        return new JsonArray(reformatedList);

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

    @SuppressWarnings({ "unchecked", "boxing" })
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
        Map<String, Object> formattedResult = new LinkedHashMap<>();
        for (Entry<String, Object> entry : resultMap.entrySet()) {
            Object value = entry.getValue();

            formattedResult.put(ApiUtils.getCaseConverter(conversion).convert(entry.getKey(), capitalAtStart),
                    (value instanceof Map<?, ?>)
                            ? reformatResultJsonMap((Map<String, Object>) value, conversion, capitalAtStart)
                            : (value instanceof List<?>) ? reformatJsonList((List<?>) value) : value);
        }
        return formattedResult;
    }

}
