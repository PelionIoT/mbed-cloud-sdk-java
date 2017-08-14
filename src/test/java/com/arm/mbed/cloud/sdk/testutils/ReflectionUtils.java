package com.arm.mbed.cloud.sdk.testutils;

import java.util.Set;

import org.reflections.Reflections;

public class ReflectionUtils {

    private final Reflections reflection;
    private static String previousPackageName = null;
    private static ReflectionUtils INSTANCE = null;

    private ReflectionUtils(String packageName) {
        reflection = new Reflections(packageName);
    }

    public static void init(String packageName) {
        if (packageName != null && !packageName.isEmpty() && previousPackageName != packageName) {
            INSTANCE = new ReflectionUtils(packageName);
            previousPackageName = packageName;
        }
    }

    public static <T> Set<Class<? extends T>> getClassChildren(Class<T> clazz) {
        if (INSTANCE == null) {
            return null;
        }
        return INSTANCE.reflection.getSubTypesOf(clazz);
    }

}
