package com.arm.mbed.cloud.sdk.testserver.internal.model;

import java.util.List;
import java.util.Map;

import com.arm.mbed.cloud.sdk.common.ConnectionOptions;

public interface TestedItem {

    /**
     * @return the name
     */
    String getName();

    /**
     * @param name
     *            the name to set
     */
    void setName(String name);

    /**
     * @return the simpleName
     */
    String getSimpleName();

    /**
     * @param simpleName
     *            the simpleName to set
     */
    void setSimpleName(String simpleName);

    /**
     * @return the methods
     */
    Map<String, List<APIMethod>> getMethods();

    /**
     * @param methods
     *            the methods to set
     */
    void setMethods(Map<String, List<APIMethod>> methods);

    /**
     * @return the instance
     */
    Object getInstance();

    /**
     * @param instance
     *            the instance to set
     */
    void setInstance(Object instance);

    void addMethod(APIMethod method);

    TestedItemType getType();

    void setType(TestedItemType type);

    List<APIMethod> fetchAllMethod();

    List<APIMethod> getMethod(String methodName);

    Object build(ConnectionOptions connectionOptions);

    void copy(TestedItem item);

}
