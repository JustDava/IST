package ru.bstu.it32.manukov.lab3;

import java.io.IOException;
import java.text.ParseException;
import java.util.Date;
import java.util.Scanner;

public abstract class Publication {

    public abstract void init(Scanner scanner) throws IOException, ParseException;
    public abstract int getName();
    public abstract Date getDatePublication();
}
