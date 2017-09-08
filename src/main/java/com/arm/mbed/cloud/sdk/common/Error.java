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

    public Error() {
        super();
    }

    /**
     * @return the object
     */
    public String getObject() {
        return object;
    }

    /**
     * @param object
     *            the object to set
     */
    public void setObject(String object) {
        this.object = object;
    }

    /**
     * @return the code
     */
    public int getCode() {
        return code;
    }

    /**
     * @param code
     *            the code to set
     */
    public void setCode(int code) {
        this.code = code;
    }

    /**
     * @return the type
     */
    public String getType() {
        return type;
    }

    /**
     * @param type
     *            the type to set
     */
    public void setType(String type) {
        this.type = type;
    }

    /**
     * @return the message
     */
    public String getMessage() {
        return message;
    }

    /**
     * @param message
     *            the message to set
     */
    public void setMessage(String message) {
        this.message = message;
    }

    /**
     * @return the request_id
     */
    public String getRequestId() {
        return requestId;
    }

    /**
     * @param requestId
     *            the request_id to set
     */
    public void setRequestId(String requestId) {
        this.requestId = requestId;
    }

    /**
     * @return the fields
     */
    public List<Field> getFields() {
        return fields;
    }

    /**
     * @param fields
     *            the fields to set
     */
    public void setFields(List<Field> fields) {
        this.fields = fields;
    }

    /*
     * (non-Javadoc)
     * 
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        return "Error [object=" + object + ", code=" + code + ", type=" + type + ", message=" + message + ", requestId="
                + requestId + ", fields=" + fields + "]";
    }

    public static class Field {
        private String name;
        private String message;

        public Field() {
            super();
        }

        /**
         * @return the name
         */
        public String getName() {
            return name;
        }

        /**
         * @param name
         *            the name to set
         */
        public void setName(String name) {
            this.name = name;
        }

        /**
         * @return the message
         */
        public String getMessage() {
            return message;
        }

        /**
         * @param message
         *            the message to set
         */
        public void setMessage(String message) {
            this.message = message;
        }

        /*
         * (non-Javadoc)
         * 
         * @see java.lang.Object#toString()
         */
        @Override
        public String toString() {
            return "Field [name=" + name + ", message=" + message + "]";
        }

    }

}
