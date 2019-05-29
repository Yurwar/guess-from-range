package com.yuwar;

import com.yuwar.controller.GameController;
import com.yuwar.model.Model;
import com.yuwar.view.View;

public class Main {

    public static void main(String[] args) {
        Model model = new Model();
        View view = new View();
        GameController controller = new GameController(model, view);

        controller.startGame();
    }
}
