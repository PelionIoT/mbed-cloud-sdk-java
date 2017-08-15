package com.arm.mbed.cloud.sdk.connect.model;

import java.net.URL;
import java.util.Map;

import com.arm.mbed.cloud.sdk.annotations.Preamble;

@Preamble(description = "Webhook")
public class Webhook {
    /**
     * The URL to which the notifications must be sent
     */
    private URL url;
    /**
     * Headers (key/value) that must be sent with the request
     */
    Map<String, String> headers;

    public Webhook() {
        super();
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

}
