package com.arm.mbed.cloud.sdk.accountmanagement.model;

import java.util.Date;
import java.util.List;

import com.arm.mbed.cloud.sdk.annotations.DefaultValue;
import com.arm.mbed.cloud.sdk.annotations.Internal;
import com.arm.mbed.cloud.sdk.annotations.Preamble;
import com.arm.mbed.cloud.sdk.common.SDKModel;

@Preamble(description = "This object represents a user in Arm Mbed Cloud")
public class User implements SDKModel {
    /**
     * Serialisation Id.
     */
    private static final long serialVersionUID = 3255828172869706707L;
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
     * The password when creating a new user. It will will generated when not present in the request.
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
     * A flag indicating that the General Terms and Conditions has been accepted.
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
     * The status of the user. INVITED means that the user has not accepted the invitation request. RESET means that the
     * password must be changed immediately.
     */
    private final UserStatus status;
    /**
     * A flag indicating whether the user's email address has been verified or not.
     */
    @DefaultValue(value = "false")
    private final boolean isEmailVerified;
    /**
     * Creation time.
     */
    @DefaultValue(value = "now()")
    private final Date createdAt;
    /**
     * States whether two factor authentication has been enabled for this user.
     */
    @DefaultValue(value = "false")
    private final boolean twoFactorAuthentication;
    /**
     * History of logins for this user.
     */
    private final List<LoginHistory> loginHistory;
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

    /**
     * Internal constructor.
     * <p>
     * Note: Should not be used. Use {@link #User()} instead.
     * 
     * @param id
     *            id
     * @param accountId
     *            accountId
     * @param groups
     *            groups
     * @param status
     *            status
     * @param isEmailVerified
     *            isEmailVerified
     * @param createdAt
     *            createdAt
     * @param creationTime
     *            creationTime
     * @param passwordChangedTime
     *            passwordChangedTime
     * @param lastLoginTime
     *            lastLoginTime
     * @param twoFactorAuthentication
     *            twoFactorAuthentification
     * @param loginHistory
     *            loginHistory
     */
    @Internal
    public User(String id, String accountId, List<String> groups, UserStatus status, boolean isEmailVerified,
            Date createdAt, long creationTime, long passwordChangedTime, long lastLoginTime,
            boolean twoFactorAuthentication, List<LoginHistory> loginHistory) {
        this(id, accountId, null, null, null, null, null, null, true, true, groups, status, isEmailVerified, createdAt,
                twoFactorAuthentication, loginHistory, creationTime, passwordChangedTime, lastLoginTime);
    }

    /**
     * Internal constructor.
     * <p>
     * Note: Should not be used. Use {@link #User()} instead.
     * 
     * @param id
     *            id
     * @param accountId
     *            accountId
     * @param fullName
     *            fullName
     * @param username
     *            username
     * @param password
     *            password
     * @param email
     *            email
     * @param phoneNumber
     *            phoneNumber
     * @param address
     *            address
     * @param areTermsAccepted
     *            areTermsAccepted
     * @param isMarketingAccepted
     *            isMarketingAccepted
     * @param groups
     *            groups
     * @param status
     *            status
     * @param isEmailVerified
     *            isEmailVerified
     * @param createdAt
     *            createdAt
     * @param twoFactorAuthentication
     *            twoFactorAuthentication
     * @param loginHistory
     *            loginHistory
     * @param creationTime
     *            creationTime
     * @param passwordChangedTime
     *            passwordChangedTime
     * @param lastLoginTime
     *            lastLoginTime
     */
    @Internal
    protected User(String id, String accountId, String fullName, String username, String password, String email,
            String phoneNumber, String address, boolean areTermsAccepted, boolean isMarketingAccepted,
            List<String> groups, UserStatus status, boolean isEmailVerified, Date createdAt,
            boolean twoFactorAuthentication, List<LoginHistory> loginHistory, long creationTime,
            long passwordChangedTime, long lastLoginTime) {
        super();
        setId(id);
        this.accountId = accountId;
        this.groups = groups;
        this.status = status;
        this.isEmailVerified = isEmailVerified;
        this.createdAt = createdAt;
        this.twoFactorAuthentication = twoFactorAuthentication;
        this.loginHistory = loginHistory;
        this.creationTime = creationTime;
        this.passwordChangedTime = passwordChangedTime;
        this.lastLoginTime = lastLoginTime;
        setFullName(fullName);
        setUsername(username);
        setPassword(password);
        setEmail(email);
        setPhoneNumber(phoneNumber);
        setAddress(address);
        setTermAccepted(areTermsAccepted);
        setMarketingAccepted(isMarketingAccepted);
    }

    /**
     * Constructor for a user.
     * <p>
     * Other constructors are for internal usage only.
     */
    public User() {
        this(null, null, null, UserStatus.getDefault(), false, new Date(), 0, 0, 0, false, null);
    }

    /**
     * Gets user Id.
     * 
     * @return the {@link #id}.
     */
    public String getId() {
        return id;
    }

    /**
     * Similar to {@link #setId(String)}.
     * 
     * @param id
     *            the id to set.
     */
    @Internal
    public void setUserId(String id) {
        setId(id);
    }

    /**
     * Sets user Id.
     * 
     * @param id
     *            the id to set.
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * Gets user full name.
     * 
     * @return the {@link #fullName}.
     */
    public String getFullName() {
        return fullName;
    }

    /**
     * Sets user full name.
     * 
     * @param fullName
     *            the fullName to set.
     */
    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    /**
     * Gets user name.
     * 
     * @return the {@link #username}.
     */
    public String getUsername() {
        return username;
    }

    /**
     * Sets user name.
     * 
     * @param username
     *            the username to set.
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * Gets the password.
     * 
     * @return the {@link #password}.
     */
    public String getPassword() {
        return password;
    }

    /**
     * Sets the password.
     * 
     * @param password
     *            the password to set.
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * Gets the email.
     * 
     * @return the {@link #email}.
     */
    public String getEmail() {
        return email;
    }

    /**
     * Sets the email.
     * 
     * @param email
     *            the email to set.
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * Gets the phone number.
     * 
     * @return the {@link #phoneNumber}.
     */
    public String getPhoneNumber() {
        return phoneNumber;
    }

    /**
     * Sets the phone number.
     * 
     * @param phoneNumber
     *            the phoneNumber to set.
     */
    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    /**
     * Gets the address.
     * 
     * @return the {@link #address}.
     */
    public String getAddress() {
        return address;
    }

    /**
     * Sets the address.
     * 
     * @param address
     *            the address to set.
     */
    public void setAddress(String address) {
        this.address = address;
    }

    /**
     * States whether terms have been accepted.
     * 
     * @return the {@link #areTermsAccepted}.
     */
    public boolean areTermsAccepted() {
        return areTermsAccepted;
    }

    /**
     * Sets whether terms have been accepted.
     * 
     * @param areTermsAccepted
     *            the isTermAccepted to set
     */
    public void setTermAccepted(boolean areTermsAccepted) {
        this.areTermsAccepted = areTermsAccepted;
    }

    /**
     * States whether marketing material can be sent.
     * 
     * @return the {@link #isMarketingAccepted}.
     */
    public boolean isMarketingAccepted() {
        return isMarketingAccepted;
    }

    /**
     * Sets whether marketing material can be sent.
     * 
     * @param isMarketingAccepted
     *            the isMarketingAccepted to set.
     */
    public void setMarketingAccepted(boolean isMarketingAccepted) {
        this.isMarketingAccepted = isMarketingAccepted;
    }

    /**
     * Gets account Id.
     * 
     * @return the {@link #accountId}.
     */
    public String getAccountId() {
        return accountId;
    }

    /**
     * Gets groups.
     * 
     * @return the {@link #groups}.
     */
    public List<String> getGroups() {
        return groups;
    }

    /**
     * Gets the status.
     * 
     * @return the {@link #status}.
     */
    public UserStatus getStatus() {
        return status;
    }

    /**
     * States whether the email has been verified.
     * 
     * @return the {@link #isEmailVerified}.
     */
    public boolean isEmailVerified() {
        return isEmailVerified;
    }

    /**
     * Gets when the User was created.
     * 
     * @return the {@link #createdAt}.
     */
    public Date getCreatedAt() {
        return createdAt;
    }

    /**
     * Gets creation time.
     * 
     * @return the {@link #creationTime}.
     */
    public long getCreationTime() {
        return creationTime;
    }

    /**
     * Gets the time when password was changed for the last time.
     * 
     * @return the {@link #passwordChangedTime}.
     */
    public long getPasswordChangedTime() {
        return passwordChangedTime;
    }

    /**
     * Gets last login time.
     * 
     * @return the {@link #lastLoginTime}.
     */
    public long getLastLoginTime() {
        return lastLoginTime;
    }

    /**
     * States whether two factor authentication is in place.
     * 
     * @return the {@link #twoFactorAuthentication}.
     */
    public boolean isTwoFactorAuthentication() {
        return twoFactorAuthentication;
    }

    /**
     * Gets user login history.
     * 
     * @return the {@link #loginHistory}.
     */
    public List<LoginHistory> getLoginHistory() {
        return loginHistory;
    }

    /**
     * Gets a clone.
     * 
     * @return a clone.
     * @see java.lang.Object#clone()
     */
    @Override
    public User clone() throws CloneNotSupportedException {
        return new User(id, accountId, fullName, username, password, email, phoneNumber, address, areTermsAccepted,
                isMarketingAccepted, groups, status, isEmailVerified, createdAt, twoFactorAuthentication, loginHistory,
                creationTime, passwordChangedTime, lastLoginTime);
    }

}
