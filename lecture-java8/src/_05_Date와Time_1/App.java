package _05_Date와Time_1;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class App {
    public static void main(String[] args) throws InterruptedException  {
        Date date = new Date();
        /**
         * 클래스 , 함수이름이 이상하다..
         */
        long time = date.getTime();
        System.out.println(date);
        System.out.println(time);

        Thread.sleep(3000);
        Date after3Seconds = new Date();
        /**
         * mutable (변경가능) 하다.
         * -> 멀티스레드 환경에서 안전하지 않다.
         */
        after3Seconds.setTime(time);
        System.out.println(after3Seconds.getTime());

        /**
            type safe 하지 않다.
            ->month는 0부터 시작하는데, int로 어떤값이든 입력가능하기 때문.
         */
        Calendar birthday = new GregorianCalendar(1990, Calendar.NOVEMBER,23 );


        /**
         *  joda time
         */
    }
}
