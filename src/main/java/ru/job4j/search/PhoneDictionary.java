package ru.job4j.search;

import java.util.ArrayList;
import java.util.function.Predicate;

/**
 * Класс описывает записную книгу с контактами
 * Используется класс {@link Person}
 *
 * @author ARTEM CHERNIKOV
 * @version 1.1
 */
public class PhoneDictionary {
    /**
     * Список людей в записной книге
     */
    private ArrayList<Person> persons = new ArrayList<>();

    /**
     * Метод для добавления людей в книгу
     *
     * @param person - человек
     */
    public void add(Person person) {
        this.persons.add(person);
    }

    /**
     * Метод описывает поиск всех людей в книге по определенному ключу
     * Метод выполнен с помощью интерфейса {@link Predicate}
     * который используется для подбора людей и дальнейшей вставке их в результирующий список
     *
     * @param key - ключевое слово, по которому ищем людей
     * @return - возвращает список всех найденных людей
     */
    public ArrayList<Person> find(String key) {
        Predicate<Person> phone = person -> person.getPhone().contains(key);
        Predicate<Person> address = person -> person.getAddress().contains(key);
        Predicate<Person> name = person -> person.getName().contains(key);
        Predicate<Person> surname = person -> person.getSurname().contains(key);
        Predicate<Person> combine = phone.or(address.or(name.or(surname)));
        ArrayList<Person> result = new ArrayList<>();
        for (var person : persons) {
            if (combine.test(person)) {
                result.add(person);
            }
        }
        return result;
    }
}
