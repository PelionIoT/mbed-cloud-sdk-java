/*
 * Pelion Device Management API
 * Pelion Device Management API build from the publicly defined API definitions.
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
import java.util.ArrayList;
import java.util.List;
import java.io.Serializable;

/**
 * TokenRequest
 */

public class TokenRequest implements Serializable {
    private static final long serialVersionUID = 1L;

    @SerializedName("aud")
    private List<String> aud = new ArrayList<String>();

    @SerializedName("cnf")
    private String cnf = null;

    @SerializedName("grant_type")
    private String grantType = null;

    @SerializedName("scope")
    private String scope = null;

    public TokenRequest aud(List<String> aud) {
        this.aud = aud;
        return this;
    }

    public TokenRequest addAudItem(String audItem) {
        this.aud.add(audItem);
        return this;
    }

    /**
     * Array of \\&lt;type\\&gt;:\\&lt;identity\\&gt; tuples representing devices for which access is being requested.
     * There must be at least one id/ep tuple.&lt;br/&gt; \\&lt;type\\&gt; ::&#x3D; id|ep &lt;br/&gt;
     * \\&lt;identity\\&gt;::&#x3D;[a-zA-Z0-9+/&#x3D;- ]+ &lt;br/&gt;\\&lt;audience\\&gt; :&#x3D;&#x3D; \\&lt;type\\&gt;
     * \&quot;:\&quot; \\&lt;identity\\&gt; &lt;br/&gt; \\&lt;identity\\&gt; can be up to 60 characters long, and can
     * contain spaces. &lt;br/&gt; The audience array can contain up to 50 tuples. If IAM does not authorize even one
     * item in the list, Secure Device Access does not authorize the whole request and does not return an access token
     * (access denied).
     * 
     * @return aud
     **/
    @ApiModelProperty(required = true,
                      value = "Array of \\<type\\>:\\<identity\\> tuples representing devices for which access is being requested. There must be at least one id/ep tuple.<br/> \\<type\\> ::= id|ep <br/> \\<identity\\>::=[a-zA-Z0-9+/=- ]+ <br/>\\<audience\\> :== \\<type\\> \":\" \\<identity\\>  <br/> \\<identity\\> can be up to 60 characters long, and can contain spaces. <br/> The audience array can contain up to 50 tuples. If IAM does not authorize even one item in the list, Secure Device Access does not authorize the whole request and does not return an access token (access denied).")
    public List<String> getAud() {
        return aud;
    }

    public void setAud(List<String> aud) {
        this.aud = aud;
    }

    public TokenRequest cnf(String cnf) {
        this.cnf = cnf;
        return this;
    }

    /**
     * The Android application proof-of-possession public key.
     * 
     * @return cnf
     **/
    @ApiModelProperty(required = true, value = "The Android application proof-of-possession public key.")
    public String getCnf() {
        return cnf;
    }

    public void setCnf(String cnf) {
        this.cnf = cnf;
    }

    public TokenRequest grantType(String grantType) {
        this.grantType = grantType;
        return this;
    }

    /**
     * Hardcoded - can only be \&quot;client_credentials\&quot;.
     * 
     * @return grantType
     **/
    @ApiModelProperty(required = true, value = "Hardcoded - can only be \"client_credentials\".")
    public String getGrantType() {
        return grantType;
    }

    public void setGrantType(String grantType) {
        this.grantType = grantType;
    }

    public TokenRequest scope(String scope) {
        this.scope = scope;
        return this;
    }

    /**
     * The space-delimited list of operations that user is requesting permission for. The array must contain at least
     * one scope item. A scope item can have up to 60 characters. A scope list can hold up to 20 scope items.
     * &lt;br/&gt; \\&lt;scope\\&gt;::&#x3D;[a-zA-Z][a-zA-Z0-9-]* &lt;br/&gt; \\&lt;scope-list\\&gt;::&#x3D;
     * \\&lt;scope\\&gt; | \\&lt;scope\\&gt; \&quot; \&quot; | \\&lt;scope\\&gt; \&quot; \&quot; \\&lt;scope-list\\&gt;
     * &lt;br/&gt; The scope being requested must match the action that the Android application eventually performs on
     * the IoT device. The device matches the scope in the access token to the action requested in the operation bundle.
     * 
     * @return scope
     **/
    @ApiModelProperty(required = true,
                      value = "The space-delimited list of operations that user is requesting permission for. The array must contain at least one scope item. A scope item can have up to 60 characters. A scope list can hold up to 20 scope items. <br/> \\<scope\\>::=[a-zA-Z][a-zA-Z0-9-]* <br/> \\<scope-list\\>::= \\<scope\\> | \\<scope\\> \" \" | \\<scope\\> \" \" \\<scope-list\\> <br/> The scope being requested must match the action that the Android application eventually performs on the IoT device. The device matches the scope in the access token to the action requested in the operation bundle.")
    public String getScope() {
        return scope;
    }

    public void setScope(String scope) {
        this.scope = scope;
    }

    @Override
    public boolean equals(java.lang.Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        TokenRequest tokenRequest = (TokenRequest) o;
        return Objects.equals(this.aud, tokenRequest.aud) && Objects.equals(this.cnf, tokenRequest.cnf)
               && Objects.equals(this.grantType, tokenRequest.grantType)
               && Objects.equals(this.scope, tokenRequest.scope);
    }

    @Override
    public int hashCode() {
        return Objects.hash(aud, cnf, grantType, scope);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class TokenRequest {\n");

        sb.append("    aud: ").append(toIndentedString(aud)).append("\n");
        sb.append("    cnf: ").append(toIndentedString(cnf)).append("\n");
        sb.append("    grantType: ").append(toIndentedString(grantType)).append("\n");
        sb.append("    scope: ").append(toIndentedString(scope)).append("\n");
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