package com.arm.mbed.cloud.sdk.testutils;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.lang.reflect.Parameter;
import java.lang.reflect.ParameterizedType;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Enumeration;
import java.util.LinkedList;
import java.util.List;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;
import java.util.stream.Collectors;

import io.vertx.core.json.JsonObject;

import com.arm.mbed.cloud.Sdk;
import com.arm.mbed.cloud.sdk.annotations.API;
import com.arm.mbed.cloud.sdk.annotations.Daemon;
import com.arm.mbed.cloud.sdk.annotations.DefaultValue;
import com.arm.mbed.cloud.sdk.annotations.Module;
import com.arm.mbed.cloud.sdk.annotations.Preamble;
import com.arm.mbed.cloud.sdk.common.SdkModel;
import com.arm.mbed.cloud.sdk.common.dao.DaoProvider;
import com.arm.mbed.cloud.sdk.common.dao.ModelDao;
import com.arm.mbed.cloud.sdk.testserver.internal.model.APIMethod;
import com.arm.mbed.cloud.sdk.testserver.internal.model.APIMethodArgument;
import com.arm.mbed.cloud.sdk.testserver.internal.model.APIModule;
import com.arm.mbed.cloud.sdk.testserver.internal.model.DaemonControl;
import com.arm.mbed.cloud.sdk.testserver.internal.model.Entity;
import com.arm.mbed.cloud.sdk.testserver.internal.model.SdkDefinition;

import ru.vyarus.java.generics.resolver.GenericsResolver;
import ru.vyarus.java.generics.resolver.context.GenericsContext;
import ru.vyarus.java.generics.resolver.context.MethodGenericsContext;

@Preamble(description = "Generator of an SDK API mapping. i.e. list of all APIs present in the SDK")
public class APIMappingGenerator {

    private static final String JAVA_SDK_PACKAGE = "com.arm.mbed.cloud";

    /**
     * Obtain a description of the APIs present in the SDK
     * 
     * @return APIs description
     */
    public static SdkDefinition getSDK() {
        APIMappingGenerator generator = new APIMappingGenerator();
        return generator.retrieveSDK();
    }

    public SdkDefinition retrieveSDK() {
        SdkDefinition sdk = new SdkDefinition(JAVA_SDK_PACKAGE);
        List<Class<?>> classes = getClassesContainedInPackage(JAVA_SDK_PACKAGE);
        for (Class<?> clazz : classes) {
            sdk.addItem(recordAPIModule(clazz));
            sdk.addItem(recordEntity(clazz));
            sdk.addItem(recordSdk(clazz));
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
        final GenericsContext context = GenericsResolver.resolve(clazz);
        for (Method method : determinePublicMethods(clazz)) {
            module.addMethod(recordAPIMethod(method, context, true));
        }
        return module;
    }

    private com.arm.mbed.cloud.sdk.testserver.internal.model.Sdk recordSdk(Class<?> clazz) {
        if (clazz == null || !clazz.isAnnotationPresent(Module.class) || !clazz.isAssignableFrom(Sdk.class)) {
            return null;
        }
        com.arm.mbed.cloud.sdk.testserver.internal.model.Sdk sdk = new com.arm.mbed.cloud.sdk.testserver.internal.model.Sdk(clazz.getName(),
                                                                                                                            clazz.getSimpleName());
        final GenericsContext context = GenericsResolver.resolve(clazz);
        for (Method method : determinePublicMethods(clazz)) {
            sdk.addMethod(recordAPIMethod(method, context, true));
        }
        return sdk;
    }

    private Entity recordEntity(Class<?> clazz) {
        if (clazz == null || !ModelDao.class.isAssignableFrom(clazz) || Modifier.isAbstract(clazz.getModifiers())) {
            return null;
        }
        Class<?> daoClass = clazz;
        while (!daoClass.equals(Object.class)
               && !ParameterizedType.class.isAssignableFrom(daoClass.getGenericSuperclass().getClass())) {
            daoClass = daoClass.getSuperclass();
        }
        Class<?> modelType = (Class<?>) ((ParameterizedType) daoClass.getGenericSuperclass()).getActualTypeArguments()[0];
        @SuppressWarnings("unchecked")
        Class<?> listEntity = DaoProvider.getCorrespondingListDao((Class<SdkModel>) modelType);
        Entity entity = new Entity(listEntity == null ? clazz.getName() : listEntity.getName(),
                                   modelType.getSimpleName());
        final GenericsContext context = GenericsResolver.resolve(clazz);
        for (Method method : determinePublicMethods(clazz)) {
            APIMethod apiMethod = recordAPIMethod(method, context, false);
            if (apiMethod != null) {
                apiMethod.setSubMethod(APIMethod.getCorrespondingDao());
                entity.addMethod(apiMethod);
            }
        }
        if (listEntity != null) {
            final GenericsContext listContext = GenericsResolver.resolve(listEntity);
            for (Method method : listEntity.getMethods()) {
                entity.addMethod(recordAPIMethod(method, listContext, false));
            }
        }
        // TODO add list
        return entity;
    }

    private List<Method> determinePublicMethods(Class<?> clazz) {
        // getMethods() does not work here because we only want the concrete public methods defined in the class and not
        // the ones defined in the interfaces.
        // Class<?> currentClazz = clazz;
        List<Method> methods = new ArrayList<Method>(Arrays.asList(clazz.getMethods()));// new LinkedList<>();
        // while (currentClazz != Object.class) {
        // methods.addAll(Arrays.asList(currentClazz.getDeclaredMethods()));
        // currentClazz = currentClazz.getSuperclass();
        // }
        return methods.stream().filter(m -> (!(m.isSynthetic() || Modifier.isAbstract(m.getModifiers()))
                                             && Modifier.isPublic(m.getModifiers())))
                      .collect(Collectors.toList());
    }

    private APIMethod recordAPIMethod(Method method, GenericsContext context, boolean onlyAnnotatedMethod) {
        if (method == null || (onlyAnnotatedMethod && !method.isAnnotationPresent(API.class))) {
            return null;
        }
        APIMethod m = new APIMethod(method.getName());
        if (method.isAnnotationPresent(Daemon.class)) {
            Daemon daemonControl = method.getAnnotation(Daemon.class);
            if (daemonControl.start()) {
                m.setDaemonControl(DaemonControl.START);
            }
            if (daemonControl.stop()) {
                m.setDaemonControl(DaemonControl.STOP);
            }
            if (daemonControl.shutdown()) {
                m.setDaemonControl(DaemonControl.SHUTDOWN);
            }
        }
        final MethodGenericsContext methodContext = Object.class.equals(method.getDeclaringClass()) ? null
                                                                                                    : context.method(method);
        if (method.getParameterCount() > 0) {
            final List<Class<?>> parameterTypes = methodContext == null ? null : methodContext.resolveParameters();
            Parameter[] parameters = method.getParameters();
            for (int i = 0; i < parameters.length; i++) {
                final Parameter parameter = parameters[i];
                final Class<?> parameterType = parameterTypes == null ? parameter.getType() : parameterTypes.get(i);
                String defaultValue = determineParameterDefaultValue(parameter);
                determineContentType(parameter);
                APIMethodArgument arg = new APIMethodArgument(parameter.getName(), parameterType,
                                                              determineContentType(parameter), defaultValue);
                m.addArgument(arg);
            }
        }
        APIMethodArgument returnArg = new APIMethodArgument(method.getReturnType(), null);
        m.setReturnArgument(returnArg);
        return m;
    }

    private Class<?> determineContentType(Parameter parameter) {
        if (parameter == null || !(List.class.isAssignableFrom(parameter.getType()))) {
            return null;
        }
        try {
            return (Class<?>) ((ParameterizedType) parameter.getParameterizedType()).getActualTypeArguments()[0];
        } catch (Exception e) {
            return null;
        }
    }

    private String determineParameterDefaultValue(Parameter parameter) {
        if (parameter == null) {
            return null;
        }
        DefaultValue defaultValue = parameter.getDeclaredAnnotation(DefaultValue.class);
        return (defaultValue == null) ? null : defaultValue.value();
    }

    private List<Class<?>> getClassesContainedInPackage(String packageName) {
        List<Class<?>> classes = new LinkedList<>();
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
        List<Class<?>> classes = new LinkedList<>();
        String jarFileName = fetchJarName(directory);
        if (jarFileName == null) {
            return classes;
        }
        try {
            @SuppressWarnings("resource")
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
        List<Class<?>> classes = new LinkedList<>();
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
