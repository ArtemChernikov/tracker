package ru.job4j.function;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class FunctionRangeTest {

    @Test
    public void whenLinearFunctionThenLinearResults() {
        List<Double> result = FunctionRange.diapason(5, 8, x -> 2 * x + 1);
        List<Double> expected = Arrays.asList(11D, 13D, 15D);
        assertThat(result, is(expected));
    }

    @Test
    public void whenQuadraticFunctionThenQuadraticResults() {
        List<Double> result = FunctionRange.diapason(3, 6, x -> 2 + Math.pow(x, 2) + 2);
        List<Double> expected = Arrays.asList(13D, 20D, 29D);
        assertThat(result, is(expected));
    }

    @Test
    public void whenDemonstrationFunctionThenDemonstrationResults() {
        List<Double> result = FunctionRange.diapason(3, 6, x -> Math.pow(2, x) + 4);
        List<Double> expected = Arrays.asList(12D, 20D, 36D);
        assertThat(result, is(expected));
    }
}