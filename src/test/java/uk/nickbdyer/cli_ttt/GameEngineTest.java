package uk.nickbdyer.cli_ttt;

import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Scanner;

import static org.hamcrest.CoreMatchers.containsString;
import static org.junit.Assert.assertThat;

public class GameEngineTest {

    private GameEngine gameEngine;
    private ByteArrayOutputStream outContent;
    private CLI ui;

    @Before
    public void setUp() {
        gameEngine = new GameEngine();
        outContent = new ByteArrayOutputStream();
    }
    
    @Test
    public void canPlayGameThrough() {
        ui = new CLI(new Scanner("1 1 2 4 5 7 n"), new PrintStream(outContent));
        gameEngine.start(ui);
        assertThat(outContent.toString(), containsString("Would you like to play again (y/n)?"));
    }

    @Test
    public void canPlayGameThroughTwice() {
        ui = new CLI(new Scanner("1 1 2 4 5 7 y 1 1 4 2 5 3 n"), new PrintStream(outContent));
        gameEngine.start(ui);
        assertThat(outContent.toString(), containsString("Resetting game board!"));
    }

    @Test
    public void gameWillCallDrawGameOverStatement() {
        ui = new CLI(new Scanner("1 1 2 4 5 8 7 3 6 9 n"), new PrintStream(outContent));
        gameEngine.start(ui);
        assertThat(outContent.toString(), containsString("It's a Draw!"));
    }

    @Test
    public void gameWillCallWinGameOverStatement() {
        ui = new CLI(new Scanner("1 1 2 4 5 7 n"), new PrintStream(outContent));
        gameEngine.start(ui);
        assertThat(outContent.toString(), containsString("X has won!"));
    }

    @Test
    public void willRejectOutOfBoundsEntry() {
        ui = new CLI(new Scanner("1 23 1 4 2 5 3 n"), new PrintStream(outContent));
        gameEngine.start(ui);
        assertThat(outContent.toString(), containsString("That is not a valid position"));
    }

    @Test
    public void willNotAllowAMarkedCellToBeMarked() {
        ui = new CLI(new Scanner("1 1 1 4 2 5 3 n"), new PrintStream(outContent));
        gameEngine.start(ui);
        assertThat(outContent.toString(), containsString("That is not a valid position"));
    }

    @Test
    public void willShowWinningMessageX() {
        ui = new CLI(new Scanner("1 1 4 2 5 3 n"), new PrintStream(outContent));
        gameEngine.start(ui);
        assertThat(outContent.toString(), containsString("X has won!"));
    }

    @Test
    public void willShowWinningMessageO() {
        ui = new CLI(new Scanner("1 1 4 2 5 8 6 n"), new PrintStream(outContent));
        gameEngine.start(ui);
        assertThat(outContent.toString(), containsString("O has won!"));
    }
}
