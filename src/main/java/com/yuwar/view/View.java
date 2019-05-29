package com.yuwar.view;

import java.util.ArrayList;

public class View {
    public static final String USAGE = "USAGE: Program generates random number " +
            "in range from 0 to 100, " +
            "you should guess the number narrowing the range";
    public static final String HISTORY = "Your attempts history: ";
    public static final String ENTER_NUMBER = "Enter the number: ";
    public static final String INCORRECT_INPUT = "Incorrect input";
    public static final String NUMBER_BIGGER = "Your number is bigger then generated";
    public static final String NUMBER_SMALLER = "Your number is smaller then generated";
    public static final String VICTORY = "Victory! You guess the number";
    public static final String START_AGAIN = "Do you want to start a new game? (y/N):";


    public void printMessage(String msg) {
        System.out.println(msg);
    }

    public void printBorders(int lower, int upper) {
        System.out.println("Secret number between "
                + lower
                + " and "
                + upper);
    }

    public void printVictoryMessage(int secretNumber, ArrayList<Integer> attemptsHistory) {
        System.out.printf("%s %d%n%s%n%s %d%n",
                "Victory! You guess the secret number:", secretNumber,
                "Your attempts history: " + attemptsHistory.toString(),
                "Total amount of attempts is", attemptsHistory.size());
    }
}
