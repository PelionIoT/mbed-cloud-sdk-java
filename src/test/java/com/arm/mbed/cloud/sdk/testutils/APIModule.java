package com.arm.mbed.cloud.sdk.testutils;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.LinkedHashMap;
import java.util.Map;

import com.arm.mbed.cloud.sdk.common.ConnectionOptions;

public class APIModule {
	private String name;
	private String simpleName;

	private Map<String, APIMethod> methods;

	public APIModule(String name, String simpleName, Map<String, APIMethod> methods) {
		super();
		setName(name);
		setSimpleName(simpleName);
		setMethods(methods);
	}

	public APIModule(String name, String simpleName) {
		this(name, simpleName, null);
	}

	public APIModule(String name) {
		this(name, null);
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name
	 *            the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the simpleName
	 */
	public String getSimpleName() {
		return simpleName;
	}

	/**
	 * @param simpleName
	 *            the simpleName to set
	 */
	public void setSimpleName(String simpleName) {
		this.simpleName = simpleName;
	}

	/**
	 * @return the methods
	 */
	public Map<String, APIMethod> getMethods() {
		return methods;
	}

	/**
	 * @param methods
	 *            the methods to set
	 */
	public void setMethods(Map<String, APIMethod> methods) {
		this.methods = methods;
	}

	public void addMethod(APIMethod method) {
		if (method == null) {
			return;
		}
		if (methods == null) {
			methods = new LinkedHashMap<String, APIMethod>();
		}
		methods.put(method.getName(), method);
	}

	public APIMethod getMethod(String methodName) {
		if (methodName == null || methods == null) {
			return null;
		}
		return methods.get(methodName);
	}

	public Object createInstance(ConnectionOptions connectionOptions) {
		if (name == null) {
			return null;
		}
		try {
			Class<?> moduleClass = Class.forName(name);
			Constructor<?> constructor = moduleClass.getConstructor(ConnectionOptions.class);
			return constructor.newInstance(connectionOptions);
		} catch (ClassNotFoundException | InstantiationException | IllegalAccessException | IllegalArgumentException
				| InvocationTargetException | NoSuchMethodException | SecurityException e) {
			e.printStackTrace();
			return null;
		}
	}

}
