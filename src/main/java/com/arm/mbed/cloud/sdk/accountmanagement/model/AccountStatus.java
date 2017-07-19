/**
 * 
 */
package com.arm.mbed.cloud.sdk.accountmanagement.model;

import com.arm.mbed.cloud.sdk.annotations.Preamble;

@Preamble(description = "The status of the account")
public enum AccountStatus {

	ENROLLING, ACTIVE, SUSPENDED, RESTRICTED

}
