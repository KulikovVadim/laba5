package com.company;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        boolean flag = true;
        while (flag) {
            double summa = 0, counter = 0;

            Scanner in = new Scanner(System.in);
            ArrayList<Double> collection = new ArrayList<>();

            try {
                // Задаем номер элемента, который в дальнейшем нам потребуется для замены на среднее арифметическое
                System.out.println("Введите номер К-го элемента, чтобы потом заменить его на ср. арифм");
                int k = in.nextInt();

                //Создаем список элементов, пока пользователь не напишет "quit"
                System.out.println("Введите первый элемент коллекции: ");
                while (true) {
                    if (!in.hasNext("quit")) {
                        System.out.println("Введите следующий элемент если желаете, либо напишите слово quit");
                        collection.add(in.nextDouble());
                    } else {
                        System.out.println("Похоже на то, что вы ввели слово quit и желаете закончить ввод");
                        break;
                    }
                }
                System.out.println("Исходный список: " + collection);
                System.out.println("Элемент, который вы хотите заменить: " + k);
                //найдем сумму и кол-во элементов в списке, чтобы найти среднее арифметическое
                for (int i = 0; i < k; i++) {
                    counter += 1;
                    summa += collection.get(i);
                }

                //найдем среднее арифметическое необходимых элементов
                double srednee = summa / counter;

                //сделаем замену соответствующего элемента на среднее арифметическое, которое нашли до этого
                collection.set(k - 1, srednee);

                System.out.println("конечный вариант вашей коллекции: " + collection);
                //можно было сделать вариант с округлением, но мне показалось, что так будет удачнее
            } catch (Exception e) {
                System.out.println("Ошибка. Вы сделали что-то не то, попробуйте еще раз");
            }
            System.out.println("Желаете повторить программу? Введите нет, если хотите остановить, либо что-угодно, чтобы продолжить");
            Scanner sc = new Scanner(System.in);
            String answer = sc.nextLine();
            if (answer.equals("нет")|answer.equals("ytn")) {
                flag = false;
                in.close();
                sc.close();
            }
        }
    }
}