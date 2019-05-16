package com.arm.mbed.cloud.sdk.testserver.internal.model;

import java.lang.reflect.Modifier;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.List;
import java.util.Map;

import com.arm.mbed.cloud.sdk.common.ApiUtils;
import com.arm.mbed.cloud.sdk.testutils.APICallException;
import com.arm.mbed.cloud.sdk.testutils.Serializer;

public class APIMethodArgument {
    private String name;
    private String type;
    private String contentType;
    private String defaultValue;

    public APIMethodArgument(String name, String type, String contentType, String defaultValue) {
        super();
        setName(name);
        setType(type);
        setContentType(contentType);
        setDefaultValue(defaultValue);
    }

    public APIMethodArgument(String name, Class<?> typeClass, Class<?> contentTypeClass, String defaultValue) {
        super();
        setName(name);
        setDefaultValue(defaultValue);
        determineType(typeClass);
        determineContentType(contentTypeClass);
    }

    public APIMethodArgument(Class<?> typeClass, Class<?> contentTypeClass) {
        this(null, typeClass, contentTypeClass, null);
    }

    public APIMethodArgument() {
        this(null, null);
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

    /**
     * @return the contentType
     */
    public String getContentType() {
        return contentType;
    }

    /**
     * @param contentType
     *            the contentType to set
     */
    public void setContentType(String contentType) {
        this.contentType = contentType;
    }

    /*
     * (non-Javadoc)
     * 
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        return "APIMethodArgument [name=" + name + ", type=" + type + ", contentType=" + contentType + ", defaultValue="
               + defaultValue + "]";
    }

    public Class<?> retrieveTypeClass() {
        return retrieveClassFromName(type);
    }

    public Class<?> retrieveContentTypeClass() {
        return retrieveClassFromName(contentType);
    }

    public void determineType(@SuppressWarnings("hiding") Class<?> type) {
        this.type = (type == null) ? null : type.getName();
    }

    public void determineContentType(@SuppressWarnings("hiding") Class<?> type) {
        this.contentType = (type == null) ? null : type.getName();
    }

    public Class<?> determineClass() throws ClassNotFoundException {
        return determineClassFromName(type);
    }

    public Class<?> determineContentClass() throws ClassNotFoundException {
        return determineClassFromName(contentType);
    }

    public <T> Object determineValue(Class<T> clazz, Class<?> contentClass,
                                     Map<String, Object> fields) throws APICallException {
        if (clazz == null || Void.class.isAssignableFrom(clazz)) {
            return null;
        }
        // If the value of an argument has not been specified and there is a default value specified, then the default
        // value is
        // considered.
        if (fields == null || fields.isEmpty()) {
            if (defaultValue == null) {
                return null;
            }
            fields = new HashMap<>(1);
            String fieldName = ApiUtils.convertCamelToSnake(name);
            fields.put((fieldName == null) ? "" : fieldName, defaultValue.trim());
        }
        return convertParametersToObject(clazz, contentClass, fields);
    }

    private <T> Object convertParametersToObject(Class<T> clazz, Class<?> contentClass,
                                                 Map<String, Object> fields) throws APICallException {
        return (List.class.isAssignableFrom(clazz)) ? Serializer.convertParametersToListObject(fields, contentClass)
                                                    : clazz == Map.class ? Serializer.convertParametersToMapObject(fields,
                                                                                                                   contentClass)
                                                                         : (Modifier.isAbstract(clazz.getModifiers())
                                                                            && !clazz.isPrimitive()) ? Serializer.convertParametersToObjectFromAbstractClasses(fields,
                                                                                                                                                               clazz)
                                                                                                     : Serializer.convertParametersToObject(fields,
                                                                                                                                            clazz);
    }

    public <T> Object determineValue(Class<T> clazz, String fields) throws APICallException {
        if (clazz == null || Void.class.isAssignableFrom(clazz) || fields == null || fields.isEmpty()) {
            return null;
        }
        return Serializer.convertStringToObject(fields, clazz);
    }

    private Class<?> determineClassFromName(String element) throws ClassNotFoundException {
        if (element == null) {
            return null;
        }
        Class<?> primitiveType = PrimitiveTypesHolder.Instance.getMappedValue(element);
        return (primitiveType != null) ? primitiveType : Class.forName(element);
    }

    private Class<?> retrieveClassFromName(String typeName) {
        if (typeName == null) {
            return null;
        }
        try {
            return Class.forName(typeName);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            return null;
        }
    }

    private static class PrimitiveTypesHolder {
        public static final PrimitiveTypes Instance = new PrimitiveTypes();
    }

    private static class PrimitiveTypes {

        private final Map<String, Class<?>> mapping;

        public PrimitiveTypes() {
            super();
            mapping = new Hashtable<>(9);
            mapping.put("int", Integer.TYPE);
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
