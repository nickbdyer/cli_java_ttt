package uk.nickbdyer.cli_ttt;

import uk.nickbdyer.tictactoe.Board;
import uk.nickbdyer.tictactoe.Game;
import uk.nickbdyer.tictactoe.players.PlayerFactory;

public class GameEngine {

    private Game game;
    private Board board;

    public void start(CLI ui) {
        game = new Game(new PlayerFactory(ui).create(ui.makeGameChoice()));
        board = new Board();
        while (!game.isOver(board)) {
            ui.displayBoard(board);
            int position = getValidPosition(board, ui);
            game.takeTurn(board, position);
        }
        endGame(board, ui);
    }

    private int getValidPosition(Board board, CLI ui) {
        ui.displayMoveInstructions();
        int position = game.getCurrentPlayer().choosePosition(board);
        while (!board.availableMoves().contains(position)) {
            ui.displayInvalidPosition();
            position = game.getCurrentPlayer().choosePosition(board);
        }
        return position;
    }

    public void endGame(Board board, CLI ui) {
        ui.displayBoard(board);
        if (board.isDraw()) {
            ui.displayDraw();
        } else {
            ui.displayWinner(board);
        }
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
