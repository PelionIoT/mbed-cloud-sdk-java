package com.arm.mbed.cloud.sdk.common;

import java.util.concurrent.TimeUnit;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.arm.mbed.cloud.sdk.annotations.DefaultValue;
import com.arm.mbed.cloud.sdk.annotations.Preamble;

@Preamble(description = "Time period")
public class TimePeriod {
    private static final Pattern STRING_PATTERN = Pattern.compile("\\s*(\\d+)\\s*([A-Za-z])\\s*");
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

    public TimePeriod(long duration) {
        this(TimeUnit.SECONDS, duration);
    }

    public TimePeriod() {
        this(DEFAULT_UNIT, DEFAULT_DURATION);
    }

    public TimePeriod(String value) {
        fromString(value);
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
        return duration + unitStr.substring(0, 1);
    }

    public static TimeUnit getUnitFromChar(String string) {
        if (string == null || string.isEmpty()) {
            return DEFAULT_UNIT;
        }
        String trimmedString = string.toLowerCase().trim();
        if (trimmedString.length() != 1) {
            return DEFAULT_UNIT;
        }
        switch (trimmedString) {
            case "d":
                return TimeUnit.DAYS;
            case "h":
                return TimeUnit.HOURS;
            case "m":
                return TimeUnit.MINUTES;
            case "s":
                return TimeUnit.SECONDS;
            case "n":
                return TimeUnit.NANOSECONDS;
            default:
                break;
        }
        return DEFAULT_UNIT;
    }

    public void fromString(String value) {
        setDuration(DEFAULT_DURATION);
        setUnit(DEFAULT_UNIT);
        if (value == null || value.isEmpty()) {
            return;
        }
        Matcher matcher = STRING_PATTERN.matcher(value);
        if (matcher.matches()) {
            setDuration(Long.parseLong(matcher.group(1)));
            setUnit(getUnitFromChar(matcher.group(2)));
        }
    }

}
