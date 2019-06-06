package com.company;

import java.time.*;
import java.time.temporal.ChronoField;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalField;
import java.util.Date;

public class Main {

    public static void main(String[] args) {

        //Date now = new Date();
        //Calendar

        //year, month, day, hour, minute, second, millisecond, timezone
        //saveToDatabase(d);
        //14.06
        //00:00:00 - 1 second

        //13.06
        //23:59:59 (NY time - 16:59:59) +05:30

        //Problems
        //1. Incompatibility with SQL
        //2. Complicated calculations (plus 1 day, minus 1 week)
        //3. Timezone

        //Solution
        //library: joda-time

        //java solution (from 2013-14, Java 8)
        //Java Date API

        //LocalDate
        //LocalTime

        //*DateTime : LocalDateTime vs ZonedDateTime

        LocalDate year = LocalDate.now();

        for (int i = 0; i < 30; i++) {

            if (year.isLeapYear()) {
                System.out.println(year.getYear());
            } else {
                System.out.println("  " + year.getYear());
            }
            year = year.minusYears(1);
        }

//        year.get(ChronoField.DAY_OF_MONTH)

        LocalDate yearStart = LocalDate.now()
                .withMonth(1)
                .withDayOfMonth(1);
        System.out.println(yearStart);
        LocalDate now = LocalDate.now();

        long days = ChronoUnit.DAYS.between(yearStart, now);


        System.out.println("Days passed since the start of the year");
        System.out.println(days);

        System.out.println("Previous elections:");
        LocalDate prev = LocalDate.of(2019, Month.APRIL, 9);
        System.out.println(prev);

        System.out.println();
        System.out.println("Next elections:");
        LocalDate next = LocalDate.of(2019, Month.SEPTEMBER, 17);
        System.out.println(next);

        System.out.println("Hours between elections: " + ChronoUnit.HOURS.between(
                LocalDateTime.of(prev, LocalTime.MIDNIGHT),
                LocalDateTime.of(next, LocalTime.MIDNIGHT))
        );

    }
}
