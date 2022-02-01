package createobject;

import java.util.List;


public class Item05 {
    public static void main(String[] args) {

    }
}

/**
 * static utility
 * - inflexible and difficult to test
 * - only one dictionary object can used
 */
class SpellChecker {
    private static final Lexicon dictionary = new Lexicon();

    private SpellChecker() {

    }
    public static boolean isValid(String word) {
        return false;
    }
    public static List<String> suggestions(String typo) {
        return null;
    }
}

/**
 * singleton
 * - inflexible and difficult to test
 * - only one dictionary object can used
 */
class SpellChecker2 {
    private static final Lexicon dictionary = new Lexicon();

    private SpellChecker2() {

    }
    public static SpellChecker2 INSTANCE = new SpellChecker2();

    public static boolean isValid(String word) {
        return false;
    }
    public static List<String> suggestions(String typo) {
        return null;
    }
}

/**
 * dependent object injection pattern
 * - flexible and easy to test
 */
class SpellChecker3 {
    private final Lexicon dictionary;

    public SpellChecker3(Lexicon dictionary) {
        this.dictionary = dictionary;
    }
    public static boolean isValid(String word) {
        return false;
    }
    public static List<String> suggestions(String typo) {
        return null;
    }
}

class Lexicon {

    private String lang = "KR";

}