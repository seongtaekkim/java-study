package _02_인터페이스의변화_2;

import jdk.swing.interop.SwingInterOpUtils;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Spliterator;

/*
Iterable의 기본 메소드 ● forEach()
    ● spliterator()
Collection의 기본 메소드
    ● stream() / parallelStream()
    ● removeIf(Predicate)
    ● spliterator()
Comparator의 기본 메소드 및 스태틱 메소드
    ● reversed()
    ● thenComparing()
    ● static reverseOrder() / naturalOrder()
    ● static nullsFirst() / nullsLast()
    ● static comparing()
인터페이스 변화에 따른 설계변화
기존
    interface <-- abstract class <--- class
    : interface 메서드를 class에서 모두 구현할 필요가 없도록 추상클래스에 추상메서드를 정의해 편의성을 높힌다.
변경
    intercase <-- class
    : default class를 interface에 구현하면, 추상클래스는 필요 없다.
 */
public class App {
    public static void main(String[] args) {
        List<String> name = new ArrayList<String>();
        name.add("apple");
        name.add("banana");
        name.add("watermalon");
        name.add("orange");

        name.forEach(System.out::println);
        for (String n : name) {
            System.out.println(n);
        }
        System.out.println("================");
        Spliterator<String> spliterator = name.spliterator();
        Spliterator<String> spliterator2 = spliterator.trySplit();

        while (spliterator.tryAdvance(System.out::println));
        System.out.println("==========================");
        while (spliterator2.tryAdvance(System.out::println));

        System.out.println("removeif =============");
        name.removeIf(s -> s.startsWith("a"));
        name.forEach(System.out::println);

        System.out.println("sort =============");
        Comparator<String> compareToIgnorecase = String::compareToIgnoreCase;;
        name.sort(compareToIgnorecase.reversed().thenComparing(compareToIgnorecase.reversed()));
        name.forEach(System.out::println);
    }
}
