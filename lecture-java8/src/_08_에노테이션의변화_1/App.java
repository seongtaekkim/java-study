package _08_에노테이션의변화_1;

import java.util.Arrays;
import java.util.List;

@Beer
public class App {
    public static void main(@Beer  String[] args) throws @Beer RuntimeException {
        List<@Beer  String> names = Arrays.asList("stack");

    }

    // Typeparamer -> @Chicken 가능
    static class FeelsLikeChicken<@Beer T> {
        // <C> : type parameter
        // C : type
        //static public <C> void print(C c) {
        static public <@Beer  C> void print(@Beer  C c) {

        }
    }
}
