package ru.geekbrains.algorithms.hw03.queues;

public class PriorityQueue<E extends Object & Comparable<? super E>> extends QueueArrayImpl<E> {

    public PriorityQueue(int capacity) {
        super(capacity);
    }

    @Override
    public boolean enqueue(E value) {
        if (isFull())
            return false;

        int index;
        for (index = mSize - 1; index >= 0; index--) {
            if (value.compareTo(mData[index]) > 0) {
                mData[index + 1] = mData[index];
            } else {
                break;
            }
        }

        mData[index + 1] = value;
        mSize++;
        return true;
    }

    @Override
    public E peekFront() {
        return mData[mSize - 1];
    }

    @Override
    public E dequeue() {
        return isEmpty() ? null : mData[--mSize];
    }
}

