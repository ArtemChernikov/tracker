package ru.job4j.stream;

import java.util.stream.Stream;

/**
 * Перечисление мастей в виде {@link Enum}
 */
enum Suit {
    Diamonds, Hearts, Spades, Clubs
}

/**
 * Перечисление значений в виде {@link Enum}
 */
enum Value {
    V_6, V_7, V_8
}

/**
 * Класс модели карты из карточной колоды со свойствами <b>suit</b> и <b>value</b>.
 *
 * @author ARTEM CHERNIKOV
 * @version 1.0
 */

public class Card {
    /**
     * Поле масти карты
     */
    private Suit suit;
    /**
     * Поле значения карты
     */
    private Value value;

    /**
     * Конструктор - создание нового объекта с определенными значениями.
     *
     * @param suit  - масть
     * @param value - значение
     */
    public Card(Suit suit, Value value) {
        this.suit = suit;
        this.value = value;
    }

    /**
     * Переопределяем метод {@link Object#toString()}
     * для перобразования объекта и его полей в строку,
     * для вывода на консоль
     *
     * @return - строка
     */
    @Override
    public String toString() {
        return "Card{"
                + "suit=" + suit
                + ", value=" + value
                + '}';
    }

    /**
     * Метод описывает создание карточной колоды
     * с использованием StreamAPI
     *
     * @param args - аргументы командной строки
     */
    public static void main(String[] args) {
        Stream.of(Suit.values())
                .flatMap(suit -> Stream.of(Value.values())
                        .map(value -> new Card(suit, value)))
                .forEach(System.out::println);
    }
}
