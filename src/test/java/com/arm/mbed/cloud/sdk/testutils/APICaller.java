package com.arm.mbed.cloud.sdk.testutils;

import java.util.Map;

import com.arm.mbed.cloud.sdk.annotations.Preamble;
import com.arm.mbed.cloud.sdk.common.ConnectionOptions;

@Preamble(description = "Mechanism to call API methods by reflection")
public class APICaller {
	private SDK sdk;
	private ConnectionOptions connectionOptions;

	public APICaller(SDK sdk, ConnectionOptions connectionOptions) {
		super();
		this.sdk = sdk;
		this.connectionOptions = connectionOptions;
	}

	/**
	 * @return the sdk
	 */
	public SDK getSdk() {
		return sdk;
	}

	/**
	 * @param sdk
	 *            the sdk to set
	 */
	public void setSdk(SDK sdk) {
		this.sdk = sdk;
	}

	/**
	 * @return the connectionOptions
	 */
	public ConnectionOptions getConnectionOptions() {
		return connectionOptions;
	}

	/**
	 * @param connectionOptions
	 *            the connectionOptions to set
	 */
	public void setConnectionOptions(ConnectionOptions connectionOptions) {
		this.connectionOptions = connectionOptions;
	}

	public Object callAPI(String module, String method, Map<String, String> parameters)
			throws UnknownAPIException, APICallException {
		if (module == null || method == null || sdk == null) {
			throwUnknownAPI(module, method);
		}
		APIModule moduleObj = sdk.getModule(module);
		if (moduleObj == null) {
			throwUnknownAPI(module, method);
		}
		APIMethod methodObj = moduleObj.getMethod(method);
		if (methodObj == null) {
			throwUnknownAPI(module, method);
		}
		API api = new API(connectionOptions, moduleObj, methodObj);
		return api.call(parameters);
	}

	private void throwUnknownAPI(String module, String method) throws UnknownAPIException {
		throw new UnknownAPIException(
				"method [" + String.valueOf(method) + "] not found on module [" + String.valueOf(module) + "]");
	}

	private static class API {
		private ConnectionOptions connectionOptions;
		private APIModule module;
		private APIMethod method;

		public API(ConnectionOptions connectionOptions, APIModule module, APIMethod method) {
			super();
			this.connectionOptions = connectionOptions;
			this.module = module;
			this.method = method;
		}

		public Object call(Map<String, String> parameters) {
			// TODO
			return null;
		}

	}

}
