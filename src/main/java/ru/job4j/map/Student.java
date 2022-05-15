package ru.job4j.map;

import java.util.Objects;

/**
 * Класс описывает медель студента со свойствами <b>name</b>, <b>account</b> и <b>group</b>
 *
 * @author ARTEM CHERNIKOV
 * @version 1.0
 */
public class Student {
    /**
     * Поле имени
     */
    private String name;
    /**
     * Поле аккаунта
     */
    private String account;
    /**
     * Поле группы
     */
    private String group;

    /**
     * Конструктор - создание нового объекта с определенными значениями
     *
     * @param name - имя
     * @param account - аккаунт
     * @param group - группа
     */
    public Student(String name, String account, String group) {
        this.name = name;
        this.account = account;
        this.group = group;
    }

    /**
     * Метод получения значения поля {@link Student#name}
     *
     * @return возвращает имя студента
     */
    public String getName() {
        return name;
    }

    /**
     * Метод получения значения поля {@link Student#account}
     *
     * @return возвращает аккаунт студента
     */
    public String getAccount() {
        return account;
    }

    /**
     * Метод получения значения поля {@link Student#group}
     *
     * @return возвращает группу студента
     */
    public String getGroup() {
        return group;
    }

    /**
     * Переопределенный метод, для корректного сравнения объектов
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
        return Objects.equals(account, student.account);
    }

    /**
     * Переопределенный метод, для корректного сравнения объектов
     *
     * @return возвращает hashcode объекта
     */
    @Override
    public int hashCode() {
        return Objects.hash(account);
    }
}
