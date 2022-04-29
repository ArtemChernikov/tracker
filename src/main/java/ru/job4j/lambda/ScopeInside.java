package ru.job4j.lambda;

import java.util.function.Supplier;

/**
 * Класс описывает подсчет и вывод суммы чисел в массиве в консоль
 *
 * @author ARTEM CHERNIKOV
 * @version 1.1
 */
public class ScopeInside {
    public static void main(String[] args) {
        int[] number = {1, 2, 3};
        int total = 0;
        for (int num : number) {
            int finalTotal = total;
            total = add(
                    () -> finalTotal + num
            );
        }
        System.out.println(total);
    }

    /**
     * Метод описывает получение значения с помощью
     * функционального интерфейса {@link Supplier} и его метода {@link Supplier#get()}
     *
     * @param calc - {@link Supplier}
     * @return - возвращает число с помощью метода {@link Supplier#get()}
     */
    private static Integer add(Supplier<Integer> calc) {
        return calc.get();
    }
}
