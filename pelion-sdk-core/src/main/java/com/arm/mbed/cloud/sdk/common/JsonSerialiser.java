package com.arm.mbed.cloud.sdk.common;

import java.io.Reader;

import com.arm.mbed.cloud.sdk.annotations.NonNull;
import com.arm.mbed.cloud.sdk.annotations.Nullable;
import com.arm.mbed.cloud.sdk.annotations.Preamble;
import com.google.gson.Gson;

@Preamble(description = "JSON serialisation/deserialisation wrapper")
public class JsonSerialiser {
    // The implementation of choice is gson rather than Jackson because retrofit2 which is used as web client in the SDK
    // uses this implementation.
    private final Gson gson;

    /**
     * Constructor.
     */
    public JsonSerialiser() {
        gson = new Gson();
    }

    /**
     * This method serialises the specified object into its equivalent JSON String representation.
     *
     * @param obj
     *            the object to serialise into JSON string representation
     * @return JSON string representation of {@code obj}.
     */
    public @NonNull String toJson(@Nullable Object obj) {
        return gson.toJson(obj);
    }

    /**
     * This method deserialises specified JSON, read from the specified reader into an object of the specified class.
     *
     * @param <T>
     *            the type of the desired object
     * @param reader
     *            the reader producing the Json from which the object is to be deserialised.
     * @param clazz
     *            the class of T
     * @return a deserialised object of type T.
     *
     */
    public @Nullable <T> T fromJson(@NonNull Reader reader, @NonNull Class<T> clazz) {
        return gson.fromJson(reader, clazz);
    }

    /**
     * This method deserialises specified JSON string into an object of the specified class.
     *
     * @param <T>
     *            the type of the desired object
     * @param jsonString
     *            the string from which the object is to be deserialised
     * @param clazz
     *            the class of T
     * @return a deserialised object of type T.
     */
    public @Nullable <T> T fromJson(@Nullable String jsonString, @NonNull Class<T> clazz) {
        return gson.fromJson(jsonString, clazz);
    }
}
