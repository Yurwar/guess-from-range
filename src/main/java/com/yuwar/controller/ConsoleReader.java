package com.yuwar.controller;

import java.util.Scanner;

public class ConsoleReader {
    private final Scanner sc;

    public ConsoleReader() {
        sc = new Scanner(System.in);
    }

    public int readNumber() throws NumberFormatException {
        return Integer.parseInt(sc.nextLine());
    }

    public char readChar() {
        return sc.nextLine().charAt(0);
    }
}
