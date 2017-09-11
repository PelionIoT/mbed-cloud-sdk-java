package com.arm.mbed.cloud.sdk.connect.model;

import com.arm.mbed.cloud.sdk.annotations.Preamble;
import com.arm.mbed.cloud.sdk.common.TimePeriod;

@Preamble(description = "Options to use when listing metrics within a period")
public class MetricsPeriodListOptions extends AbstractMetricsListOptions {
    /**
     * Fetch data for this period until now
     */
    private TimePeriod period;

    public MetricsPeriodListOptions() {
        super();
        setPeriod(new TimePeriod());
    }

    /**
     * @return the period
     */
    public TimePeriod getPeriod() {
        return period;
    }

    /**
     * @param period
     *            the period to set
     */
    public void setPeriod(TimePeriod period) {
        this.period = period;
    }

    /**
     * @param period
     *            the period to set
     */
    public void setPeriod(String period) {
        setPeriod(new TimePeriod(period));
    }

}
