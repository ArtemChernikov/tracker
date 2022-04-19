package ru.job4j.collection;

import java.util.Arrays;
import java.util.Comparator;

public class LexSort implements Comparator<String> {
    @Override
    public int compare(String left, String right) {
        String[] arrayLeft = left.split("\\.");
        String[] arrayRight = right.split("\\.");
        return Integer.compare(Integer.parseInt(arrayLeft[0]), Integer.parseInt(arrayRight[0]));
    }
}

