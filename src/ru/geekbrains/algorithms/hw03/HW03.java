package ru.geekbrains.algorithms.hw03;

import ru.geekbrains.algorithms.hw03.deque.Deque;
import ru.geekbrains.algorithms.hw03.deque.DequeImpl;
import ru.geekbrains.algorithms.hw03.stacks.Stack;
import ru.geekbrains.algorithms.hw03.stacks.StackArrayImpl;

public class HW03 {
    public static void main(String[] args) {
        revertStringTask();

        dequeueTestTask();
    }

    private static void revertStringTask() {
        final String henryTheEight = "I come no more to make you laugh: things now,\n" +
                "That bear a weighty and a serious brow,\n" +
                "Sad, high, and working, full of state and woe,\n" +
                "Such noble scenes as draw the eye to flow,\n" +
                "We now present. Those that can pity, here\n" +
                "May, if they think it well, let fall a tear;";

        Stack<Character> stack = new StackArrayImpl<>(henryTheEight.length());


        for (int i = 0; i < henryTheEight.length(); i++) {
            stack.push(henryTheEight.charAt(i));
        }

        while (!stack.isEmpty()) {
            System.out.printf("%c", stack.pop());
        }
        System.out.println();
    }

    private static void dequeueTestTask() {
        Deque<Integer> dq = new DequeImpl<>(TestQueue.QUEUE_SIZE);
        TestQueue.fillQueueByRandomInteger(dq, TestQueue.QUEUE_SIZE - 2);

        dq.insertLeft(15);
        dq.insertRight(22);

        System.out.printf("%d\n", dq.removeLeft());
        System.out.printf("%d\n", dq.removeRight());

//        TestQueue.printQueue(dq, TestQueue.QUEUE_SIZE);

        revertData(dq);
    }

    private static <E> void revertData(Deque<E> dq) {
        while (!dq.isEmpty()) {
            System.out.printf("%d\t", (Integer) dq.removeRight());
        }
    }
}
