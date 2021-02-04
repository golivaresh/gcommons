package com.goh.gcommons.date.test;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.temporal.ChronoUnit;
import java.util.Date;

import org.junit.jupiter.api.Test;

import com.goh.gcommons.date.Periods;

class PeriodsTest {

    @Test
    void test() {
        Date startDate = new Date();

        LocalDateTime today = LocalDateTime.now();
        today = today.plusYears(1);
        Date endDate = Date.from(today.atZone(ZoneId.systemDefault()).toInstant());

        System.out.println(startDate);
        System.out.println(endDate);

        ChronoUnit[] types = { ChronoUnit.NANOS, ChronoUnit.MILLIS, ChronoUnit.SECONDS, ChronoUnit.MINUTES,
                ChronoUnit.HOURS, ChronoUnit.DAYS, ChronoUnit.WEEKS, ChronoUnit.MONTHS, ChronoUnit.YEARS,
                ChronoUnit.DECADES, ChronoUnit.CENTURIES, ChronoUnit.MILLENNIA };
        long time = 0;

        for (ChronoUnit type : types) {
            time = Periods.between(startDate, endDate, type);
            System.out.println(startDate + " and " + startDate + " is " + time + " " + type.name());
        }
    }

}
