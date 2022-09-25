package generic;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class Item28 {

    public static void main(String[] args) {

        /**
         * Array type
         * runtime error
         */
        Object[] objectArray = new Long[1];
        objectArray[0] = "cannot be inserted because the type is different";

        /**
         * Generic type
         * compile error
         */
        //List<Object> ol = new ArrayList<Long>();
        //ol.add("cannot be inserted because the type is different");


        // Arrays are reify

    }
}

class Chooser {
    private final Object[] choiceArray;

    public Chooser(Collection choices) {
        choiceArray = choices.toArray();
    }
    public Object choose() {
        Random rnd = ThreadLocalRandom.current();
        return choiceArray[rnd.nextInt(choiceArray.length)];
    }
}

class Chooser2<T> {
    private final T[] choiseArray;
    public Chooser2(Collection<T> choise) {
        /**
         * compile error
         */
        //choiseArray = choise.toArray();

        /**
         * casting from Obejct to T array
         * Uncheced cast: 'java.lang.Object[] to T[]'
         * -> A warning is issued because stability is not guaranteed
         */
        choiseArray = (T[])choise.toArray();
    }
}

class Chooser3<T> {
    private final List<T> choiseList;
    public Chooser3(Collection<T> choises) {
        /**
         * use lists instead of array to get rid of the warning
         */
        choiseList = new ArrayList<>(choises);

    }
    public Object choose() {
        Random rnd = ThreadLocalRandom.current();
        return choiseList.get(rnd.nextInt(choiseList.size()));
    }
}
