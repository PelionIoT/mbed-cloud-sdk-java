package com.arm.mbed.cloud.sdk.accountmanagement.model;

import com.arm.mbed.cloud.sdk.annotations.Preamble;

@Preamble(description = "The status of the user")
public enum UserStatus {
	ENROLLING, INVITED, ACTIVE, RESET, INACTIVE
}
