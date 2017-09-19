package com.arm.mbed.cloud.sdk.connect.model;

import java.net.URL;
import java.util.LinkedHashMap;
import java.util.Map;

import com.arm.mbed.cloud.sdk.annotations.Preamble;
import com.arm.mbed.cloud.sdk.common.SdkModel;

@Preamble(description = "Webhook")
public class Webhook implements SdkModel {
    /**
     * Serialisation Id.
     */
    private static final long serialVersionUID = 6075770197049142567L;
    /**
     * The URL to which the notifications must be sent.
     */
    private URL url;
    /**
     * Headers (key/value) that must be sent with the request.
     */
    Map<String, String> headers;

    /**
     * Constructor.
     * 
     * @param url
     *            URL
     * @param headers
     *            headers (key/Value)
     */
    public Webhook(URL url, Map<String, String> headers) {
        super();
        setUrl(url);
        setHeaders(headers);
    }

    /**
     * Constructor.
     */
    public Webhook() {
        this(null, null);
    }

    /**
     * Gets the URL.
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
     * Gets HTTP headers.
     * 
     * @return the headers
     */
    public Map<String, String> getHeaders() {
        return headers;
    }

    /**
     * Sets HTTP headers.
     * 
     * @param headers
     *            the headers to set
     */
    public void setHeaders(Map<String, String> headers) {
        this.headers = headers;
    }

    /**
     * Adds an HTTP header.
     * 
     * @param key
     *            header
     * @param value
     *            header value
     */
    public void addHeader(String key, String value) {
        if (key == null || value == null) {
            return;
        }
        if (headers == null) {
            headers = new LinkedHashMap<>();
        }
        headers.put(key, value);
    }

    /**
     * Gets a clone.
     * 
     * @return a clone.
     * 
     * @see java.lang.Object#clone()
     */
    @Override
    public Webhook clone() throws CloneNotSupportedException {
        return new Webhook(url, headers);
    }

}
