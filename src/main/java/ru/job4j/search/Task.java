package ru.job4j.search;

/**
 * Класс модели задач со свойствами <b>desk</b> и <b>priority</b>.
 *
 * @author ARTEM CHERNIKOV
 * @version 1.0
 */
public class Task {
    /**
     * Поле описание задачи
     */
    private String desc;
    /**
     * Поле приоритет задачи
     */
    private int priority;

    /**
     * Конструктор - создание нового объекта с определенными значениями
     *
     * @param desc     - описание
     * @param priority - приоритет
     */
    public Task(String desc, int priority) {
        this.desc = desc;
        this.priority = priority;
    }

    /**
     * Метод получения значения поля {@link Task#desc}
     *
     * @return - возвращает описание задачи
     */
    public String getDesc() {
        return desc;
    }

    /**
     * Метод получения значения поля {@link Task#priority}
     *
     * @return - возвращает поле приоритет задачи
     */
    public int getPriority() {
        return priority;
    }
}
