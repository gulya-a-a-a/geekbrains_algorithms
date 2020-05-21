package ru.geekbrains.algorithms.hw04;

public class TwoSideLinkedListImpl<E> extends SimpleLinkedList<E> implements TwoSideLinkedList<E> {

    private Entry<E> mTail;

    @Override
    public void addLast(E value) {
        Entry<E> newEntry = new Entry<>(value);
        if (mTail == null) {
            mHead = newEntry;
        } else {
            mTail.next = newEntry;
        }
        mTail = newEntry;
        mSize++;
    }

    @Override
    public void addFirst(E value) {
        super.addFirst(value);
        if (mSize == 1) {
            mTail = mHead;
        }
    }

    @Override
    public E removeFirst() {
        E removedEntry = super.removeFirst();
        if (mSize == 0) {
            mTail = null;
        }
        return removedEntry;
    }

    @Override
    public boolean remove(E value) {
        if (isEmpty())
            return false;

        Entry<E> current = mHead,
                previous = null;

        while (current != null) {
            if (current.value.equals(value)) {
                break;
            }
            previous = current;
            current = current.next;
        }

        if (current == null) {
            return false;
        }
        if (current == mHead) {
            mHead = mHead.next;
        } else {
            if (current == mTail) {
                mTail = previous;
            }
            previous.next = current.next;
        }
        mSize--;
        return true;
    }
}
