package createobject;

public class Item03 {
    public static void main(String[] args) {

    }

}

/**
 * static factory
 */
class Elvis {
    private static final Elvis INSTANCE = new Elvis();
    private Elvis() {
    }
    public static Elvis getInstance() {
        return INSTANCE;
    }

    // see item89
    private Object readResolve() {
        return INSTANCE;
    }
}
