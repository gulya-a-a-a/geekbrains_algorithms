package ru.geekbrains.algorithms.hw05;

public class Exponential {
    public static void main(String[] args) {
        System.out.printf("%f\n", exp(0, 2));
        System.out.printf("%f\n", exp(2, 3));
        System.out.printf("%f\n", exp(-2, 3));
        System.out.printf("%f\n", exp(2, -2));
        System.out.printf("%f\n", exp(-2, -3));
        System.out.printf("%f\n", exp(4, 1));

        try {
            System.out.printf("%f\n", exp(0, -2));
        } catch (IllegalArgumentException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public static float exp(float value, int pow) throws IllegalArgumentException {
        if (pow < 0) {
            if (value == 0)
                throw new IllegalArgumentException("Can't divide by zero.");
            return 1.0F / (value * exp(value, -(pow + 1)));
        } else if (pow > 0) {
            if (value == 0)
                return 0;
            return value * exp(value, pow - 1);
        }

        return 1.0F;
    }
}
