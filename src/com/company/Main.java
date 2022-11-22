package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) {

        System.out.println("Для первого выбора студента студента введите /r, далее, после выбора студента" +
                "проставьте флаг его присутствия, а потом введите оценку за семинар. Для прекращения программы" +
                "введите слово end. Для вывода списка отвечавших студентов введите /l");
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = null;
        while (s != "end") {
            try {
                System.out.println("Введите ключ для генерации номера студента или /l для вывода" +
                        "списка отвечавших");
                s = br.readLine();
                if (s.equals("/r")) {
                    StudentsAnswer.generateStudents();
                    int num = StudentsAnswer.getRandomStudent();
                    if (StudentsAnswer.amountOfAnswered != 5) {
                        boolean flag = StudentsAnswer.checkIfAnswered(num);
                        while (flag) {
                            num = StudentsAnswer.getRandomStudent();
                            flag = StudentsAnswer.checkIfAnswered(num);
                            System.out.println("a");
                        }
                        System.out.println("Отвечает "+ StudentsAnswer.answered.get(num).name + " " +
                                StudentsAnswer.answered.get(num).surname );
                        System.out.println("Присутсвует ли на паре?");
                        String c = br.readLine();
                        if (c.equals("/y")) {
                            System.out.print("Введите оценку за ответ: ");
                            int mark = Integer.parseInt(br.readLine());
                            StudentsAnswer.amountOfAnswered += 1;
                            StudentsAnswer.answered.get(num).mark = mark;
                        }
                    } else {
                        System.out.println("Все студенты уже отвечали");
                        s = "end";
                    }
                } else if (s.equals("/l")) {
                    StudentsAnswer.printStudents();
                }
            } catch (IOException e) {
                System.out.println("Вы ввели неверный ключ или неправильный диапазон оценок." +
                        "Должно быть от 0 до 10");
            }
        }

    }


}
