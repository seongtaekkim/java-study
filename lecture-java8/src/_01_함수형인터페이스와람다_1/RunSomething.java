package _01_함수형인터페이스와람다_1;

@FunctionalInterface
public interface RunSomething {
    void doIt();
    //void doIt2();
    static void printName() {
        System.out.println("staek");
    }
    default void printAge() {
        System.out.println(33);
    }

}
