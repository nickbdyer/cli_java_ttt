package com.company;

public class GameEngine {
    public void start(UserInterface ui) {
        Game game = new Game(new PlayerFactory().create(ui.makeGameChoice()));
        Board board = new Board();
        while (!game.isOver(board)) {
            game.promptTurn(board, ui);
        }
        game.endGame(board, ui);
        gameRestart(ui);
    }

    private void gameRestart(UserInterface ui) {
        ui.displayReplayQuery();
        if (ui.getYorN().equals("y")) {
            ui.displayResetNotice();
            start(ui);
        } else {
            System.out.println("Goodbye");
        }
    }

}
