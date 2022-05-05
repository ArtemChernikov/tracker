package ru.job4j.stream;

import java.util.Objects;

/**
 * Класс модели студента со свойствами <b>score</b> и <b>surname</b>
 *
 * @author ARTEM CHERNIKOV
 * @version 1.1
 */
public class Student {
    /**
     * Поле успеваемости студента
     */
    private int score;
    /**
     * Поле фамилии студента
     */
    private String surname;

    /**
     * Конструктор - создание нового объекта с определенными значениями
     *
     * @param score   - успеваемость
     * @param surname - фамилмя
     */
    public Student(int score, String surname) {
        this.score = score;
        this.surname = surname;
    }

    /**
     * Метод получения значения поля {@link Student#score}
     *
     * @return - успеваемость
     */
    public int getScore() {
        return score;
    }

    /**
     * Метод получения значения поля {@link Student#surname}
     *
     * @return - фамилия
     */
    public String getSurname() {
        return surname;
    }

    /**
     * Переопределенный метод {@link Object#equals(Object)}, для корректного сравнения объектов
     *
     * @param o - другой студент
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
        Student student = (Student) o;
        return score == student.score
                && Objects.equals(surname, student.surname);
    }

    /**
     * Переопределенный метод {@link Object#hashCode()}, для корректного сравнения объектов
     *
     * @return возвращает hashcode объекта
     */
    @Override
    public int hashCode() {
        return Objects.hash(score, surname);
    }

    /**
     * Переопределяем метод {@link Object#toString()} для корректного отображения объекта в консоли
     *
     * @return - возвращает строку с содержимым объекта
     */
    @Override
    public String toString() {
        return "Student{"
                + "score=" + score
                + ", surname='" + surname + '\''
                + '}';
    }
}
