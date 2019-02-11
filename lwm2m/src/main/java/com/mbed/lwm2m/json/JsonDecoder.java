package com.mbed.lwm2m.json;

import java.nio.ByteBuffer;
import java.util.List;

import com.mbed.lwm2m.DecodingException;

public class JsonDecoder {

    public JsonDecoder() {
        super();
    }

    /**
     * Decodes a LWM2M json sequence into a list of LWM2M objects for which the type is not yet know
     *
     * @param buffer
     *            sequence to decode
     * @return List of LWM2M objects (i.e. Object instance, Resource instance, Resource)
     * @throws DecodingException
     *             if an error occurred during parsing
     */
    public static List<?> decodeJson(ByteBuffer buffer) throws DecodingException {
        return null;// TODO
    }

    /**
     * Decodes a LWM2M Json sequence into a list of LWM2M objects of type T
     *
     * @param buffer
     *            sequence to decode
     * @param <T>
     *            type of LWM2M objects to expect
     * @param clazz
     *            type of LWM2M objects (i.e. Object instance, Resource instance, Resource) expected in sequence
     * @return List of LWM2M objects of type T
     * @throws DecodingException
     *             if an error occurred during parsing
     */
    public static <T> List<T> decodeJson(ByteBuffer buffer, Class<T> clazz) throws DecodingException {
        return null; // TODO
    }
}
