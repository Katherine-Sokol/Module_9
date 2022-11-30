package Task4_Stack;

import java.util.Objects;
import java.util.StringJoiner;

public class MyStack<T> {

    private static final int INIT_SIZE = 8;
    private Object[] data;
    private int size;

    public MyStack() {
        data = new Object[INIT_SIZE];
    }

    public void push(Object value) {
        if (value == null) {
            throw new NullPointerException();
        }
        resizeIfNeed();
        data[size] = value;
        size++;
    }

    private void resizeIfNeed() {
        if (size == data.length) {
            int newSize = data.length * 2;
            Object[] newData = new Object[newSize];
            System.arraycopy(data, 0, newData, 0, data.length);
            data = newData;
        }
    }

    public T remove(int index) {
        Objects.checkIndex(index, size);
        Object[] objects = data;
        T oldValue = (T) objects[index];
        fastRemove(objects, index);
        return oldValue;
    }

    private void fastRemove(Object[] objects, int i) {
        int newSize;
        if ((newSize = size - 1) > i)
            System.arraycopy(objects, i + 1, objects, i, newSize - i);
        objects[size = newSize] = null;
    }

    public void clear() {
        Object[] objects = data;
        for (int i = 0; i < size; i++) {
            objects[i] = null;
        }
        size = 0;
    }

    public int size() {
        return size;
    }

    public T peek() {
        int last = size();
        if (last == 0) {
            throw new IndexOutOfBoundsException("MyStack is empty");
        }
        return (T) data[last - 1];
    }

    public T pop() {
        T element;
        element = peek();
        Object[] objects = data;
        objects[size = size - 1] = null;
        return element;
    }

    @Override
    public String toString() {
        StringJoiner result = new StringJoiner(", ");
        for (int i = 0; i < size; i++) {
            result.add(data[i].toString());
        }
        return "[" + result + "]";
    }
}
