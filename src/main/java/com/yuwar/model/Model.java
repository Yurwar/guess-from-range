package com.yuwar.model;

import com.yuwar.Validator;
import com.yuwar.exception.OutOfRangeException;

import java.util.ArrayList;
import java.util.Random;

public class Model {
    private final int LOWER_BORDER = 0;
    private final int UPPER_BORDER = 100;
    private int currentLowerBorder;
    private int currentUpperBorder;
    private int secretNumber;
    private ArrayList<Integer> attemptsHistory;
    private Random random;

    public Model() {
        currentLowerBorder = LOWER_BORDER;
        currentUpperBorder = UPPER_BORDER;

        attemptsHistory = new ArrayList<>();
        random = new Random();

        secretNumber = randFromRange(LOWER_BORDER, UPPER_BORDER);
    }

    public int compareUserNumber(int userNumber) throws OutOfRangeException {
        Validator.checkNumberInRange(userNumber, currentLowerBorder, currentUpperBorder);

        attemptsHistory.add(userNumber);
        if (userNumber > secretNumber) {
            currentUpperBorder = userNumber;
            return 1;
        } else if (userNumber < secretNumber) {
            currentLowerBorder = userNumber;
            return -1;
        }
        return 0;
    }

    public void restartGame() {
        currentLowerBorder = LOWER_BORDER;
        currentUpperBorder = UPPER_BORDER;
        attemptsHistory.clear();
        secretNumber = randFromRange(currentLowerBorder, currentUpperBorder);
    }

    public int getCurrentLowerBorder() {
        return currentLowerBorder;
    }

    public int getCurrentUpperBorder() {
        return currentUpperBorder;
    }

    public int getSecretNumber() {
        return secretNumber;
    }

    public ArrayList<Integer> getAttemptsHistory() {
        return attemptsHistory;
    }

    private int randFromRange(int lower, int upper) {
        return random.nextInt((upper - lower) + 1) + lower;
    }


}
