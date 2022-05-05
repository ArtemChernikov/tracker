package ru.job4j.stream;

import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

/**
 * Класс описывает применение Stream API для работы с коллекциями
 * Используется класс {@link Student}
 *
 * @author ARTEM CHERNIKOV
 * @version 1.0
 */
public class School {
    /**
     * Метод описывает разделение студентов на группы при помощи
     * функционального интерфейса {@link Predicate}
     *
     * @param students - список студентов
     * @param predict  - функциональный интерфейс {@link Predicate}
     * @return - возвращает отсортированный список студентов
     */
    public List<Student> collect(List<Student> students, Predicate<Student> predict) {
        return students.stream()
                .filter(predict)
                .collect(Collectors.toList());
    }
}
