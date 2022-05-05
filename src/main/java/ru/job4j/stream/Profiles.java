package ru.job4j.stream;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Класс демонстрирует использование Stream API для работы с коллекцияи
 * Применяется класс {@link Address} и {@link Profile}
 *
 * @author ARTEM CHERNIKOV
 * @version 1.1
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

    /**
     * Метод осуществляет выборку адресов из профилей в список
     * с дальнейшей сортировкой по городам, по возрастанию
     * и удалением дубликатов
     *
     * @param profiles - список профилей
     * @return - список адресов
     */
    public static List<Address> collectSortWithoutDuplicate(List<Profile> profiles) {
        return profiles.stream()
                .map(Profile::getAddress)
                .sorted(Comparator.comparing(Address::getCity))
                .distinct()
                .collect(Collectors.toList());
    }
}
