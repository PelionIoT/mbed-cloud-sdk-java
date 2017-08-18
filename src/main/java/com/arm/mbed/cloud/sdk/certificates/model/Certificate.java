package com.arm.mbed.cloud.sdk.certificates.model;

import java.util.Date;

import com.arm.mbed.cloud.sdk.annotations.DefaultValue;
import com.arm.mbed.cloud.sdk.annotations.Internal;
import com.arm.mbed.cloud.sdk.annotations.Preamble;

@Preamble(description = "Certificate")
public class Certificate {
    /**
     * Entity ID.
     */
    private String id;
    /**
     * Certificate name
     */
    private String name;
    /**
     * The UUID of the account.
     */
    private final String accountId;
    /**
     * Status of the certificate
     */
    @DefaultValue(value = "INACTIVE")
    private CertificateStatus status;
    /**
     * Certificate type
     */
    @DefaultValue(value = "DEVELOPER")
    private CertificateType type;
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
     * Content of the security.c file that will be flashed into the device to provide the security credentials
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
     * The UUID of the certificate owner (user or ApiKey)
     */
    private final String ownerId;
    /**
     * X509.v3 CA certificate in PEM or base64 encoded DER format
     */
    private String certificationData;
    /**
     * Base64 encoded signature of the account ID signed by the certificate to be uploaded. Signature must be hashed
     * with SHA256
     */
    private String signature;

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
        setCertificationData(null);
        setDescription(null);
        setName(null);
        setSignature(null);
        setStatus(CertificateStatus.getDefault());
        setType(CertificateType.getDefault());
    }

    public Certificate() {
        this(null, null, null, new Date(), null, new Date(), null, null, null, null, null, null);
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
    public void setCertificateId(String id) {
        setId(id);
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name
     *            the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the status
     */
    public CertificateStatus getStatus() {
        return status;
    }

    /**
     * @param status
     *            the status to set
     */
    public void setStatus(CertificateStatus status) {
        this.status = status;
    }

    /**
     * @param status
     *            the status to set
     */
    public void setStatus(String status) {
        setStatus(CertificateStatus.getStatus(status));
    }

    /**
     * @return the type
     */
    public CertificateType getType() {
        return type;
    }

    /**
     * @param type
     *            the type to set
     */
    public void setType(CertificateType type) {
        this.type = type;
    }

    /**
     * @param type
     *            the type to set
     */
    public void setType(String type) {
        setType(CertificateType.getType(type));
    }

    /**
     * @return the description
     */
    public String getDescription() {
        return description;
    }

    /**
     * @param description
     *            the description to set
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * @return the certificationData
     */
    public String getCertificationData() {
        return certificationData;
    }

    /**
     * @param certificationData
     *            the certificationData to set
     */
    public void setCertificationData(String certificationData) {
        this.certificationData = certificationData;
    }

    /**
     * @return the signature
     */
    public String getSignature() {
        return signature;
    }

    /**
     * @param signature
     *            the signature to set
     */
    public void setSignature(String signature) {
        this.signature = signature;
    }

    /**
     * @return the accountId
     */
    public String getAccountId() {
        return accountId;
    }

    /**
     * @return the subject
     */
    public String getSubject() {
        return subject;
    }

    /**
     * @return the validity
     */
    public Date getValidity() {
        return validity;
    }

    /**
     * @return the issuer
     */
    public String getIssuer() {
        return issuer;
    }

    /**
     * @return the createdAt
     */
    public Date getCreatedAt() {
        return createdAt;
    }

    /**
     * @return the serverUri
     */
    public String getServerUri() {
        return serverUri;
    }

    /**
     * @return the serverCertificate
     */
    public String getServerCertificate() {
        return serverCertificate;
    }

    /**
     * @return the headerFile
     */
    public String getHeaderFile() {
        return headerFile;
    }

    /**
     * @return the developerCertificate
     */
    public String getDeveloperCertificate() {
        return developerCertificate;
    }

    /**
     * @return the developerPrivateKey
     */
    public String getDeveloperPrivateKey() {
        return developerPrivateKey;
    }

    /**
     * @return the ownerId
     */
    public String getOwnerId() {
        return ownerId;
    }

    private static <T> T mergeField(T obj1, T obj2) {
        if (obj1 == null) {
            return obj2;
        }
        if (obj2 == null) {
            return obj1;
        }
        return obj2;
    }

    public static Certificate merge(Certificate partial1, Certificate partial2) {
        if (partial1 == null) {
            return partial2;
        }
        if (partial2 == null) {
            return partial1;
        }
        Certificate merge = new Certificate(mergeField(partial1.getId(), partial2.getId()),
                mergeField(partial1.getAccountId(), partial2.getAccountId()),
                mergeField(partial1.getSubject(), partial2.getSubject()),
                mergeField(partial1.getValidity(), partial2.getValidity()),
                mergeField(partial1.getIssuer(), partial2.getIssuer()),
                mergeField(partial1.getCreatedAt(), partial2.getCreatedAt()),
                mergeField(partial1.getServerUri(), partial2.getServerUri()),
                mergeField(partial1.getServerCertificate(), partial2.getServerCertificate()),
                mergeField(partial1.getHeaderFile(), partial2.getHeaderFile()),
                mergeField(partial1.getDeveloperCertificate(), partial2.getDeveloperCertificate()),
                mergeField(partial1.getDeveloperPrivateKey(), partial2.getDeveloperPrivateKey()),
                mergeField(partial1.getOwnerId(), partial2.getOwnerId()));
        merge.setCertificationData(mergeField(partial1.getCertificationData(), partial2.getCertificationData()));
        merge.setDescription(mergeField(partial1.getDescription(), partial2.getDescription()));
        merge.setName(mergeField(partial1.getName(), partial2.getName()));
        merge.setSignature(mergeField(partial1.getSignature(), partial2.getSignature()));
        merge.setStatus(mergeField(partial1.getStatus(), partial2.getStatus()));
        merge.setType(mergeField(partial1.getType(), partial2.getType()));
        return merge;
    }

}
