package _03_stream_1;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class App {
    public static void main(String[] args) {
        List<String> names = new ArrayList<>();
        names.add("apple");
        names.add("water");
        names.add("banana");

        Stream<String> stringStream = names.stream().map(String::toUpperCase);

        names.stream().map((s) ->{
            System.out.println(s);
            return s.toUpperCase();
        });

        List<String> collect = names.stream().map((s) -> {
            System.out.println(s);
            return s.toUpperCase();
        }).collect(Collectors.toList());
        collect.forEach(System.out::println);
        System.out.println("====================");
        //names.forEach(System.out::println);


        for (String name : names) {
            System.out.println(name.toUpperCase());
        }
        System.out.println("====================");

        List<String> collect1 = names.parallelStream().map(String::toUpperCase)
                .collect(Collectors.toList());
        collect1.forEach(System.out::println);

        System.out.println("====================");

        // 병렬처리는
        // 속도가 더 느려질 수 있다.
        // 데이터 속성, 개수 등에 따라 달라짐.
        List<String> collect2 = names.parallelStream().map((s) -> {
                    System.out.println(s + " " + Thread.currentThread());
                    return (s.toUpperCase());
                })
                .collect(Collectors.toList());
    }
}
