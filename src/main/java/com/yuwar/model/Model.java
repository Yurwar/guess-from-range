package com.yuwar.model;

import com.yuwar.Validator;
import com.yuwar.exception.OutOfRangeException;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Model {
    private int currentLowerBorder;
    private int currentUpperBorder;
    private int secretNumber;
    private List<Integer> attemptsHistory;
    private Random random;

    public Model() {
        attemptsHistory = new ArrayList<>();
        random = new Random();
    }

    public void initGame(int lowerBorder, int upperBorder) {
        currentLowerBorder = lowerBorder;
        currentUpperBorder = upperBorder;
        secretNumber = randFromRange(currentLowerBorder, currentUpperBorder);

        attemptsHistory.clear();
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

    public void setSecretNumber(int secretNumber) {
        this.secretNumber = secretNumber;
    }

    public int getAttemptsStatistic() {
        return attemptsHistory.size();
    }

    public String getAttemptsHistoryString() {
        return attemptsHistory.toString();
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

    public List<Integer> getAttemptsHistory() {
        return attemptsHistory;
    }

    private int randFromRange(int lower, int upper) {
        return random.nextInt(((upper - 1) - (lower + 1)) + 1) + lower + 1;
    }


}
