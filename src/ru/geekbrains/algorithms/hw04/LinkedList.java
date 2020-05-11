package ru.geekbrains.algorithms.hw04;

import java.util.Iterator;
import java.util.function.Consumer;

public interface LinkedList<E> extends Iterable<E> {

    void addFirst(E value);

    E removeFirst();

    boolean remove(E value);

    int size();

    default boolean isEmpty() {
        return size() == 0;
    }

    void print();

    boolean find(E value);

    E get(int index);

    E getFirst();

    Entry<E> getFirstEntry();

    @Override
    Iterator<E> iterator();

    @Override
    void forEach(Consumer<? super E> action);

    class Entry<E> {
        E value;
        Entry<E> next;

        Entry(E value) {
            this.value = value;
        }
    }
}
