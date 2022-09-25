package _01_함수형인터페이스와람다_2;

import _01_함수형인터페이스와람다_1.RunSomething2;

import java.util.function.*;

public class Foo {
    public static void main(String[] args) {
        Plus10 plus10 = new Plus10();
        System.out.println(plus10.apply(1));


//        Function<Integer, Integer> plus10_2 = (i) -> {
//            return i + 10;
//        };
        Function<Integer, Integer> plus10_2 = (i) -> 10 + i;
        Function<Integer, Integer> multiply2 = (i) -> i * 2;
        System.out.println(plus10_2.apply(2));

        // 뒤에 있는 함수를 적용 후, 앞에 있는 함수를 적용.
        System.out.println(plus10_2.compose(multiply2).apply(2));
        Function<Integer, Integer> multiply2AndPlus10 = plus10_2.compose(multiply2);
        System.out.println(multiply2AndPlus10.apply(3));

        // 앞에 있는 함수 적용 후, 뒤에 있는 함수 적용
        System.out.println(plus10_2.andThen(multiply2).apply(3));

        // bifunction : 입력 두
        Consumer<Integer> printT = (i) -> System.out.println(i);
        printT.accept(10);

        // 받아올 값의 타입을 정의
        Supplier<String> get10 = () -> "a";
        System.out.println("supplier : " + get10.get());

        // 입력 안에 값을 판단
        Predicate<String> startWithStaek = (s) -> s.startsWith("staek");
        Predicate<Integer> isOdd = (i) -> i % 2 == 1;
        // 조합이 가능함
        //startWithStaek.and()

        // input, output 타입이 같은 경우 사
        UnaryOperator<Integer> plus10_3 = (i) -> 10 + i;
        System.out.println(plus10_3.apply(3));

        // input 2개, output 1개 가 모두 같은 타입일 경우 사용.
        //BinaryOperator<Integer>
    }
}
