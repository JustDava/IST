package ru.bstu.it32.manukov.lab1;

import jdk.jfr.StackTrace;
import org.apache.log4j.Logger;

import java.io.*;
import java.util.*;

public class Main {

    public static Logger log = Logger.getLogger("APP");

    public static void task_1() {
        System.out.println("Задание №1\n");
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите 3 числа ч/з Enter:");
        boolean flag = false;
        log.warn(flag);
        float a = 0, b = 0, c = 0;
        try {
            a = scanner.nextFloat();
            b = scanner.nextFloat();
            c = scanner.nextFloat();
            log.info("Пользователь ввел: " + a + " " + b + " " + c);
            log.warn(a + " " + b + " " + c);
            System.out.println("\nОтвет:");
            if (b < a & b > c) {
                System.out.println(a *= 2);
                System.out.println(b *= 2);
                System.out.println(c *= 2);
                log.info("b < a & b > c - true");
            } else {
                System.out.println(a = Math.abs(a));
                System.out.println(b = Math.abs(b));
                System.out.println(c = Math.abs(c));
                log.info("b < a & b > c - false");
            }
        } catch (Exception e) {
            flag = true;
            log.error(e);
        }

    }
    public static void task_2()
    {
        System.out.println("\nЗадание №2\n");
        int wDay = 0;
        do {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Введите день недели(целое число от 1 до 7):");
            try {
                wDay = scanner.nextInt();
                log.debug("Введено: " + wDay);
            }
            catch (Exception e) {
                log.error(e);
            }
        }
        while (wDay > 7 || wDay < 1);
            switch (wDay) {
                case 1:
                    System.out.println("Понедельник - 4 пары");
                    log.info("case 1");
                    break;
                case 2:
                    System.out.println("Вторник - 4 пары");
                    log.info("case 2");
                    break;
                case 3:
                    System.out.println("Среда - 3 пары");
                    log.info("case 3");
                    break;
                case 4:
                    System.out.println("Четверг - выходной");
                    log.info("case 4");
                    break;
                case 5:
                    System.out.println("Пятница - выходной");
                    log.info("case 5");
                    break;
                case 6:
                    System.out.println("Суббота - выходной");
                    log.info("case 6");
                    break;
                case 7:
                    System.out.println("Воскресенье - выходной");
                    log.info("case 7");
                    break;
            }
    }
    public static void task_3()
    {
        System.out.println("\nЗадание №3\n");
        System.out.println("Результатами вычислений по\n" +
                "формуле х^2 + х + 17 при 0<х<15 являются простые числа");
        System.out.println("\nЦикл for\n");
        boolean flag = true;
        for (int i = 1; i < 15; i++) {
            int rez = i*i + i + 17;
            if (rez % 2 == 0) {
                log.info("Цикл for - Утверждение не верно!");
                flag = false;
                break;
            }
        }
        if (flag)   log.info("Цикл for - Утверждение верно!");

        System.out.println("\nЦикл while\n");
        flag = true;
        int i = 1;
        while (i<15)
        {
            int rez = i*i + i + 17;
            if (rez % 2 == 0) {
                log.info("Цикл while - Утверждение не верно!");
                flag = false;
                break;
            } else i++;
        }
        if (flag) log.info("Цикл while - Утверждение верно!");

    }
    public static void task_4(){
        System.out.println("\nЗадание №4\n");
        Scanner scanner = new Scanner(System.in);
        int[] array = null;
        System.out.println("Выберите способ заполнения массива: 1 - с файла, 2 - рандомно");
        try {
            int flag = scanner.nextInt();
            if (flag == 1)
            {
                log.info("Заполнение массива с файла");
                File file = new File("D:\\STUDENT\\3_Kurs\\2_semestr\\Инстр. средства ИС\\Lab_1\\input.txt");
                try (BufferedReader in = new BufferedReader(new FileReader(file)))
                {
                    array = (in.lines().mapToInt(Integer::parseInt)).toArray();
                }
                catch (IOException | NumberFormatException e)
                {
                    log.error(e);
                }
            }
            else if (flag == 2)
            {
                log.info("Заполнение массива рандомно");
                System.out.println("Введите размерность массива: ");
                try {
                    int size = scanner.nextInt();
                    array = new int[size];
                    for (int i = 0; i < 3; i++) {
                        array[i] = ((int) (Math.random() * 15) - 10);
                    }
                }
                catch (Exception e) {
                    log.error(e);
                }
            }
        }
        catch (Exception e) {
            StringWriter stack = new StringWriter();
            e.printStackTrace(new PrintWriter(stack));
            log.error("Error: " + stack);
        }
        if (array != null) {
            for (int i = 0; i < array.length; i++) {
                System.out.print("[" + array[i] + "] ");
            }
            int rez = 0;
            System.out.println("\nВведите делитель: ");
            scanner = new Scanner(System.in);
            int k = scanner.nextInt();

            for (int i = 0; i < array.length; i++) {
                if (array[i] % k == 0) {
                    rez += array[i];
                }
            }
            System.out.println("Ответ: " + rez);

        }
    }
    public static void main(String[] args){
        task_1();
        task_2();
        task_3();
        task_4();
    }
}
