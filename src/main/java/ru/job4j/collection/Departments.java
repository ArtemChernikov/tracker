package ru.job4j.collection;

import java.util.*;

/**
 * Класс описывает список подразделений
 *
 * @author ARTEM CHERNIKOV
 * @version 1.0
 */
public class Departments {
    /**
     * Метод описывает деление списка департаментов на подразделения
     * Создается множество для временного хранения
     * Пробегаемся по списку и каждый элемент разбиваем по "/"
     * Если элемент цикла эквивалентен "", то добавляем его во множество
     * иначе добавляем start + "/" + el
     *
     * @param deps - список департаментов
     * @return - массив уникальных одиночных элементов
     */
    public static List<String> fillGaps(List<String> deps) {
        Set<String> tmp = new LinkedHashSet<>();
        for (String value : deps) {
            String start = "";
            for (String el : value.split("/")) {
                start += "".equals(start) ? el : "/" + el;
                tmp.add(start);
            }
        }
        return new ArrayList<>(tmp);
    }

    /**
     * Метод сортирует по возрастанию список департаментов
     *
     * @param orgs - список департаментов
     */
    public static void sortAsc(List<String> orgs) {
        Collections.sort(orgs);
    }

    /**
     * Метод сортирует входящий список по убыванию
     *
     * @param orgs - список департаментов
     */
    public static void sortDesc(List<String> orgs) {
        orgs.sort(new DepDescComp());
    }
}
