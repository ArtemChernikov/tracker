package ru.job4j.bank;

import java.util.Objects;

/**
 * Класс модели банковского счета со свойствами <b>requisite</b> и <b>balance</b>
 * @author ARTEM CHERNIKOV
 * @version 1.0
 */
public class Account {
    /** Поле реквизиты */
    private String requisite;
    /** Поле баланс  */
    private double balance;

    /**
     * Конструктор - создание нового объекта с определенными значениями
     * @param requisite - реквизиты
     * @param balance - баланс
     */
    public Account(String requisite, double balance) {
        this.requisite = requisite;
        this.balance = balance;
    }

    /**
     * Метод получения значения поля {@link Account#requisite}
     * @return возвращает реквизиты банковского счета
     */
    public String getRequisite() {
        return requisite;
    }

    /**
     * Метод для определения реквизитов банковского счета {@link Account#requisite}
     * @param requisite - реквизиты
     */
    public void setRequisite(String requisite) {
        this.requisite = requisite;
    }

    /**
     * Метод для получения значения поля {@link Account#balance}
     * @return возвращает баланс банковского счета
     */
    public double getBalance() {
        return balance;
    }

    /**
     * Метод для определения баланса банковского счета {@link Account#balance}
     * @param balance - баланс
     */
    public void setBalance(double balance) {
        this.balance = balance;
    }

    /**
     * Переопределенный метод, для корректного сравнения объектов
     * @param o - другой аккаунт
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
        Account account = (Account) o;
        return Objects.equals(requisite, account.requisite);
    }

    /**
     * Переопределенный метод, для корректного сравнения объектов
     * @return возвращает hashcode объекта
     */
    @Override
    public int hashCode() {
        return Objects.hash(requisite);
    }
}
