package com.arm.mbed.cloud.sdk.testserver.internal.model;

import com.arm.mbed.cloud.sdk.common.ApiMetadata;
import com.arm.mbed.cloud.sdk.common.ApiUtils;

public class APIMethodResult implements Cloneable {

    private Object result;
    private ApiMetadata metadata;
    private boolean allowed;
    private Exception exception;

    public APIMethodResult() {
        super();
        result = null;
        metadata = null;
        exception = null;
        allowed = true;
    }

    public APIMethodResult(Object result, ApiMetadata metadata, boolean allowed, Exception exception) {
        super();
        this.result = result;
        this.metadata = metadata;
        this.allowed = allowed;
        this.exception = exception;
    }

    /**
     * @return the result
     */
    public Object getResult() {
        return result;
    }

    /**
     * @param result
     *            the result to set
     */
    public void setResult(Object result) {
        this.result = result;
    }

    /**
     * @return the metadata
     */
    public ApiMetadata getMetadata() {
        return metadata;
    }

    /**
     * @param metadata
     *            the metadata to set
     */
    public void setMetadata(ApiMetadata metadata) {
        this.metadata = metadata;

    }

    /**
     * @return the exception
     */
    public Exception getException() {
        return exception;
    }

    /**
     * @param exception
     *            the exception to set
     */
    public void setException(Exception exception) {
        this.exception = exception;
    }

    public boolean wasExceptionRaised() {
        return exception != null;
    }

    public void setAllowed(boolean allowed) {
        this.allowed = allowed;
    }

    public boolean wasAllowed() {
        return allowed;
    }

    public boolean isCloudException() {
        return wasExceptionRaised() && ApiUtils.isCloudException(exception);
    }

    public boolean isParameterException() {
        return wasExceptionRaised() && ApiUtils.isParameterErrorException(exception);
    }

    public boolean isNotImplementedException() {
        return wasExceptionRaised() && ApiUtils.isNotImplementedException(exception);
    }

    @Override
    public APIMethodResult clone() {
        return new APIMethodResult(result, metadata, allowed, exception);
    }

}
