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
     * @see com.arm.mbed.cloud.sdk.common.listing.ListOptions#clone()
     */
    @Override
    public MetricsPeriodListOptions clone() {
        final MetricsPeriodListOptions opt = new MetricsPeriodListOptions();
        opt.setOptions(this);
        return opt;
    }
}
