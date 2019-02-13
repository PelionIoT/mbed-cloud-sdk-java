package com.arm.mbed.cloud.sdk.testserver.internal.model;

import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import com.arm.mbed.cloud.sdk.common.ConnectionOptions;

public abstract class AbstractTestedItem implements TestedItem {
    protected String name;
    protected String simpleName;
    protected Object instance;
    protected Map<String, List<APIMethod>> methods;

    public AbstractTestedItem(String name, String simpleName, Map<String, List<APIMethod>> methods) {
        super();
        setName(name);
        setSimpleName(simpleName);
        setMethods(methods);
        setInstance(null);
    }

    @Override
    public void copy(TestedItem item) {
        if (item == null) {
            return;
        }
        setName(item.getName());
        setSimpleName(item.getSimpleName());
        setMethods(item.getMethods());
        setInstance(item.getInstance());
    }

    public AbstractTestedItem(String name, String simpleName) {
        this(name, simpleName, null);
    }

    public AbstractTestedItem(String name) {
        this(name, null);
    }

    public AbstractTestedItem() {
        this(null);
    }

    /*
     * (non-Javadoc)
     * 
     * @see com.arm.mbed.cloud.sdk.testserver.internal.model.TestedItem#getName()
     */
    @Override
    public String getName() {
        return name;
    }

    /*
     * (non-Javadoc)
     * 
     * @see com.arm.mbed.cloud.sdk.testserver.internal.model.TestedItem#setName(java.lang.String)
     */
    @Override
    public void setName(String name) {
        this.name = name;
    }

    /*
     * (non-Javadoc)
     * 
     * @see com.arm.mbed.cloud.sdk.testserver.internal.model.TestedItem#getSimpleName()
     */
    @Override
    public String getSimpleName() {
        return simpleName;
    }

    /*
     * (non-Javadoc)
     * 
     * @see com.arm.mbed.cloud.sdk.testserver.internal.model.TestedItem#setSimpleName(java.lang.String)
     */
    @Override
    public void setSimpleName(String simpleName) {
        this.simpleName = simpleName;
    }

    /*
     * (non-Javadoc)
     * 
     * @see com.arm.mbed.cloud.sdk.testserver.internal.model.TestedItem#getMethods()
     */
    @Override
    public Map<String, List<APIMethod>> getMethods() {
        return methods;
    }

    /*
     * (non-Javadoc)
     * 
     * @see com.arm.mbed.cloud.sdk.testserver.internal.model.TestedItem#setMethods(java.util.Map)
     */
    @Override
    public void setMethods(Map<String, List<APIMethod>> methods) {
        this.methods = methods;
    }

    /*
     * (non-Javadoc)
     * 
     * @see com.arm.mbed.cloud.sdk.testserver.internal.model.TestedItem#getInstance()
     */
    @Override
    public Object getInstance() {
        return instance;
    }

    /*
     * (non-Javadoc)
     * 
     * @see com.arm.mbed.cloud.sdk.testserver.internal.model.TestedItem#setInstance(java.lang.Object)
     */
    @Override
    public void setInstance(Object instance) {
        this.instance = instance;
    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * com.arm.mbed.cloud.sdk.testserver.internal.model.TestedItem#addMethod(com.arm.mbed.cloud.sdk.testserver.internal.
     * model.APIMethod)
     */
    @Override
    public void addMethod(APIMethod method) {
        if (method == null) {
            return;
        }
        if (methods == null) {
            methods = new LinkedHashMap<>();
        }
        List<APIMethod> methodDescriptions = methods.get(method.getName());
        if (methodDescriptions == null) {
            methodDescriptions = new LinkedList<>();
            methods.put(method.getName(), methodDescriptions);
        }
        methodDescriptions.add(method);
    }

    /*
     * (non-Javadoc)
     * 
     * @see com.arm.mbed.cloud.sdk.testserver.internal.model.TestedItem#fetchAllMethod()
     */
    @Override
    public List<APIMethod> fetchAllMethod() {
        if (methods == null) {
            return null;
        }
        List<APIMethod> list = methods.values().stream().flatMap(List::stream).collect(Collectors.toList());
        if (list.isEmpty()) {
            return null;
        }
        return list;
    }

    /*
     * (non-Javadoc)
     * 
     * @see com.arm.mbed.cloud.sdk.testserver.internal.model.TestedItem#getMethod(java.lang.String)
     */
    @Override
    public List<APIMethod> getMethod(String methodName) {
        if (methodName == null || methods == null) {
            return null;
        }
        return methods.get(methodName);
    }

    /*
     * (non-Javadoc)
     * 
     * @see com.arm.mbed.cloud.sdk.testserver.internal.model.TestedItem#build(com.arm.mbed.cloud.sdk.common.
     * ConnectionOptions)
     */
    @Override
    public Object build(ConnectionOptions connectionOptions) {
        synchronized (this) {
            if (instance == null) {
                instance = createInstance(connectionOptions);
            }
        }
        return getInstance();
    }

    @Override
    public void setType(TestedItemType type) {
        // Nothing to do

    }

    protected abstract Object createInstance(ConnectionOptions connectionOptions);

}
