package ru.job4j.function;

import java.util.Objects;

/**
 * Класс модели папки со свойствами <b>name</b> и <b>size</b>
 *
 * @author ARTEM CHERNIKOV
 * @version 1.0
 */
public class Folder {
    /**
     * Поле название папки
     */
    private String name;
    /**
     * Поле размер папки
     */
    private int size;

    /**
     * Конструктор - создание нового объекта с определенными значениями
     *
     * @param name - имя папки
     * @param size - размер папки
     */
    public Folder(String name, int size) {
        this.name = name;
        this.size = size;
    }

    /**
     * Метод получения значения поля {@link Folder#name}
     *
     * @return возвращает название папки
     */
    public String getName() {
        return name;
    }

    /**
     * Метод получения значения поля {@link Folder#size}
     *
     * @return возвращает размер папки
     */
    public int getSize() {
        return size;
    }

    /**
     * Переопределенный метод, для корректного сравнения объектов
     *
     * @param o - другая папка
     * @return возвращает true, если объекты равны, false если нет
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Folder folder = (Folder) o;
        return size == folder.size && Objects.equals(name, folder.name);
    }

    /**
     * Переопределенный метод, для корректного сравнения объектов
     *
     * @return возвращает hashcode объекта
     */
    @Override
    public int hashCode() {
        return Objects.hash(name, size);
    }

    /**
     * Переопределяем метод для лучшего вывода в консоль нашего объекта
     *
     * @return - возвращает строку с выводом объекта
     */
    @Override
    public String toString() {
        return "Folder{"
                + "name='" + name + '\''
                + ", size=" + size
                + '}';
    }
}
