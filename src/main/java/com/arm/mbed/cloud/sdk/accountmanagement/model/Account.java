/**
 * 
 */
package com.arm.mbed.cloud.sdk.accountmanagement.model;

import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import com.arm.mbed.cloud.sdk.annotations.DefaultValue;
import com.arm.mbed.cloud.sdk.annotations.Internal;
import com.arm.mbed.cloud.sdk.annotations.Preamble;
import com.arm.mbed.cloud.sdk.common.SDKModel;

@Preamble(description = "Account")
public class Account implements SDKModel {
    /**
     * 
     */
    private static final long serialVersionUID = -2328282179161226623L;

    /**
     * Account ID
     */
    private String id;

    /**
     * Status of the account.
     */
    @DefaultValue(value = "SUSPENDED")
    private AccountStatus status;

    /**
     * The display name for the account.
     */
    private String displayName;

    /**
     * The name of the contact person for this account.
     */
    private String contact;
    /**
     * The name of the company owning this account.
     */
    private String company;

    /**
     * Phone number of the company
     */
    private String phoneNumber;

    /**
     * Postal code part of the postal address.
     */
    private String postCode;

    /**
     * Postal address line 1.
     */
    private String addressLine1;

    /**
     * Postal address line 2.
     */
    private String addressLine2;

    /**
     * City part of postal address.
     */
    private String city;

    /**
     * State part of postal address.
     */
    private String state;
    /**
     * Country part of postal address.
     */
    private String country;
    /**
     * Company email address for this account.
     */
    private String email;
    /**
     * Flag (true/false) indicating whether Factory Tool is allowed to download or not.
     */
    @DefaultValue(value = "true")
    private boolean provisioningAllowed;

    /**
     * List of aliases.
     */
    private List<String> aliases;

    /**
     * The tier level of the account; &#39;0&#39;: free tier, commercial account. Other values are reserved for the
     * future.
     */
    private String tierLevel;

    /**
     * Account creation UTC time RFC3339.
     */
    @DefaultValue(value = "now()")
    private Date createdAt;
    /**
     * Time when upgraded to commercial account in UTC format RFC3339.
     */
    @DefaultValue(value = "now()")
    private Date upgradedAt;
    /**
     * List of limits as key-value pairs if requested.
     */
    private Map<String, String> limits;

    /**
     * Account template ID.
     */
    private String templateId;

    public Account() {
        this(null, AccountStatus.getDefault(), null, null, null, null, null, null, null, null, null, null, null, true,
                null, null, new Date(), new Date(), null, null);
    }

    @Internal
    public Account(String id, AccountStatus status, String displayName, String contact, String company,
            String phoneNumber, String postCode, String addressLine1, String addressLine2, String city, String state,
            String country, String email, boolean provisioningAllowed, List<String> aliases, String tierLevel,
            Date createdAt, Date upgradedAt, Map<String, String> limits, String templateId) {
        super();
        setId(id);
        setStatus(status);
        setDisplayName(displayName);
        setContact(contact);
        setCompany(company);
        setPhoneNumber(phoneNumber);
        setPostCode(postCode);
        setAddressLine1(addressLine1);
        setAddressLine2(addressLine2);
        setCity(city);
        setState(state);
        setCountry(country);
        setEmail(email);
        setProvisioningAllowed(provisioningAllowed);
        setAliases(aliases);
        setTierLevel(tierLevel);
        setCreatedAt(createdAt);
        setUpgradedAt(upgradedAt);
        setLimits(limits);
        setTemplateId(templateId);
    }

    /**
     * @return the status
     */
    public AccountStatus getStatus() {
        return status;
    }

    /**
     * @param status
     *            the status to set
     */
    public void setStatus(AccountStatus status) {
        this.status = status;
    }

    /**
     * @return the id
     */
    public String getId() {
        return id;
    }

    /**
     * @param id
     *            the id to set
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * similar to setId()
     * 
     * @param id
     *            the id to set
     */
    @Internal
    public void setAccountId(String id) {
        setId(id);
    }

    /**
     * @return the displayName
     */
    public String getDisplayName() {
        return displayName;
    }

    /**
     * @param displayName
     *            the displayName to set
     */
    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

    /**
     * @return the contact
     */
    public String getContact() {
        return contact;
    }

    /**
     * @param contact
     *            the contact to set
     */
    public void setContact(String contact) {
        this.contact = contact;
    }

    /**
     * @return the company
     */
    public String getCompany() {
        return company;
    }

    /**
     * @param company
     *            the company to set
     */
    public void setCompany(String company) {
        this.company = company;
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
     * @return the postCode
     */
    public String getPostCode() {
        return postCode;
    }

    /**
     * @param postCode
     *            the postCode to set
     */
    public void setPostCode(String postCode) {
        this.postCode = postCode;
    }

    /**
     * @return the addressLine1
     */
    public String getAddressLine1() {
        return addressLine1;
    }

    /**
     * @param addressLine1
     *            the addressLine1 to set
     */
    public void setAddressLine1(String addressLine1) {
        this.addressLine1 = addressLine1;
    }

    /**
     * @return the addressLine2
     */
    public String getAddressLine2() {
        return addressLine2;
    }

    /**
     * @param addressLine2
     *            the addressLine2 to set
     */
    public void setAddressLine2(String addressLine2) {
        this.addressLine2 = addressLine2;
    }

    /**
     * @return the city
     */
    public String getCity() {
        return city;
    }

    /**
     * @param city
     *            the city to set
     */
    public void setCity(String city) {
        this.city = city;
    }

    /**
     * @return the state
     */
    public String getState() {
        return state;
    }

    /**
     * @param state
     *            the state to set
     */
    public void setState(String state) {
        this.state = state;
    }

    /**
     * @return the country
     */
    public String getCountry() {
        return country;
    }

    /**
     * @param country
     *            the country to set
     */
    public void setCountry(String country) {
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
     * @return the aliases
     */
    public List<String> getAliases() {
        return aliases;
    }

    /**
     * @param aliases
     *            the aliases to set
     */
    public void setAliases(List<String> aliases) {
        this.aliases = aliases;
    }

    /**
     * Add a new alias to the account
     * 
     * @param alias
     *            to add
     */
    public void addAliases(String alias) {
        if (alias != null && !alias.isEmpty()) {
            if (aliases == null) {
                aliases = new LinkedList<>();
            }
            aliases.add(alias);
        }
    }

    /**
     * @return the tierLevel
     */
    public String getTierLevel() {
        return tierLevel;
    }

    /**
     * @param tierLevel
     *            the tierLevel to set
     */
    public void setTierLevel(String tierLevel) {
        this.tierLevel = tierLevel;
    }

    /**
     * @return the createdAt
     */
    public Date getCreatedAt() {
        return createdAt;
    }

    /**
     * @param createdAt
     *            the createdAt to set
     */
    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    /**
     * @return the upgradedAt
     */
    public Date getUpgradedAt() {
        return upgradedAt;
    }

    /**
     * @param upgradedAt
     *            the upgradedAt to set
     */
    public void setUpgradedAt(Date upgradedAt) {
        this.upgradedAt = upgradedAt;
    }

    /**
     * @return the limits
     */
    public Map<String, String> getLimits() {
        return limits;
    }

    /**
     * @param limits
     *            the limits to set
     */
    public void setLimits(Map<String, String> limits) {
        this.limits = limits;
    }

    /**
     * @return the templateId
     */
    public String getTemplateId() {
        return templateId;
    }

    /**
     * @param templateId
     *            the templateId to set
     */
    public void setTemplateId(String templateId) {
        this.templateId = templateId;
    }

    /*
     * (non-Javadoc)
     * 
     * @see java.lang.Object#clone()
     */
    @Override
    public Account clone() throws CloneNotSupportedException {
        return new Account(id, status, displayName, contact, company, phoneNumber, postCode, addressLine1, addressLine2,
                city, state, country, email, provisioningAllowed, aliases, tierLevel, createdAt, upgradedAt, limits,
                templateId);
    }

}
