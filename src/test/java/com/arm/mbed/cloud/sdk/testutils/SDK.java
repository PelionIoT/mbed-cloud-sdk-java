package com.arm.mbed.cloud.sdk.testutils;

import java.util.LinkedHashMap;
import java.util.Map;

public class SDK {
	private Map<String, APIModule> modules;

	public SDK(Map<String, APIModule> modules) {
		super();
		setModules(modules);
	}

	public SDK() {
		this(null);
	}

	/**
	 * @return the modules
	 */
	public Map<String, APIModule> getModules() {
		return modules;
	}

	/**
	 * @param modules
	 *            the modules to set
	 */
	public void setModules(Map<String, APIModule> modules) {
		this.modules = modules;
	}

	public APIModule getModule(String moduleSimpleName) {
		if (moduleSimpleName == null || modules == null) {
			return null;
		}
		return modules.get(moduleSimpleName);

	}

	public void addModule(APIModule module) {
		if (module == null) {
			return;
		}
		if (modules == null) {
			modules = new LinkedHashMap<String, APIModule>();
		}
		modules.put(module.getSimpleName(), module);
	}

}
