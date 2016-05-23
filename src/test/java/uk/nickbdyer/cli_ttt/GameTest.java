package uk.nickbdyer.cli_ttt;

import uk.nickbdyer.tictactoe.Board;
import uk.nickbdyer.tictactoe.Game;
import uk.nickbdyer.tictactoe.GameType;
import uk.nickbdyer.tictactoe.players.PlayerFactory;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Scanner;

import static uk.nickbdyer.tictactoe.Mark.O;
import static uk.nickbdyer.tictactoe.Mark.X;
import static junit.framework.TestCase.assertTrue;
import static org.hamcrest.CoreMatchers.containsString;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

public class GameTest {

    private Game game;
    private ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private Board board;
    private CLI ui;

    @Before
    public void setUp() {
        board = new Board();
    }

    @Test
    public void knowsWhenTheGameIsOverDueToWin() {
        makeMultipleMoves(5, "1 2 4 5 7");
        assertTrue(game.isOver(board));
    }

    @Test
    public void knowsWhenTheGameIsOverDueToDraw() {
        makeMultipleMoves(9, "1 2 4 5 8 7 3 6 9");
        assertTrue(game.isOver(board));
    }

    @Test
    public void gameWillCallDrawGameOverStatement() {
        makeMultipleMoves(9, "1 2 4 5 8 7 3 6 9");
        game.endGame(board,ui);
        assertThat(outContent.toString(), containsString("It's a Draw!"));
    }

    @Test
    public void gameWillCallWinGameOverStatement() {
        makeMultipleMoves(5, "1 2 4 5 7");
        game.endGame(board,ui);
        assertThat(outContent.toString(), containsString("X has won!"));
    }

    @Test
    public void gameKnowsWhosTurnItIs() {
        makeMultipleMoves(5, "1 2 4 5 7");
        assertEquals(X, board.getMarkAt(0));
        assertEquals(O, board.getMarkAt(1));
    }

    @Test
    public void willRejectOutOfBoundsEntry() {
        makeMultipleMoves(5, "23 1 4 2 5 3");
        game.endGame(board, ui);
        assertThat(outContent.toString(), containsString("That is not a valid position"));
    }

    @Test
    public void willNotAllowAMarkedCellToBeMarked() {
        makeMultipleMoves(5, "1 1 4 2 5 3");
        game.endGame(board, ui);
        assertThat(outContent.toString(), containsString("That is not a valid position"));
    }

    @Test
    public void willShowWinningMessageX() {
        makeMultipleMoves(5, "1 4 2 5 3");
        game.endGame(board, ui);
        assertThat(outContent.toString(), containsString("X has won!"));
    }

    @Test
    public void willShowWinningMessageO() {
        makeMultipleMoves(6, "1 4 2 5 8 6");
        game.endGame(board, ui);
        assertThat(outContent.toString(), containsString("O has won!"));
    }

    private void makeMultipleMoves(int numberOfMoves, String positions) {
        ui = new CLI(new Scanner(positions), new PrintStream(outContent));
        game = new Game(new PlayerFactory().create(GameType.HvsH, ui));
        for (int i = 0; i < numberOfMoves; i++) {
            game.promptTurn(board, ui);
        }
    }
}
