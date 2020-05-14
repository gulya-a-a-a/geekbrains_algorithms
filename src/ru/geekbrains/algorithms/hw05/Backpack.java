package ru.geekbrains.algorithms.hw05;

import java.util.ArrayList;
import java.util.List;

public class Backpack {
    private int mBestCost, mMaxWeight;
    private List<Subject> mBestList;

    Backpack(int maxWeight) {
        mMaxWeight = maxWeight;
    }

    private int getWeight(List<Subject> subjects) {
        int weight = 0;
        for (Subject s : subjects) {
            weight += s.getWeight();
        }
        return weight;
    }

    private int getCost(List<Subject> subjects) {
        int cost = 0;
        for (Subject s : subjects) {
            cost += s.getCost();
        }
        return cost;
    }

    public List<Subject> getBestList() {
        return mBestList;
    }

    void checkListCost(List<Subject> subjects) {
        int subCost = getCost(subjects);
        if (getWeight(subjects) <= mMaxWeight && subCost > mBestCost) {
            mBestCost = subCost;
            mBestList = subjects;
        }
    }


    void findMaxCostList(List<Subject> subjects) {
        if (subjects.isEmpty())
            return;

        checkListCost(subjects);

        for (int i = 0; i < subjects.size(); i++) {
            List<Subject> partList = new ArrayList<>(subjects);
            partList.remove(i);
            findMaxCostList(partList);
        }
    }
}
