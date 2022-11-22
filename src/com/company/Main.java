package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) {

        System.out.println("��� ������� ������ �������� �������� ������� /r, �����, ����� ������ ��������" +
                "���������� ���� ��� �����������, � ����� ������� ������ �� �������. ��� ����������� ���������" +
                "������� ����� end. ��� ������ ������ ���������� ��������� ������� /l");
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = null;
        while (s != "end") {
            try {
                System.out.println("������� ���� ��� ��������� ������ �������� ��� /l ��� ������" +
                        "������ ����������");
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
                        System.out.println("�������� "+ StudentsAnswer.answered.get(num).name + " " +
                                StudentsAnswer.answered.get(num).surname );
                        System.out.println("����������� �� �� ����?");
                        String c = br.readLine();
                        if (c.equals("/y")) {
                            System.out.print("������� ������ �� �����: ");
                            int mark = Integer.parseInt(br.readLine());
                            StudentsAnswer.amountOfAnswered += 1;
                            StudentsAnswer.answered.get(num).mark = mark;
                        }
                    } else {
                        System.out.println("��� �������� ��� ��������");
                        s = "end";
                    }
                } else if (s.equals("/l")) {
                    StudentsAnswer.printStudents();
                }
            } catch (IOException e) {
                System.out.println("�� ����� �������� ���� ��� ������������ �������� ������." +
                        "������ ���� �� 0 �� 10");
            }
        }

    }


}
