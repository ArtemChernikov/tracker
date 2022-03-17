package ru.job4j.oop;

public class Calculator {
    private static int x = 5;

    public static int sum(int y) {
        return x + y;
    }

    public static int minus(int y) {
        return y - x;
    }

    public int divide(int y) {
        return y / x;
    }

    public int multiply(int a) {
        return x * a;
    }

    public int sumAllOperation(int a) {
        return sum(a) + minus(a) + divide(a) + multiply(a);
    }

    public static void main(String[] args) {
        Calculator calculator = new Calculator();
        sum(10);
        minus(10);
        calculator.divide(10);
        calculator.multiply(10);
        calculator.sumAllOperation(10);
    }
}
