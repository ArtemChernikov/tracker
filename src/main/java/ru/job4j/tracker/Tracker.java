package ru.job4j.tracker;

import java.util.Arrays;

public class Tracker {
    private final Item[] items = new Item[100];
    private int ids = 1;
    private int size = 0;

    public Item add(Item item) {
        item.setId(ids++);
        items[size++] = item;
        return item;
    }

    public Item findById(int id) {
        Item rsl = null;
        for (int index = 0; index < size; index++) {
            Item item = items[index];
            if (item.getId() == id) {
                rsl = item;
                break;
            }
        }
        return rsl;
    }

    public Item[] findAll() {
        Item[] rsl = new Item[items.length];
        int len = 0;
        for (int i = 0; i < size; i++) {
            if (items[i] != null) {
                rsl[len++] = items[i];
            }
        }
        return Arrays.copyOf(rsl, len);
    }

    Item[] findByName(String key) {
        Item[] rsl = Arrays.copyOf(items, size);
        int len = 0;
        for (int i = 0; i < rsl.length; i++) {
            if (rsl[i].getName().equals(key)) {
                rsl[len++] = rsl[i];
            }
        }
        return Arrays.copyOf(rsl, len);
    }
}