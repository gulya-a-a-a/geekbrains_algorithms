package ru.geekbrains.algorithms.hw08;

public class HashTableImpl<K, V> implements HashTable<K, V> {

    private static class Node<K, V> implements Entry<K, V> {
        K key;
        V value;
        Entry<K, V> next;

        public Node(K key, V value) {
            this.key = key;
            this.value = value;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "key=" + key +
                    ", value=" + value +
                    ", next=" + next +
                    '}';
        }

        @Override
        public K getKey() {
            return key;
        }

        @Override
        public V getValue() {
            return value;
        }

        @Override
        public void setValue(V value) {
            this.value = value;
        }

        @Override
        public Entry<K, V> getNext() {
            return next;
        }

        @Override
        public void setNext(Entry<K, V> next) {
            this.next = next;
        }
    }

    private static final int DOUBLE_HASH_CONST = 5;
    private final Node<K, V>[] mData;
    private int mSize;

    @SuppressWarnings("unchecked")
    public HashTableImpl(int maxSize) {
        this.mData = new Node[maxSize];
    }

    private int hashFunc(K key) {
        return (key.hashCode() % mData.length);
    }

    @Override
    public boolean put(K key, V value) {
        int index = hashFunc(key);
        Node<K, V> newNode = new Node<>(key, value);
        Entry<K, V> currentNode = mData[index];
        if (currentNode == null) {
            mData[index] = newNode;
            mSize++;
            return true;
        }
        while (currentNode.getNext() != null) {
            currentNode = currentNode.getNext();
        }
        currentNode.setNext(newNode);
        mSize++;
        return true;
    }

    @Override
    public V get(K key) {
        int index = hashFunc(key);
        Entry<K, V> current = mData[index];
        while (current != null && !current.getKey().equals(key)) {
            current = current.getNext();
        }
        if (current != null)
            return current.getValue();
        return null;
    }

    @Override
    public V remove(K key) {
        int index = hashFunc(key);
        Entry<K, V> current = mData[index],
                previous = null;
        while (current != null && !current.getKey().equals(key)) {
            previous = current;
            current = current.getNext();
        }
        if (current != null) {
            if (previous != null)
                previous.setNext(current.getNext());
            else
                mData[index] = (Node<K, V>) current.getNext();
            mSize--;
            return current.getValue();
        }
        return null;
    }

    @Override
    public boolean isEmpty() {
        return mSize == 0;
    }

    @Override
    public int size() {
        return mSize;
    }

    @Override
    public void display() {
        System.out.println("------------");
        for (int i = 0; i < mData.length; i++) {
            System.out.printf("%d - {%s}\n", i, mData[i]);
        }
        System.out.println("------------");
    }
}
