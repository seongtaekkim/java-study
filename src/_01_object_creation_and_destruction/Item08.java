package createobject;

import java.lang.ref.Cleaner;

public class Item08 {
    public static void main(String[] args) throws Exception {

        try(Room room = new Room(11)) {
            System.out.println("hi");
        }

        new Room(88);
        System.out.println("hihi");
        //System.gc();
    }

}
class Room implements AutoCloseable {
    private static final Cleaner cleaner = Cleaner.create();


    private static class State implements Runnable {
        int numJunkPiles ;
        State(int numJunkPiles) {
            this.numJunkPiles = numJunkPiles;
        }

        @Override
        public void run() {
            System.out.println("cleanning room" );
            numJunkPiles = 0;
        }
    }

    private final State state;

    private final Cleaner.Cleanable cleanable;

    public Room(int numJunkPiles) {
        state = new State(numJunkPiles);
        cleanable = cleaner.register(this, state);
    }
    @Override
    public void close() throws Exception {
        cleanable.clean();
    }
}
