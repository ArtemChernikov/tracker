package ru.job4j.function;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

/**
 * Класс подсчета функции в диапазоне
 *
 * @author ARTEM CHERNIKOV
 * @version 1.0
 */
public class FunctionRange {
    /**
     * Метод организует подсчет функции в диапазоне и возвращает список с результатами
     * 1. Создаем список для результатов подсчетов для каждого элемента в диапазоне (кроме последнего)
     * 2. В цикле пробегаем от start до end (не включительно)
     * 3. С каждой итерацией добавляем результат функции (Double) в список
     *
     * @param start - старт (начальная точка)
     * @param end   - конец (конечная точка)
     * @param func  - функциональный интерфейс {@link Function}
     * @return - возвращает список с результатами
     */
    public static List<Double> diapason(int start, int end, Function<Double, Double> func) {
        List<Double> list = new ArrayList<>();
        for (int i = start; i < end; i++) {
            list.add(func.apply((double) i));
        }
        return list;
    }
}
