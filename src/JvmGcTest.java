import java.util.Arrays;
import java.util.EmptyStackException;

/**
 * JVM - memory leak test
 */
public class JvmGcTest {
    public static void main( String[] args ) {
        GenericStack<Object0> st = new GenericStack();
        while(true) {
            st.push(new Object0());
            st.pop();
        }
    }
}

class Object0 {
    private Integer data[][][][] = null;
    Object0() {
        data = new Integer[100][100][100][100];
    }
}

class GenericStack<E> {
    private Object[] elements;
    private int size;
    private static final int DEFAULT_INITIAL_CAPACITY = 16;

    @SuppressWarnings("unchecked")
    public GenericStack() {
        elements = new Object[DEFAULT_INITIAL_CAPACITY];
    }

    public void push(E e) {
        ensureCapacity();
        elements[size++] = e;
    }

    public E pop() {
        if(size == 0) {
            throw new EmptyStackException();
        }

        @SuppressWarnings("unchecked")  E result = (E) elements[--size];
        // elements[size] = null; // reference release
        return result;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    private void ensureCapacity() {
        if(elements.length == size)
            elements = Arrays.copyOf(elements, 2*size+1);
    }
}