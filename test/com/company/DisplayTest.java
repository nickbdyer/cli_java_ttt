package com.company;

import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Arrays;
import java.util.Scanner;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertTrue;
import static org.hamcrest.CoreMatchers.containsString;
import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertThat;

public class DisplayTest {

    private ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private Board board;
    private Display display;
    private Scanner sc;

    @Before
    public void setUp() {
        board = new Board();
    }

    private void createMockUserInput(String input) {
        sc = new Scanner(input);
        display = new Display(sc, new PrintStream(outContent));
    }

    @Test
    public void showBoard() {
        createMockUserInput("");
        display.showBoard(board);
        sc.close();
        assertEquals(" 1 | 2 | 3 \n---|---|---\n 4 | 5 | 6 \n---|---|---\n 7 | 8 | 9 \n", outContent.toString());
    }

    @Test
    public void canProcessMark() {
        BoardSpy board = new BoardSpy();
        createMockUserInput("1");
        display.processMark(board, 'X');
        sc.close();
        assertTrue(board.wasMarkCalled);
    }

    @Test
    public void willRejectNonDigitEntry() {
        createMockUserInput("g 1");
        display.processMark(board, 'X');
        sc.close();
        assertThat(outContent.toString(), containsString("That is not a valid input"));
        assertEquals(Arrays.asList('X', '2', '3', '4', '5', '6', '7', '8', '9'), board.showCells());
    }

    @Test
    public void willRejectOutOfBoundsEntry() {
        createMockUserInput("23 5");
        display.processMark(board, 'X');
        sc.close();
        assertThat(outContent.toString(), containsString("That is not a valid position"));
        assertEquals(Arrays.asList('1', '2', '3', '4', 'X', '6', '7', '8', '9'), board.showCells());
    }

    @Test
    public void willNotAllowAMarkedCellToBeMarked() {
        Board board = new Board();
        createMockUserInput("1 1 2");
        display.processMark(board, 'X');
        display.processMark(board, 'O');
        sc.close();
        assertThat(outContent.toString(), containsString("That cell is already marked, try again"));
        assertEquals(Arrays.asList('X', 'O', '3', '4', '5', '6', '7', '8', '9'), board.showCells());
    }

//    @Test
//    public void willShowWinningMessageX() {
//        Board board = new Board();
//        createMockUserInput("1 4 2 5 3");
//        display.processMark(board, 'X');
//        display.processMark(board, 'O');
//        display.processMark(board, 'X');
//        display.processMark(board, 'O');
//        display.processMark(board, 'X');
//        sc.close();
//        display.announceWinner(board);
//        assertThat(outContent.toString(), containsString("X has won!"));
//    }
//
//    @Test
//    public void willShowWinningMessageO() {
//        Board board = new Board();
//        createMockUserInput("1 4 2 5 3");
//        display.processMark(board, 'O');
//        display.processMark(board, 'X');
//        display.processMark(board, 'O');
//        display.processMark(board, 'X');
//        display.processMark(board, 'O');
//        sc.close();
//        display.announceWinner(board);
//        assertThat(outContent.toString(), containsString("O has won!"));
//    }

    @Test
    public void willShowDrawMessage() {
        createMockUserInput("");
        display.announceDraw();
        assertThat(outContent.toString(), containsString("It's a Draw!"));

    }
}
