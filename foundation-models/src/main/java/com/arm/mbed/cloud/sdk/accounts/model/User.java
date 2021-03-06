// This file was generated by the Pelion SDK foundation code generator.
// This is an autogenerated class. Do not modify its content as modifications will be lost at next code generation.
package com.arm.mbed.cloud.sdk.accounts.model;

import com.arm.mbed.cloud.sdk.annotations.Internal;
import com.arm.mbed.cloud.sdk.annotations.Preamble;
import com.arm.mbed.cloud.sdk.annotations.Required;
import com.arm.mbed.cloud.sdk.common.SdkModel;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Objects;

/**
 * Model for a user.
 */
@Preamble(description = "Model for a user.")
@SuppressWarnings({ "PMD.CyclomaticComplexity", "PMD.AvoidDuplicateLiterals" })
public class User implements SdkModel {
    /**
     * Serialisation Id.
     */
    private static final long serialVersionUID = 2103476832119518L;

    /**
     * The ID of the account.
     */
    private final String accountId;

    /**
     * List of active user sessions.
     */
    private final List<ActiveSession> activeSessions;

    /**
     * Address.
     */
    private String address;

    /**
     * Creation UTC time RFC3339.
     */
    private final Date createdAt;

    /**
     * A timestamp of the user creation in the storage, in milliseconds.
     */
    private final long creationTime;

    /**
     * User's account-specific custom properties. The value is a string.
     */
    private final Map<String, String> customFields;

    /**
     * The email address.
     */
    @Required
    private String email;

    /**
     * A flag indicating whether the user's email address has been verified or not.
     */
    private final boolean emailVerified;

    /**
     * The full name of the user.
     */
    private String fullName;

    /**
     * A list of IDs of the groups this user belongs to.
     */
    private List<String> groups;

    /**
     * The ID of the user.
     */
    private String id;

    /**
     * A flag indicating that the user has accepted General Terms and Conditions.
     */
    private boolean isGtcAccepted;

    /**
     * A flag indicating that the user has consented to receive marketing information.
     */
    private boolean isMarketingAccepted;

    /**
     * A flag indicating whether two-factor authentication (TOTP) has been enabled.
     */
    private boolean isTotpEnabled;

    /**
     * A timestamp of the latest login of the user, in milliseconds.
     */
    private final long lastLoginTime;

    /**
     * Timestamps, succeedings, IP addresses and user agent information of the last five logins of the user, with
     * timestamps in RFC3339 format.
     */
    private final List<LoginHistory> loginHistory;

    /**
     * A list of login profiles for the user. Specified as the identity providers the user is associated with.
     */
    private List<LoginProfile> loginProfiles;

    /**
     * The password when creating a new user. It will be generated when not present in the request.
     */
    private String password;

    /**
     * A timestamp of the latest change of the user password, in milliseconds.
     */
    private final long passwordChangedTime;

    /**
     * Phone number.
     */
    private String phoneNumber;

    /**
     * The status of the user. ENROLLING state indicates that the user is in the middle of the enrollment process.
     * INVITED means that the user has not accepted the invitation request. RESET means that the password must be
     * changed immediately. INACTIVE users are locked out and not permitted to use the system.
     */
    private UserStatus status;

    /**
     * A list of scratch codes for the two-factor authentication. Visible only when 2FA is requested to be enabled or
     * the codes regenerated.
     */
    private final List<String> totpScratchCodes;

    /**
     * Last update UTC time RFC3339.
     */
    private final Date updatedAt;

    /**
     * A username.
     */
    private String username;

    /**
     * Internal constructor.
     * 
     * <p>
     * Constructor based on all fields.
     * <p>
     * Note: Should not be used. Use {@link #User()} instead.
     * 
     * @param accountId
     *            The ID of the account.
     * @param activeSessions
     *            List of active user sessions.
     * @param address
     *            Address.
     * @param createdAt
     *            Creation UTC time RFC3339.
     * @param creationTime
     *            A timestamp of the user creation in the storage, in milliseconds.
     * @param customFields
     *            User's account-specific custom properties. The value is a string.
     * @param email
     *            The email address.
     * @param emailVerified
     *            A flag indicating whether the user's email address has been verified or not.
     * @param fullName
     *            The full name of the user.
     * @param groups
     *            A list of IDs of the groups this user belongs to.
     * @param id
     *            The ID of the user.
     * @param isGtcAccepted
     *            A flag indicating that the user has accepted General Terms and Conditions.
     * @param isMarketingAccepted
     *            A flag indicating that the user has consented to receive marketing information.
     * @param isTotpEnabled
     *            A flag indicating whether two-factor authentication (TOTP) has been enabled.
     * @param lastLoginTime
     *            A timestamp of the latest login of the user, in milliseconds.
     * @param loginHistory
     *            Timestamps, succeedings, IP addresses and user agent information of the last five logins of the user,
     *            with timestamps in RFC3339 format.
     * @param loginProfiles
     *            A list of login profiles for the user. Specified as the identity providers the user is associated
     *            with.
     * @param password
     *            The password when creating a new user. It will be generated when not present in the request.
     * @param passwordChangedTime
     *            A timestamp of the latest change of the user password, in milliseconds.
     * @param phoneNumber
     *            Phone number.
     * @param status
     *            The status of the user. ENROLLING state indicates that the user is in the middle of the enrollment
     *            process. INVITED means that the user has not accepted the invitation request. RESET means that the
     *            password must be changed immediately. INACTIVE users are locked out and not permitted to use the
     *            system.
     * @param totpScratchCodes
     *            A list of scratch codes for the two-factor authentication. Visible only when 2FA is requested to be
     *            enabled or the codes regenerated.
     * @param updatedAt
     *            Last update UTC time RFC3339.
     * @param username
     *            A username.
     */
    @Internal
    @SuppressWarnings("PMD.CyclomaticComplexity")
    public User(String accountId, List<ActiveSession> activeSessions, String address, Date createdAt, long creationTime,
                Map<String, String> customFields, String email, boolean emailVerified, String fullName,
                List<String> groups, String id, boolean isGtcAccepted, boolean isMarketingAccepted,
                boolean isTotpEnabled, long lastLoginTime, List<LoginHistory> loginHistory,
                List<LoginProfile> loginProfiles, String password, long passwordChangedTime, String phoneNumber,
                UserStatus status, List<String> totpScratchCodes, Date updatedAt, String username) {
        super();
        this.accountId = accountId;
        this.activeSessions = activeSessions;
        this.createdAt = createdAt;
        this.creationTime = creationTime;
        this.customFields = customFields;
        this.emailVerified = emailVerified;
        this.lastLoginTime = lastLoginTime;
        this.loginHistory = loginHistory;
        this.passwordChangedTime = passwordChangedTime;
        this.totpScratchCodes = totpScratchCodes;
        this.updatedAt = updatedAt;
        setAddress(address);
        setEmail(email);
        setFullName(fullName);
        setGroups(groups);
        setId(id);
        setIsGtcAccepted(isGtcAccepted);
        setIsMarketingAccepted(isMarketingAccepted);
        setIsTotpEnabled(isTotpEnabled);
        setLoginProfiles(loginProfiles);
        setPassword(password);
        setPhoneNumber(phoneNumber);
        setStatus(status);
        setUsername(username);
    }

    /**
     * Internal constructor.
     * 
     * <p>
     * Constructor based on a similar object.
     * <p>
     * Note: Should not be used. Use {@link #User()} instead.
     * 
     * @param user
     *            a user.
     */
    @Internal
    public User(User user) {
        this(user == null ? (String) null : user.accountId,
             user == null ? (List<ActiveSession>) null : user.activeSessions,
             user == null ? (String) null : user.address, user == null ? new Date() : user.createdAt,
             user == null ? 0 : user.creationTime, user == null ? (Map<String, String>) null : user.customFields,
             user == null ? (String) null : user.email, user != null && user.emailVerified,
             user == null ? (String) null : user.fullName, user == null ? (List<String>) null : user.groups,
             user == null ? (String) null : user.id, user != null && user.isGtcAccepted,
             user != null && user.isMarketingAccepted, user != null && user.isTotpEnabled,
             user == null ? 0 : user.lastLoginTime, user == null ? (List<LoginHistory>) null : user.loginHistory,
             user == null ? (List<LoginProfile>) null : user.loginProfiles,
             user == null ? (String) null : user.password, user == null ? 0 : user.passwordChangedTime,
             user == null ? (String) null : user.phoneNumber, user == null ? UserStatus.getDefault() : user.status,
             user == null ? (List<String>) null : user.totpScratchCodes, user == null ? new Date() : user.updatedAt,
             user == null ? (String) null : user.username);
    }

    /**
     * Constructor.
     */
    public User() {
        this((String) null, (List<ActiveSession>) null, (String) null, new Date(), 0, (Map<String, String>) null,
             (String) null, false, (String) null, (List<String>) null, (String) null, false, false, false, 0,
             (List<LoginHistory>) null, (List<LoginProfile>) null, (String) null, 0, (String) null,
             UserStatus.getDefault(), (List<String>) null, new Date(), (String) null);
    }

    /**
     * Constructor.
     * 
     * <p>
     * Constructor based on object identifier.
     * <p>
     * 
     * @param id
     *            The ID of the user.
     */
    public User(String id) {
        this();
        setId(id);
    }

    /**
     * Internal constructor.
     * 
     * <p>
     * Constructor based on read-only fields.
     * <p>
     * Note: Should not be used. Use {@link #User()} instead.
     * 
     * @param accountId
     *            The ID of the account.
     * @param activeSessions
     *            List of active user sessions.
     * @param createdAt
     *            Creation UTC time RFC3339.
     * @param creationTime
     *            A timestamp of the user creation in the storage, in milliseconds.
     * @param customFields
     *            User's account-specific custom properties. The value is a string.
     * @param emailVerified
     *            A flag indicating whether the user's email address has been verified or not.
     * @param lastLoginTime
     *            A timestamp of the latest login of the user, in milliseconds.
     * @param loginHistory
     *            Timestamps, succeedings, IP addresses and user agent information of the last five logins of the user,
     *            with timestamps in RFC3339 format.
     * @param passwordChangedTime
     *            A timestamp of the latest change of the user password, in milliseconds.
     * @param totpScratchCodes
     *            A list of scratch codes for the two-factor authentication. Visible only when 2FA is requested to be
     *            enabled or the codes regenerated.
     * @param updatedAt
     *            Last update UTC time RFC3339.
     */
    @Internal
    @SuppressWarnings("PMD.CyclomaticComplexity")
    public User(String accountId, List<ActiveSession> activeSessions, Date createdAt, long creationTime,
                Map<String, String> customFields, boolean emailVerified, long lastLoginTime,
                List<LoginHistory> loginHistory, long passwordChangedTime, List<String> totpScratchCodes,
                Date updatedAt) {
        this(accountId, activeSessions, (String) null, createdAt, creationTime, customFields, (String) null,
             emailVerified, (String) null, (List<String>) null, (String) null, false, false, false, lastLoginTime,
             loginHistory, (List<LoginProfile>) null, (String) null, passwordChangedTime, (String) null,
             UserStatus.getDefault(), totpScratchCodes, updatedAt, (String) null);
    }

    /**
     * Gets the id of the account.
     * 
     * @return accountId
     */
    public String getAccountId() {
        return accountId;
    }

    /**
     * Gets list of active user sessions.
     * 
     * @return activeSessions
     */
    public List<ActiveSession> getActiveSessions() {
        return activeSessions;
    }

    /**
     * Gets address.
     * 
     * @return address
     */
    public String getAddress() {
        return address;
    }

    /**
     * Sets address.
     * 
     * @param address
     *            Address.
     */
    public void setAddress(String address) {
        this.address = address;
    }

    /**
     * Gets creation utc time rfc3339.
     * 
     * @return createdAt
     */
    public Date getCreatedAt() {
        return createdAt;
    }

    /**
     * Gets a timestamp of the user creation in the storage, in milliseconds.
     * 
     * @return creationTime
     */
    public long getCreationTime() {
        return creationTime;
    }

    /**
     * Gets user's account-specific custom properties. the value is a string.
     * 
     * @return customFields
     */
    public Map<String, String> getCustomFields() {
        return customFields;
    }

    /**
     * Gets the email address.
     * 
     * @return email
     */
    public String getEmail() {
        return email;
    }

    /**
     * Sets the email address.
     * 
     * <p>
     * Note: the length of the string has to match {@code /^(?=.{3,254}$).+@.+/} to be valid
     * 
     * @param email
     *            The email address.
     */
    @Required
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * Checks whether email value is valid.
     * 
     * @return true if the value is valid; false otherwise.
     */
    @SuppressWarnings("PMD.UselessParentheses")
    public boolean isEmailValid() {
        return email != null && (email.matches("^(?=.{3,254}$).+@.+"));
    }

    /**
     * Gets a flag indicating whether the user's email address has been verified or not.
     * 
     * @return emailVerified
     */
    public boolean isEmailVerified() {
        return emailVerified;
    }

    /**
     * Gets the full name of the user.
     * 
     * @return fullName
     */
    public String getFullName() {
        return fullName;
    }

    /**
     * Sets the full name of the user.
     * 
     * <p>
     * Note: the length of the string has to be less than or equal to {@code 100} to be valid
     * 
     * @param fullName
     *            The full name of the user.
     */
    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    /**
     * Checks whether fullName value is valid.
     * 
     * @return true if the value is valid; false otherwise.
     */
    @SuppressWarnings("PMD.UselessParentheses")
    public boolean isFullNameValid() {
        return (fullName == null || fullName.length() <= 100);
    }

    /**
     * Gets a list of ids of the groups this user belongs to.
     * 
     * @return groups
     */
    public List<String> getGroups() {
        return groups;
    }

    /**
     * Sets a list of ids of the groups this user belongs to.
     * 
     * @param groups
     *            A list of IDs of the groups this user belongs to.
     */
    public void setGroups(List<String> groups) {
        this.groups = groups;
    }

    /**
     * Gets the id of the user.
     * 
     * @return id
     */
    @Override
    public String getId() {
        return id;
    }

    /**
     * Sets the id of the user.
     * 
     * <p>
     * Note: the length of the string has to match {@code /[a-f0-9]{32}/} to be valid
     * 
     * @param id
     *            The ID of the user.
     */
    @Override
    public void setId(String id) {
        this.id = id;
    }

    /**
     * Sets the id of the user.
     * 
     * <p>
     * Similar to {@link #setId(String)}
     * <p>
     * Note: the length of the string has to match {@code /[a-f0-9]{32}/} to be valid
     * 
     * @param userId
     *            The ID of the user.
     */
    @Internal
    public void setUserId(String userId) {
        setId(userId);
    }

    /**
     * Checks whether id value is valid.
     * 
     * @return true if the value is valid; false otherwise.
     */
    @SuppressWarnings("PMD.UselessParentheses")
    public boolean isIdValid() {
        return (id == null || id.matches("[a-f0-9]{32}"));
    }

    /**
     * Gets a flag indicating that the user has accepted general terms and conditions.
     * 
     * @return isGtcAccepted
     */
    public boolean isGtcAccepted() {
        return isGtcAccepted;
    }

    /**
     * Sets a flag indicating that the user has accepted general terms and conditions.
     * 
     * @param isGtcAccepted
     *            A flag indicating that the user has accepted General Terms and Conditions.
     */
    public void setIsGtcAccepted(boolean isGtcAccepted) {
        this.isGtcAccepted = isGtcAccepted;
    }

    /**
     * Gets a flag indicating that the user has consented to receive marketing information.
     * 
     * @return isMarketingAccepted
     */
    public boolean isMarketingAccepted() {
        return isMarketingAccepted;
    }

    /**
     * Sets a flag indicating that the user has consented to receive marketing information.
     * 
     * @param isMarketingAccepted
     *            A flag indicating that the user has consented to receive marketing information.
     */
    public void setIsMarketingAccepted(boolean isMarketingAccepted) {
        this.isMarketingAccepted = isMarketingAccepted;
    }

    /**
     * Gets a flag indicating whether two-factor authentication (totp) has been enabled.
     * 
     * @return isTotpEnabled
     */
    public boolean isTotpEnabled() {
        return isTotpEnabled;
    }

    /**
     * Sets a flag indicating whether two-factor authentication (totp) has been enabled.
     * 
     * @param isTotpEnabled
     *            A flag indicating whether two-factor authentication (TOTP) has been enabled.
     */
    public void setIsTotpEnabled(boolean isTotpEnabled) {
        this.isTotpEnabled = isTotpEnabled;
    }

    /**
     * Gets a timestamp of the latest login of the user, in milliseconds.
     * 
     * @return lastLoginTime
     */
    public long getLastLoginTime() {
        return lastLoginTime;
    }

    /**
     * Gets timestamps, succeedings, ip addresses and user agent information of the last five logins of the user, with
     * timestamps in rfc3339 format.
     * 
     * @return loginHistory
     */
    public List<LoginHistory> getLoginHistory() {
        return loginHistory;
    }

    /**
     * Gets a list of login profiles for the user. specified as the identity providers the user is associated with.
     * 
     * @return loginProfiles
     */
    public List<LoginProfile> getLoginProfiles() {
        return loginProfiles;
    }

    /**
     * Sets a list of login profiles for the user. specified as the identity providers the user is associated with.
     * 
     * @param loginProfiles
     *            A list of login profiles for the user. Specified as the identity providers the user is associated
     *            with.
     */
    public void setLoginProfiles(List<LoginProfile> loginProfiles) {
        this.loginProfiles = loginProfiles;
    }

    /**
     * Gets the password when creating a new user. it will be generated when not present in the request.
     * 
     * @return password
     */
    public String getPassword() {
        return password;
    }

    /**
     * Sets the password when creating a new user. it will be generated when not present in the request.
     * 
     * @param password
     *            The password when creating a new user. It will be generated when not present in the request.
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * Gets a timestamp of the latest change of the user password, in milliseconds.
     * 
     * @return passwordChangedTime
     */
    public long getPasswordChangedTime() {
        return passwordChangedTime;
    }

    /**
     * Gets phone number.
     * 
     * @return phoneNumber
     */
    public String getPhoneNumber() {
        return phoneNumber;
    }

    /**
     * Sets phone number.
     * 
     * <p>
     * Note: the length of the string has to be less than or equal to {@code 100} to be valid
     * 
     * @param phoneNumber
     *            Phone number.
     */
    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    /**
     * Checks whether phoneNumber value is valid.
     * 
     * @return true if the value is valid; false otherwise.
     */
    @SuppressWarnings("PMD.UselessParentheses")
    public boolean isPhoneNumberValid() {
        return (phoneNumber == null || phoneNumber.length() <= 100);
    }

    /**
     * Gets the status of the user. enrolling state indicates that the user is in the middle of the enrollment process.
     * invited means that the user has not accepted the invitation request. reset means that the password must be
     * changed immediately. inactive users are locked out and not permitted to use the system.
     * 
     * @return status
     */
    public UserStatus getStatus() {
        return status;
    }

    /**
     * Sets the status of the user. enrolling state indicates that the user is in the middle of the enrollment process.
     * invited means that the user has not accepted the invitation request. reset means that the password must be
     * changed immediately. inactive users are locked out and not permitted to use the system.
     * 
     * @param status
     *            The status of the user. ENROLLING state indicates that the user is in the middle of the enrollment
     *            process. INVITED means that the user has not accepted the invitation request. RESET means that the
     *            password must be changed immediately. INACTIVE users are locked out and not permitted to use the
     *            system.
     */
    public void setStatus(UserStatus status) {
        this.status = status;
    }

    /**
     * Sets the status of the user. enrolling state indicates that the user is in the middle of the enrollment process.
     * invited means that the user has not accepted the invitation request. reset means that the password must be
     * changed immediately. inactive users are locked out and not permitted to use the system.
     * 
     * <p>
     * Similar to {@link #setStatus(com.arm.mbed.cloud.sdk.accounts.model.UserStatus)}
     * 
     * @param status
     *            The status of the user. ENROLLING state indicates that the user is in the middle of the enrollment
     *            process. INVITED means that the user has not accepted the invitation request. RESET means that the
     *            password must be changed immediately. INACTIVE users are locked out and not permitted to use the
     *            system.
     */
    @Internal
    public void setStatus(String status) {
        this.status = UserStatus.getValue(status);
    }

    /**
     * Gets a list of scratch codes for the two-factor authentication. visible only when 2fa is requested to be enabled
     * or the codes regenerated.
     * 
     * @return totpScratchCodes
     */
    public List<String> getTotpScratchCodes() {
        return totpScratchCodes;
    }

    /**
     * Gets last update utc time rfc3339.
     * 
     * @return updatedAt
     */
    public Date getUpdatedAt() {
        return updatedAt;
    }

    /**
     * Gets a username.
     * 
     * @return username
     */
    public String getUsername() {
        return username;
    }

    /**
     * Sets a username.
     * 
     * <p>
     * Note: the length of the string has to match {@code /[\\w\\-,._@+=]{4,30}/} to be valid
     * 
     * @param username
     *            A username.
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * Checks whether username value is valid.
     * 
     * @return true if the value is valid; false otherwise.
     */
    @SuppressWarnings("PMD.UselessParentheses")
    public boolean isUsernameValid() {
        return (username == null || username.matches("[\\w\\-,._@+=]{4,30}"));
    }

    /**
     * Returns a string representation of the object.
     * 
     * <p>
     * 
     * @see java.lang.Object#toString()
     * @return the string representation
     */
    @Override
    public String toString() {
        return "User [accountId=" + accountId + ", activeSessions=" + activeSessions + ", address=" + address
               + ", createdAt=" + createdAt + ", creationTime=" + creationTime + ", customFields=" + customFields
               + ", email=" + email + ", emailVerified=" + emailVerified + ", fullName=" + fullName + ", groups="
               + groups + ", id=" + id + ", isGtcAccepted=" + isGtcAccepted + ", isMarketingAccepted="
               + isMarketingAccepted + ", isTotpEnabled=" + isTotpEnabled + ", lastLoginTime=" + lastLoginTime
               + ", loginHistory=" + loginHistory + ", loginProfiles=" + loginProfiles + ", password=" + password
               + ", passwordChangedTime=" + passwordChangedTime + ", phoneNumber=" + phoneNumber + ", status=" + status
               + ", totpScratchCodes=" + totpScratchCodes + ", updatedAt=" + updatedAt + ", username=" + username + "]";
    }

    /**
     * Calculates the hash code of this instance based on field values.
     * 
     * <p>
     * 
     * @see java.lang.Object#hashCode()
     * @return hash code
     */
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((accountId == null) ? 0 : accountId.hashCode());
        result = prime * result + ((activeSessions == null) ? 0 : activeSessions.hashCode());
        result = prime * result + ((address == null) ? 0 : address.hashCode());
        result = prime * result + ((createdAt == null) ? 0 : createdAt.hashCode());
        result = prime * result + Objects.hashCode(Long.valueOf(creationTime));
        result = prime * result + ((customFields == null) ? 0 : customFields.hashCode());
        result = prime * result + ((email == null) ? 0 : email.hashCode());
        result = prime * result + Objects.hashCode(Boolean.valueOf(emailVerified));
        result = prime * result + ((fullName == null) ? 0 : fullName.hashCode());
        result = prime * result + ((groups == null) ? 0 : groups.hashCode());
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        result = prime * result + Objects.hashCode(Boolean.valueOf(isGtcAccepted));
        result = prime * result + Objects.hashCode(Boolean.valueOf(isMarketingAccepted));
        result = prime * result + Objects.hashCode(Boolean.valueOf(isTotpEnabled));
        result = prime * result + Objects.hashCode(Long.valueOf(lastLoginTime));
        result = prime * result + ((loginHistory == null) ? 0 : loginHistory.hashCode());
        result = prime * result + ((loginProfiles == null) ? 0 : loginProfiles.hashCode());
        result = prime * result + ((password == null) ? 0 : password.hashCode());
        result = prime * result + Objects.hashCode(Long.valueOf(passwordChangedTime));
        result = prime * result + ((phoneNumber == null) ? 0 : phoneNumber.hashCode());
        result = prime * result + ((status == null) ? 0 : status.hashCode());
        result = prime * result + ((totpScratchCodes == null) ? 0 : totpScratchCodes.hashCode());
        result = prime * result + ((updatedAt == null) ? 0 : updatedAt.hashCode());
        result = prime * result + ((username == null) ? 0 : username.hashCode());
        return result;
    }

    /**
     * Method to ensure {@link #equals(Object)} is correct.
     * 
     * <p>
     * Note: see this article: <a href="https://www.artima.com/lejava/articles/equality.html">canEqual()</a>
     * 
     * @param other
     *            another object.
     * @return true if the other object is an instance of the class in which canEqual is (re)defined, false otherwise.
     */
    protected boolean canEqual(Object other) {
        return other instanceof User;
    }

    /**
     * Indicates whether some other object is "equal to" this one.
     * 
     * <p>
     * 
     * @see java.lang.Object#equals(java.lang.Object)
     * @param obj
     *            an object to compare with this instance.
     * @return true if this object is the same as the obj argument; false otherwise.
     */
    @Override
    @SuppressWarnings({ "PMD.ExcessiveMethodLength", "PMD.NcssMethodCount" })
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (!(obj instanceof User)) {
            return false;
        }
        final User other = (User) obj;
        if (!other.canEqual(this)) {
            return false;
        }
        if (accountId == null) {
            if (other.accountId != null) {
                return false;
            }
        } else if (!accountId.equals(other.accountId)) {
            return false;
        }
        if (activeSessions == null) {
            if (other.activeSessions != null) {
                return false;
            }
        } else if (!activeSessions.equals(other.activeSessions)) {
            return false;
        }
        if (address == null) {
            if (other.address != null) {
                return false;
            }
        } else if (!address.equals(other.address)) {
            return false;
        }
        if (createdAt == null) {
            if (other.createdAt != null) {
                return false;
            }
        } else if (!createdAt.equals(other.createdAt)) {
            return false;
        }
        if (creationTime != other.creationTime) {
            return false;
        }
        if (customFields == null) {
            if (other.customFields != null) {
                return false;
            }
        } else if (!customFields.equals(other.customFields)) {
            return false;
        }
        if (email == null) {
            if (other.email != null) {
                return false;
            }
        } else if (!email.equals(other.email)) {
            return false;
        }
        if (emailVerified != other.emailVerified) {
            return false;
        }
        if (fullName == null) {
            if (other.fullName != null) {
                return false;
            }
        } else if (!fullName.equals(other.fullName)) {
            return false;
        }
        if (groups == null) {
            if (other.groups != null) {
                return false;
            }
        } else if (!groups.equals(other.groups)) {
            return false;
        }
        if (id == null) {
            if (other.id != null) {
                return false;
            }
        } else if (!id.equals(other.id)) {
            return false;
        }
        if (isGtcAccepted != other.isGtcAccepted) {
            return false;
        }
        if (isMarketingAccepted != other.isMarketingAccepted) {
            return false;
        }
        if (isTotpEnabled != other.isTotpEnabled) {
            return false;
        }
        if (lastLoginTime != other.lastLoginTime) {
            return false;
        }
        if (loginHistory == null) {
            if (other.loginHistory != null) {
                return false;
            }
        } else if (!loginHistory.equals(other.loginHistory)) {
            return false;
        }
        if (loginProfiles == null) {
            if (other.loginProfiles != null) {
                return false;
            }
        } else if (!loginProfiles.equals(other.loginProfiles)) {
            return false;
        }
        if (password == null) {
            if (other.password != null) {
                return false;
            }
        } else if (!password.equals(other.password)) {
            return false;
        }
        if (passwordChangedTime != other.passwordChangedTime) {
            return false;
        }
        if (phoneNumber == null) {
            if (other.phoneNumber != null) {
                return false;
            }
        } else if (!phoneNumber.equals(other.phoneNumber)) {
            return false;
        }
        if (status != other.status) {
            return false;
        }
        if (totpScratchCodes == null) {
            if (other.totpScratchCodes != null) {
                return false;
            }
        } else if (!totpScratchCodes.equals(other.totpScratchCodes)) {
            return false;
        }
        if (updatedAt == null) {
            if (other.updatedAt != null) {
                return false;
            }
        } else if (!updatedAt.equals(other.updatedAt)) {
            return false;
        }
        if (username == null) {
            if (other.username != null) {
                return false;
            }
        } else if (!username.equals(other.username)) {
            return false;
        }
        return true;
    }

    /**
     * Checks whether the model is valid or not.
     * 
     * <p>
     * 
     * @see SdkModel#isValid()
     * @return true if the model is valid; false otherwise.
     */
    @Override
    public boolean isValid() {
        return isEmailValid() && isFullNameValid() && isIdValid() && isPhoneNumberValid() && isUsernameValid();
    }

    /**
     * Clones this instance.
     * 
     * <p>
     * 
     * @see java.lang.Object#clone()
     * @return a cloned instance
     */
    @Override
    public User clone() {
        return new User(this);
    }
}
