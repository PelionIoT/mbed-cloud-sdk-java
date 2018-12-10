package com.arm.pelion.sdk.foundation.generator.lowlevelapis;

import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class LowLevelAPIs {
    private Map<String, LowLevelAPIModule> modules;
    private Map<String, List<LowLevelAPIMethod>> methods;

    public LowLevelAPIs(Map<String, LowLevelAPIModule> modules, Map<String, List<LowLevelAPIMethod>> methods) {
        super();
        setModules(modules);
        setMethods(methods);
    }

    public LowLevelAPIs() {
        this(null, null);
    }

    /**
     * @return the methods
     */
    public Map<String, List<LowLevelAPIMethod>> getMethods() {
        return methods;
    }

    /**
     * @param methods
     *            the methods to set
     */
    public void setMethods(Map<String, List<LowLevelAPIMethod>> methods) {
        this.methods = methods;
    }

    /**
     * @return the modules
     */
    public Map<String, LowLevelAPIModule> getModules() {
        return modules;
    }

    /**
     * @param modules
     *            the modules to set
     */
    public void setModules(Map<String, LowLevelAPIModule> modules) {
        this.modules = modules;
    }

    public LowLevelAPIModule getModule(String moduleSimpleName) {
        if (moduleSimpleName == null || modules == null) {
            return null;
        }
        return modules.get(moduleSimpleName);
    }

    public List<LowLevelAPIMethod> getMethod(String methodName) {
        if (methodName == null || methods == null) {
            return null;
        }
        return methods.get(methodName);
    }

    public LowLevelAPIMethod getFirstMethod(String methodName) {
        final List<LowLevelAPIMethod> methodList = getMethod(methodName);
        return methodList == null ? null : methodList.stream().findFirst().get();
    }

    public Class<?> getModuleClazz(String methodName) {
        List<LowLevelAPIMethod> method = getMethod(methodName);
        return method == null || method.isEmpty() ? null : method.iterator().next().getModuleClazz();
    }

    public Set<String> fetchModuleSet() {
        if (modules == null) {
            return null;
        }
        return modules.keySet();
    }

    public Set<String> fetchMethodSet() {
        if (methods == null) {
            return null;
        }
        return methods.keySet();
    }

    private void addModule(LowLevelAPIModule module) {
        if (module == null) {
            return;
        }
        if (modules == null) {
            modules = new LinkedHashMap<>();
        }
        if (modules.containsKey(module.getSimpleName())) {
            getModule(module.getSimpleName()).merge(module);
        } else {
            modules.put(module.getSimpleName(), module);
        }
    }

    private void addMethod(LowLevelAPIMethod method) {
        if (method == null) {
            return;
        }
        if (methods == null) {
            methods = new LinkedHashMap<>();
        }
        if (methods.containsKey(method.getName())) {
            List<LowLevelAPIMethod> methodsWithSameName = getMethod(method.getName());
            methodsWithSameName.add(method);
        } else {
            methods.put(method.getName(), new LinkedList<>(Arrays.asList(method)));
        }
    }

    public void addLowLevelApi(Method m) throws UnknownAPIException {
        if (m == null) {
            return;
        }
        LowLevelAPIMethod method = new LowLevelAPIMethod(m);
        addMethod(method);
        LowLevelAPIModule module = new LowLevelAPIModule(method.getModuleClass());
        module.addMethod(method);
        addModule(module);

    }

}
