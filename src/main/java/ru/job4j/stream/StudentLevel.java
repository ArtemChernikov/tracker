package ru.job4j.stream;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Класс описывает применение Stream API для работы с коллекциями
 * Используется класс {@link Student}
 *
 * @author ARTEM CHERNIKOV
 * @version 1.0
 */
public class StudentLevel {
    /**
     * Метод описывает сортировку списка студентов,
     * балл которых выше определенного значения и собирает их в отдельный список
     * В исходном списке допускаются элементы null
     *
     * @param students - список студентов
     * @param bound    - порог успеваемости
     * @return - результирующий список
     */
    public static List<Student> levelOf(List<Student> students, int bound) {
        return students.stream()
                .flatMap(Stream::ofNullable)
                .sorted((left, right) -> Integer.compare(right.getScore(), left.getScore()))
                .takeWhile(st -> st.getScore() > bound)
                .collect(Collectors.toList());
    }
}
