package com.arm.mbed.cloud.sdk.connect.model;

import com.arm.mbed.cloud.sdk.annotations.Preamble;
import com.arm.mbed.cloud.sdk.common.TimePeriod;

@Preamble(description = "Options to use when listing metrics within a period")
public class MetricsPeriodListOptions extends AbstractMetricsListOptions {
    /**
     * Fetch data for this period until now.
     */
    private TimePeriod period;

    /**
     * Constructor.
     */
    public MetricsPeriodListOptions() {
        super();
        setPeriod(new TimePeriod());
    }

    /**
     * Gets period to consider.
     * 
     * @return the period
     */
    public TimePeriod getPeriod() {
        return period;
    }

    /**
     * Sets period to consider.
     * 
     * @param period
     *            the period to set
     */
    public void setPeriod(TimePeriod period) {
        this.period = period;
    }

    /**
     * Sets period from a string.
     * <p>
     * 
     * @see TimePeriod#fromString(String) for more information about string format
     * 
     * @param period
     *            the period to set
     */
    public void setPeriod(String period) {
        setPeriod(new TimePeriod(period));
    }

}
