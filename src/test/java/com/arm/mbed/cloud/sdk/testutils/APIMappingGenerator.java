package com.arm.mbed.cloud.sdk.testutils;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Method;
import java.lang.reflect.Parameter;
import java.net.URL;
import java.util.Enumeration;
import java.util.LinkedList;
import java.util.List;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;

import com.arm.mbed.cloud.sdk.annotations.API;
import com.arm.mbed.cloud.sdk.annotations.DefaultValue;
import com.arm.mbed.cloud.sdk.annotations.Module;
import com.arm.mbed.cloud.sdk.annotations.Preamble;

import io.vertx.core.json.JsonObject;

@Preamble(description = "Generator of an SDK API mapping. i.e. list of all APIs present in the SDK")
public class APIMappingGenerator {

    private static final String JAVA_SDK_PACKAGE = "com.arm.mbed.cloud.sdk";

    /**
     * Obtain a description of the APIs present in the SDK
     * 
     * @return APIs description
     */
    public static SDK getSDK() {
        APIMappingGenerator generator = new APIMappingGenerator();
        return generator.retrieveSDK();
    }

    public SDK retrieveSDK() {
        SDK sdk = new SDK();
        sdk.setPackageName(JAVA_SDK_PACKAGE);
        List<Class<?>> classes = getClassesContainedInPackage(JAVA_SDK_PACKAGE);
        for (Class<?> clazz : classes) {
            sdk.addModule(recordAPIModule(clazz));
        }
        return sdk;
    }

    public String retrieveSDKAsJSON(boolean pretty) {
        JsonObject json = JsonObject.mapFrom(retrieveSDK());
        return (pretty) ? json.encodePrettily() : json.encode();
    }

    private APIModule recordAPIModule(Class<?> clazz) {
        if (clazz == null || !clazz.isAnnotationPresent(Module.class)) {
            return null;
        }
        APIModule module = new APIModule(clazz.getName(), clazz.getSimpleName());
        for (Method method : clazz.getMethods()) {
            module.addMethod(recordAPIMethod(method));
        }
        return module;
    }

    private APIMethod recordAPIMethod(Method method) {
        if (method == null || !method.isAnnotationPresent(API.class)) {
            return null;
        }
        APIMethod m = new APIMethod(method.getName());
        if (method.getParameterCount() > 0) {
            Parameter[] parameters = method.getParameters();
            for (Parameter parameter : parameters) {
                String defaultValue = determineParameterDefaultValue(parameter);
                APIMethodArgument arg = new APIMethodArgument(parameter.getName(), parameter.getType(), defaultValue);
                m.addArgument(arg);
            }
        }
        APIMethodArgument returnArg = new APIMethodArgument(method.getReturnType());
        m.setReturnArgument(returnArg);
        return m;
    }

    private String determineParameterDefaultValue(Parameter parameter) {
        if (parameter == null) {
            return null;
        }
        DefaultValue defaultValue = parameter.getDeclaredAnnotation(DefaultValue.class);
        return (defaultValue == null) ? null : defaultValue.value();
    }

    private List<Class<?>> getClassesContainedInPackage(String packageName) {
        List<Class<?>> classes = new LinkedList<Class<?>>();
        ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
        if (classLoader == null || packageName == null) {
            return classes;
        }
        String packageFilePath = packageName.replace('.', '/');
        Enumeration<URL> resources;
        try {
            resources = classLoader.getResources(packageFilePath);

        } catch (IOException e) {
            e.printStackTrace();
            return classes;
        }
        while (resources.hasMoreElements()) {
            URL resource = resources.nextElement();
            String resourcePath = resource.getFile();
            if (resourcePath != null) {
                resourcePath = resourcePath.replace("%20", " ");
            }
            File resourceFile = new File(resourcePath);
            // Run from an IDE
            if (resourceFile.exists()) {
                classes.addAll(findClassesInPackageWhenInFileSystem(resourceFile, packageName));
            } else { // Run from a Jar
                classes.addAll(findClassesInPackageWhenInJar(resourceFile, packageFilePath));
            }
        }
        return classes;
    }

    private List<Class<?>> findClassesInPackageWhenInJar(File directory, String packageFilePath) {
        // There is no easy way to list classes present in a jar.
        // https://stackoverflow.com/questions/15720822/how-to-get-names-of-classes-inside-a-jar-file
        List<Class<?>> classes = new LinkedList<Class<?>>();
        String jarFileName = fetchJarName(directory);
        if (jarFileName == null) {
            return classes;
        }
        try {
            JarFile jarFile = new JarFile(jarFileName);
            Enumeration<JarEntry> entries = jarFile.entries();
            while (entries.hasMoreElements()) {
                final JarEntry entry = entries.nextElement();
                String entryName = entry.getName();
                if (entryName.startsWith(packageFilePath) && entryName.endsWith(".class")) {
                    entryName = entryName.substring(0, entryName.length() - 6).replace("/", ".");
                    try {
                        classes.add(Class.forName(entryName));
                    } catch (ClassNotFoundException e) {
                        e.printStackTrace();
                    }
                }
            }
            jarFile.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return classes;
    }

    private String fetchJarName(File directory) {
        if (directory == null) {
            return null;
        }
        String path = directory.toString();
        String scheme = directory.toURI().getScheme();
        if (scheme != null) {
            path = path.replaceAll(scheme + ":", "");
        }
        String[] parts = path.split(".jar");
        if (parts.length != 2) {
            return null;
        }
        String fileName = parts[0] + ".jar";
        return ((new File(fileName).exists()) ? fileName : null);

    }

    private List<Class<?>> findClassesInPackageWhenInFileSystem(File directory, String packageName) {
        List<Class<?>> classes = new LinkedList<Class<?>>();
        if (!directory.exists() || packageName == null) {
            return classes;
        }
        File[] files = directory.listFiles();
        for (File file : files) {

            String javaObjectName = getJavaObjectName(file, packageName);
            if (javaObjectName == null) {
                continue;
            }
            if (file.isDirectory()) {
                classes.addAll(findClassesInPackageWhenInFileSystem(file, javaObjectName));
            } else {
                try {
                    classes.add(Class.forName(javaObjectName));
                } catch (ClassNotFoundException e) {
                    e.printStackTrace();
                }
            }
        }
        return classes;
    }

    private String getJavaObjectName(File file, String packageName) {
        if (file == null || packageName == null) {
            return null;
        }
        StringBuilder nameBuilder = new StringBuilder();
        nameBuilder.append(packageName).append(".");
        if (file.isDirectory()) {
            nameBuilder.append(file.getName());
        } else {
            if (!file.getName().endsWith(".class")) {
                return null;
            }
            nameBuilder.append(file.getName().substring(0, file.getName().length() - 6));
        }
        return nameBuilder.toString();
    }

    public static void main(String[] arg) {
        APIMappingGenerator generator = new APIMappingGenerator();
        System.out.println(generator.retrieveSDKAsJSON(true));
    }
}
