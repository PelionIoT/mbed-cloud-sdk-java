package com.arm.mbed.cloud.sdk.testutils;

import java.io.IOException;
import java.util.Arrays;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

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
import com.fasterxml.jackson.annotation.JsonProperty;
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

/**
 * This class performs Json transformation for understanding/translating data coming from or going to the testrunner.
 *
 */
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

    private static class DateTimeSerializer extends StdSerializer<DateTime> {
        /**
         * 
         */
        private static final long serialVersionUID = -5880796497122627333L;
        private static final DateTimeFormatter DATE_ISO_FORMATTER = ISODateTimeFormat.dateTime();

        public DateTimeSerializer() {
            this(null);
        }

        public DateTimeSerializer(Class<DateTime> t) {
            super(t);
        }

        @SuppressWarnings("cast")
        @Override
        public void serialize(DateTime value, JsonGenerator jgen, SerializerProvider provider) throws IOException {
            jgen.writeString(
                    (value == null) ? null : DATE_ISO_FORMATTER.print(((DateTime) value).toDateTime(DateTimeZone.UTC)));

        }

    }

    private static class SDKDateTimeDeserializer extends StdDeserializer<DateTime> {

        /**
         * 
         */
        private static final DateTimeFormatter DATE_ISO_FORMATTER = ISODateTimeFormat.dateTime();
        private static final long serialVersionUID = -1389360632544518602L;

        protected SDKDateTimeDeserializer(Class<DateTime> vc) {
            super(vc);
        }

        public SDKDateTimeDeserializer() {
            this(null);
        }

        @Override
        public DateTime deserialize(JsonParser p, DeserializationContext ctxt)
                throws IOException, JsonProcessingException {
            return DATE_ISO_FORMATTER.parseDateTime(p.getValueAsString());
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
        module.addSerializer(DateTime.class, new DateTimeSerializer());
        module.addDeserializer(Filters.class, new SDKFiltersDeserializer());
        module.addDeserializer(DateTime.class, new SDKDateTimeDeserializer());
        Json.mapper.registerModule(module);
        Json.prettyMapper.registerModule(module);
    }

    /*
     * Change result JSON entries to be snake case as expected by the test system
     */
    // TODO REMOVE WHEN NO LONGER NEEDED
    public static String convertLegacyResultToJson(Object result) {
        if (result == null || result instanceof Void) {
            return "{}";
        }
        if (result instanceof String) {
            return reformatLegacyString((String) result);
        }

        if (Utils.isPrimitiveOrWrapperType(result.getClass())) {
            return String.valueOf(result);
        }

        if (result instanceof List) {
            return reformatJsonList((List<?>) result, true).encode();
        }
        if (result instanceof ListResponse) {
            return reformatJsonListResponse((ListResponse<?>) result, true).encode();
        }
        return reformatJsonObject(retrieveJsonObject(result), CaseConversion.CAMEL_TO_SNAKE, false).encode();
    }

    public static <T> T convertJsonToObject(String jsonString, Class<T> clazz) {
        if (jsonString == null || jsonString.isEmpty()) {
            return null;
        }
        JsonObject object = reformatJsonObject(new JsonObject(jsonString.replace("\'", "\"")),
                CaseConversion.SNAKE_TO_CAMEL, false);
        return object.mapTo(clazz);
    }

    public static Object deserialiseString(String serialisedObject) {
        if (serialisedObject == null || serialisedObject.isEmpty()) {
            return serialisedObject;
        }
        try {
            return new JsonObject(serialisedObject);
        } catch (Exception e) {
            try {
                return new JsonArray(serialisedObject);
            } catch (Exception e1) {
                return serialisedObject;
            }
        }
    }

    public static String convertJsonResultToJsonString(Object result) {
        if (result == null || result instanceof Void) {
            return new JsonObject().encode();
        }
        if (result instanceof String) {
            return reformatString(result.toString());
        }

        if (Utils.isPrimitiveOrWrapperType(result.getClass())) {
            return String.valueOf(result);
        }

        if (result instanceof JsonArray) {
            return ((JsonArray) result).encode();
        }

        return ((JsonObject) result).encode();
    }

    public static Object convertResultToJsonObject(Object result, boolean reformat) {
        if (result == null || result instanceof Void) {
            return null;
        }
        if (result instanceof String || Utils.isPrimitiveOrWrapperType(result.getClass())) {
            return result;
        }

        if (result instanceof List) {
            return reformatJsonList((List<?>) result, reformat);
        }
        if (result instanceof ListResponse) {
            return reformatJsonListResponse((ListResponse<?>) result, reformat);
        }
        return (reformat) ? reformatJsonObject(retrieveJsonObject(result), CaseConversion.CAMEL_TO_SNAKE, false)
                : retrieveJsonObject(result);
    }

    @SuppressWarnings({ "unchecked", "rawtypes" })
    private static JsonObject retrieveJsonObject(Object result) {
        if (result instanceof Map) {
            // This is a temporary fix to solve the problem raised against Vertx JsonObject
            // https://github.com/eclipse/vert.x/issues/2286
            // The following looks for any extra fields with the Jason annotation JsonProperty (in the current class and
            // all its parents) and add them to the hashtable.
            Class<?> clazz = result.getClass();
            List<Class<?>> classes = new LinkedList<>();
            while (clazz != null) {
                classes.add(clazz);
                clazz = clazz.getSuperclass();
            }
            Map<String, Object> extraFields = classes.stream().map(cls -> Arrays.asList(cls.getDeclaredFields()))
                    .flatMap(l -> l.stream()).filter(f -> f.isAnnotationPresent(JsonProperty.class))
                    .collect(Collectors.toMap(java.lang.reflect.Field::getName, f -> {
                        f.setAccessible(true);
                        try {
                            return f.get(result);
                        } catch (IllegalArgumentException | IllegalAccessException e) {
                            return null;
                        }
                    }));
            if (extraFields != null) {
                ((Map) result).putAll(extraFields);
            }
        }
        return JsonObject.mapFrom(result);
    }

    private static String reformatString(String result) {
        result = result.trim();
        if (!result.startsWith("{")) {
            result = "\"" + result + "\"";
        }
        return result;
    }

    // TODO Remove when no longer needed
    private static String reformatLegacyString(String result) {
        result = result.trim();
        if (!result.startsWith("{")) {
            result = "{\"message\":\"" + result + "\"}";
        }
        return result;
    }

    public static JsonObject reformatJsonListResponse(ListResponse<?> result, boolean reformat) {
        List<?> data = result.getData();
        JsonArray array = null;
        if (data != null) {
            array = reformatJsonList(data, reformat);
        }
        result.setData(null);
        JsonObject jsonObject = (reformat)
                ? reformatJsonObject(retrieveJsonObject(result), CaseConversion.CAMEL_TO_SNAKE, false)
                : retrieveJsonObject(result);
        if (array != null) {
            jsonObject.put("data", array);
        }
        return jsonObject;
    }

    public static JsonArray reformatJsonList(List<?> result, boolean reformat) {
        JsonArray array = new JsonArray();
        for (Object object : result) {
            try {
                if (Utils.isPrimitiveOrWrapperTypeAndThrow(object.getClass())) {
                    array.add(object);
                } else {
                    array.add((reformat)
                            ? reformatJsonObject(retrieveJsonObject(object), CaseConversion.CAMEL_TO_SNAKE, false)
                            : retrieveJsonObject(object));
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
            Object parameterValue = objectFields.get(objectFields.keySet().iterator().next());
            JsonArray jsonArray = null;
            if (parameterValue instanceof List<?>) {
                jsonArray = new JsonArray((List<?>) parameterValue);
            } else {
                jsonArray = new JsonArray((String) parameterValue);
            }
            if (Utils.isPrimitiveOrWrapperTypeAndThrow(contentClass)) {
                jsonArray.getList().forEach(o -> value.add((T) o));
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
        return (Utils.isPrimitiveOrWrapperTypeAndThrow(objectClass)) ? convertPrimitive(objectClass, transformedObject)
                : Utils.isDateType(objectClass) ? convertDate(objectClass, transformedObject)
                        : convertObject(objectClass, transformedObject);
    }

    private static JsonObject reformatJsonObject(JsonObject result, CaseConversion conversion, boolean capitalAtStart) {
        return (result == null) ? new JsonObject()
                : new JsonObject(reformatResultJsonMap(result.getMap(), conversion, capitalAtStart));
    }

    @SuppressWarnings("unchecked")
    private static JsonArray reformatJsonArray(JsonArray result, CaseConversion conversion, boolean capitalAtStart) {
        if (result == null || result.isEmpty()) {
            return new JsonArray();
        }

        return new JsonArray((List<Object>) result.getList().stream()
                .map(e -> (e instanceof JsonObject || e instanceof Map) ? reformatJsonObject(
                        (e instanceof JsonObject) ? (JsonObject) e : new JsonObject((Map<String, Object>) e),
                        conversion, capitalAtStart) : e)
                .collect(Collectors.toList()));
    }

    private static <T> T convertObject(Class<T> objectClass, JsonObject transformedObject) throws APICallException {
        try {
            return transformedObject.mapTo(objectClass);
        } catch (IllegalArgumentException | ClassCastException e) {
            throw new APICallException(e);
        }
    }

    @SuppressWarnings("unchecked")
    private static <T> T convertDate(Class<T> objectClass, JsonObject transformedObject) throws APICallException {
        if (transformedObject.fieldNames().size() != 1) {
            throw new IllegalArgumentException(transformedObject.encode());
        }
        String fieldName = transformedObject.fieldNames().iterator().next();
        try {
            return (T) transformedObject.getValue(fieldName);
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
            if (objectClass == Integer.class || objectClass == int.class) {
                Object value = transformedObject.getValue(fieldName);
                if (value instanceof String) {
                    return (T) new Integer(Integer.parseInt((String) value));
                }
                return (T) transformedObject.getInteger(fieldName);
            }
            if (objectClass == Long.class || objectClass == long.class) {
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
        resultMap.forEach((k, v) -> formattedResult.put(
                ApiUtils.getCaseConverter(conversion).convert(k, capitalAtStart),
                (v instanceof Map<?, ?>) ? reformatResultJsonMap((Map<String, Object>) v, conversion, capitalAtStart)
                        : (v instanceof List<?>) ? reformatJsonList((List<?>) v, true) : v));
        return formattedResult;
    }
}
