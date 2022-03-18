package ru.job4j.inheritance;

public class Engineer extends Profession {
    private int architecturies;

    public Engineer(String name, String surname, String education, String birthday, int architecturies) {
        super(name, surname, education, birthday);
        this.architecturies = architecturies;
    }

    public void repair(int architecturies) {

    }
}
