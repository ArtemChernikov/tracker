package ru.job4j.inheritance;

public class Builder extends Engineer {
    private int structuries;

    public Builder(String name, String surname, String education, String birthday, int architecturies, int structuries) {
        super(name, surname, education, birthday, architecturies);
        this.structuries = structuries;
    }

    public void build(int structuries) {

    }
}
