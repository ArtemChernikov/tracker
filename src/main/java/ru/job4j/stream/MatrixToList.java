package ru.job4j.stream;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Класс описывает применение Stream API
 *
 * @author ARTEM CHERNIKOV
 * @version 1.0
 */
public class MatrixToList {
    /**
     * Метод выполняет преобразование двумерного массива в список
     *
     * @param matrix - двумерный массив
     * @return - список
     */
    public static List<Integer> convert(Integer[][] matrix) {
        return Stream.of(matrix)
                .flatMap(Stream::of)
                .collect(Collectors.toList());
    }
}
