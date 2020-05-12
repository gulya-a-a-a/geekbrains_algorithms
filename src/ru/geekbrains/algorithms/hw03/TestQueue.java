package ru.geekbrains.algorithms.hw03;

import ru.geekbrains.algorithms.hw03.queues.PriorityQueue;
import ru.geekbrains.algorithms.hw03.queues.Queue;
import ru.geekbrains.algorithms.hw03.queues.QueueArrayImpl;

import java.util.Random;

public class TestQueue {
    public static final int QUEUE_SIZE = 20;
    public static final int MAX_VALUE = 100;
    public static final String delimiter = "---------";

    public static void main(String[] args) {
        QueueArrayImpl<Integer> q = new QueueArrayImpl<>(QUEUE_SIZE);
        System.out.println("Simple array based queue test.");
        testQueue(q);
        System.out.println(delimiter);
        System.out.println();

        System.out.println("Priority queue test.");
        PriorityQueue<Integer> pq = new PriorityQueue<>(QUEUE_SIZE);
        testQueue(pq);
        System.out.println(delimiter);
    }

    public static void testQueue(Queue<Integer> queue) {
        System.out.println("Inserting data in the following order:");
        fillQueueByRandomInteger(queue, queue.getCapacity());

        System.out.println("Removing data in the following order:");
        printQueue(queue, queue.getCapacity() / 2);

        System.out.println("Additional data in the following order:");
        fillQueueByRandomInteger(queue, queue.getCapacity());

        System.out.println("Removing data in the following order:");
        printQueue(queue, queue.getCapacity());
    }

    public static void printQueue(Queue<Integer> q, int numberToRemove) {
        for (int i = 0; i < numberToRemove; i++) {
            System.out.printf("%d\t", q.dequeue());
        }
        System.out.println();
    }

    public static void fillQueueByRandomInteger(Queue<Integer> q, int numberToInsert) {
        Random random = new Random();
        int val;
        for (int i = 0; i < numberToInsert; i++) {
            val = random.nextInt(MAX_VALUE);
            if (q.enqueue(val)) {
                System.out.printf("%d\t", val);
            }
        }
        System.out.println();
    }
}
