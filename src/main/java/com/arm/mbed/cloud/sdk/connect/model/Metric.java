package com.arm.mbed.cloud.sdk.connect.model;

import java.util.Date;

import com.arm.mbed.cloud.sdk.annotations.DefaultValue;
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
    @DefaultValue(value = "now()")
    private final Date timestamp;
    /**
     * Number of transaction events from devices linked to the account.
     */
    @DefaultValue(value = "0")
    private final long transactions;
    /**
     * Number of successful device server REST API requests the account has used.
     */
    @DefaultValue(value = "0")
    private final long successfulApiCalls;
    /**
     * Number of failed device server REST API requests the account has used.
     */
    @DefaultValue(value = "0")
    private final long failedApiCalls;
    /**
     * Number of successful handshakes the account has used.
     */
    @DefaultValue(value = "0")
    private final long successfulHandshakes;
    /**
     * Number of pending bootstraps the account has used.
     */
    @DefaultValue(value = "0")
    private final long pendingBootstraps;
    /**
     * Number of successful bootstraps the account has used.
     */
    @DefaultValue(value = "0")
    private final long successfulBootstraps;
    /**
     * Number of failed bootstraps the account has used.
     */
    @DefaultValue(value = "0")
    private final long failedBootstraps;
    /**
     * Number of registrations
     */
    @DefaultValue(value = "0")
    private final long registrations;
    /**
     * Number of updated registrations
     */
    @DefaultValue(value = "0")
    private final long updatedRegistrations;
    /**
     * Number of expired registrations
     */
    @DefaultValue(value = "0")
    private final long expiredRegistrations;
    /**
     * Number of deleted registrations
     */
    @DefaultValue(value = "0")
    private final long deletedRegistrations;

    public Metric(String id, Date timestamp, long transactions, long successfulApiCalls, long failedApiCalls,
            long successfulHandshakes, long pendingBootstraps, long successfulBootstraps, long failedBootstraps,
            long registrations, long updatedRegistrations, long expiredRegistrations, long deletedRegistrations) {
        super();
        setId(id);
        this.timestamp = timestamp;
        this.transactions = transactions;
        this.successfulApiCalls = successfulApiCalls;
        this.failedApiCalls = failedApiCalls;
        this.successfulHandshakes = successfulHandshakes;
        this.pendingBootstraps = pendingBootstraps;
        this.successfulBootstraps = successfulBootstraps;
        this.failedBootstraps = failedBootstraps;
        this.registrations = registrations;
        this.updatedRegistrations = updatedRegistrations;
        this.expiredRegistrations = expiredRegistrations;
        this.deletedRegistrations = deletedRegistrations;
    }

    public Metric() {
        this(null, new Date(), 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0);
    }

    /**
     * @return the pendingBootstraps
     */
    public long getPendingBootstraps() {
        return pendingBootstraps;
    }

    /**
     * @return the successfulBootstraps
     */
    public long getSuccessfulBootstraps() {
        return successfulBootstraps;
    }

    /**
     * @return the failedBootstraps
     */
    public long getFailedBootstraps() {
        return failedBootstraps;
    }

    /**
     * @return the registrations
     */
    public long getRegistrations() {
        return registrations;
    }

    /**
     * @return the updatedRegistrations
     */
    public long getUpdatedRegistrations() {
        return updatedRegistrations;
    }

    /**
     * @return the expiredRegistrations
     */
    public long getExpiredRegistrations() {
        return expiredRegistrations;
    }

    /**
     * @return the deletedRegistrations
     */
    public long getDeletedRegistrations() {
        return deletedRegistrations;
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
     * @return the transactions
     */
    public long getTransactions() {
        return transactions;
    }

    /**
     * @return the successfulApiCalls
     */
    public long getSuccessfulApiCalls() {
        return successfulApiCalls;
    }

    /**
     * @return the failedApiCalls
     */
    public long getFailedApiCalls() {
        return failedApiCalls;
    }

    /**
     * @return the successfulHandshakes
     */
    public long getSuccessfulHandshakes() {
        return successfulHandshakes;
    }

}
