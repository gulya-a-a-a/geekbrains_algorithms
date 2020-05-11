package ru.geekbrains.algorithms.hw04;

import java.sql.Struct;
import java.util.Arrays;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class Main {
    public static void main(String[] args) {
//        System.out.println("Simple linked list");
//        testSimpleLinkedLists();
//
//        System.out.println("Two side linked list");
//        testTwoSideLinkedList();

        LinkedIteratorApp();
    }

    public static void testSimpleLinkedLists() {
        SimpleLinkedList<Integer> sll = new SimpleLinkedList<>();

        sll.addFirst(10);
        fillLinkedList(sll, 10);

        System.out.println("Initial list");
        printLinkedList(sll);

        System.out.println("Elements were removed");
        int value = sll.removeFirst();
        sll.remove(10);
        printLinkedList(sll);
        System.out.println();


    }

    public static void acceptToListItems(Integer value) {
        System.out.printf("%s\t", String.valueOf(value + 5));
    }

    public static void testTwoSideLinkedList() {
        TwoSideLinkedList<Integer> tsll = new TwoSideLinkedListImpl<>();
        fillLinkedList(tsll, 15);

        System.out.println("Initial list");
        printLinkedList(tsll);

        System.out.println("Add to end");
        tsll.addLast(12);
        tsll.addLast(91);
        printLinkedList(tsll);

        System.out.println("Removing items");
        tsll.remove(12);
        printLinkedList(tsll);
    }

    public static void fillLinkedList(LinkedList<Integer> list, int size) {
        for (int i = 0; i < size; i++) {
            list.addFirst((int) (Math.random() * 100));
        }
    }

    public static void printLinkedList(LinkedList<Integer> list) {
        System.out.printf("Size: %d\n", list.size());
        list.print();
        System.out.println("------------");
    }

    public static void LinkedIteratorApp() {
        SimpleLinkedList<Integer> sll = new SimpleLinkedList<>();

        fillLinkedList(sll, 10);

        System.out.println("Initial list");
        printLinkedList(sll);

        System.out.println("Print through range based for");
        for (int i : sll) {
            System.out.printf("%d\t", i);
        }
        System.out.println("\n------------");

        System.out.println("Accept plus 5 method through forEach");
        sll.forEach(Main::acceptToListItems);
        System.out.println("\n------------");

        System.out.println("Remove items through iterator");
        Iterator<Integer> iter = sll.iterator();
        Integer iterVal = null;
        int i;
        for (i = 0; i < 3; i++) {
            iterVal = iter.next();
        }
        Integer val = sll.get(i);
        System.out.printf("Iter: %d; Get: %d; Equality: %b\n", iterVal, val, val.equals(iterVal));
        System.out.println("\n------------");
        iter.remove();

        printLinkedList(sll);

        System.out.println("Try to get an exception");
        iter = sll.iterator();
        try {
            for (int j = 0; j < sll.size() + 1; j++) {
                System.out.printf("%s\t", String.valueOf(iter.next()));
            }
        } catch (NoSuchElementException ex) {
            System.out.printf("\nException: %s\n The end of the list was reached.\n", ex.getClass());
        }
        System.out.println();

        System.out.println("Inserting before and after selected item");
        LinkedListIterator<Integer> iterSimple = (LinkedListIterator<Integer>) sll.iterator();
        iterSimple.insertAfter(66);
        for (int j = 0; j < sll.size(); j++) {
            if (iterSimple.hasNext())
                iterSimple.next();
        }
        iterSimple.insertBefore(99);
        printLinkedList(sll);

        System.out.println("EmptyList");
        SimpleLinkedList<Integer> sllEmpty = new SimpleLinkedList<>();

        printLinkedList(sllEmpty);

        iterSimple = (LinkedListIterator<Integer>) sllEmpty.iterator();
        iterSimple.insertAfter(18);
        iterSimple.insertBefore(11);

        printLinkedList(sllEmpty);
    }
}
