package ru.job4j.tracker;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class ItemAscByNameTest {

    @Test
    public void compare() {
        List<Item> list = new ArrayList<>();
        Item item1 = new Item(1, "Fedor");
        Item item2 = new Item(2, "Petr");
        Item item3 = new Item(3, "Artem");
        list.add(item1);
        list.add(item2);
        list.add(item3);
        Collections.sort(list, new ItemAscByName());
        List<Item> expected = List.of(item3, item1, item2);
        assertEquals(list, expected);
    }
}