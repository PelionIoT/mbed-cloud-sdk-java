package com.arm.mbed.cloud.sdk.testserver.model;

import java.util.HashMap;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonInclude;

/**
 * Parameters to provide to an SDK method call
 **/
@JsonInclude(JsonInclude.Include.NON_NULL)
public class SdkMethodParameters extends HashMap<String, Object> {

    public SdkMethodParameters() {

    }

    @SuppressWarnings("unused")
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        SdkMethodParameters sdkMethodParameters = (SdkMethodParameters) o;
        return true;
    }

    @SuppressWarnings("boxing")
    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode());
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class SdkMethodParameters {\n");
        sb.append("    ").append(toIndentedString(super.toString())).append("\n");
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
