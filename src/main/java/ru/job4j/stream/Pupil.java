package ru.job4j.stream;

import java.util.List;

/**
 * Класс модели ученика со свойствами <b>name</b> и <b>subjects</b>
 * Используется класс {@link Subject}
 *
 * @author ARTEM CHERNIKOV
 * @version 1.0
 */
public class Pupil {
    /**
     * Поле имя ученика
     */
    private String name;
    /**
     * Поле список школьных предметов ученика
     */
    private List<Subject> subjects;

    /**
     * Конструктор - создание нового объекта с определенными значениями
     *
     * @param name     - имя
     * @param subjects - школьные предметы
     */
    public Pupil(String name, List<Subject> subjects) {
        this.name = name;
        this.subjects = subjects;
    }

    /**
     * Метод получения значения поля {@link Pupil#name}
     *
     * @return возвращает имя ученика
     */
    public String getName() {
        return name;
    }

    /**
     * Метод получения значения поля {@link Pupil#subjects}
     *
     * @return возвращает список предметов ученика
     */
    public List<Subject> getSubjects() {
        return subjects;
    }
}
