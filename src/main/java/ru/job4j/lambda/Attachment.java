package ru.job4j.lambda;

/**
 * Класс модели вложения со свойствами <b>name</b> и <b>size</b>.
 *
 * @author ARTEM CHERNIKOV
 * @version 1.0
 */
public class Attachment {
    /**
     * Поле имя
     */
    private String name;
    /**
     * Поле размер
     */
    private int size;

    /**
     * Конструктор - создание нового объекта с определенными значениями.
     *
     * @param name - имя
     * @param size - размер
     */
    public Attachment(String name, int size) {
        this.name = name;
        this.size = size;
    }

    /**
     * Метод получения значения поля {@link Attachment#name}
     *
     * @return - возвращает имя вложения
     */
    public String getName() {
        return name;
    }

    /**
     * Метод получения значения поля {@link Attachment#size}
     *
     * @return - возвращает размер вложения
     */
    public int getSize() {
        return size;
    }

    /**
     * Переопределяем метод для лучшего вывода нашего объекта
     *
     * @return - возвращает строку с выводом объекта
     */
    @Override
    public String toString() {
        return "{"
                + "name='" + name + '\''
                + ", size=" + size
                + '}';
    }
}
