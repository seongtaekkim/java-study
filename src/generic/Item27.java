package generic;

import java.util.Arrays;

public class Item27 {
    public static void main(String[] args) {

    }
    public <T> T[] toArray(T[] a) {
        Integer[] elements = new Integer[4];
        int size = elements.length;
        if(a.length < size) {
            @SuppressWarnings("unchecked") T[] result =  (T[]) Arrays.copyOf(elements, size, a.getClass());
            return result;
        }
        System.arraycopy(elements,0,a,0,size);
        if(a.length > size)
            a[size] = null;
        return a;
    }
}
