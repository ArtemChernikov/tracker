package ru.job4j.oop;

public class Transports {
    public static void main(String[] args) {
        Vehicle plane1 = new Plane();
        Vehicle plane2 = new Plane();
        Vehicle train1 = new Train();
        Vehicle train2 = new Train();
        Vehicle bus1 = new Bus();
        Vehicle bus2 = new Bus();
        Vehicle[] vehicles = new Vehicle[6];
        vehicles[0] = plane1;
        vehicles[1] = plane2;
        vehicles[2] = train1;
        vehicles[3] = train2;
        vehicles[4] = bus1;
        vehicles[5] = bus2;
        for (Vehicle vehicle : vehicles) {
            vehicle.move();
            vehicle.signal();
        }
    }
}
