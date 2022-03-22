package ru.job4j.oop;

public class Bus implements Vehicle {
    @Override
    public void move() {
        System.out.println("Ending station is...");
    }

    @Override
    public void signal() {
        System.out.println("Beep - Beep");
    }
}
