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
import com.arm.mbed.cloud.sdk.common.SdkUtils;

@Preamble(description = "Account")
public class Account implements SdkModel {
    private static final String NOW = "now()";
    public static final long DEFAULT_EXPIRY_WARNING = 0;
    private static final String DEFAULT_EXPIRY_WARNING_STRING = "0";

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
     * Customer reference.
     */
    private final String customerNumber;
    /**
     * Email address of the sales contact.
     */
    private final String salesContactEmail;
    /**
     * Contract number of the customer.
     */
    private final String contractNumber;
    /**
     * Account specific custom properties.
     */
    private CustomProperties customProperties;
    /**
     * Number of days before an email should be sent to notify account expiration.
     */
    @DefaultValue(value = DEFAULT_EXPIRY_WARNING_STRING)
    private long expiryWarning;
    /**
     * List of notification email addresses.
     */
    private List<String> notificationEmails;
    /**
     * The enforcement status of the multi-factor authentication.
     */
    private MultifactorAuthenticationStatus multifactorAuthenticationStatus;
    /**
     * List of aliases.
     */
    private List<String> aliases;
    /**
     * A reference note for updating the status of the account.
     */
    private final String referenceNote;

    /**
     * The tier level of the account; &#39;0&#39;: free tier, commercial account.
     */
    private final String tier;

    /**
     * Account creation.
     */
    @DefaultValue(value = NOW)
    private final Date createdAt;
    /**
     * Time when upgraded to commercial account.
     */
    @DefaultValue(value = NOW)
    private final Date upgradedAt;
    /**
     * Time when upgraded to commercial account.
     */
    @DefaultValue(value = NOW)
    private final Date updatedAt;
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
        this(null, AccountStatus.getDefault(), null, null, null, null, null, new Date(), new Date(), new Date(), null,
                null, null, null);

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
     * @param customerNumber
     *            customerNumber
     * @param salesContactEmail
     *            salesContactEmail
     * @param contractNumber
     *            contractNumber
     * @param referenceNote
     *            referenceNote
     * @param tier
     *            tier
     * @param createdAt
     *            createdAt
     * @param upgradedAt
     *            upgradedAt
     * @param updatedAt
     *            updatedAt
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
    public Account(String id, AccountStatus status, String customerNumber, String salesContactEmail,
            String contractNumber, String referenceNote, String tier, Date createdAt, Date upgradedAt, Date updatedAt,
            Map<String, String> limits, List<Policy> policies, String templateId, String reason) {
        this(id, status, null, null, null, null, null, null, null, null, null, null, null, customerNumber,
                salesContactEmail, contractNumber, null, DEFAULT_EXPIRY_WARNING, null,
                MultifactorAuthenticationStatus.getDefault(), null, referenceNote, tier, createdAt, upgradedAt,
                updatedAt, limits, policies, templateId, reason);
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
     * @param contractNumber
     *            contractNumber
     * @param customerNumber
     *            customerNumber
     * @param referenceNote
     *            referenceNote
     * @param salesContactEmail
     *            salesContactEmail
     * @param updatedAt
     *            updatedAt
     * @param customProperties
     *            customProperties
     * @param expiryWarning
     *            expiryWarning
     * @param multifactorAuthenticationStatus
     *            multifactorAuthenticationStatus
     * @param notificationEmailAddresses
     *            notificationEmailAddresses
     */
    @Internal
    protected Account(String id, AccountStatus status, String displayName, String contact, String company,
            String phoneNumber, String postcode, String addressLine1, String addressLine2, String city, String state,
            String country, String email, String customerNumber, String salesContactEmail, String contractNumber,
            CustomProperties customProperties, long expiryWarning, List<String> notificationEmailAddresses,
            MultifactorAuthenticationStatus multifactorAuthenticationStatus, List<String> aliases, String referenceNote,
            String tier, Date createdAt, Date upgradedAt, Date updatedAt, Map<String, String> limits,
            List<Policy> policies, String templateId, String reason) {
        super();
        setId(id);
        this.status = status;
        this.tier = tier;
        this.createdAt = createdAt;
        this.upgradedAt = upgradedAt;
        this.limits = limits;
        this.templateId = templateId;
        this.policies = policies;
        this.reason = reason;

        this.contractNumber = contractNumber;
        this.customerNumber = customerNumber;
        this.referenceNote = referenceNote;
        this.salesContactEmail = salesContactEmail;
        this.updatedAt = updatedAt;
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
        setAdditionalFields(customProperties);
        setExpiryWarning(expiryWarning);
        setMultifactorAuthenticationStatus(multifactorAuthenticationStatus);
        setNotificationEmails(notificationEmailAddresses);
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
    public void setAliasesFromString(String aliases) {
        setAliases(SdkUtils.parseListString(aliases));
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
     * States whether the account has custom properties or not.
     *
     * @return true if so. False otherwise.
     */
    public boolean hasAdditionalFields() {
        return customProperties != null && !customProperties.isEmpty();
    }

    /**
     * Gets account custom properties.
     *
     * @return the custom properties as a hashmap
     */
    public Map<String, String> getCustomFields() {
        return hasAdditionalFields() ? customProperties.getRawProperties() : null;
    }

    /**
     * Gets account custom properties.
     *
     * @return the custom properties
     */
    public CustomProperties getAdditionalFields() {
        return customProperties;
    }

    /**
     * Sets account custom properties.
     *
     * @param customProperties
     *            the customProperties to set
     */
    public void setAdditionalFields(CustomProperties customProperties) {
        this.customProperties = customProperties;
    }

    /**
     * Sets account custom properties from a Json string.
     * <p>
     * Note: Similar to {@link #setAdditionalFields(CustomProperties)}
     *
     * @param customProperties
     *            Json string describing the custom attributes
     */
    public void setCustomFieldsFromJson(String customProperties) {
        setAdditionalFields(new CustomProperties(customProperties));
    }

    /**
     * Sets account custom properties from a hashMap.
     * <p>
     * Note: Prefer using {@link #setAdditionalFields(CustomProperties)} instead
     *
     * @param customProperties
     *            hashmap describing the custom properties
     */
    public void setCustomFields(Map<String, String> customProperties) {
        setAdditionalFields(new CustomProperties(customProperties));
    }

    /**
     * Gets account custom properties.
     * <p>
     * Note: Similar to {@link #getCustomFields()}
     *
     * @return the custom properties
     */
    @Deprecated
    public Map<String, Map<String, String>> getCustomProperties() {
        return hasAdditionalFields() ? customProperties.getPropertiesInFormerFormat() : null;
    }

    /**
     * Sets account custom properties from an Object.
     * <p>
     * Note: Similar to {@link #setAdditionalFields(CustomProperties)}
     *
     * @param obj
     *            object describing the custom attributes
     */
    @Deprecated
    public void setCustomProperties(Object obj) {
        if (obj instanceof CustomProperties) {
            setAdditionalFields((CustomProperties) obj);
        } else if (obj instanceof String) {
            setCustomFieldsFromJson((String) obj);
        } else {
            setAdditionalFields(new CustomProperties().fromObject(obj));
        }
    }

    /**
     * Gets the number of days before a expiry warning email is sent.
     *
     * @return the expiryWarning
     */
    public long getExpiryWarning() {
        return expiryWarning;
    }

    /**
     * Sets the number of days before a expiry warning email is sent.
     *
     * @param expiryWarning
     *            number of days before email notification
     */
    public void setExpiryWarning(long expiryWarning) {
        this.expiryWarning = expiryWarning;
    }

    /**
     * Gets notification email addresses.
     *
     * @return the notificationEmailAddresses
     */
    public List<String> getNotificationEmails() {
        return notificationEmails;
    }

    /**
     * Sets notifications email addresses.
     *
     * @param notificationEmailAddresses
     *            the notificationEmailAddresses to set
     */
    public void setNotificationEmails(List<String> notificationEmailAddresses) {
        this.notificationEmails = notificationEmailAddresses;
    }

    /**
     * Gets the enforcement status of the multi-factor authentication.
     *
     * @return the multifactorAuthenticationStatus
     */
    public MultifactorAuthenticationStatus getMultifactorAuthenticationStatus() {
        return multifactorAuthenticationStatus;
    }

    /**
     * Sets the enforcement status of the multi-factor authentication.
     *
     * @param multifactorAuthenticationStatus
     *            the multifactorAuthenticationStatus to set
     */
    public void setMultifactorAuthenticationStatus(MultifactorAuthenticationStatus multifactorAuthenticationStatus) {
        this.multifactorAuthenticationStatus = multifactorAuthenticationStatus;
    }

    /**
     * Sets the status from a string representation.
     *
     * @param status
     *            the status string representation.
     */
    public void setMultifactorAuthenticationStatus(String status) {
        setMultifactorAuthenticationStatus(MultifactorAuthenticationStatus.getStatus(status));
    }

    /**
     * Gets customer reference number.
     *
     * @return the customerNumber
     */
    public String getCustomerNumber() {
        return customerNumber;
    }

    /**
     * Gets the email address of the sales contact.
     *
     * @return the salesContactEmail
     */
    public String getSalesContactEmail() {
        return salesContactEmail;
    }

    /**
     * Gets contract number.
     *
     * @return the contractNumber
     */
    public String getContractNumber() {
        return contractNumber;
    }

    /**
     * Gets a reference note for updating the status of the account.
     *
     * @return the referenceNote
     */
    public String getReferenceNote() {
        return referenceNote;
    }

    /**
     * Gets when the account was last updated.
     *
     * @return the updatedAt
     */
    public Date getUpdatedAt() {
        return updatedAt;
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
                city, state, country, email, customerNumber, salesContactEmail, contractNumber, customProperties,
                expiryWarning, notificationEmails, multifactorAuthenticationStatus, aliases, referenceNote, tier,
                createdAt, upgradedAt, updatedAt, limits, policies, templateId, reason);
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
                + country + ", email=" + email + ", customerNumber=" + customerNumber + ", salesContactEmail="
                + salesContactEmail + ", contractNumber=" + contractNumber + ", customProperties=" + customProperties
                + ", expiryWarning=" + expiryWarning + ", notificationEmails=" + notificationEmails
                + ", multifactorAuthenticationStatus=" + multifactorAuthenticationStatus + ", aliases=" + aliases
                + ", referenceNote=" + referenceNote + ", tier=" + tier + ", createdAt=" + createdAt + ", upgradedAt="
                + upgradedAt + ", updatedAt=" + updatedAt + ", limits=" + limits + ", policies=" + policies
                + ", templateId=" + templateId + ", reason=" + reason + "]";
    }

}
