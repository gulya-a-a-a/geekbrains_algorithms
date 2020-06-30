package ru.geekbrains.algorithms.hw08;

public interface HashTable<K, V> {

    boolean put(K key, V value);

    V get(K key);

    V remove(K key);

    boolean isEmpty();

    int size();

    void display();

    interface Entry<K, V> {
        K getKey();

        V getValue();

        void setValue(V value);

        Entry<K, V> getNext();

        void setNext(Entry<K, V> next);
    }

}
