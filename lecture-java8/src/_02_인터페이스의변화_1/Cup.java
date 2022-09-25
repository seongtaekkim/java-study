package _02_인터페이스의변화_1;

public interface Cup {

    default void printNameUpperCase() {
        System.out.println("cup");
    }
}
