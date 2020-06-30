package ru.geekbrains.algorithms.hw06;

import java.util.LinkedList;
import java.util.Queue;

public class TreeImpl<E extends Comparable<? super E>> implements Tree<E> {

    private BinaryNode<E> root;
    private int mSize;
    private int mMaxLevel;

    @Override
    public boolean insert(E value) {
        if (isEmpty()) {
            root = new BinaryNode<>(value);
            mSize++;
            return true;
        }

        NodeInfo nodeInfo = find(value);
        if (nodeInfo.level > mMaxLevel) {
            mMaxLevel = nodeInfo.level;
        }

        BinaryNode<E> parent = nodeInfo.parent;
        if (parent == null) {
            return false;
        }
        if (parent.getData().compareTo(value) > 0) {
            parent.setLeftChild(new BinaryNode<>(value));
        } else {
            parent.setRightChild(new BinaryNode<>(value));
        }
        mSize++;
        return true;
    }

    @Override
    public int size() {
        return mSize;
    }

    @Override
    public boolean contains(E value) {
        return find(value).current != null;
    }

    @Override
    public boolean remove(E value) {
        return false;
    }

    private int height(BinaryNode<E> node) {
        return node == null ? 0 : 1 + Math.max(height(node.getLeftChild()), height(node.getRightChild()));
    }

    @Override
    public boolean isBalanced() {
        return isBalancedRecurred(root);
    }


    private boolean isBalancedRecurred(BinaryNode<E> node) {
        return (node == null)
                || isBalancedRecurred(node.getLeftChild())
                && isBalancedRecurred(node.getRightChild())
                && Math.abs(height(node.getLeftChild()) - height(node.getRightChild())) <= 1;
    }

    private NodeInfo find(E value) {
        BinaryNode<E> current = root,
                parent = null;
        int level = 0;

        while (current != null) {
            if (current.getData().equals(value)) {
                return new NodeInfo(current, parent, level);
            }

            parent = current;
            if (current.getData().compareTo(value) > 0) {
                current = current.getLeftChild();
            } else {
                current = current.getRightChild();
            }
            level++;
        }
        return new NodeInfo(null, parent, level);
    }

    @Override
    public void traverse(TreeTraverseOrder order) {
        switch (order) {
            case PRE_ORDER -> traversePreOrder(root);
            case IN_ORDER -> traverseInOrder(root);
            case POST_ORDER -> traversePostOrder(root);
            case DEPTH_FIRST -> traverseDepthFirst(root);
        }
    }

    void traversePreOrder(BinaryNode<E> node) {
        System.out.printf("%s\t", node.getData());
        if (node.getLeftChild() != null)
            traversePreOrder(node.getLeftChild());
        if (node.getRightChild() != null)
            traversePreOrder(node.getRightChild());
    }

    void traverseInOrder(BinaryNode<E> node) {
        if (node.getLeftChild() != null)
            traverseInOrder(node.getLeftChild());
        System.out.printf("%s\t", node.getData());
        if (node.getRightChild() != null)
            traverseInOrder(node.getRightChild());
    }

    void traversePostOrder(BinaryNode<E> node) {
        if (node.getLeftChild() != null)
            traverseInOrder(node.getLeftChild());
        if (node.getRightChild() != null)
            traverseInOrder(node.getRightChild());
        System.out.printf("%s\t", node.getData());
    }


    void traverseDepthFirst(BinaryNode<E> root) {
        Queue<BinaryNode<E>> queue = new LinkedList<>();

        queue.add(root);
        while (!queue.isEmpty()) {
            BinaryNode<E> node = queue.remove();

            System.out.printf("%s\t", node.getData());

            if (node.getLeftChild() != null)
                queue.add(node.getLeftChild());
            if (node.getRightChild() != null)
                queue.add(node.getRightChild());
        }
    }

    @Override
    public int getMaxLevel() {
        return mMaxLevel;
    }

    private class NodeInfo {
        BinaryNode<E> current;
        BinaryNode<E> parent;
        int level;

        NodeInfo(BinaryNode<E> current, BinaryNode<E> parent, int level) {
            this.current = current;
            this.parent = parent;
            this.level = level;
        }
    }

}
