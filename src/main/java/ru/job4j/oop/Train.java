package ru.job4j.oop;

public class Train implements Vehicle {
    @Override
    public void move() {
        System.out.println("I'm going by rail");
    }

    @Override
    public void signal() {
        System.out.println("Too - Too");
    }
}
