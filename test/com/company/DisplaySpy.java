package com.company;

public class DisplaySpy extends Display {

    public boolean wasShowBoardCalled = false;
    public boolean wasProcessMarkCalled = false;
    public boolean wasAnnounceWinCalled = false;
    public boolean wasAnnounceDrawCalled = false;

    public DisplaySpy() {
        super(null, null);
    }

    @Override
    public void showBoard(Board board) {
        wasShowBoardCalled = true;
    }

    @Override
    public void processMark(Board board, char mark) {
        wasProcessMarkCalled = true;
    }

//    @Override
//    public void announceWinner(Board board) {
//        wasAnnounceWinCalled = true;
//    }

    @Override
    public void announceDraw() {
        wasAnnounceDrawCalled = true;
    }
}
