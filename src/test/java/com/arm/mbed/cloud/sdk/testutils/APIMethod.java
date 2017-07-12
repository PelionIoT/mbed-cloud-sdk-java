package com.arm.mbed.cloud.sdk.testutils;

import java.util.LinkedList;
import java.util.List;

public class APIMethod {
	private String name;
	private APIMethodArgument returnArgument;
	private List<APIMethodArgument> arguments;

	public APIMethod(String name, APIMethodArgument returnArgument, List<APIMethodArgument> arguments) {
		super();
		setName(name);
		setReturnArgument(returnArgument);
		setArguments(arguments);
	}

	public APIMethod(String name) {
		this(name, null, null);
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
	 * @return the returnArgument
	 */
	public APIMethodArgument getReturnArgument() {
		return returnArgument;
	}

	/**
	 * @param returnArgument
	 *            the returnArgument to set
	 */
	public void setReturnArgument(APIMethodArgument returnArgument) {
		this.returnArgument = returnArgument;
	}

	/**
	 * @return the arguments
	 */
	public List<APIMethodArgument> getArguments() {
		return arguments;
	}

	/**
	 * @param arguments
	 *            the arguments to set
	 */
	public void setArguments(List<APIMethodArgument> arguments) {
		this.arguments = arguments;
	}

	public void addArgument(APIMethodArgument argument) {
		if (argument == null) {
			return;
		}
		if (arguments == null) {
			arguments = new LinkedList<APIMethodArgument>();
		}
		arguments.add(argument);
	}
}
