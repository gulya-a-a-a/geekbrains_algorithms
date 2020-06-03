package ru.geekbrains.algorithms.hw08;

public class HashTableTest {
    public static void main(String[] args) {
        HashTable<Product, Integer> hashTable = new HashTableImpl<>(10);

        hashTable.put(new Product(7, "Ball"), 200);
        hashTable.put(new Product(3, "Shirt"), 400);
        hashTable.put(new Product(18, "Boots"), 600);
        hashTable.put(new Product(7, "T-shirt"), 800);
        hashTable.display();

        hashTable.remove(new Product(3, "Shirt"));
        hashTable.remove(new Product(7, "Ball"));
        hashTable.display();

        System.out.println(hashTable.get(new Product(7, "Ball")));
    }
}
