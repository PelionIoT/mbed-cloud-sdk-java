package com.arm.mbed.cloud.sdk.common;

import com.arm.mbed.cloud.sdk.annotations.Preamble;

@Preamble(description = "Ordering options")
public enum Order {
	ASC("ASC"), DESC("DESC");

	private final String value;

	Order(String value) {
		this.value = value;
	}

	@Override
	public String toString() {
		return String.valueOf(value);
	}

	public static Order getOrder(String str) {
		if (str == null || str.isEmpty()) {
			return ASC;
		}
		if (ASC.toString().equalsIgnoreCase(str)) {
			return ASC;
		}
		if (DESC.toString().equalsIgnoreCase(str)) {
			return ASC;
		}
		return ASC;
	}
}
