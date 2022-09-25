package _01_함수형인터페이스와람다_4;

import java.util.Arrays;
import java.util.Comparator;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.function.UnaryOperator;


/*
    메소드 레퍼런스
 */
public class App {
    public static void main(String[] args) {
        Function<Integer, String> intToString = (i) -> "name";

        //UnaryOperator<String> hi =  (s) -> "hi" + s;

        // static method 참조
        // 타입::스테틱매서드
        UnaryOperator<String> hi = Greeting::hi;
        System.out.println(hi.apply("name"));

        // instance method 참조
        // 객체레퍼런스::인스턴스메서드
        Greeting greeting = new Greeting();
        UnaryOperator<String> hello = greeting::hello;
        System.out.println(hello.apply("name2"));

        // 생성자 참조 (default 생성자)
        Supplier<Greeting> newGreeting = Greeting::new;
        System.out.println(newGreeting.get().getName());

        // 생성자 참조 (인자 하나)
        // 타입::new
        Function<String, Greeting> staekGreeting = Greeting::new;
        System.out.println(staekGreeting.apply("staek").getName());

        // 임의 객체의 instance method 참조 (타입::인스턴스메서드)
        String[] names = {"banana", "apple", "kakao"};
//        Arrays.sort(names, new Comparator<String>() {
//            @Override
//            public int compare(String o1, String o2) {
//                return 0;
//            }
//        });
        Arrays.sort(names, String::compareToIgnoreCase);
        System.out.println(Arrays.toString(names));
    }
}
