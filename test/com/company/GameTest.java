package com.company;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import static junit.framework.TestCase.assertTrue;

public class GameTest {

    private Game game;
    private DisplaySpy display;
    private BoardSpy board;

    @Before
    public void setUp() {
        game = new Game();
        display = new DisplaySpy();
        board = new BoardSpy();
    }

//    @Test
//    public void canStartItself() {
//        game.run(display, board);
//        assertTrue(display.wasShowBoardCalled);
//        assertTrue(display.wasProcessMarkCalled);
//    }

//    @Test
//    public void knowsWhenTheGameIsOverDueToDraw() {
//        board.setADraw(true);
//        game.run(display, board);
//        assertTrue(game.isOver(board));
//    }
//
//    @Test
//    public void knowsWhenTheGameIsOverDueToWinCondition() {
//        board.setHasAWinner(true);
//        game.run(display, board);
//        assertTrue(game.isOver(board));
//    }

    @Test
    public void gameWillCallDrawGameOverStatement() {
        board.setADraw(true);
        game.run(display, board);
        assertTrue(display.wasAnnounceDrawCalled);
    }

    @Test
    public void gameWillCallWinGameOverStatement() {
        board.setHasAWinner(true);
        game.run(display, board);
        assertTrue(display.wasAnnounceWinCalled);
    }


    //Rules:
    //A game knows when someone won, draw and announces that


}