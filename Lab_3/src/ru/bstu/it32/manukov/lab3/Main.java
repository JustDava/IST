package ru.bstu.it32.manukov.lab3;

import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws IOException, ParseException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите количество публикаций: ");
        int count = scanner.nextInt();
        List<Publication> publicationsList = new ArrayList<>(count);
        String message =
                """
                   Выберите тип издания:
                    1) Книга;
                    2) Журнал;
                    3) Эл. издание;
                    4) Закончить;
                """;
        initializePublicationsList(scanner, message, publicationsList, count);

        if (publicationsList.size() > 0) {
            Publication new_publication = publicationsList.get(0);
            for (Publication item : publicationsList) {
                if (item.getDatePublication().getTime() < new_publication.getDatePublication().getTime()) {
                    new_publication = item;
                }
            }
            System.out.println("Самая свежая публикация: " + new_publication.toString());
        } else {
            System.out.println("Список пустой");
        }
    }

    private static void initializePublicationsList(Scanner scanner, String message, List<Publication> publicationsList, int count) throws IOException, ParseException {
        int c;
        for (int i = 0; i < count; i++) {
            c = InputController.getIntFromConsole(scanner, message);
            if (c == 4) return;
            while (c < 1 || c > 3);
            publicationsList.add(chooseType(c, scanner));
        }
    }

    static Publication chooseType(int type, Scanner scanner) throws IOException, ParseException {
        switch (type) {
            case 1 -> {
                Book book = new Book();
                book.init(scanner);
                return book;
            }
            case 2 -> {
                Magazine magazine = new Magazine();
                magazine.init(scanner);
                return magazine;
            }
            case 3 -> {
                Electronic_publication electronic_publication = new Electronic_publication();
                electronic_publication.init(scanner);
                return electronic_publication;
            }
            default -> throw new IllegalStateException("Unexpected value: " + type);
        }
    }
}
