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
import java.util.HashMap;
import java.util.Map;
import org.joda.time.LocalDate;
import java.io.Serializable;

/**
 * DeviceDataPostRequest
 */

public class DeviceDataPostRequest implements Serializable {
    private static final long serialVersionUID = 1L;

    @SerializedName("auto_update")
    private Boolean autoUpdate = null;

    @SerializedName("bootstrap_expiration_date")
    private LocalDate bootstrapExpirationDate = null;

    @SerializedName("ca_id")
    private String caId = null;

    @SerializedName("connector_expiration_date")
    private LocalDate connectorExpirationDate = null;

    @SerializedName("custom_attributes")
    private Map<String, String> customAttributes = null;

    @SerializedName("deployment")
    private String deployment = null;

    @SerializedName("description")
    private String description = null;

    @SerializedName("device_class")
    private String deviceClass = null;

    @SerializedName("device_execution_mode")
    private Integer deviceExecutionMode = null;

    @SerializedName("device_key")
    private String deviceKey = null;

    @SerializedName("endpoint_name")
    private String endpointName = null;

    @SerializedName("endpoint_type")
    private String endpointType = null;

    @SerializedName("host_gateway")
    private String hostGateway = null;

    @SerializedName("issuer_fingerprint")
    private String issuerFingerprint = null;

    @SerializedName("manifest")
    private String manifest = null;

    /**
     * The ID of the channel used to communicate with the device.
     */
    @JsonAdapter(MechanismEnum.Adapter.class)
    public enum MechanismEnum {
        CONNECTOR("connector"),

        DIRECT("direct");

        private String value;

        MechanismEnum(String value) {
            this.value = value;
        }

        public String getValue() {
            return value;
        }

        @Override
        public String toString() {
            return String.valueOf(value);
        }

        public static MechanismEnum fromValue(String text) {
            for (MechanismEnum b : MechanismEnum.values()) {
                if (String.valueOf(b.value).equals(text)) {
                    return b;
                }
            }
            return null;
        }

        public static class Adapter extends TypeAdapter<MechanismEnum> {
            @Override
            public void write(final JsonWriter jsonWriter, final MechanismEnum enumeration) throws IOException {
                jsonWriter.value(enumeration.getValue());
            }

            @Override
            public MechanismEnum read(final JsonReader jsonReader) throws IOException {
                String value = jsonReader.nextString();
                return MechanismEnum.fromValue(String.valueOf(value));
            }
        }
    }

    @SerializedName("mechanism")
    private MechanismEnum mechanism = null;

    @SerializedName("mechanism_url")
    private String mechanismUrl = null;

    @SerializedName("name")
    private String name = null;

    @SerializedName("serial_number")
    private String serialNumber = null;

    /**
     * The current state of the device.
     */
    @JsonAdapter(StateEnum.Adapter.class)
    public enum StateEnum {
        UNENROLLED("unenrolled"),

        CLOUD_ENROLLING("cloud_enrolling"),

        BOOTSTRAPPED("bootstrapped"),

        REGISTERED("registered"),

        DEREGISTERED("deregistered");

        private String value;

        StateEnum(String value) {
            this.value = value;
        }

        public String getValue() {
            return value;
        }

        @Override
        public String toString() {
            return String.valueOf(value);
        }

        public static StateEnum fromValue(String text) {
            for (StateEnum b : StateEnum.values()) {
                if (String.valueOf(b.value).equals(text)) {
                    return b;
                }
            }
            return null;
        }

        public static class Adapter extends TypeAdapter<StateEnum> {
            @Override
            public void write(final JsonWriter jsonWriter, final StateEnum enumeration) throws IOException {
                jsonWriter.value(enumeration.getValue());
            }

            @Override
            public StateEnum read(final JsonReader jsonReader) throws IOException {
                String value = jsonReader.nextString();
                return StateEnum.fromValue(String.valueOf(value));
            }
        }
    }

    @SerializedName("state")
    private StateEnum state = null;

    @SerializedName("vendor_id")
    private String vendorId = null;

    public DeviceDataPostRequest autoUpdate(Boolean autoUpdate) {
        this.autoUpdate = autoUpdate;
        return this;
    }

    /**
     * DEPRECATED: Mark this device for automatic firmware update.
     * 
     * @return autoUpdate
     **/
    @ApiModelProperty(value = "DEPRECATED: Mark this device for automatic firmware update.")
    public Boolean isAutoUpdate() {
        return autoUpdate;
    }

    public void setAutoUpdate(Boolean autoUpdate) {
        this.autoUpdate = autoUpdate;
    }

    public DeviceDataPostRequest bootstrapExpirationDate(LocalDate bootstrapExpirationDate) {
        this.bootstrapExpirationDate = bootstrapExpirationDate;
        return this;
    }

    /**
     * The expiration date of the certificate used to connect to bootstrap server.
     * 
     * @return bootstrapExpirationDate
     **/
    @ApiModelProperty(example = "2017-05-22",
                      value = "The expiration date of the certificate used to connect to bootstrap server.")
    public LocalDate getBootstrapExpirationDate() {
        return bootstrapExpirationDate;
    }

    public void setBootstrapExpirationDate(LocalDate bootstrapExpirationDate) {
        this.bootstrapExpirationDate = bootstrapExpirationDate;
    }

    public DeviceDataPostRequest caId(String caId) {
        this.caId = caId;
        return this;
    }

    /**
     * The certificate issuer&#39;s ID.
     * 
     * @return caId
     **/
    @ApiModelProperty(example = "00000000000000000000000000000000", value = "The certificate issuer's ID.")
    public String getCaId() {
        return caId;
    }

    public void setCaId(String caId) {
        this.caId = caId;
    }

    public DeviceDataPostRequest connectorExpirationDate(LocalDate connectorExpirationDate) {
        this.connectorExpirationDate = connectorExpirationDate;
        return this;
    }

    /**
     * The expiration date of the certificate used to connect to the LwM2M server.
     * 
     * @return connectorExpirationDate
     **/
    @ApiModelProperty(example = "2017-05-22",
                      value = "The expiration date of the certificate used to connect to the LwM2M server.")
    public LocalDate getConnectorExpirationDate() {
        return connectorExpirationDate;
    }

    public void setConnectorExpirationDate(LocalDate connectorExpirationDate) {
        this.connectorExpirationDate = connectorExpirationDate;
    }

    public DeviceDataPostRequest customAttributes(Map<String, String> customAttributes) {
        this.customAttributes = customAttributes;
        return this;
    }

    public DeviceDataPostRequest putCustomAttributesItem(String key, String customAttributesItem) {
        if (this.customAttributes == null) {
            this.customAttributes = new HashMap<String, String>();
        }
        this.customAttributes.put(key, customAttributesItem);
        return this;
    }

    /**
     * Up to five custom key-value attributes. Note that keys cannot begin with a number. Both keys and values are
     * limited to 128 characters. Updating this field replaces existing contents.
     * 
     * @return customAttributes
     **/
    @ApiModelProperty(example = "{\"key\":\"value\"}",
                      value = "Up to five custom key-value attributes. Note that keys cannot begin with a number. Both keys and values are limited to 128 characters. Updating this field replaces existing contents.")
    public Map<String, String> getCustomAttributes() {
        return customAttributes;
    }

    public void setCustomAttributes(Map<String, String> customAttributes) {
        this.customAttributes = customAttributes;
    }

    public DeviceDataPostRequest deployment(String deployment) {
        this.deployment = deployment;
        return this;
    }

    /**
     * DEPRECATED: The last deployment used on the device.
     * 
     * @return deployment
     **/
    @ApiModelProperty(example = "", value = "DEPRECATED: The last deployment used on the device.")
    public String getDeployment() {
        return deployment;
    }

    public void setDeployment(String deployment) {
        this.deployment = deployment;
    }

    public DeviceDataPostRequest description(String description) {
        this.description = description;
        return this;
    }

    /**
     * The description of the device.
     * 
     * @return description
     **/
    @ApiModelProperty(example = "", value = "The description of the device.")
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public DeviceDataPostRequest deviceClass(String deviceClass) {
        this.deviceClass = deviceClass;
        return this;
    }

    /**
     * An ID representing the model and hardware revision of the device.
     * 
     * @return deviceClass
     **/
    @ApiModelProperty(value = "An ID representing the model and hardware revision of the device.")
    public String getDeviceClass() {
        return deviceClass;
    }

    public void setDeviceClass(String deviceClass) {
        this.deviceClass = deviceClass;
    }

    public DeviceDataPostRequest deviceExecutionMode(Integer deviceExecutionMode) {
        this.deviceExecutionMode = deviceExecutionMode;
        return this;
    }

    /**
     * The execution mode from the certificate of the device. Permitted values: - 0 - unspecified execution mode
     * (default) - 1 - development devices - 5 - production devices
     * 
     * @return deviceExecutionMode
     **/
    @ApiModelProperty(value = "The execution mode from the certificate of the device. Permitted values:   - 0 - unspecified execution mode (default)   - 1 - development devices   - 5 - production devices")
    public Integer getDeviceExecutionMode() {
        return deviceExecutionMode;
    }

    public void setDeviceExecutionMode(Integer deviceExecutionMode) {
        this.deviceExecutionMode = deviceExecutionMode;
    }

    public DeviceDataPostRequest deviceKey(String deviceKey) {
        this.deviceKey = deviceKey;
        return this;
    }

    /**
     * The fingerprint of the device certificate.
     * 
     * @return deviceKey
     **/
    @ApiModelProperty(example = "00:00:00:00:00:00:00:00:00:00:00:00:00:00:00:00:00:00:00:00:00:00:00:00:00:00:00:00:00:00:00:00",
                      value = "The fingerprint of the device certificate.")
    public String getDeviceKey() {
        return deviceKey;
    }

    public void setDeviceKey(String deviceKey) {
        this.deviceKey = deviceKey;
    }

    public DeviceDataPostRequest endpointName(String endpointName) {
        this.endpointName = endpointName;
        return this;
    }

    /**
     * The endpoint name given to the device.
     * 
     * @return endpointName
     **/
    @ApiModelProperty(example = "00000000-0000-0000-0000-000000000000",
                      value = "The endpoint name given to the device.")
    public String getEndpointName() {
        return endpointName;
    }

    public void setEndpointName(String endpointName) {
        this.endpointName = endpointName;
    }

    public DeviceDataPostRequest endpointType(String endpointType) {
        this.endpointType = endpointType;
        return this;
    }

    /**
     * The endpoint type of the device. For example, the device is a gateway.
     * 
     * @return endpointType
     **/
    @ApiModelProperty(example = "", value = "The endpoint type of the device. For example, the device is a gateway.")
    public String getEndpointType() {
        return endpointType;
    }

    public void setEndpointType(String endpointType) {
        this.endpointType = endpointType;
    }

    public DeviceDataPostRequest hostGateway(String hostGateway) {
        this.hostGateway = hostGateway;
        return this;
    }

    /**
     * The ID of the host gateway, if appropriate.
     * 
     * @return hostGateway
     **/
    @ApiModelProperty(example = "", value = "The ID of the host gateway, if appropriate.")
    public String getHostGateway() {
        return hostGateway;
    }

    public void setHostGateway(String hostGateway) {
        this.hostGateway = hostGateway;
    }

    public DeviceDataPostRequest issuerFingerprint(String issuerFingerprint) {
        this.issuerFingerprint = issuerFingerprint;
        return this;
    }

    /**
     * SHA256 fingerprint of the certificate used to validate the signature of the device certificate.
     * 
     * @return issuerFingerprint
     **/
    @ApiModelProperty(example = "C42EDEFC75871E4CE2146FCDA67D03DDA05CC26FDF93B17B55F42C1EADFDC322",
                      value = "SHA256 fingerprint of the certificate used to validate the signature of the device certificate.")
    public String getIssuerFingerprint() {
        return issuerFingerprint;
    }

    public void setIssuerFingerprint(String issuerFingerprint) {
        this.issuerFingerprint = issuerFingerprint;
    }

    public DeviceDataPostRequest manifest(String manifest) {
        this.manifest = manifest;
        return this;
    }

    /**
     * DEPRECATED: The URL for the current device manifest.
     * 
     * @return manifest
     **/
    @ApiModelProperty(example = "", value = "DEPRECATED: The URL for the current device manifest.")
    public String getManifest() {
        return manifest;
    }

    public void setManifest(String manifest) {
        this.manifest = manifest;
    }

    public DeviceDataPostRequest mechanism(MechanismEnum mechanism) {
        this.mechanism = mechanism;
        return this;
    }

    /**
     * The ID of the channel used to communicate with the device.
     * 
     * @return mechanism
     **/
    @ApiModelProperty(value = "The ID of the channel used to communicate with the device.")
    public MechanismEnum getMechanism() {
        return mechanism;
    }

    public void setMechanism(MechanismEnum mechanism) {
        this.mechanism = mechanism;
    }

    public DeviceDataPostRequest mechanismUrl(String mechanismUrl) {
        this.mechanismUrl = mechanismUrl;
        return this;
    }

    /**
     * The address of the connector to use.
     * 
     * @return mechanismUrl
     **/
    @ApiModelProperty(example = "", value = "The address of the connector to use.")
    public String getMechanismUrl() {
        return mechanismUrl;
    }

    public void setMechanismUrl(String mechanismUrl) {
        this.mechanismUrl = mechanismUrl;
    }

    public DeviceDataPostRequest name(String name) {
        this.name = name;
        return this;
    }

    /**
     * The name of the device.
     * 
     * @return name
     **/
    @ApiModelProperty(example = "00000000-0000-0000-0000-000000000000", value = "The name of the device.")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public DeviceDataPostRequest serialNumber(String serialNumber) {
        this.serialNumber = serialNumber;
        return this;
    }

    /**
     * The serial number of the device.
     * 
     * @return serialNumber
     **/
    @ApiModelProperty(example = "00000000-0000-0000-0000-000000000000", value = "The serial number of the device.")
    public String getSerialNumber() {
        return serialNumber;
    }

    public void setSerialNumber(String serialNumber) {
        this.serialNumber = serialNumber;
    }

    public DeviceDataPostRequest state(StateEnum state) {
        this.state = state;
        return this;
    }

    /**
     * The current state of the device.
     * 
     * @return state
     **/
    @ApiModelProperty(value = "The current state of the device.")
    public StateEnum getState() {
        return state;
    }

    public void setState(StateEnum state) {
        this.state = state;
    }

    public DeviceDataPostRequest vendorId(String vendorId) {
        this.vendorId = vendorId;
        return this;
    }

    /**
     * The device vendor ID.
     * 
     * @return vendorId
     **/
    @ApiModelProperty(example = "00000000-0000-0000-0000-000000000000", value = "The device vendor ID.")
    public String getVendorId() {
        return vendorId;
    }

    public void setVendorId(String vendorId) {
        this.vendorId = vendorId;
    }

    @Override
    public boolean equals(java.lang.Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        DeviceDataPostRequest deviceDataPostRequest = (DeviceDataPostRequest) o;
        return Objects.equals(this.autoUpdate, deviceDataPostRequest.autoUpdate)
               && Objects.equals(this.bootstrapExpirationDate, deviceDataPostRequest.bootstrapExpirationDate)
               && Objects.equals(this.caId, deviceDataPostRequest.caId)
               && Objects.equals(this.connectorExpirationDate, deviceDataPostRequest.connectorExpirationDate)
               && Objects.equals(this.customAttributes, deviceDataPostRequest.customAttributes)
               && Objects.equals(this.deployment, deviceDataPostRequest.deployment)
               && Objects.equals(this.description, deviceDataPostRequest.description)
               && Objects.equals(this.deviceClass, deviceDataPostRequest.deviceClass)
               && Objects.equals(this.deviceExecutionMode, deviceDataPostRequest.deviceExecutionMode)
               && Objects.equals(this.deviceKey, deviceDataPostRequest.deviceKey)
               && Objects.equals(this.endpointName, deviceDataPostRequest.endpointName)
               && Objects.equals(this.endpointType, deviceDataPostRequest.endpointType)
               && Objects.equals(this.hostGateway, deviceDataPostRequest.hostGateway)
               && Objects.equals(this.issuerFingerprint, deviceDataPostRequest.issuerFingerprint)
               && Objects.equals(this.manifest, deviceDataPostRequest.manifest)
               && Objects.equals(this.mechanism, deviceDataPostRequest.mechanism)
               && Objects.equals(this.mechanismUrl, deviceDataPostRequest.mechanismUrl)
               && Objects.equals(this.name, deviceDataPostRequest.name)
               && Objects.equals(this.serialNumber, deviceDataPostRequest.serialNumber)
               && Objects.equals(this.state, deviceDataPostRequest.state)
               && Objects.equals(this.vendorId, deviceDataPostRequest.vendorId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(autoUpdate, bootstrapExpirationDate, caId, connectorExpirationDate, customAttributes,
                            deployment, description, deviceClass, deviceExecutionMode, deviceKey, endpointName,
                            endpointType, hostGateway, issuerFingerprint, manifest, mechanism, mechanismUrl, name,
                            serialNumber, state, vendorId);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class DeviceDataPostRequest {\n");

        sb.append("    autoUpdate: ").append(toIndentedString(autoUpdate)).append("\n");
        sb.append("    bootstrapExpirationDate: ").append(toIndentedString(bootstrapExpirationDate)).append("\n");
        sb.append("    caId: ").append(toIndentedString(caId)).append("\n");
        sb.append("    connectorExpirationDate: ").append(toIndentedString(connectorExpirationDate)).append("\n");
        sb.append("    customAttributes: ").append(toIndentedString(customAttributes)).append("\n");
        sb.append("    deployment: ").append(toIndentedString(deployment)).append("\n");
        sb.append("    description: ").append(toIndentedString(description)).append("\n");
        sb.append("    deviceClass: ").append(toIndentedString(deviceClass)).append("\n");
        sb.append("    deviceExecutionMode: ").append(toIndentedString(deviceExecutionMode)).append("\n");
        sb.append("    deviceKey: ").append(toIndentedString(deviceKey)).append("\n");
        sb.append("    endpointName: ").append(toIndentedString(endpointName)).append("\n");
        sb.append("    endpointType: ").append(toIndentedString(endpointType)).append("\n");
        sb.append("    hostGateway: ").append(toIndentedString(hostGateway)).append("\n");
        sb.append("    issuerFingerprint: ").append(toIndentedString(issuerFingerprint)).append("\n");
        sb.append("    manifest: ").append(toIndentedString(manifest)).append("\n");
        sb.append("    mechanism: ").append(toIndentedString(mechanism)).append("\n");
        sb.append("    mechanismUrl: ").append(toIndentedString(mechanismUrl)).append("\n");
        sb.append("    name: ").append(toIndentedString(name)).append("\n");
        sb.append("    serialNumber: ").append(toIndentedString(serialNumber)).append("\n");
        sb.append("    state: ").append(toIndentedString(state)).append("\n");
        sb.append("    vendorId: ").append(toIndentedString(vendorId)).append("\n");
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
