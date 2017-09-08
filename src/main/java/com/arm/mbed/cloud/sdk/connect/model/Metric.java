package com.arm.mbed.cloud.sdk.connect.model;

import java.util.Date;

import com.arm.mbed.cloud.sdk.annotations.DefaultValue;
import com.arm.mbed.cloud.sdk.annotations.Internal;
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
    private final long handshakes;
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
    private final long fullRegistrations;
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
    /**
     * Number of successful proxy requests from Mbed Cloud Connect to devices linked to the account. The proxy requests
     * are made from Mbed Cloud Connect to devices when you try to read or write values to device resources using
     * Connect API endpoints.
     */
    @DefaultValue(value = "0")
    private final long successfulProxyRequests;
    /**
     * Number of failed proxy requests from Mbed Cloud Connect to devices linked to the account. The proxy requests are
     * made from Mbed Cloud Connect to devices when you try to read or write values to device resources using Connect
     * API endpoints.
     */
    @DefaultValue(value = "0")
    private final long failedProxyRequests;
    /**
     * Number of successful subscription requests from Mbed Cloud Connect to devices linked to the account.The
     * subscription requests are made from Mbed Cloud Connect to devices when you try to subscribe to a resource path
     * using Connect API endpoints.
     */
    @DefaultValue(value = "0")
    private final long successfulSubscriptionRequests;
    /**
     * Number of failed subscription requests from Mbed Cloud Connect to devices linked to the account. The subscription
     * requests are made from Mbed Cloud Connect to devices when you try to subscribe to a resource path using Connect
     * API endpoints.
     */
    @DefaultValue(value = "0")
    private final long failedSubscriptionRequests;
    /**
     * Number of observations received by Mbed Cloud Connect from the devices linked to the account.The observations are
     * pushed from the device to Mbed Cloud Connect when you have successfully subscribed to the device resources using
     * Connect API endpoints.
     */
    @DefaultValue(value = "0")
    private final long observations;

    @Internal
    public Metric(String id, Date timestamp, long transactions, long successfulApiCalls, long failedApiCalls,
            long successfulHandshakes, long pendingBootstraps, long successfulBootstraps, long failedBootstraps,
            long registrations, long updatedRegistrations, long expiredRegistrations, long deletedRegistrations,
            long successfulDeviceProxyRequests, long failedDeviceProxyRequests,
            long successfulDeviceSubscriptionRequests, long failedDeviceSubscriptionRequests, long deviceObservations) {
        super();
        setId(id);
        this.timestamp = timestamp;
        this.transactions = transactions;
        this.successfulApiCalls = successfulApiCalls;
        this.failedApiCalls = failedApiCalls;
        this.handshakes = successfulHandshakes;
        this.pendingBootstraps = pendingBootstraps;
        this.successfulBootstraps = successfulBootstraps;
        this.failedBootstraps = failedBootstraps;
        this.fullRegistrations = registrations;
        this.updatedRegistrations = updatedRegistrations;
        this.expiredRegistrations = expiredRegistrations;
        this.deletedRegistrations = deletedRegistrations;
        this.successfulProxyRequests = successfulDeviceProxyRequests;
        this.failedProxyRequests = failedDeviceProxyRequests;
        this.successfulSubscriptionRequests = successfulDeviceSubscriptionRequests;
        this.failedSubscriptionRequests = failedDeviceSubscriptionRequests;
        this.observations = deviceObservations;
    }

    public Metric() {
        this(null, new Date(), 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0);
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
    public long getFullRegistrations() {
        return fullRegistrations;
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
    public long getHandshakes() {
        return handshakes;
    }

    /**
     * @return the successfulDeviceProxyRequests
     */
    public long getSuccessfulProxyRequests() {
        return successfulProxyRequests;
    }

    /**
     * @return the failedDeviceProxyRequests
     */
    public long getFailedProxyRequests() {
        return failedProxyRequests;
    }

    /**
     * @return the successfulDeviceSubscriptionRequests
     */
    public long getSuccessfulSubscriptionRequests() {
        return successfulSubscriptionRequests;
    }

    /**
     * @return the failedDeviceSubscriptionRequests
     */
    public long getFailedSubscriptionRequests() {
        return failedSubscriptionRequests;
    }

    /**
     * @return the deviceObservations
     */
    public long getObservations() {
        return observations;
    }

    /*
     * (non-Javadoc)
     * 
     * @see java.lang.Object#clone()
     */
    @Override
    public Metric clone() throws CloneNotSupportedException {
        return new Metric(id, timestamp, transactions, successfulApiCalls, failedApiCalls, handshakes,
                pendingBootstraps, successfulBootstraps, failedBootstraps, fullRegistrations, updatedRegistrations,
                expiredRegistrations, deletedRegistrations, successfulProxyRequests, failedProxyRequests,
                successfulSubscriptionRequests, failedSubscriptionRequests, observations);
    }

}
