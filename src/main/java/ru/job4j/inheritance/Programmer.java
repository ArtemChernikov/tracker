package ru.job4j.inheritance;

public class Programmer extends Engineer {
    private String technology;

    public Programmer(String name, String surname, String education, String birthday, int architecturies, String technology) {
        super(name, surname, education, birthday, architecturies);
        this.technology = technology;
    }

    public void develop(String technology) {

    }
}
