package com.arm.mbed.cloud.sdk.common;

import java.io.Serializable;
import java.util.List;

import com.arm.mbed.cloud.sdk.annotations.Preamble;

@Preamble(description = "Error object sent back from Arm Mbed Cloud in case of errors")
public class Error implements SdkModel {

    private static final String DEFAULT_OBJECT = "error";
    /**
     * Serialisation Id.
     */
    private static final long serialVersionUID = 8022558248605031676L;
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
     * Internal constructor.
     * <p>
     * Note: Should not be used. Use {@link #Error()} instead.
     *
     *
     * @param code
     *            code.
     * @param type
     *            type.
     * @param message
     *            message.
     * @param requestId
     *            requestId.
     */
    public Error(int code, String type, String message, String requestId) {
        this(DEFAULT_OBJECT, code, type, message, requestId, null);
    }

    /**
     * Internal constructor.
     * <p>
     * Note: Should not be used. Use {@link #Error()} instead.
     *
     * @param object
     *            object.
     * @param code
     *            code.
     * @param type
     *            type.
     * @param message
     *            message.
     * @param requestId
     *            requestId.
     *
     * @param fields
     *            fields.
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
        return type + " (" + requestId + "). Status code: " + code + ". Object: " + object + ". Message: "
               + generatePrettyMessage();
    }

    private String generatePrettyMessage() {
        if (message == null) {
            return "";
        }
        String formattedMessage = message;
        if (fields != null && formattedMessage.endsWith(".")) {
            formattedMessage = formattedMessage.substring(0, formattedMessage.length() - 1);
        }
        return formattedMessage + generateieldsDescription();
    }

    private String generateieldsDescription() {
        if (fields == null) {
            return "";
        }
        final StringBuilder builder = new StringBuilder();
        builder.append(" (");
        boolean start = true;
        for (final Field field : fields) {
            if (!start) {
                builder.append(", ");
            }
            start = false;
            builder.append(field.toPrettyString());
        }
        builder.append(").");
        return builder.toString();
    }

    /*
     * (non-Javadoc)
     *
     * @see java.lang.Object#hashCode()
     */
    @Override
    public final int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + code;
        result = prime * result + ((fields == null) ? 0 : fields.hashCode());
        result = prime * result + ((message == null) ? 0 : message.hashCode());
        result = prime * result + ((object == null) ? 0 : object.hashCode());
        result = prime * result + ((requestId == null) ? 0 : requestId.hashCode());
        result = prime * result + ((type == null) ? 0 : type.hashCode());
        return result;
    }

    /*
     * (non-Javadoc)
     *
     * @see java.lang.Object#equals(java.lang.Object)
     */
    @Override
    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (!(obj instanceof Error)) {
            return false;
        }
        final Error other = (Error) obj;
        if (code != other.code) {
            return false;
        }
        if (fields == null) {
            if (other.fields != null) {
                return false;
            }
        } else if (!fields.equals(other.fields)) {
            return false;
        }
        if (message == null) {
            if (other.message != null) {
                return false;
            }
        } else if (!message.equals(other.message)) {
            return false;
        }
        if (object == null) {
            if (other.object != null) {
                return false;
            }
        } else if (!object.equals(other.object)) {
            return false;
        }
        if (requestId == null) {
            if (other.requestId != null) {
                return false;
            }
        } else if (!requestId.equals(other.requestId)) {
            return false;
        }
        if (type == null) {
            if (other.type != null) {
                return false;
            }
        } else if (!type.equals(other.type)) {
            return false;
        }
        return true;
    }

    /**
     * Clones the error.
     */
    @Override
    public Error clone() {
        return new Error(object, code, type, message, requestId, fields);
    }

    /**
     * Checks whether the error is valid or not.
     */
    @Override
    public boolean isValid() {
        return getCode() != 0;
    }

    /**
     * Gets error id.
     */
    @Override
    public String getId() {
        return getCode() + "-" + getRequestId();
    }

    /*
     * (non-Javadoc)
     *
     * @see com.arm.mbed.cloud.sdk.common.SdkModel#setId(java.lang.String)
     */
    @Override
    public void setId(String id) {
        // Nothing to do.

    }

    @Preamble(description = "Request field in which there is an error")
    public static class Field implements Serializable {
        /**
         * Serialisation id.
         */
        private static final long serialVersionUID = -3457278683653766424L;
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

        /**
         * Generates a pretty string representation.
         *
         * @return string representation of the error.
         */
        public String toPrettyString() {
            return name + ": " + message;
        }
    }

}
