package com.arm.mbed.cloud.sdk.testserver.model;

import java.util.HashMap;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * SDK Configuration including connection options
 **/
@JsonInclude(JsonInclude.Include.NON_NULL)
public class SdkConfiguration extends HashMap<String, Object> {
    @JsonProperty("api_key")
    private String apiKey = null;
    @JsonProperty("host")
    private String host = null;
    @JsonProperty("autostart_daemon")
    private Boolean autostartDaemon = null;

    public SdkConfiguration() {

    }

    public SdkConfiguration(String apiKey, String host, Boolean autostartDaemon) {
        this.apiKey = apiKey;
        this.host = host;
        this.autostartDaemon = autostartDaemon;
    }

    public String getApiKey() {
        return apiKey;
    }

    public void setApiKey(String apiKey) {
        this.apiKey = apiKey;
    }

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public Boolean isAutostartDaemon() {
        return autostartDaemon;
    }

    public void setAutostartDaemon(Boolean autostartDaemon) {
        this.autostartDaemon = autostartDaemon;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        SdkConfiguration sdkConfiguration = (SdkConfiguration) o;
        return Objects.equals(apiKey, sdkConfiguration.apiKey) && Objects.equals(host, sdkConfiguration.host)
               && Objects.equals(autostartDaemon, sdkConfiguration.autostartDaemon);
    }

    @Override
    public int hashCode() {
        return Objects.hash(apiKey, host, autostartDaemon, super.hashCode());
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class SdkConfiguration {\n");
        sb.append("    ").append(toIndentedString(super.toString())).append("\n");
        sb.append("    apiKey: ").append(toIndentedString(apiKey)).append("\n");
        sb.append("    host: ").append(toIndentedString(host)).append("\n");
        sb.append("    autostartDaemon: ").append(toIndentedString(autostartDaemon)).append("\n");
        sb.append("}");
        return sb.toString();
    }

    /**
     * Convert the given object to string with each line indented by 4 spaces (except the first line).
     */
    private String toIndentedString(Object o) {
        if (o == null) {
            return "null";
        }
        return o.toString().replace("\n", "\n    ");
    }
}
