package com.arm.mbed.cloud.sdk.common;

import java.net.URL;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

import com.arm.mbed.cloud.sdk.annotations.Preamble;

@Preamble(description = "API metadata")
public class ApiMetadata {

    private Date date;
    private Map<String, List<String>> headers;
    /**
     * Url of the API request
     */
    private URL url;
    /**
     * Method of the API request
     */
    private String method;
    /**
     * HTTP Status code of the API response
     */
    private int statusCode;
    /**
     * Request ID of the transaction
     */
    private String requestId;
    /**
     * Object type of the returned data
     */
    private Class<?> object;
    /**
     * etag of the returned data
     */
    private String etag;

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
     * @return the date
     */
    public Date getDate() {
        return date;
    }

    /**
     * @param dateString
     *            the date to set
     * @throws Exception
     *             if string cannot be interpreted as a date
     */
    public void setDateFromString(String dateString) throws Exception {
        DateFormat format = new SimpleDateFormat("EEE, dd MMM yyyy HH:mm:ss z");
        format.setLenient(true);
        setDate(TranslationUtils.convertTimestamp(dateString, format));
    }

    /**
     * @param date
     *            the date to set
     */
    public void setDate(Date date) {
        this.date = date;
    }

    /**
     * @return the headers
     */
    public Map<String, List<String>> getHeaders() {
        return headers;
    }

    /**
     * @param headers
     *            the headers to set
     */
    public void setHeaders(Map<String, List<String>> headers) {
        this.headers = headers;
    }

    /**
     * @return the url
     */
    public URL getUrl() {
        return url;
    }

    /**
     * @param url
     *            the url to set
     */
    public void setUrl(URL url) {
        this.url = url;
    }

    /**
     * @return the method
     */
    public String getMethod() {
        return method;
    }

    /**
     * @param method
     *            the method to set
     */
    public void setMethod(String method) {
        this.method = method;
    }

    /**
     * @return the statusCode
     */
    public int getStatusCode() {
        return statusCode;
    }

    /**
     * @param statusCode
     *            the statusCode to set
     */
    public void setStatusCode(int statusCode) {
        this.statusCode = statusCode;
    }

    /**
     * @return the requestId
     */
    public String getRequestId() {
        return requestId;
    }

    /**
     * @param requestId
     *            the requestId to set
     */
    public void setRequestId(String requestId) {
        this.requestId = requestId;
    }

    /**
     * @return the object
     */
    public Class<?> getObject() {
        return object;
    }

    /**
     * @param object
     *            the object to set
     */
    public void setObject(Class<?> object) {
        this.object = object;
    }

    /**
     * @return the etag
     */
    public String getEtag() {
        return etag;
    }

    /**
     * @param etag
     *            the etag to set
     */
    public void setEtag(String etag) {
        this.etag = etag;
    }

    /*
     * (non-Javadoc)
     * 
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        return "ApiMetadata [date=" + date + ", headers=" + headers + ", url=" + url + ", method=" + method
                + ", statusCode=" + statusCode + ", requestId=" + requestId + ", object=" + object + ", etag=" + etag
                + "]";
    }

}
