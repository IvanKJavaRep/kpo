package com.company;

import javax.lang.model.type.NullType;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class StudentsAnswer {
    static List<Student> answered = new ArrayList<Student>();
    static int amountOfAnswered = 0;

    public static int getRandomStudent() {
        int value = new Random().nextInt(5);
        return value;
    }

    public static boolean checkIfAnswered(int num) {
        if (answered.get(num).mark != -1) {
            return true;
        }
        return false;
    }


    public static void generateStudents() {
        answered.add(new Student(-1, "Ivan", "Ivanov"));
        answered.add(new Student(-1, "Petr", "Petrov"));
        answered.add(new Student(-1, "Alex", "Denisov"));
        answered.add(new Student(-1, "Vlad", "Drozdov"));
        answered.add(new Student(-1, "Nikita", "Orlov"));

    }

    public static void printStudents() {
        for (Student i : answered
        ) {
            if (i.mark != -1) {
                System.out.println(i);
            }
        }
    }

}
