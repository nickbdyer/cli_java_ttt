package uk.nickbdyer.cli_ttt;

import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Scanner;

import static org.hamcrest.CoreMatchers.containsString;
import static org.junit.Assert.assertThat;

public class GameEngineTest {
    
    @Test
    public void canPlayGameThrough() {
        GameEngine engine = new GameEngine();
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        CLI ui = new CLI(new Scanner("1 1 2 4 5 7 n"), new PrintStream(outContent));
        engine.start(ui);
        assertThat(outContent.toString(), containsString("Would you like to play again (y/n)?"));
    }

    @Test
    public void canPlayGameThroughTwice() {
        GameEngine engine = new GameEngine();
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        CLI ui = new CLI(new Scanner("1 1 2 4 5 7 y 1 1 4 2 5 3 n"), new PrintStream(outContent));
        engine.start(ui);
        assertThat(outContent.toString(), containsString("Resetting game board!"));
    }


//    @Test
//    public void gameWillCallDrawGameOverStatement() {
//        makeMultipleMoves(9, "1 2 4 5 8 7 3 6 9");
//        game.endGame(board,ui);
//        assertThat(outContent.toString(), containsString("It's a Draw!"));
//    }
//
//    @Test
//    public void gameWillCallWinGameOverStatement() {
//        makeMultipleMoves(5, "1 2 4 5 7");
//        game.endGame(board,ui);
//        assertThat(outContent.toString(), containsString("X has won!"));
//    }
//
//    @Test
//    public void gameKnowsWhosTurnItIs() {
//        makeMultipleMoves(5, "1 2 4 5 7");
//        assertEquals(X, board.getMarkAt(0));
//        assertEquals(O, board.getMarkAt(1));
//    }
//
//    @Test
//    public void willRejectOutOfBoundsEntry() {
//        makeMultipleMoves(5, "23 1 4 2 5 3");
//        game.endGame(board, ui);
//        assertThat(outContent.toString(), containsString("That is not a valid position"));
//    }
//
//    @Test
//    public void willNotAllowAMarkedCellToBeMarked() {
//        makeMultipleMoves(5, "1 1 4 2 5 3");
//        game.endGame(board, ui);
//        assertThat(outContent.toString(), containsString("That is not a valid position"));
//    }
//
//    @Test
//    public void willShowWinningMessageX() {
//        makeMultipleMoves(5, "1 4 2 5 3");
//        game.endGame(board, ui);
//        assertThat(outContent.toString(), containsString("X has won!"));
//    }
//
//    @Test
//    public void willShowWinningMessageO() {
//        makeMultipleMoves(6, "1 4 2 5 8 6");
//        game.endGame(board, ui);
//        assertThat(outContent.toString(), containsString("O has won!"));
//    }
//
//    private void makeMultipleMoves(int numberOfMoves, String positions) {
//        game = new Game(new PlayerFactory().create(GameType.HvsH));
//        for (int i = 0; i < numberOfMoves; i++) {
//            game.promptTurn(board, ui);
//        }
//    }
}
