package ru.job4j.lambda;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

/**
 * Класс выводит на консоль список имен и
 * описывает применение упрощенного лямбда выражения за счет оператора (::)
 *
 * @author ARTEM CHERNIKOV
 * @version 1.0
 */
public class RefMethod {
    public static void main(String[] args) {
        List<String> names = Arrays.asList(
                "Ivan",
                "Petr Arsentev"
        );
        Consumer<String> out = RefMethod::cutOut;
        names.forEach(out);
    }

    /**
     * Метод описывает вывод имени в консоль, которое меньше 10 символов,
     * если имя больше 10 символов, то вывод обрезается до 10 символов
     *
     * @param value - имя
     */
    public static void cutOut(String value) {
        if (value.length() > 10) {
            System.out.println(value.substring(0, 10) + "..");
        } else {
            System.out.println(value);
        }
    }
}
