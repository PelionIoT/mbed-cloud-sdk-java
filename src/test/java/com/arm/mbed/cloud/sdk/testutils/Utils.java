package com.arm.mbed.cloud.sdk.testutils;

import java.util.Arrays;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

public class Utils {

    private Utils() {
        // Nothing to do
    }

    @SuppressWarnings({ "rawtypes", "unchecked" })
    private static final Set<Class> WRAPPER_TYPES = new HashSet(Arrays.asList(Boolean.class, Character.class,
                                                                              Byte.class, Short.class, Integer.class,
                                                                              Long.class, Float.class, Double.class,
                                                                              Void.class, String.class));

    public static boolean isPrimitiveOrWrapperTypeAndThrow(Class<?> clazz) throws APICallException {
        try {
            return (clazz != null) && (clazz.isPrimitive() || WRAPPER_TYPES.contains(clazz));
        } catch (IllegalArgumentException | ClassCastException e) {
            throw new APICallException(e);
        }
    }

    public static boolean isPrimitiveOrWrapperType(Class<?> clazz) {
        try {
            return isPrimitiveOrWrapperTypeAndThrow(clazz);
        } catch (APICallException e) {
            // Nothing to do
            e.printStackTrace();
        }
        return false;
    }

    public static <T> boolean isDateType(Class<T> objectClass) {
        if (objectClass == null) {
            return false;
        }
        return objectClass.isAssignableFrom(Date.class);
    }

}
