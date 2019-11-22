package com.arm.mbed.cloud.sdk.connect.model;

import java.net.URL;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Objects;

import com.arm.mbed.cloud.sdk.annotations.Internal;
import com.arm.mbed.cloud.sdk.annotations.PerformsNoOperation;
import com.arm.mbed.cloud.sdk.annotations.Preamble;
import com.arm.mbed.cloud.sdk.annotations.Required;
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
    @Required
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
     * Constructor.
     *
     * @param url
     *            URL
     *
     */
    public Webhook(URL url) {
        this();
        setUrl(url);
    }

    /**
     * Gets webhook id (url)
     * <p>
     *
     * @return the webhook URL as a string.
     */
    @Internal
    @Override
    public String getId() {
        return (getUrl() == null) ? null : getUrl().toString();
    }

    /*
     * (non-Javadoc)
     *
     * @see com.arm.mbed.cloud.sdk.common.SdkModel#setId(java.lang.String)
     */
    @PerformsNoOperation
    @Internal
    @Override
    public void setId(String id) {
        // Nothing to do

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
    @Required
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
    public Webhook clone() {
        return new Webhook(url, headers);
    }

    /**
     * Determines whether all required fields have been set and therefore if the model instance is valid.
     *
     * @return true if instance is valid. False otherwise.
     */
    @Override
    public boolean isValid() {
        return url != null;
    }

    @Override
    public int hashCode() {
        return Objects.hash(headers, url);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (!(obj instanceof Webhook)) {
            return false;
        }
        final Webhook other = (Webhook) obj;
        return Objects.equals(headers, other.headers) && Objects.equals(url, other.url);
    }

    /*
     * (non-Javadoc)
     *
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        return "Webhook [url=" + url + ", headers=" + headers + "]";
    }

}
