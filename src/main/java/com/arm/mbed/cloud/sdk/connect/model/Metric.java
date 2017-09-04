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
     * Number of pending bootstraps the account has used.
     */
    private long pendingBootstraps;
    /**
     * Number of successful bootstraps the account has used.
     */
    private long successfulBootstraps;
    /**
     * Number of failed bootstraps the account has used.
     */
    private long failedBootstraps;
    /**
     * Number of registrations
     */
    private long registrations;
    /**
     * Number of updated registrations
     */
    private long updatedRegistrations;
    /**
     * Number of expired registrations
     */
    private long expiredRegistrations;
    /**
     * Number of deleted registrations
     */
    private long deletedRegistrations;

    public Metric() {
        super();
    }

    /**
     * @return the pendingBootstraps
     */
    public long getPendingBootstraps() {
        return pendingBootstraps;
    }

    /**
     * @param pendingBootstraps
     *            the pendingBootstraps to set
     */
    public void setPendingBootstraps(long pendingBootstraps) {
        this.pendingBootstraps = pendingBootstraps;
    }

    /**
     * @return the successfulBootstraps
     */
    public long getSuccessfulBootstraps() {
        return successfulBootstraps;
    }

    /**
     * @param successfulBootstraps
     *            the successfulBootstraps to set
     */
    public void setSuccessfulBootstraps(long successfulBootstraps) {
        this.successfulBootstraps = successfulBootstraps;
    }

    /**
     * @return the failedBootstraps
     */
    public long getFailedBootstraps() {
        return failedBootstraps;
    }

    /**
     * @param failedBootstraps
     *            the failedBootstraps to set
     */
    public void setFailedBootstraps(long failedBootstraps) {
        this.failedBootstraps = failedBootstraps;
    }

    /**
     * @return the registrations
     */
    public long getRegistrations() {
        return registrations;
    }

    /**
     * @param registrations
     *            the registrations to set
     */
    public void setRegistrations(long registrations) {
        this.registrations = registrations;
    }

    /**
     * @return the updatedRegistrations
     */
    public long getUpdatedRegistrations() {
        return updatedRegistrations;
    }

    /**
     * @param updatedRegistrations
     *            the updatedRegistrations to set
     */
    public void setUpdatedRegistrations(long updatedRegistrations) {
        this.updatedRegistrations = updatedRegistrations;
    }

    /**
     * @return the expiredRegistrations
     */
    public long getExpiredRegistrations() {
        return expiredRegistrations;
    }

    /**
     * @param expiredRegistrations
     *            the expiredRegistrations to set
     */
    public void setExpiredRegistrations(long expiredRegistrations) {
        this.expiredRegistrations = expiredRegistrations;
    }

    /**
     * @return the deletedRegistrations
     */
    public long getDeletedRegistrations() {
        return deletedRegistrations;
    }

    /**
     * @param deletedRegistrations
     *            the deletedRegistrations to set
     */
    public void setDeletedRegistrations(long deletedRegistrations) {
        this.deletedRegistrations = deletedRegistrations;
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
}
