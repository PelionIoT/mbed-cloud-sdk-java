package com.arm.mbed.cloud.sdk.common;

import java.util.concurrent.TimeUnit;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.arm.mbed.cloud.sdk.annotations.DefaultValue;
import com.arm.mbed.cloud.sdk.annotations.Preamble;

@Preamble(description = "Time period")
public class TimePeriod implements Cloneable {
    private enum PeriodTimeUnit {
        YEARS, WEEKS, DAYS, HOURS, MINUTES, SECONDS, NANOSECONDS;
    }

    private static final Pattern STRING_PATTERN = Pattern.compile("\\s*(\\d+)\\s*([A-Za-z])\\s*");
    private static final int DEFAULT_DURATION = 1;
    private static final PeriodTimeUnit DEFAULT_UNIT = PeriodTimeUnit.DAYS;
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

    /**
     * Defines a timeout in second
     * 
     * @param duration
     *            in second
     */
    public TimePeriod(long duration) {
        this();
        setTimeout(duration);
    }

    public TimePeriod() {
        super();
        setTimePeriod(DEFAULT_DURATION, DEFAULT_UNIT);
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

    /**
     * Sets as a timeout in second
     * 
     * @param timeout
     *            timeout in second
     */
    public void setTimeout(long timeout) {
        setUnit(TimeUnit.SECONDS);
        setDuration(timeout);
    }

    /*
     * (non-Javadoc)
     * 
     * @see java.lang.Object#toString()
     */
    @SuppressWarnings("incomplete-switch")
    @Override
    public String toString() {
        if (unit == null || duration == 0) {
            setTimePeriod(DEFAULT_DURATION, DEFAULT_UNIT);
        }
        StringBuilder builder = new StringBuilder();
        switch (unit) {
            case DAYS:
                if (duration >= 7 && duration % 7 == 0) {
                    builder.append(duration / 7).append("w");
                } else {
                    builder.append(duration).append("d");
                }
                break;
            case HOURS:
                if (duration >= 24 && duration % 24 == 0) {
                    builder.append(duration / 24).append("d");
                } else {
                    builder.append(duration).append("h");
                }
                break;
            case MINUTES:
                if (duration >= 60 && duration % 60 == 0) {
                    builder.append(duration / 60).append("h");
                } else {
                    builder.append(duration).append("m");
                }
                break;
            case NANOSECONDS:
                if (duration >= 1000000000 && duration % 1000000000 == 0) {
                    builder.append(duration / 1000000000).append("s");
                } else {
                    builder.append(duration).append("n");
                }
                break;
            case SECONDS:
                if (duration >= 60 && duration % 60 == 0) {
                    builder.append(duration / 60).append("m");
                } else {
                    builder.append(duration).append("s");
                }
                break;
        }

        return builder.toString();
    }

    public void fromString(String value) {
        setTimePeriod(DEFAULT_DURATION, DEFAULT_UNIT);
        if (value == null || value.isEmpty()) {
            return;
        }
        Matcher matcher = STRING_PATTERN.matcher(value);
        if (matcher.matches()) {
            setTimePeriod(Long.parseLong(matcher.group(1)), getUnitFromChar(matcher.group(2)));
        }
    }

    private void setTimePeriod(long duration, PeriodTimeUnit unit) {
        switch (unit) {
            case DAYS:
                setUnit(TimeUnit.DAYS);
                setDuration(duration);
                break;
            case HOURS:
                setUnit(TimeUnit.HOURS);
                setDuration(duration);
                break;
            case MINUTES:
                setUnit(TimeUnit.MINUTES);
                setDuration(duration);
                break;
            case NANOSECONDS:
                setUnit(TimeUnit.NANOSECONDS);
                setDuration(duration);
                break;
            case SECONDS:
                setUnit(TimeUnit.SECONDS);
                setDuration(duration);
                break;
            case WEEKS:
                setUnit(TimeUnit.DAYS);
                setDuration(7l * duration);
                break;
            case YEARS:
                setUnit(TimeUnit.DAYS);
                setDuration(365l * duration);
                break;
            default:
                break;
        }
    }

    private static PeriodTimeUnit getUnitFromChar(String string) {
        if (string == null || string.isEmpty()) {
            return DEFAULT_UNIT;
        }
        String trimmedString = string.toLowerCase().trim();
        if (trimmedString.length() != 1) {
            return DEFAULT_UNIT;
        }
        switch (trimmedString) {
            case "y":
                return PeriodTimeUnit.YEARS;
            case "w":
                return PeriodTimeUnit.WEEKS;
            case "d":
                return PeriodTimeUnit.DAYS;
            case "h":
                return PeriodTimeUnit.HOURS;
            case "m":
                return PeriodTimeUnit.MINUTES;
            case "s":
                return PeriodTimeUnit.SECONDS;
            case "n":
                return PeriodTimeUnit.NANOSECONDS;
            default:
                break;
        }
        return DEFAULT_UNIT;
    }

    /*
     * (non-Javadoc)
     * 
     * @see java.lang.Object#clone()
     */
    @Override
    public TimePeriod clone() {
        TimePeriod clone = new TimePeriod(unit, duration);
        return clone;
    }

}
