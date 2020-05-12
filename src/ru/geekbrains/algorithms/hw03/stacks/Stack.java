package ru.geekbrains.algorithms.hw03.stacks;

public interface Stack<E> {
    boolean push(E value);

    E pop();

    E top();

    int size();

    boolean isFull();

    default boolean isEmpty() {
        return size() == 0;
    }
}
