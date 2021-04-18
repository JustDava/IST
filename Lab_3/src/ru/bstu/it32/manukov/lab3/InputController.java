package ru.bstu.it32.manukov.lab3;

import java.util.Scanner;

public class InputController {

    public static int getIntFromConsole(Scanner scanner, String message) {
        String result = "";
        do {
            System.out.println(message);
            String something = scanner.next();
            int length = something.length();
            for (int i = 0; i < length; i++) {
                char character = something.charAt(i);
                if (Character.isDigit(character)) {
                    result += character;
                }
            }
        }while(result.equals(""));
        return Integer.parseInt(result);
    }
}
