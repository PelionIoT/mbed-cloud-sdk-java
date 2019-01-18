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
import java.io.Serializable;

/**
 * DeviceRequest
 */

public class DeviceRequest implements Serializable {
    private static final long serialVersionUID = 1L;

    @SerializedName("accept")
    private String accept = null;

    @SerializedName("content-type")
    private String contentType = null;

    @SerializedName("method")
    private String method = null;

    @SerializedName("payload-b64")
    private String payloadB64 = null;

    @SerializedName("uri")
    private String uri = null;

    public DeviceRequest accept(String accept) {
        this.accept = accept;
        return this;
    }

    /**
     * The content type of an accepted response.
     * 
     * @return accept
     **/
    @ApiModelProperty(example = "text/plain", value = "The content type of an accepted response.")
    public String getAccept() {
        return accept;
    }

    public void setAccept(String accept) {
        this.accept = accept;
    }

    public DeviceRequest contentType(String contentType) {
        this.contentType = contentType;
        return this;
    }

    /**
     * The content type of the payload.
     * 
     * @return contentType
     **/
    @ApiModelProperty(example = "text/plain", value = "The content type of the payload.")
    public String getContentType() {
        return contentType;
    }

    public void setContentType(String contentType) {
        this.contentType = contentType;
    }

    public DeviceRequest method(String method) {
        this.method = method;
        return this;
    }

    /**
     * The CoAP request method. Allowed values are GET, POST, PUT and DELETE.
     * 
     * @return method
     **/
    @ApiModelProperty(example = "GET", required = true,
                      value = "The CoAP request method. Allowed values are GET, POST, PUT and DELETE.")
    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    public DeviceRequest payloadB64(String payloadB64) {
        this.payloadB64 = payloadB64;
        return this;
    }

    /**
     * The base64 encoded payload to be sent to the device.
     * 
     * @return payloadB64
     **/
    @ApiModelProperty(example = "dmFsdWUxCg==", value = "The base64 encoded payload to be sent to the device.")
    public String getPayloadB64() {
        return payloadB64;
    }

    public void setPayloadB64(String payloadB64) {
        this.payloadB64 = payloadB64;
    }

    public DeviceRequest uri(String uri) {
        this.uri = uri;
        return this;
    }

    /**
     * The URI path of the requested resource.
     * 
     * @return uri
     **/
    @ApiModelProperty(example = "/5/0/1", required = true, value = "The URI path of the requested resource.")
    public String getUri() {
        return uri;
    }

    public void setUri(String uri) {
        this.uri = uri;
    }

    @Override
    public boolean equals(java.lang.Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        DeviceRequest deviceRequest = (DeviceRequest) o;
        return Objects.equals(this.accept, deviceRequest.accept)
               && Objects.equals(this.contentType, deviceRequest.contentType)
               && Objects.equals(this.method, deviceRequest.method)
               && Objects.equals(this.payloadB64, deviceRequest.payloadB64)
               && Objects.equals(this.uri, deviceRequest.uri);
    }

    @Override
    public int hashCode() {
        return Objects.hash(accept, contentType, method, payloadB64, uri);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class DeviceRequest {\n");

        sb.append("    accept: ").append(toIndentedString(accept)).append("\n");
        sb.append("    contentType: ").append(toIndentedString(contentType)).append("\n");
        sb.append("    method: ").append(toIndentedString(method)).append("\n");
        sb.append("    payloadB64: ").append(toIndentedString(payloadB64)).append("\n");
        sb.append("    uri: ").append(toIndentedString(uri)).append("\n");
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