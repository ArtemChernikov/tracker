package ru.job4j.poly;

public class Bus implements Transport {
    @Override
    public void ride() {
        System.out.println("Bus rides");
    }

    @Override
    public void passengers(int passengers) {
        System.out.println("Number of passengers on the bus: " + passengers);
    }

    @Override
    public double refuel(double fuel) {
        double price = 2.5;
        return fuel * price;
    }
}
