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
import com.google.gson.TypeAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import io.swagger.annotations.ApiModelProperty;
import java.io.IOException;
import org.joda.time.DateTime;
import java.io.Serializable;

/**
 * BlackListedDeviceData
 */

public class BlackListedDeviceData implements Serializable {
    private static final long serialVersionUID = 1L;

    @SerializedName("account_id")
    private String accountId = null;

    @SerializedName("created_at")
    private DateTime createdAt = null;

    @SerializedName("endpoint_name")
    private String endpointName = null;

    @SerializedName("id")
    private String id = null;

    /**
     * Gets or Sets object
     */
    @JsonAdapter(ObjectEnum.Adapter.class)
    public enum ObjectEnum {
        DEVICE("denied_device");

        private String value;

        ObjectEnum(String value) {
            this.value = value;
        }

        public String getValue() {
            return value;
        }

        @Override
        public String toString() {
            return String.valueOf(value);
        }

        public static ObjectEnum fromValue(String text) {
            for (ObjectEnum b : ObjectEnum.values()) {
                if (String.valueOf(b.value).equals(text)) {
                    return b;
                }
            }
            return null;
        }

        public static class Adapter extends TypeAdapter<ObjectEnum> {
            @Override
            public void write(final JsonWriter jsonWriter, final ObjectEnum enumeration) throws IOException {
                jsonWriter.value(enumeration.getValue());
            }

            @Override
            public ObjectEnum read(final JsonReader jsonReader) throws IOException {
                String value = jsonReader.nextString();
                return ObjectEnum.fromValue(String.valueOf(value));
            }
        }
    }

    @SerializedName("object")
    private ObjectEnum object = null;

    @SerializedName("trusted_certificate_id")
    private String trustedCertificateId = null;

    public BlackListedDeviceData accountId(String accountId) {
        this.accountId = accountId;
        return this;
    }

    /**
     * account id
     * 
     * @return accountId
     **/
    @ApiModelProperty(example = "00005a4e027f0a580a01081c00000000", required = true, value = "account id")
    public String getAccountId() {
        return accountId;
    }

    public void setAccountId(String accountId) {
        this.accountId = accountId;
    }

    public BlackListedDeviceData createdAt(DateTime createdAt) {
        this.createdAt = createdAt;
        return this;
    }

    /**
     * date on which the failed bootstrap was attempted on
     * 
     * @return createdAt
     **/
    @ApiModelProperty(example = "2000-01-23T04:56:07.000+00:00", required = true,
                      value = "date on which the failed bootstrap was attempted on")
    public DateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(DateTime createdAt) {
        this.createdAt = createdAt;
    }

    public BlackListedDeviceData endpointName(String endpointName) {
        this.endpointName = endpointName;
        return this;
    }

    /**
     * endpoint name
     * 
     * @return endpointName
     **/
    @ApiModelProperty(example = "Endpoint_1234", required = true, value = "endpoint name")
    public String getEndpointName() {
        return endpointName;
    }

    public void setEndpointName(String endpointName) {
        this.endpointName = endpointName;
    }

    public BlackListedDeviceData id(String id) {
        this.id = id;
        return this;
    }

    /**
     * id of the recorded failed bootstrap attempt
     * 
     * @return id
     **/
    @ApiModelProperty(example = "00005a4e027f0a580a04567c00000000", required = true,
                      value = "id of the recorded failed bootstrap attempt")
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public BlackListedDeviceData object(ObjectEnum object) {
        this.object = object;
        return this;
    }

    /**
     * Get object
     * 
     * @return object
     **/
    @ApiModelProperty(required = true, value = "")
    public ObjectEnum getObject() {
        return object;
    }

    public void setObject(ObjectEnum object) {
        this.object = object;
    }

    public BlackListedDeviceData trustedCertificateId(String trustedCertificateId) {
        this.trustedCertificateId = trustedCertificateId;
        return this;
    }

    /**
     * Trusted certificate id
     * 
     * @return trustedCertificateId
     **/
    @ApiModelProperty(example = "00005a4e027f0a580a01081c00000000", required = true, value = "Trusted certificate id")
    public String getTrustedCertificateId() {
        return trustedCertificateId;
    }

    public void setTrustedCertificateId(String trustedCertificateId) {
        this.trustedCertificateId = trustedCertificateId;
    }

    @Override
    public boolean equals(java.lang.Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        BlackListedDeviceData blackListedDeviceData = (BlackListedDeviceData) o;
        return Objects.equals(this.accountId, blackListedDeviceData.accountId)
               && Objects.equals(this.createdAt, blackListedDeviceData.createdAt)
               && Objects.equals(this.endpointName, blackListedDeviceData.endpointName)
               && Objects.equals(this.id, blackListedDeviceData.id)
               && Objects.equals(this.object, blackListedDeviceData.object)
               && Objects.equals(this.trustedCertificateId, blackListedDeviceData.trustedCertificateId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(accountId, createdAt, endpointName, id, object, trustedCertificateId);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class BlackListedDeviceData {\n");

        sb.append("    accountId: ").append(toIndentedString(accountId)).append("\n");
        sb.append("    createdAt: ").append(toIndentedString(createdAt)).append("\n");
        sb.append("    endpointName: ").append(toIndentedString(endpointName)).append("\n");
        sb.append("    id: ").append(toIndentedString(id)).append("\n");
        sb.append("    object: ").append(toIndentedString(object)).append("\n");
        sb.append("    trustedCertificateId: ").append(toIndentedString(trustedCertificateId)).append("\n");
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
