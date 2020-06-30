package ru.geekbrains.algorithms.hw07;

import org.w3c.dom.ls.LSOutput;

public class GraphsTest {
    public static void main(String[] args) {
        Graph<String> graph = new Graph<>(20);
        graph.addMultiple("Москва", "Тула", "Липецк", "Воронеж", "Рязань", "Тула", "Липецк", "Саратов", "Курск", "Тамбов", "Калуга", "Орел");

        graph.addEdges("Москва", "Тула", "Рязань", "Калуга");

        graph.addEdges("Тула", "Липецк");

        graph.addEdges("Рязань", "Тамбов");
        graph.addEdges("Тамбов", "Саратов");

        graph.addEdges("Калуга", "Орел");
        graph.addEdges("Орел", "Курск");

        graph.addEdges("Воронеж", "Липецк", "Саратов", "Курск");

        System.out.println("Кратчайший путь: ");
        System.out.println(graph.findShortestPath("Москва", "Воронеж"));

        System.out.println();
        System.out.println("Обход в глубину");
        graph.dfs();

        System.out.println("\n");
        System.out.println("Обход в ширину");
        graph.bfs();
    }
}
