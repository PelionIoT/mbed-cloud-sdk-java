package com.arm.mbed.cloud.sdk.connect.model;

import com.arm.mbed.cloud.sdk.annotations.Preamble;
import com.arm.mbed.cloud.sdk.common.TimePeriod;
import com.arm.mbed.cloud.sdk.common.listing.ListOptions;

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
        setDefault();
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

    /*
     * (non-Javadoc)
     *
     * @see
     * com.arm.mbed.cloud.sdk.common.listing.ListOptions#setOptions(com.arm.mbed.cloud.sdk.common.listing.ListOptions)
     */
    /*
     * (non-Javadoc)
     *
     * @see com.arm.mbed.cloud.sdk.common.listing.ListOptions#setDefault()
     */
    @Override
    protected void setDefault() {
        super.setDefault();
        setPeriod(new TimePeriod());
    }

    @Override
    protected <T extends ListOptions> void setOptions(T options) {
        if (options == null) {
            setDefault();
            return;
        }
        super.setOptions(options);
        if (MetricsPeriodListOptions.class.isAssignableFrom(options.getClass())) {
            final MetricsPeriodListOptions opt = (MetricsPeriodListOptions) options;
            setPeriod(opt.getPeriod());
        }
    }

    /*
     * (non-Javadoc)
     *
     * @see java.lang.Object#hashCode()
     */
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = super.hashCode();
        result = prime * result + ((period == null) ? 0 : period.hashCode());
        return result;
    }

    /*
     * (non-Javadoc)
     *
     * @see java.lang.Object#equals(java.lang.Object)
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!super.equals(obj)) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final MetricsPeriodListOptions other = (MetricsPeriodListOptions) obj;
        if (period == null) {
            if (other.period != null) {
                return false;
            }
        } else if (!period.equals(other.period)) {
            return false;
        }
        return true;
    }

    /*
     * (non-Javadoc)
     *
     * @see com.arm.mbed.cloud.sdk.common.listing.ListOptions#clone()
     */
    @Override
    public MetricsPeriodListOptions clone() {
        final MetricsPeriodListOptions opt = new MetricsPeriodListOptions();
        opt.setOptions(this);
        return opt;
    }
}
