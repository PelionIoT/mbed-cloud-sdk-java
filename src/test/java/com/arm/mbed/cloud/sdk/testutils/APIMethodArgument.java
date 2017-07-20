package com.arm.mbed.cloud.sdk.testutils;

import java.util.Map;

public class APIMethodArgument {
	private String name;
	private String type;

	public APIMethodArgument(String name, String type) {
		super();
		setName(name);
		setType(type);
	}

	public APIMethodArgument(String name, Class<?> typeClass) {
		super();
		setName(name);
		determineType(typeClass);
	}

	public APIMethodArgument(Class<?> typeClass) {
		this(null, typeClass);
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
	 * @return the type
	 */
	public String getType() {
		return type;
	}

	/**
	 * @param type
	 *            the type to set
	 */
	public void setType(String type) {
		this.type = type;
	}

	public Class<?> retrieveTypeClass() {
		if (type == null) {
			return null;
		}
		try {
			return Class.forName(type);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			return null;
		}
	}

	public void determineType(Class<?> type) {
		if (type == null) {
			this.type = null;
		}
		this.type = type.getName();
	}

	public Class<?> determineClass() throws ClassNotFoundException {
		if (type == null) {
			return null;
		}
		return Class.forName(type);
	}

	public <T> Object determineValue(Class<T> clazz, Map<String, Object> fields) throws APICallException {
		if (clazz == null || Void.class.isAssignableFrom(clazz) || fields == null || fields.isEmpty()) {
			return null;
		}
		return Serializer.convertParametersToObject(fields, clazz);
	}

	public <T> Object determineValue(Class<T> clazz, String fields) throws APICallException {
		if (clazz == null || Void.class.isAssignableFrom(clazz) || fields == null || fields.isEmpty()) {
			return null;
		}
		return Serializer.convertStringToObject(fields, clazz);
	}

}
