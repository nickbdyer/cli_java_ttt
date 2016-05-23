package uk.nickbdyer.tictactoe;

import uk.nickbdyer.tictactoe.players.PlayerFactory;

public class GameEngine {

    private Game game;
    private Board board;

    public void start(UserInterface ui) {
        game = new Game(new PlayerFactory().create(ui.makeGameChoice()));
        board = new Board();
        while (!game.isOver(board)) {
            game.takeTurn(board, ui);
        }
        endGame(ui);
    }

    private void endGame(UserInterface ui) {
        game.endGame(board, ui);
        gameRestart(ui);
    }

    private void gameRestart(CLI ui) {
        ui.displayReplayQuery();
        if ("y".equals(ui.getYorN())) {
            ui.displayResetNotice();
            start(ui);
        } else {
            return;
        }
    }

}
