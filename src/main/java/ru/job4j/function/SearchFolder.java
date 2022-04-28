package ru.job4j.function;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

/**
 * Класс для поиска определенной папки
 *
 * @author ARTEM CHERNIKOV
 * @version 1.0
 */
public class SearchFolder {
    /**
     * Метод позволяет найти определенный элемент (папку)
     * и добавить ее в коллекцию, с помощью функционального интерфейса и его метода {@link Predicate#test(Object)}
     *
     * @param list - список папок
     * @param pred - функциональный интерфейс {@link Predicate}
     * @return - новый список с нужными нам (отфильтрованными) элементами
     */
    public static List<Folder> filter(List<Folder> list, Predicate<Folder> pred) {
        List<Folder> rsl = new ArrayList<>();
        for (Folder folder : list) {
            if (pred.test(folder)) {
                rsl.add(folder);
            }
        }
        return rsl;
    }
}
