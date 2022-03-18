package ru.job4j.inheritance;

public class Surgeon extends Doctor {
    private int scalpels;

    public Surgeon(String name, String surname, String education, String birthday, boolean phD, int scalpels) {
        super(name, surname, education, birthday, phD);
        this.scalpels = scalpels;
    }

    public void cutLeg(int scalpels) {

    }
}
