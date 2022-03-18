package ru.job4j.inheritance;

public class Doctor extends Profession {
    private boolean phD;

    public Doctor(String name, String surname, String education, String birthday, boolean phD) {
        super(name, surname, education, birthday);
        this.phD = phD;
    }

    public void study() {

    }
}
