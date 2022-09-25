package _03_stream_2;

import java.sql.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class App {
    public static void main(String[] args) {
        List<OnlineClass> springClasses = new ArrayList();
        springClasses.add(new OnlineClass(1, "springboot", true));
        springClasses.add(new OnlineClass(2, "spring data jpa", true));
        springClasses.add(new OnlineClass(3, "spring mvc", false));
        springClasses.add(new OnlineClass(4, "spring core", false));
        springClasses.add(new OnlineClass(5, "rest api development", false));

        List<OnlineClass> javaClasses = new ArrayList<>();
        javaClasses.add(new OnlineClass(6, "The java Test", true));
        javaClasses.add(new OnlineClass(7, "The java Code mnipulation", true));
        javaClasses.add(new OnlineClass(8, "The java 8 to 11", false));

         List<List<OnlineClass>> staekEvents = new ArrayList<>();
         staekEvents.add(springClasses);
         staekEvents.add(javaClasses);

         System.out.println("### spring으로 시작하는 수업");
         springClasses.stream().filter(oc -> oc.getTitle().startsWith("spring"))
                         .forEach(oc -> System.out.println(oc.getId() + " " + oc.getTitle()));

         System.out.println("### close 되지 않은 수업");
         springClasses.stream()
                            //.filter(oc -> !oc.isClosed())
                            .filter(Predicate.not(OnlineClass::isClosed))
                            .forEach(oc-> System.out.println(oc.getId()));

         System.out.println("### 수업 이름만 모아서 스트림 만들기");
         springClasses.stream()
                 .map(OnlineClass::getTitle)
                 .forEach(System.out::println);

        System.out.println("### 두 수업 목록에 있는 모든 수업 아이디 출력");
        staekEvents.stream().flatMap(list -> list.stream())
                .forEach(oc -> System.out.println(oc.getId()));

        System.out.println("### 10부터 1씩 증가하는 무제한 스트림 중에서 앞에 10개빼 최대 10개까지만");
        Stream.iterate(10, i -> i + 1)
                .skip(10)
                .limit(10)
                .forEach(System.out::println);


        System.out.println();
        boolean test = javaClasses.stream().anyMatch(oc -> oc.getTitle().contains("Test"));
        System.out.println(test);

        System.out.println("### 스프링 수업중에 제목에 spring이 들어간 것만 모아서 list로 만들기");

        List<String> spring = springClasses.stream().filter(os -> os.getTitle().contains("spring"))
                .map(oc -> oc.getTitle())
                .collect(Collectors.toList());
        spring.forEach(System.out::println);


    }
}
