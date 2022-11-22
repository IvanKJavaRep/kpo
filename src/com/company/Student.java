package com.company;

public class Student {
    int mark;
    String name;
    String surname;

    public Student(int mark, String name, String surname) {
        this.mark = mark;
        this.name = name;
        this.surname = surname;
    }

    @Override
    public String toString() {
        return "Student{" +
                "mark=" + mark +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                '}';
    }
}
