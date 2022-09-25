package _06_Date와Time_2;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.TimeZone;

public class App {
    public static void main(String[] args) throws InterruptedException  {
        // 기계용 api
        Instant instant = Instant.now();
        System.out.println(instant); // 기준시 UTC, GMT
        System.out.println(instant.atZone(ZoneId.of("UTC"))); // 기준시 UTC, GMT

        ZoneId zoneId = ZoneId.systemDefault();
        System.out.println(zoneId);
        ZonedDateTime zonedDateTime = instant.atZone(zoneId);
        System.out.println(zonedDateTime);

        // 현재 내 local zone을 참조해서 출력.
        LocalDateTime now = LocalDateTime.now();
        System.out.println(now);
        LocalDateTime.of(1990, Month.OCTOBER, 23, 03,0, 0);
        ZonedDateTime now1 = ZonedDateTime.now(ZoneId.of("Asia/Seoul"));
        System.out.println(now1);
        // zonedDatetime <-> instant 는 서로 변경이 가능하다.
        Instant now2 = Instant.now();
        ZonedDateTime zonedDateTime1 = now2.atZone(ZoneId.of("Asia/Seoul"));
        System.out.println(zonedDateTime1);

        LocalDate today = LocalDate.now();
        LocalDate whenbirth = LocalDate.of(2024, Month.OCTOBER, 30);
        Period between = Period.between(today, whenbirth);
        System.out.println(between.getDays());
        // 사람용 시간 비교
        Period until = today.until(whenbirth);
        System.out.println(until.get(ChronoUnit.DAYS));

        // 기계용 시간비교
        Instant now3 = Instant.now();
        Instant plus = now3.plus(10, ChronoUnit.SECONDS);
        Duration between1 = Duration.between(now3, plus);
        System.out.println(between1.getSeconds());

        // formatting
        LocalDateTime now4 = LocalDateTime.now();
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("MM/dd/yyyy");
        System.out.println(now4.format(dateTimeFormatter));

        // 파싱
        LocalDate parse = LocalDate.parse("07/15/1990", dateTimeFormatter);
        System.out.println(parse);


        Date date = new Date();
        Instant instant1 = date.toInstant();
        Date from = Date.from(instant1);

        GregorianCalendar g = new GregorianCalendar();
        ZonedDateTime zonedDateTime2 = g.toInstant().atZone(ZoneId.systemDefault());
        GregorianCalendar from1 = GregorianCalendar.from(zonedDateTime2);

        ZoneId zoneId2 = TimeZone.getTimeZone("PST").toZoneId();
        TimeZone timeZone = TimeZone.getTimeZone(zoneId2);


    }
}
