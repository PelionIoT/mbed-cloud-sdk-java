package com.arm.pelion.sdk.foundation.generator.lowlevelapis;

import java.lang.reflect.Field;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.Hashtable;
import java.util.Map;

import io.swagger.annotations.ApiModel;

public class LowLevelAPIMethodArgument {
    private String name;
    private String type;
    private String contentType;

    public LowLevelAPIMethodArgument(String name, Class<?> typeClass, Type type2) {
        super();
        setName(name);
        determineType(typeClass);
        determineContent(typeClass, type2);
    }

    public LowLevelAPIMethodArgument() {
        this(null, null, null);
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
        return "APIMethodArgument [name=" + name + ", type=" + type + ", contentType=" + contentType + "]";
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

    public void determineContent(Class<?> argClass, @SuppressWarnings("hiding") Type type) {
        this.contentType = type == null || !(type instanceof ParameterizedType)
                           || ((ParameterizedType) type).getActualTypeArguments() == null ? null
                                                                                          : ((ParameterizedType) type).getActualTypeArguments()[0].getTypeName();
        if (contentType == null) {
            contentType = determinePageContentType(argClass);
        }

    }

    protected String determinePageContentType(Class<?> argClass) {
        try {
            if (argClass.getDeclaredField(LIST_RESPONSE_LIST_FIELD()) != null) {
                Field dataField = argClass.getDeclaredField(LIST_RESPONSE_LIST_FIELD());
                return ((ParameterizedType) dataField.getGenericType()).getActualTypeArguments()[0].getTypeName();
            }
        } catch (@SuppressWarnings("unused") Exception exception) {
            // Nothing to do
        }
        return null;
    }

    protected String LIST_RESPONSE_LIST_FIELD() {
        return "data";
    }

    public boolean isOpenApiModel() {
        Class<?> clazz;
        try {
            clazz = determineClass();
        } catch (@SuppressWarnings("unused") ClassNotFoundException exception) {
            return false;
        }
        return isOpenApiModel(clazz);
    }

    public static boolean isOpenApiModel(Class<?> clazz) {
        return clazz == null ? false
                             : clazz.isAnnotationPresent(ApiModel.class)
                               || (clazz.getPackage() != null && clazz.getPackage().getName().contains(".model"));
        // TODO ensure all low level swagger models have the annotation rather than looking at the package.
    }

    public Class<?> determineClass() throws ClassNotFoundException {
        return determineClassFromName(type);
    }

    public Class<?> determineContentClass() throws ClassNotFoundException {
        return determineClassFromName(contentType);
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

    /*
     * (non-Javadoc)
     *
     * @see java.lang.Object#hashCode()
     */
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((contentType == null) ? 0 : contentType.hashCode());
        result = prime * result + ((name == null) ? 0 : name.hashCode());
        result = prime * result + ((type == null) ? 0 : type.hashCode());
        return result;
    }

    /*
     * (non-Javadoc)
     *
     * @see java.lang.Object#equals(java.lang.Object)
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (!(obj instanceof LowLevelAPIMethodArgument)) {
            return false;
        }
        LowLevelAPIMethodArgument other = (LowLevelAPIMethodArgument) obj;
        if (contentType == null) {
            if (other.contentType != null) {
                return false;
            }
        } else if (!contentType.equals(other.contentType)) {
            return false;
        }
        if (name == null) {
            if (other.name != null) {
                return false;
            }
        } else if (!name.equals(other.name)) {
            return false;
        }
        if (type == null) {
            if (other.type != null) {
                return false;
            }
        } else if (!type.equals(other.type)) {
            return false;
        }
        return true;
    }

}
