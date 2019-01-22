package com.arm.mbed.cloud.sdk.testserver.model;

import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * JSON string representation of the method call result
 **/
@JsonInclude(JsonInclude.Include.NON_NULL)
public class SdkMethodResult {
    @JsonProperty("payload")
    private Object payload = null;

    public SdkMethodResult() {

    }

    public SdkMethodResult(Object payload) {
        this.payload = payload;
    }

    public Object getPayload() {
        return payload;
    }

    public void setPayload(Object payload) {
        this.payload = payload;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        SdkMethodResult sdkMethodResult = (SdkMethodResult) o;
        return Objects.equals(payload, sdkMethodResult.payload);
    }

    @Override
    public int hashCode() {
        return Objects.hash(payload, super.hashCode());
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class SdkMethodResult {\n");

        sb.append("    payload: ").append(toIndentedString(payload)).append("\n");
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
