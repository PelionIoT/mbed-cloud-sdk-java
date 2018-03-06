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
    private String javaVendorUrl;
    private String os;
    private String osVersion;
    private String osArchitecture;
    private String locale;

    private static final class SdkInformationHolder {

        static final SdkInformation INSTANCE = new SdkInformation();

        private SdkInformationHolder() {
            super();
        }

    }

    protected SdkInformation() {
        super();
        setJavaVersion(System.getProperty("java.version"));
        setJavaVendor(System.getProperty("java.vendor"));
        setJavaVendorUrl(System.getProperty("java.vendor.url"));
        setOs(System.getProperty("os.name"));
        setOsVersion(System.getProperty("os.version"));
        setOsArchitecture(System.getProperty("os.arch"));
        if (Manifests.exists(IMPLEMENTATION_TITLE_ATTRIBUTE)) {
            final String description = Manifests.read(IMPLEMENTATION_TITLE_ATTRIBUTE);
            if (description.toLowerCase(Locale.getDefault()).contains(MBED_IDENTIFIER)) {
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
     * Gets the Sdk version.
     * 
     * @return the sdkVersion
     */
    public String getSdkVersion() {
        return sdkVersion;
    }

    /**
     * Sets the Sdk version.
     * 
     * @param sdkVersion
     *            the sdkVersion to set
     */
    public void setSdkVersion(String sdkVersion) {
        this.sdkVersion = sdkVersion;
    }

    /**
     * Gets the Sdk description.
     * 
     * @return the sdkDescription
     */
    public String getSdkDescription() {
        return sdkDescription;
    }

    /**
     * Sets the Sdk description.
     * 
     * @param sdkDescription
     *            the sdkDescription to set
     */
    public void setSdkDescription(String sdkDescription) {
        this.sdkDescription = sdkDescription;
    }

    /**
     * Gets the Sdk licence Url.
     * 
     * @return the sdkLicence
     */
    public String getSdkLicence() {
        return sdkLicence;
    }

    /**
     * Sets the Sdk licence Url.
     * 
     * @param sdkLicence
     *            the sdkLicence to set
     */
    public void setSdkLicence(String sdkLicence) {
        this.sdkLicence = sdkLicence;
    }

    /**
     * Gets the Operating System the Sdk runs on.
     * 
     * @return the os
     */
    public String getOs() {
        return os;
    }

    /**
     * Sets the Operating System the Sdk runs on.
     * 
     * @param os
     *            the os to set
     */
    public void setOs(String os) {
        this.os = os;
    }

    /**
     * Gets the Operating System version.
     * 
     * @return the osVersion
     */
    public String getOsVersion() {
        return osVersion;
    }

    /**
     * Sets the Operating System version.
     * 
     * @param osVersion
     *            the osVersion to set
     */
    public void setOsVersion(String osVersion) {
        this.osVersion = osVersion;
    }

    /**
     * Gets the Operating System architecture.
     * 
     * @return the osArchitecture
     */
    public String getOsArchitecture() {
        return osArchitecture;
    }

    /**
     * Sets the Operating System architecture.
     * 
     * @param osArchitecture
     *            the osArchitecture to set
     */
    public void setOsArchitecture(String osArchitecture) {
        this.osArchitecture = osArchitecture;
    }

    /**
     * Sets the JRE version used.
     * 
     * @param javaVersion
     *            the javaVersion to set
     */
    public void setJavaVersion(String javaVersion) {
        this.javaVersion = javaVersion;
    }

    /**
     * Sets the JRE vendor.
     * 
     * @param javaVendor
     *            the javaVendor to set
     */
    public void setJavaVendor(String javaVendor) {
        this.javaVendor = javaVendor;
    }

    /**
     * Sets the JRE vendor Url.
     * 
     * @param javaVendorUrl
     *            the javaVendorURL to set
     */
    public void setJavaVendorUrl(String javaVendorUrl) {
        this.javaVendorUrl = javaVendorUrl;
    }

    /**
     * Gets the JRE version used.
     * 
     * @return the javaVersion
     */
    public String getJavaVersion() {
        return javaVersion;
    }

    /**
     * Gets the JRE vendor.
     * 
     * @return the javaVendor
     */
    public String getJavaVendor() {
        return javaVendor;
    }

    /**
     * Gets the JRE vendor Url.
     * 
     * @return the javaVendorUrl
     */
    public String getJavaVendorUrl() {
        return javaVendorUrl;
    }

    /**
     * Gets the locale used.
     * 
     * @return the locale
     */
    public String getLocale() {
        return locale;
    }

    /**
     * Sets the locale used.
     * 
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
                + javaVendorUrl + ", os=" + os + ", osVersion=" + osVersion + ", osArchitecture=" + osArchitecture
                + ", locale=" + locale + "]";
    }

    /**
     * Gets singleton instance.
     * 
     * @return singleton
     */
    public static SdkInformation getInstance() {
        return SdkInformationHolder.INSTANCE;
    }

    /**
     * Gets Sdk version.
     * 
     * @return Sdk version.
     */
    public static @Nullable String getVersion() {
        return SdkInformationHolder.INSTANCE.getSdkVersion();
    }

    /**
     * Gets Sdk description.
     * 
     * @return Sdk description.
     */
    public static @Nullable String getDescription() {
        return SdkInformationHolder.INSTANCE.getSdkDescription();
    }

    /**
     * Gets Sdk licence.
     * 
     * @return Sdk licence Url.
     */
    public static @Nullable String getLicence() {
        return SdkInformationHolder.INSTANCE.getSdkLicence();
    }

    /**
     * Gets JRE version in use.
     * 
     * @return java version.
     */
    public static @Nullable String getJreVersion() {
        return SdkInformationHolder.INSTANCE.getJavaVersion();
    }

    /**
     * Gets JRE vendor.
     * 
     * @return java VM provider.
     */
    public static @Nullable String getJreVendor() {
        return SdkInformationHolder.INSTANCE.getJavaVendor();
    }

    /**
     * Gets JRE vendor URL.
     * 
     * @return java VM provider Url.
     */
    public static @Nullable String getJreVendorUrl() {
        return SdkInformationHolder.INSTANCE.getJavaVendorUrl();
    }

    /**
     * Gets OS the Sdk runs on.
     * 
     * @return operating system description.
     */
    public static @Nullable String getOperatingSystem() {
        return SdkInformationHolder.INSTANCE.getOs();
    }

    /**
     * Gets OS version.
     * 
     * @return operating system version.
     */
    public static @Nullable String getOperatingSystemVersion() {
        return SdkInformationHolder.INSTANCE.getOsVersion();
    }

    /**
     * Gets operating system architecture.
     * 
     * @return architecture description.
     */
    public static @Nullable String getOperatingSystemArchitecture() {
        return SdkInformationHolder.INSTANCE.getOsArchitecture();
    }

    /**
     * Gets locale in use.
     * 
     * @return locale in use.
     */
    public static @Nullable String getEnvironmentLocale() {
        return SdkInformationHolder.INSTANCE.getLocale();
    }
}
