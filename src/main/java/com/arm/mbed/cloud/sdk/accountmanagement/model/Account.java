/**
 * 
 */
package com.arm.mbed.cloud.sdk.accountmanagement.model;

import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import com.arm.mbed.cloud.sdk.annotations.DefaultValue;
import com.arm.mbed.cloud.sdk.annotations.NonNull;
import com.arm.mbed.cloud.sdk.annotations.Nullable;
import com.arm.mbed.cloud.sdk.annotations.Preamble;

@Preamble(description = "Account")
public class Account {
	/**
	 * Account ID
	 */
	@NonNull
	private String id;

	/**
	 * Status of the account.
	 */
	@NonNull
	private AccountStatus status;

	/**
	 * The display name for the account.
	 */
	@Nullable
	private String displayName;

	/**
	 * The name of the contact person for this account.
	 */
	@Nullable
	private String contact;
	/**
	 * The name of the company owning this account.
	 */
	@Nullable
	private String company;

	/**
	 * Phone number of the company
	 */
	@Nullable
	private String phoneNumber;

	/**
	 * Postal code part of the postal address.
	 */
	@Nullable
	private String postCode;

	/**
	 * Postal address line 1.
	 */
	@Nullable
	private String addressLine1;

	/**
	 * Postal address line 2.
	 */
	@Nullable
	private String addressLine2;

	/**
	 * City part of postal address.
	 */
	@Nullable
	private String city;

	/**
	 * State part of postal address.
	 */
	@Nullable
	private String state;
	/**
	 * Country part of postal address.
	 */
	@Nullable
	private String country;
	/**
	 * Company email address for this account.
	 */
	@Nullable
	private String email;
	/**
	 * Flag (true/false) indicating whether Factory Tool is allowed to download
	 * or not.
	 */
	@DefaultValue(value = "true")
	private boolean provisioningAllowed = true;

	/**
	 * List of aliases.
	 */
	@Nullable
	private List<String> aliases;

	/**
	 * The tier level of the account; &#39;0&#39;: free tier, commercial
	 * account. Other values are reserved for the future.
	 */
	@NonNull
	private String tierLevel;

	/**
	 * Account creation UTC time RFC3339.
	 */
	@NonNull
	private Date createdAt;
	/**
	 * Time when upgraded to commercial account in UTC format RFC3339.
	 */
	@NonNull
	private Date upgradedAt;
	/**
	 * List of limits as key-value pairs if requested.
	 */
	@Nullable
	private Map<String, String> limits;

	/**
	 * Account template ID.
	 */
	@Nullable
	private String templateId;

	/**
	 * @return the status
	 */
	@NonNull
	public AccountStatus getStatus() {
		return status;
	}

	/**
	 * @param status
	 *            the status to set
	 */
	public void setStatus(@NonNull AccountStatus status) {
		this.status = status;
	}

	/**
	 * @return the id
	 */
	@NonNull
	public String getId() {
		return id;
	}

	/**
	 * @param id
	 *            the id to set
	 */
	public void setId(@NonNull String id) {
		this.id = id;
	}

	/**
	 * @return the displayName
	 */
	@Nullable
	public String getDisplayName() {
		return displayName;
	}

	/**
	 * @param displayName
	 *            the displayName to set
	 */
	public void setDisplayName(@Nullable String displayName) {
		this.displayName = displayName;
	}

	/**
	 * @return the contact
	 */
	@Nullable
	public String getContact() {
		return contact;
	}

	/**
	 * @param contact
	 *            the contact to set
	 */
	public void setContact(@Nullable String contact) {
		this.contact = contact;
	}

	/**
	 * @return the company
	 */
	@Nullable
	public String getCompany() {
		return company;
	}

	/**
	 * @param company
	 *            the company to set
	 */
	public void setCompany(@Nullable String company) {
		this.company = company;
	}

	/**
	 * @return the phoneNumber
	 */
	@Nullable
	public String getPhoneNumber() {
		return phoneNumber;
	}

	/**
	 * @param phoneNumber
	 *            the phoneNumber to set
	 */
	public void setPhoneNumber(@Nullable String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	/**
	 * @return the postCode
	 */
	@Nullable
	public String getPostCode() {
		return postCode;
	}

	/**
	 * @param postCode
	 *            the postCode to set
	 */
	public void setPostCode(@Nullable String postCode) {
		this.postCode = postCode;
	}

	/**
	 * @return the addressLine1
	 */
	@Nullable
	public String getAddressLine1() {
		return addressLine1;
	}

	/**
	 * @param addressLine1
	 *            the addressLine1 to set
	 */
	public void setAddressLine1(@Nullable String addressLine1) {
		this.addressLine1 = addressLine1;
	}

	/**
	 * @return the addressLine2
	 */
	@Nullable
	public String getAddressLine2() {
		return addressLine2;
	}

	/**
	 * @param addressLine2
	 *            the addressLine2 to set
	 */
	public void setAddressLine2(@Nullable String addressLine2) {
		this.addressLine2 = addressLine2;
	}

	/**
	 * @return the city
	 */
	@Nullable
	public String getCity() {
		return city;
	}

	/**
	 * @param city
	 *            the city to set
	 */
	public void setCity(@Nullable String city) {
		this.city = city;
	}

	/**
	 * @return the state
	 */
	@Nullable
	public String getState() {
		return state;
	}

	/**
	 * @param state
	 *            the state to set
	 */
	public void setState(@Nullable String state) {
		this.state = state;
	}

	/**
	 * @return the country
	 */
	@Nullable
	public String getCountry() {
		return country;
	}

	/**
	 * @param country
	 *            the country to set
	 */
	public void setCountry(@Nullable String country) {
		this.country = country;
	}

	/**
	 * @return provisioningAllowed states whether provisioning is allowed
	 */
	public boolean isProvisioningAllowed() {
		return provisioningAllowed;
	}

	/**
	 * @param provisioningAllowed
	 *            provisioning allowance to set
	 */
	public void setProvisioningAllowed(boolean provisioningAllowed) {
		this.provisioningAllowed = provisioningAllowed;
	}

	/**
	 * @return the email
	 */
	@Nullable
	public String getEmail() {
		return email;
	}

	/**
	 * @param email
	 *            the email to set
	 */
	public void setEmail(@Nullable String email) {
		this.email = email;
	}

	/**
	 * @return the aliases
	 */
	@Nullable
	public List<String> getAliases() {
		return aliases;
	}

	/**
	 * @param aliases
	 *            the aliases to set
	 */
	public void setAliases(@Nullable List<String> aliases) {
		this.aliases = aliases;
	}

	/**
	 * Add a new alias to the account
	 * 
	 * @param alias
	 *            to add
	 */
	public void addAliases(@Nullable String alias) {
		if (alias != null && !alias.isEmpty()) {
			if (aliases == null) {
				aliases = new LinkedList<String>();
			}
			aliases.add(alias);
		}
	}

	/**
	 * @return the tierLevel
	 */
	@NonNull
	public String getTierLevel() {
		return tierLevel;
	}

	/**
	 * @param tierLevel
	 *            the tierLevel to set
	 */
	public void setTierLevel(@NonNull String tierLevel) {
		this.tierLevel = tierLevel;
	}

	/**
	 * @return the createdAt
	 */
	@NonNull
	public Date getCreatedAt() {
		return createdAt;
	}

	/**
	 * @param createdAt
	 *            the createdAt to set
	 */
	public void setCreatedAt(@NonNull Date createdAt) {
		this.createdAt = createdAt;
	}

	/**
	 * @return the upgradedAt
	 */
	@NonNull
	public Date getUpgradedAt() {
		return upgradedAt;
	}

	/**
	 * @param upgradedAt
	 *            the upgradedAt to set
	 */
	public void setUpgradedAt(@NonNull Date upgradedAt) {
		this.upgradedAt = upgradedAt;
	}

	/**
	 * @return the limits
	 */
	@Nullable
	public Map<String, String> getLimits() {
		return limits;
	}

	/**
	 * @param limits
	 *            the limits to set
	 */
	public void setLimits(@Nullable Map<String, String> limits) {
		this.limits = limits;
	}

	/**
	 * @return the templateId
	 */
	@Nullable
	public String getTemplateId() {
		return templateId;
	}

	/**
	 * @param templateId
	 *            the templateId to set
	 */
	public void setTemplateId(@Nullable String templateId) {
		this.templateId = templateId;
	}

}
