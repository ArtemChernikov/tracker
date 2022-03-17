package ru.job4j.oop;

public class Cat {
    private String food;
    private String name;

    public String sound() {
        return "may-may";
    }

    public void show() {
        System.out.println("Cat's name: " + this.name);
        System.out.println(this.name + " ate a " + this.food);
    }

    public void eat(String meat) {
        this.food = meat;
    }

    public void giveNick(String nick) {
        this.name = nick;
    }

    public static void main(String[] args) {
        Cat gav = new Cat();
        gav.giveNick("gav");
        gav.eat("kotleta");
        gav.show();
        Cat black = new Cat();
        black.giveNick("black");
        black.eat("fish");
        black.show();
    }
}
