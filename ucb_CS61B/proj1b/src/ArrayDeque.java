import java.util.ArrayList;
import java.util.List;

public class ArrayDeque<T> implements Deque<T> {
    private T[] items;
    private int size;
    private int nextFirst;;
    private int nextLast;


    public ArrayDeque(){
        items = (T[]) new Object[8];
        size = 8;
        nextFirst = 4;
        nextLast = 5;
    }
    public static void main(String[] args) {
        Deque<Integer> ad = new ArrayDeque<>();
    }

    /** Creates a resized Deque and copy the items into it. */
    private void resize(int capacity) {
        T[] newItems = (T[]) new Object[capacity];
        int startIndex = (nextFirst + 1) % items.length;  // the index of the first item in the previous Deque

        for (int i = 0; i < size; i++) {
            newItems[i] = items[startIndex];
            startIndex = (startIndex + 1) % items.length;
        }
        items = newItems;
        nextFirst = capacity - 1;
        nextLast = size;
    }

    /** Adds an item to the next position of nextFirst. */
    @Override
    public void addFirst(T x) {

        // Deque is full and needs resizing.
        if (size == items.length) {
            resize(size * 2);
        }
        items[nextFirst + 1] = x;
        nextFirst = (nextFirst - 1 + items.length) % items.length;
        size++;
    }

    /** Adds an item to the last position of nextLast. */
    @Override
    public void addLast(T x) {
        if (size == items.length) {
            resize(size * 2);
        }
        items[nextLast - 1] = x;
        nextLast = (nextLast + 1) % items.length;
        size++;
    }

    /** Converts Deque into a Java array List, which is easier for test. */
    @Override
    public List<T> toList() {
        List<T> returnList = new ArrayList<>();
        // traverse through the Deque and add it into returnList
        for (int i = nextFirst + 1; i < nextFirst + size; i++) {
            T tmp = items[i];
            returnList.add(tmp);
        }

        return returnList;
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public T removeFirst() {
        return null;
    }

    @Override
    public T removeLast() {
        return null;
    }

    @Override
    public T get(int index) {
        /** Gets the item with index of Deque. */

        // Throw an error if the index is out-of-range w.r.t. Deque.
        if (index >= size) {
            throw new IndexOutOfBoundsException("Index " + index + " is out of bounds!");
        }
        int arrIndex = (nextFirst + 1 + index) % items.length;
        // As a circular arrayDeque is implemented, we should find the corresponding index of array with that of Deque.
        return items[arrIndex];
    }
}
