/**
 * 
 */
package com.goh.gcommons.date.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZoneId;
import java.util.Date;

/**
 * 
 * <strong>DateUtils.java</strong><br>
 * Utilities for dates.<br>
 * <br>
 * Version control:<br>
 * <ol>
 * <li>1.0.0 | 27/01/2021 | Gustavo Olivares Hernandez |
 * golivaresh.dev@gmail.com</li>
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
    }

    // Convert To Date

    /**
     * Convert the {@link LocalDate} object to {@link Date}.
     * 
     * @param localDate
     *            LocalDate object.
     * @return Date Object if localDate parameter is not null, null otherwise.
     */
    public static Date convertToDate(final LocalDate localDate) {
        return (localDate == null) ? null : Date.from(getInstant(localDate));
    }

    /**
     * Convert the {@link LocalDateTime} object to {@link Date}.
     * 
     * @param localDateTime
     *            LocalDateTime object.
     * @return Date Object if localDateTime parameter is not null, null otherwise.
     */
    public static Date convertToDate(final LocalDateTime localDateTime) {
        return (localDateTime == null) ? null : Date.from(getInstant(localDateTime));
    }

    /**
     * Convert the {@link LocalTime} object to {@link Date}.
     * 
     * @param localTime
     *            LocalTime object.
     * @param dateToTime
     *            Date, Since the DateTime object contains only time, we need a date
     *            to assign to the Date object. If this parameter is null, today's
     *            date is assigned by default.
     * @return Date Object if localTime and dateToTime parameters are not null, null
     *         otherwise.
     */
    public static Date convertToDate(final LocalTime localTime, final Date dateToTime) {
        return (localTime == null) ? null : Date.from(getInstant(localTime, dateToTime));
    }

    /**
     * Convert the {@link String} text to {@link Date}.
     * 
     * @param value
     *            Value to convert to Date.
     * @param pattern
     *            Date pattern to convert the string.
     * @return Date object if the parameters are correct.
     * @throws ParseException
     *             If the pattern is incorrect, an {@link ParseException} is thrown.
     */
    public static Date convertToDate(final String value, final String pattern) throws ParseException {
        SimpleDateFormat formatter = new SimpleDateFormat(pattern);
        return formatter.parse(value);
    }

    /* Convert To LocalDate */
    /**
     * Convert {@link Date} object to {@link LocalDate}.
     * 
     * @param date
     *            Date object to convert to LocalDate.
     * @return LocalDate object if Date is not null, null otherwise.
     */
    public static LocalDate convertLocalDate(final Date date) {
        return (date == null) ? null : date.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
    }

    /* Convert To LocalDateTime */
    /**
     * Convert {@link Date} to {@link LocalDateTime}.
     * 
     * @param date
     *            Date object to convert to LocalDateTime.
     * @return LocalDateTime object if parameter is not null, null otherwise.
     */
    public static LocalDateTime convertLocalDateTime(final Date date) {
        return (date == null) ? null : date.toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime();
    }

    /* Convert To LocalTime */
    /**
     * Convert {@link Date} to {@link LocalTime}.
     * 
     * @param date
     *            Date object to convert to LocalTime.
     * @return LocalTime object if parameter is not null, null otherwise.
     */
    public static LocalTime convertLocalTime(final Date date) {
        return (date == null) ? null : date.toInstant().atZone(ZoneId.systemDefault()).toLocalTime();
    }

    /* Get Instants */
    /**
     * Get the {@link Instant} object from the {@link LocalDate} object.
     * 
     * @param localDate
     *            Object to obtain the instant.
     * @return Instant object if parameter is not null, null otherwise.
     */
    public static Instant getInstant(final LocalDate localDate) {
        return (localDate == null) ? null : localDate.atStartOfDay().atZone(ZoneId.systemDefault()).toInstant();
    }

    /**
     * Get the {@link Instant} object from the {@link LocalDateTime} object.
     * 
     * @param localDate
     *            Object to obtain the instant.
     * @return Instant object if parameter is not null, null otherwise.
     */
    public static Instant getInstant(final LocalDateTime localDateTime) {
        return (localDateTime == null) ? null : localDateTime.atZone(ZoneId.systemDefault()).toInstant();
    }

    /**
     * 
     * Get the {@link Instant} object from the {@link LocalTime} object.<br>
     * 
     * @param localTime
     *            Object to obtain the instant.
     * @param dateToTime
     *            Date, Since the DateTime object contains only time, we need a date
     *            to assign to the Date object. If this parameter is null, today's
     *            date is assigned by default.
     * @return Date Object if localTime parameter is not null, null otherwise.
     */
    public static Instant getInstant(final LocalTime localTime, final Date dateToTime) {
        if (localTime == null) {
            return null;
        }
        LocalDate ld = convertLocalDate((dateToTime == null) ? new Date() : dateToTime);

        return localTime.atDate(LocalDate.of(ld.getYear(), ld.getMonthValue(), ld.getDayOfMonth()))
                .atZone(ZoneId.systemDefault()).toInstant();
    }

}
