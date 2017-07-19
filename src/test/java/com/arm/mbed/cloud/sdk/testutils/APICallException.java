/**
 * 
 */
package com.arm.mbed.cloud.sdk.testutils;

public class APICallException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7760245804136605697L;

	/**
	 * 
	 */
	public APICallException() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param arg0
	 */
	public APICallException(String arg0) {
		super(arg0);
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param arg0
	 */
	public APICallException(Throwable arg0) {
		super(arg0);
	}

	/**
	 * @param arg0
	 * @param arg1
	 */
	public APICallException(String arg0, Throwable arg1) {
		super(arg0, arg1);
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param arg0
	 * @param arg1
	 * @param arg2
	 * @param arg3
	 */
	public APICallException(String arg0, Throwable arg1, boolean arg2, boolean arg3) {
		super(arg0, arg1, arg2, arg3);
		// TODO Auto-generated constructor stub
	}

}
