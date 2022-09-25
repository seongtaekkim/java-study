package _02_인터페이스의변화_1;

public interface Bar extends Foo {

    /**
     * Foo 에서 정의한 default method를 적용하고 싶지 않으면
     * 해당 method를 재정의 해주면 된다.
     */
    void printNameUpperCase();
}
