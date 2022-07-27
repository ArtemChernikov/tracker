package ru.job4j.ex;

import static org.junit.Assert.assertThrows;

import org.junit.jupiter.api.Test;

public class FactTest {

    @Test
    public void calc() {
        assertThrows(IllegalArgumentException.class, () -> Fact.calc(-1));
    }
}
