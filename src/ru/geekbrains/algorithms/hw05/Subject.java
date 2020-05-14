package ru.geekbrains.algorithms.hw05;

public class Subject {
    private final String mName;
    private final int mWeight;
    private final int mCost;

    Subject(String name, int weight, int cost) {
        mName = name;
        mWeight = weight;
        mCost = cost;
    }

    public String getName() {
        return mName;
    }

    public int getWeight() {
        return mWeight;
    }

    public int getCost() {
        return mCost;
    }

    @Override
    public String toString() {
        return String.format("\nИмя: %s\nВес: %d\nСтоимость: %d\n", mName, mWeight, mCost);
    }
}
