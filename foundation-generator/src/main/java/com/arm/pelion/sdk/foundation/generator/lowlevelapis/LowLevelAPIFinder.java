package com.arm.pelion.sdk.foundation.generator.lowlevelapis;

import java.lang.reflect.Method;
import java.util.Set;

import org.reflections.Reflections;
import org.reflections.scanners.MethodParameterScanner;
import org.reflections.util.ClasspathHelper;
import org.reflections.util.ConfigurationBuilder;

import retrofit2.Call;

public class LowLevelAPIFinder {

    private final String rootPackageName;
    private final String lowLevelApiModuleRegex;

    /**
     * @param rootPackageName
     * @param lowLevelApiModuleRegex
     */
    public LowLevelAPIFinder(String rootPackageName, String lowLevelApiModuleRegex) {
        super();
        this.rootPackageName = rootPackageName;
        this.lowLevelApiModuleRegex = lowLevelApiModuleRegex;
    }

    /**
     * @return the rootPackageName
     */
    public String getRootPackageName() {
        return rootPackageName;
    }

    /**
     * @return the lowLevelApiModuleRegex
     */
    public String getLowLevelApiModuleRegex() {
        return lowLevelApiModuleRegex;
    }

    public LowLevelAPIs find() {
        Reflections reflections = new Reflections(new ConfigurationBuilder().addUrls(ClasspathHelper.forPackage(rootPackageName))
                                                                            .setScanners(new MethodParameterScanner()));
        Set<Method> methods = reflections.getMethodsReturn(Call.class);
        LowLevelAPIs lowLevelAPIs = new LowLevelAPIs();
        if (methods == null) {
            return lowLevelAPIs;
        }
        methods.stream().filter(m -> m.getDeclaringClass().getSimpleName().matches(lowLevelApiModuleRegex))
               .forEach(m -> {
                   try {
                       lowLevelAPIs.addLowLevelApi(m);
                   } catch (UnknownAPIException exception) {
                       exception.printStackTrace();
                   }
               });
        return lowLevelAPIs;
    }

}
