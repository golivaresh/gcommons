/**
 * 
 */
package com.goh.gcommons.date;

import static java.time.temporal.ChronoUnit.DAYS;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.DateTimeException;
import java.time.Duration;
import java.time.LocalDate;
import java.time.Period;
import java.time.temporal.ChronoUnit;
import java.time.temporal.UnsupportedTemporalTypeException;
import java.util.Date;

import com.goh.gcommons.date.util.DateUtils;
/**
 * 
 * <strong>Periods.java</strong><br>
 * TODO Add class description.<br>
 * <br>
 * Version control:<br>
 * <ol>
 *      <li>1.0.0 | 04/02/2021 | Gustavo Olivares Hernandez | golivaresh.dev@gmail.com</li>
 * </ol>
 * 
 * @author golivaresh
 * @version 1.0.0
 * @since 1.0.0
 *
 */
public class Periods {

    /**
     * Constructor of Periods.
     */
    private Periods() {
        // TODO Auto-generated constructor stub
    }

    public static final long between(final Date fromDate, final Date toDate, final ChronoUnit period) {
        return getPeriod(fromDate, toDate, period);
    }
    
    public static final long between(final LocalDate fromDate, final LocalDate toDate, final ChronoUnit period) {
        return getPeriod(fromDate, toDate, period);
    }
    
    
    private static long getPeriod(final Object fromDate, final Object toDate, final ChronoUnit period) {
        if (fromDate == null || toDate == null) {
            throw new DateTimeException("The dates are required");
        }
        
        long value = 0;
        switch (period) {
        case NANOS:
            value = getTime(fromDate, toDate).toNanos();
            break;
        case MILLIS:
            value = getTime(fromDate, toDate).toMillis();
            break;
        case SECONDS:
            value = getTime(fromDate, toDate).getSeconds();
            break;
        case MINUTES:
            value = getTime(fromDate, toDate).toMinutes();
            break;
        case HOURS:
            value = getTime(fromDate, toDate).toHours();
            break;
        case DAYS:
            value = getTime(fromDate, toDate).toDays();
            break;
        case WEEKS:
            value = getPeriod(fromDate, toDate).toTotalMonths() * 4;
            break;
        case MONTHS:
            value = getPeriod(fromDate, toDate).toTotalMonths();
            break;
        case YEARS:
            value = getPeriod(fromDate, toDate).getYears();
            break;
        case DECADES:
            value = getPeriod(fromDate, toDate).getYears() / 10;
            break;
        case CENTURIES:
            value = getPeriod(fromDate, toDate).getYears() / 100;
            break;
        case MILLENNIA:
            value = getPeriod(fromDate, toDate).getYears() / 1000;
            break;
        default:
            // Periods not supported MICROS, HALF_DAYS, ERAS, FOREVER.
            throw new UnsupportedTemporalTypeException("Unsupported unit: " + period);
        }
        return value;
    }

    private static final Period getPeriod(final Object fromDate, final Object toDate) {
        LocalDate localFrom = null;
        LocalDate localTo = null;
        if (fromDate instanceof Date) {
            localFrom = DateUtils.convertLocalDate((Date) fromDate);
            localTo = DateUtils.convertLocalDate((Date) toDate);
        } else if (fromDate instanceof LocalDate) {
            localFrom = ((LocalDate) fromDate);
            localTo = ((LocalDate) toDate);
        }
        return Period.between(localFrom, localTo);
    }

    private static final Duration getTime(final Object fromDate, final Object toDate) {
        Date dateFrom = null;
        Date dateTo = null;

        if (fromDate instanceof Date) {
            dateFrom = ((Date) fromDate);
            dateTo = ((Date) toDate);
        } else if (fromDate instanceof LocalDate) {
            dateFrom = DateUtils.convertToDate((LocalDate) fromDate);
            dateTo = DateUtils.convertToDate((LocalDate) toDate);
        }
        return Duration.between(dateFrom.toInstant(), dateTo.toInstant());
    }
    
    @Deprecated
    public static final long getDaysBetween(final String dateBefore, final String dateAfter) {
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
        try {
            final Date before = formatter.parse(dateBefore);
            final Date after = formatter.parse(dateAfter);
            return DAYS.between(new java.sql.Date(before.getTime()).toLocalDate(),
                    new java.sql.Date(after.getTime()).toLocalDate());
        } catch (ParseException e) {
            e.printStackTrace();
            return 0L;
        }
    }
}
