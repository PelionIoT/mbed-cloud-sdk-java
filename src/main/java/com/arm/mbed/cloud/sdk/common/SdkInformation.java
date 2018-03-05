package com.arm.mbed.cloud.sdk.common;

import java.io.Serializable;
import java.util.Locale;

import com.arm.mbed.cloud.sdk.annotations.Nullable;
import com.arm.mbed.cloud.sdk.annotations.Preamble;
import com.jcabi.manifests.Manifests;

@Preamble(description = "Information about the SDK")
public class SdkInformation implements Serializable {

    private static final String MBED_IDENTIFIER = "mbed";
    private static final String LICENCE_URL_ATTRIBUTE = "Bundle-License";
    private static final String DEFAULT_DESCRIPTION = "Arm Mbed Cloud SDK for Java";
    private static final String IMPLEMENTATION_TITLE_ATTRIBUTE = "Implementation-Title";
    private static final String IMPLEMENTATION_VERSION_ATTRIBUTE = "Implementation-Version";
    private static final String MBED_CLOUD_SDK_VERSION_SPECIFIC_ATTRIBUTE = "MbedCloudSdk-Version";
    private static final long serialVersionUID = -5990299519912590004L;
    private String sdkVersion;
    private String sdkDescription;
    private String sdkLicence;
    private String javaVersion;
    private String javaVendor;
    private String javaVendorURL;
    private String os;
    private String osVersion;
    private String osArchitecture;
    private String locale;

    private static class SdkInformationHolder {
        public static final SdkInformation INSTANCE = new SdkInformation();
    }

    private SdkInformation() {
        super();
        setJavaVersion(System.getProperty("java.version"));
        setJavaVendor(System.getProperty("java.vendor"));
        setJavaVendorURL(System.getProperty("java.vendor.url"));
        setOs(System.getProperty("os.name"));
        setOsVersion(System.getProperty("os.version"));
        setOsArchitecture(System.getProperty("os.arch"));
        if (Manifests.exists(IMPLEMENTATION_TITLE_ATTRIBUTE)) {
            final String description = Manifests.read(IMPLEMENTATION_TITLE_ATTRIBUTE);
            if (description.toLowerCase().contains(MBED_IDENTIFIER)) {
                setSdkDescription(description);
            } else {
                setSdkDescription(DEFAULT_DESCRIPTION);
            }
        } else {
            setSdkDescription(DEFAULT_DESCRIPTION);
        }
        if (Manifests.exists(MBED_CLOUD_SDK_VERSION_SPECIFIC_ATTRIBUTE)) {
            setSdkVersion(Manifests.read(MBED_CLOUD_SDK_VERSION_SPECIFIC_ATTRIBUTE));
        } else {
            if (Manifests.exists(IMPLEMENTATION_VERSION_ATTRIBUTE)) {
                setSdkVersion(Manifests.read(IMPLEMENTATION_VERSION_ATTRIBUTE));
            } else {
                setSdkVersion(null);
            }
        }
        if (Manifests.exists(LICENCE_URL_ATTRIBUTE)) {
            setSdkLicence(Manifests.read(LICENCE_URL_ATTRIBUTE));
        } else {
            setSdkLicence(null);
        }
        setLocale(Locale.getDefault().toString());

    }

    /**
     * @return the sdkVersion
     */
    public String getSdkVersion() {
        return sdkVersion;
    }

    /**
     * @param sdkVersion
     *            the sdkVersion to set
     */
    public void setSdkVersion(String sdkVersion) {
        this.sdkVersion = sdkVersion;
    }

    /**
     * @return the sdkDescription
     */
    public String getSdkDescription() {
        return sdkDescription;
    }

    /**
     * @param sdkDescription
     *            the sdkDescription to set
     */
    public void setSdkDescription(String sdkDescription) {
        this.sdkDescription = sdkDescription;
    }

    /**
     * @return the sdkLicence
     */
    public String getSdkLicence() {
        return sdkLicence;
    }

    /**
     * @param sdkLicence
     *            the sdkLicence to set
     */
    public void setSdkLicence(String sdkLicence) {
        this.sdkLicence = sdkLicence;
    }

    /**
     * @return the os
     */
    public String getOs() {
        return os;
    }

    /**
     * @param os
     *            the os to set
     */
    public void setOs(String os) {
        this.os = os;
    }

    /**
     * @return the osVersion
     */
    public String getOsVersion() {
        return osVersion;
    }

    /**
     * @param osVersion
     *            the osVersion to set
     */
    public void setOsVersion(String osVersion) {
        this.osVersion = osVersion;
    }

    /**
     * @return the osArchitecture
     */
    public String getOsArchitecture() {
        return osArchitecture;
    }

    /**
     * @param osArchitecture
     *            the osArchitecture to set
     */
    public void setOsArchitecture(String osArchitecture) {
        this.osArchitecture = osArchitecture;
    }

    /**
     * @param javaVersion
     *            the javaVersion to set
     */
    public void setJavaVersion(String javaVersion) {
        this.javaVersion = javaVersion;
    }

    /**
     * @param javaVendor
     *            the javaVendor to set
     */
    public void setJavaVendor(String javaVendor) {
        this.javaVendor = javaVendor;
    }

    /**
     * @param javaVendorURL
     *            the javaVendorURL to set
     */
    public void setJavaVendorURL(String javaVendorURL) {
        this.javaVendorURL = javaVendorURL;
    }

    /**
     * @return the javaVersion
     */
    public String getJavaVersion() {
        return javaVersion;
    }

    /**
     * @return the javaVendor
     */
    public String getJavaVendor() {
        return javaVendor;
    }

    /**
     * @return the javaVendorURL
     */
    public String getJavaVendorURL() {
        return javaVendorURL;
    }

    /**
     * @return the locale
     */
    public String getLocale() {
        return locale;
    }

    /**
     * @param locale
     *            the locale to set
     */
    public void setLocale(String locale) {
        this.locale = locale;
    }

    /*
     * (non-Javadoc)
     * 
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        return "SdkInformation [sdkVersion=" + sdkVersion + ", sdkDescription=" + sdkDescription + ", sdkLicence="
                + sdkLicence + ", javaVersion=" + javaVersion + ", javaVendor=" + javaVendor + ", javaVendorURL="
                + javaVendorURL + ", os=" + os + ", osVersion=" + osVersion + ", osArchitecture=" + osArchitecture
                + ", locale=" + locale + "]";
    }

    public static SdkInformation getInstance() {
        return SdkInformationHolder.INSTANCE;
    }

    public static @Nullable String getVersion() {
        return SdkInformationHolder.INSTANCE.getSdkVersion();
    }

    public static @Nullable String getDescription() {
        return SdkInformationHolder.INSTANCE.getSdkDescription();
    }

    public static @Nullable String getLicence() {
        return SdkInformationHolder.INSTANCE.getSdkLicence();
    }

    public static @Nullable String getJreVersion() {
        return SdkInformationHolder.INSTANCE.getJavaVersion();
    }

    public static @Nullable String getJreVendor() {
        return SdkInformationHolder.INSTANCE.getJavaVendor();
    }

    public static @Nullable String getJreVendorURL() {
        return SdkInformationHolder.INSTANCE.getJavaVendorURL();
    }

    public static @Nullable String getOperatingSystem() {
        return SdkInformationHolder.INSTANCE.getOs();
    }

    public static @Nullable String getOperatingSystemVersion() {
        return SdkInformationHolder.INSTANCE.getOsVersion();
    }

    public static @Nullable String getOperatingSystemArchitecture() {
        return SdkInformationHolder.INSTANCE.getOsArchitecture();
    }

    public static @Nullable String getEnvironmentLocale() {
        return SdkInformationHolder.INSTANCE.getLocale();
    }
}
