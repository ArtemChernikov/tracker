package ru.job4j.function;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.*;

/**
 * Класс описывает применение лямбда выражений
 * с помощью функциональных интерфейсов
 *
 * @author ARTEM CHERNIKOV
 * @version 1.0
 */
public class FunctionalInterfaces {
    public static void main(String[] args) {
        Map<Integer, String> map = new HashMap<>();
        /**
         * Используем интерфейс {@link BiConsumer} и его метод {@link BiConsumer#accept(Object, Object)}
         * для вставки элементов в {@link Map<Integer, String>}
         */
        BiConsumer<Integer, String> biCon = (num, str) -> map.put(num, str);
        biCon.accept(1, "one");
        biCon.accept(1, "one");
        biCon.accept(2, "two");
        biCon.accept(3, "three");
        biCon.accept(4, "four");
        biCon.accept(5, "five");
        biCon.accept(6, "six");
        biCon.accept(7, "seven");
        /**
         * Используем интерфейс {@link BiPredicate} и его метод {@link BiPredicate#test(Object, Object)}
         * для проверки условия
         */
        BiPredicate<Integer, String> biPred = (num, str) -> num % 2 == 0 || str.length() == 4;
        for (Integer i : map.keySet()) {
            if (biPred.test(i, map.get(i))) {
                System.out.println("key: " + i + " value: " + map.get(i));
            }
        }
        /**
         * Используем интерфейс {@link Supplier} и его метод {@link Supplier#get()}
         * для создания ArrayList со значениями map
         */
        Supplier<List<String>> sup = () -> new ArrayList<>(map.values());
        List<String> list = sup.get();
        /**
         * Используем интерфейс {@link Consumer} и его метод {@link Consumer#accept(Object)}
         * для вывода на экран элементов из ArrayList
         */
        Consumer<String> con = (s) -> System.out.println(s);
        /**
         * Используем интерфейс {@link Function} и его метод {@link Function#apply(Object)}
         * для преобразования строк к верхнему регистру
         */
        Function<String, String> func = (str) -> str.toUpperCase();
        for (String s : list) {
            con.accept(func.apply(s));
        }
    }
}
