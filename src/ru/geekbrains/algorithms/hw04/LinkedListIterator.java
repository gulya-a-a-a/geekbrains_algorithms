package ru.geekbrains.algorithms.hw04;

import java.util.Iterator;

public interface LinkedListIterator<E> extends Iterator<E> {
    void reset();

    void insertAfter(E value);

    void insertBefore(E value);
}
