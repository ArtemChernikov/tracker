package ru.job4j.collection;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.greaterThan;

public class JobTest {

    @Test
    public void whenComparatorDescByNameAndPriority() {
        Comparator<Job> cmpNamePriority = new CompareDescByName().thenComparing(new CompareDescByPriority());
        int rsl = cmpNamePriority.compare(
                new Job("Impl task", 0),
                new Job("Impl task", 1)
        );
        assertThat(rsl, greaterThan(0));
    }

    @Test
    public void whenComparatorAscByNameAndPriority() {
        Comparator<Job> comparator = new CompareAscByName().thenComparing(new CompareAscByPriority());
        int rsl = comparator.compare(
                new Job("Fix Bug", 5),
                new Job("Fix Bug", 1)
        );
        assertThat(rsl, greaterThan(0));
    }

    @Test
    public void whenComparatorAscByNameAndDescByPriority() {
        Comparator<Job> comparator = new CompareAscByName().thenComparing(new CompareDescByPriority());
        int rsl = comparator.compare(
                new Job("Fix Bug", 3),
                new Job("Fix Bug", 5)
        );
        assertThat(rsl, greaterThan(0));
    }

    @Test
    public void whenComparatorDescByNameAndAscByPriority() {
        Comparator<Job> comparator = new CompareDescByName().thenComparing(new CompareAscByPriority());
        int rsl = comparator.compare(
                new Job("Fix Bug", 3),
                new Job("Fix Bug", 1)
        );
        assertThat(rsl, greaterThan(0));
    }

    @Test
    public void whenComparatorAscByName() {
        Job job1 = new Job("Xaviering", 2);
        Job job2 = new Job("Feramiring", 2);
        Job job3 = new Job("Exceling", 2);
        List<Job> list = new ArrayList<>();
        list.add(job1);
        list.add(job2);
        list.add(job3);
        Collections.sort(list, new CompareAscByName());
        List<Job> expected = List.of(job3, job2, job1);
        assertThat(list, is(expected));
    }

    @Test
    public void whenComparatorAscByPriority() {
        Job job1 = new Job("Xaviering", 3);
        Job job2 = new Job("Feramiring", 4);
        Job job3 = new Job("Exceling", 1);
        List<Job> list = new ArrayList<>();
        list.add(job1);
        list.add(job2);
        list.add(job3);
        Collections.sort(list, new CompareAscByPriority());
        List<Job> expected = List.of(job3, job1, job2);
        assertThat(list, is(expected));
    }

    @Test
    public void whenComparatorDescByName() {
        Job job1 = new Job("Xaviering", 3);
        Job job2 = new Job("Feramiring", 4);
        Job job3 = new Job("Exceling", 1);
        List<Job> list = new ArrayList<>();
        list.add(job1);
        list.add(job3);
        list.add(job2);
        Collections.sort(list, new CompareDescByName());
        List<Job> expected = List.of(job1, job2, job3);
        assertThat(list, is(expected));
    }

    @Test
    public void whenComparatorDescByPriority() {
        Job job1 = new Job("Xaviering", 3);
        Job job2 = new Job("Feramiring", 4);
        Job job3 = new Job("Exceling", 1);
        List<Job> list = new ArrayList<>();
        list.add(job1);
        list.add(job3);
        list.add(job2);
        Collections.sort(list, new CompareDescByPriority());
        List<Job> expected = List.of(job2, job1, job3);
        assertThat(list, is(expected));
    }
}