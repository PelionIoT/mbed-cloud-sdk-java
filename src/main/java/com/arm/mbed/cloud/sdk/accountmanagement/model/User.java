package com.arm.mbed.cloud.sdk.accountmanagement.model;

import java.util.Date;
import java.util.List;

import com.arm.mbed.cloud.sdk.annotations.DefaultValue;
import com.arm.mbed.cloud.sdk.annotations.Internal;
import com.arm.mbed.cloud.sdk.annotations.Preamble;

@Preamble(description = "This object represents a user in mbed Cloud")
public class User {
	/**
	 * The UUID of the user.
	 */
	private String id;
	/**
	 * The UUID of the account.
	 */
	private final String accountId;

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
	private boolean areTermsAccepted;
	/**
	 * A flag indicating that receiving marketing information has been accepted.
	 */
	@DefaultValue(value = "true")
	private boolean isMarketingAccepted;
	/**
	 * A list of group IDs this user belongs to.
	 */
	private final List<String> groups;
	/**
	 * The status of the user. INVITED means that the user has not accepted the
	 * invitation request. RESET means that the password must be changed
	 * immediately.
	 */
	@DefaultValue(value = "INACTIVE")
	private final UserStatus status;
	/**
	 * A flag indicating whether the user's email address has been verified or
	 * not.
	 */
	@DefaultValue(value = "false")
	private final boolean isEmailVerified;
	/**
	 * Creation time.
	 */
	@DefaultValue(value = "now()")
	private final Date createdAt;
	/**
	 * A timestamp of the user creation in the storage, in milliseconds.
	 */
	private final long creationTime;
	/**
	 * A timestamp of the latest change of the user password, in milliseconds.
	 */
	private final long passwordChangedTime;
	/**
	 * A timestamp of the latest login of the user, in milliseconds.
	 */
	private final long lastLoginTime;

	public User(String id, String accountId, List<String> groups, UserStatus status, boolean isEmailVerified,
			Date createdAt, long creationTime, long passwordChangedTime, long lastLoginTime) {
		super();
		setId(id);
		this.accountId = accountId;
		this.groups = groups;
		this.status = status;
		this.isEmailVerified = isEmailVerified;
		this.createdAt = createdAt;
		this.creationTime = creationTime;
		this.passwordChangedTime = passwordChangedTime;
		this.lastLoginTime = lastLoginTime;
		setFullName(null);
		setUsername(null);
		setPassword(null);
		setEmail(null);
		setPhoneNumber(null);
		setAddress(null);
		setTermAccepted(true);
		setMarketingAccepted(true);
	}

	public User() {
		this(null, null, null, UserStatus.INACTIVE, false, new Date(), 0, 0, 0);
	}

	/**
	 * @return the id
	 */
	public String getId() {
		return id;
	}

	/**
	 * similar to setId()
	 * 
	 * @param id
	 *            the id to set
	 */
	@Internal
	public void setUserId(String id) {
		setId(id);
	}

	/**
	 * @param id
	 *            the id to set
	 */
	public void setId(String id) {
		this.id = id;
	}

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

	/**
	 * @return the accountId
	 */
	public String getAccountId() {
		return accountId;
	}

	/**
	 * @return the groups
	 */
	public List<String> getGroups() {
		return groups;
	}

	/**
	 * @return the status
	 */
	public UserStatus getStatus() {
		return status;
	}

	/**
	 * @return the isEmailVerified
	 */
	public boolean isEmailVerified() {
		return isEmailVerified;
	}

	/**
	 * @return the createdAt
	 */
	public Date getCreatedAt() {
		return createdAt;
	}

	/**
	 * @return the creationTime
	 */
	public long getCreationTime() {
		return creationTime;
	}

	/**
	 * @return the passwordChangedTime
	 */
	public long getPasswordChangedTime() {
		return passwordChangedTime;
	}

	/**
	 * @return the lastLoginTime
	 */
	public long getLastLoginTime() {
		return lastLoginTime;
	}

}
