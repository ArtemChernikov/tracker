package ru.job4j.stream;

import java.util.Objects;

/**
 * Класс модели адреса со свойствами <b>city</b>, <b>street</b>, <b>home</b> и <b>apartment</b>
 *
 * @author ARTEM CHERNIKOV
 * @version 1.1
 */
public class Address {
    /**
     * Поле город
     */
    private String city;
    /**
     * Поле улица
     */
    private String street;
    /**
     * Поле дом
     */
    private int home;
    /**
     * Поле квартира
     */
    private int apartment;

    /**
     * Конструктор - создание нового объекта с определенными значениями
     *
     * @param city      - город
     * @param street    - улица
     * @param home      - дом
     * @param apartment - квартира
     */
    public Address(String city, String street, int home, int apartment) {
        this.city = city;
        this.street = street;
        this.home = home;
        this.apartment = apartment;
    }

    /**
     * Метод получения значения поля {@link Address#city}
     *
     * @return - город
     */
    public String getCity() {
        return city;
    }

    /**
     * Переопределенный метод, для корректного сравнения объектов
     *
     * @param o - другой адрес
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
        Address address = (Address) o;
        return home == address.home
                && apartment == address.apartment
                && Objects.equals(city, address.city)
                && Objects.equals(street, address.street);
    }

    /**
     * Переопределенный метод, для корректного сравнения объектов
     *
     * @return возвращает hashcode объекта
     */
    @Override
    public int hashCode() {
        return Objects.hash(city, street, home, apartment);
    }
}
