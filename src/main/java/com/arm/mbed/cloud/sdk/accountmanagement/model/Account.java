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
import com.arm.mbed.cloud.sdk.common.SdkModel;
import com.arm.mbed.cloud.sdk.common.SdkModelUtils;

@Preamble(description = "Account")
public class Account implements SdkModel {
    /**
     * Serialisation Id.
     */
    private static final long serialVersionUID = -2328282179161226623L;

    /**
     * Account ID.
     */
    private String id;

    /**
     * Status of the account.
     */
    private final AccountStatus status;

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
     * Phone number of the company.
     */
    private String phoneNumber;

    /**
     * Postal code part of the postal address.
     */
    private String postcode;

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
    private final boolean provisioningAllowed;

    /**
     * List of aliases.
     */
    private List<String> aliases;

    /**
     * The tier level of the account; &#39;0&#39;: free tier, commercial account. Other values are reserved for the
     * future.
     */
    private final String tier;

    /**
     * Account creation UTC time RFC3339.
     */
    @DefaultValue(value = "now()")
    private final Date createdAt;
    /**
     * Time when upgraded to commercial account in UTC format RFC3339.
     */
    @DefaultValue(value = "now()")
    private final Date upgradedAt;
    /**
     * List of limits as key-value pairs if requested.
     */
    private final Map<String, String> limits;
    /**
     * List of policies.
     */
    private final List<Policy> policies;
    /**
     * Account template ID.
     */
    private final String templateId;

    /**
     * A reason note for updating the status of the account.
     */
    private final String reason;

    /**
     * Constructor for an account.
     * <p>
     * Other constructors are for internal usage only.
     */
    public Account() {
        this(null, AccountStatus.getDefault(), true, null, new Date(), new Date(), null, null, null, null);
    }

    /**
     * Internal constructor.
     * <p>
     * Note: Should not be used. Use {@link #Account()} instead.
     *
     * @param id
     *            id
     * @param status
     *            status
     * @param provisioningAllowed
     *            provisioningAllowed
     * @param tierLevel
     *            tierLevel
     * @param createdAt
     *            createdAt
     * @param upgradedAt
     *            upgradedAt
     * @param limits
     *            limits
     * @param policies
     *            policies
     * @param templateId
     *            templateId
     * @param reason
     *            reason
     */
    @Internal
    public Account(String id, AccountStatus status, boolean provisioningAllowed, String tierLevel, Date createdAt,
            Date upgradedAt, Map<String, String> limits, List<Policy> policies, String templateId, String reason) {
        this(id, status, null, null, null, null, null, null, null, null, null, null, null, provisioningAllowed, null,
                tierLevel, createdAt, upgradedAt, limits, policies, templateId, reason);
    }

    /**
     * Internal constructor.
     * <p>
     * Note: Should not be used. Use {@link #Account()} instead.
     *
     * @param id
     *            id
     * @param status
     *            status
     * @param displayName
     *            displayName
     * @param contact
     *            contact
     * @param company
     *            company
     * @param phoneNumber
     *            phoneNumber
     * @param postcode
     *            postcode
     * @param addressLine1
     *            addressLine1
     *
     * @param addressLine2
     *            addressLine2
     * @param city
     *            city
     * @param state
     *            state
     * @param country
     *            country
     * @param email
     *            email
     * @param provisioningAllowed
     *            provisioningAllowed
     * @param aliases
     *            aliases
     * @param tier
     *            tier Level
     * @param createdAt
     *            createdAt
     * @param upgradedAt
     *            upgradedAt
     * @param limits
     *            limits
     * @param policies
     *            policies
     * @param templateId
     *            templateId
     * @param reason
     *            reason
     */
    @Internal
    protected Account(String id, AccountStatus status, String displayName, String contact, String company,
            String phoneNumber, String postcode, String addressLine1, String addressLine2, String city, String state,
            String country, String email, boolean provisioningAllowed, List<String> aliases, String tier,
            Date createdAt, Date upgradedAt, Map<String, String> limits, List<Policy> policies, String templateId,
            String reason) {
        super();
        setId(id);
        this.status = status;
        this.provisioningAllowed = provisioningAllowed;
        this.tier = tier;
        this.createdAt = createdAt;
        this.upgradedAt = upgradedAt;
        this.limits = limits;
        this.templateId = templateId;
        this.policies = policies;
        this.reason = reason;
        setAliases(aliases);
        setDisplayName(displayName);
        setContact(contact);
        setCompany(company);
        setPhoneNumber(phoneNumber);
        setPostcode(postcode);
        setAddressLine1(addressLine1);
        setAddressLine2(addressLine2);
        setCity(city);
        setState(state);
        setCountry(country);
        setEmail(email);
    }

    /**
     * Gets the status.
     *
     * @return the status.
     */
    public AccountStatus getStatus() {
        return status;
    }

    /**
     * Gets the id.
     *
     * @return the id
     */
    @Override
    public String getId() {
        return id;
    }

    /**
     * Sets the id.
     *
     * @param id
     *            the id to set
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * Sets the id.
     * <p>
     * Similar to {@link #setId(String)}.
     *
     * @param id
     *            the id to set.
     */
    @Internal
    public void setAccountId(String id) {
        setId(id);
    }

    /**
     * Gets display name.
     *
     * @return the displayName.
     */
    public String getDisplayName() {
        return displayName;
    }

    /**
     * Sets display name.
     *
     * @param displayName
     *            the displayName to set.
     */
    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

    /**
     * Gets the contact.
     *
     * @return the contact.
     */
    public String getContact() {
        return contact;
    }

    /**
     * Sets the contact.
     *
     * @param contact
     *            the contact to set.
     */
    public void setContact(String contact) {
        this.contact = contact;
    }

    /**
     * Gets the company.
     *
     * @return the company.
     */
    public String getCompany() {
        return company;
    }

    /**
     * Sets the company.
     *
     * @param company
     *            the company to set.
     */
    public void setCompany(String company) {
        this.company = company;
    }

    /**
     * Gets the phone number.
     *
     * @return the phoneNumber.
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
     * Gets the postcode.
     *
     * @return the postCode.
     */
    public String getPostcode() {
        return postcode;
    }

    /**
     * Sets the postcode.
     *
     * @param postcode
     *            the postcode to set.
     */
    public void setPostcode(String postcode) {
        this.postcode = postcode;
    }

    /**
     * Gets the first line of the address.
     *
     * @return the addressLine1.
     */
    public String getAddressLine1() {
        return addressLine1;
    }

    /**
     * Sets the first line of the address.
     *
     * @param addressLine1
     *            the addressLine1 to set.
     */
    public void setAddressLine1(String addressLine1) {
        this.addressLine1 = addressLine1;
    }

    /**
     * Gets the second line of the address.
     *
     * @return the addressLine2.
     */
    public String getAddressLine2() {
        return addressLine2;
    }

    /**
     * Sets the second line of the address.
     *
     * @param addressLine2
     *            the addressLine2 to set.
     */
    public void setAddressLine2(String addressLine2) {
        this.addressLine2 = addressLine2;
    }

    /**
     * Gets the city.
     *
     * @return the city.
     */
    public String getCity() {
        return city;
    }

    /**
     * Sets the city.
     *
     * @param city
     *            the city to set.
     */
    public void setCity(String city) {
        this.city = city;
    }

    /**
     * Gets the state (address).
     *
     * @return the state.
     */
    public String getState() {
        return state;
    }

    /**
     * Sets the state (address).
     *
     * @param state
     *            the state to set.
     */
    public void setState(String state) {
        this.state = state;
    }

    /**
     * Gets the country.
     *
     * @return the country.
     */
    public String getCountry() {
        return country;
    }

    /**
     * Sets the country.
     *
     * @param country
     *            the country to set.
     */
    public void setCountry(String country) {
        this.country = country;
    }

    /**
     * States whether provisioning is allowed or not.
     *
     * @return provisioningAllowed states whether provisioning is allowed.
     */
    public boolean isProvisioningAllowed() {
        return provisioningAllowed;
    }

    /**
     * Gets the email address.
     *
     * @return the email.
     */
    public String getEmail() {
        return email;
    }

    /**
     * Sets the email address.
     *
     * @param email
     *            the email to set.
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * Gets account aliases.
     *
     * @return the aliases.
     */
    public List<String> getAliases() {
        return aliases;
    }

    /**
     * Sets account aliases.
     *
     * @param aliases
     *            the aliases to set.
     */
    public void setAliases(List<String> aliases) {
        this.aliases = aliases;
    }

    /**
     * Sets account aliases.
     *
     * @param aliases
     *            the aliases to set as a string, such as "[\"arm-iot-tools\", \"AUTOTEST-BXAU54\"]" or "arm-iot-tools,
     *            AUTOTEST-BXAU54".
     */
    public void setAliases(String aliases) {
        setAliases(SdkModelUtils.parseListString(aliases));
    }

    /**
     * Adds a new alias to the account.
     *
     * @param alias
     *            to add.
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
     * Gets tier level.
     *
     * @return the tier level.
     */
    public String getTier() {
        return tier;
    }

    /**
     * Gets when account was created.
     *
     * @return the createdAt.
     */
    public Date getCreatedAt() {
        return createdAt;
    }

    /**
     * Gets when the account was upgraded.
     *
     * @return the upgradedAt.
     */
    public Date getUpgradedAt() {
        return upgradedAt;
    }

    /**
     * Gets limits.
     *
     * @return the limits
     */
    public Map<String, String> getLimits() {
        return limits;
    }

    /**
     * Gets account template id.
     *
     * @return the templateId
     */
    public String getTemplateId() {
        return templateId;
    }

    /**
     * Gets list of policies.
     * 
     * @return the policies
     */
    public List<Policy> getPolicies() {
        return policies;
    }

    /**
     * Gets the reason note for updating the status of the account.
     * 
     * @return the reason
     */
    public String getReason() {
        return reason;
    }

    /**
     * Gets a clone.
     *
     * @return a clone of this account.
     *
     * @see java.lang.Object#clone()
     */
    @Override
    public Account clone() {
        return new Account(id, status, displayName, contact, company, phoneNumber, postcode, addressLine1, addressLine2,
                city, state, country, email, provisioningAllowed, aliases, tier, createdAt, upgradedAt, limits,
                policies, templateId, reason);
    }

    /**
     * Determines whether all required fields have been set and therefore if the model instance is valid.
     *
     * @return true if instance is valid. False otherwise.
     */
    @Override
    public boolean isValid() {
        return true;
    }

    /*
     * (non-Javadoc)
     * 
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        return "Account [id=" + id + ", status=" + status + ", displayName=" + displayName + ", contact=" + contact
                + ", company=" + company + ", phoneNumber=" + phoneNumber + ", postcode=" + postcode + ", addressLine1="
                + addressLine1 + ", addressLine2=" + addressLine2 + ", city=" + city + ", state=" + state + ", country="
                + country + ", email=" + email + ", provisioningAllowed=" + provisioningAllowed + ", aliases=" + aliases
                + ", tier=" + tier + ", createdAt=" + createdAt + ", upgradedAt=" + upgradedAt + ", limits=" + limits
                + ", policies=" + policies + ", templateId=" + templateId + ", reason=" + reason + "]";
    }

}
