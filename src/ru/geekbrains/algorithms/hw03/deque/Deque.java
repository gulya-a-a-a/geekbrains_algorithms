package ru.geekbrains.algorithms.hw03.deque;

import ru.geekbrains.algorithms.hw03.queues.Queue;

public interface Deque<E> extends Queue<E> {
    boolean insertLeft(E value);

    boolean insertRight(E value);

    E removeRight();

    E removeLeft();
}
