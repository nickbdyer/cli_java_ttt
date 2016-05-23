package uk.nickbdyer.cli_ttt;

import uk.nickbdyer.tictactoe.Board;
import uk.nickbdyer.tictactoe.Game;
import uk.nickbdyer.tictactoe.players.PlayerFactory;

public class GameEngine {

    private Game game;
    private Board board;

    public void start(UserInterface ui) {
        game = new Game(new PlayerFactory().create(ui.makeGameChoice()));
        board = new Board();
        while (!game.isOver(board)) {
            int position = game.getCurrentPlayer().choosePosition(board);
            game.takeTurn(board, position);
        }
        endGame(board, ui);
    }

    public void endGame(Board board, UserInterface ui) {
        ui.displayBoard(board);
        if (board.isDraw()) {
            ui.displayDraw();
        } else {
            ui.displayWinner(board);
        }
        gameRestart(ui);
    }

    private void gameRestart(UserInterface ui) {
        ui.displayReplayQuery();
        if ("y".equals(ui.getYorN())) {
            ui.displayResetNotice();
            start(ui);
        } else {
            return;
        }
    }

}
