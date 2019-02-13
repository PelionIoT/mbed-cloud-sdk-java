package com.arm.mbed.cloud.sdk.testserver.model;

import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class ErrorMessage {
    @JsonProperty("message")
    private String message = null;
    @JsonProperty("traceback")
    private String traceback = null;

    public ErrorMessage() {

    }

    public ErrorMessage(String message, String traceback) {
        this.message = message;
        this.traceback = traceback;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getTraceback() {
        return traceback;
    }

    public void setTraceback(String traceback) {
        this.traceback = traceback;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        ErrorMessage errorMessage = (ErrorMessage) o;
        return Objects.equals(message, errorMessage.message) && Objects.equals(traceback, errorMessage.traceback);
    }

    @Override
    public int hashCode() {
        return Objects.hash(message, traceback, super.hashCode());
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class ErrorMessage {\n");

        sb.append("    message: ").append(toIndentedString(message)).append("\n");
        sb.append("    traceback: ").append(toIndentedString(traceback)).append("\n");
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
