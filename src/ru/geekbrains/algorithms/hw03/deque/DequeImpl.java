package ru.geekbrains.algorithms.hw03.deque;

import ru.geekbrains.algorithms.hw03.queues.QueueArrayImpl;

public class DequeImpl<E> extends QueueArrayImpl<E> implements Deque<E> {

    public DequeImpl(int capacity) {
        super(capacity);
    }

    @Override
    public boolean insertLeft(E value) {
        if (isFull())
            return false;

        if (mFront - 1 < 0)
            mFront = mData.length;

        mData[--mFront] = value;
        mSize++;
        return true;
    }

    @Override
    public boolean insertRight(E value) {
        return super.enqueue(value);
    }

    @Override
    public E removeRight() {
        if (isEmpty())
            return null;

        if (--mEnd < 0)
            mEnd = mSize - 1;
        E data = mData[mEnd];
        mSize--;
        return data;
    }

    @Override
    public E removeLeft() {
        return super.dequeue();
    }
}
