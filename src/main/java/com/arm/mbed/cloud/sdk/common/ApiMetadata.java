package com.arm.mbed.cloud.sdk.common;

import java.net.URL;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Map;

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
        super();
        setDate(null);
        setEtag(null);
        setHeaders(null);
        setMethod(null);
        setObject(null);
        setRequestId(null);
        setStatusCode(0);
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
    public synchronized void setDateFromString(String dateString) throws MbedCloudException {
        final DateFormat format = REQUEST_DATE_FORMAT;
        format.setLenient(true);
        setDate(TranslationUtils.convertTimestamp(dateString, format));
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
     * toString.
     * 
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        return "ApiMetadata [date=" + date + ", headers=" + headers + ", url=" + url + ", method=" + method
                + ", statusCode=" + statusCode + ", requestId=" + requestId + ", object=" + object + ", etag=" + etag
                + ", errorMessage=" + errorMessage + "]";
    }

}
