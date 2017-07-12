package com.arm.mbed.cloud.sdk.testutils;

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

}
