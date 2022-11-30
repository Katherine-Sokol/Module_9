package Task5_HashMap;


import java.util.Arrays;
import java.util.Objects;
import java.util.StringJoiner;

public class MyHashMap<K, V> {
    private static final int INIT_SIZE = 8;
    private int length = INIT_SIZE;
    private Node<K, V>[] table;
    private int size;

    public MyHashMap() {
        table = new Node[INIT_SIZE];
    }

    public V remove(K key) {
        V result = getValue(key, true);
        size--;
        return result;
    }

    public V get(K key) {
        return getValue(key, false);
    }

    private V getValue(K key, boolean isToBeDeleted) {
        V result = null;
        int cellHash = hash(key);
        int cellAddress = cellHash & (length - 1);
        Node<K, V> entry = table[cellAddress];
        if ( (entry.getKey() == null && key == null)  || (entry.getKey() != null && entry.getKey().equals(key))) {
            result = entry.getValue();
            if (isToBeDeleted) {
                table[cellAddress] = entry.next;
            }
            return result;
        }
        while (entry.next != null) {
            if ((entry.next.getKey() == null && key == null)  || (entry.next.getKey() != null && entry.next.getKey().equals(key))) {
                result = entry.next.getValue();
                if (isToBeDeleted) {
                    entry.next = entry.next.next;
                }
                break;
            }
            entry = entry.next;
        }

        return result;
    }

    private int hash(Object key) {
        int h;
        return (key == null) ? 0 : (h = key.hashCode()) ^ (h >>> 16);
    }

    public V put(K key, V value) {
        if (size == table.length) {
            table = resize(table);
        }
        V result = put(table, key, value);
        size++;
        return result;
    }

    private V put(Node<K, V>[] storage, K key, V value) {
        V result = null;
        int cellHash = hash(key);
        boolean isKeyFound = false;
        int cellAddress = cellHash & (length - 1);
        Node<K, V> entry;
        if (storage[cellAddress] == null) {
            storage[cellAddress] = new Node<>(cellHash, key, value, null);
        } else {
            entry = storage[cellAddress];
            while (entry.next != null) {
                if ((entry.getKey() == null && key == null) || (entry.getKey() != null && entry.getKey().equals(key))) {
                    result = entry.getValue();
                    entry.setValue(value);
                    isKeyFound = true;
                    break;
                }
                entry = entry.next;
            }
            if (!isKeyFound) {
                entry.next = new Node<>(cellHash, key, value, null);
            }
        }

        return result;
    }


    private Node<K, V>[] resize(Node<K, V>[] table) {
        int newSize = table.length * 2;
        Node<K, V>[] newStorage = new Node[newSize];
        for (Node<K, V> entry : table) {
            while (entry != null) {
                int cellAddress = entry.hash & (length - 1);
                if (newStorage[cellAddress] == null) {
                    newStorage[cellAddress] = entry;
                    entry = entry.next;
                    newStorage[cellAddress].next = null;
                } else {
                    Node<K, V> newEntry = newStorage[cellAddress];
                    while (newEntry.next != null) {
                        newEntry = newEntry.next;
                    }
                    newEntry.next = entry;
                    entry = entry.next;
                    newEntry.next.next = null;
                }

            }
        }
        return newStorage;
    }

    public void clear() {
        Node<K, V>[] tab;
        if ((tab = table) != null && size > 0) {
            size = 0;
            Arrays.fill(tab, null);
        }
    }

    public int size() {
        return size;
    }

    private static class Node<K, V> {
        private int hash;
        private K key;
        private V value;
        Node<K, V> next;

        Node(int hash, K key, V value, Node<K, V> next) {
            this.hash = hash;
            this.key = key;
            this.value = value;
            this.next = next;
        }

        public final K getKey() {
            return key;
        }

        public final V getValue() {
            return value;
        }

        public final String toString() {
            return key + "=" + value;
        }

        public final int hashCode() {
            return Objects.hashCode(key) ^ Objects.hashCode(value);
        }

        public final V setValue(V newValue) {
            V oldValue = value;
            value = newValue;
            return oldValue;
        }

        public final boolean equals(Object o) {
            if (o == this)
                return true;
            if (o instanceof Node) {
                Node<?, ?> e = (Node<?, ?>) o;
                return Objects.equals(key, e.getKey()) &&
                        Objects.equals(value, e.getValue());
            }
            return false;
        }
    }

    @Override
    public String toString() {
        StringJoiner result = new StringJoiner(", ");
        for (Node<K,V> node: table) {
            if (node != null) {
                result.add(node.toString());
            }
        }
        return "[" + result + "]";
    }
}
