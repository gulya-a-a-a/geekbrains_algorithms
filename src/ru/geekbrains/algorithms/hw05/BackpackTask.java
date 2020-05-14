package ru.geekbrains.algorithms.hw05;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BackpackTask {
    public static void main(String[] args) {

        Backpack backpack = new Backpack(7);

        List<Subject> subjectList = new ArrayList<>(5);
        subjectList.add(new Subject("Книга", 1, 600));
        subjectList.add(new Subject("Бинокль", 2, 5000));
        subjectList.add(new Subject("Аптечка", 4, 1500));
        subjectList.add(new Subject("Ноутбук", 2, 40000));
        subjectList.add(new Subject("Котелок", 1, 500));


        backpack.findMaxCostList(subjectList);

        if (backpack.getBestList() != null)
            System.out.println(Arrays.toString(backpack.getBestList().toArray()));
    }
}
