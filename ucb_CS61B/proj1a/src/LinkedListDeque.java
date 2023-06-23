import java.util.ArrayList;
import java.util.List;

public class LinkedListDeque<T> implements Deque<T> {
    private class NewNode {
       public T item;
       public NewNode prev;
       public NewNode next;

       public NewNode(T i, NewNode p, NewNode n) {
           item = i;
           prev = p;
           next = n;
       }
    }

    private NewNode sentinel;
    private int size;
    public LinkedListDeque() {
        sentinel = new NewNode(null, null , null);
        sentinel.next = sentinel;
        sentinel.prev = sentinel;
        size = 0;
    }
    public static void main(String[] args) {
        Deque<Integer> lld = new LinkedListDeque<>();
    }

    @Override
    public void addFirst(T x) {
        size += 1;
        NewNode newNode = new NewNode(x, sentinel, sentinel.next);
        sentinel.next.prev = newNode;
        sentinel.next = newNode;
    }

    @Override
    public void addLast(T x) {
        size += 1;
        NewNode newNode = new NewNode(x, sentinel.prev, sentinel);
        sentinel.prev.next = newNode;
        sentinel.prev = newNode;
    }

    @Override
    public List<T> toList() {
        List<T> returnList = new ArrayList<>();
        NewNode crt = sentinel.next;
        while (crt != sentinel) {
            returnList.add(crt.item);
            crt = crt.next;
        }
        return returnList;
    }

    @Override
    public boolean isEmpty() {
        return sentinel.next == sentinel;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public T removeFirst() {
        T tmp = sentinel.next.item;

        sentinel.next = sentinel.next.next;
        sentinel.next.prev = sentinel.next.prev.prev;

        return tmp;
    }

    @Override
    public T removeLast() {
        T tmp = sentinel.prev.item;

        sentinel.prev = sentinel.prev.prev;
        sentinel.prev.next = sentinel.prev.next.next;

        return tmp;
    }

    @Override
    public T get(int index) {
        if (index < 0 || index >= size) {
            return null;
        }

        NewNode crt = sentinel.next;
        for (int i = 0; i < index; i++) {
            crt = crt.next;
        }
        return crt.item;
    }

    @Override
    public T getRecursive(int index) {
        if (index < 0 || index >= size) {
            return null;
        }
        return getRecursiveHelper(sentinel.next, index);
    }

    private T getRecursiveHelper(NewNode crtNode, int index) {
        if (index == 0) {
            return crtNode.item;
        } else {
            return getRecursiveHelper(crtNode.next, index - 1);
        }
    }
}
