package com.arm.pelion.sdk.foundation.generator.lowlevelapis;

import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class LowLevelAPIModule {
    private String moduleClassName;

    private Map<String, List<LowLevelAPIMethod>> methods;

    public LowLevelAPIModule(String clazz, Map<String, List<LowLevelAPIMethod>> methods) {
        super();
        setModuleClass(clazz);
        setMethods(methods);
    }

    public LowLevelAPIModule(String clazz) {
        this(clazz, null);
    }

    public LowLevelAPIModule() {
        this(null, null);
    }

    /**
     * @return the name
     */
    public String getName() {
        try {
            return moduleClassName == null ? null : Class.forName(moduleClassName).getName();
        } catch (@SuppressWarnings("unused") ClassNotFoundException exception) {
            return null;
        }
    }

    public Class<?> getClazz() {
        try {
            return moduleClassName == null ? null : Class.forName(moduleClassName);
        } catch (@SuppressWarnings("unused") ClassNotFoundException exception) {
            return null;
        }
    }

    /**
     * @return the simpleName
     */
    public String getSimpleName() {
        try {
            return moduleClassName == null ? null : Class.forName(moduleClassName).getSimpleName();
        } catch (@SuppressWarnings("unused") ClassNotFoundException exception) {
            return null;
        }
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
     * @return the moduleClass
     */
    public String getModuleClass() {
        return moduleClassName;
    }

    public boolean hasMethods() {
        return methods != null && !methods.isEmpty();
    }

    /**
     * @param moduleClass
     *            the moduleClass to set
     */
    public void setModuleClass(String moduleClassName) {
        this.moduleClassName = moduleClassName;
    }

    public void addMethod(LowLevelAPIMethod method) {
        if (method == null) {
            return;
        }
        if (methods == null) {
            methods = new LinkedHashMap<>();
        }
        List<LowLevelAPIMethod> methodDescriptions = methods.get(method.getName());
        if (methodDescriptions == null) {
            methodDescriptions = new LinkedList<>();
            methods.put(method.getName(), methodDescriptions);
        }
        methodDescriptions.add(method);
    }

    public void addMethods(Map<String, List<LowLevelAPIMethod>> otherMethods) {
        if (methods == null) {
            return;
        }
        if (methods == null) {
            methods = new LinkedHashMap<>();
        }
        for (String methodName : otherMethods.keySet()) {
            List<LowLevelAPIMethod> methodDescriptions = methods.get(methodName);
            if (methodDescriptions == null) {
                methodDescriptions = new LinkedList<>();
                methods.put(methodName, methodDescriptions);
            }
            methodDescriptions.addAll(otherMethods.get(methodName));
        }
    }

    public List<LowLevelAPIMethod> fetchAllMethod() {
        if (methods == null) {
            return null;
        }
        List<LowLevelAPIMethod> list = methods.values().stream().flatMap(List::stream).collect(Collectors.toList());
        if (list.isEmpty()) {
            return null;
        }
        return list;
    }

    public List<LowLevelAPIMethod> getMethod(String methodName) {
        if (methodName == null || methods == null) {
            return null;
        }
        return methods.get(methodName);
    }

    public void merge(LowLevelAPIModule module) {
        if (module == null) {
            return;
        }
        if (module.hasMethods()) {
            addMethods(module.getMethods());
        }

    }

    /*
     * (non-Javadoc)
     *
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        return "LowLevelAPIModule [moduleClassName=" + moduleClassName + ", methods=" + methods + "]";
    }

    /*
     * (non-Javadoc)
     *
     * @see java.lang.Object#hashCode()
     */
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((methods == null) ? 0 : methods.hashCode());
        result = prime * result + ((moduleClassName == null) ? 0 : moduleClassName.hashCode());
        return result;
    }

    /*
     * (non-Javadoc)
     *
     * @see java.lang.Object#equals(java.lang.Object)
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (!(obj instanceof LowLevelAPIModule)) {
            return false;
        }
        LowLevelAPIModule other = (LowLevelAPIModule) obj;
        if (methods == null) {
            if (other.methods != null) {
                return false;
            }
        } else if (!methods.equals(other.methods)) {
            return false;
        }
        if (moduleClassName == null) {
            if (other.moduleClassName != null) {
                return false;
            }
        } else if (!moduleClassName.equals(other.moduleClassName)) {
            return false;
        }
        return true;
    }

}
