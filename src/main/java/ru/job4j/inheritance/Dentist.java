package ru.job4j.inheritance;

public class Dentist extends Doctor {
    private int implants;

    public Dentist(String name, String surname, String education, String birthday, boolean phD, int implants) {
        super(name, surname, education, birthday, phD);
        this.implants = implants;
    }

    public void treatTeeth(int implants) {

    }
}
