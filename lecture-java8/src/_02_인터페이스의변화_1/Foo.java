package _02_인터페이스의변화_1;

public interface Foo {

    void printName();

    String getName();

    /**
     * @implSpec default 메소드에 대한 상세내용을 기술해야 한다.
     */
    default void printNameUpperCase() {
        System.out.println(this.getName().toUpperCase());
    }

    /**
     * Obejct class의 method는 default method로 정의 할 수없다.
     * Default method 'toString' overrides a member of 'java.lang.Object
     * @return
     */
//    default String toString() {
//
//    }

    /**
     * static method 를 정의해서 class method로 사용할 수 있다.
     */
    static void printAnyThing() {
        System.out.println("static method");
    }
}
