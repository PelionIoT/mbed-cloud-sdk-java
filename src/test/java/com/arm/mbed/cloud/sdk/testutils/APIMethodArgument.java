package com.arm.mbed.cloud.sdk.testutils;

import java.lang.reflect.Modifier;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;

import com.arm.mbed.cloud.sdk.common.ApiUtils;

public class APIMethodArgument {
    private String name;
    private String type;
    private String defaultValue;

    public APIMethodArgument(String name, String type, String defaultValue) {
        super();
        setName(name);
        setType(type);
        setDefaultValue(defaultValue);
    }

    public APIMethodArgument(String name, Class<?> typeClass, String defaultValue) {
        super();
        setName(name);
        setDefaultValue(defaultValue);
        determineType(typeClass);
    }

    public APIMethodArgument(Class<?> typeClass) {
        this(null, typeClass, null);
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name
     *            the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the type
     */
    public String getType() {
        return type;
    }

    /**
     * @param type
     *            the type to set
     */
    public void setType(String type) {
        this.type = type;
    }

    /**
     * @return the defaultValue
     */
    public String getDefaultValue() {
        return defaultValue;
    }

    /**
     * @param defaultValue
     *            the defaultValue to set
     */
    public void setDefaultValue(String defaultValue) {
        this.defaultValue = defaultValue;
    }

    public Class<?> retrieveTypeClass() {
        if (type == null) {
            return null;
        }
        try {
            return Class.forName(type);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            return null;
        }
    }

    public void determineType(@SuppressWarnings("hiding") Class<?> type) {
        this.type = (type == null) ? null : type.getName();
    }

    public Class<?> determineClass() throws ClassNotFoundException {
        if (type == null) {
            return null;
        }
        Class<?> primitiveType = PrimitiveTypesHolder.Instance.getMappedValue(type);
        return (primitiveType != null) ? primitiveType : Class.forName(type);
    }

    public <T> Object determineValue(Class<T> clazz, Map<String, Object> fields) throws APICallException {
        if (clazz == null || Void.class.isAssignableFrom(clazz)) {
            return null;
        }
        if (fields == null || fields.isEmpty()) {
            if (defaultValue == null) {
                return null;
            }
            fields = new HashMap<>(1);
            String fieldName = ApiUtils.convertCamelToSnake(name);
            fields.put((fieldName == null) ? "" : fieldName, defaultValue.trim());
        }
        return convertParametersToObject(clazz, fields);
    }

    private <T> Object convertParametersToObject(Class<T> clazz, Map<String, Object> fields) throws APICallException {
        return (Modifier.isAbstract(clazz.getModifiers()) && !clazz.isPrimitive())
                ? Serializer.convertParametersToObjectFromAbstractClasses(fields, clazz)
                : Serializer.convertParametersToObject(fields, clazz);
    }

    public <T> Object determineValue(Class<T> clazz, String fields) throws APICallException {
        if (clazz == null || Void.class.isAssignableFrom(clazz) || fields == null || fields.isEmpty()) {
            return null;
        }
        return Serializer.convertStringToObject(fields, clazz);
    }

    private static class PrimitiveTypesHolder {
        public static final PrimitiveTypes Instance = new PrimitiveTypes();
    }

    private static class PrimitiveTypes {

        private final Map<String, Class<?>> mapping;

        public PrimitiveTypes() {
            super();
            mapping = new Hashtable<>(8);
            mapping.put("long", Long.TYPE);
            mapping.put("double", Double.TYPE);
            mapping.put("float", Float.TYPE);
            mapping.put("boolean", Boolean.TYPE);
            mapping.put("char", Character.TYPE);
            mapping.put("byte", Byte.TYPE);
            mapping.put("void", Void.TYPE);
            mapping.put("short", Short.TYPE);

        }

        public Class<?> getMappedValue(String value) {
            if (value == null) {
                return null;
            }
            return mapping.get(value);
        }

    }

}
