package ru.geekbrains.algorithms.hw04;

import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.function.Consumer;

public class SimpleLinkedList<E> implements LinkedList<E> {

    protected Entry<E> mHead;
    protected int mSize;

    @Override
    public void addFirst(E value) {
        Entry<E> newEntry = new Entry<>(value);
        newEntry.next = mHead;
        mHead = newEntry;
        mSize++;
    }

    @Override
    public void print() {
        Entry<E> current = mHead;
        while (current != null) {
            System.out.printf("%s\t", String.valueOf(current.value));
            current = current.next;
        }
        System.out.println();
    }

    @Override
    public boolean find(E value) {
        Entry<E> current = mHead;
        while (current != null) {
            if (current.value.equals(value))
                return true;
            current = current.next;
        }
        return false;
    }

    @Override
    public E get(int index) {
        if (index > mSize) {
            return null;
        }
        Entry<E> current = mHead;
        int number = 0;
        while (current != null) {
            if (number == index) {
                return current.value;
            }
            number++;
            current = current.next;
        }
        return null;
    }

    @Override
    public E getFirst() {
        return mHead.value;
    }

    @Override
    public E removeFirst() {
        if (isEmpty()) {
            return null;
        }
        Entry<E> removeItem = mHead;
        mHead = mHead.next;
        mSize--;
        return removeItem.value;
    }

    @Override
    public Entry<E> getFirstEntry() {
        return mHead;
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
            previous.next = current.next;
        }
        mSize--;
        return true;
    }

    @Override
    public int size() {
        return mSize;
    }

    @Override
    public Iterator<E> iterator() {
        return new SimpleLinkedListIterator<>(this);
    }

    @Override
    public void forEach(Consumer<? super E> action) {
        LinkedListIterator<E> iterator = (LinkedListIterator<E>) iterator();
        while (iterator.hasNext()) {
            action.accept(iterator.next());
        }
    }

    private static class SimpleLinkedListIterator<E> implements LinkedListIterator<E> {

        private final SimpleLinkedList<E> mIterableList;
        private Entry<E> mCurrent = null,
                mPrevious = null;

        SimpleLinkedListIterator(SimpleLinkedList<E> list) {
            mIterableList = list;
            reset();
        }

        @Override
        public void reset() {
            mCurrent = mIterableList.getFirstEntry();
            mPrevious = null;
        }

        @Override
        public boolean hasNext() {
            return mCurrent != null;
        }

        @Override
        public E next() throws NoSuchElementException {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            E nextValue = mCurrent.value;
            mPrevious = mCurrent;
            mCurrent = mCurrent.next;
            return nextValue;
        }

        @Override
        public void remove() {
            if (mPrevious != null) {
                mPrevious.next = mCurrent.next;
                if (hasNext()) {
                    mCurrent = mCurrent.next;
                } else {
                    reset();
                }
            } else {
                mIterableList.mHead = mCurrent.next;
                reset();
            }
            mIterableList.mSize--;
        }

        @Override
        public void insertBefore(E value) {
            Entry<E> newEntry = new Entry<>(value);
            if (mPrevious == null) {
                newEntry.next = mIterableList.mHead;
                mIterableList.mHead = newEntry;
                reset();
            } else {
                newEntry.next = mCurrent;
                mPrevious.next = newEntry;
                mCurrent = newEntry;
            }
            mIterableList.mSize++;
        }

        @Override
        public void insertAfter(E value) {
            Entry<E> newEntry = new Entry<>(value);
            if (mIterableList.isEmpty()) {
                mIterableList.mHead = newEntry;
                mCurrent = newEntry;
            } else if (mCurrent == null) {
                mPrevious.next = newEntry;
                mCurrent = newEntry;
            } else {
                newEntry.next = mCurrent.next;
                mCurrent.next = newEntry;
            }
            mIterableList.mSize++;
        }
    }
}
