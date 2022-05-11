package ru.job4j.stream;

import java.time.LocalDate;

/**
 * Класс модели автомобиля со свойствами <b>brand</b>, <b>model</b>, <b>created</b>,
 * <b>volume</b> и <b>color</b>
 *
 * @author ARTEM CHERNIKOV
 * @version 1.0
 */
public class Car {
    /**
     * Поле бренд
     */
    private String brand;
    /**
     * Поле модель
     */
    private String model;
    /**
     * Поле дата выпуска
     */
    private LocalDate created;
    /**
     * Поле объем двигателя
     */
    private double volume;
    /**
     * Поле цвет
     */
    private String color;

    /**
     * Переопределяем метод {@link Object#toString()}
     * для наилучшего вывода свойств объекта {@link Car} в консоль
     *
     * @return - свойства объекта {@link Car} в виде строки
     */
    @Override
    public String toString() {
        return "Car{"
                + "brand='" + brand + '\''
                + ", model='" + model + '\''
                + ", created=" + created
                + ", volume=" + volume
                + ", color='" + color + '\''
                + '}';
    }

    /**
     * Вложенный статический класс {@link Builder}
     * для реализации шаблона проектирования Builder
     */
    static class Builder {
        /**
         * Поле бренд
         */
        private String brand;
        /**
         * Поле модель
         */
        private String model;
        /**
         * Поле дата выпуска
         */
        private LocalDate created;
        /**
         * Поле объем двигателя
         */
        private double volume;
        /**
         * Поле цвет
         */
        private String color;

        /**
         * Метод присваивания значения полю {@link Builder#brand}
         *
         * @param brand - бренд автомобиля
         * @return - возвращает объект {@link Builder}
         */
        Builder buildBrand(String brand) {
            this.brand = brand;
            return this;
        }

        /**
         * Метод присваивания значения полю {@link Builder#model}
         *
         * @param model - модель автомобиля
         * @return - возвращает объект {@link Builder}
         */
        Builder buildModel(String model) {
            this.model = model;
            return this;
        }

        /**
         * Метод присваивания значения полю {@link Builder#created}
         *
         * @param created - дата выпуска автомобиля
         * @return - возвращает объект {@link Builder}
         */
        Builder buildCreated(LocalDate created) {
            this.created = created;
            return this;
        }

        /**
         * Метод присваивания значения полю {@link Builder#volume}
         *
         * @param volume - объем двигателя автомобиля
         * @return - возвращает объект {@link Builder}
         */
        Builder buildVolume(double volume) {
            this.volume = volume;
            return this;
        }

        /**
         * Метод присваивания значения полю {@link Builder#color}
         *
         * @param color - цвет автомобиля
         * @return - возвращает объект {@link Builder}
         */
        Builder buildColor(String color) {
            this.color = color;
            return this;
        }

        /**
         * Метод создания автомобиля с определенными параметрами
         *
         * @return - возвращает автомобиль {@link Car}
         */
        Car build() {
            Car car = new Car();
            car.brand = brand;
            car.color = color;
            car.volume = volume;
            car.model = model;
            car.created = created;
            return car;
        }
    }

    /**
     * Метод описывает демонстрацию создания объектов
     * с помощью шаблона проектирования Builder
     *
     * @param args - аргументы командной строки
     */
    public static void main(String[] args) {
        Car car = new Builder()
                .buildBrand("Toyota")
                .buildModel("Camry")
                .buildCreated(LocalDate.of(2021, 6, 1))
                .buildVolume(2.5)
                .buildColor("Red")
                .build();
        System.out.println(car);

        Car myCar = new Builder()
                .buildBrand("Porsche")
                .buildColor("Yellow")
                .buildModel("Cayenne")
                .buildCreated(LocalDate.of(2021, 6, 18))
                .build();
        System.out.println(myCar);
    }
}
