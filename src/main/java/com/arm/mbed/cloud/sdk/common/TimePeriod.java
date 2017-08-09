package com.arm.mbed.cloud.sdk.common;

import java.util.concurrent.TimeUnit;

import com.arm.mbed.cloud.sdk.annotations.DefaultValue;
import com.arm.mbed.cloud.sdk.annotations.Preamble;

@Preamble(description = "Time period")
public class TimePeriod {
    private static final int DEFAULT_DURATION = 1;
    private static final TimeUnit DEFAULT_UNIT = TimeUnit.DAYS;
    /**
     * The time period unit
     */
    @DefaultValue(value = "days")
    private TimeUnit unit;
    /**
     * The unit duration
     */
    @DefaultValue(value = "1")
    private long duration;

    public TimePeriod(TimeUnit unit, long duration) {
        super();
        this.unit = unit;
        this.duration = duration;
    }

    public TimePeriod() {
        this(DEFAULT_UNIT, DEFAULT_DURATION);
    }

    /**
     * @return the unit
     */
    public TimeUnit getUnit() {
        return unit;
    }

    /**
     * @param unit
     *            the unit to set
     */
    public void setUnit(TimeUnit unit) {
        this.unit = unit;
    }

    /**
     * @return the duration
     */
    public long getDuration() {
        return duration;
    }

    /**
     * @param duration
     *            the duration to set
     */
    public void setDuration(long duration) {
        this.duration = duration;
    }

    /*
     * (non-Javadoc)
     * 
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        if (unit == null) {
            setUnit(DEFAULT_UNIT);
        }
        if (duration == 0) {
            setDuration(DEFAULT_DURATION);
        }
        String unitStr = unit.toString().toLowerCase();
        return "" + duration + unitStr.substring(0, 1);
    }

}
