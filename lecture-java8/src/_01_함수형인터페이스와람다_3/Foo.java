package _01_함수형인터페이스와람다_3;

import _01_함수형인터페이스와람다_2.Plus10;

import java.util.function.*;

public class Foo {
    public static void main(String[] args) {
        BinaryOperator<Integer> sum =  (a, b) -> a + b;
        System.out.println(sum.apply(5,10));

        Foo foo = new Foo();
        foo.run();
    }


    /*
    변수 캡처 (Variable Capture)
    ● 로컬변수캡처
        ○ final이거나 effective final 인 경우에만 참조할 수 있다.
        ○ 그렇지 않을 경우 concurrency 문제가 생길 수 있어서 컴파일가 방지한다.
    ● effective final
        ○ 이것도 역시 자바 8부터 지원하는 기능으로 “사실상" final인 변수.
        ○ final 키워드 사용하지 않은 변수를 익명 클래스 구현체 또는 람다에서 참조할 수 있다.
    ● 익명 클래스 구현체와 달리 ‘쉐도윙’하지 않는다.
        ○ 익명 클래스, 로컬 클래스는 새로 스콥을 만들지만, 람다는 람다를 감싸고 있는 스콥과 같다.
          즉, 람다내부에서는 같은 이름의 변수를 생성할 수 없다는 의미.
     */
    private void run() {
        //final int baseNumber = 10; // 자바8부터 effective final 변수 허용
        int baseNumber = 10;
        //baseNumber++; // effective final 이어야 하므로, 컴파일에러가 발생함.
        // 로컬클래스
        class LocalClass {
           int baseNumber = 100;
            void run() {
                System.out.println(baseNumber);
            }
        }
        LocalClass l = new LocalClass();
        l.run();

        // 익명클래스
        Consumer<Integer> integerConsumer = new Consumer<Integer>() {
            @Override
            public void accept(Integer baseNumber) {
                System.out.println(baseNumber);
            }
        };
        integerConsumer.accept(5);

        // 람다
        IntConsumer printInt = (i) -> {
            System.out.println(i + baseNumber);
        };

        printInt.accept(5);
    }
}
