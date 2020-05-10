package ru.geekbrains.algorithms.hw02;

import java.util.concurrent.TimeUnit;
import java.util.function.Consumer;

public class Arrays {
    public static void main(String[] args) {
        ArrayImpl<Integer> arrays = new ArrayImpl<>();

        randomFillInteger(arrays);

//        Integer v = arrays.removeValue(122);
//        arrays.remove(9);

        long res = workTimeCalculate(ArrayImpl::sortBubble, arrays);
        System.out.printf("Bubble sort time: %d\n", res);

        arrays.resetData();
        randomFillInteger(arrays);
        res = workTimeCalculate(ArrayImpl::sortInsertion, arrays);
        System.out.printf("Insertion sort time: %d\n", res);

        arrays.resetData();
        randomFillInteger(arrays);
        res = workTimeCalculate(ArrayImpl::sortSelection, arrays);
        System.out.printf("Selection sort time: %d\n", res);

        int pos = arrays.find(9);
    }

    public static void randomFillInteger(ArrayImpl<Integer> array) {
        for (int i = 0; i < ArrayImpl.MAX_CAPACITY; i++) {
            array.add((int) (Math.random() * 1000));
        }
    }

    public static long workTimeCalculate(Consumer<ArrayImpl> func, ArrayImpl<Integer> integerArray) {
        long start = System.nanoTime();
        func.accept(integerArray);
        return TimeUnit.NANOSECONDS.toMillis(System.nanoTime() - start);
    }
}
