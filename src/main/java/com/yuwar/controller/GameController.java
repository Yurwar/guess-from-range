package com.yuwar.controller;

import com.yuwar.exception.OutOfRangeException;
import com.yuwar.model.Model;
import com.yuwar.view.View;

public class GameController {
    private static final int LOWER_BORDER = 0;
    private static final int UPPER_BORDER = 100;

    private Model model;
    private View view;
    private ConsoleReader reader;

    public GameController(Model model, View view) {
        this.model = model;
        this.view = view;
        reader = new ConsoleReader();
    }

    public void startGame() {
        char condition;
        boolean winFlag;

        do {
            winFlag = false;
            model.initGame(LOWER_BORDER, UPPER_BORDER);

            view.printMessage(View.USAGE);
            int userNumber;
            while (!winFlag) {
                view.printMessage(View.HISTORY
                        + model.getAttemptsHistory().toString());
                view.printBorders(model.getCurrentLowerBorder(), model.getCurrentUpperBorder());
                view.printMessage(View.ENTER_NUMBER);

                try {
                    userNumber = reader.readNumber();

                    switch (model.compareUserNumber(userNumber)) {
                        case -1: {
                            view.printMessage(View.NUMBER_SMALLER);
                            break;
                        }
                        case 1: {
                            view.printMessage(View.NUMBER_BIGGER);
                            break;
                        }
                        case 0: {
                            view.printVictoryMessage(model.getSecretNumber(),
                                    model.getAttemptsHistoryString(),
                                    model.getAttemptsStatistic());
                            winFlag = true;
                        }
                        default:
                    }
                } catch (NumberFormatException e) {
                    view.printMessage(View.INCORRECT_INPUT);
                } catch (OutOfRangeException e) {
                    view.printMessage(e.getMessage());
                }
            }

            view.printMessage(View.START_AGAIN);
            condition = reader.readChar();
        } while (condition == 'y' || condition == 'Y');
    }
}
