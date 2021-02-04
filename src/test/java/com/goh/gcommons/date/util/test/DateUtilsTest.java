/**
 * 
 */
package com.goh.gcommons.date.util.test;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.text.ParseException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Date;
import org.junit.jupiter.api.Test;
import com.goh.gcommons.date.util.DateUtils;

/**
 * 
 * @author golivaresh
 *
 */
class DateUtilsTest {

    @Test
    void toDateTest() throws ParseException {
        System.out.println("--------------------------------------------------");
        System.out.println("To Date Test");
        System.out.println("--------------------------------------------------");
        // LocalDate OK
        LocalDate localDate = LocalDate.now();
        Date dateLd = DateUtils.convertToDate(localDate);
        assertNotNull(dateLd);
        // LocalDate null
        LocalDate localDateNull = null;
        Date dateLdNull = DateUtils.convertToDate(localDateNull);
        assertNull(dateLdNull);
        System.out.println("localDate: " + localDate);
        System.out.println("dateLd: " + dateLd);
        System.out.println("--------------------------------------------------");

        // LocalDateTime OK
        LocalDateTime localDateTime = LocalDateTime.now();
        Date dateDt = DateUtils.convertToDate(localDateTime);
        assertNotNull(dateDt);
        // LocalDateTime null
        LocalDateTime localDateTimeNull = null;
        Date dateDtNull = DateUtils.convertToDate(localDateTimeNull);
        assertNull(dateDtNull);
        System.out.println("localDateTime: " + localDateTime);
        System.out.println("dateDt: " + dateDt);
        System.out.println("--------------------------------------------------");

        // LocalTime OK
        LocalTime localTime = LocalTime.now();
        Date dateT = DateUtils.convertToDate(localTime, new Date());
        assertNotNull(dateT);
        // LocalTime null 1
        LocalTime localTimeNull = null;
        Date dateTNull = DateUtils.convertToDate(localTimeNull, new Date());
        assertNull(dateTNull);
        // LocalTime null 2
        LocalTime localTimeNull2 = LocalTime.now();
        Date dateTNull2 = DateUtils.convertToDate(localTimeNull2, null);
        assertNotNull(dateTNull2);
        // LocalTime null 3
        LocalTime localTimeNull3 = null;
        Date dateTNull3 = DateUtils.convertToDate(localTimeNull3, null);
        assertNull(dateTNull3);
        System.out.println("localTime: " + localTime);
        System.out.println("dateT: " + dateT);
        System.out.println("--------------------------------------------------");

        // Date OK
        Date dateStr = DateUtils.convertToDate("25/03/2021", "dd/MM/yyyy");
        assertNotNull(dateStr);
        assertNotNull(dateStr);
        System.out.println("date: 25/03/2021");
        System.out.println("dateStr: " + dateStr);
        // Date parseException
        String assertMsg = "Unparseable date: \"/30/0021\"";
        Exception parseException = assertThrows(ParseException.class, () -> {
            DateUtils.convertToDate("/30/0021", "dd/MM/yyyy");
        });
        assertNotNull(parseException);
        assertTrue(assertMsg.contains(parseException.getMessage()));
        System.out.println("ParseException Msg:" + parseException.getMessage());
        System.out.println("--------------------------------------------------");
        // Date Assertion Error.
    }

    @Test
    void toLocalDateTest() throws ParseException {
        System.out.println("--------------------------------------------------");
        System.out.println("To LocalDate Test");
        System.out.println("--------------------------------------------------");
        // ToLocalDate OK
        Date date = DateUtils.convertToDate("07/03/2020", "dd/MM/yyyy");
        LocalDate localDate = DateUtils.convertLocalDate(date);
        assertNotNull(localDate);
        // ToLocalDate null
        LocalDate localDateNull = DateUtils.convertLocalDate(null);
        assertNull(localDateNull);
        System.out.println("date: " + date);
        System.out.println("localDate: " + localDate);
        System.out.println("--------------------------------------------------");
    }

    @Test
    void toLocalDateTimeTest() throws ParseException {
        System.out.println("--------------------------------------------------");
        System.out.println("To LocalDateTime Test");
        System.out.println("--------------------------------------------------");
        // ToLocalDateTime OK
        Date date = DateUtils.convertToDate("07/03/2020 03:25:54", "dd/MM/yyyy h:m:s");
        LocalDateTime localDateTime = DateUtils.convertLocalDateTime(date);
        assertNotNull(localDateTime);
        // ToLocalDateTime null
        LocalDateTime localDateTimeNull = DateUtils.convertLocalDateTime(null);
        assertNull(localDateTimeNull);
        System.out.println("date: " + date);
        System.out.println("localDateTime: " + localDateTime);
        System.out.println("--------------------------------------------------");
    }

    @Test
    void toLocalTimeTest() throws ParseException {
        System.out.println("--------------------------------------------------");
        System.out.println("To LocalTime Test");
        System.out.println("--------------------------------------------------");
        // ToLocalTime OK
        Date date = DateUtils.convertToDate("07/03/2020 08:25:55", "dd/MM/yyyy h:m:s");
        LocalTime localDateTime = DateUtils.convertLocalTime(date);
        assertNotNull(localDateTime);
        // ToLocalTime null
        LocalTime localDateTimeNull = DateUtils.convertLocalTime(null);
        assertNull(localDateTimeNull);
        System.out.println("date: " + date);
        System.out.println("localDateTime: " + localDateTime);
        System.out.println("--------------------------------------------------");
    }
}
