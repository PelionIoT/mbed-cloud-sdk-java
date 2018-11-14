/**
 *
 */
package com.mbed.lwm2m;

/**
 * LWM2M objects encoding types
 *
 */
public enum EncodingType {
    PLAIN_TEXT("text", "text/plain"),
    JSON("application/json", "application/json"),
    LWM2M_TLV("lwm2m+tlv", "application/vnd.oma.wm2m+tlv"),
    LWM2M_JSON("lwm2m+json", "application/vnd.oma.lwm2m+json"),
    LWM2M_OPAQUE("octet", "application/octet-stream"),
    LWM2M_CORE_LINK_PARAM("link", "application/link-format"),
    UNKNOWN("unknown", "");

    private final String value;
    private final String contentType;

    private EncodingType(String value, String contentType) {
        this.value = value;
        this.contentType = contentType;
    }

    /**
     * @return the value
     */
    public String getValue() {
        return value;
    }

    /**
     * @return the contentType
     */
    public String getContentType() {
        return contentType;
    }

    public static EncodingType getType(String contentType) {
        if (contentType == null) {
            return EncodingType.UNKNOWN;
        }
        for (EncodingType type : values()) {
            if (contentType.contains(type.value)) {
                return type;
            }
        }
        return EncodingType.UNKNOWN;
    }

}
