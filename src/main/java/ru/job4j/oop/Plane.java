package ru.job4j.oop;

public class Plane implements Vehicle {
    @Override
    public void move() {
        System.out.println("Up to sky");
    }

    @Override
    public void signal() {
        System.out.println("Boop - Boop");
    }
}
