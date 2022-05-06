package ru.job4j.stream;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Класс описывает применение Stream API для работы с коллекциями
 * Используется класс {@link Student}
 *
 * @author ARTEM CHERNIKOV
 * @version 1.0
 */
public class ListToMap {
    /**
     * Метод описывает конвертацию входящего списка студентов
     * в карту {@link LinkedHashMap}, где key - фамилия студента,
     * а value - объект студента
     * Если возникают совпадающие ключи (фамилии),
     * то используется уже существующий ключ
     *
     * @param list - список студентов
     * @return - карта {@link LinkedHashMap} студентов
     */
    public static Map<String, Student> convert(List<Student> list) {
        return list.stream()
                .collect(Collectors.toMap(Student::getSurname,
                        e -> e,
                        (existing, replacement) -> existing,
                        LinkedHashMap::new
                ));
    }
}
