package generic;

import java.util.Collection;
import java.util.Iterator;
import java.util.Set;

public class Item26 {

    static int numElementsInCommon(Set s1, Set s2) {
        int result= 0;
        for(Object o1 : s1)
            if(s2.contains(o1))
                result++;
        return result;
    }

    static void chkType(Set s1) {
        if(s1 instanceof Set) {
            Set<?> s = (Set<?>)s1;
        }
    }
}
