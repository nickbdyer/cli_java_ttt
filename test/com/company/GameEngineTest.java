package com.company;


import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

public class GameEngineTest {
    @Test
    public void whenThreeXMarksAreAdjacentTheGameAnnouncesXAsTheWinner() {
        AnnouncerSpy announcer = new AnnouncerSpy();
        GameEngine game = new GameEngine(announcer);
        setUpGameWith3XMarksOnTopRow(game);
        assertEquals("X", announcer.announcedWinnerMark());
    }

    @Test
    public void whenThreeOMarksAreAdjacentTheGameAnnouncesOAsTheWinner() {
        AnnouncerSpy announcer = new AnnouncerSpy();
        GameEngine game = new GameEngine(announcer);
        setUpGameWith3OMarksOnTopRow(game);
        assertEquals("O", announcer.announcedWinnerMark());
    }

    private void setUpGameWith3XMarksOnTopRow(GameEngine game) {
        game.putMark(1);
        game.putMark(4);
        game.putMark(2);
        game.putMark(5);
        game.putMark(3);
    }

    private void setUpGameWith3OMarksOnTopRow(GameEngine game) {
        game.putMark(1);
        game.putMark(4);
        game.putMark(2);
        game.putMark(5);
        game.putMark(8);
        game.putMark(6);
    }


    //Rules:
    //A game knows when someone won, draw and announces that

}
