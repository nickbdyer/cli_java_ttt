package com.company;

public class Game {

    public void run(Display display, Board board) {
        Character mark = 'O';
        for (int i=0;i<9;i++) {
            mark = swapMarks(mark);
            display.showBoard(board);
            display.processMark(board, mark);

        }
        display.showBoard(board);
    }

    private Character swapMarks(Character mark) {
        if (mark == 'O'){
            mark = 'X';
        } else {
            mark = 'O';
        }
        return mark;
    }



}
