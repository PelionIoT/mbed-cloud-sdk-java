package com.arm.mbed.cloud.sdk.connect.model;

import java.net.URL;
import java.util.Map;

import com.arm.mbed.cloud.sdk.annotations.Preamble;
import com.arm.mbed.cloud.sdk.common.SdkModel;

@Preamble(description = "Webhook")
public class Webhook implements SdkModel {
    /**
     * 
     */
    private static final long serialVersionUID = 6075770197049142567L;
    /**
     * The URL to which the notifications must be sent
     */
    private URL url;
    /**
     * Headers (key/value) that must be sent with the request
     */
    Map<String, String> headers;

    public Webhook(URL url, Map<String, String> headers) {
        super();
        setUrl(url);
        setHeaders(headers);
    }

    public Webhook() {
        this(null, null);
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
     * @return the headers
     */
    public Map<String, String> getHeaders() {
        return headers;
    }

    /**
     * @param headers
     *            the headers to set
     */
    public void setHeaders(Map<String, String> headers) {
        this.headers = headers;
    }

    /*
     * (non-Javadoc)
     * 
     * @see java.lang.Object#clone()
     */
    @Override
    public Webhook clone() throws CloneNotSupportedException {
        return new Webhook(url, headers);
    }

}
