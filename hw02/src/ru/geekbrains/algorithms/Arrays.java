package ru.geekbrains.algorithms;

public class Arrays {
    public static void main(String[] args) {
        ArrayImpl<Integer> arrays = new ArrayImpl<Integer>();

        randomFillInteger(arrays);

//        Integer v = arrays.removeValue(122);
//
//        arrays.remove(9);

//        arrays.sortBubble();

//        arrays.sortInsertion();

        arrays.sortSelection();

        int pos = arrays.find(9);
    }

    public static void randomFillInteger(ArrayImpl<Integer> array) {
        for (int i = 0; i < ArrayImpl.MAX_CAPACITY; i++) {
            array.add((int) (Math.random() * 1000));
        }
    }
}
