package ru.geekbrains.algorithms;

public class ArrayImpl<T extends Object & Comparable<? super T>> {
    static final int MAX_CAPACITY = 100000;
    static final int NOT_FOUND = -1;
    private T[] mData;

    private int size;
    private boolean isSorted;

    public ArrayImpl() {
        mData = (T[]) new Object[MAX_CAPACITY + 1];
    }

    public <T> T[] getData() {
        return (T[]) mData;
    }

    public T get(int position) {
        checkIndex(position);
        return (T) mData[position];
    }

    public void add(int position, T value) {
        checkIndex(position);
        mData[position] = value;
    }

    public void add(T value) {
        add(size, value);
        size++;
        isSorted = false;
    }

    public void resetData() {
        mData = (T[]) new Object[MAX_CAPACITY + 1];
        size = 0;
    }

    public void set(int position, T value) {
        checkIndex(position);
        mData[position] = value;
    }

    private int linearSearch(T value) {
        for (int i = 0; i < size; i++) {
            if (mData[i].equals(value)) {
                return i;
            }
        }
        return NOT_FOUND;
    }

    private int binarySearch(T value) {
        int min = 0, max = size, mid;

        while (min <= max) {
            mid = (max - min) / 2 + min;
            if (value.compareTo(mData[mid]) > 0) {
                min = mid + 1;
            } else if (value.compareTo(mData[mid]) < 0) {
                max = mid - 1;
            } else {
                return mid;
            }
        }
        return NOT_FOUND;
    }

    public int find(T value) {
        if (isSorted) {
            return binarySearch(value);
        }
        return linearSearch(value);
    }

    public T remove(int position) {
        checkIndex(position);
        T removed = mData[position];
        System.arraycopy(mData, position + 1, mData, position, size - position);
        size--;
        return removed;
    }

    public T removeValue(T value) {
        int position = find(value);
        if (position == NOT_FOUND)
            return null;
        return remove(position);
    }

    public T removeLast() {
        int position = size - 1;
        return remove(position);
    }

    private void swap(int pos1, int pos2) {
        T temp = mData[pos1];
        mData[pos1] = mData[pos2];
        mData[pos2] = temp;
    }

    private boolean less(T value1, T value2) {
        return value1.compareTo(value2) < 0;
    }

    public void sortBubble() {
        for (int i = size; i >= 0; i--) {
            for (int j = 0; j < i - 1; j++) {
                if (less(mData[j + 1], mData[j])) {
                    swap(j + 1, j);
                }
            }
        }
        isSorted = true;
    }

    public void sortInsertion() {
        for (int i = 1; i < size; i++) {
            for (int j = i; j > 0 && less(mData[j], mData[j - 1]); j--) {
                swap(j - 1, j);
            }
        }
        isSorted = true;
    }

    public void sortSelection() {
        int minIndex = 0;
        for (int i = 0; i < size; i++) {
            for (int j = i; j < size; j++) {
                if (less(mData[j], mData[minIndex])) {
                    minIndex = j;
                }
            }
            swap(minIndex, i);
        }
        isSorted = true;
    }

    private void checkIndex(int position) {
        if (position < 0 || position > mData.length) {
            String errMsg = String.format("Invalid index %d for array with size %d",
                    position, size);
            throw new IndexOutOfBoundsException(errMsg);
        }
    }
}
