package ru.geekbrains.algorithms.hw03;

import ru.geekbrains.algorithms.hw03.stacks.StackArrayImpl;
import ru.geekbrains.algorithms.hw03.stacks.Stack;

public class TestStacks {
    private static final String outputDelimiter = "---------";

    public static void main(String[] args) {
        Stack<Integer> stack = new StackArrayImpl<>();
        fillStackByRandomIntegers(stack, 10);

        printStack(stack);
    }

    public static void fillStackByRandomIntegers(Stack<Integer> stack, int numberOf) {
        int value;
        for (int i = 0; i < numberOf; i++) {
            value = (int) (Math.random() * 100);
            if (!stack.push(value)) {
                break;
            }
            System.out.printf("%d\t", value);
        }
        System.out.printf("\n%s\n", outputDelimiter);
    }

    public static <E> void printStack(Stack<E> stack) {
        E value;
        while ((value = stack.pop()) != null) {
            System.out.printf("%d\t", value);
        }
        System.out.printf("\n%s\n", outputDelimiter);
    }
}
