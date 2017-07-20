package com.arm.mbed.cloud.sdk.testutils;

import java.lang.reflect.InvocationTargetException;
import java.util.Hashtable;
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

	public Object callAPI(String module, String method, Map<String, Object> parameters)
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

	private static void throwUnknownAPI(String module, String method) throws UnknownAPIException {
		throw new UnknownAPIException(
				"method [" + String.valueOf(method) + "] not found on module [" + String.valueOf(module) + "]");
	}

	private static void throwAPICallException(APIModule module, APIMethod method, Exception e) throws APICallException {
		throw new APICallException("Error occurred when calling method [" + String.valueOf(method.getName())
				+ "] on module [" + String.valueOf(module.getSimpleName()) + "]. "
				+ String.valueOf((e == null) ? "Unknown reason" : e.getMessage()));
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

		@SuppressWarnings("unchecked")
		public Object call(Map<String, Object> parameters) throws APICallException {
			Map<String, Map<String, Object>> argDescription = determineArgumentJsonValues(parameters);
			try {
				return method.invokeMethod(module.createInstance(connectionOptions), argDescription);
			} catch (NoSuchMethodException | SecurityException | ClassNotFoundException | IllegalAccessException
					| IllegalArgumentException | InvocationTargetException e) {
				// e.printStackTrace();
				throwAPICallException(module, method, e);
			}
			return null;
		}

		private Map<String, Map<String, Object>> determineArgumentJsonValues(Map<String, Object> parameters)
				throws APICallException {
			Map<String, Map<String, Object>> argDescription = null;
			if (parameters != null && method.determineNumberOfArguments() > 0) {
				argDescription = new Hashtable<String, Map<String, Object>>(method.determineNumberOfArguments());
				if (method.determineNumberOfArguments() == 1 || parameters.size() == 1) {
					String argName = method.getArguments().get(0).getName();
					argDescription.put(argName, parameters);
				} else {
					for (APIMethodArgument argument : method.getArguments()) {
						String argName = argument.getName();
						Object subMap = parameters.get(argName);
						if (subMap != null) {
							if (!(subMap instanceof Map)) {
								throwAPICallException(module, method,
										new Exception("Incorrect argument type [" + String.valueOf(subMap) + "]."));
							}
							argDescription.put(argName, (Map<String, Object>) subMap);
						}
					}
				}
			}
			return argDescription;
		}

	}

}
