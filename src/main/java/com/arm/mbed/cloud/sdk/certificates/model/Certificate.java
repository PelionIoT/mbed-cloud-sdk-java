package com.arm.mbed.cloud.sdk.certificates.model;

import java.util.Date;

import com.arm.mbed.cloud.sdk.annotations.DefaultValue;
import com.arm.mbed.cloud.sdk.annotations.Internal;
import com.arm.mbed.cloud.sdk.annotations.Nullable;
import com.arm.mbed.cloud.sdk.annotations.Preamble;
import com.arm.mbed.cloud.sdk.annotations.Required;
import com.arm.mbed.cloud.sdk.common.SdkEnum;
import com.arm.mbed.cloud.sdk.common.SdkModel;

@Preamble(description = "Certificate")
public class Certificate implements SdkModel {
    public static final boolean DEFAULT_ENROLMENT_MODE = false;
    private static final String DEFAULT_ENROLMENT_MODE_STRING = "FALSE";
    /**
     * Serialisation Id.
     */
    private static final long serialVersionUID = 4006607827430203707L;
    /**
     * Entity ID.
     */
    private String id;
    /**
     * Certificate name.
     */
    @Required
    private String name;
    /**
     * The UUID of the account.
     */
    private final String accountId;
    /**
     * Status of the certificate.
     */
    @DefaultValue(value = "INACTIVE")
    private CertificateStatus status;
    /**
     * Field to keep track of an updated status.
     */
    @Internal
    private transient boolean hasStatusBeenUpdated;
    /**
     * Certificate type.
     */
    @Required
    @DefaultValue(value = "DEVELOPER")
    private CertificateType type;
    /**
     * Field to keep track of an updated type.
     */
    @Internal
    private transient boolean hasTypeBeenUpdated;
    /**
     * Human readable description of this certificate.
     */
    private String description;
    /**
     * Subject of the certificate.
     */
    private final String subject;
    /**
     * Expiration {@link Date} in UTC formatted as RFC3339.
     */
    @DefaultValue(value = "now()")
    private final Date validity;
    /**
     * Issuer of the certificate.
     */
    private final String issuer;
    /**
     * Creation time.
     */
    @DefaultValue(value = "now()")
    private final Date createdAt;
    /**
     * Bootstrap server URI to which the client needs to connect to.
     */
    private final String serverUri;
    /**
     * PEM format X.509 server certificate that will be used to validate the server certificate that will be received
     * during the TLS/DTLS handshake.
     */
    private final String serverCertificate;
    /**
     * Content of the security.c file that will be flashed into the device to provide the security credentials.
     */
    private final String headerFile;
    /**
     * PEM format X.509 developer certificate.
     */
    private final String developerCertificate;
    /**
     * PEM format developer private key associated to the certificate.
     */
    private final String developerPrivateKey;
    /**
     * The UUID of the certificate owner (user or ApiKey).
     */
    private final String ownerId;
    /**
     * X509.v3 CA certificate in PEM or base64 encoded DER format.
     */
    private String certificateData;
    /**
     * Field to keep track of an updated data.
     */
    @Internal
    private transient boolean hasCertificateDataBeenUpdated;
    /**
     * Base64 encoded signature of the account ID signed by the certificate to be uploaded. Signature must be hashed
     * with SHA256.
     */
    @Deprecated
    private String signature;
    /**
     * Enrolment mode. Certificate is used in enrollment mode. Default value is false.
     */
    @Required
    @DefaultValue(value = DEFAULT_ENROLMENT_MODE_STRING)
    private boolean enrollmentMode;

    /**
     * Internal constructor.
     * <p>
     * Note: Should not be used. Use {@link #Certificate()} or {@link #Certificate(String, CertificateType, boolean)}
     * instead.
     *
     * @param id
     *            id
     * @param accountId
     *            accountId
     * @param subject
     *            subject
     * @param validity
     *            validity
     * @param issuer
     *            issuer
     * @param createdAt
     *            createdAt
     * @param serverUri
     *            serverUri
     * @param serverCertificate
     *            serverCertificate
     * @param headerFile
     *            headerFile
     * @param developerCertificate
     *            developerCertificate
     * @param developerPrivateKey
     *            developerPrivateKey
     * @param ownerId
     *            ownerId
     */
    @Internal
    public Certificate(String id, String accountId, String subject, Date validity, String issuer, Date createdAt,
                       String serverUri, String serverCertificate, String headerFile, String developerCertificate,
                       String developerPrivateKey, String ownerId) {
        super();
        setId(id);
        this.accountId = accountId;
        this.subject = subject;
        this.validity = validity;
        this.issuer = issuer;
        this.createdAt = createdAt;
        this.serverUri = serverUri;
        this.serverCertificate = serverCertificate;
        this.headerFile = headerFile;
        this.developerCertificate = developerCertificate;
        this.developerPrivateKey = developerPrivateKey;
        this.ownerId = ownerId;
        setCertificateData(null);
        setDescription(null);
        setName(null);
        setSignature(null);
        setStatus(CertificateStatus.getDefault());
        setType(CertificateType.getDefault());
        setEnrollmentMode(DEFAULT_ENROLMENT_MODE);
        setAsNew();

    }

    /**
     * Internal constructor.
     * <p>
     * Note: Should not be used. Use {@link #Certificate()} or {@link #Certificate(String, CertificateType, boolean)}
     * instead.
     *
     * @param id
     *            id
     * @param name
     *            name
     * @param accountId
     *            accountId
     * @param status
     *            status
     * @param type
     *            type
     * @param description
     *            description
     * @param subject
     *            subject
     * @param validity
     *            validity
     * @param issuer
     *            issuer
     * @param createdAt
     *            createdAt
     * @param serverUri
     *            serverUri
     * @param serverCertificate
     *            serverCertificate
     * @param headerFile
     *            headerFile
     * @param developerCertificate
     *            developerCertificate
     * @param developerPrivateKey
     *            developerPrivateKey
     * @param ownerId
     *            ownerId
     * @param certificateData
     *            certificateData
     * @param signature
     *            signature
     * @param enrollmentMode
     *            enrolment mode
     */
    @Internal
    public Certificate(String id, String name, String accountId, CertificateStatus status, CertificateType type,
                       String description, String subject, Date validity, String issuer, Date createdAt,
                       String serverUri, String serverCertificate, String headerFile, String developerCertificate,
                       String developerPrivateKey, String ownerId, String certificateData, String signature,
                       boolean enrollmentMode) {
        this(id, accountId, subject, validity, issuer, createdAt, serverUri, serverCertificate, headerFile,
             developerCertificate, developerPrivateKey, ownerId);
        setCertificateData(certificateData);
        setDescription(description);
        setName(name);
        setSignature(signature);
        setStatus(status);
        setType(type);
        setEnrollmentMode(enrollmentMode);
        setAsNew();
    }

    /**
     * Constructor for a certificate.
     * <p>
     * Other constructors with 'Internal' annotation are for internal usage only.
     */
    public Certificate() {
        this(null, null, null, new Date(), null, new Date(), null, null, null, null, null, null);
    }

    /**
     * Constructor for a certificate.
     * <p>
     * Other constructors with 'Internal' annotation are for internal usage only.
     *
     * @param name
     *            name of the certificate
     * @param type
     *            type of the certificate
     * @param enrollmentMode
     *            enrolment mode
     */
    public Certificate(String name, CertificateType type, boolean enrollmentMode) {
        this();
        setName(name);
        setType(type);
        setEnrollmentMode(enrollmentMode);
        setAsNew();
    }

    private void setAsNew() {
        hasCertificateDataBeenUpdated = false;
        hasStatusBeenUpdated = false;
        hasTypeBeenUpdated = false;
    }

    /**
     * Gets the Id.
     *
     * @return the id.
     */
    @Override
    public String getId() {
        return id;
    }

    /**
     * Sets the Id.
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
     *            the id to set
     */
    @Internal
    public void setCertificateId(String id) {
        setId(id);
    }

    /**
     * Gets the name.
     *
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the name.
     *
     * @param name
     *            the name to set
     */
    @Required
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Gets the status.
     *
     * @return the status
     */
    public CertificateStatus getStatus() {
        return status;
    }

    /**
     * Sets the status.
     *
     * @param status
     *            the status to set
     */
    public void setStatus(CertificateStatus status) {
        this.status = status;
        hasStatusBeenUpdated = true;
    }

    /**
     * Sets the status from a string representation.
     *
     * @param status
     *            the status string representation.
     */
    public void setStatus(String status) {
        setStatus(CertificateStatus.getStatus(status));
    }

    /**
     * Gets the type.
     *
     * @return the type
     */
    public CertificateType getType() {
        return type;
    }

    /**
     * Sets the type.
     *
     * @param type
     *            the type to set
     */
    @Required
    public void setType(CertificateType type) {
        this.type = type;
        hasTypeBeenUpdated = true;
    }

    /**
     * Sets the type from a string representation.
     *
     * @param type
     *            the type string representation
     */
    public void setType(String type) {
        setType(CertificateType.getType(type));
    }

    /**
     * Gets the description.
     *
     * @return the description
     */
    public String getDescription() {
        return description;
    }

    /**
     * Sets the description.
     *
     * @param description
     *            the description to set
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * Gets the certificate data.
     *
     * @return the certificateData
     */
    public String getCertificateData() {
        return certificateData;
    }

    /**
     * Sets the certificate data.
     *
     * @param certificateData
     *            the certificate data to set
     */
    public void setCertificateData(String certificateData) {
        this.certificateData = certificateData;
        hasCertificateDataBeenUpdated = true;
    }

    /**
     * Gets the signature.
     *
     * @return the signature
     */
    @Deprecated
    public String getSignature() {
        return signature;
    }

    /**
     * Sets the signature.
     *
     * @param signature
     *            the signature to set
     */
    @Deprecated
    public void setSignature(String signature) {
        this.signature = signature;
    }

    /**
     * Gets the account id.
     *
     * @return the accountId
     */
    public String getAccountId() {
        return accountId;
    }

    /**
     * Gets the subject.
     *
     * @return the subject
     */
    public String getSubject() {
        return subject;
    }

    /**
     * Gets the validity.
     *
     * @return the validity
     */
    public Date getValidity() {
        return validity;
    }

    /**
     * Gets the issuer.
     *
     * @return the issuer
     */
    public String getIssuer() {
        return issuer;
    }

    /**
     * Gets when the certificate was created.
     *
     * @return the createdAt
     */
    public Date getCreatedAt() {
        return createdAt;
    }

    /**
     * Gets the server URI.
     *
     * @return the serverUri
     */
    public String getServerUri() {
        return serverUri;
    }

    /**
     * Gets the server certificate.
     *
     * @return the serverCertificate
     */
    public String getServerCertificate() {
        return serverCertificate;
    }

    /**
     * Gets the header file.
     *
     * @return the headerFile
     */
    public String getHeaderFile() {
        return headerFile;
    }

    /**
     * Gets the developer certificate.
     *
     * @return the developerCertificate
     */
    public String getDeveloperCertificate() {
        return developerCertificate;
    }

    /**
     * Gets the developer private key.
     *
     * @return the developerPrivateKey
     */
    public String getDeveloperPrivateKey() {
        return developerPrivateKey;
    }

    /**
     * Gets the owner id.
     *
     * @return the ownerId
     */
    public String getOwnerId() {
        return ownerId;
    }

    /**
     * States whether the certificate is used in enrolment mode or not. Default value is false.
     *
     * @return the enrollmentMode
     */
    public boolean isEnrollmentMode() {
        return enrollmentMode;
    }

    /**
     * Sets whether the certificate is used in enrolment mode or not. Default value is false.
     *
     * @param enrollmentMode
     *            the enrollmentMode to set
     */
    @Required
    public void setEnrollmentMode(boolean enrollmentMode) {
        this.enrollmentMode = enrollmentMode;
    }

    /**
     * Checks whether the status has been modified since creation.
     *
     * @return true if the status has been modified. False otherwise.
     */
    @Internal
    public boolean hasStatusBeenUpdated() {
        return hasStatusBeenUpdated;
    }

    /**
     * Checks whether the type has been modified since creation.
     *
     * @return true if the type has been modified. False otherwise.
     */
    @Internal
    public boolean hasTypeBeenUpdated() {
        return hasTypeBeenUpdated;
    }

    /**
     * Checks whether certificate data have been modified since creation.
     *
     * @return true if the data have been modified. False otherwise.
     */
    @Internal
    public boolean hasCertificateDataBeenUpdated() {
        return hasCertificateDataBeenUpdated;
    }

    @SuppressWarnings({ "unchecked", "boxing" })
    private static <T> T mergeField(T obj1, T obj2) {
        if (obj1 == null) {
            return obj2;
        }
        if (obj2 == null) {
            return obj1;
        }
        if (obj1 instanceof SdkEnum) {
            return (T) ((SdkEnum) obj1).merge((SdkEnum) obj1, (SdkEnum) obj2);
        }
        if (obj1 instanceof Boolean && obj2 instanceof Boolean) {
            return (T) Boolean.valueOf(((Boolean) obj1) || ((Boolean) obj2));
        }
        return obj2;
    }

    /**
     * Merges two partial certificates.
     *
     * @param partial1
     *            one partial certificate.
     * @param partial2
     *            another partial certificate.
     * @return a merged certificate
     */
    @SuppressWarnings({ "boxing" })
    public static Certificate merge(@Nullable Certificate partial1, @Nullable Certificate partial2) {
        if (partial1 == null) {
            return partial2;
        }
        if (partial2 == null) {
            return partial1;
        }
        final Certificate merge = new Certificate(mergeField(partial1.getId(), partial2.getId()),
                                                  mergeField(partial1.getAccountId(), partial2.getAccountId()),
                                                  mergeField(partial1.getSubject(), partial2.getSubject()),
                                                  mergeField(partial1.getValidity(), partial2.getValidity()),
                                                  mergeField(partial1.getIssuer(), partial2.getIssuer()),
                                                  mergeField(partial1.getCreatedAt(), partial2.getCreatedAt()),
                                                  mergeField(partial1.getServerUri(), partial2.getServerUri()),
                                                  mergeField(partial1.getServerCertificate(),
                                                             partial2.getServerCertificate()),
                                                  mergeField(partial1.getHeaderFile(), partial2.getHeaderFile()),
                                                  mergeField(partial1.getDeveloperCertificate(),
                                                             partial2.getDeveloperCertificate()),
                                                  mergeField(partial1.getDeveloperPrivateKey(),
                                                             partial2.getDeveloperPrivateKey()),
                                                  mergeField(partial1.getOwnerId(), partial2.getOwnerId()));
        merge.setCertificateData(mergeField(partial1.getCertificateData(), partial2.getCertificateData()));
        merge.setDescription(mergeField(partial1.getDescription(), partial2.getDescription()));
        merge.setName(mergeField(partial1.getName(), partial2.getName()));
        merge.setSignature(mergeField(partial1.getSignature(), partial2.getSignature()));
        merge.setStatus(mergeField(partial1.getStatus(), partial2.getStatus()));
        merge.setType(mergeField(partial1.getType(), partial2.getType()));
        merge.setEnrollmentMode(mergeField(Boolean.valueOf(partial1.isEnrollmentMode()),
                                           Boolean.valueOf(partial2.isEnrollmentMode())));
        merge.setAsNew();
        return merge;
    }

    /**
     * Gets a clone.
     *
     * @return a clone.
     *
     * @see java.lang.Object#clone()
     */
    @Override
    public Certificate clone() {
        return new Certificate(id, name, accountId, status, type, description, subject, validity, issuer, createdAt,
                               serverUri, serverCertificate, headerFile, developerCertificate, developerPrivateKey,
                               ownerId, certificateData, signature, enrollmentMode);
    }

    /**
     * Determines whether all required fields have been set and therefore if the model instance is valid.
     *
     * @return true if instance is valid. False otherwise.
     */
    @Override
    public boolean isValid() {
        return name != null && type != null;
    }

    /*
     * (non-Javadoc)
     *
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        return "Certificate [id=" + id + ", name=" + name + ", accountId=" + accountId + ", status=" + status
               + ", type=" + type + ", description=" + description + ", subject=" + subject + ", validity=" + validity
               + ", issuer=" + issuer + ", createdAt=" + createdAt + ", serverUri=" + serverUri + ", serverCertificate="
               + serverCertificate + ", headerFile=" + headerFile + ", developerCertificate=" + developerCertificate
               + ", developerPrivateKey=" + developerPrivateKey + ", ownerId=" + ownerId + ", certificateData="
               + certificateData + ", enrollmentMode=" + enrollmentMode + "]";
    }

}
