package ru.geekbrains.algorithms.hw06;

import java.util.Random;

public class TreeTest {
    public static final int MAX_TREE_LEVEL = 10;

    public static void main(String[] args) {
        Tree<Integer> tree = new TreeImpl<>();
        int balanced = 0;
        for (int i = 0; i < 100; i++) {
            fillRandomTree(tree);
            balanced = tree.isBalanced() ? balanced + 1 : balanced;
        }

        float procent = ((float) balanced / MAX_TREE_LEVEL) * 100.0f;

        traverseTree(tree);
    }

    private static void traverseTree(Tree<Integer> tree) {
        System.out.printf("%s\t:", "Pre order");
        tree.traverse(Tree.TreeTraverseOrder.PRE_ORDER);
        System.out.printf("\n%s:\t", "Post order");
        tree.traverse(Tree.TreeTraverseOrder.POST_ORDER);
        System.out.printf("\n%s:\t", "In order");
        tree.traverse(Tree.TreeTraverseOrder.IN_ORDER);
        System.out.printf("\n%s:\t", "Depth first");
        tree.traverse(Tree.TreeTraverseOrder.DEPTH_FIRST);
    }

    private static void fillRandomTree(Tree<Integer> tree) {
        Random random = new Random();
        while (tree.getMaxLevel() < MAX_TREE_LEVEL) {
            tree.insert(random.nextInt(201) - 100);
        }
    }
}