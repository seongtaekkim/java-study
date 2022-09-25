package _02_인터페이스의변화_1;


/**
 * 다이아몬드 상속(인터페이스가 같은 이름의 메소드를 정의)의 경우,
 * default method 이더라도 재정의 해야 한다.
 */
// public class DefaultFoo implements Foo, Bar{
public class DefaultFoo implements Foo {

    private String name;

    DefaultFoo(String name) {
        this.name = name;
    }

    @Override
    public void printName() {
        System.out.println(this.name);
    }

    @Override
    public String getName() {
        return this.name;
    }

    /**
     *  interface의 default method를 사용하지 않고 override 할 수 있다.
     */
//    @Override
//    public void printNameUpperCase() {
//        Foo.super.printNameUpperCase();
//    }
}
