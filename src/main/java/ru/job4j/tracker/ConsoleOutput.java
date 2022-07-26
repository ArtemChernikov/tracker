package ru.job4j.tracker;

public class ConsoleOutput implements Output {
    public ConsoleOutput() {
    }

    @Override
    public void println(Object obj) {
        System.out.println(obj);
    }
}
