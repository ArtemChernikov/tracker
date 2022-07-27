package ru.job4j.tracker;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class ItemDescByNameTest {

    @Test
    public void compare() {
        List<Item> list = new ArrayList<>();
        Item item1 = new Item(1, "Fedor");
        Item item2 = new Item(2, "Petr");
        Item item3 = new Item(3, "Artem");
        list.add(item1);
        list.add(item2);
        list.add(item3);
        Collections.sort(list, new ItemDescByName());
        List<Item> expected = List.of(item2, item1, item3);
        assertThat(list, is(expected));
    }
}