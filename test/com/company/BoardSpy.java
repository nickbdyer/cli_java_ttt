package com.company;

public class BoardSpy extends Board {

    public boolean wasMarkCalled = false;
    private boolean hasAWinner;
    private boolean isADraw;

    @Override
    public void mark(int position, char mark) {
        wasMarkCalled = true;
    }

//    @Override
//    public boolean hasAWinner() {
//        return hasAWinner;
//    }

//    @Override
//    public boolean isADraw() {
//        return isADraw;
//    }

    public void setADraw(boolean isADraw) {
        this.isADraw = isADraw;
    }

    public void setHasAWinner(boolean hasAWinner) {
        this.hasAWinner = hasAWinner;
    }
}
