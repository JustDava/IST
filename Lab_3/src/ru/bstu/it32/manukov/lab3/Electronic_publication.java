package ru.bstu.it32.manukov.lab3;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Electronic_publication extends Publication {
    private int num_name;
    private Date date_of_publication;
    private String publication_link;

    private SimpleDateFormat sdf;

    @Override
    public void init(Scanner scanner) throws ParseException {
        System.out.println("Введите номер издания: ");
        num_name = scanner.nextInt();

        System.out.println("Введите ссылку: ");
        publication_link = scanner.next();

        System.out.println("Введите дату публикации: ");
        sdf = new SimpleDateFormat("dd.MM.yyyy");
        date_of_publication = sdf.parse(scanner.next());
    }

    @Override
    public int getName() {
        return num_name;
    }

    @Override
    public Date getDatePublication() {
        return date_of_publication;
    }

    public String getPublication_link() {
        return publication_link;
    }

    @Override
    public String toString() {
        return "Эл. издание{" +
                "Номер издания=" + num_name +
                ", Дата публикации=" + sdf.format(date_of_publication) +
                ", Ссылка='" + publication_link + '\'' +
                '}';
    }
}
