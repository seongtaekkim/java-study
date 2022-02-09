package generic;

import java.sql.SQLOutput;
import java.util.Collection;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;
import java.util.function.UnaryOperator;

public class Item30 {

    private static UnaryOperator<Object> IDENTITY_FN = (t) -> t;

    @SuppressWarnings("unchecked")
    public static <T> UnaryOperator<T> identityFunction() {
        return (UnaryOperator<T>) IDENTITY_FN;
    }

    public static void main(String[] args) {
        Set<String> guys = Set.of("data1","data2","data3");
        Set<String> stooges = Set.of("data4","data5","data6");
        Set<String> aflCio = union2(guys, stooges);
        System.out.println(aflCio);


        String[] strings = {"test1", "test2", "test3"};
        UnaryOperator<String> sameString = identityFunction();
        for(String s : strings)
            System.out.println(sameString.apply(s));

        Number[] numbers = {1, 2.0, 3L};
        UnaryOperator<Number> sameNumber = identityFunction();
        for(Number n : numbers)
            System.out.println(sameNumber.apply(n));

    }

    public static Set union(Set s1, Set s2)  {
        Set result = new HashSet(s1);
        result.addAll(s2);
        return result;
    }

    public static <E> Set<E> union2(Set<E> s1, Set<E> s2) {
        Set<E> result = new HashSet<>(s1);
        result.addAll(s2);
        return result;
    }

    public static <E extends Comparable<E>> E max(Collection<E> c) {
        if(c.isEmpty())
            throw new IllegalArgumentException("collectoin is empty");
        E result = null;
        for(E e : c)
            if(result == null || e.compareTo(result) >0)
                result = Objects.requireNonNull(e);
        return result;
    }


}
