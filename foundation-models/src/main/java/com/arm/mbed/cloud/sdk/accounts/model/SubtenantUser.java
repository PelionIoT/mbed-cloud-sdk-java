// This file was generated by the Pelion SDK foundation code generator.
// This is an autogenerated class. Do not modify its content as modifications will be lost at next code generation.
package com.arm.mbed.cloud.sdk.accounts.model;

import com.arm.mbed.cloud.sdk.annotations.Internal;
import com.arm.mbed.cloud.sdk.annotations.Preamble;
import com.arm.mbed.cloud.sdk.annotations.Required;
import com.arm.mbed.cloud.sdk.common.SdkModel;
import java.util.Date;
import java.util.List;
import java.util.Objects;

/**
 * Model for a subtenant user.
 */
@Preamble(description = "Model for a subtenant user.")
@SuppressWarnings("PMD.CyclomaticComplexity")
public class SubtenantUser implements SdkModel {
    /**
     * Serialisation Id.
     */
    private static final long serialVersionUID = -206161294719212L;

    /**
     * The ID of the account.
     */
    @Required
    private String accountId;

    /**
     * Address.
     */
    private String address;

    /**
     * Creation UTC time RFC3339.
     */
    private Date createdAt;

    /**
     * A timestamp of the user creation in the storage, in milliseconds.
     */
    private long creationTime;

    /**
     * The email address.
     */
    @Required
    private String email;

    /**
     * A flag indicating whether the user's email address has been verified or not.
     */
    private boolean emailVerified;

    /**
     * The full name of the user.
     */
    private String fullName;

    /**
     * The ID of the user.
     */
    private String id;

    /**
     * A timestamp of the latest login of the user, in milliseconds.
     */
    private long lastLoginTime;

    /**
     * Timestamps, succeedings, IP addresses and user agent information of the last five logins of the user, with
     * timestamps in RFC3339 format.
     */
    private List<LoginHistory> loginHistory;

    /**
     * A list of login profiles for the user. Specified as the identity providers the user is associated with.
     */
    private List<LoginProfile> loginProfiles;

    /**
     * A flag indicating that receiving marketing information has been accepted.
     */
    private boolean marketingAccepted;

    /**
     * The password when creating a new user. It will be generated when not present in the request.
     */
    private String password;

    /**
     * A timestamp of the latest change of the user password, in milliseconds.
     */
    private long passwordChangedTime;

    /**
     * Phone number.
     */
    private String phoneNumber;

    /**
     * The status of the user. ENROLLING state indicates that the user is in the middle of the enrollment process.
     * INVITED means that the user has not accepted the invitation request. RESET means that the password must be
     * changed immediately. INACTIVE users are locked out and not permitted to use the system.
     */
    private SubtenantUserStatus status;

    /**
     * A flag indicating that the General Terms and Conditions has been accepted.
     */
    private boolean termsAccepted;

    /**
     * A flag indicating whether 2-factor authentication (TOTP) has been enabled.
     */
    private boolean twoFactorAuthentication;

    /**
     * Last update UTC time RFC3339.
     */
    private Date updatedAt;

    /**
     * A username containing alphanumerical letters and -,._@+= characters.
     */
    private String username;

    /**
     * Internal constructor.
     * <p>
     * Note: Should not be used. Use {@link #SubtenantUser()} instead.
     * 
     * @param accountId
     *            The ID of the account.
     * @param address
     *            Address.
     * @param createdAt
     *            Creation UTC time RFC3339.
     * @param creationTime
     *            A timestamp of the user creation in the storage, in milliseconds.
     * @param email
     *            The email address.
     * @param emailVerified
     *            A flag indicating whether the user's email address has been verified or not.
     * @param fullName
     *            The full name of the user.
     * @param id
     *            The ID of the user.
     * @param lastLoginTime
     *            A timestamp of the latest login of the user, in milliseconds.
     * @param loginHistory
     *            Timestamps, succeedings, IP addresses and user agent information of the last five logins of the user,
     *            with timestamps in RFC3339 format.
     * @param loginProfiles
     *            A list of login profiles for the user. Specified as the identity providers the user is associated
     *            with.
     * @param marketingAccepted
     *            A flag indicating that receiving marketing information has been accepted.
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
     * @param termsAccepted
     *            A flag indicating that the General Terms and Conditions has been accepted.
     * @param twoFactorAuthentication
     *            A flag indicating whether 2-factor authentication (TOTP) has been enabled.
     * @param updatedAt
     *            Last update UTC time RFC3339.
     * @param username
     *            A username containing alphanumerical letters and -,._@+= characters.
     */
    @Internal
    @SuppressWarnings("PMD.CyclomaticComplexity")
    public SubtenantUser(String accountId, String address, Date createdAt, long creationTime, String email,
                         boolean emailVerified, String fullName, String id, long lastLoginTime,
                         List<LoginHistory> loginHistory, List<LoginProfile> loginProfiles, boolean marketingAccepted,
                         String password, long passwordChangedTime, String phoneNumber, SubtenantUserStatus status,
                         boolean termsAccepted, boolean twoFactorAuthentication, Date updatedAt, String username) {
        super();
        setAccountId(accountId);
        setAddress(address);
        setCreatedAt(createdAt);
        setCreationTime(creationTime);
        setEmail(email);
        setEmailVerified(emailVerified);
        setFullName(fullName);
        setId(id);
        setLastLoginTime(lastLoginTime);
        setLoginHistory(loginHistory);
        setLoginProfiles(loginProfiles);
        setMarketingAccepted(marketingAccepted);
        setPassword(password);
        setPasswordChangedTime(passwordChangedTime);
        setPhoneNumber(phoneNumber);
        setStatus(status);
        setTermsAccepted(termsAccepted);
        setTwoFactorAuthentication(twoFactorAuthentication);
        setUpdatedAt(updatedAt);
        setUsername(username);
    }

    /**
     * Internal constructor.
     * <p>
     * Note: Should not be used. Use {@link #SubtenantUser()} instead.
     * 
     * @param subtenantUser
     *            a subtenant user.
     */
    @Internal
    public SubtenantUser(SubtenantUser subtenantUser) {
        this(subtenantUser == null ? (String) null : subtenantUser.accountId,
             subtenantUser == null ? (String) null : subtenantUser.address,
             subtenantUser == null ? new java.util.Date() : subtenantUser.createdAt,
             subtenantUser == null ? 0L : subtenantUser.creationTime,
             subtenantUser == null ? (String) null : subtenantUser.email,
             subtenantUser != null && subtenantUser.emailVerified,
             subtenantUser == null ? (String) null : subtenantUser.fullName,
             subtenantUser == null ? (String) null : subtenantUser.id,
             subtenantUser == null ? 0L : subtenantUser.lastLoginTime,
             subtenantUser == null ? null : subtenantUser.loginHistory,
             subtenantUser == null ? null : subtenantUser.loginProfiles,
             subtenantUser != null && subtenantUser.marketingAccepted,
             subtenantUser == null ? (String) null : subtenantUser.password,
             subtenantUser == null ? 0L : subtenantUser.passwordChangedTime,
             subtenantUser == null ? (String) null : subtenantUser.phoneNumber,
             subtenantUser == null ? SubtenantUserStatus.getDefault() : subtenantUser.status,
             subtenantUser != null && subtenantUser.termsAccepted,
             subtenantUser != null && subtenantUser.twoFactorAuthentication,
             subtenantUser == null ? new java.util.Date() : subtenantUser.updatedAt,
             subtenantUser == null ? (String) null : subtenantUser.username);
    }

    /**
     * Constructor.
     */
    public SubtenantUser() {
        this((String) null, (String) null, new java.util.Date(), 0L, (String) null, false, (String) null, (String) null,
             0L, null, null, false, (String) null, 0L, (String) null, SubtenantUserStatus.getDefault(), false, false,
             new java.util.Date(), (String) null);
    }

    /**
     * Constructor.
     * 
     * @param id
     *            The ID of the user.
     */
    public SubtenantUser(String id) {
        this();
        setId(id);
    }

    /**
     * Constructor.
     * 
     * @param accountId
     *            The ID of the account.
     * @param email
     *            The email address.
     */
    public SubtenantUser(String accountId, String email) {
        this(accountId, (String) null, new java.util.Date(), 0L, email, false, (String) null, (String) null, 0L, null,
             null, false, (String) null, 0L, (String) null, SubtenantUserStatus.getDefault(), false, false,
             new java.util.Date(), (String) null);
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
     * Sets the id of the account.
     * 
     * @param accountId
     *            The ID of the account.
     */
    @Required
    public void setAccountId(String accountId) {
        this.accountId = accountId;
    }

    /**
     * Checks whether accountId value is valid.
     * 
     * @return true if the value is valid; false otherwise.
     */
    @SuppressWarnings("PMD.UselessParentheses")
    public boolean isAccountIdValid() {
        return accountId != null;
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
     * Sets creation utc time rfc3339.
     * 
     * @param createdAt
     *            Creation UTC time RFC3339.
     */
    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
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
     * Sets a timestamp of the user creation in the storage, in milliseconds.
     * 
     * @param creationTime
     *            A timestamp of the user creation in the storage, in milliseconds.
     */
    public void setCreationTime(long creationTime) {
        this.creationTime = creationTime;
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
        return email != null;
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
     * Sets a flag indicating whether the user's email address has been verified or not.
     * 
     * @param emailVerified
     *            A flag indicating whether the user's email address has been verified or not.
     */
    public void setEmailVerified(boolean emailVerified) {
        this.emailVerified = emailVerified;
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
     * @param fullName
     *            The full name of the user.
     */
    public void setFullName(String fullName) {
        this.fullName = fullName;
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
     * @param id
     *            The ID of the user.
     */
    @Override
    public void setId(String id) {
        this.id = id;
    }

    /**
     * Sets the id of the user.
     * <p>
     * Similar to {@link #setId(String)}
     * 
     * @param subtenantUserId
     *            The ID of the user.
     */
    @Internal
    public void setSubtenantUserId(String subtenantUserId) {
        setId(subtenantUserId);
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
     * Sets a timestamp of the latest login of the user, in milliseconds.
     * 
     * @param lastLoginTime
     *            A timestamp of the latest login of the user, in milliseconds.
     */
    public void setLastLoginTime(long lastLoginTime) {
        this.lastLoginTime = lastLoginTime;
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
     * Sets timestamps, succeedings, ip addresses and user agent information of the last five logins of the user, with
     * timestamps in rfc3339 format.
     * 
     * @param loginHistory
     *            Timestamps, succeedings, IP addresses and user agent information of the last five logins of the user,
     *            with timestamps in RFC3339 format.
     */
    public void setLoginHistory(List<LoginHistory> loginHistory) {
        this.loginHistory = loginHistory;
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
     * Gets a flag indicating that receiving marketing information has been accepted.
     * 
     * @return marketingAccepted
     */
    public boolean isMarketingAccepted() {
        return marketingAccepted;
    }

    /**
     * Sets a flag indicating that receiving marketing information has been accepted.
     * 
     * @param marketingAccepted
     *            A flag indicating that receiving marketing information has been accepted.
     */
    public void setMarketingAccepted(boolean marketingAccepted) {
        this.marketingAccepted = marketingAccepted;
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
     * Sets a timestamp of the latest change of the user password, in milliseconds.
     * 
     * @param passwordChangedTime
     *            A timestamp of the latest change of the user password, in milliseconds.
     */
    public void setPasswordChangedTime(long passwordChangedTime) {
        this.passwordChangedTime = passwordChangedTime;
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
     * @param phoneNumber
     *            Phone number.
     */
    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    /**
     * Gets the status of the user. enrolling state indicates that the user is in the middle of the enrollment process.
     * invited means that the user has not accepted the invitation request. reset means that the password must be
     * changed immediately. inactive users are locked out and not permitted to use the system.
     * 
     * @return status
     */
    public SubtenantUserStatus getStatus() {
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
    public void setStatus(SubtenantUserStatus status) {
        this.status = status;
    }

    /**
     * Gets a flag indicating that the general terms and conditions has been accepted.
     * 
     * @return termsAccepted
     */
    public boolean isTermsAccepted() {
        return termsAccepted;
    }

    /**
     * Sets a flag indicating that the general terms and conditions has been accepted.
     * 
     * @param termsAccepted
     *            A flag indicating that the General Terms and Conditions has been accepted.
     */
    public void setTermsAccepted(boolean termsAccepted) {
        this.termsAccepted = termsAccepted;
    }

    /**
     * Gets a flag indicating whether 2-factor authentication (totp) has been enabled.
     * 
     * @return twoFactorAuthentication
     */
    public boolean isTwoFactorAuthentication() {
        return twoFactorAuthentication;
    }

    /**
     * Sets a flag indicating whether 2-factor authentication (totp) has been enabled.
     * 
     * @param twoFactorAuthentication
     *            A flag indicating whether 2-factor authentication (TOTP) has been enabled.
     */
    public void setTwoFactorAuthentication(boolean twoFactorAuthentication) {
        this.twoFactorAuthentication = twoFactorAuthentication;
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
     * Sets last update utc time rfc3339.
     * 
     * @param updatedAt
     *            Last update UTC time RFC3339.
     */
    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }

    /**
     * Gets a username containing alphanumerical letters and -,._@+= characters.
     * 
     * @return username
     */
    public String getUsername() {
        return username;
    }

    /**
     * Sets a username containing alphanumerical letters and -,._@+= characters.
     * 
     * @param username
     *            A username containing alphanumerical letters and -,._@+= characters.
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * Calculates the hash code of this instance based on field values.
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
        result = prime * result + ((address == null) ? 0 : address.hashCode());
        result = prime * result + ((createdAt == null) ? 0 : createdAt.hashCode());
        result = prime * result + Objects.hashCode(creationTime);
        result = prime * result + ((email == null) ? 0 : email.hashCode());
        result = prime * result + Objects.hashCode(emailVerified);
        result = prime * result + ((fullName == null) ? 0 : fullName.hashCode());
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        result = prime * result + Objects.hashCode(lastLoginTime);
        result = prime * result + ((loginHistory == null) ? 0 : loginHistory.hashCode());
        result = prime * result + ((loginProfiles == null) ? 0 : loginProfiles.hashCode());
        result = prime * result + Objects.hashCode(marketingAccepted);
        result = prime * result + ((password == null) ? 0 : password.hashCode());
        result = prime * result + Objects.hashCode(passwordChangedTime);
        result = prime * result + ((phoneNumber == null) ? 0 : phoneNumber.hashCode());
        result = prime * result + ((status == null) ? 0 : status.hashCode());
        result = prime * result + Objects.hashCode(termsAccepted);
        result = prime * result + Objects.hashCode(twoFactorAuthentication);
        result = prime * result + ((updatedAt == null) ? 0 : updatedAt.hashCode());
        result = prime * result + ((username == null) ? 0 : username.hashCode());
        return result;
    }

    /**
     * Method to ensure {@link #equals(Object)} is correct.
     * <p>
     * Note: see this article: <a href="https://www.artima.com/lejava/articles/equality.html">canEqual()</a>
     * 
     * @param other
     *            another object.
     * @return true if the other object is an instance of the class in which canEqual is (re)defined, false otherwise.
     */
    protected boolean canEqual(Object other) {
        return other instanceof SubtenantUser;
    }

    /**
     * Indicates whether some other object is "equal to" this one.
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
        if (!(obj instanceof SubtenantUser)) {
            return false;
        }
        final SubtenantUser other = (SubtenantUser) obj;
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
        if (id == null) {
            if (other.id != null) {
                return false;
            }
        } else if (!id.equals(other.id)) {
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
        if (marketingAccepted != other.marketingAccepted) {
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
        if (termsAccepted != other.termsAccepted) {
            return false;
        }
        if (twoFactorAuthentication != other.twoFactorAuthentication) {
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
     * Returns a string representation of the object.
     * <p>
     * 
     * @see java.lang.Object#toString()
     * @return the string representation
     */
    @Override
    public String toString() {
        return "SubtenantUser [accountId=" + accountId + ", address=" + address + ", createdAt=" + createdAt
               + ", creationTime=" + creationTime + ", email=" + email + ", emailVerified=" + emailVerified
               + ", fullName=" + fullName + ", id=" + id + ", lastLoginTime=" + lastLoginTime + ", loginHistory="
               + loginHistory + ", loginProfiles=" + loginProfiles + ", marketingAccepted=" + marketingAccepted
               + ", password=" + password + ", passwordChangedTime=" + passwordChangedTime + ", phoneNumber="
               + phoneNumber + ", status=" + status + ", termsAccepted=" + termsAccepted + ", twoFactorAuthentication="
               + twoFactorAuthentication + ", updatedAt=" + updatedAt + ", username=" + username + "]";
    }

    /**
     * Checks whether the model is valid or not.
     * <p>
     * 
     * @see SdkModel#isValid()
     * @return true if the model is valid; false otherwise.
     */
    @Override
    public boolean isValid() {
        return isAccountIdValid() && isEmailValid();
    }

    /**
     * Clones this instance.
     * <p>
     * 
     * @see java.lang.Object#clone()
     * @return a cloned instance
     */
    @Override
    public SubtenantUser clone() {
        return new SubtenantUser(this);
    }
}
