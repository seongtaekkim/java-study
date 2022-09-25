package generic;

import java.util.Arrays;
import java.util.EmptyStackException;
import java.util.Locale;

public class Item29 {

    public static void main(String[] args) {
        GenericStack<String> stack = new GenericStack<>();

        stack.push("a");
        stack.push("b");
        stack.push("c");
        stack.push("d");
        stack.push("e");
        stack.push("f");
        stack.push("g");
        while(!stack.isEmpty())
            System.out.println(stack.pop().toUpperCase());
    }
}
class Stack {
    private Object[] elements;
    private int size;
    private static final int DEFAULT_INITIAL_CAPACITY = 16;

    public Stack() {
        elements = new Object[DEFAULT_INITIAL_CAPACITY];
    }
    
    public void push(Object e) {
        ensureCapacity();
        elements[size++] = e;
    }

    public Object pop() {
        if(size == 0) {
            throw new EmptyStackException();
        }
        Object result = elements[--size];
        elements[size] = null; // reference release
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

/**
 * Stack class => generic Stack class
 * problem : array cannot be created because it is a non-reify type.
 * solution1 : see below
 * solution2 : see below
 * @param <E>
 */
class GenericStack<E> {
    private Object[] elements;
    private int size;
    private static final int DEFAULT_INITIAL_CAPACITY = 16;

    @SuppressWarnings("unchecked")
    public GenericStack() {
        //An array cannot be created because it is a non-reify type.
        //elements = new E[DEFAULT_INITIAL_CAPACITY];

        /**
         * solution 1
         * Object[] to E[]
         * new Object --> E[] element
         */
        //elements = (E[]) new Object[DEFAULT_INITIAL_CAPACITY]; // Unchecked cast : 'java.lang.Object[] to E[]'


        elements = new Object[DEFAULT_INITIAL_CAPACITY]; // Unchecked cast : 'java.lang.Object[] to E[]'
    }

    public void push(E e) {
        ensureCapacity();
        elements[size++] = e;
    }

    public E pop() {
        if(size == 0) {
            throw new EmptyStackException();
        }

        /**
         * solution 2
         *
         * Object element --> E
         */
        @SuppressWarnings("unchecked")  E result = (E) elements[--size];
        elements[size] = null; // reference release
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
