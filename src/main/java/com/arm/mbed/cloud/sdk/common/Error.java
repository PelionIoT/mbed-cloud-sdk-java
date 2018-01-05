package com.arm.mbed.cloud.sdk.common;

import java.util.List;

import com.arm.mbed.cloud.sdk.annotations.Preamble;

@Preamble(description = "Error object sent back from Arm Mbed Cloud in case of errors")
public class Error {

    private String object;
    private int code;
    private String type;
    private String message;
    private String requestId;
    private List<Field> fields;

    /**
     * Constructor.
     */
    public Error() {
        this(0, null, null, null);
    }

    /**
     * Constructor.
     */
    public Error(int code, String type, String message, String requestId) {
        this(null, code, type, message, requestId, null);
    }

    /**
     * Constructor.
     */
    public Error(String object, int code, String type, String message, String requestId, List<Field> fields) {
        super();
        setCode(code);
        setFields(fields);
        setMessage(message);
        setObject(object);
        setRequestId(requestId);
        setType(type);
    }

    /**
     * Gets the object.
     * 
     * @return the object
     */
    public String getObject() {
        return object;
    }

    /**
     * Sets the object.
     * 
     * @param object
     *            the object to set
     */
    public void setObject(String object) {
        this.object = object;
    }

    /**
     * Gets the error code.
     * 
     * @return the code
     */
    public int getCode() {
        return code;
    }

    /**
     * Sets the error code.
     * 
     * @param code
     *            the code to set
     */
    public void setCode(int code) {
        this.code = code;
    }

    /**
     * Gets the error type.
     * 
     * @return the type
     */
    public String getType() {
        return type;
    }

    /**
     * Sets the error type.
     * 
     * @param type
     *            the type to set
     */
    public void setType(String type) {
        this.type = type;
    }

    /**
     * Gets the error message.
     * 
     * @return the message
     */
    public String getMessage() {
        return message;
    }

    /**
     * Sets the error message.
     * 
     * @param message
     *            the message to set
     */
    public void setMessage(String message) {
        this.message = message;
    }

    /**
     * Gets the request id.
     * 
     * @return the request_id
     */
    public String getRequestId() {
        return requestId;
    }

    /**
     * Sets the request id.
     * 
     * @param requestId
     *            the request_id to set
     */
    public void setRequestId(String requestId) {
        this.requestId = requestId;
    }

    /**
     * Gets all the fields containing errors.
     * 
     * @return the fields
     */
    public List<Field> getFields() {
        return fields;
    }

    /**
     * Sets all the fields containing errors.
     * 
     * @param fields
     *            the fields to set
     */
    public void setFields(List<Field> fields) {
        this.fields = fields;
    }

    /**
     * toString.
     * 
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        return "Error [object=" + object + ", code=" + code + ", type=" + type + ", message=" + message + ", requestId="
                + requestId + ", fields=" + fields + "]";
    }

    /**
     * Generates a pretty string representation.
     * 
     * @return string representation of the error.
     */
    public String toPrettyString() {
        return type + " (" + requestId + "). Status code: " + code + ". Object: " + object + ". Message: " + message;
    }

    @Preamble(description = "Request field in which there is an error")
    public static class Field {
        private String name;
        private String message;

        /**
         * Constructor.
         */
        public Field() {
            super();
            setName(null);
            setMessage(null);
        }

        /**
         * Gets field name.
         * 
         * @return the name
         */
        public String getName() {
            return name;
        }

        /**
         * Sets field name.
         * 
         * @param name
         *            the name to set
         */
        public void setName(String name) {
            this.name = name;
        }

        /**
         * Gets field message.
         * 
         * @return the message
         */
        public String getMessage() {
            return message;
        }

        /**
         * Sets field message.
         * 
         * @param message
         *            the message to set
         */
        public void setMessage(String message) {
            this.message = message;
        }

        /**
         * toString.
         * 
         * @see java.lang.Object#toString()
         */
        @Override
        public String toString() {
            return "Field [name=" + name + ", message=" + message + "]";
        }

    }

}
