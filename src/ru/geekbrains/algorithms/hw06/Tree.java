package ru.geekbrains.algorithms.hw06;

public interface Tree<E extends Comparable<? super E>> {

    enum TreeTraverseOrder {
        PRE_ORDER,
        IN_ORDER,
        POST_ORDER,
        DEPTH_FIRST
    }

    boolean insert(E value);

    boolean contains(E value);

    boolean remove(E value);

    int size();

    default boolean isEmpty() {
        return size() == 0;
    }

    int getMaxLevel();

    boolean isBalanced();

    void traverse(TreeTraverseOrder order);
}
