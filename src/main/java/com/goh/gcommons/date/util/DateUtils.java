/**
 * 
 */
package com.goh.gcommons.date.util;

import static java.time.temporal.ChronoUnit.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.chrono.ChronoLocalDate;
import java.time.chrono.ChronoPeriod;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Date;


/**
 * 
 * <strong>DateUtils.java</strong><br>
 * Utilities for dates.<br>
 * <br>
 * Version control:<br>
 * <ol>
 *      <li>1.0.0 | 27/01/2021 | Gustavo Olivares Hernandez | golivaresh.dev@gmail.com</li>
 * </ol>
 * 
 * @author golivaresh
 * @version 1.0.0 
 * @since 1.0.0
 *
 */
public final class DateUtils {

    /**
     * Constructor of DateUtils.
     */
    private DateUtils() {
        // TODO Auto-generated constructor stub
    }
    
    public static final long getPeriod(final Date fromDate, final Date toDate, ChronoUnit period) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        ChronoLocalDate from = ChronoLocalDate.from(formatter.parse("01/01/2000"));
        ChronoLocalDate to = ChronoLocalDate.from(formatter.parse("01/01/2015"));
        ChronoPeriod chronoPeriod = ChronoPeriod.between(from, to);
        System.out.printf("%d años, %d meses y %d días\n", chronoPeriod.get(YEARS), chronoPeriod.get(MONTHS),
                chronoPeriod.get(DAYS));
        return chronoPeriod.get(period);
    }

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
