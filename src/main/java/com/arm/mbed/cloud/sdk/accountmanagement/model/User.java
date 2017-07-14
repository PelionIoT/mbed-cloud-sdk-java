package com.arm.mbed.cloud.sdk.accountmanagement.model;

import com.arm.mbed.cloud.sdk.annotations.DefaultValue;
import com.arm.mbed.cloud.sdk.annotations.Preamble;

@Preamble(description = "This object represents a user in mbed Cloud")
public class User {
	/**
	 * The full name of the user.
	 */
	private String fullName;
	/**
	 * A username containing alphanumerical letters and -,._@+= characters.
	 */
	private String username;
	/**
	 * The password when creating a new user. It will will generated when not
	 * present in the request.
	 */
	private String password;
	/**
	 * The email address.
	 */
	private String email;
	/**
	 * Phone number.
	 */
	private String phoneNumber;
	/**
	 * Address.
	 */
	private String address;
	/**
	 * A flag indicating that the General Terms and Conditions has been
	 * accepted.
	 */
	@DefaultValue(value = "true")
	private boolean areTermsAccepted = true;
	/**
	 * A flag indicating that receiving marketing information has been accepted.
	 */
	@DefaultValue(value = "true")
	private boolean isMarketingAccepted = true;

	/**
	 * @return the fullName
	 */
	public String getFullName() {
		return fullName;
	}

	/**
	 * @param fullName
	 *            the fullName to set
	 */
	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	/**
	 * @return the username
	 */
	public String getUsername() {
		return username;
	}

	/**
	 * @param username
	 *            the username to set
	 */
	public void setUsername(String username) {
		this.username = username;
	}

	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * @param password
	 *            the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * @param email
	 *            the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * @return the phoneNumber
	 */
	public String getPhoneNumber() {
		return phoneNumber;
	}

	/**
	 * @param phoneNumber
	 *            the phoneNumber to set
	 */
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	/**
	 * @return the address
	 */
	public String getAddress() {
		return address;
	}

	/**
	 * @param address
	 *            the address to set
	 */
	public void setAddress(String address) {
		this.address = address;
	}

	/**
	 * @return the areTermsAccepted
	 */
	public boolean areTermsAccepted() {
		return areTermsAccepted;
	}

	/**
	 * @param areTermsAccepted
	 *            the isTermAccepted to set
	 */
	public void setTermAccepted(boolean areTermsAccepted) {
		this.areTermsAccepted = areTermsAccepted;
	}

	/**
	 * @return the isMarketingAccepted
	 */
	public boolean isMarketingAccepted() {
		return isMarketingAccepted;
	}

	/**
	 * @param isMarketingAccepted
	 *            the isMarketingAccepted to set
	 */
	public void setMarketingAccepted(boolean isMarketingAccepted) {
		this.isMarketingAccepted = isMarketingAccepted;
	}

}
