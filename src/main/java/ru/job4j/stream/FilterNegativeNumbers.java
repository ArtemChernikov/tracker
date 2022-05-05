package ru.job4j.stream;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Класс описывает применение Stream API для работы с коллекциями
 *
 * @author ARTEM CHERNIKOV
 * @version 1.0
 */
public class FilterNegativeNumbers {
    /**
     * Метод описывает фильтрацию положительных чисел
     * и дальнейшим помещением их в результирующий список
     * при промощи стримов
     *
     * @param args - аргументы командной строки
     */
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(1, -4, 3, 22, -10, -15, -2, 3, 0);
        List<Integer> positive = numbers.stream().filter(x -> x > 0).collect(Collectors.toList());
        positive.forEach(System.out::println);
    }
}
