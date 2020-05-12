package ru.geekbrains.algorithms.hw03.stacks;

public class StackArrayImpl<E> implements Stack<E> {
    private static final int DEFAULT_CAPACITY = 10;

    private final E[] mData;
    private int mTop;

    public StackArrayImpl() {
        this(DEFAULT_CAPACITY);
    }

    public StackArrayImpl(int capacity) {
        mData = (E[]) new Object[capacity];
    }

    @Override
    public boolean push(E value) {
        if (isFull()) {
            return false;
        }
        mData[mTop++] = value;
        return true;
    }

    @Override
    public E top() {
        if (isEmpty())
            return null;
        return mData[mTop - 1];
    }

    @Override
    public E pop() {
        if (isEmpty()) {
            return null;
        }
        E data = top();
        mTop--;
        return data;
    }

    @Override
    public boolean isFull() {
        return mTop == mData.length;
    }

    @Override
    public int size() {
        return mTop;
    }
}
