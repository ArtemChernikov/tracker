package ru.job4j.stream;

/**
 * Класс модели профиля со свойством <b>address</b>
 * Применяется класс {@link Address}
 *
 * @author ARTEM CHERNIKOV
 * @version 1.0
 */
public class Profile {
    /**
     * Поле адрес
     */
    private Address address;

    /**
     * Конструктор - создание нового объекта с определенными значениями
     *
     * @param address - адрес
     */
    public Profile(Address address) {
        this.address = address;
    }

    /**
     * Метод получения значения поля {@link Profile#address}
     *
     * @return - адрес
     */
    public Address getAddress() {
        return address;
    }
}
