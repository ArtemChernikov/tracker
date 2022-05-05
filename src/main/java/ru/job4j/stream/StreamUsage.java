package ru.job4j.stream;

import java.util.List;

/**
 * Класс описывает применение Stream API для работы с коллекциями
 *
 * @author ARTEM CHERNIKOV
 * @version 1.0
 */
public class StreamUsage {
    /**
     * Класс описывает модель задачи со свойствами <b>name</b> и <b>spent</b>
     *
     * @author ARTEM CHERNIKOV
     * @version 1.0
     */
    public static class Task {
        /**
         * Поле имени задачи
         */
        private final String name;
        /**
         * Поле времени на задачу
         */
        private final long spent;

        /**
         * Конструктор - создание нового объекта с определенными значениями
         *
         * @param name  - имя
         * @param spent - время на задачу
         */
        public Task(String name, long spent) {
            this.name = name;
            this.spent = spent;
        }
    }

    /**
     * Метод описывает фильтрацию списка по имени и по времени отведенному на задачу
     *
     * @param args - аргументы командной строки
     */
    public static void main(String[] args) {
        List<Task> tasks = List.of(
                new Task("Bug #1", 10),
                new Task("Task #2", 20),
                new Task("Bug #3", 40)
        );
        tasks.stream()
                .filter(task -> task.name.contains("Bug"))
                .filter(task -> task.spent > 30)
                .map(task -> task.name + " " + task.spent)
                .forEach(System.out::println);
    }
}
