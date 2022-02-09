package createobject;

public class Item04 {
    public static void main(String[] args) {

    }
}

/**
 * use private constructor to prevent to instantiation
 */
class UtilityClass {
    private UtilityClass() {
        throw new AssertionError();
    }
}
