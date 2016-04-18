package com.company;

import org.junit.Ignore;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class DumbComputerTest {

    @Test
    public void canMarkTheBoard() {
        DumbComputer tron = new DumbComputer();
        Board board = new Board();
        tron.setMark('O');
        tron.markBoard(3, board);
        assertEquals('O', board.getMarkAt(3));
    }

    @Test
    public void canGenerateValidMoveDecisionOnEmptyBoard() {
        DumbComputer hal9000 = new DumbComputer();
        Board board = new Board();
        assertTrue(board.isCellEmpty(hal9000.generateMove(board)));
    }

    @Ignore
    @Test
    public void canGenerateValidMoveDecisionOnPartiallyFullBoard() {
        DumbComputer hal9000 = new DumbComputer();
        Board board = new Board();
        for(int i=1;i<9;i++) {
            board.mark(i, 'X');
        }
        assertTrue(board.isCellEmpty(0));
        assertEquals(0, hal9000.generateMove(board));
    }
}
