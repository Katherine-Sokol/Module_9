package Task2_LinkedList;

import java.util.StringJoiner;

public class MyLinkedList<T> {
    private int size;
    Node<T> first;
    Node<T> last;

    void linkLast(T t) {
        Node<T> l = last;
        Node<T> newNode = new Node<>(l, t, null);
        last = newNode;
        if (l == null)
            first = newNode;
        else
            l.next = newNode;
        size++;
    }

    public void add(Object value) {
        linkLast((T) value);
    }

    public T remove(int index) {
        checkElementIndex(index);
        return unlink(node(index));
    }

    T unlink(Node<T> x) {
        if (x == null) {
            throw new NullPointerException();
        }
        final T element = x.item;
        final Node<T> next = x.next;
        final Node<T> prev = x.prev;

        if (prev == null) {
            first = next;
        } else {
            prev.next = next;
            x.prev = null;
        }

        if (next == null) {
            last = prev;
        } else {
            next.prev = prev;
            x.next = null;
        }

        x.item = null;
        size--;
        return element;
    }

    Node<T> node(int index) {
        Node<T> x;
        if (index < (size >> 1)) {
            x = first;
            for (int i = 0; i < index; i++)
                x = x.next;
        } else {
            x = last;
            for (int i = size - 1; i > index; i--)
                x = x.prev;
        }
        return x;
    }

    private void checkElementIndex(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index " + index + " is out of bounds for length " + size);
        }
    }

    public void clear() {
        for (Node<T> x = first; x != null; ) {
            Node<T> next = x.next;
            x.item = null;
            x.next = null;
            x.prev = null;
            x = next;
        }
        first = last = null;
        size = 0;
    }

    public int size() {
        return size;
    }

    public T get(int index) {
        checkElementIndex(index);
        return node(index).item;
    }

    private static class Node<T> {
        T item;
        Node<T> next;
        Node<T> prev;

        Node(Node<T> prev, T element, Node<T> next) {
            this.item = element;
            this.next = next;
            this.prev = prev;
        }
    }

    @Override
    public String toString() {
        StringJoiner result = new StringJoiner(", ");
        for (int i = 0; i < size; i++) {
            result.add(node(i).item.toString());
        }
        return "[" + result + "]";
    }
}
