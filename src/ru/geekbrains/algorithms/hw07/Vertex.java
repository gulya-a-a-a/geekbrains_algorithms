package ru.geekbrains.algorithms.hw07;

public class Vertex<E> {
    private final E mData;
    private boolean mVisited;

    private Vertex<E> mPrevious;

    Vertex(E value) {
        mData = value;
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }

    public E getData() {
        return mData;
    }

    public boolean isVisited() {
        return mVisited;
    }

    public void setVisited(boolean visited) {
        mVisited = visited;
    }

    @Override
    public String toString() {
        return String.format("%s", mData);
    }

    public void setVisited(boolean b, Vertex<E> previousNode) {
        setVisited(b);
        mPrevious = previousNode;
    }

    public Vertex<E> getPrevious() {
        return mPrevious;
    }
}
