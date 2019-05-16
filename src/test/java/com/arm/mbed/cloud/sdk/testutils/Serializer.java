package com.arm.mbed.cloud.sdk.testutils;

import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.time.OffsetDateTime;
import java.util.Arrays;
import java.util.Date;
import java.util.Hashtable;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import io.vertx.core.json.Json;
import io.vertx.core.json.JsonArray;
import io.vertx.core.json.JsonObject;

import com.arm.mbed.cloud.sdk.common.ApiUtils;
import com.arm.mbed.cloud.sdk.common.MbedCloudException;
import com.arm.mbed.cloud.sdk.common.SdkEnum;
import com.arm.mbed.cloud.sdk.common.SdkUtils;
import com.arm.mbed.cloud.sdk.common.SdkUtils.CaseConversion;
import com.arm.mbed.cloud.sdk.common.TranslationUtils;
import com.arm.mbed.cloud.sdk.common.listing.ListResponse;
import com.arm.mbed.cloud.sdk.common.listing.filtering.FilterMarshaller;
import com.arm.mbed.cloud.sdk.common.listing.filtering.Filters;
import com.arm.mbed.cloud.sdk.common.model.DataFile;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;
import com.fasterxml.jackson.databind.module.SimpleModule;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;

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
        public void serialize(SdkEnum value, JsonGenerator jgen, SerializerProvider provider) throws IOException,
                                                                                              JsonProcessingException {

            jgen.writeString((value == null) ? null : value.getString());

        }
    }

    private static class DateSerializer extends StdSerializer<Date> {
        /**
         * 
         */
        private static final long serialVersionUID = 4811129002272093745L;

        public DateSerializer() {
            this(null);
        }

        public DateSerializer(Class<Date> t) {
            super(t);
        }

        @Override
        public void serialize(Date value, JsonGenerator jgen, SerializerProvider provider) throws IOException {
            jgen.writeString((value == null) ? null : ApiUtils.toUtcTimestamp(value));

        }
    }

    private static class OffsetDateSerializer extends StdSerializer<OffsetDateTime> {

        private static final long serialVersionUID = -478370903130456240L;

        public OffsetDateSerializer() {
            this(null, false);
        }

        protected OffsetDateSerializer(Class<?> t, boolean dummy) {
            super(t, dummy);
        }

        @Override
        public void serialize(OffsetDateTime value, JsonGenerator jgen,
                              SerializerProvider provider) throws IOException {
            long epochMilli = value.toInstant().toEpochMilli();
            Date date = new Date(epochMilli);
            jgen.writeString((value == null) ? null : ApiUtils.toUtcTimestamp(date));

        }
    }

    private static class SDKDateDeserializer extends StdDeserializer<Date> {

        /**
         * 
         */
        private static final long serialVersionUID = -4080497056681306862L;

        protected SDKDateDeserializer(Class<Date> vc) {
            super(vc);
        }

        public SDKDateDeserializer() {
            this(null);
        }

        @Override
        public Date deserialize(JsonParser p, DeserializationContext ctxt) throws IOException, JsonProcessingException {
            try {
                return ApiUtils.convertStringToDate(p.getValueAsString());
            } catch (MbedCloudException e) {
                e.printStackTrace();
                return null;
            }
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
        public Filters deserialize(JsonParser p, DeserializationContext ctxt) throws IOException,
                                                                              JsonProcessingException {
            return FilterMarshaller.fromJson(p.getValueAsString());
        }

    }

    static {
        SimpleModule module = new SimpleModule();
        module.addSerializer(SdkEnum.class, new SDKEnumSerializer());
        module.addSerializer(Date.class, new DateSerializer());
        module.addSerializer(OffsetDateTime.class, new OffsetDateSerializer());
        // module.addSerializer(DateTime.class, new DateTimeSerializer());
        module.addDeserializer(Filters.class, new SDKFiltersDeserializer());
        module.addDeserializer(Date.class, new SDKDateDeserializer());
        // module.addDeserializer(DateTime.class, new SDKDateTimeDeserializer());
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

    public static Object deserialiseString(String serialisedObject) {
        if (serialisedObject == null || serialisedObject.isEmpty()) {
            return serialisedObject;
        }
        try {
            return new JsonObject(serialisedObject);
        } catch (@SuppressWarnings("unused") Exception e) {
            try {
                return new JsonArray(serialisedObject);
            } catch (@SuppressWarnings("unused") Exception e1) {
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

    private static JsonObject retrieveJsonObject(Object result) {
        if (result instanceof Map) {
            result = performWorkaroundForMapSerialisation(result);
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
        JsonObject jsonObject = (reformat) ? reformatJsonObject(retrieveJsonObject(result),
                                                                CaseConversion.CAMEL_TO_SNAKE, false)
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
                    array.add((reformat) ? reformatJsonObject(retrieveJsonObject(object), CaseConversion.CAMEL_TO_SNAKE,
                                                              false)
                                         : retrieveJsonObject(object));
                }
            } catch (APICallException e) {
                e.printStackTrace();
            }
        }
        return array;
    }

    public static <T> T convertStringToObject(String serializedObject, Class<T> objectClass) throws APICallException {
        if (objectClass == null) {
            return null;
        }
        if (Utils.isPrimitiveOrWrapperType(objectClass)) {
            return convertStringToPrimitive(objectClass, serializedObject);
        }
        if (Utils.isDateType(objectClass)) {
            return convertStringToDate(objectClass, serializedObject);
        }
        if (serializedObject == null || serializedObject.isEmpty()) {
            return null;
        }
        JsonObject jsonObject = new JsonObject(serializedObject);
        JsonObject transformedObject = reformatJsonObject(jsonObject, CaseConversion.SNAKE_TO_CAMEL, false);
        return createObjectInstance(objectClass, transformedObject);
    }

    public static <T> T convertParametersToObject(Map<String, Object> objectFields,
                                                  Class<T> objectClass) throws APICallException {
        if (objectClass == null || objectFields == null || objectFields.isEmpty()) {
            return null;
        }
        JsonObject jsonObject = new JsonObject(objectFields);
        JsonObject transformedObject = reformatJsonObject(jsonObject, CaseConversion.SNAKE_TO_CAMEL, false);
        return createObjectInstance(objectClass, transformedObject);
    }

    @SuppressWarnings("unchecked")
    public static <T> List<T> convertParametersToListObject(Map<String, Object> objectFields,
                                                            Class<T> contentClass) throws APICallException {
        if (objectFields == null || contentClass == null || objectFields.isEmpty() || objectFields.size() > 1) {
            return null;
        }
        List<T> value = new LinkedList<>();
        try {
            Object parameterValue = objectFields.get(objectFields.keySet().stream().findFirst().orElse(null));
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

    @SuppressWarnings("unchecked")
    public static <T> Map<String, T> convertParametersToMapObject(Map<String, Object> objectFields,
                                                                  Class<T> contentClass) throws APICallException {
        if (objectFields == null || objectFields.isEmpty()) {
            return null;
        }
        if (contentClass == null || contentClass == Object.class) {
            return (Map<String, T>) objectFields;
        }
        final Map<String, T> value = new LinkedHashMap<>();
        try {
            objectFields.entrySet().forEach(entry -> value.put(entry.getKey(), (T) entry.getValue()));
        } catch (Exception e) {
            throw new APICallException(e);
        }
        return value;
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

    private static <T> T createObjectInstance(Class<T> objectClass,
                                              JsonObject transformedObject) throws APICallException {
        return (Utils.isPrimitiveOrWrapperTypeAndThrow(objectClass)) ? convertPrimitive(objectClass, transformedObject)
                                                                     : Utils.isDateType(objectClass) ? convertDate(objectClass,
                                                                                                                   transformedObject)
                                                                                                     : convertObject(objectClass,
                                                                                                                     transformedObject);
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
                                                  .map(e -> (e instanceof JsonObject
                                                             || e instanceof Map) ? reformatJsonObject((e instanceof JsonObject) ? (JsonObject) e : new JsonObject((Map<String, Object>) e), conversion, capitalAtStart) : e)
                                                  .collect(Collectors.toList()));
    }

    @SuppressWarnings("unchecked")
    private static <T> T convertObject(Class<T> objectClass, JsonObject transformedObject) throws APICallException {
        try {
            if (Map.class.isAssignableFrom(objectClass)) {
                return performWorkaroundForMapDeserialisation(objectClass, transformedObject);
            }
            if (DataFile.class.isAssignableFrom(objectClass)) {
                return (T) convertDataFile(transformedObject);
            }
            return transformedObject.mapTo(objectClass);
        } catch (IllegalArgumentException | ClassCastException e) {
            throw new APICallException(e);
        }
    }

    private static DataFile convertDataFile(JsonObject transformedObject) {
        if (transformedObject == null || transformedObject.isEmpty()) {
            return null;
        }
        try {
            return transformedObject.mapTo(DataFile.class);
        } catch (@SuppressWarnings("unused") Exception e) {
            if (transformedObject.size() > 1) {
                return null;
            }
            final Object value = transformedObject.getMap().values().stream().findFirst().orElse(null);
            if (value instanceof String) {
                return new DataFile((String) value);
            }
            return null;
        }
    }

    @SuppressWarnings({ "unchecked", "rawtypes" })
    private static Object performWorkaroundForMapSerialisation(Object result) {
        // This is a temporary fix to solve the problem raised against Vertx JsonObject
        // https://github.com/eclipse/vert.x/issues/2286
        // The following looks for any extra fields with the Jason annotation JsonProperty (in the current class and
        // all its parents) and adds them to the hashtable.
        Class<?> clazz = result.getClass();
        List<Class<?>> classes = new LinkedList<>();
        while (clazz != null) {
            classes.add(clazz);
            clazz = clazz.getSuperclass();
        }
        Map<String,
            Object> extraFields = classes.stream().map(cls -> Arrays.asList(cls.getDeclaredFields()))
                                         .flatMap(l -> l.stream())
                                         .filter(f -> f.isAnnotationPresent(JsonProperty.class))
                                         .collect(Collectors.toMap(java.lang.reflect.Field::getName, f -> {
                                             f.setAccessible(true);
                                             try {
                                                 return f.get(result);
                                             } catch (@SuppressWarnings("unused") IllegalArgumentException
                                                                                  | IllegalAccessException e) {
                                                 return null;
                                             }
                                         }));
        if (extraFields != null) {
            ((Map) result).putAll(extraFields);
        }
        return result;
    }

    @SuppressWarnings("unchecked")
    private static <T> T performWorkaroundForMapDeserialisation(Class<T> objectClass,
                                                                JsonObject transformedObject) throws APICallException {
        // This is a temporary fix to solve the problem raised against Vertx JsonObject
        // https://github.com/eclipse/vert.x/issues/2286
        // The following goes through all key/value pairs and verifies that the object does not have fields that
        // correspond (i.e key equals field name). If so, it tries to set the field with the value.
        // The following is a bit of a hack and has not been thoroughly tested
        try {
            if (objectClass == Map.class || objectClass == Hashtable.class) {
                return (T) transformedObject.getMap();
            }
            Constructor<T> constructor = objectClass.getConstructor();
            if (constructor == null) {
                throw new APICallException("Cannot find a suitable constructor for class [" + objectClass
                                           + "] which is supposed to be a POJO.");
            }
            T instance = constructor.newInstance();
            List<Class<?>> classes = new LinkedList<>();
            Class<?> clazz = objectClass;
            while (clazz != null) {
                classes.add(clazz);
                clazz = clazz.getSuperclass();
            }

            Map<String,
                Field> fields = classes.stream().map(cls -> Arrays.asList(cls.getDeclaredFields()))
                                       .flatMap(l -> l.stream()).filter(f -> f.isAnnotationPresent(JsonProperty.class))
                                       .collect(Collectors.toMap(java.lang.reflect.Field::getName, f -> {
                                           f.setAccessible(true);
                                           try {
                                               return f;
                                           } catch (@SuppressWarnings("unused") IllegalArgumentException e) {
                                               return null;
                                           }
                                       }));
            ((Map<?, ?>) transformedObject.getMap()).forEach((k, v) -> {
                if (fields.containsKey(k)) {
                    final Field f = fields.get(k);
                    if (f != null) {
                        try {
                            f.set(instance, Serializer.convertStringToObject(String.valueOf(v), f.getType()));
                        } catch (IllegalArgumentException | IllegalAccessException | APICallException e) {
                            e.printStackTrace();
                        }
                    }
                }
            });

            return instance;
        } catch (NoSuchMethodException | SecurityException | InstantiationException | IllegalAccessException
                 | InvocationTargetException e) {
            e.printStackTrace();

        }
        return null;
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

    @SuppressWarnings("unchecked")
    private static <T> T convertStringToDate(Class<T> objectClass, String stringValue) throws APICallException {
        try {
            return (stringValue == null
                    || stringValue.isEmpty()) ? null : (T) TranslationUtils.convertStringToDate(stringValue);
        } catch (IllegalArgumentException | ClassCastException | MbedCloudException e) {
            throw new APICallException(e);
        }
    }

    @SuppressWarnings({ "unchecked", "boxing" })
    private static <T> T convertStringToPrimitive(Class<T> objectClass, String stringValue) throws APICallException {
        try {
            if (objectClass == String.class) {
                return (T) stringValue;
            }
            if (objectClass == Character.class || objectClass == char.class) {
                return (T) ((stringValue == null || stringValue.isEmpty()) ? null : stringValue.toCharArray()[0]);
            }
            if (objectClass == Boolean.class || objectClass == boolean.class) {
                if (stringValue == null || stringValue.isEmpty()) {
                    return (T) new Boolean(false);
                }
                return (T) new Boolean(Boolean.parseBoolean(stringValue));

            }
            if (objectClass == Double.class || objectClass == double.class || objectClass == Float.class
                || objectClass == float.class) {
                if (stringValue == null || stringValue.isEmpty()) {
                    return (T) new Double(0);
                }
                return (T) new Double(Double.parseDouble(stringValue));

            }
            if (objectClass == Integer.class || objectClass == int.class) {
                if (stringValue == null || stringValue.isEmpty()) {
                    return (T) new Integer(0);
                }
                return (T) new Integer(Integer.parseInt(stringValue));

            }
            if (objectClass == Long.class || objectClass == long.class) {
                if (stringValue == null || stringValue.isEmpty()) {
                    return (T) new Long(0);
                }
                return (T) new Long(Long.parseLong(stringValue));

            }
            if (objectClass == Short.class || objectClass == short.class || objectClass == Byte.class
                || objectClass == byte.class) {
                if (stringValue == null || stringValue.isEmpty()) {
                    return (T) new Short((short) 0);
                }
                return (T) new Integer(Integer.parseInt(stringValue));

            }
        } catch (IllegalArgumentException | ClassCastException e) {
            throw new APICallException(e);
        }
        return null;
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
                                                        SdkUtils.getCaseConverter(conversion).convert(k,
                                                                                                      capitalAtStart),
                                                        (v instanceof Map<?,
                                                                          ?>) ? reformatResultJsonMap((Map<String, Object>) v, conversion, capitalAtStart) : (v instanceof List<?>) ? reformatJsonList((List<?>) v, true) : v));
        return formattedResult;
    }
}
