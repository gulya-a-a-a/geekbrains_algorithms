package ru.geekbrains.algorithms.hw03.queues;

public class QueueArrayImpl<E> implements Queue<E> {

    protected E[] mData;
    protected int mSize, mFront, mEnd;

    public QueueArrayImpl(int capacity) {
        mData = (E[]) new Object[capacity];
    }

    @Override
    public int getCapacity() {
        return mData.length;
    }

    @Override
    public boolean enqueue(E value) {
        if (isFull()) {
            return false;
        }
        if (mEnd == mData.length) {
            mEnd = 0;
        }
        mData[mEnd] = value;
        mEnd++;
        mSize++;
        return true;
    }

    @Override
    public E peekFront() {
        if (isEmpty()) {
            return null;
        }
        return mData[mFront];
    }

    @Override
    public E dequeue() {
        if (isEmpty()) {
            return null;
        }
        E data = mData[mFront];
        if (++mFront >= mData.length)
            mFront = 0;
        mSize--;
        return data;
    }

    @Override
    public int size() {
        return mSize;
    }

    @Override
    public boolean isFull() {
        return mSize == mData.length;
    }
}
