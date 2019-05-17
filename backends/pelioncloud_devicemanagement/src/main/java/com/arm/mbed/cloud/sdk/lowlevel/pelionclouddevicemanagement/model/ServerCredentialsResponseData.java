/*
 * Mbed Cloud API
 * The full Mbed Cloud API
 *
 * OpenAPI spec version: 3
 * 
 *
 * NOTE: This class is auto generated by the swagger code generator program.
 * https://github.com/swagger-api/swagger-codegen.git
 * Do not edit the class manually.
 */

package com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.model;

import java.util.Objects;
import com.google.gson.annotations.SerializedName;
import io.swagger.annotations.ApiModelProperty;
import org.joda.time.DateTime;
import java.io.Serializable;

/**
 * ServerCredentialsResponseData
 */

public class ServerCredentialsResponseData implements Serializable {
    private static final long serialVersionUID = 1L;

    @SerializedName("created_at")
    private DateTime createdAt = null;

    @SerializedName("etag")
    private String etag = null;

    @SerializedName("id")
    private String id = null;

    @SerializedName("object")
    private String object = null;

    @SerializedName("server_certificate")
    private String serverCertificate = null;

    @SerializedName("server_uri")
    private String serverUri = null;

    public ServerCredentialsResponseData createdAt(DateTime createdAt) {
        this.createdAt = createdAt;
        return this;
    }

    /**
     * Creation UTC time RFC3339.
     * 
     * @return createdAt
     **/
    @ApiModelProperty(value = "Creation UTC time RFC3339.")
    public DateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(DateTime createdAt) {
        this.createdAt = createdAt;
    }

    public ServerCredentialsResponseData etag(String etag) {
        this.etag = etag;
        return this;
    }

    /**
     * API resource entity version.
     * 
     * @return etag
     **/
    @ApiModelProperty(value = "API resource entity version.")
    public String getEtag() {
        return etag;
    }

    public void setEtag(String etag) {
        this.etag = etag;
    }

    public ServerCredentialsResponseData id(String id) {
        this.id = id;
        return this;
    }

    /**
     * Unique entity ID.
     * 
     * @return id
     **/
    @ApiModelProperty(value = "Unique entity ID.")
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public ServerCredentialsResponseData object(String object) {
        this.object = object;
        return this;
    }

    /**
     * Entity name: always &#x60;server-credentials&#x60;.
     * 
     * @return object
     **/
    @ApiModelProperty(value = "Entity name: always `server-credentials`.")
    public String getObject() {
        return object;
    }

    public void setObject(String object) {
        this.object = object;
    }

    public ServerCredentialsResponseData serverCertificate(String serverCertificate) {
        this.serverCertificate = serverCertificate;
        return this;
    }

    /**
     * PEM-format X.509 server certificate used to validate the server certificate received during the TLS/DTLS
     * handshake.
     * 
     * @return serverCertificate
     **/
    @ApiModelProperty(value = "PEM-format X.509 server certificate used to validate the server certificate received during the TLS/DTLS handshake.")
    public String getServerCertificate() {
        return serverCertificate;
    }

    public void setServerCertificate(String serverCertificate) {
        this.serverCertificate = serverCertificate;
    }

    public ServerCredentialsResponseData serverUri(String serverUri) {
        this.serverUri = serverUri;
        return this;
    }

    /**
     * Server URI that the client connects to.
     * 
     * @return serverUri
     **/
    @ApiModelProperty(value = "Server URI that the client connects to.")
    public String getServerUri() {
        return serverUri;
    }

    public void setServerUri(String serverUri) {
        this.serverUri = serverUri;
    }

    @Override
    public boolean equals(java.lang.Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        ServerCredentialsResponseData serverCredentialsResponseData = (ServerCredentialsResponseData) o;
        return Objects.equals(this.createdAt, serverCredentialsResponseData.createdAt)
               && Objects.equals(this.etag, serverCredentialsResponseData.etag)
               && Objects.equals(this.id, serverCredentialsResponseData.id)
               && Objects.equals(this.object, serverCredentialsResponseData.object)
               && Objects.equals(this.serverCertificate, serverCredentialsResponseData.serverCertificate)
               && Objects.equals(this.serverUri, serverCredentialsResponseData.serverUri);
    }

    @Override
    public int hashCode() {
        return Objects.hash(createdAt, etag, id, object, serverCertificate, serverUri);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class ServerCredentialsResponseData {\n");

        sb.append("    createdAt: ").append(toIndentedString(createdAt)).append("\n");
        sb.append("    etag: ").append(toIndentedString(etag)).append("\n");
        sb.append("    id: ").append(toIndentedString(id)).append("\n");
        sb.append("    object: ").append(toIndentedString(object)).append("\n");
        sb.append("    serverCertificate: ").append(toIndentedString(serverCertificate)).append("\n");
        sb.append("    serverUri: ").append(toIndentedString(serverUri)).append("\n");
        sb.append("}");
        return sb.toString();
    }

    /**
     * Convert the given object to string with each line indented by 4 spaces (except the first line).
     */
    private String toIndentedString(java.lang.Object o) {
        if (o == null) {
            return "null";
        }
        return o.toString().replace("\n", "\n    ");
    }

}
