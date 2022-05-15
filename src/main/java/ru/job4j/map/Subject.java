package ru.job4j.map;

import java.util.Objects;

/**
 * Класс описывает медель предмета со свойствами <b>name</b> и <b>score</b>
 *
 * @author ARTEM CHERNIKOV
 * @version 1.0
 */
public class Subject {
    /**
     * Поле названия предмета
     */
    private String name;
    /**
     * Поле баллы предмета
     */
    private int score;

    /**
     * Конструктор - создание нового объекта с определенными значениями
     *
     * @param name- имя
     * @param score - баллы
     */
    public Subject(String name, int score) {
        this.name = name;
        this.score = score;
    }

    /**
     * Метод получения значения поля {@link Subject#name}
     *
     * @return возвращает имя студента
     */
    public String getName() {
        return name;
    }

    /**
     * Метод получения значения поля {@link Subject#score}
     *
     * @return возвращает имя студента
     */
    public int getScore() {
        return score;
    }

    /**
     * Переопределенный метод, для корректного сравнения объектов
     *
     * @param o - другой предмет
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
        Subject subject = (Subject) o;
        return Objects.equals(name, subject.name);
    }

    /**
     * Переопределенный метод, для корректного сравнения объектов
     *
     * @return возвращает hashcode объекта
     */
    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}
