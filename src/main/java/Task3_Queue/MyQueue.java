package Task3_Queue;

import java.util.StringJoiner;

public class MyQueue<T> {

    private static final int INIT_SIZE = 8;
    private Object[] data;
    private int size;

    public MyQueue() {
        data = new Object[INIT_SIZE];
    }

    public void add(Object value) {
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
        return (T) data[0];
    }

    public T poll() {
        Object[] objects = data;
        T oldValue = (T) objects[0];
        int newSize = size - 1;
        System.arraycopy(objects, 1, objects, 0, newSize);
        objects[size = newSize] = null;
        return oldValue;
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
