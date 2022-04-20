package ru.job4j.bank;

import java.util.Objects;

/**
 * Класс модели пользователя со свойствами <b>passport</b> и <b>username</b>.
 * @author ARTEM CHERNIKOV
 * @version 1.0
 */
public class User {
    /** Поле паспорт */
    private String passport;
    /** Поле имя пользователя */
    private String username;

    /**
     * Конструктор - создание нового объекта с определенными значениями.
     * @param passport - паспорт
     * @param username - имя пользователя
     */
    public User(String passport, String username) {
        this.passport = passport;
        this.username = username;
    }

    /**
     * Метод для получения значения поля {@link User#passport}
     * @return возвращает паспорт пользователя
     */
    public String getPassport() {
        return passport;
    }

    /**
     * Метод для определения номера паспорта пользователя {@link User#passport}
     * @param passport - паспорт
     */
    public void setPassport(String passport) {
        this.passport = passport;
    }

    /**
     * Метод для получения значения поля {@link User#username}
     * @return возвращает имя пользователя
     */
    public String getUsername() {
        return username;
    }

    /**
     * Метод для определения номера паспорта пользователя {@link User#username}
     * @param username - имя пользователя
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * Переопределенный метод, для корректного сравнения объектов
     * @param o - пользователь
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
        User user = (User) o;
        return Objects.equals(passport, user.passport);
    }

    /**
     * Переопределенный метод, для корректного сравнения объектов
     * @return возвращает hashcode объекта
     */
    @Override
    public int hashCode() {
        return Objects.hash(passport);
    }
}
