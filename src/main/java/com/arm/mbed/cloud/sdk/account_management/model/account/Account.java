/**
 * 
 */
package com.arm.mbed.cloud.sdk.account_management.model.account;

import com.arm.mbed.cloud.sdk.annotations.Preamble;

@Preamble()
public class Account {
	/**
	 * The status of the account.
	 */
	private eAccountStatus status;

	/**
	 * @return the status
	 */
	public eAccountStatus getStatus() {
		return status;
	}

	/**
	 * @param status
	 *            the status to set
	 */
	public void setStatus(eAccountStatus status) {
		this.status = status;
	}

}
