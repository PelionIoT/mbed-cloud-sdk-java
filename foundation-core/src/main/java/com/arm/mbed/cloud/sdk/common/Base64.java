package com.arm.mbed.cloud.sdk.common;

import java.nio.ByteBuffer;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;

import com.arm.mbed.cloud.sdk.annotations.NonNull;
import com.arm.mbed.cloud.sdk.annotations.Nullable;
import com.arm.mbed.cloud.sdk.annotations.Preamble;

@Preamble(description = "Utility to deal with base64 byte arrays")
public class Base64 {
    public static final String METHOD_GET_ENCODED_ARRAY = "getEncodedArray";
    public static final String METHOD_GET_ENCODED_STRING = "getEncodedString";

    private final byte[] decodedByteArray;

    /**
     * Constructor.
     * 
     * @param unencodedSource
     *            byte array source. The content of this array should be unencoded.
     */
    public Base64(byte[] unencodedSource) {
        super();
        this.decodedByteArray = unencodedSource;
    }

    /**
     * Constructor.
     * 
     * @param unencodedSource
     *            String source. The content of this string should be unencoded.
     */
    public Base64(String unencodedSource) {
        this(unencodedSource == null ? null : unencodedSource.getBytes(StandardCharsets.UTF_8));
    }

    /**
     * Constructor.
     * 
     * @param unencodedSource
     *            buffer. The content of this buffer should be unencoded.
     */
    public Base64(ByteBuffer unencodedSource) {
        this(unencodedSource == null ? null : unencodedSource.array());
    }

    /**
     * Generates a Base64 instance from an encoded byte array.
     * 
     * @param encodedSource
     *            encoded source.
     * @return a Base64 instance
     */
    public static @NonNull Base64 decode(byte[] encodedSource) {
        return new Base64(encodedSource == null ? null
                                                : org.apache.commons.codec.binary.Base64.decodeBase64(encodedSource));
    }

    /**
     * Generates a Base64 instance from an encoded string.
     * 
     * @param encodedSource
     *            encoded source.
     * @return a Base64 instance
     */
    public static @NonNull Base64 decode(String encodedSource) {
        return new Base64(encodedSource == null ? null
                                                : org.apache.commons.codec.binary.Base64.decodeBase64(encodedSource));
    }

    /**
     * Generates a Base64 instance from an encoded buffer.
     * 
     * @param encodedSource
     *            encoded source.
     * @return a Base64 instance
     */
    public static @NonNull Base64 decode(ByteBuffer encodedSource) {
        return decode(encodedSource == null ? (byte[]) null : encodedSource.array());
    }

    /**
     * States whether the underlying buffer is empty or not.
     * 
     * @return true if the buffer is empty; False otherwise.
     */
    public boolean isEmpty() {
        return decodedByteArray == null || decodedByteArray.length == 0;
    }

    /**
     * Gets the unencoded underlying byte array.
     * 
     * @return the byte array.
     */
    public @Nullable byte[] getUnencodedArray() {
        return decodedByteArray;
    }

    /**
     * Gets the unencoded underlying string.
     * 
     * @return the string.
     */
    public @Nullable String getUnencodedString() {
        return decodedByteArray == null ? null : new String(decodedByteArray, StandardCharsets.UTF_8);
    }

    /**
     * Gets the buffer containing the unencoded underlying byte array.
     * 
     * @return a buffer.
     */
    public @Nullable ByteBuffer getUnencodedBuffer() {
        return decodedByteArray == null ? null : ByteBuffer.wrap(decodedByteArray);
    }

    /**
     * Gets the base 64 encoded byte array.
     * <p>
     * Note: the base 64 encoding happens every time this method is called.
     * 
     * @return a byte array.
     */
    public @Nullable byte[] getEncodedArray() {
        return decodedByteArray == null ? null : org.apache.commons.codec.binary.Base64.encodeBase64(decodedByteArray);
    }

    /**
     * Gets a String containing the base 64 encoded characters.
     * <p>
     * Note: the base 64 encoding happens every time this method is called.
     * 
     * @return a string.
     */
    public @Nullable String getEncodedString() {
        return decodedByteArray == null ? null
                                        : org.apache.commons.codec.binary.Base64.encodeBase64String(decodedByteArray);
    }

    /**
     * Gets a buffer containing the base 64 encoded byte array.
     * <p>
     * Note: the base 64 encoding happens every time this method is called.
     * 
     * @return a buffer.
     */
    public @Nullable ByteBuffer getEncodedBuffer() {
        final byte[] encodedByteArray = getEncodedArray();
        return encodedByteArray == null ? null : ByteBuffer.wrap(encodedByteArray);
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + Arrays.hashCode(decodedByteArray);
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (!(obj instanceof Base64)) {
            return false;
        }
        final Base64 other = (Base64) obj;
        if (!other.canEqual(this)) {
            return false;
        }
        if (!Arrays.equals(decodedByteArray, other.decodedByteArray)) {
            return false;
        }
        return true;
    }

    /**
     * Method to ensure {@link #equals(Object)} is correct.
     * <p>
     * Note: see this article: <a href="https://www.artima.com/lejava/articles/equality.html">canEqual()</a>
     *
     * @param other
     *            another object.
     * @return true if the other object is an instance of the class in which canEqual is (re)defined, false otherwise
     */
    protected boolean canEqual(Object other) {
        return other instanceof Base64;
    }
}
