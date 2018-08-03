package com.arm.mbed.cloud.sdk.common;

import java.net.URL;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import com.arm.mbed.cloud.sdk.annotations.Internal;
import com.arm.mbed.cloud.sdk.annotations.Nullable;
import com.arm.mbed.cloud.sdk.annotations.Preamble;

@Preamble(description = "API metadata")
public class ApiMetadata {

    private static final SimpleDateFormat REQUEST_DATE_FORMAT = new SimpleDateFormat("EEE, dd MMM yyyy HH:mm:ss z",
                                                                                     Locale.getDefault());
    private Date date;
    private Map<String, List<String>> headers;
    /**
     * Url of the API request.
     */
    private URL url;
    /**
     * Method of the API request.
     */
    private String method;
    /**
     * HTTP Status code of the API response.
     */
    private int statusCode;
    /**
     * Request ID of the transaction.
     */
    private String requestId;
    /**
     * Object type of the returned data.
     */
    private Class<?> object;
    /**
     * etag of the returned data.
     */
    private String etag;
    /**
     * Error message if an error occurred during Mbed Cloud request null if no error happened.
     */
    public @Nullable Error errorMessage;

    /**
     * Constructor.
     */
    public ApiMetadata() {
        this(null, null, 0, null, null);
    }

    /**
     * Internal constructor.
     * <p>
     * Note: Should not be used. Use {@link #ApiMetadata()} instead.
     *
     * @param date
     *            date.
     * @param method
     *            method.
     * @param statusCode
     *            statusCode.
     * @param requestId
     *            requestId.
     * @param errorMessage
     *            errorMessage.
     */
    @Internal
    public ApiMetadata(Date date, String method, int statusCode, String requestId, Error errorMessage) {
        super();
        setDate(date);
        setEtag(null);
        setHeaders(null);
        setMethod(method);
        setObject(null);
        setRequestId(requestId);
        setStatusCode(statusCode);
        setErrorMessage(errorMessage);
    }

    /**
     * Gets the date.
     *
     * @return the date
     */
    public Date getDate() {
        return date;
    }

    /**
     * Sets the date from a string representation.
     *
     * @param dateString
     *            the date to set
     * @throws MbedCloudException
     *             if string cannot be interpreted as a date
     */
    public void setDateFromString(String dateString) throws MbedCloudException {
        if (dateString == null || dateString.isEmpty()) {
            throw new MbedCloudException("Error occurred when parsing timestamp as it is missing.");
        }
        final DateFormat format = REQUEST_DATE_FORMAT;
        format.setLenient(true);
        final Date requestDate = TranslationUtils.convertTimestamp(dateString, format);
        if (requestDate == null) {
            throw new MbedCloudException("Error occurred when parsing timestamp [" + dateString + "]");
        }
        setDate(requestDate);
    }

    /**
     * Sets the date.
     *
     * @param date
     *            the date to set
     */
    public void setDate(Date date) {
        this.date = date;
    }

    /**
     * Gets the HTTP headers.
     *
     * @return the headers
     */
    public Map<String, List<String>> getHeaders() {
        return headers;
    }

    /**
     * Sets the HTTP headers.
     *
     * @param headers
     *            the headers to set
     */
    public void setHeaders(Map<String, List<String>> headers) {
        this.headers = headers;
    }

    /**
     * Gets the URL used.
     *
     * @return the url
     */
    public URL getUrl() {
        return url;
    }

    /**
     * Sets the URL.
     *
     * @param url
     *            the url to set
     */
    public void setUrl(URL url) {
        this.url = url;
    }

    /**
     * Gets the method name.
     *
     * @return the method
     */
    public String getMethod() {
        return method;
    }

    /**
     * Sets the method name.
     *
     * @param method
     *            the method to set
     */
    public void setMethod(String method) {
        this.method = method;
    }

    /**
     * Gets the status code.
     *
     * @return the statusCode
     */
    public int getStatusCode() {
        return statusCode;
    }

    /**
     * Sets the status code.
     *
     * @param statusCode
     *            the statusCode to set
     */
    public void setStatusCode(int statusCode) {
        this.statusCode = statusCode;
    }

    /**
     * Gets the request id.
     *
     * @return the requestId
     */
    public String getRequestId() {
        return requestId;
    }

    /**
     * Sets the request id.
     *
     * @param requestId
     *            the requestId to set
     */
    public void setRequestId(String requestId) {
        this.requestId = requestId;
    }

    /**
     * Checks whether the meta-data contains the request Id or not.
     *
     * @return True if request Id is specified. False otherwise.
     */
    public boolean hasRequestId() {
        return requestId != null && !requestId.isEmpty();
    }

    /**
     * Gets the object.
     *
     * @return the object
     */
    public Class<?> getObject() {
        return object;
    }

    /**
     * Sets the object.
     *
     * @param object
     *            the object to set
     */
    public void setObject(Class<?> object) {
        this.object = object;
    }

    /**
     * Checks whether the meta-data contains the etag or not.
     *
     * @return True if etag is specified. False otherwise.
     */
    public boolean hasEtag() {
        return etag != null && !etag.isEmpty();
    }

    /**
     * Gets the etag.
     *
     * @return the etag
     */
    public String getEtag() {
        return etag;
    }

    /**
     * Sets the etag.
     *
     * @param etag
     *            the etag to set
     */
    public void setEtag(String etag) {
        this.etag = etag;
    }

    /**
     * Gets error message.
     *
     * @see Error
     * @return the error message
     */
    public Error getErrorMessage() {
        return errorMessage;
    }

    /**
     * Sets error message.
     *
     * @see Error
     * @param errorMessage
     *            the errorMessage to set
     */
    public void setErrorMessage(Error errorMessage) {
        this.errorMessage = errorMessage;
    }

    /**
     * Sets error.
     *
     * @see Error
     * @param error
     *            the errorMessage to set
     */
    @Internal
    public void setError(Error error) {
        setErrorMessage(error);
        if (requestId == null && error != null) {
            setRequestId(error.getRequestId());
        }
        if (object == null) {
            setObject(Error.class);
        }
    }

    /**
     * toString.
     *
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        final String errorMessageStr = (errorMessage == null) ? null : errorMessage.toPrettyString();
        return "ApiMetadata [date=" + date + ", headers=" + headers + ", url=" + url + ", method=" + method
               + ", statusCode=" + statusCode + ", requestId=" + requestId + ", object=" + object + ", etag=" + etag
               + ", errorMessage=" + errorMessageStr + "]";
    }

    /**
     * Generates API metadata.
     *
     * @param method
     *            method name.
     * @param error
     *            error message
     * @return corresponding metadata.
     */
    public static ApiMetadata generateMetaData(String method, Error error) {
        final ApiMetadata metadata = new ApiMetadata();
        if (error == null) {
            return metadata;
        }
        metadata.setDate(new Date());
        metadata.setStatusCode(error.getCode());
        metadata.setErrorMessage(error);
        metadata.setMethod(method);
        metadata.setRequestId(error.getRequestId());
        return metadata;
    }
}
