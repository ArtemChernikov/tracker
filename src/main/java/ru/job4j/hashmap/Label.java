package ru.job4j.hashmap;

/**
 * @author Artem Chernikov
 * @version 1.0
 * @since 20.01.2024
 */
public record Label(String name, double score) implements Comparable<Label> {
    @Override
    public int compareTo(Label o) {
        return Double.compare(this.score, o.score);
    }
}
