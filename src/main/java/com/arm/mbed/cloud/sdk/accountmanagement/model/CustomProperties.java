package com.arm.mbed.cloud.sdk.accountmanagement.model;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import com.arm.mbed.cloud.sdk.annotations.Internal;
import com.arm.mbed.cloud.sdk.annotations.Nullable;
import com.arm.mbed.cloud.sdk.annotations.Preamble;
import com.arm.mbed.cloud.sdk.common.JsonSerialiser;
import com.arm.mbed.cloud.sdk.common.SdkModel;

@Preamble(description = "Object representing user's custom properties")
public class CustomProperties implements SdkModel {
    /**
     * Serialisation Id.
     */
    private static final long serialVersionUID = 1917364914377541938L;
    private Map<String, String> rawProperties;
    private final JsonSerialiser jsonMarshaller;

    /**
     * Internal constructor.
     * <p>
     * Note: use {@link #CustomProperties()} instead.
     *
     * @param rawProperties
     *            raw properties
     */
    @Internal
    public CustomProperties(Map<String, String> rawProperties) {
        this(rawProperties, null);
    }

    /**
     * Constructor.
     */
    public CustomProperties() {
        this(null, null);
    }

    /**
     * Constructor using a Json string.
     *
     * @param json
     *            Json string describing the custom properties.
     */
    public CustomProperties(String json) {
        this();
        setFromJsonString(json);
    }

    /**
     * Internal constructor.
     * <p>
     * Note: use {@link #CustomProperties()} instead.
     *
     * @param rawProperties
     *            raw properties
     * @param jsonMarshaller
     *            jsonMarshaller
     */
    @Internal
    public CustomProperties(Map<String, String> rawProperties, JsonSerialiser jsonMarshaller) {
        super();
        this.rawProperties = rawProperties;
        this.jsonMarshaller = jsonMarshaller == null ? new JsonSerialiser() : jsonMarshaller;
    }

    private void initialiseMap() {
        if (isEmpty()) {
            rawProperties = new HashMap<>();
        }
    }

    /**
     * Gets the raw properties.
     *
     * @return the rawProperties
     */
    @Internal
    public Map<String, String> getRawProperties() {
        return rawProperties;
    }

    /**
     * Gets the properties in previously defined format when possible.
     *
     * @return the properties in former format when possible.
     */
    @Deprecated
    public Map<String, Map<String, String>> getPropertiesInFormerFormat() {
        if (isEmpty()) {
            return null;
        }
        final Map<String, Map<String, String>> newMap = new HashMap<>(rawProperties.size());
        for (final Entry<String, String> pair : rawProperties.entrySet()) {
            final Map<String, String> subMap = new HashMap<>();
            try {
                final Map<String, Object> parsedMap = jsonMarshaller.fromJson(pair.getValue(), Map.class);
                for (final Entry<String, Object> subpair : parsedMap.entrySet()) {
                    subMap.put(subpair.getKey(), String.valueOf(subpair.getValue()));
                }
            } catch (Exception exception) {
                subMap.put(pair.getValue(), pair.getValue());
            }
            newMap.put(pair.getKey(), subMap);
        }
        return newMap;
    }

    /**
     * Sets the raw properties.
     *
     * @param rawProperties
     *            the rawProperties to set
     */
    @Internal
    public void setRawProperties(Map<String, String> rawProperties) {
        this.rawProperties = rawProperties;
    }

    /**
     * Gets the raw property.
     *
     * @param key
     *            property key
     * @return corresponding value
     */
    @Internal
    public @Nullable String getRawProperty(String key) {
        return isEmpty() ? null : rawProperties.get(key);
    }

    /**
     * Sets a raw property.
     *
     * @param key
     *            property key
     * @param value
     *            property value as a String (e.g. Json String)
     */
    @Internal
    public void setRawProperty(String key, String value) {
        if (key == null || value == null) {
            return;
        }
        initialiseMap();
        rawProperties.put(key, value);
    }

    /**
     * Gets a property value as an object.
     *
     * @param key
     *            property key
     * @param valueType
     *            type of the value
     * @param <T>
     *            type of the value
     * @return corresponding value
     */
    @SuppressWarnings("unchecked")
    @Internal
    public @Nullable <T> T getProperty(String key, Class<T> valueType) {
        final String raw = getRawProperty(key);
        return raw == null ? null : valueType == String.class ? (T) raw : jsonMarshaller.fromJson(raw, valueType);
    }

    /**
     * Sets a property.
     *
     * @param key
     *            property key.
     * @param value
     *            property value.
     */
    @Internal
    public void setProperty(String key, Object value) {
        if (value instanceof String) {
            setRawProperty(key, (String) value);
            return;
        }
        setRawProperty(key, jsonMarshaller.toJson(value));
    }

    /**
     * Gets properties as an object.
     *
     * @param valueType
     *            type of the object
     * @param <T>
     *            type of the object
     * @return corresponding properties.
     */
    @SuppressWarnings("unchecked")
    public @Nullable <T> T getProperties(Class<T> valueType) {
        if (isEmpty() || valueType == null) {
            return null;
        }
        if (CustomProperties.class.isAssignableFrom(valueType)) {
            return (T) this;
        }

        final Map<String, Object> newMap = new HashMap<>(rawProperties.size());
        for (final Entry<String, String> pair : rawProperties.entrySet()) {
            try {
                newMap.put(pair.getKey(), jsonMarshaller.fromJson(pair.getValue(), Map.class));
            } catch (Exception exception) {

                newMap.put(pair.getKey(), pair.getValue());
            }
        }
        final String serialisedObject = jsonMarshaller.toJson(newMap);
        if (String.class.isAssignableFrom(valueType)) {
            return (T) serialisedObject;
        }
        return serialisedObject == null ? null : jsonMarshaller.fromJson(serialisedObject, valueType);
    }

    /**
     * States whether a property is existing.
     *
     * @param key
     *            property key.
     * @return True if the property is present. False otherwise.
     */
    @Internal
    public boolean hasProperty(String key) {
        if (key == null || isEmpty()) {
            return false;
        }
        return rawProperties.containsKey(key);
    }

    /**
     * Sets the properties from a Json String.
     *
     * @param json
     *            Json string describing the properties.
     */
    public void setFromJsonString(String json) {
        setRawProperties(null);
        if (json == null) {
            return;
        }
        final Map<String, Object> underlyingMap = jsonMarshaller.fromJson(json, Map.class);
        for (final Entry<String, Object> pair : underlyingMap.entrySet()) {
            setProperty(pair.getKey(), pair.getValue());
        }
    }

    /**
     * Sets the properties from a custom object.
     *
     * @param obj
     *            object describing the properties
     */
    public void setFromObject(Object obj) {
        setRawProperties(null);
        if (obj == null) {
            return;
        }
        if (obj instanceof CustomProperties) {
            setRawProperties(((CustomProperties) obj).getRawProperties());
            return;
        }
        if (obj instanceof String) {
            setFromJsonString(obj.toString());
            return;
        }
        setFromJsonString(jsonMarshaller.toJson(obj));
    }

    /**
     * Sets the properties from a custom object.
     * <p>
     * Note: Similar to {@link #setFromObject(Object)}
     *
     * @param obj
     *            object describing the properties
     * @return this properties
     */
    public CustomProperties fromObject(Object obj) {
        setFromObject(obj);
        return this;
    }

    /**
     * Generates the custom properties from a custom object
     *
     * @param obj
     *            object describing the properties
     * @return corresponding custom properties
     */
    public static CustomProperties from(Object obj) {
        return new CustomProperties().fromObject(obj);
    }

    /**
     * States whether there are some properties set.
     *
     * @return true if no properties were set. False otherwise.
     */
    public boolean isEmpty() {
        return rawProperties == null || rawProperties.isEmpty();
    }

    /*
     * (non-Javadoc)
     *
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        return "CustomProperties [rawProperties=" + rawProperties + "]";
    }

    @Override
    public CustomProperties clone() {
        return new CustomProperties(rawProperties, jsonMarshaller);
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
        result = prime * result + ((rawProperties == null) ? 0 : rawProperties.hashCode());
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
        if (getClass() != obj.getClass()) {
            return false;
        }
        final CustomProperties other = (CustomProperties) obj;
        if (rawProperties == null) {
            if (other.rawProperties != null) {
                return false;
            }
        } else if (!rawProperties.equals(other.rawProperties)) {
            return false;
        }
        return true;
    }

    @Override
    public boolean isValid() {
        return true;
    }

    @Override
    @Internal
    public String getId() {
        return String.valueOf(hashCode());
    }

}
