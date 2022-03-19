package ru.job4j.pojo;

import java.time.LocalDate;

public class Student {
    private String fullName;
    private int group;
    private LocalDate dateOfAdmission;

    public String getFullName() {
        return fullName;
    }

    public int getGroup() {
        return group;
    }

    public LocalDate getDateOfAdmission() {
        return dateOfAdmission;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public void setGroup(int group) {
        this.group = group;
    }

    public void setDateOfAdmission(LocalDate dateOfAdmission) {
        this.dateOfAdmission = dateOfAdmission;
    }
}
