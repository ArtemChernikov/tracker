package ru.job4j.stream;

/**
 * Класс модели школьного предмета со свойствами <b>name</b> и <b>score</b>
 *
 * @author ARTEM CHERNIKOV
 * @version 1.0
 */
public class Subject {
    /**
     * Поле название предмета
     */
    private String name;
    /**
     * Поле аттестационный балл ученика по предмету
     */
    private int score;

    /**
     * Конструктор - создание нового объекта с определенными значениями
     *
     * @param name  - название
     * @param score - аттестационный балл
     */
    public Subject(String name, int score) {
        this.name = name;
        this.score = score;
    }

    /**
     * Метод получения значения поля {@link Subject#name}
     *
     * @return возвращает название школьного предмета
     */
    public String getName() {
        return name;
    }

    /**
     * Метод получения значения поля {@link Subject#score}
     *
     * @return возвращает аттестационный балл ученика по предмету
     */
    public int getScore() {
        return score;
    }
}
