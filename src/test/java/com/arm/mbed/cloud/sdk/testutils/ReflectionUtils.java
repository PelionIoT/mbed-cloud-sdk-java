package com.arm.mbed.cloud.sdk.testutils;

import java.util.Set;

import org.reflections.Reflections;

public class ReflectionUtils {

    private static final ClassReflectionRegistry reflectionRegistry = new ClassReflectionRegistry();

    public static void init(String packageName) {
        reflectionRegistry.init(packageName);
    }

    public static <T> Set<Class<? extends T>> getClassChildren(Class<T> clazz) {
        return reflectionRegistry.getClassChildren(clazz);

    }

    private static class ClassReflectionRegistry {
        private ClassReflectionInspector inspector;
        private Object lock;

        public ClassReflectionRegistry() {
            super();
            inspector = null;
            lock = new Object();
        }

        public void init(String packageName) {
            if (packageName == null || packageName.isEmpty()) {
                return;
            }
            synchronized (lock) {
                if (inspector == null || inspector.needsReload(packageName)) {
                    inspector = new ClassReflectionInspector(packageName);
                }
            }
            return;

        }

        public <T> Set<Class<? extends T>> getClassChildren(Class<T> clazz) {
            if (clazz == null) {
                return null;
            }
            synchronized (lock) {
                if (inspector == null) {
                    return null;
                }
                return inspector.getClassChildren(clazz);
            }
        }

    }

    private static class ClassReflectionInspector {
        private final String packageName;
        private final Reflections reflection;

        public ClassReflectionInspector(String packageName) {
            super();
            this.packageName = packageName;
            this.reflection = new Reflections(packageName);
        }

        public boolean needsReload(String newPackageName) {
            return !packageName.equals(packageName);
        }

        public <T> Set<Class<? extends T>> getClassChildren(Class<T> clazz) {
            if (clazz == null) {
                return null;
            }
            return reflection.getSubTypesOf(clazz);
        }

        /*
         * (non-Javadoc)
         * 
         * @see java.lang.Object#toString()
         */
        @Override
        public String toString() {
            return "ClassReflectionInspector [packageName=" + packageName + ", reflection=" + reflection + "]";
        }

    }
}
