package ru.job4j.collection;

import java.util.Comparator;

/**
 * Класс описывает сортировку департаментов
 * Используется в классе {@link Departments}
 *
 * @author ARTEM CHERNIKOV
 * @version 1.0
 */
public class DepDescComp implements Comparator<String> {
    /**
     * Метод сортирует элементы по убыванию
     * 1. Создаются 2 массива со строками, которые были разбиты методом split("/")
     * 2. Сравниваем первые элементы полученных массивов методом compareTo()
     * 3. Если элементы равны, то сравниеваем следующие элементы, но уже в возрастающем порядке
     *
     * @param o1 - первая входящая строка
     * @param o2 - вторая входящая строка
     * @return - результат сравнения элементов (либо в убывающем порядке, либо в возрастающем)
     */
    @Override
    public int compare(String o1, String o2) {
        String[] ar1 = o1.split("/");
        String[] ar2 = o2.split("/");
        int result = ar2[0].compareTo(ar1[0]);
        return result == 0 ? o1.compareTo(o2) : result;
    }
}
