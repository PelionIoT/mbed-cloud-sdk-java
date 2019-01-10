// This file was generated by the Pelion SDK foundation code generator.
// This is an autogenerated abstract class. Do not modify its contents.
// Code customisation should happen in the child class [SubtenantTrustedCertificate]
package com.arm.mbed.cloud.sdk.security.model;

import java.util.Date;
import java.util.Objects;

import com.arm.mbed.cloud.sdk.annotations.Internal;
import com.arm.mbed.cloud.sdk.annotations.Preamble;
import com.arm.mbed.cloud.sdk.annotations.Required;
import com.arm.mbed.cloud.sdk.common.SdkModel;

/**
 * Model for a subtenant trusted certificate.
 */
@Preamble(description = "Model for a subtenant trusted certificate.")
@SuppressWarnings("PMD.CyclomaticComplexity")
public abstract class AbstractSubtenantTrustedCertificate implements SdkModel {
    /**
     * Serialisation Id.
     */
    private static final long serialVersionUID = -167468309812192L;

    /**
     * The ID of the account.
     */
    @Required
    protected String accountId;

    /**
     * X509.v3 trusted certificate in PEM format.
     */
    @Required
    protected String certificate;

    /**
     * A SHA-256 fingerprint of the certificate.
     */
    protected String certificateFingerprint;

    /**
     * Creation UTC time RFC3339.
     */
    protected Date createdAt;

    /**
     * Human readable description of this certificate.
     */
    protected String description;

    /**
     * Device execution mode where 1 means a developer certificate.
     */
    protected int deviceExecutionMode;

    /**
     * If true, signature is not required. Default value false.
     */
    protected boolean enrollmentMode;

    /**
     * Entity ID.
     */
    @Required
    protected String id;

    /**
     * Issuer of the certificate.
     */
    protected String issuer;

    /**
     * Certificate name.
     */
    @Required
    protected String name;

    /**
     * The ID of the owner.
     */
    protected String ownerId;

    /**
     * Service name where the certificate is to be used.
     */
    @Required
    protected SubtenantTrustedCertificateService service;

    /**
     * Status of the certificate.
     */
    protected SubtenantTrustedCertificateStatus status;

    /**
     * Subject of the certificate.
     */
    protected String subject;

    /**
     * Last update UTC time RFC3339.
     */
    protected Date updatedAt;

    /**
     * Expiration time in UTC formatted as RFC3339.
     */
    protected Date validity;

    /**
     * Internal constructor.
     * <p>
     * Note: Should not be used. Use {@link #AbstractSubtenantTrustedCertificate()} instead.
     * 
     * @param accountId
     *            The ID of the account.
     * @param certificate
     *            X509.v3 trusted certificate in PEM format.
     * @param certificateFingerprint
     *            A SHA-256 fingerprint of the certificate.
     * @param createdAt
     *            Creation UTC time RFC3339.
     * @param description
     *            Human readable description of this certificate.
     * @param deviceExecutionMode
     *            Device execution mode where 1 means a developer certificate.
     * @param enrollmentMode
     *            If true, signature is not required. Default value false.
     * @param id
     *            Entity ID.
     * @param issuer
     *            Issuer of the certificate.
     * @param name
     *            Certificate name.
     * @param ownerId
     *            The ID of the owner.
     * @param service
     *            Service name where the certificate is to be used.
     * @param status
     *            Status of the certificate.
     * @param subject
     *            Subject of the certificate.
     * @param updatedAt
     *            Last update UTC time RFC3339.
     * @param validity
     *            Expiration time in UTC formatted as RFC3339.
     */
    @Internal
    @SuppressWarnings("PMD.CyclomaticComplexity")
    public AbstractSubtenantTrustedCertificate(String accountId, String certificate, String certificateFingerprint,
                                               Date createdAt, String description, int deviceExecutionMode,
                                               boolean enrollmentMode, String id, String issuer, String name,
                                               String ownerId, SubtenantTrustedCertificateService service,
                                               SubtenantTrustedCertificateStatus status, String subject, Date updatedAt,
                                               Date validity) {
        super();
        setAccountId(accountId);
        setCertificate(certificate);
        setCertificateFingerprint(certificateFingerprint);
        setCreatedAt(createdAt);
        setDescription(description);
        setDeviceExecutionMode(deviceExecutionMode);
        setEnrollmentMode(enrollmentMode);
        setId(id);
        setIssuer(issuer);
        setName(name);
        setOwnerId(ownerId);
        setService(service);
        setStatus(status);
        setSubject(subject);
        setUpdatedAt(updatedAt);
        setValidity(validity);
    }

    /**
     * Internal constructor.
     * <p>
     * Note: Should not be used. Use {@link #AbstractSubtenantTrustedCertificate()} instead.
     * 
     * @param abstractSubtenantTrustedCertificate
     *            an abstract subtenant trusted certificate.
     */
    @Internal
    public AbstractSubtenantTrustedCertificate(AbstractSubtenantTrustedCertificate abstractSubtenantTrustedCertificate) {
        this(abstractSubtenantTrustedCertificate == null ? (String) null
                                                         : abstractSubtenantTrustedCertificate.accountId,
             abstractSubtenantTrustedCertificate == null ? (String) null
                                                         : abstractSubtenantTrustedCertificate.certificate,
             abstractSubtenantTrustedCertificate == null ? (String) null
                                                         : abstractSubtenantTrustedCertificate.certificateFingerprint,
             abstractSubtenantTrustedCertificate == null ? new java.util.Date()
                                                         : abstractSubtenantTrustedCertificate.createdAt,
             abstractSubtenantTrustedCertificate == null ? (String) null
                                                         : abstractSubtenantTrustedCertificate.description,
             abstractSubtenantTrustedCertificate == null ? 0 : abstractSubtenantTrustedCertificate.deviceExecutionMode,
             abstractSubtenantTrustedCertificate != null && abstractSubtenantTrustedCertificate.enrollmentMode,
             abstractSubtenantTrustedCertificate == null ? (String) null : abstractSubtenantTrustedCertificate.id,
             abstractSubtenantTrustedCertificate == null ? (String) null : abstractSubtenantTrustedCertificate.issuer,
             abstractSubtenantTrustedCertificate == null ? (String) null : abstractSubtenantTrustedCertificate.name,
             abstractSubtenantTrustedCertificate == null ? (String) null : abstractSubtenantTrustedCertificate.ownerId,
             abstractSubtenantTrustedCertificate == null ? SubtenantTrustedCertificateService.getDefault()
                                                         : abstractSubtenantTrustedCertificate.service,
             abstractSubtenantTrustedCertificate == null ? SubtenantTrustedCertificateStatus.getDefault()
                                                         : abstractSubtenantTrustedCertificate.status,
             abstractSubtenantTrustedCertificate == null ? (String) null : abstractSubtenantTrustedCertificate.subject,
             abstractSubtenantTrustedCertificate == null ? new java.util.Date()
                                                         : abstractSubtenantTrustedCertificate.updatedAt,
             abstractSubtenantTrustedCertificate == null ? new java.util.Date()
                                                         : abstractSubtenantTrustedCertificate.validity);
    }

    /**
     * Constructor.
     */
    public AbstractSubtenantTrustedCertificate() {
        this((String) null, (String) null, (String) null, new java.util.Date(), (String) null, 0, false, (String) null,
             (String) null, (String) null, (String) null, SubtenantTrustedCertificateService.getDefault(),
             SubtenantTrustedCertificateStatus.getDefault(), (String) null, new java.util.Date(), new java.util.Date());
    }

    /**
     * Constructor.
     * 
     * @param id
     *            Entity ID.
     */
    public AbstractSubtenantTrustedCertificate(String id) {
        this();
        setId(id);
    }

    /**
     * Constructor.
     * 
     * @param accountId
     *            The ID of the account.
     * @param certificate
     *            X509.v3 trusted certificate in PEM format.
     * @param id
     *            Entity ID.
     * @param name
     *            Certificate name.
     * @param service
     *            Service name where the certificate is to be used.
     */
    public AbstractSubtenantTrustedCertificate(String accountId, String certificate, String id, String name,
                                               SubtenantTrustedCertificateService service) {
        this(accountId, certificate, (String) null, new java.util.Date(), (String) null, 0, false, id, (String) null,
             name, (String) null, service, SubtenantTrustedCertificateStatus.getDefault(), (String) null,
             new java.util.Date(), new java.util.Date());
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
     * Gets x509.v3 trusted certificate in pem format.
     * 
     * @return certificate
     */
    public String getCertificate() {
        return certificate;
    }

    /**
     * Sets x509.v3 trusted certificate in pem format.
     * 
     * @param certificate
     *            X509.v3 trusted certificate in PEM format.
     */
    @Required
    public void setCertificate(String certificate) {
        this.certificate = certificate;
    }

    /**
     * Checks whether certificate value is valid.
     * 
     * @return true if the value is valid; false otherwise.
     */
    @SuppressWarnings("PMD.UselessParentheses")
    public boolean isCertificateValid() {
        return certificate != null;
    }

    /**
     * Gets a sha-256 fingerprint of the certificate.
     * 
     * @return certificateFingerprint
     */
    public String getCertificateFingerprint() {
        return certificateFingerprint;
    }

    /**
     * Sets a sha-256 fingerprint of the certificate.
     * 
     * @param certificateFingerprint
     *            A SHA-256 fingerprint of the certificate.
     */
    public void setCertificateFingerprint(String certificateFingerprint) {
        this.certificateFingerprint = certificateFingerprint;
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
     * Gets human readable description of this certificate.
     * 
     * @return description
     */
    public String getDescription() {
        return description;
    }

    /**
     * Sets human readable description of this certificate.
     * 
     * @param description
     *            Human readable description of this certificate.
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * Gets device execution mode where 1 means a developer certificate.
     * 
     * @return deviceExecutionMode
     */
    public int getDeviceExecutionMode() {
        return deviceExecutionMode;
    }

    /**
     * Sets device execution mode where 1 means a developer certificate.
     * 
     * @param deviceExecutionMode
     *            Device execution mode where 1 means a developer certificate.
     */
    public void setDeviceExecutionMode(int deviceExecutionMode) {
        this.deviceExecutionMode = deviceExecutionMode;
    }

    /**
     * Gets if true, signature is not required. default value false.
     * 
     * @return enrollmentMode
     */
    public boolean isEnrollmentMode() {
        return enrollmentMode;
    }

    /**
     * Sets if true, signature is not required. default value false.
     * 
     * @param enrollmentMode
     *            If true, signature is not required. Default value false.
     */
    public void setEnrollmentMode(boolean enrollmentMode) {
        this.enrollmentMode = enrollmentMode;
    }

    /**
     * Gets entity id.
     * 
     * @return id
     */
    @Override
    public String getId() {
        return id;
    }

    /**
     * Sets entity id.
     * 
     * @param id
     *            Entity ID.
     */
    @Override
    @Required
    public void setId(String id) {
        this.id = id;
    }

    /**
     * Sets entity id.
     * <p>
     * Similar to {@link #setId(String)}
     * 
     * @param subtenantTrustedCertificateId
     *            Entity ID.
     */
    @Internal
    @Required
    public void setSubtenantTrustedCertificateId(String subtenantTrustedCertificateId) {
        setId(subtenantTrustedCertificateId);
    }

    /**
     * Checks whether id value is valid.
     * 
     * @return true if the value is valid; false otherwise.
     */
    @SuppressWarnings("PMD.UselessParentheses")
    public boolean isIdValid() {
        return id != null;
    }

    /**
     * Gets issuer of the certificate.
     * 
     * @return issuer
     */
    public String getIssuer() {
        return issuer;
    }

    /**
     * Sets issuer of the certificate.
     * 
     * @param issuer
     *            Issuer of the certificate.
     */
    public void setIssuer(String issuer) {
        this.issuer = issuer;
    }

    /**
     * Gets certificate name.
     * 
     * @return name
     */
    public String getName() {
        return name;
    }

    /**
     * Sets certificate name.
     * 
     * @param name
     *            Certificate name.
     */
    @Required
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Checks whether name value is valid.
     * 
     * @return true if the value is valid; false otherwise.
     */
    @SuppressWarnings("PMD.UselessParentheses")
    public boolean isNameValid() {
        return name != null;
    }

    /**
     * Gets the id of the owner.
     * 
     * @return ownerId
     */
    public String getOwnerId() {
        return ownerId;
    }

    /**
     * Sets the id of the owner.
     * 
     * @param ownerId
     *            The ID of the owner.
     */
    public void setOwnerId(String ownerId) {
        this.ownerId = ownerId;
    }

    /**
     * Gets service name where the certificate is to be used.
     * 
     * @return service
     */
    public SubtenantTrustedCertificateService getService() {
        return service;
    }

    /**
     * Sets service name where the certificate is to be used.
     * 
     * @param service
     *            Service name where the certificate is to be used.
     */
    @Required
    public void setService(SubtenantTrustedCertificateService service) {
        this.service = service;
    }

    /**
     * Checks whether service value is valid.
     * 
     * @return true if the value is valid; false otherwise.
     */
    @SuppressWarnings("PMD.UselessParentheses")
    public boolean isServiceValid() {
        return service != null;
    }

    /**
     * Gets status of the certificate.
     * 
     * @return status
     */
    public SubtenantTrustedCertificateStatus getStatus() {
        return status;
    }

    /**
     * Sets status of the certificate.
     * 
     * @param status
     *            Status of the certificate.
     */
    public void setStatus(SubtenantTrustedCertificateStatus status) {
        this.status = status;
    }

    /**
     * Gets subject of the certificate.
     * 
     * @return subject
     */
    public String getSubject() {
        return subject;
    }

    /**
     * Sets subject of the certificate.
     * 
     * @param subject
     *            Subject of the certificate.
     */
    public void setSubject(String subject) {
        this.subject = subject;
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
     * Gets expiration time in utc formatted as rfc3339.
     * 
     * @return validity
     */
    public Date getValidity() {
        return validity;
    }

    /**
     * Sets expiration time in utc formatted as rfc3339.
     * 
     * @param validity
     *            Expiration time in UTC formatted as RFC3339.
     */
    public void setValidity(Date validity) {
        this.validity = validity;
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
        return other instanceof SubtenantTrustedCertificate;
    }

    /**
     * Clones this instance.
     * <p>
     * 
     * @see java.lang.Object#clone()
     * @return a cloned instance
     */
    @Override
    public abstract Object clone();

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
        result = prime * result + ((certificate == null) ? 0 : certificate.hashCode());
        result = prime * result + ((certificateFingerprint == null) ? 0 : certificateFingerprint.hashCode());
        result = prime * result + ((createdAt == null) ? 0 : createdAt.hashCode());
        result = prime * result + ((description == null) ? 0 : description.hashCode());
        result = prime * result + Objects.hashCode(deviceExecutionMode);
        result = prime * result + Objects.hashCode(enrollmentMode);
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        result = prime * result + ((issuer == null) ? 0 : issuer.hashCode());
        result = prime * result + ((name == null) ? 0 : name.hashCode());
        result = prime * result + ((ownerId == null) ? 0 : ownerId.hashCode());
        result = prime * result + ((service == null) ? 0 : service.hashCode());
        result = prime * result + ((status == null) ? 0 : status.hashCode());
        result = prime * result + ((subject == null) ? 0 : subject.hashCode());
        result = prime * result + ((updatedAt == null) ? 0 : updatedAt.hashCode());
        result = prime * result + ((validity == null) ? 0 : validity.hashCode());
        return result;
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
        if (!(obj instanceof AbstractSubtenantTrustedCertificate)) {
            return false;
        }
        final AbstractSubtenantTrustedCertificate other = (AbstractSubtenantTrustedCertificate) obj;
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
        if (certificate == null) {
            if (other.certificate != null) {
                return false;
            }
        } else if (!certificate.equals(other.certificate)) {
            return false;
        }
        if (certificateFingerprint == null) {
            if (other.certificateFingerprint != null) {
                return false;
            }
        } else if (!certificateFingerprint.equals(other.certificateFingerprint)) {
            return false;
        }
        if (createdAt == null) {
            if (other.createdAt != null) {
                return false;
            }
        } else if (!createdAt.equals(other.createdAt)) {
            return false;
        }
        if (description == null) {
            if (other.description != null) {
                return false;
            }
        } else if (!description.equals(other.description)) {
            return false;
        }
        if (deviceExecutionMode != other.deviceExecutionMode) {
            return false;
        }
        if (enrollmentMode != other.enrollmentMode) {
            return false;
        }
        if (id == null) {
            if (other.id != null) {
                return false;
            }
        } else if (!id.equals(other.id)) {
            return false;
        }
        if (issuer == null) {
            if (other.issuer != null) {
                return false;
            }
        } else if (!issuer.equals(other.issuer)) {
            return false;
        }
        if (name == null) {
            if (other.name != null) {
                return false;
            }
        } else if (!name.equals(other.name)) {
            return false;
        }
        if (ownerId == null) {
            if (other.ownerId != null) {
                return false;
            }
        } else if (!ownerId.equals(other.ownerId)) {
            return false;
        }
        if (service != other.service) {
            return false;
        }
        if (status != other.status) {
            return false;
        }
        if (subject == null) {
            if (other.subject != null) {
                return false;
            }
        } else if (!subject.equals(other.subject)) {
            return false;
        }
        if (updatedAt == null) {
            if (other.updatedAt != null) {
                return false;
            }
        } else if (!updatedAt.equals(other.updatedAt)) {
            return false;
        }
        if (validity == null) {
            if (other.validity != null) {
                return false;
            }
        } else if (!validity.equals(other.validity)) {
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
        return "AbstractSubtenantTrustedCertificate [accountId=" + accountId + ", certificate=" + certificate
               + ", certificateFingerprint=" + certificateFingerprint + ", createdAt=" + createdAt + ", description="
               + description + ", deviceExecutionMode=" + deviceExecutionMode + ", enrollmentMode=" + enrollmentMode
               + ", id=" + id + ", issuer=" + issuer + ", name=" + name + ", ownerId=" + ownerId + ", service="
               + service + ", status=" + status + ", subject=" + subject + ", updatedAt=" + updatedAt + ", validity="
               + validity + "]";
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
        return isAccountIdValid() && isCertificateValid() && isIdValid() && isNameValid() && isServiceValid();
    }
}
