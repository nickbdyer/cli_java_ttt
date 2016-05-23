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
}
