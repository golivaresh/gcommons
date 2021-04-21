package com.goh.gcommons.date.test;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.time.DateTimeException;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.time.temporal.UnsupportedTemporalTypeException;
import java.util.Date;

import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

import com.goh.gcommons.date.Periods;
import com.goh.gcommons.date.util.DateUtils;

@TestMethodOrder(OrderAnnotation.class)
class PeriodsTest {

    @Test
    @Order(1)
    void betweenTest() {
        final Date startDate = new Date();
        LocalDateTime today = DateUtils.convertLocalDateTime(startDate);
        Date endDate = null;
        long time = 0;

        System.out.println("--------------------------------------------------");
        System.out.println("Between Test NANOS");
        endDate = DateUtils.convertToDate(today.plusNanos(1000000000));
        time = Periods.between(startDate, endDate, ChronoUnit.NANOS);
        System.out.println(String.format("Between [%s] and [%s] there are [%s] NANOS", startDate, endDate, time));
        assertTrue(time == 1000000000);
        System.out.println("--------------------------------------------------");

        System.out.println("--------------------------------------------------");
        System.out.println("Between Test MILLIS");
        endDate = DateUtils.convertToDate(today.plusSeconds(5));
        time = Periods.between(startDate, endDate, ChronoUnit.MILLIS);
        System.out.println(String.format("Between [%s] and [%s] there are [%s] MILLIS", startDate, endDate, time));
        assertTrue(time == 5000);
        System.out.println("--------------------------------------------------");

        System.out.println("--------------------------------------------------");
        System.out.println("Between Test SECONDS");
        endDate = DateUtils.convertToDate(today.plusMinutes(1));
        time = Periods.between(startDate, endDate, ChronoUnit.SECONDS);
        System.out.println(String.format("Between [%s] and [%s] there are [%s] SECONDS", startDate, endDate, time));
        assertTrue(time == 60);
        System.out.println("--------------------------------------------------");

        System.out.println("--------------------------------------------------");
        System.out.println("Between Test MINUTES");
        endDate = DateUtils.convertToDate(today.plusSeconds(60));
        time = Periods.between(startDate, endDate, ChronoUnit.MINUTES);
        System.out.println(String.format("Between [%s] and [%s] there are [%s] MINUTES", startDate, endDate, time));
        assertTrue(time == 1);
        System.out.println("--------------------------------------------------");

        System.out.println("--------------------------------------------------");
        System.out.println("Between Test HOURS");
        endDate = DateUtils.convertToDate(today.plusDays(1));
        time = Periods.between(startDate, endDate, ChronoUnit.HOURS);
        System.out.println(String.format("Between [%s] and [%s] there are [%s] HOURS", startDate, endDate, time));
        assertTrue(time == 24);
        System.out.println("--------------------------------------------------");

        System.out.println("--------------------------------------------------");
        System.out.println("Between Test DAYS");
        endDate = DateUtils.convertToDate(today.plusHours(24));
        time = Periods.between(startDate, endDate, ChronoUnit.DAYS);
        System.out.println(String.format("Between [%s] and [%s] there are [%s] DAYS", startDate, endDate, time));
        assertTrue(time == 1);
        System.out.println("--------------------------------------------------");

        System.out.println("--------------------------------------------------");
        System.out.println("Between Test WEEKS");
        endDate = DateUtils.convertToDate(today.plusHours(168));
        time = Periods.between(startDate, endDate, ChronoUnit.WEEKS);
        System.out.println(String.format("Between [%s] and [%s] there are [%s] WEEKS", startDate, endDate, time));
        assertTrue(time == 1);
        System.out.println("--------------------------------------------------");

        System.out.println("--------------------------------------------------");
        System.out.println("Between Test MONTHS");
        endDate = DateUtils.convertToDate(today.plusDays(365));
        time = Periods.between(startDate, endDate, ChronoUnit.MONTHS);
        System.out.println(String.format("Between [%s] and [%s] there are [%s] MONTHS", startDate, endDate, time));
        assertTrue(time == 12);
        System.out.println("--------------------------------------------------");

        System.out.println("--------------------------------------------------");
        System.out.println("Between Test YEARS");
        endDate = DateUtils.convertToDate(today.plusDays(365));
        time = Periods.between(startDate, endDate, ChronoUnit.YEARS);
        System.out.println(String.format("Between [%s] and [%s] there are [%s] YEARS", startDate, endDate, time));
        assertTrue(time == 1);
        System.out.println("--------------------------------------------------");

        System.out.println("--------------------------------------------------");
        System.out.println("Between Test DECADES");
        endDate = DateUtils.convertToDate(today.plusDays(3652));
        time = Periods.between(startDate, endDate, ChronoUnit.DECADES);
        System.out.println(String.format("Between [%s] and [%s] there are [%s] DECADES", startDate, endDate, time));
        assertTrue(time == 1);
        System.out.println("--------------------------------------------------");

        System.out.println("--------------------------------------------------");
        System.out.println("Between Test CENTURIES");
        endDate = DateUtils.convertToDate(today.plusYears(1000));
        time = Periods.between(startDate, endDate, ChronoUnit.CENTURIES);
        System.out.println(String.format("Between [%s] and [%s] there are [%s] CENTURIES", startDate, endDate, time));
        assertTrue(time == 10);
        System.out.println("--------------------------------------------------");

        System.out.println("--------------------------------------------------");
        System.out.println("Between Test MILLENNIA");
        endDate = DateUtils.convertToDate(today.plusYears(1000));
        time = Periods.between(startDate, endDate, ChronoUnit.MILLENNIA);
        System.out.println(String.format("Between [%s] and [%s] there are [%s] MILLENNIA", startDate, endDate, time));
        assertTrue(time == 1);
        System.out.println("--------------------------------------------------");

//        ChronoUnit[] types = { ChronoUnit.NANOS, ChronoUnit.MILLIS, ChronoUnit.SECONDS, ChronoUnit.MINUTES,
//                ChronoUnit.HOURS, ChronoUnit.DAYS, ChronoUnit.WEEKS, ChronoUnit.MONTHS, ChronoUnit.YEARS,
//                ChronoUnit.DECADES, ChronoUnit.CENTURIES, ChronoUnit.MILLENNIA };

        // for (ChronoUnit type : types) {
        // time = Periods.between(startDate, endDate, type);
        // System.out.println(startDate + " and " + startDate + " is " + time + " " +
        // type.name());
        // }
    }

    @Test
    @Order(2)
    public void dateTimeExceptionTest() {
        System.out.println("--------------------------------------------------");
        System.out.println("Between Test DateTimeException");
        // A
        Exception dateTimeExceptionA = assertThrows(DateTimeException.class,
                () -> Periods.between(null, new Date(), ChronoUnit.YEARS));
        assertNotNull(dateTimeExceptionA);
        System.out.println("dateTimeException: " + dateTimeExceptionA.getMessage());
        assertTrue(dateTimeExceptionA.getMessage().contains("All parameters are required"));
        // B
        Exception dateTimeExceptionB = assertThrows(DateTimeException.class,
                () -> Periods.between(new Date(), null, ChronoUnit.YEARS));
        assertNotNull(dateTimeExceptionB);
        System.out.println("dateTimeException: " + dateTimeExceptionB.getMessage());
        assertTrue(dateTimeExceptionB.getMessage().contains("All parameters are required"));
        // C
        Exception dateTimeExceptionC = assertThrows(DateTimeException.class,
                () -> Periods.between(new Date(), new Date(), null));
        assertNotNull(dateTimeExceptionC);
        System.out.println("dateTimeException: " + dateTimeExceptionC.getMessage());
        assertTrue(dateTimeExceptionC.getMessage().contains("All parameters are required"));
        // C
        Exception dateTimeExceptionD = assertThrows(DateTimeException.class, () -> Periods.between(null, null, null));
        assertNotNull(dateTimeExceptionD);
        System.out.println("dateTimeException: " + dateTimeExceptionD.getMessage());
        assertTrue(dateTimeExceptionD.getMessage().contains("All parameters are required"));
        System.out.println("--------------------------------------------------");

        // Exception exception = assertThrows(UnsupportedTemporalTypeException.class, ()
        // -> {
        // Periods.between(new Date(), new Date(), null);
        // });
        // assertNotNull(exception);
        // System.out.println(exception);
        // assertTrue(assertMsg.contains(parseException.getMessage()));
    }

    @Test
    @Order(3)
    public void unsupportedTemporalTypeExceptionTest() {
        System.out.println("--------------------------------------------------");
        System.out.println("Between Test UnsupportedTemporalTypeException MICROS");
        // MICROS
        Exception unsupportedTemporalTypeExceptionA = assertThrows(UnsupportedTemporalTypeException.class,
                () -> Periods.between(new Date(), new Date(), ChronoUnit.MICROS));
        assertNotNull(unsupportedTemporalTypeExceptionA);
        System.out.println("UnsupportedTemporalTypeException: " + unsupportedTemporalTypeExceptionA.getMessage());
        assertTrue(unsupportedTemporalTypeExceptionA.getMessage().contains("Unsupported unit: Micros"));
        System.out.println("--------------------------------------------------");
        
        System.out.println("--------------------------------------------------");
        System.out.println("Between Test UnsupportedTemporalTypeException HALF_DAYS");
        // HALF_DAYS
        Exception unsupportedTemporalTypeExceptionB = assertThrows(UnsupportedTemporalTypeException.class,
                () -> Periods.between(new Date(), new Date(), ChronoUnit.HALF_DAYS));
        assertNotNull(unsupportedTemporalTypeExceptionB);
        System.out.println("UnsupportedTemporalTypeException: " + unsupportedTemporalTypeExceptionB.getMessage());
        assertTrue(unsupportedTemporalTypeExceptionB.getMessage().contains("Unsupported unit: HalfDays"));
        System.out.println("--------------------------------------------------");
        
        System.out.println("--------------------------------------------------");
        System.out.println("Between Test UnsupportedTemporalTypeException ERAS");
        // HALF_DAYS
        Exception unsupportedTemporalTypeExceptionC = assertThrows(UnsupportedTemporalTypeException.class,
                () -> Periods.between(new Date(), new Date(), ChronoUnit.ERAS));
        assertNotNull(unsupportedTemporalTypeExceptionC);
        System.out.println("UnsupportedTemporalTypeException: " + unsupportedTemporalTypeExceptionC.getMessage());
        assertTrue(unsupportedTemporalTypeExceptionC.getMessage().contains("Unsupported unit: Eras"));
        System.out.println("--------------------------------------------------");
        
        System.out.println("--------------------------------------------------");
        System.out.println("Between Test UnsupportedTemporalTypeException FOREVER");
        // HALF_DAYS
        Exception unsupportedTemporalTypeExceptionD = assertThrows(UnsupportedTemporalTypeException.class,
                () -> Periods.between(new Date(), new Date(), ChronoUnit.FOREVER));
        assertNotNull(unsupportedTemporalTypeExceptionD);
        System.out.println("UnsupportedTemporalTypeException: " + unsupportedTemporalTypeExceptionD.getMessage());
        assertTrue(unsupportedTemporalTypeExceptionD.getMessage().contains("Unsupported unit: Forever"));
        System.out.println("--------------------------------------------------");
    }

}
