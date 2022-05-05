package ru.job4j.stream;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Класс демонстрирует использование Stream API для работы с коллекцияи
 * Применяется класс {@link Address} и {@link Profile}
 *
 * @author ARTEM CHERNIKOV
 * @version 1.0
 */
public class Profiles {
    /**
     * Метод осуществляет выборку адресов из профилей в список
     *
     * @param profiles - список профилей
     * @return - список адресов
     */
    public static List<Address> collect(List<Profile> profiles) {
        return profiles.stream()
                .map(Profile::getAddress)
                .collect(Collectors.toList());
    }
}
