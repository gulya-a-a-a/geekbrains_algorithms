package ru.geekbrains.algorithms.hw06;

public class BinaryNode<T extends Comparable<? super T>> {

    private BinaryNode<T> leftChild,
            rightChild;

    private final T mData;

    BinaryNode(T value) {
        mData = value;
    }

    public T getData() {
        return mData;
    }

    public BinaryNode<T> getLeftChild() {
        return leftChild;
    }

    public BinaryNode<T> getRightChild() {
        return rightChild;
    }


    public void setLeftChild(BinaryNode<T> leftChild) {
        this.leftChild = leftChild;
    }

    public void setRightChild(BinaryNode<T> rightChild) {
        this.rightChild = rightChild;
    }
}
