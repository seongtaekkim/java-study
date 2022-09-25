package createobject;

import java.util.regex.Pattern;

/**
 * avoid unnecessary object creation
 */
public class Item06 {
    public static void main(String[] args) {


        /**
         * excercise 1
         * sumByLong() is create Long instance by auto boxing
         */
        long beforeTime = System.currentTimeMillis();
        System.out.println(sumByLong());;
        //System.out.println(sumBylong());;
        long afterTime = System.currentTimeMillis();
        long secDiffTime = (afterTime - beforeTime)/1000;
        System.out.println("second diff : "+secDiffTime);

    }
    private static long sumByLong() {
        Long sum = 0L;
        int a = 0;
        for(long i = 1; i<=Integer.MAX_VALUE ; i++) {
            sum += i;
        }

        return sum;
    }

    private static long sumBylong() {
        long sum = 0L;
        for(long i = 0; i<=Integer.MAX_VALUE ; i++) {
            sum += i;
        }
        return sum;
    }

}

/**
 * exercise 2
 * case1) isRomanNumeral's Pattern instance is created every time it is called
 * case2) ROMAN is created only one
 *        and it is recycled
 */
class RomanNumerals {
    static boolean isRomanNumeral(String s) {
        return s.matches("^(?=.)M*(C[MD]|D?C{0,3})"
                + "(X[CL]|L?X{0,3})(I[XV]|V?I{0,3})$");
    }


    private static final Pattern ROMAN = Pattern.compile("^(?=.)M*(C[MD]|D?C{0,3})"
            + "(X[CL]|L?X{0,3})(I[XV]|V?I{0,3})$");

    static boolean isRomanNumeral2(String s) {
        return ROMAN.matcher(s).matches();
    }

}


