package ru.job4j.pojo;

import java.time.LocalDate;

public class College {
    public static void main(String[] args) {
        Student student = new Student();
        student.setFullName("Chernikov Artem");
        student.setGroup(3);
        student.setDateOfAdmission(LocalDate.now());
        System.out.println("Full name: " + student.getFullName() + ", group: "
                + student.getGroup() + ", date of admission: " + student.getDateOfAdmission());
    }
}
