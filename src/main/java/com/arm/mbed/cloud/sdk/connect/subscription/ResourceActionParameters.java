package com.arm.mbed.cloud.sdk.connect.subscription;

import java.nio.ByteBuffer;
import java.nio.charset.StandardCharsets;

import com.arm.mbed.cloud.sdk.annotations.Preamble;
import com.arm.mbed.cloud.sdk.common.ApiUtils;
import com.arm.mbed.cloud.sdk.common.MbedCloudException;
import com.arm.mbed.cloud.sdk.connect.model.Resource;
import com.mbed.lwm2m.base64.Base64Encoder;

@Preamble(description = "Parameters of an action carried out on a resource")
public class ResourceActionParameters {

    private final String asyncId;
    private final Resource resource;
    private final Object value;
    private final ResourceValueType valueType;
    private final Integer retries;
    private final Integer expirySeconds;

    /**
     * Constructor.
     * 
     * @param asyncId
     *            asynchronous response Id.
     * @param resource
     *            resource the action refers to.
     * @param value
     *            value of the resource to set or execute.
     * @param valueType
     *            type of the value.
     * 
     * @param retries
     *            The count of retry transmissions of the request to the device, after initial transmission. For
     *            example, retry of two means three delivery attempts in total. If retries are exhausted, the request is
     *            discarded.
     * @param expirySeconds
     *            The time period during which the delivery is attempted, in seconds. If the device is not reachable
     *            within this period, the request is discarded.
     * 
     */
    public ResourceActionParameters(String asyncId, Resource resource, Object value, ResourceValueType valueType,
                                    Integer retries, Integer expirySeconds) {
        super();
        this.asyncId = asyncId;
        this.resource = resource;
        this.value = value;
        this.valueType = valueType;
        this.retries = retries;
        this.expirySeconds = expirySeconds;
    }

    /**
     * Constructor.
     * 
     * @param asyncId
     *            asynchronous response Id.
     * @param resource
     *            resource the action refers to.
     * @param value
     *            value of the resource to set or execute.
     * @param valueType
     *            type of the value.
     */
    public ResourceActionParameters(String asyncId, Resource resource, Object value, ResourceValueType valueType) {
        this(asyncId, resource, value, valueType, null, null);
    }

    public String getAsyncId() {
        return asyncId;
    }

    public Resource getResource() {
        return resource;
    }

    public Object getValue() {
        return value;
    }

    public boolean hasPayload() {
        return value != null;
    }

    public ResourceValueType getValueType() {
        return valueType;
    }

    public Integer getRetries() {
        return retries;
    }

    public Integer getExpirySeconds() {
        return expirySeconds;
    }

    public String getResourcePath() {
        return resource == null ? null : ApiUtils.normaliseResourcePath(resource.getPath());
    }

    /**
     * Marshalls the resource value into whatever acceptable format accepted by Pelion Cloud.
     * 
     * @return marshalled resource value as a String.
     * @throws MbedCloudException
     *             if an error occurred during the marshalling.
     */
    public String marshall() throws MbedCloudException {
        if (!hasPayload()) {
            return null;
        }
        ResourceValueType actualValueType = valueType;
        if (value instanceof byte[]) {
            actualValueType = ResourceValueType.BYTES;
        } else if (value instanceof Number) {
            actualValueType = ResourceValueType.NUMBER;
            if (value.getClass() == int.class || value.getClass() == Integer.class || value.getClass() == long.class
                || value.getClass() == Long.class) {
                actualValueType = ResourceValueType.INTEGER;
            }
        } else {
            // TODO be more granular OBJECT and LWM2M
            actualValueType = ResourceValueType.STRING;
        }
        ByteBuffer input = null;
        switch (actualValueType) {
            case BYTES:
                if (value instanceof byte[]) {
                    throw new MbedCloudException(new IllegalArgumentException("Expected value to be byte[] but was "
                                                                              + value.getClass()));
                }
                input = ByteBuffer.wrap((byte[]) value);
                break;
            // case OBJECT:
            // break;
            // case LWM2M:
            // break;
            case INTEGER:
            case NUMBER:
                if (!(value instanceof Number)) {
                    throw new MbedCloudException(new IllegalArgumentException("Expected value to a  number but was "
                                                                              + value.getClass()));
                }
                final Number number = ((Number) value);
                input = ByteBuffer.allocate(Double.BYTES);
                if (valueType == ResourceValueType.INTEGER) {
                    input.putLong(number.longValue());
                } else {
                    input.putDouble(number.doubleValue());
                }
                break;
            case STRING:
                input = ByteBuffer.wrap(String.valueOf(value).getBytes(StandardCharsets.UTF_8));
                break;
            case UNKNOWN_ENUM:
                break;
            default:
                break;

        }
        return Base64Encoder.encodeToUTF8(input);
    }

}
