package ru.job4j.stream;

import java.util.Objects;

/**
 * Класс модели аттестата со свойствами <b>name</b> и <b>score</b>
 * Этот класс используется как для {@link Subject}, так и для {@link Pupil}
 *
 * @author ARTEM CHERNIKOV
 * @version 1.0
 */
public class Tuple {
    /**
     * Поле имя ученика
     */
    private String name;
    /**
     * Поле аттестационный балл
     */
    private double score;

    /**
     * Конструктор - создание нового объекта с определенными значениями
     *
     * @param name  - название
     * @param score - аттестационный балл
     */
    public Tuple(String name, double score) {
        this.name = name;
        this.score = score;
    }

    /**
     * Метод получения значения поля {@link Tuple#name}
     *
     * @return возвращает имя ученика
     */
    public String getName() {
        return name;
    }

    /**
     * Метод получения значения поля {@link Tuple#score}
     *
     * @return возвращает аттестационный балл ученика
     */
    public double getScore() {
        return score;
    }

    /**
     * Переопределенный метод, для корректного сравнения объектов
     *
     * @param o - другой объект
     * @return возвращает true, если объекты равны, false если нет
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Tuple tuple = (Tuple) o;
        return Double.compare(tuple.score, score) == 0
                && Objects.equals(name, tuple.name);
    }

    /**
     * Переопределенный метод, для корректного сравнения объектов
     *
     * @return возвращает hashcode объекта
     */
    @Override
    public int hashCode() {
        return Objects.hash(name, score);
    }
}
