package ru.geekbrains.algorithms.hw03.queues;

public interface Queue<E> {

    boolean enqueue(E value);

    E peekFront();

    E dequeue();

    int size();

    default boolean isEmpty() {
        return size() == 0;
    }

    boolean isFull();

    int getCapacity();

}
