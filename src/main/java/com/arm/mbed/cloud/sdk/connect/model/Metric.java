package com.arm.mbed.cloud.sdk.connect.model;

import java.util.Date;

import com.arm.mbed.cloud.sdk.annotations.Preamble;
import com.arm.mbed.cloud.sdk.common.SDKModel;

@Preamble(description = "Metric")
public class Metric implements SDKModel {

    /**
     * 
     */
    private static final long serialVersionUID = -3773225008298999579L;
    /**
     * The ID of the metric
     */
    private String id;
    /**
     * UTC time in RFC3339 format
     */
    private Date timestamp;
    /**
     * Number of transaction events from devices linked to the account.
     */
    private long transactions;
    /**
     * Number of successful bootstraps the account has used.
     */
    private long successfulDeviceRegistrations;
    /**
     * Number of pending bootstraps the account has used.
     */
    private long pendingDeviceRegistrations;
    /**
     * Number of failed bootstraps the account has used.
     */
    private long failedDeviceRegistrations;
    /**
     * Number of successful device server REST API requests the account has used.
     */
    private long successfulApiCalls;
    /**
     * Number of failed device server REST API requests the account has used.
     */
    private long failedApiCalls;
    /**
     * Number of successful handshakes the account has used.
     */
    private long successfulHandshakes;
    /**
     * Number of failed handshakes the account has used.
     */
    private long failedHandshakes;
    /**
     * Maximum number of registered devices linked to the account.
     */
    private long registeredDevices;

    public Metric() {
        super();
    }

    /**
     * @return the id
     */
    public String getId() {
        return id;
    }

    /**
     * @param id
     *            the id to set
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * @return the timestamp
     */
    public Date getTimestamp() {
        return timestamp;
    }

    /**
     * @param timestamp
     *            the timestamp to set
     */
    public void setTimestamp(Date timestamp) {
        this.timestamp = timestamp;
    }

    /**
     * @return the transactions
     */
    public long getTransactions() {
        return transactions;
    }

    /**
     * @param transactions
     *            the transactions to set
     */
    public void setTransactions(long transactions) {
        this.transactions = transactions;
    }

    /**
     * @return the successfulDeviceRegistrations
     */
    public long getSuccessfulDeviceRegistrations() {
        return successfulDeviceRegistrations;
    }

    /**
     * @param successfulDeviceRegistrations
     *            the successfulDeviceRegistrations to set
     */
    public void setSuccessfulDeviceRegistrations(long successfulDeviceRegistrations) {
        this.successfulDeviceRegistrations = successfulDeviceRegistrations;
    }

    /**
     * @return the pendingDeviceRegistrations
     */
    public long getPendingDeviceRegistrations() {
        return pendingDeviceRegistrations;
    }

    /**
     * @param pendingDeviceRegistrations
     *            the pendingDeviceRegistrations to set
     */
    public void setPendingDeviceRegistrations(long pendingDeviceRegistrations) {
        this.pendingDeviceRegistrations = pendingDeviceRegistrations;
    }

    /**
     * @return the failedDeviceRegistrations
     */
    public long getFailedDeviceRegistrations() {
        return failedDeviceRegistrations;
    }

    /**
     * @param failedDeviceRegistrations
     *            the failedDeviceRegistrations to set
     */
    public void setFailedDeviceRegistrations(long failedDeviceRegistrations) {
        this.failedDeviceRegistrations = failedDeviceRegistrations;
    }

    /**
     * @return the successfulApiCalls
     */
    public long getSuccessfulApiCalls() {
        return successfulApiCalls;
    }

    /**
     * @param successfulApiCalls
     *            the successfulApiCalls to set
     */
    public void setSuccessfulApiCalls(long successfulApiCalls) {
        this.successfulApiCalls = successfulApiCalls;
    }

    /**
     * @return the failedApiCalls
     */
    public long getFailedApiCalls() {
        return failedApiCalls;
    }

    /**
     * @param failedApiCalls
     *            the failedApiCalls to set
     */
    public void setFailedApiCalls(long failedApiCalls) {
        this.failedApiCalls = failedApiCalls;
    }

    /**
     * @return the successfulHandshakes
     */
    public long getSuccessfulHandshakes() {
        return successfulHandshakes;
    }

    /**
     * @param successfulHandshakes
     *            the successfulHandshakes to set
     */
    public void setSuccessfulHandshakes(long successfulHandshakes) {
        this.successfulHandshakes = successfulHandshakes;
    }

    /**
     * @return the failedHandshakes
     */
    public long getFailedHandshakes() {
        return failedHandshakes;
    }

    /**
     * @param failedHandshakes
     *            the failedHandshakes to set
     */
    public void setFailedHandshakes(long failedHandshakes) {
        this.failedHandshakes = failedHandshakes;
    }

    /**
     * @return the registeredDevices
     */
    public long getRegisteredDevices() {
        return registeredDevices;
    }

    /**
     * @param registeredDevices
     *            the registeredDevices to set
     */
    public void setRegisteredDevices(long registeredDevices) {
        this.registeredDevices = registeredDevices;
    }

}
