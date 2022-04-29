package ru.job4j.search;

/**
 * Класс модели человека со свойствами <b>name</b>, <b>surname</b>, <b>phone</b> и <b>address</b>.
 *
 * @author ARTEM CHERNIKOV
 * @version 1.0
 */
public class Person {
    /**
     * Поле имя
     */
    private String name;
    /**
     * Поле фамилия
     */
    private String surname;
    /**
     * Поле номер телефона
     */
    private String phone;
    /**
     * Поле адрес проживания
     */
    private String address;

    /**
     * Конструктор - создание нового объекта с определенными значениями
     *
     * @param name    - имя
     * @param surname - фамилия
     * @param phone   - номер телефона
     * @param address - адрес
     */
    public Person(String name, String surname, String phone, String address) {
        this.name = name;
        this.surname = surname;
        this.phone = phone;
        this.address = address;
    }

    /**
     * Метод получения значения поля {@link Person#name}
     *
     * @return - возвращает имя человека
     */
    public String getName() {
        return name;
    }

    /**
     * Метод получения значения поля {@link Person#surname}
     *
     * @return - возвращает фамилию человека
     */
    public String getSurname() {
        return surname;
    }

    /**
     * Метод получения значения поля {@link Person#phone}
     *
     * @return - возвращает номер телефона человека
     */
    public String getPhone() {
        return phone;
    }

    /**
     * Метод получения значения поля {@link Person#address}
     *
     * @return - возвращает адрес человека
     */
    public String getAddress() {
        return address;
    }
}
