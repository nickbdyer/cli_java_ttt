package com.company;

import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertFalse;
import static junit.framework.TestCase.assertTrue;

public class BoardTest {

    private Board board;

    @Before
    public void setUp() throws Exception {
        board = new Board();
    }

    @Test
    public void canShowItsFullCurrentState() {
        assertEquals(Arrays.asList('1', '2', '3', '4', '5', '6', '7', '8', '9'), board.showCells());
    }

    @Test
    public void canShowTheStateOfIndividualCell() {
        assertEquals('1', board.getMarkAt(0));
    }

    @Test
    public void canBeMarkedWithX() {
        board.mark(3, 'X');
        assertEquals('X', board.getMarkAt(3));
    }

    @Test
    public void canBeMarkedWithO() {
        board.mark(1, 'O');
        assertEquals('O', board.getMarkAt(1));
    }

    @Test
    public void knowsIfCellIsEmpty() {
        assertTrue(board.isCellEmpty(1));
    }

    @Test
    public void knowsIfCellIsNotEmpty() {
        board.mark(0, 'X');
        assertFalse(board.isCellEmpty(0));
    }


}